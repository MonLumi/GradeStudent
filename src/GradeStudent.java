import java.text.DecimalFormat;
import java.util.Scanner;

public class GradeStudent {
    static Scanner input = new Scanner(System.in);
    static DecimalFormat formated = new DecimalFormat("0.0");
    static int totalWeight = 100;
    static double midScore;
    static double finalScore;
    static double homeworkScore;
    static double overall;

    public static void main(String[] args) {
        begin();
        System.out.println();
        midterm();
        System.out.println();
        finalterm();
        System.out.println();
        homework();
        System.out.println();
        report();
    }

    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

    public static int shiftPoint() {
        System.out.print("Shift amount? ");
        return input.nextInt();
    }

    public static double termCal() {
        // Weight
        System.out.print("Weight (0-100)? ");
        int weight = input.nextInt();
        totalWeight -= weight;
        // Score
        System.out.print("Score earned? ");
        int point = input.nextInt();
        // Shifted bonus
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        boolean isShifted = input.nextInt() == 1;
        if (isShifted) {
            point += shiftPoint();
        }
        point = Math.min(point, 100);
        // Total
        System.out.println("Total points = " + point + " / 100");
        double weightScore = (double) point/100 * weight;
        System.out.println("Weighted score = " + formated.format(weightScore) + " / " + weight);
        return weightScore;
    }

    public static void midterm () {
        System.out.println("Midterm: ");
        midScore = termCal();
    }

    public static void finalterm () {
        System.out.println("Final: ");
        finalScore = termCal();
    }

    public static void homework () {
        System.out.println("Homework: ");
        System.out.print("Weight (0-100)? ");
        input.nextInt();

        System.out.print("Number of assignments? ");
        int assignNumber = input.nextInt();
        int assignScore = 0;
        int assignMaxScore = 0;
        for (int i = 1; i <= assignNumber; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            assignScore += input.nextInt();
            assignMaxScore += input.nextInt();
        }
        assignScore = Math.min(assignScore, 150);
        assignMaxScore = Math.min(assignMaxScore, 150);

        System.out.print("How many sections did you attend? ");
        int sectionAttended = input.nextInt();
        int sectionPoint = (sectionAttended>6) ? 30 : sectionAttended*5;
        System.out.println("Section points = " + sectionPoint + " / 30");
        int homeworkPoints = assignScore + sectionPoint;
        int homeworkMaxPoints = assignMaxScore + 30;
        System.out.println("Total points = " + homeworkPoints + " / " + homeworkMaxPoints);

        homeworkScore = (double) homeworkPoints/homeworkMaxPoints*totalWeight;
        System.out.println("Weighted score = "+ homeworkScore + " / " + totalWeight);
    }

    public static void report() {
        overall = homeworkScore + midScore + finalScore;
        System.out.println("Overall = " + formated.format(overall));
        System.out.println("Your grade will be at least: 3.0");
        System.out.print("Your grade: ");
        if (overall < 60) {
            System.out.println(0.0);
            System.out.println("You need to review your learning attitude!");
        } else if (overall < 74.99) {
            System.out.println(0.7);
            System.out.println("You have to learn again!");
        } else if (overall < 84.99) {
            System.out.println(2.0);
            System.out.println("You need more improvement!");
        } else if (overall < 93) {
            System.out.println(3.0);
            System.out.println("Good!");
        } else {
            System.out.println(4.0);
            System.out.println("Excellent!");
        }
    }
}
