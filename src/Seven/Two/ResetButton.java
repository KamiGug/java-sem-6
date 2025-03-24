public class ResetButton extends Button {
    public ResetButton() {
        super("Reset");
        this.setCallback(e -> {
            Klient.resetConnection();
        });
    }
}
