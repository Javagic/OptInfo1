package lab;

import javax.media.j3d.BranchGroup;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Created by Ilya on 2/15/2018.
 */
public class Sphere {
    static double[] R0;
    static double[] E;
    static double[] P0;
    static double R;
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
        System.out.println("Параметры сферы:");
        System.out.println("Координата точки сферы по x:");
        double rpx0 = scanner.nextDouble();
        System.out.println("Координата точки сферы по y:");
        double rpy0 = scanner.nextDouble();
        System.out.println("Координата точки сферы по z:");
        double rpz0 = scanner.nextDouble();
        System.out.println("Радиус сферы:");
        R = scanner.nextDouble();
        double absE = sqrt(ex * ex + ey * ey + ez * ez);
        R0 = new double[]{x0, y0, z0};//ray
        E = new double[]{ex / absE, ey / absE, ez / absE};//rayDirection
        P0 = new double[]{rpx0, rpy0, rpz0};//plane
        double[] a = diff(R0, P0);//r0-p0
        if (isCross()<0) {
            System.out.println("Пересечения нет");
        } else if(isCross()==0){
            double t1 = scalar(a, E) + tSqrt();
            if(t1>0)System.out.println("t1 = "+t1);
        }else {
            double t1 = -scalar(a, E) + tSqrt();
            double t2 = -scalar(a, E) - tSqrt();
            if(t1>0)System.out.println("t1 = "+t1);
            if(t2>0)System.out.println("t2 = "+t2);
        }
    }

    private static double isCross() {
        double[] a = diff(R0, P0);//r0-p0
        return scalar(a, E) * scalar(a, E) - (scalar(a, a) - R * R);
    }

    private static double tSqrt() {
        double[] a = diff(R0, P0);//r0-p0
        return sqrt(scalar(a, E) * scalar(a, E) - scalar(a, a) + R * R);
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

    private static double scalar(double[] a, double[] b) {
        return sum(multiply(a, b));
    }

    private static double[] multiply(double[] a, double b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * b;
        }
        return c;
    }
}
