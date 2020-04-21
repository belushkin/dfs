import java.util.Scanner;

public class Solvation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < p; i++) {
            int t = Integer.parseInt(sc.nextLine());
            int l = 1;
            int res = t;
            while (res/10 > 0) {
                res /= 10;
                l++;
            }

            boolean out = false;
            int k = 1;
            for (int j = 2; j < t; j++) {
                if (t % j == 0) {
                    if (k == l) {
                        System.out.println(j);
                        out = true;
                        break;
                    }
                    k++;
                }
            }
            if (!out) {
                System.out.println(1);
            }
        }
    }
}
