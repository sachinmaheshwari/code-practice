package hacker.earth.ebay;

import java.util.Vector; /* Line 2 */
 class MyVector extends Vector
{
    int i = 1; /* Line 5 */
    public MyVector()
    {
        i = 2;
    }
}

public class Test extends MyVector
{
    public Test()
    {
        i = 4; /* Line 15 */
    }
    public static void main (String args [])
    {
        MyVector v = new Test(); /* Line 19 */
    }
}