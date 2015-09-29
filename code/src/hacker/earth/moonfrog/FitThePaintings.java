package hacker.earth.moonfrog;

import java.util.Scanner;

/**
 * Created by Sachin Maheshwari on 9/20/2015.
 */
public class FitThePaintings {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        System.out.println(new FitThePaintings().findSolution(n, m , a , b, c, d)? "Yes" : "No");
    }


    public boolean findSolution(int n, int m, int a, int b, int c, int d) {

        //
        Rectangle box = new Rectangle(n, m);
        Rectangle paintingA = new Rectangle(a, b);
        Rectangle paintingB = new Rectangle(c, d);

        if(box.getArea() < paintingA.getArea() + paintingB.getArea()){
            // Not possible to fit
            return false;
        }

        return isPossibleToFitThem(box, paintingA, paintingB);


    }

    private boolean isPossibleToFitThem(Rectangle box, Rectangle paintingA, Rectangle paintingB) {
        if(itFitsForWidth(box, paintingA, paintingB)){
            return true;
        } else if(itFitsForWidth(new Rectangle(box.getWidth(), box.getLength()), paintingA, paintingB)){
           return true;
        }
        return false;
    }

    private boolean itFitsForWidth(Rectangle box, Rectangle paintingA, Rectangle paintingB) {
        if(box.getWidth() >= paintingA.getWidth() + paintingB.getWidth()){
            if(box.getLength() >= paintingA.getLength() && box.getLength() >= paintingB.getLength()){
                return true;
            }
        }

        if(box.getWidth() >= paintingA.getLength() + paintingB.getLength()){
            if(box.getLength() >= paintingA.getWidth() && box.getLength() >= paintingB.getWidth()){
                return true;
            }
        }

        if(box.getWidth() >= paintingA.getWidth() + paintingB.getLength()){
            if(box.getLength() >= paintingA.getLength()  && box.getLength() >= paintingB.getWidth()){
                return true;
            }
        }

        if(box.getWidth() >= paintingA.getLength() + paintingB.getWidth()){
            if(box.getLength() >= paintingA.getWidth() && box.getLength() >= paintingB.getLength()){
                return true;
            }
        }

        return false;
    }

    public static class Rectangle{
        public int getLength() {
            return length;
        }

        public int getWidth() {
            return width;
        }

        private final int length;
        private final int width;

        public Rectangle(int length, int width){

            this.length = length;
            this.width = width;
        }

        public int getArea(){
            return length*width;
        }
    }

}
