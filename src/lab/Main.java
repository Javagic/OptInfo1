package lab;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Created by Ilya on 2/15/2018.
 */
public class Main {
    static double x0;
    static double y0;
    static double z0;
    static double ex;
    static double ey;
    static double ez;
    static double rpx0;
    static double rpy0;
    static double rpz0;
    static double nx;
    static double ny;
    static double nz;
    static double[] R0;//ray
    static double[] E;//rayDirection
    static double[] RP0;//plane
    static double[] N;//normal

    public static void main(String[] args) {
        initFromInput();
        //sum((RP0- R0)*normal)==0 && sum(E. * N))
        if (sum(multiply(diff(RP0, R0), N)) == 0 && (sum(multiply(E, N))) == 0) {//луч совпадает с плоскостью
            System.out.println("Луч лежит на плоскости");
        }
        else if(sum(multiply(E,N))==0){//луч параллелен
            System.out.println("Пересечения нет");
        }
        else{//луч пересекает
           double t = abs(sum(multiply(diff(RP0,R0),N)) / sum(multiply(E,N)));
            System.out.println("Длина луча:"+ t);
            double[] R = sum(R0,multiply(E,t));
            System.out.println("Координаты точки пересечения луча с плоскостью:"+ Arrays.toString(R));
        }
    }

    private static double[] diff(double[] a, double[] b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] - b[i];
        }
        return c;
    }

    private static double sum(double[] a) {
        double res = 0;
        for (double anA : a) {
            res += anA;
        }
        return res;
    }
    private static double[] sum(double[] a, double[] b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    private static double[] multiply(double[] a, double[] b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * b[i];
        }
        return c;
    }
    private static double[] multiply(double[] a, double b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * b;
        }
        return c;
    }
    /*        if (sum((RP0 - R0). * N) == 0)&&(sum(E. * N) == 0)
        disp('Точка лежит на плоскости');
        elseif sum (E. * N) == 0
        disp('Пересечения нет');
        else
        t = abs(sum((RP0 - R0). * N) / sum(E. * N));
        disp('Длина луча:');
        t
                R = R0 + t * E;
        disp('Координаты точки пересечения луча с плоскостью:');
        R
                end*/
    static private void initFromInput(){
        System.out.println("Параметры луча:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Координата начала луча по x:");
        x0 = scanner.nextDouble();
        System.out.println("Координата начала луча по y:");
        y0 = scanner.nextDouble();
        System.out.println("Координата начала луча по z:");
        z0 = scanner.nextDouble();
        System.out.println("Координата направления луча по x:");
        ex = scanner.nextDouble();
        System.out.println("Координата направления луча по y:");
        ey = scanner.nextDouble();
        System.out.println("Координата направления луча по z:");
        ez = scanner.nextDouble();
        System.out.println("Параметры плоскости:");
        System.out.println("Координата точки плоскости по x:");
        rpx0 = scanner.nextDouble();
        System.out.println("Координата точки плоскости по y:");
        rpy0 = scanner.nextDouble();
        System.out.println("Координата точки плоскости по z:");
        rpz0 = scanner.nextDouble();
        System.out.println("Координата нормали по x:");
        nx = scanner.nextDouble();
        System.out.println("Координата нормали по y:");
        ny = scanner.nextDouble();
        System.out.println("Координата нормали по z:");
        nz = scanner.nextDouble();
        double absN = sqrt(nx*nx+ny*ny+nz*nz);
        double absE = sqrt(ex*ex+ey*ey+ez*ez);
        R0 = new double[]{x0, y0, z0};
        E = new double[]{ex/absE, ey/absE, ez/absE};
        RP0 = new double[]{rpx0, rpy0, rpz0};
        N = new double[]{nx/absN, ny/absN, nz/absN};
    }
}
