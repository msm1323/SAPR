package preprcssr;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        PREPCSSR preprcssr = new PREPCSSR();
        JFrame frameMain = new JFrame("Preprocessor");
        frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMain.setContentPane(preprcssr.JPanelMain);
        frameMain.setSize(1500,900);
        frameMain.setLocationRelativeTo(null);
        frameMain.setResizable(false);
        frameMain.setVisible(true);

        preprcssr.run();

    }
}