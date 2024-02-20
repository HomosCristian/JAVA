package seminar1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {  //putem sa scriem psvm + enter
//        System.out.println("Seminar 1");
//        for(String v:args){
//            System.out.println(v);
//        }
        //Problema 1 din Tema 1.1
        int n= args.length/2;
        double[][] x = new double [n][];

        for(int i =0; i<n;i++){
            int m= Integer.parseInt(args[i*2].trim());
            x[i]= new double[m];
            for(int j=0;j<m;j++){
                x[i][j]=Double.parseDouble(args[i*2+1].trim());      // .trim elimina spatiile de la inceput si final
            }
        }
        afisareMatrice(x, "Matricea initiala:");
        try {
            x = inserareLinie(x, new double[]{Math.PI, Math.E}, 1);
            afisareMatrice(x, "Matrice dupa inserare:");
        }
        catch (Exception e){
            System.err.println(e);
        }

        try {
            x = stergereLinie(x, 1);
            afisareMatrice(x, "Matrice dupa stergere:");
        }
        catch (Exception e){
            System.err.println(e);
        }

    }

    private static  double[][] inserareLinie(double[][] x, double[] v, int k)
    throws Exception{

        int n = x.length;
        if (k < 0 || k > n) {
            throw new Exception("Index linie invalid!");

        }
        double[][] y = new double[n+1][];

        for(int i =0; i<k;i++){
            y[i]= Arrays.copyOf(x[i], x[i].length);
        }
        y[k]= Arrays.copyOf(v, v.length);
        for(int i =k+1 ;i< n;i++){
            y[i]= Arrays.copyOf(x[i-1], x[i-1].length);
        }
        return y;
    }

    private static double[][] stergereLinie(double[][] x, int k)     //tema
        throws Exception{
        int n =x.length;
        if(k<0 || k>n){
            throw new Exception("Index linie invalid!");
        }

        double[][] y = new double[n-1][];

        for(int i =0; i<k;i++){
            y[i]= Arrays.copyOf(x[i], x[i].length);
        }

        for(int i =k+1 ;i< n-1;i++){
            y[i]= Arrays.copyOf(x[i+1], x[i+1].length);
        }
        return y;
    }
    public static void afisareMatrice(double[][] x, String mesaj){

        System.out.println(mesaj);
        for(double[] v:x){
            System.out.println(Arrays.toString(v));
        }

    }



}
