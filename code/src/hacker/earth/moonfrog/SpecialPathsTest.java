package hacker.earth.moonfrog;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Sachin Maheshwari on 9/20/2015.
 */
public class SpecialPathsTest {

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testFindSolution() throws Exception {
        SpecialPaths.Coordinates[] coordinates = new SpecialPaths.Coordinates[2];
        coordinates[0] = new SpecialPaths.Coordinates(2,2);
        coordinates[1] = new SpecialPaths.Coordinates(3,2);

        SpecialPaths solution = new SpecialPaths(100, 100, 2, coordinates);
        Assert.assertEquals(solution.findSolution(), new int[]{1,3,2});
    }
}