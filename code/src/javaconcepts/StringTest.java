package javaconcepts;

import java.io.Externalizable;
import java.io.Serializable;

/**
 * Created by Sachin Maheshwari on 8/6/2015.
 */
public class StringTest implements Serializable {

    public static void main(String[] args) {
        String s = new String("sachin"); // it will create 2 string objects one in pool and one in heap
        String s1 = "sachin";

        System.out.println(s == s1);
        System.out.println(s.equals(s1));
        s = "sachin"; // Now it will point to pool object
        System.out.println(s == s1);

    }


}
