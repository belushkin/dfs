import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> aa = new ArrayList<>();
        List<Integer> bb = new ArrayList<>();
        boolean no = false;

        int p = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < p; i++) {
            int t = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < t; j++) {
                String s   = sc.nextLine();
                String[] result = s.split(" ");
                int a = Integer.parseInt(result[0]);
                int b = Integer.parseInt(result[1]);
                aa.add(a);
                bb.add(b);
            }
            for (int l = 0; l < aa.size(); l++) {
                if (
                        aa.get(l) < 0 ||
                        bb.get(l) < 0 ||
                        ((l+1) < aa.size() && aa.get(l) > aa.get(l+1)) ||
                        ((l+1) < bb.size() && bb.get(l) > bb.get(l+1)) ||
                        ((l+1) < bb.size() && aa.get(l).equals(aa.get(l+1)) && !bb.get(l).equals(bb.get(l + 1))) ||
                        ((l-1) > 0 && bb.get(l) > bb.get(l-1) && aa.get(l).equals(aa.get(l - 1))) ||
                        ((l-1) > 0 && aa.get(l).equals(bb.get(l)) && !aa.get(l).equals(aa.get(l-1))) ||
                        bb.get(l) > aa.get(l)
                ) {
                    System.out.println("NO");
                    no = true;
                    break;
                }
            }

            if (!no) {
                System.out.println("YES");
            }
        }
    }
}
