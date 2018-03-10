package lab;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Created by Ilya on 2/15/2018.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Параметры луча:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Координата начала луча по x:");
        double x0 = scanner.nextDouble();
        System.out.println("Координата начала луча по y:");
        double y0 = scanner.nextDouble();
        System.out.println("Координата начала луча по z:");
        double z0 = scanner.nextDouble();
        System.out.println("Координата направления луча по x:");
        double ex = scanner.nextDouble();
        System.out.println("Координата направления луча по y:");
        double ey = scanner.nextDouble();
        System.out.println("Координата направления луча по z:");
        double ez = scanner.nextDouble();
        System.out.println("Параметры плоскости:");
        System.out.println("Координата точки плоскости по x:");
        double rpx0 = scanner.nextDouble();
        System.out.println("Координата точки плоскости по y:");
        double rpy0 = scanner.nextDouble();
        System.out.println("Координата точки плоскости по z:");
        double rpz0 = scanner.nextDouble();
        System.out.println("Координата нормали по x:");
        double nx = scanner.nextDouble();
        System.out.println("Координата нормали по y:");
        double ny = scanner.nextDouble();
        System.out.println("Координата нормали по z:");
        double nz = scanner.nextDouble();
        double absN = sqrt(nx*nx+ny*ny+nz*nz);
        double absE = sqrt(ex*ex+ey*ey+ez*ez);
        double[] R0 = {x0, y0, z0};//ray
        double[] E = {ex/absE, ey/absE, ez/absE};//rayDirection
        double[] RP0 = {rpx0, rpy0, rpz0};//plane
        double[] N = {nx/absN, ny/absN, nz/absN};//normal
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
}
