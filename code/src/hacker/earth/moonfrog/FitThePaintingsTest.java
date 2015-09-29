package hacker.earth.moonfrog;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Sachin Maheshwari on 9/20/2015.
 */
public class FitThePaintingsTest {

    private FitThePaintings solution;

    @BeforeMethod
    public void setUp() throws Exception {
        solution = new FitThePaintings();
    }

    @Test(dataProvider = "testCases")
    public void testSolution(int n, int m, int a, int b, int c, int d, boolean expectedSolution){
        Assert.assertEquals(solution.findSolution(n, m, a, b, c, d), expectedSolution);
    }

    @DataProvider
    public Object[][] testCases(){
       return new Object[][]{
               {3, 2, 1, 3, 2, 1, true},
               {3, 2, 1, 2, 2, 2, true},
               {3, 2, 1, 3, 2, 3, false},
               {3, 2, 1, 3, 1, 3, true},
               {3, 2, 3, 1, 1, 3, true},
               {3, 2, 4, 1, 1, 3, false},
               {2, 2, 2, 2, 2, 2, false},
               {2, 2, 2, 1, 2, 1, true},
               {2, 2, 1, 1, 1, 1, true},



       };
    }
}