package preprcssr;

import javax.swing.*;

import static preprcssr.PREPCSSR.project;

public class Postprocessor {

    protected static double[] axis;
    protected static double[] ph;
    protected  static POSTPCSSR postpcssr;

    protected static double getNx(double E, double A, double L, double q, int i, double x){
        return (E * A / L) * (Processor.d[i+1] - Processor.d[i]) + L * q / 2 - q * x;
    }

    protected static double getUx(double E, double A, double L, double q, int i, double x){
        return Processor.d[i]+( (Processor.d[i+1]-Processor.d[i])/L + ((q*L)/(2*A*E)) )*x - (q/(2*A*E))*Math.pow(x,2);
    }

    Postprocessor(){
        postpcssr = new POSTPCSSR();
        JFrame frameMain = new JFrame("preprcssr Postprocessor");
        frameMain.setContentPane(postpcssr.jPanelPost);
        frameMain.setSize(1500,900);
        frameMain.setLocationRelativeTo(null);
        frameMain.setResizable(false);
        frameMain.setVisible(true);

        for(int i=0; i<project.bars.size();i++){
            postpcssr.comboBox1.addItem( String.valueOf(i+1) );
        }

        Project.Bar a = project.bars.get(0);
        double Nx = getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, 0, 0 );
        double Ux = getUx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, 0, 0 );
        double SgmX = Nx/a.A*Math.pow(10, a.es[1]);
        double[] Elements = {Nx, Ux, SgmX};
        double[][] minmax = new double[2][3];
        axis = new double[3];
        ph = new double[3];
        for(int i = 0; i < Elements.length; i++) {
            double el = Elements[i];
            double min = el, max = el;
            for (int b = 0; b < project.bars.size(); b++) {
                a = project.bars.get(b);
                for (int j = 0; j < a.L +1; j++) {

                    switch (i) {
                        case 0:
                            el = getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, b, j);
                            break;
                        case 1:
                            el = getUx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, b, j);
                            break;
                        case 2:
                            el = getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, b, j)/a.A*Math.pow(10, a.es[1]);
                            break;
                    }
                    if (el > max) {
                        max = el;
                    }
                    if (el < min) {
                        min = el;
                    }
                }
                minmax[0][i] = min;
                minmax[1][i] = max;
            }
            double hMax=0, hMin=0,  hAxis;
            if ((min >= 0) && (max > 0)) {
                hMax = max*680/Math.abs(max);
                hAxis = 720 - 20;
            } else {
                if ((min == 0) && (max == 0)) {
                    hMax=0;
                    hAxis = 360;
                } else {
                    hMax = (Math.abs(max) * 680) / (Math.abs(min) + Math.abs(max));
                    hMin = 680 - hMax;
                    hAxis = 720 - 20 - hMin;
                }
            }
            axis[i] = hAxis;
            ph[i] = Math.abs(hMax/max);
        }

    }

}
