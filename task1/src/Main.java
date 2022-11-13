import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;

        boolean br = false;
        ArrayList<Integer> res = new ArrayList<>();
        int k = 0;

        int[] new_arr = new int[m];
        while (!br) {
            for (int i = 0; i < m; i++) {
                new_arr[i] = arr[k % n];
                k++;
            }
            res.add(new_arr[0]);

            if (new_arr[m - 1] == 1)
                br = true;

            k--;
        }
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i));
    }

}