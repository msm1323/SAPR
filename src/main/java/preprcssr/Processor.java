package preprcssr;

import javax.swing.*;
import java.awt.*;
import java.lang.*;

import static preprcssr.PREPCSSR.project;

public class Processor {

    protected double[][] A;
    protected static double[] b;
    protected static double[] d;

    Processor(){
        A = new double[project.bars.size()+1][project.bars.size()+1];
        b = new double[project.bars.size()+1];

        for(int i=0; i<project.bars.size(); i++){
            Project.Bar el = project.bars.get(i);
            double a = (el.E*Math.pow(10, el.es[2])*el.A*Math.pow(10, el.es[1]))/el.L*Math.pow(10, el.es[0]);
            A[i][i] += a;
            A[i][i+1] += -a;
            A[i+1][i] += -a;
            A[i+1][i+1] += a;
        }

        if(project.loads.size()!=0){
            for(Project.Load a: project.loads){
                if(a.loadType){
                    b[a.number-1]+=a.value;
                }else{
                    b[a.number-1]+= (a.value*project.bars.get(a.number-1).L)/2;
                    b[a.number]+= (a.value*project.bars.get(a.number-1).L)/2;
                }
            }
        }else{
            for(double a: b){
                a = 0;
            }
        }

        if(project.sealL){
            b[0]=0;
            A[0][0] = 1;
            for(int i=1; i<=project.bars.size(); i++){
                A[0][i] = 0;
                A[i][0] = 0;
            }
        }
        if(project.sealR){
            b[project.bars.size()]=0;
            for(int i=1; i<=project.bars.size(); i++){
                A[project.bars.size()][i] = 0;
                A[i][project.bars.size()] = 0;
            }
            A[project.bars.size()][project.bars.size()] = 1;
        }

        SquareRootMethod solve = new SquareRootMethod(A, b);
        d = solve.run();

        PCSSR pcssr = new PCSSR();
        JFrame frameProcessor = new JFrame("preprcssr Processor");

        DefaultListModel listModel = new DefaultListModel();
        pcssr.listForD.setModel(listModel);
        for(int i=0; i<d.length; i++){
            listModel.addElement("Δ"+(i+1)+" = "+d[i]+"    \n");
        }

        frameProcessor.setContentPane(pcssr.mainPanel);
        pcssr.listForD.setVisibleRowCount(22);
        frameProcessor.setSize(250,500);
        frameProcessor.setLocationRelativeTo(null);
        frameProcessor.setResizable(false);
        frameProcessor.setVisible(true);

    }

}
