package codeforces;

import java.util.*;

public class TwoCityScheduling {
    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
//        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
//        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));

        //,,{840,118},{577,469}
        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{
                {259, 770},
                {448, 54},
                {926, 667},
                {184, 139},
                {840, 118},
                {577, 469}

//                {100, 1},
//                {1, 5},
//                {0, 5},
//                {1, 5}
        }));


//        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20},{40,30},{100,100}}));
//        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}}));
    }


    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, Comparator.comparingInt(ints -> (ints[0] - ints[1])));
        int res = 0;
        for (int i = 0; i <costs.length; i++) {
            if (i < costs.length/2) {
                res += costs[0][0];
            } else {
                res += costs[1][0];
            }
        }
        return res;
    }
}
