import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название файла: ");
        String s1 = in.nextLine();
        File file1 = new File(s1);

        Scanner in1 = new Scanner(file1);

        ArrayList<Integer> data = new ArrayList();

        while (in1.hasNext()) {
            data.add(in1.nextInt());
        }

        Collections.sort(data);
        double median;
        if (data.size() % 2 == 0)
            median = ((double)data.get(data.size()/2) + (double)data.get(data.size()/2 - 1))/2;
        else
            median = (double)data.get(data.size()/2) ;
        double res = 0;
        for (int i = 0; i < data.size(); i++) {
            res += Math.abs(data.get(i) - median);
        }
        System.out.println((int)res);

    }
}