import java.util.Scanner;

public class GradeStudent {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

    public static int getAssignScore() {

    }

    public static int getAssignMax() {

    }

    public static double midterm () {
        System.out.println("Midterm: ");
        System.out.print("Weight (0-100)? ");
        int midWeigt = input.nextInt();
        System.out.print("Score earned? ");
        int midScore = input.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        boolean isShifted = (input.nextInt() == 1) ? true : false;
    }

    public static double finalterm () {

    }

    public static double homework () {

    }

    public static void report() {
        
    }
}
