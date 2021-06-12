package preprcssr;

import java.util.ArrayList;
import java.util.Arrays;

public class Project {
    protected ArrayList<Bar> bars = new ArrayList<>();
    protected ArrayList<Load> loads = new ArrayList<>();
    protected boolean sealL;
    protected boolean sealR;

    public void createBar(double l, double a, double e, double alwV, int[] es){
        Bar bar = new Bar();
        bar.A = a;
        bar.E = e;
        bar.L = l;
        bar.σ = alwV;
        bar.es = Arrays.copyOf(es, es.length);
        bars.add(bar);
    }

    public void createLoad(boolean type, double value, int num){
        Load load = new Load();
        load.loadType = type;
        load.value = value;
        load.number = num;
        loads.add(load);
    }

    protected class Load{
        protected boolean loadType;
        protected double value;
        protected int number;   //стержня или узла в зависимости от типа
    }

    protected class Bar {
        protected double A;
        protected double E;
        protected double L;
        protected double σ;
        protected double q;
        protected int[] es;
        protected int typeA;
        protected int typeL;

        @Override
        public boolean equals(Object obj) { //с учетом только L и A
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Bar other = (Bar) obj;
            if (A != other.A)
                return false;
            if (L != other.L)
                return false;
            return true;
        }
    }
}
