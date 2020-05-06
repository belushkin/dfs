import java.util.Scanner;

public class Silos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = Integer.parseInt(sc.nextLine());

        for (int k = 0; k < p; k++) {
            String s   = sc.nextLine();
            int amount = Integer.parseInt(s);

            int[] cards = new int[1000];
            for (int i = 1; i < cards.length; i++) {
                int c = 0;
                for (int j = 1; j <= i; j++) {
                    c += j*2;
                    if (j >= 2) {
                        c += j-1;
                    }
                }
                cards[i] = c;
            }

            int res = 0;
            while (amount >= 2) {
                for (int i = 1; i < cards.length; i++) {
                    if (cards[i] > amount) {
                        amount -= cards[i-1];
                        res += 1;
                        break;
                    }
                }
            }
            System.out.println(res);
        }

    }

}
