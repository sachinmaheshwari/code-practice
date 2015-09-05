package hacker.earth.ebay;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Sachin Maheshwari on 8/30/2015.
 */
public class PairCounter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfPairs = scanner.nextInt();
        BigInteger productOfPairs = scanner.nextBigInteger();
        List<Pairs> lstOfPairs = new ArrayList<>();
        for (int i = 1; i < numberOfPairs; i++) {
           lstOfPairs.add(new Pairs(scanner.nextInt(), scanner.nextInt()));
        }
        System.out.println(new PairCounter().getPairCount(productOfPairs, lstOfPairs));
    }


    public int getPairCount(BigInteger productOfPairs, List<Pairs> pairsList){
        int numOfPairsFound = 0;

        HashMap<BigInteger, List<BigInteger>> mapOfNodes = new HashMap<>();
        // Create a hierarchy
        for (Iterator<Pairs> iterator = pairsList.iterator(); iterator.hasNext(); ) {
            Pairs pairs = iterator.next();
            if(mapOfNodes.get(pairs.getParent()) == null){
                ArrayList<BigInteger> listOfChildren = new ArrayList<>();
                listOfChildren.add(pairs.getChild());
                mapOfNodes.put(pairs.getParent(), listOfChildren);
            } else {
                mapOfNodes.get(pairs.getParent()).add(pairs.getChild());
            }
        }

        for(Map.Entry<BigInteger, List<BigInteger>> entry : mapOfNodes.entrySet()){
            BigInteger parent = entry.getKey();
            List<BigInteger> listOfChildren = entry.getValue();
            numOfPairsFound += countAllPairs(parent, listOfChildren, mapOfNodes, productOfPairs);
        }

        return numOfPairsFound;
    }

    private int countAllPairs(BigInteger parent, List<BigInteger> listOfChildren, HashMap<BigInteger, List<BigInteger>> mapOfNodes, BigInteger productOfPairs) {
        int pairsFound = 0;
        for(BigInteger child : listOfChildren){
            if (parent.multiply(child).compareTo(productOfPairs) <= 0) {
                pairsFound++;
            }

            if(mapOfNodes.containsKey(child)){
                pairsFound += countAllPairs(parent, mapOfNodes.get(child), mapOfNodes, productOfPairs);
            }
        }

        return pairsFound;
    }

    static class Pairs {
        private final BigInteger parent;
        private final BigInteger child;

        Pairs(int parent, int child) {
            this.parent = new BigInteger(String.valueOf(parent));
            this.child = new BigInteger(String.valueOf(child));
        }

        public BigInteger getParent() {
            return parent;
        }

        public BigInteger getChild() {
            return child;
        }
    }

}
