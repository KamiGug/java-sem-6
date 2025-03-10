import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileHelper {
    public static void save(
            String filePath,
            String encoding,
            String content)
            throws FileNotFoundException,
            UnsupportedEncodingException,
            IOException {
        if (filePath == null || encoding == null) {
            throw new IllegalArgumentException("Missing arguments for saving!");
        }
        FileOutputStream file = new FileOutputStream(filePath);
        OutputStreamWriter output = new OutputStreamWriter(file, encoding);
        output.write(content);
        output.close();
        file.close();
    }

    public static String read(String filePath, String encoding) throws UnsupportedEncodingException, IOException {
        if (filePath == null || encoding == null) {
            throw new IllegalArgumentException("Missing arguments for reading file!");
        }
        byte[] rawFile = Files.readAllBytes(Paths.get(filePath));
        return new String(rawFile, encoding);
    }

    public static String chooseFile(JFrame frame) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int val = fc.showDialog(frame, "Choose");
        if (val == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        }
        // it's safe to assume that an empty string will never be meant
        // to be used as file path and i don't feel like making even more classes
        return "";
    }

}
