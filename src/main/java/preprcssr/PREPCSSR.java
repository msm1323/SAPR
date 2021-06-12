package preprcssr;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PREPCSSR {
    protected JPanel JPanelMain;
    private JComboBox NumberOfNodeCB;
    private JTextField aAddTF;
    private JTextField eAddTF;
    private JTextField lAddTF;
    private JTextField σAddTF;
    private JTextField AmountOfBarsTF;
    private JButton buttonAddBar;
    private JComboBox NumberOfBarCB;
    private JComboBox NumberOfBarChangeCB;
    private JTextField aChangeTF;
    private JTextField eChangeTF;
    private JTextField lChangeTF;
    private JTextField σChangeTF;
    private JPanel canvasPanel;
    private JPanel leftPanel;
    private JPanel upPanel;
    private JButton открытьПроектButton;
    private JPanel downPanel;
    private JButton сохранитьButton;
    private JTabbedPane tabbedPaneMain;
    private JPanel JPanelAdd;
    private JButton qButtonAdd;
    private JButton fButtonAdd;
    private JTextField qAddTF;
    private JTextField fAddTF;
    private JPanel JPanelChange;
    private JTextField qTextField;
    private JButton buttonApplyChanges;
    private JButton buttonDeleteBar;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField fTextField;
    private JComboBox NumberOfNodeChngCB;
    private JComboBox NumberOfBarChngCB;
    private JButton леваяButton;
    private JButton праваяButton;
    private JButton процессорButton;
    private JButton справкаButton;
    private JTextField aTextField1;
    private JTextField eTextField1;
    private JTextField lTextField1;
    private JTextField σTextField2;
    private JTextField qTextField1;
    private JTextField fTextField1;
    private JButton сбросButton;
    private JTextField lAddTFe;
    private JTextField aAddTFe;
    private JTextField eAddTFe;
    private JTextField σAddTFe;
    private JTextField lTextField;
    private JTextField aTextField;
    private JTextField eTextField;
    private JTextField σTextField;
    private JButton qApplyButton;
    private JButton fApplyButton;
    private JTextField lChangeTFe;
    private JTextField aChangeTFe;
    private JTextField eChangeTFe;
    private JTextField σChangeTFe;
    private JButton qDeleteButton;
    private JButton fDeleteButton;
    private JButton постпроцессорButton;

    protected static Project project;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        canvasPanel = new MyCanvas();
    }

    private void fillCB(){
        NumberOfBarCB.removeAllItems();
        NumberOfBarChangeCB.removeAllItems();
        NumberOfBarChngCB.removeAllItems();

        NumberOfNodeCB.removeAllItems();
        NumberOfNodeChngCB.removeAllItems();
        for(int i =0; i<project.bars.size(); i++){
            NumberOfBarCB.addItem(Integer.toString(i+1));
            NumberOfBarChangeCB.addItem(Integer.toString(i+1));
            NumberOfBarChngCB.addItem(Integer.toString(i + 1));

            NumberOfNodeCB.addItem(Integer.toString(i+1));
            NumberOfNodeChngCB.addItem(Integer.toString(i+1));
            if(i==project.bars.size()-1){
                NumberOfNodeCB.addItem(Integer.toString(i+2));
                NumberOfNodeChngCB.addItem(Integer.toString(i+2));
            }
        }
    }

    private int adde(JTextField textField){
        int e=0;
        if(textField.getText().length()>0) {
            e = Integer.valueOf(textField.getText());
        }
        return e;
    }

    public PREPCSSR() {

        project = new Project();
        project.sealL = true;
        project.sealR = true;

        aAddTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(aAddTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });

        eAddTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(eAddTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });
        lAddTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(lAddTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });

        lAddTFe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( ((ch<'0')||(ch>'9')||((ch=='0')&&(lAddTFe.getText().length()==0)))&&(ch!='-') ){
                    e.consume();
                }
                if(ch=='-'){
                    int j=0;
                    for(int i=0; i<lAddTFe.getText().length(); i++){
                        if(lAddTFe.getText().charAt(i)=='-'){
                            j++;
                        }
                    }
                    if( (j>0) ){
                        e.consume();
                    }
                    if(lAddTFe.getText().length()>0){
                        if (lAddTFe.getText().charAt(0) != '-') {
                            e.consume();
                        }
                    }
                }
            }
        });
        σAddTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(σAddTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });
        AmountOfBarsTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(AmountOfBarsTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });

        aChangeTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(aChangeTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });
        eChangeTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(eChangeTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });
        lChangeTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(lChangeTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });
        σChangeTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( (ch<'0')||(ch>'9')||((ch=='0')&&(σChangeTF.getText().length()==0)) ){
                    e.consume();
                }
            }
        });

        qAddTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if(project.bars.size()!=0) {
                    if (((ch < '0') || (ch > '9') || ((ch == '0') && (qAddTF.getText().length() == 0))) && (ch != '-')) {
                        e.consume();
                    }
                    if (ch == '-') {
                        int j = 0;
                        for (int i = 0; i < qAddTF.getText().length(); i++) {
                            if (qAddTF.getText().charAt(i) == '-') {
                                j++;
                            }
                        }
                        if ((j > 0)) {
                            e.consume();
                        }
                        if (qAddTF.getText().length() > 0) {
                            if (qAddTF.getText().charAt(0) != '-') {
                                e.consume();
                            }
                        }
                    }
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Давайте всё-таки не будем задавать нагрузку\nв пространстве отдельно от стержня.");
                    e.consume();
                }
            }
        });

        fAddTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if(project.bars.size()!=0) {
                    if (((ch < '0') || (ch > '9') || ((ch == '0') && (fAddTF.getText().length() == 0))) && (ch != '-')) {
                        e.consume();
                    }
                    if (ch == '-') {
                        int j = 0;
                        for (int i = 0; i < fAddTF.getText().length(); i++) {
                            if (fAddTF.getText().charAt(i) == '-') {
                                j++;
                            }
                        }
                        if ((j > 0)) {
                            e.consume();
                        }
                        if (fAddTF.getText().length() > 0) {
                            if (fAddTF.getText().charAt(0) != '-') {
                                e.consume();
                            }
                        }
                    }
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Давайте всё-таки не будем задавать нагрузку\nв пространстве отдельно от стержня.");
                    e.consume();
                }
            }
        });

        qButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( qAddTF.getText().isEmpty() ){
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Незаполненное поле!");
                }else{
                    int value = Integer.valueOf(qAddTF.getText());
                    int numB = NumberOfBarCB.getSelectedIndex()+1;
                    project.bars.get(numB-1).q = value;
                    if(valuesLoads(false, numB, value, -1)){
                        project.createLoad(false , value, numB);
                    }
                }
                Graphics g = canvasPanel.getGraphics();
                canvasPanel.paint(g);
            }
        });



        fButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( fAddTF.getText().isEmpty() ){
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Незаполненное поле!");
                }else{
                    int value = Integer.valueOf(fAddTF.getText());
                    int numN = NumberOfNodeCB.getSelectedIndex()+1;
                    if(valuesLoads(true, numN, value, -1)){
                        project.createLoad(true , value, numN);
                    }
                    System.out.println("NumberOfNodeCB.getSelectedIndex() = "+NumberOfNodeCB.getSelectedIndex());
                }
                Graphics g = canvasPanel.getGraphics();
                canvasPanel.paint(g);
            }
        });

        buttonAddBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if( aAddTF.getText().isEmpty()||eAddTF.getText().isEmpty()||lAddTF.getText().isEmpty()||σAddTF.getText().isEmpty()) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Незаполненные поля!");
                }else {
                    int[] es = new int[4];
                    es[0] = adde(lAddTFe);
                    es[1] = adde(aAddTFe);
                    es[2] = adde(eAddTFe);
                    es[3] = adde(σAddTFe);
                    double a = Double.valueOf(aAddTF.getText());
                    double ee = Double.valueOf(eAddTF.getText());
                    double l = Double.valueOf(lAddTF.getText());
                    double o = Double.valueOf(σAddTF.getText());

                    if ((project.bars.size() + Integer.valueOf(AmountOfBarsTF.getText())) > 40) {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Создание конструкции из более чем 40ка стержней невозможно!");
                    } else {

                        for (int i = 0; i < Integer.valueOf(AmountOfBarsTF.getText()); i++) {
                            project.createBar(l, a, ee, o, es);
                        }
                        fillCB();
                        Graphics g = canvasPanel.getGraphics();
                        canvasPanel.paint(g);
                    }
                }
            }
        });

        леваяButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( project.sealL && project.sealR ){
                    project.sealL = false;
                    Graphics g = canvasPanel.getGraphics();
                    canvasPanel.paint(g);
                }else {
                    if ( (!project.sealL)&&project.sealR ) {
                        project.sealL = true;
                        Graphics g = canvasPanel.getGraphics();
                        canvasPanel.paint(g);
                    }else {
                        if (project.sealL && (!project.sealR)) {
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(frame, "Конструкция должна иметь хотя бы одну заделку!");
                        }
                    }
                }
            }
        });
        праваяButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( project.sealL && project.sealR ){
                    project.sealR = false;
                    Graphics g = canvasPanel.getGraphics();
                    canvasPanel.paint(g);
                }else {
                    if ( project.sealL&&(!project.sealR) ) {
                        project.sealR = true;
                        Graphics g = canvasPanel.getGraphics();
                        canvasPanel.paint(g);
                    }else {
                        if ( (!project.sealL)&&project.sealR ) {
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(frame, "Конструкция должна иметь хотя бы одну заделку!");
                        }
                    }
                }
            }
        });

        сохранитьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(project.bars.size()!=0){
                    String strFile = "preprcssr PROJECT\r\nBars:\r\n"+project.bars.size()+"\r\nA\tE\tL\tσ\tes[]\ttypeA\ttypeL\r\n";
                    for(Project.Bar i: project.bars){
                        strFile = strFile+i.L+"\r\n"+i.A+"\r\n"+i.E+"\r\n"+i.σ+"\r\n"+i.es[0]+"\r\n"+i.es[1]+"\r\n"+i.es[2]+"\r\n"+i.es[3]+"\r\n"+i.typeA+"\r\n"+i.typeL+"\r\n";
                    }
                    strFile+="Loads:\r\n"+project.loads.size()+"\r\ntype\tvalue\tnum S/N\r\n";
                    for(Project.Load i: project.loads){
                        strFile = strFile+i.loadType+"\r\n"+i.value+"\r\n"+i.number+"\r\n";
                    }
                    strFile+="Seals:\r\nLeft\r\n";
                    if(project.sealL){
                        strFile+="true\r\n";
                    }else{
                        strFile+="false\r\n";
                    }
                    strFile+="Right\r\n";
                    if(project.sealR){
                        strFile+="true\r\n";
                    }else{
                        strFile+="false\r\n";
                    }

                    MyFrame myFrame = new MyFrame();
                    myFrame.save(strFile);
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Конструкция должна иметь хотя бы один стержень!");
                }
            }
        });

        процессорButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(project.bars.size()!=0) {
                    Processor processor = new Processor();
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Конструкция должна иметь хотя бы один стержень!");
                }
            }
        });

        сбросButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(project.bars.size()!=0){
                    project.loads.clear();
                    project.bars.clear();
                    Graphics g = canvasPanel.getGraphics();
                    canvasPanel.paint(g);
                }
            }
        });

        открытьПроектButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame myFrame = new MyFrame();
                myFrame.open();
            }
        });

        NumberOfBarChangeCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                for (int i = 0; i < project.bars.size(); i++) {
                    if (e.getItem().equals(String.valueOf(i+1))) {
                        Project.Bar a = project.bars.get(i);
                        aChangeTF.setText(String.valueOf((int)a.A));
                        lChangeTF.setText(String.valueOf((int)a.L));
                        eChangeTF.setText(String.valueOf((int)a.E));
                        σChangeTF.setText(String.valueOf((int)a.σ));
                        aChangeTFe.setText(String.valueOf(a.es[1]));
                        lChangeTFe.setText(String.valueOf(a.es[0]));
                        eChangeTFe.setText(String.valueOf(a.es[2]));
                        σChangeTFe.setText(String.valueOf(a.es[3]));
                    }
                }
            }
        });

        NumberOfBarChngCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                for (int i = 0; i < project.bars.size(); i++) {
                    if (e.getItem().equals(String.valueOf(i+1))) {
                        textField3.setText(String.valueOf((int)project.bars.get(i).q));
                        break;
                    }
                }
            }
        });

        NumberOfNodeChngCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                for (int i = 0; i < project.loads.size(); i++) {
                    if ( e.getItem().equals(String.valueOf(project.loads.get(i).number))) {
                        textField4.setText(String.valueOf((int)project.loads.get(i).value));
                        break;
                    }
                }
            }
        });

        buttonApplyChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( aAddTF.getText().isEmpty()||eAddTF.getText().isEmpty()||lAddTF.getText().isEmpty()||σAddTF.getText().isEmpty()) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Незаполненные поля!");
                }else {
                    for (int i = 0; i < project.bars.size(); i++) {
                        if( (i+1)== Integer.valueOf((String)NumberOfBarChangeCB.getSelectedItem()) ) {
                            project.bars.get(i).A = Double.parseDouble(aChangeTF.getText());
                            project.bars.get(i).L = Double.parseDouble(lChangeTF.getText());
                            project.bars.get(i).σ = Double.parseDouble(σChangeTF.getText());
                            project.bars.get(i).E = Double.parseDouble(eChangeTF.getText());
                        }
                    }
                }
                Graphics g = canvasPanel.getGraphics();
                canvasPanel.paint(g);
            }
        });

        buttonDeleteBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item = Integer.valueOf((String)NumberOfBarChangeCB.getSelectedItem());

                for(int i=0; i<project.loads.size(); i++){
                    Project.Load load = project.loads.get(i);
                    if(load.loadType&&(load.number>=(item+1))){
                        load.number--;
                    }

                    if((!load.loadType)&&(load.number==item)){
                        project.loads.remove(i);
                        i--;
                    }
                    if((!load.loadType)&&(load.number>=item)){
                        load.number--;
                    }
                }
                for(int i=0; i<project.loads.size(); i++){
                    Project.Load a = project.loads.get(i);
                    if(!valuesLoads(a.loadType, a.number, a.value, i)){
                        project.loads.remove(i);
                    }
                }

                project.bars.remove(item);
                buttonApplyChanges.getActionListeners();
                fillCB();
                Graphics g = canvasPanel.getGraphics();
                canvasPanel.paint(g);
            }
        });

        aAddTFe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( ((ch<'0')||(ch>'9')||((ch=='0')&&(aAddTFe.getText().length()==0)))&&(ch!='-') ){
                    e.consume();
                }
                if(ch=='-'){
                    int j=0;
                    for(int i=0; i<aAddTFe.getText().length(); i++){
                        if(aAddTFe.getText().charAt(i)=='-'){
                            j++;
                        }
                    }
                    if( (j>0) ){
                        e.consume();
                    }
                    if(aAddTFe.getText().length()>0){
                        if (aAddTFe.getText().charAt(0) != '-') {
                            e.consume();
                        }
                    }
                }
            }
        });
        eAddTFe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( ((ch<'0')||(ch>'9')||((ch=='0')&&(eAddTFe.getText().length()==0)))&&(ch!='-') ){
                    e.consume();
                }
                if(ch=='-'){
                    int j=0;
                    for(int i=0; i<eAddTFe.getText().length(); i++){
                        if(eAddTFe.getText().charAt(i)=='-'){
                            j++;
                        }
                    }
                    if( (j>0) ){
                        e.consume();
                    }
                    if(eAddTFe.getText().length()>0){
                        if (eAddTFe.getText().charAt(0) != '-') {
                            e.consume();
                        }
                    }
                }
            }
        });
        σAddTFe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                if( ((ch<'0')||(ch>'9')||((ch=='0')&&(σAddTFe.getText().length()==0)))&&(ch!='-') ){
                    e.consume();
                }
                if(ch=='-'){
                    int j=0;
                    for(int i=0; i<σAddTFe.getText().length(); i++){
                        if(σAddTFe.getText().charAt(i)=='-'){
                            j++;
                        }
                    }
                    if( (j>0) ){
                        e.consume();
                    }
                    if(σAddTFe.getText().length()>0){
                        if (σAddTFe.getText().charAt(0) != '-') {
                            e.consume();
                        }
                    }
                }
            }
        });

        qDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item = Integer.valueOf((String)NumberOfBarChngCB.getSelectedItem());
                project.bars.get(item-1).q = 0;
                for(int i=0; i<project.loads.size(); i++) {
                    Project.Load load = project.loads.get(i);
                    if ( (!load.loadType)&&(load.number == item) ) {
                        project.loads.remove(i);
                        break;
                    }
                }
                Graphics g = canvasPanel.getGraphics();
                canvasPanel.paint(g);
            }
        });

        fDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item = Integer.valueOf((String)NumberOfNodeChngCB.getSelectedItem());
                for(int i=0; i<project.loads.size(); i++) {
                    Project.Load load = project.loads.get(i);
                    if ( load.loadType&&(load.number == item) ) {
                        project.loads.remove(i);
                        break;
                    }
                }
                Graphics g = canvasPanel.getGraphics();
                canvasPanel.paint(g);
            }
        });
        qApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item = Integer.valueOf((String)NumberOfBarChngCB.getSelectedItem());
                project.bars.get(item-1).q = Double.parseDouble(textField3.getText());
                for(int i=0; i<project.loads.size(); i++) {
                    Project.Load load = project.loads.get(i);
                    if ( (!load.loadType)&&(load.number == item) ) {
                        load.value = Double.parseDouble(textField3.getText());
                        break;
                    }
                }
                Graphics g = canvasPanel.getGraphics();
                canvasPanel.paint(g);
            }
        });
        fApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item = Integer.valueOf((String)NumberOfNodeChngCB.getSelectedItem());
                for(int i=0; i<project.loads.size(); i++) {
                    Project.Load load = project.loads.get(i);
                    if ( load.loadType&&(load.number == item) ) {
                        load.value = Double.parseDouble(textField4.getText());
                        break;
                    }
                }
                Graphics g = canvasPanel.getGraphics();
                canvasPanel.paint(g);
            }
        });
    }

    private boolean valuesLoads(boolean type, int numB, double value, int index){
        for(int i=0; i<project.loads.size(); i++){
            Project.Load a = project.loads.get(i);
            if( (a.number==numB)&&(a.loadType==type)&&(i!=index) ){
                a.value += value;
                if(a.value==0){
                    project.loads.remove(i);
                }
                return false;
            }
        }
        return true;
    }

    public void run(){
        AmountOfBarsTF.setText("1");
    }

    public class MyFrame extends JFrame{

        private JFrame parentFrame;
        private JFileChooser dialog;

        MyFrame()
        {
            parentFrame = new JFrame();
            dialog = new JFileChooser();

        }

        private void open(){

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException E) {
                E.printStackTrace();
            }

            setBounds(0,0,500,500); //?
            dialog.setDialogTitle("Open");
            JFileChooser dialog = new JFileChooser();
            int retrival = dialog.showOpenDialog(parentFrame);
            File openFile;

            Scanner input = null;
            dialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text file", "txt");
            dialog.setFileFilter(fnef);

            if(retrival==JFileChooser.APPROVE_OPTION){
                try{
                    openFile = dialog.getSelectedFile();
                    input = new Scanner(openFile);
                    project.bars.clear();
                    project.loads.clear();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException E) {
                E.printStackTrace();
            }

            if(project.bars.size()!=0) {
                project.bars.clear();
                project.loads.clear();
            }

            String str = new String();
            for(int i=0;i<2;i++) {
                 str = input.nextLine();
            }
            double size = Integer.parseInt(input.nextLine());
            str = input.nextLine();
            for(int i=0; i<size;i++ ){
                System.out.println("bar: "+str);
                double[] n = new double[10];
                for(int j=0; j<n.length; j++){
                    n[j] = Double.parseDouble(input.nextLine());
                }
                int[] es = new int[4];
                for(int j=4; j<8; j++){
                    es[j-4] = (int)(n[j]);
                }
                project.createBar(n[0], n[1], n[2], n[3], es);
                project.bars.get(i).typeA = (int)n[8];
                project.bars.get(i).typeL = (int)n[9];
            }
            str = input.nextLine();
            size = Integer.parseInt(input.nextLine());
            str = input.nextLine();
            for(int i=0; i<size; i++ ){
                System.out.println("load: "+str);
                boolean boolType = Boolean.parseBoolean(input.nextLine());
                double value = Double.parseDouble(input.nextLine());
                int number = Integer.parseInt(input.nextLine());
                if(!boolType) {
                    project.bars.get(number - 1).q = value;
                }
                project.createLoad(boolType, value, number);
            }
            str = input.nextLine();
            str = input.nextLine();
            project.sealL = Boolean.parseBoolean(input.nextLine());
            str = input.nextLine();
            project.sealR = Boolean.parseBoolean(input.nextLine());

            fillCB();
            Graphics g = canvasPanel.getGraphics();
            canvasPanel.paint(g);
        }

        private void save(String strFile){

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException E) {
                E.printStackTrace();
            }

            setBounds(0,0,500,500);
            dialog.setDialogTitle("Save");
            JFileChooser dialog = new JFileChooser();
            int userSelection = dialog.showSaveDialog(parentFrame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = dialog.getSelectedFile();
                File file = new File(fileToSave.getAbsolutePath()+".txt");
                /*file.setExecutable(true); //IT'S DOESN'T WORK! SHIEEET
                file.setReadable(true);
                file.setWritable(false);*/

                try(FileWriter writer = new FileWriter(file))
                {
                    writer.write(strFile);
                    writer.flush();
                }
                catch(IOException ex){
                    System.out.println("All is not good");
                    System.out.println(ex.getMessage());
                }

                try
                {
                    boolean created = file.createNewFile();
                    if(created)
                        System.out.println("File has been created");
                }
                catch(IOException ex){
                    System.out.println("File HAS NOT BEEN created");
                    System.out.println(ex.getMessage());
                }
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());

                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException E) {
                    E.printStackTrace();
                }

            }

        }

    }

}
