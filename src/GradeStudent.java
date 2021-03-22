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
        point = (point > 100) ? 100 : point;
        // Total
        System.out.println("Total points = " + point + " / 100");
        double weightScore = (double) point/weight;
        System.out.println("Weighted score = " + weightScore + " / " + weight);
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
        System.out.println("Weight = " + totalWeight);

        System.out.print("Number of assignments? ");
        int assignNumber = input.nextInt();
        int assignScore = 0;
        int assignMaxScore = 0;
        for (int i = 1; i <= assignNumber; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            assignScore += input.nextInt();
            assignMaxScore += input.nextInt();
        }
        assignScore = (assignScore>150) ? 150 : assignScore;
        assignMaxScore = (assignMaxScore>150) ? 150 : assignMaxScore;

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

    }
}
