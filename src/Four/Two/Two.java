import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Two {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Missing argument!");
            System.exit(100);
        }
        boolean isGzip = true;
        ArrayList<String> files = new ArrayList<String>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-u")) {
                isGzip = false;
                continue;
            } else if (args[i].startsWith("-")) {
                continue;
            }
            files.add(args[i]);
        }
        if (isGzip) {
            FileInputStream inputStream;
            GZIPOutputStream out;
            for (String file : files) {
                out = new GZIPOutputStream(new FileOutputStream(file + ".gz"));
                inputStream = new FileInputStream(file);
                out.write(inputStream.readAllBytes());
                out.close();
                inputStream.close();
            }
        } else {
            GZIPInputStream input;
            FileOutputStream output;
            for (String file : files) {
                input = new GZIPInputStream(new FileInputStream(file));
                if (file.contains(".gz")) {
                    file = file.replace(".gz", "");
                } else {
                    file = file + "-new";
                }
                output = new FileOutputStream(file);
                output.write(input.readAllBytes());
            }
        }
    }

}
