import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Sachin Maheshwari on 8/27/2015.
 */
public class A {

    final int a;
    final int b;

    public A(int a, int b){
        this.a = a;
        this.b = b;
    }

    public static void doX(){
        System.out.println("from a");
    }

    public static void main(String[] args) {

        HashMap<A, String> map = new HashMap<>();
        A key = new A(1, 2);
        map.put(key, "mil gaya 1, 2");
        System.out.println(map.get(key));
    }


    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a1 = (A) o;
        return Objects.equals(a, a1.a) &&
                Objects.equals(b, a1.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
