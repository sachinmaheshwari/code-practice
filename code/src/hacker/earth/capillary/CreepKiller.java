package hacker.earth.capillary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sachin Maheshwari on 8/30/2015.
 */
public class CreepKiller {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int sunStrikeCost = scanner.nextInt();
        int tornadoCost = scanner.nextInt();
        int tornadoLength = scanner.nextInt();
        int totalCreepers = scanner.nextInt();
        Integer[] creepersLocation = new Integer[totalCreepers];

        for (int i = 0; i < totalCreepers; i++) {
            creepersLocation[i] = scanner.nextInt();
        }

        System.out.println(findMinimumManaRequired(sunStrikeCost, tornadoCost, tornadoLength, creepersLocation));

//        System.out.println(findMinimumManaRequired(2, 3, 3, new Integer[]{1,3, 5}));
    }

    private static int findMinimumManaRequired(int sunStrikeCost, int tornadoCost, int tornadoLength, Integer[] creepersLocations) {

        int minimumByGreedyApproach = findMinimumByGreedyApproach(sunStrikeCost, tornadoCost, tornadoLength, creepersLocations);
        int minimumWithTornadoPreferred = findMinimumWithTornadoPreferred(sunStrikeCost, tornadoCost, tornadoLength, creepersLocations);
        return Math.min(minimumByGreedyApproach, minimumWithTornadoPreferred);


    }

    private static int findMinimumWithTornadoPreferred( int sunStrikeCost,  int tornadoCost,  int tornadoLength,  Integer[] creepersLocations) {
        int totalCost = 0;
        for (int i = 0; i < creepersLocations.length; i++) {

            if(i+tornadoLength -1 < creepersLocations.length){
                if(creepersLocations[i+tornadoLength -1] - creepersLocations[i] + 1 == tornadoLength){
                    // maximum found
                    totalCost+=tornadoCost;
                    for (int j = i; j < i + tornadoCost - 1 && j < creepersLocations.length; j++) {
                        creepersLocations[j] = 0;
                    }
                    i += tornadoLength;
                }
            }

        }

        List<Integer> lstOfCreepersLocation = new ArrayList<>();
        for (int i = 0; i < creepersLocations.length; i++) {
          if(creepersLocations[i] > 0){
              lstOfCreepersLocation.add(creepersLocations[i]);
          }
        }

        if(lstOfCreepersLocation.size() == 0){
            return totalCost;
        } else
            return totalCost + findMinimumByGreedyApproach(sunStrikeCost, tornadoCost, tornadoLength, lstOfCreepersLocation.toArray(new Integer[lstOfCreepersLocation.size()]));
    }

    private static int findMinimumByGreedyApproach(final int sunStrikeCost, final int tornadoCost, final int tornadoLength, final Integer[] creepersLocations) {
        // Greedy Approach for every point consider the cost and go with the minimum
        int totalCost =0;
        for (int i = 0; i < creepersLocations.length; i++) {

            //try with tornado first
            int creepersTerminated = 1;
            while (true){
                if(i + creepersTerminated < creepersLocations.length){
                   int distanceBetweenNextCreeper = creepersLocations[i + creepersTerminated] - creepersLocations[i] + 1;
                   if(distanceBetweenNextCreeper <= tornadoLength){
                       creepersTerminated++;
                   } else {
                       //tornado will not cover it.
                       break;
                   }
                } else {
                    // we have reached the end time to break
                    break;
                }
            }


            // try with sunStrike
            int costByUsingSunStrike = creepersTerminated * sunStrikeCost;

            // find which one will be minimum if its sunstrike just add the cost if its tornado then increase i counter by the creepers terminated.
            i=i+creepersTerminated - 1;

            if(costByUsingSunStrike > tornadoCost){
                totalCost+=tornadoCost;
            } else {
                totalCost+=costByUsingSunStrike;
            }

        }


        return totalCost;
    }
}
