import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название файла, в котором находится данные о точке и радиусе: ");
        String s1 = in.nextLine();

        System.out.println("Введите название файла, в котором находятся точки: ");
        String s2 = in.nextLine();
        File file1 = new File(s1);
        File file2 = new File(s2);

        Scanner in1 = new Scanner(file1);
        Scanner in2 = new Scanner(file2);

        double x = in1.nextDouble();
        double y = in1.nextDouble();
        double r = in1.nextDouble();

        double x2, y2;
        ArrayList<Integer> points = new ArrayList();
        while (in2.hasNext()) {
            x2 = in2.nextDouble();
            y2 = in2.nextDouble();

            points.add(calculateDistanceBetweenPoints(x, y, x2, y2, r));
        }


        for (int i = 0; i < points.size(); i++)
            System.out.println(points.get(i));


    }
    public static int calculateDistanceBetweenPoints(double x1, double y1, double x2, double y2, double r) {
        double res = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        if (Math.abs(res - r) < 0.0001) return 0;
        else if (res < r) return 1;
        else return 2;

    }
}