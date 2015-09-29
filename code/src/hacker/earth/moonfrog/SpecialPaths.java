package hacker.earth.moonfrog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sachin Maheshwari on 9/20/2015.
 */
public class SpecialPaths {


    private static final int MODULUS_NUMBER = 1000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        List<Coordinates> coordinatesList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            coordinatesList.add(new Coordinates(scanner.nextInt(), scanner.nextInt()));
        }

        SpecialPaths solution = new SpecialPaths(n, m, k, coordinatesList.toArray(new Coordinates[k]));
        int[] pathsCounter = solution.findSolution();

        for (int i = 0; i < pathsCounter.length; i++) {
            System.out.print( pathsCounter[i] + " ");

        }

    }


    int[] pathsFound;
    int[][] field;

    public SpecialPaths(int n, int m, int k, Coordinates[] specialFields){
        field = new int[n][m];
        pathsFound = new int[k + 1];
        for (int i = 0; i < specialFields.length; i++) {
            Coordinates specialField = specialFields[i];
            // minus 1 as it starts with 1
            field[specialField.getX() - 1][specialField.getY() -1] = 1;
        }

    }


    public int[] findSolution(){
        traverseIt(new Coordinates(0, 0), 0);
        return pathsFound;
    }

    private void traverseIt(Coordinates current, int totalSpecialEncountered) {

        if(field[current.getX()][current.getY()] == 1){
            // Current is a special field.
            totalSpecialEncountered = (totalSpecialEncountered + 1);
        }

        if(current.getX() == field.length-1 && current.getY() == field[0].length-1){
            // We are at the end.
            pathsFound[totalSpecialEncountered] = (pathsFound[totalSpecialEncountered] + 1) % MODULUS_NUMBER;

            return;
        } else {
            if(current.getX() + 1 < field.length){
                traverseIt(new Coordinates(current.getX() + 1, current.getY()), totalSpecialEncountered);
            }

            if( current.getY() + 1 < field[0].length){
                traverseIt(new Coordinates(current.getX(), current.getY() + 1), totalSpecialEncountered);
            }
        }
    }


    public static class Coordinates{
        private final int x;
        private final int y;

        public Coordinates(int x, int y){

            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Coordinates{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
