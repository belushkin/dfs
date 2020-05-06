import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoCityScheduling {
    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
//        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
//        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));

        //,,{840,118},{577,469}
        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{
                {259, 770},
                {448, 54},
//                {926, 667},
//                {184, 139},
//                {840, 118},
//                {577, 469}
        }));


//        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20},{40,30},{100,100}}));
//        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}}));
    }


    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] a,int[] b)->{

            System.out.println(a[1] + " " +  a[0]);
            System.out.println("----");
            System.out.println(b[1] + " " +  b[0]);
            System.out.println("--");
            System.out.println((a[1] - a[0]) - (b[1] - b[0]));

            return (a[1] - a[0]) - (b[1] - b[0]);

        });

        int count = 0;
        int total = 0;
        for(int[] pair:costs){
            q.offer(pair);
        }

        int[] a = q.poll();
        System.out.println(a[0] + " " + a[1]);
        a = q.poll();
        System.out.println(a[0] + " " + a[1]);
//        a = q.poll();
//        System.out.println(a[0] + " " + a[1]);
//        a = q.poll();
//        System.out.println(a[0] + " " + a[1]);
//        a = q.poll();
//        System.out.println(a[0] + " " + a[1]);
//        a = q.poll();
//        System.out.println(a[0] + " " + a[1]);
        return 1;
    }
}
