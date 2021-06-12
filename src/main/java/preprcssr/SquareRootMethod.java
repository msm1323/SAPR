package preprcssr;

public class SquareRootMethod {
    private double[][] A;
    private double[] b;

    SquareRootMethod(double[][] A, double[] b){
        this.A = A;
        this.b= b;
    }

    protected double[] run(){
        int N = A.length;
        double y;
        double[] a = new double[N];
        double[] B = new double[N];
        double[] matRes = new double[N];
        int N1 = N - 1;
        y = A[0][0];
        a[0] = -A[0][1] / y;
        B[0] = b[0] / y  ;
        for (int i = 1; i < N1; i++) {
            y = A[i][i] + A[i][i - 1] * a[i - 1];
            a[i] = -A[i][i + 1] / y;
            B[i] = (b[i] - A[i][i - 1] * B[i - 1]) / y;
        }
        matRes[N1] = (b[N1] - A[N1][N1 - 1] * B[N1 - 1]) / (A[N1][N1] + A[N1][N1 - 1] * a[N1 - 1]);
        for (int i = N1 - 1; i >= 0; i--) {
            matRes[i] = a[i] * matRes[i + 1] + B[i];
        }
        return matRes;
    }

}