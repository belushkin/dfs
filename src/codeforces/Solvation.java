package codeforces;

import java.util.Scanner;

public class Solvation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < p; i++) {
            String s   = sc.nextLine();
            String[] result = s.split(" ");
            int n = Integer.parseInt(result[0]);
            int m = Integer.parseInt(result[1]);

            if (n == 1) {
                System.out.println("yes");
            } else if (n == 2 && m == 2) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
