package hacker.earth.ebay;

import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Sachin Maheshwari on 8/30/2015.
 */
public class PairCounterTest {

    @org.testng.annotations.Test
    public void testGetPairCount() throws Exception {
        List<PairCounter.Pairs> lstOfPairs = new ArrayList<>();
        lstOfPairs.add(new PairCounter.Pairs(1, 2));
        lstOfPairs.add(new PairCounter.Pairs(1,3));
        lstOfPairs.add(new PairCounter.Pairs(1,4));
        Assert.assertEquals(new PairCounter().getPairCount(new BigInteger("3"), lstOfPairs), 2);
    }


    @org.testng.annotations.Test
    public void testGetPairCountWithHierarchicalParents() throws Exception {
        List<PairCounter.Pairs> lstOfPairs = new ArrayList<>();
        lstOfPairs.add(new PairCounter.Pairs(1, 5));
        lstOfPairs.add(new PairCounter.Pairs(5,3));
        lstOfPairs.add(new PairCounter.Pairs(5,2));
        lstOfPairs.add(new PairCounter.Pairs(5,4));
        Assert.assertEquals(new PairCounter().getPairCount(new BigInteger("3"), lstOfPairs), 2);
    }
}