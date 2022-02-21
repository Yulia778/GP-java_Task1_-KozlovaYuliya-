import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.*;

class Matrix {
    static int R = 4;
    static int C = 4;


    static int findLongestPath(int[][] mat, int i, int j, int x, int y) {

        if (j == y && i != x) {
            out.println("No such path");
        }
        boolean visited[][] = new boolean[R][C];
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(mat[i][j]);

        if (i != x || j != y) {
            arr.add(mat[x][y]);
        }
        int row = i;
        int col = j;


        for (row = i; (((C - 1) > row && row < x && (R - 1) > col && col <= y) ||
                ((C - 1) > row && row <= x && (R - 1) > col && col < y)); row++) {
            for (col = j; (((C - 1) > row && row < x && (R - 1) > col && col <= y) ||
                    ((C - 1) > row && row <= x && (R - 1) > col && col < y)); col++) {

                int max1 = 0;
                int max2 = 0;
                int max3 = 0;
                if (col < (y - 1)) {
                    max1 = mat[row][col + 1];
                }
                if (row < (x - 1) || col < (y - 1)) {
                    max2 = mat[row + 1][col + 1];
                }
                if (row < (x + 1) && col < (y - 1)) {
                    max3 = mat[row - 1][col + 1];
                }

                int sumMax = Math.max(max1, max2);
                arr.add(Math.max(sumMax, max3));

            }
        }



        if (x < i && y>1&&y < (C - 1)) {
            arr.add(mat[row - 1][col + 1]);
        };
        if (x < i && y == (C - 1)) {
            arr.add(mat[row][col +2 ]);
            arr.add(mat[row + 1][col + 1]);
        }


        int sum = 0;
        for (int a = 0; a < arr.toArray().length; a++) {
            sum = sum + arr.get(a);
        }
        out.println("initialVertex ->[" + x + "][" + y + "] =" + sum);

        return sum;
    }


    public static void main (String[]args){


        int mat[][] = {{1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}
        };
        out.println(" all longest paths tree from initialVertex:");

        Matrix t1=new Matrix();
        Matrix t2=new Matrix();
        Matrix t3=new Matrix();
        Matrix t4=new Matrix();
        Matrix t5=new Matrix();
        Matrix t6=new Matrix();
        Matrix t7=new Matrix();
        Matrix t8=new Matrix();
        Matrix t9=new Matrix();

        ArrayList<Integer>maxSum=new ArrayList<>();

        maxSum.add(t1.findLongestPath(mat, 0, 0, 0, 0));
        maxSum.add(t2.findLongestPath(mat, 1, 0, 1, 1));
        maxSum.add( t3.findLongestPath(mat, 1, 0, 2, 2));
        maxSum.add( t4.findLongestPath(mat, 1, 0, 0, 1));
        maxSum.add(t5.findLongestPath(mat, 1, 0, 1, 2));
        maxSum.add(t6.findLongestPath(mat, 1, 0, 0, 2));
        maxSum.add(t7.findLongestPath(mat, 2, 0, 2, 0));
        maxSum.add(t8.findLongestPath(mat, 1, 0, 1, 0));
        maxSum.add(t9.findLongestPath(mat, 1, 0, 2, 1));





        out.println("longest path tree from vertex 'initialVertex="+ Collections.max(maxSum));



    }
}
