import java.util.Scanner;

class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    public double add(double x, double y) {
        return x + y;
    }

    public int add(int x, int y, int z) {
        return x + y + z;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }

    public double divide(int x, int y) {
        try {
            if (y == 0) {
                throw new ArithmeticException("Division by zero is not allowed!");
            }
            return (double) x / y;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Calculator calculator = new Calculator();

    public void performAddition() {
        System.out.println("Choose type of addition:");
        System.out.println("1. Add two integers");
        System.out.println("2. Add two doubles");
        System.out.println("3. Add three integers");
        System.out.print("Enter choice: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.print("Enter two integers: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.println("Result: " + calculator.add(x, y));
            }
            case 2 -> {
                System.out.print("Enter two double values: ");
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                System.out.println("Result: " + calculator.add(x, y));
            }
            case 3 -> {
                System.out.print("Enter three integers: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                System.out.println("Result: " + calculator.add(x, y, z));
            }
            default -> System.out.println("Invalid option!");
        }
    }

    public void performSubtraction() {
        System.out.print("Enter two integers: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("Result: " + calculator.subtract(x, y));
    }

    public void performMultiplication() {
        System.out.print("Enter two double values: ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        System.out.println("Result: " + calculator.multiply(x, y));
    }

    public void performDivision() {
        System.out.print("Enter two integers: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double result = calculator.divide(x, y);
        System.out.println("Result: " + result);
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> performAddition();
                case 2 -> performSubtraction();
                case 3 -> performMultiplication();
                case 4 -> performDivision();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }
}

class CalculatorApplication {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}