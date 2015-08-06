package javaconcepts;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.HashMap;

/**
 * Created by Sachin Maheshwari on 8/6/2015.
 */
public class HashmapTesting {

    private int data;
    public static void main(String[] args) {
        HashmapTesting testing = new HashmapTesting();


        HashMap<HashmapTesting, String> map = new HashMap<>();
        map.put(testing, "somedATA");
        HashmapTesting testing1 = new HashmapTesting();
        map.put(testing1, "otherdata");

        System.out.println(map.get(testing));
        System.out.println(map.get(testing1));
    }
}
