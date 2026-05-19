import javax.swing.SwingUtilities;

import vue.MainFrame;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
