package recursions;

/**
 * User: sachin
 * Date: 01/08/15
 * Time: 1:21 PM
 */
public class TowerOfHanoi {

    public static void main(String[] args) {
        System.out.println("Solving tower of hanoi problem.");
        solve(3, "A", "C", "B");
    }

    private static void solve(int n, String source, String destination, String aux) {
        if(n == 1) {
            System.out.printf("Moving disc from %s to %s%n", source, destination);
        } else {
            solve(n-1, source, aux, destination);
            System.out.printf("Moving disc from %s to %s%n", source, destination);
            solve(n-1, aux, destination, source);
        }
    }

}
