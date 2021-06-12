package preprcssr;

import javax.swing.*;
import java.awt.*;

import static preprcssr.PREPCSSR.project;
import static preprcssr.MyCanvas.*;

public class PostCanvas extends JPanel {

    @Override
    public void paint(Graphics g){
        super.paint(g);
        DefaultListModel listModel = new DefaultListModel();
        Postprocessor.postpcssr.postList.setModel(listModel);
        if(POSTPCSSR.nxJChB){
            double x = 10;
            for(int i=0; i<project.bars.size();i++){
                listModel.addElement("На стержне №"+(i+1)+":\n");
                g.setColor(Color.RED);
                Project.Bar a = project.bars.get(i);
                w = pL*a.typeL;
                g.drawLine( (int)x, 20+(int)(Postprocessor.axis[0]- Postprocessor.ph[0]* Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, 0)), (int)(x+w), 20+(int)(Postprocessor.axis[0]- Postprocessor.ph[0]*Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, a.L)));
                int ii=0;
                for(int j=(int)x; j<(int)(x+w); j+=10){
                    g.drawLine(j, 20+(int)(Postprocessor.axis[0]- Postprocessor.ph[0]* Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, ii*10*a.L/w)), j, 20+(int)Postprocessor.axis[0]);
                    ii++;
                }
                g.setColor(Color.WHITE);
                g.drawLine((int)(x), 720,(int)(x), 0);
                g.drawLine((int)(x+w), 720,(int)(x+w), 0);
                listModel.addElement("Nx(0) = "+Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, 0)+"\n");
                listModel.addElement("Nx("+a.L+") = "+Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, a.L)+"\n");
                x+=w;
            }
            g.drawLine(0,20+(int) Postprocessor.axis[0], 1000, 20+(int) Postprocessor.axis[0]);
        }
        if(POSTPCSSR.uxJChB) {
            int x = 10;
            for (int i = 0; i < project.bars.size(); i++) {
                listModel.addElement("На стержне №"+(i+1)+":\n");
                g.setColor(Color.MAGENTA);
                Project.Bar a = project.bars.get(i);
                w = pL * a.typeL;
                int[] xs = new int[w];
                int[] ys = new int[w];
                double xB;
                for (int j = 0; j <  w; j++) {
                    xs[j] = x+j;
                    xB = a.L*j/w;
                    ys[j] = 20+(int)(Postprocessor.axis[1]- Postprocessor.ph[1]* Postprocessor.getUx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i,xB));
                }

                g.drawPolyline(xs, ys, w);
                for(int j=0; j<w-1; j++){
                    ys[j] = ys[j]+1;
                }
                g.drawPolyline(xs, ys, w);
                for(int j=10; j<w-1; j+=10){
                    ys[j-1] = ys[j];
                    xs[j-1] = xs[j];
                    ys[j+1] = ys[j];
                    xs[j+1] = xs[j];
                    ys[j] = 20+(int) Postprocessor.axis[1];
                }
                g.drawPolyline(xs, ys, w);
                g.setColor(Color.WHITE);
                g.drawLine((x), 720,(x), 0);
                g.drawLine((x+w), 720,(x+w), 0);
                listModel.addElement("Ux(0) = "+Postprocessor.getUx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, 0)+"\n");
                listModel.addElement("Ux("+a.L+") = "+Postprocessor.getUx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, a.L)+"\n");
                x += w;
            }
            g.drawLine(0, 20+(int) Postprocessor.axis[1], 1000, 20+(int) Postprocessor.axis[1]);
        }
        if(POSTPCSSR.σJChB){
            int x = 10;
            for (int i = 0; i < project.bars.size(); i++) {
                listModel.addElement("На стержне №"+(i+1)+":\n");
                g.setColor(Color.BLUE);
                Project.Bar a = project.bars.get(i);
                w = pL * a.typeL;
                System.out.println(w);
                int[] xs = new int[w];
                int[] ys = new int[w];
                double xB;
                for (int j = 0; j < w; j++) {
                    xs[j] = x+j;
                    xB = a.L*((double)j)/w;
                    ys[j] = 20+(int)(Postprocessor.axis[2]- Postprocessor.ph[2]* Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i,xB)/a.A);
                }
                g.drawPolyline(xs, ys, w);
                g.drawLine(xs[0], ys[0], xs[w-1], ys[w-1]);
                for(int j=0; j<w-1; j++){
                    ys[j] = ys[j]+1;
                }
                g.drawPolyline(xs, ys, w);
                for(int j=0; j<w-1; j+=10){
                    if(j!=0){
                        ys[j-1] = ys[j];
                        xs[j-1] = xs[j];
                    }
                    ys[j+1] = ys[j];
                    xs[j+1] = xs[j];
                    ys[j] = 20+(int) Postprocessor.axis[2];
                }
                g.drawPolyline(xs, ys, w);
                g.setColor(Color.WHITE);
                g.drawLine((x+w), 720,(x+w), 0);
                g.drawLine((x), 720,(x), 0);
                listModel.addElement("σx(0) = "+Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, 0)/a.A+"\n");
                listModel.addElement("σx("+a.L+") = "+Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, a.L)/a.A+"\n");
                x += w;
            }
            g.drawLine(0, 20+(int) Postprocessor.axis[2], 1000, 20+(int) Postprocessor.axis[2]);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DefaultListModel listModel = new DefaultListModel();
        Postprocessor.postpcssr.postList.setModel(listModel);
        if(POSTPCSSR.nxJChB){
            double x = 10;
            for(int i=0; i<project.bars.size();i++){
                listModel.addElement("На стержне №"+(i+1)+":\n");
                g.setColor(Color.RED);
                Project.Bar a = project.bars.get(i);
                w = pL*a.typeL;
                g.drawLine( (int)x, 20+(int)(Postprocessor.axis[0]- Postprocessor.ph[0]* Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, 0)), (int)(x+w), 20+(int)(Postprocessor.axis[0]- Postprocessor.ph[0]* Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, a.L)));
                int ii=0;
                for(int j=(int)x; j<(int)(x+w); j+=10){
                    g.drawLine(j, 20+(int)(Postprocessor.axis[0]- Postprocessor.ph[0]* Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, ii*10*a.L/w)), j, 20+(int)Postprocessor.axis[0]);
                    ii++;
                }
                g.setColor(Color.WHITE);
                g.drawLine((int)(x), 720,(int)(x), 0);
                g.drawLine((int)(x+w), 720,(int)(x+w), 0);
                listModel.addElement("Nx(0) = "+Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, 0)+"\n");
                listModel.addElement("Nx("+a.L+") = "+Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, a.L)+"\n");
                x+=w;
            }
            g.drawLine(0,20+(int) Postprocessor.axis[0], 1000, 20+(int) Postprocessor.axis[0]);
        }
        if(POSTPCSSR.uxJChB) {
            int x = 10;
            for (int i = 0; i < project.bars.size(); i++) {
                listModel.addElement("На стержне №"+(i+1)+":\n");
                g.setColor(Color.MAGENTA);
                Project.Bar a = project.bars.get(i);
                w = pL * a.typeL;
                int[] xs = new int[w];
                int[] ys = new int[w];
                double xB;
                for (int j = 0; j < w; j++) {
                    xs[j] = x+j;
                    xB = a.L*j/w;
                    ys[j] = 20+(int)(Postprocessor.axis[1]- Postprocessor.ph[1]* Postprocessor.getUx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i,xB));
                }
                g.drawPolyline(xs, ys, w);
                for(int j=0; j<w-1; j++){
                    ys[j] = ys[j]+1;
                }
                g.drawPolyline(xs, ys, w);
                for(int j=10; j<w-1; j+=10){
                    ys[j-1] = ys[j];
                    xs[j-1] = xs[j];
                    ys[j+1] = ys[j];
                    xs[j+1] = xs[j];
                    ys[j] = 20+(int) Postprocessor.axis[1];
                }
                g.drawPolyline(xs, ys, w);
                g.setColor(Color.WHITE);
                g.drawLine((x), 720,(x), 0);
                g.drawLine((x+w), 720,(x+w), 0);
                listModel.addElement("Ux(0) = "+Postprocessor.getUx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, 0)+"\n");
                listModel.addElement("Ux("+a.L+") = "+Postprocessor.getUx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, a.L)+"\n");
                x += w;
            }
            g.drawLine(0, 20+(int) Postprocessor.axis[1], 1000, 20+(int) Postprocessor.axis[1]);
        }
        if(POSTPCSSR.σJChB){
            int x = 10;
            for (int i = 0; i < project.bars.size(); i++) {
                listModel.addElement("На стержне №"+(i+1)+":\n");
                g.setColor(Color.BLUE);
                Project.Bar a = project.bars.get(i);
                w = pL * a.typeL;
                System.out.println(w);
                int[] xs = new int[w];
                int[] ys = new int[w];
                double xB;
                for (int j = 0; j < w; j++) {
                    xs[j] = x+j;
                    xB = a.L*((double)j)/w;
                    ys[j] = 20+(int)(Postprocessor.axis[2]- Postprocessor.ph[2]* Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i,xB)/a.A);
                }
                g.drawPolyline(xs, ys, w);
                g.drawLine(xs[0], ys[0], xs[w-1], ys[w-1]);
//                for(int j=0; j<w-1; j++){
//                    ys[j] = ys[j]+1;
//                }
//                g.drawPolyline(xs, ys, w);
//                for(int j=0; j<w-1; j+=10){
//                    if(j!=0){
//                        ys[j-1] = ys[j];
//                        xs[j-1] = xs[j];
//                    }
//                    ys[j+1] = ys[j];
//                    xs[j+1] = xs[j];
//                    ys[j] = 20+(int) Postprocessor.axis[2];
//                }
//                g.drawPolyline(xs, ys, w);
                g.setColor(Color.WHITE);
                g.drawLine((x+w), 720,(x+w), 0);
                g.drawLine((x), 720,(x), 0);
                listModel.addElement("σx(0) = "+Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, 0)/a.A+"\n");
                listModel.addElement("σx("+a.L+") = "+Postprocessor.getNx(a.E*Math.pow(10, a.es[2]), a.A*Math.pow(10, a.es[1]), a.L*Math.pow(10, a.es[0]), a.q, i, a.L)/a.A+"\n");
                x += w;
            }
            g.drawLine(0, 20+(int) Postprocessor.axis[2], 1000, 20+(int) Postprocessor.axis[2]);
        }
    }
}
