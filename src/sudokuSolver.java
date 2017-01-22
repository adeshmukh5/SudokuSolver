/**
 * Created by anushkadeshmukh on 1/5/17.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class sudokuSolver {
    public static int[][] puz;
    public static boolean[][][] sudoku = new boolean[9][9][9];



    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k<9; k++) {
                    sudoku[i][j][k] = true;
                }
            }
        }

        puz = new int[9][9];
        System.out.println("when entering rows, use a 0 for a blank, and your row may look like this: 0 2 0 0 0 4 0 9 0");
        Scanner reader = new Scanner(System.in);
        System.out.println("enter row 1:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[0][i] = cur;
        }
        System.out.println("enter row 2:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[1][i] = cur;
        }
        System.out.println("enter row 3:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[2][i] = cur;
        }
        System.out.println("enter row 4:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[3][i] = cur;
        }
        System.out.println("enter row 5:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[4][i] = cur;
        }
        System.out.println("enter row 6:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[5][i] = cur;
        }
        System.out.println("enter row 7:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[6][i] = cur;
        }
        System.out.println("enter row 8:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[7][i] = cur;
        }
        System.out.println("enter row 9:");
        for (int i = 0; i < 9; i++) {
            int cur = reader.nextInt();
            puz[8][i] = cur;
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(puz[i][j] != 0) {
                    for(int row = 0; row < 9; row ++){
                        sudoku[row][j][puz[i][j] - 1] = false;
                    }
                    for(int col = 0; col < 9; col ++){
                        sudoku[i][col][puz[i][j] - 1] = false;
                    }
                    for (int row = i - (i % 3); row < i - (i % 3) + 3; row++){
                        for (int col = j - (j % 3); col < j - (j % 3) + 3; col++){
                            sudoku[row][col][puz[i][j] - 1] = false;
                        }
                    }
                }
            }
        }


        sudokuSolver s = new sudokuSolver();
        if (s.solve()) {
            s.print();
        } else {
            System.out.println("NO SOLUTION");
        }
        System.out.println("  ");
    }


    public boolean solve() {
        int[] blank = getblank();

        if (blank[0] == 10) {
            return true;
        }

        for(int i = 1; i < 10; i ++){
            if (sudoku[blank[0]][blank[1]][i - 1]){
                if (numAllowed(blank, i)){
                    puz[blank[0]][blank[1]] = i;
                    if(solve()) {
                        return true;
                    }
                    else{
                        puz[blank[0]][blank[1]] = 0;
                    }
                }
            }
        }
        return false;
    }

    public int[] getblank() {
        int[] blank = new int[2];
        for (int row = 0; row < 9; row ++) {
            for (int col = 0; col < 9; col ++) {
                if (puz[row][col] == 0) {
                     blank[0] = row;
                     blank[1] = col;
                    return blank;
                }
            }
        }
        blank[0] = 10;
        blank[1] = 10;
        return blank;
    }

    public boolean numAllowed(int[] blank, int num) {

        for (int i = 0; i < 9; i++) {
            if (puz[blank[0]][i] == num) {
                return false;
            }
            if (puz[i][blank[1]] == num) {
                return false;
            }
        }
        for (int i = blank[0] - (blank[0] % 3); i < blank[0] - (blank[0] % 3) + 3; i++){
            for (int j = blank[1] - (blank[1] % 3); j < blank[1] - (blank[1] % 3) + 3; j++){
                if (puz[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    public void print(){
        for (int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                System.out.print(puz[row][col]);
            }
            System.out.println("");
        }
    }
}

