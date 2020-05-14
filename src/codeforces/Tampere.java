package codeforces;

import java.util.Scanner;

public class Tampere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < p; i++) {
            String s   = sc.nextLine();
            String[] result = s.split(" ");
            int n = Integer.parseInt(result[0]);
            int m = Integer.parseInt(result[1]);

            int a = m / 2;
            int b = m - a;

            if (n == 1 || n == 0) {
                System.out.println(0);
            } else if (n == 2 || n == 3) {
                System.out.println(m);
            } else if (n == 4) {
                System.out.println(((a * 2) + (b * 2)) - 1);
            } else {
                System.out.println((a * 2) + (b * 2));
            }
        }
    }
}
