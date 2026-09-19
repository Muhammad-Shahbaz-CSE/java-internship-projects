import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numSubjects = Integer.parseInt(sc.nextLine().trim());

        while (numSubjects <= 0) {
            System.out.print("Invalid! Enter number of subjects (must be > 0): ");
            numSubjects = Integer.parseInt(sc.nextLine().trim());
        }

        int[] marks = new int[numSubjects];

        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            int mark = -1;
            while (mark < 0 || mark > 100) {
                System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");
                mark = Integer.parseInt(sc.nextLine().trim());
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid marks! Must be between 0 and 100.");
                }
            }
            marks[i] = mark;
            totalMarks += mark; 
        }

        double percentage = (double) totalMarks / numSubjects;

        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n----- Student Report -----");
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("Subject %d: %d/100%n", (i + 1), marks[i]);
        }
        System.out.println("---------------------------");
        System.out.printf("Total Marks   : %d/%d%n", totalMarks, numSubjects * 100);
        System.out.printf("Percentage    : %.2f%%%n", percentage);
        System.out.printf("Grade         : %c%n", grade);
        System.out.println("---------------------------");

        sc.close();
    }
}
