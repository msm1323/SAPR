package preprcssr;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static preprcssr.PREPCSSR.project;

public class MyCanvas extends JPanel {

    protected static int x=10, y, w=0, h, pA, pL;

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(project.bars.size()!=0) {
            drawBars(g);
            drawSeal(g);
        }
        if(project.loads.size()!=0){
            drawLoads(g);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(project.bars.size()!=0) {
            drawBars(g);
            drawSeal(g);
        }
        if(project.loads.size()!=0){
            drawLoads(g);
        }
    }

    public void drawBars (Graphics g) {
        ArrayList<Project.Bar> barsClone = new ArrayList<>();
        barsClone.addAll(project.bars);
        Collections.sort(barsClone, new SortByCost());

        int n = 1;
        barsClone.get(0).typeA = 1;
        for(int i=1; i<barsClone.size(); i++){
            if(barsClone.get(i).A*Math.pow(10, barsClone.get(i).es[1])!=barsClone.get(i-1).A*Math.pow(10, barsClone.get(i-1).es[1])){
                barsClone.get(i).typeA = barsClone.get(i-1).typeA+1;
                n++;
            }else{
                barsClone.get(i).typeA = barsClone.get(i-1).typeA;
            }
        }
        barsClone.clear();
        barsClone.addAll(project.bars);
        Collections.sort(barsClone, new SortByCost2());

        barsClone.get(0).typeL = 1;
        int sum = 1;
        for(int i = 1; i<barsClone.size(); i++){
            if(barsClone.get(i).L*Math.pow(10, barsClone.get(i).es[0])!=barsClone.get(i-1).L*Math.pow(10, barsClone.get(i-1).es[0])){
                barsClone.get(i).typeL = barsClone.get(i-1).typeL+1;
            }else{
                barsClone.get(i).typeL = barsClone.get(i-1).typeL;
            }
            sum += barsClone.get(i).typeL;
        }
        for(Project.Bar i: barsClone){
            whereIsTwins(project.bars, i);
        }

        pA = 720/n;
        pL = 973/sum;
        x=10; y=10; w=0; h=0;
        g.setColor(Color.WHITE);
        if(pL<22){
            h = 720;
            for(int i=0; i<project.bars.size(); i++){
                x = x + w;
                w = 22;
                y = 415 - h/2;
                g.drawRect(x,y,w,h);
            }
        }else {
            for (Project.Bar i : project.bars) {
                h = pA * i.typeA;
                x = x + w;
                w = pL * i.typeL;
                y = 415 - h / 2;
                g.drawRect(x, y, w, h);

            }
        }

    }

    private void drawLoads(Graphics g){
        int xStart;
        for ( Project.Load load: project.loads ) {
            xStart = 10;
            for(int i=0; i<load.number-1; i++){
                xStart+=pL*project.bars.get(i).typeL;
            }
            double p;
            if(load.loadType){
                g.setColor(Color.MAGENTA);
                if (load.value<0){
                    if( load.number==1 ){
                        p=30;
                    }else{
                        p = pL*project.bars.get(load.number-2).typeL;
                    }
                    for(int i=413; i<418; i++){
                        g.drawLine(xStart, i, (int)(xStart-p/4), i);
                    }
                    for(int i=0; i<=p/4; i++){
                        g.drawLine((int)(xStart-p/2+i), 415, (int)(xStart-p/4), (int)(415-p/4+i));
                        g.drawLine((int)(xStart-p/2+i), 415, (int)(xStart-p/4), (int)(415+p/4-i));
                    }
                }else{
                    if( load.number==project.bars.size()+1 ){
                        p=30;
                    }else{
                        p = pL*project.bars.get(load.number-1).typeL;
                    }
                    for(int i=413; i<418; i++){
                        g.drawLine(xStart, i, (int)(xStart+p/4), i);
                    }
                    for(int i=0; i<=p/4; i++){
                        g.drawLine((int)(xStart+p/2-i), 415, (int)(xStart+p/4), (int)(415-p/4+i));
                        g.drawLine((int)(xStart+p/2-i), 415, (int)(xStart+p/4), (int)(415+p/4-i));
                    }
                }
            }else{
                g.setColor(Color.BLUE);
                p = pL*project.bars.get(load.number-1).typeL;
                for(int i=413; i<418; i++){
                    g.drawLine(xStart, i, (int)(xStart+p), i);
                }
                if(load.value<0){
                    for(int i=0; i<(p-p/4); i+=p/4) {
                        for(int j=0; j<5; j++){
                            g.drawLine((int)(p/16+xStart + i+j), 415, (int)(p/16+xStart + p / 8 + i+j), 400);
                            g.drawLine((int)(p/16+xStart + i+j), 415, (int)(p/16+xStart + p / 8 + i+j), 430);
                        }
                    }
                }else{
                    for(int i=0; i<(p-p/4); i+=p/4) {
                        for(int j=0; j<5; j++){
                            g.drawLine((int)(xStart + p / 8 + i+j), 415, xStart + i+j, 400);
                            g.drawLine((int)(xStart + p / 8 + i+j), 415, xStart + i+j, 430);
                        }
                    }
                }
            }
        }
    }

    public void drawSeal(Graphics g) {
        if ( project.sealL ) {
            g.setColor(Color.WHITE);
            for (int i = 0; i < 800; i = i + 10) {
                g.drawLine(0, i, 10, i + 10);
                g.drawLine(0, i + 1, 10, i + 11);
            }
            g.drawLine(9, 0, 9, 800);
            g.drawLine(10, 0, 10, 800);
        }
        if (project.sealR) {
            g.setColor(Color.WHITE);
            for (int i = 0; i < 800; i = i + 10) {
                g.drawLine(x+w, i, x+w+10, i + 10);
                g.drawLine(x+w, i + 1, x+w+10, i + 11);
            }
            g.drawLine(x+w, 0, x+w, 800);
            g.drawLine(x+w+1, 0, x+w+1, 800);
        }
    }

    class SortByCost implements Comparator<Project.Bar> {
        public int compare(Project.Bar a, Project.Bar b) {
            if ( a.A*Math.pow(10, a.es[1]) < b.A*Math.pow(10, b.es[1])) return -1;
            else if ( a.A*Math.pow(10, a.es[1]) == b.A*Math.pow(10, b.es[1]) ) return 0;
            else return 1;
        }
    }

    class SortByCost2 implements Comparator<Project.Bar> {
        public int compare(Project.Bar a, Project.Bar b) {
            if ( a.L*Math.pow(10, a.es[0]) < b.L*Math.pow(10, b.es[0])) return -1;
            else if ( a.L*Math.pow(10, a.es[0]) == b.L*Math.pow(10, b.es[0]) ) return 0;
            else return 1;
        }
    }

    private void whereIsTwins(ArrayList<Project.Bar> list, Project.Bar el){
        for(Project.Bar i: list){
            if( i.equals(el) ){
                i.typeA = el.typeA;
                i.typeL = el.typeL;
            }
        }
    }
}
