package preprcssr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCSSR {
    protected JPanel mainPanel;
    private JButton постпроцессорButton;
    protected JList listForD;
    private JScrollPane scrollPane;

    PCSSR(){
        постпроцессорButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Postprocessor postprocessor = new Postprocessor();
            }
        });
    }

}
