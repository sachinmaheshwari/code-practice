package javaconcepts;

/**
 * Created by Sachin Maheshwari on 8/6/2015.
 */
public class TryCatchFinally {


    static {
        System.out.println("hello world!");
    }

    public static  void main(String[] args) {
        boolean a = false;// local variable need to be initialized always.
        try {
            System.out.printf(""+ a);
            throw new Exception("");
        } catch (Exception e) {
            System.out.println("catch!");
            System.exit(0); // It will disable the execution of finally block.
        } finally {
            System.out.println("finally!");
        }
    }
}
