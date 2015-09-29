package adobe;


public class Solution {

    static int a = 1;
    private static int value = 1;

    public static void main(String[] args) {


        Thread th = new Thread(){

            @Override
            public void run() {
                try {
                    Thread.sleep(10000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Thread");
            }
        };

        th.run();

        System.out.println("Main");

        int x = 012;

        if(x == 10){
            System.out.println("yes");
        }

        System.out.println(getValue());
        System.out.println(value);
    }

    public static int getValue() {
        try{
           value+=1;
          return value;
        } finally {
            value+=1;
        }
    }
}
