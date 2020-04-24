import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solvatron {
    public static void main(String[] args) {

        Solvatron solvatron = new Solvatron();
        solvatron.reducer();

//        Scanner sc = new Scanner(System.in);
//        int p = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < p; i++) {
//            String s   = sc.nextLine();
//            String[] result = s.split(" ");
//            int n = Integer.parseInt(result[0]);
//            int a = Integer.parseInt(result[1]);
//            int b = Integer.parseInt(result[2]);
//            int c = Integer.parseInt(result[3]);
//            int d = Integer.parseInt(result[4]);
//
//            if (((a-b)*n >= (c-d)) && ((a-b)*n <= (c+d))) {
//                System.out.println("yes");
//            } else if (((a+b)*n >= (c-d)) && ((a+b)*n <= (c+d))) {
//                System.out.println("yes");
//            } else {
//                System.out.println("no");
//            }
//        }
    }

    private void reducer() {
        int ans =
                IntStream.range(4000000, 2147483646).
                        boxed().
                        collect(Collectors.toList()).
                        stream().
                        reduce((integer, integer2) -> integer & integer2).
                        orElse(0);
        System.out.println(ans);


    }
}
