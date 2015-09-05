package hacker.earth.ebay;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sachin Maheshwari on 8/30/2015.
 */
public class SolarPower {

    private static BigInteger[][] square;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfDays = scanner.nextInt();
        for (int i = 0; i < numOfDays; i++) {
            int sizeOfSquare = scanner.nextInt();
            int initialPower = scanner.nextInt();
            int numberOfActions = scanner.nextInt();
            List<Actions> actionsList = new ArrayList<>();
            for (int j = 0; j < numberOfActions; j++) {
                String action = scanner.next();
                if(action.startsWith("m")){
                    actionsList.add(new Measure(scanner.nextInt()-1, scanner.nextInt()-1, scanner.nextInt()-1, scanner.nextInt()-1));
                } else {
                    actionsList.add(new SetRotation(scanner.nextInt()-1, scanner.nextInt()-1, scanner.nextBigInteger()));
                }
            }
            new SolarPower().findSolutionForDay(sizeOfSquare, initialPower, actionsList);
        }
    }


    public void findSolutionForDay(int sizeOfSquare, int initialPower, List<Actions> actionsList){

        // Create initial square
        square = new BigInteger[sizeOfSquare][sizeOfSquare];
        for (int i = 0; i < square.length; i++) {
            BigInteger[] bigIntegers = square[i];
            Arrays.fill(bigIntegers, new BigInteger(String.valueOf(initialPower)));
        }

        for(Actions action: actionsList){
            action.doIt();
        }
    }


    static abstract class Actions {
        public abstract void doIt();

    }


    static class Measure extends Actions{

        private final int x1;
        private final int x2;
        private final int y1;
        private final int y2;

        Measure(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }


        @Override
        public void doIt() {
            // Measure it
            BigInteger totalPower = new BigInteger("0");
            int xMin = x1 < x2? x1: x2;
            int xMax = x1 > x2? x1: x2;
            int yMin = y1 < y2? y1 : y2;
            int yMax = y1 > y2? y1 : y2;
            for (int i = xMin; i <= xMax; i++) {
                for (int j = yMin; j <= yMax; j++) {
                    totalPower = totalPower.add(square[i][j]);
                }
            }
            System.out.println(totalPower.toString());
        }


    }

    static class SetRotation extends Actions{

        private final int x;
        private final int y;
        private final BigInteger multiplyFactor;

        SetRotation(int x, int y, BigInteger multiplyFactor) {
            this.x = x;
            this.y = y;
            this.multiplyFactor = multiplyFactor;
        }

        @Override
        public void doIt() {
            // set the rotation
            square[x][y] = square[x][y].multiply(multiplyFactor);
        }
    }

}
