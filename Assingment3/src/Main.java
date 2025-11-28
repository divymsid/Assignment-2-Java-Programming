import java.util.*;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

class Student {
    private int rollNumber;
    private String studentName;
    private int[] marks = new int[3];

    public Student(int rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i + 1) + ": " + marks[i]);
            }
        }
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    public void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.print("Marks: ");
        for (int m : marks) System.out.print(m + " ");
        System.out.println();
        double avg = calculateAverage();
        System.out.println("Average: " + avg);
        System.out.println("Result: " + (avg >= 40 ? "Pass" : "Fail"));
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

class ResultManager {
    Student[] students = new Student[100];
    int count = 0;

    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }
            Student s = new Student(roll, name, marks);
            s.validateMarks();
            students[count++] = s;
            System.out.println("Student added successfully.");
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error occurred.");
        }
    }

    public void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int roll = sc.nextInt();
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (students[i].getRollNumber() == roll) {
                    students[i].displayResult();
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Error occurred.");
        }
    }

    public void mainMenu() {
        try {
            while (true) {
                System.out.println("===== Student Result Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Show Student Details");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                if (choice == 1) addStudent();
                else if (choice == 2) showStudentDetails();
                else if (choice == 3) {
                    System.out.println("Exiting program. Thank you!");
                    break;
                } else System.out.println("Invalid choice.");
            }
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) {
        new ResultManager().mainMenu();
    }
}
