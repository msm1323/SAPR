package preprcssr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.*;

import static preprcssr.PREPCSSR.project;

public class POSTPCSSR {
    protected static boolean nxJChB;
    protected static boolean uxJChB;
    protected static boolean σJChB;
    protected JPanel jPanelPost;
    protected JPanel postCanvas;
    private JButton nxButton;
    private JButton uxButton;
    private JButton σButton;
    private JTextField textField1;
    private JButton применитьButton;
    protected JComboBox comboBox1;
    protected JList postList;
    protected JScrollPane scrollPane;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        postCanvas = new PostCanvas();
    }

    POSTPCSSR(){
        nxJChB = false;
        uxJChB = false;
        σJChB = false;



        nxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nxJChB = true;
                uxJChB = false;
                σJChB = false;
                Graphics g = postCanvas.getGraphics();
                postCanvas.paint(g);
            }
        });
        uxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uxJChB = true;
                nxJChB = false;
                σJChB = false;
                Graphics g = postCanvas.getGraphics();
                postCanvas.paint(g);
            }
        });
        σButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                σJChB = true;
                uxJChB = false;
                nxJChB = false;
                Graphics g = postCanvas.getGraphics();
                postCanvas.paint(g);
            }
        });
        применитьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = Integer.valueOf((String)comboBox1.getSelectedItem());
                Project.Bar a = project.bars.get(i-1);
                JTable table = new JTable();//1
                Render render = new Render(a.σ);
                System.out.println(a.σ);

                int n = Integer.valueOf(textField1.getText());
                Object[] headers = {"length", "Nx", "Ux", "σx"};
                Object[][] data = new Object[n+1][4];

                double k = a.L/n;

                for(int j=0; j<=n; j++){
                    data[j][0] = j*k;
                    data[j][1] = Postprocessor.getNx(a.E, a.A, a.L, a.q, i-1, j*k);
                    data[j][2] = Postprocessor.getUx(a.E, a.A, a.L, a.q, i-1, j*k);
                    data[j][3] = Postprocessor.getNx(a.E, a.A, a.L, a.q, i-1, j*k)/a.A;
                }

                table.setModel(new DefaultTableModel(data, headers));
                for(int j=0; j<4; j++){
                    table.getColumnModel().getColumn(j).setCellRenderer(render);
                }

                JScrollPane jScrollPane = new JScrollPane(table);
                table.setPreferredScrollableViewportSize(new Dimension(640, 400));

                JFrame tableFrame = new JFrame("Table");
                tableFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Dimension dimension = new Dimension(640, 400);
                tableFrame.setMinimumSize(dimension);
                tableFrame.setSize(dimension);
                tableFrame.getContentPane().add(jScrollPane, BorderLayout.EAST);
                tableFrame.setLocationRelativeTo(null);
                tableFrame.setResizable(false);
                tableFrame.setVisible(true);

            }
        });
    }

}
