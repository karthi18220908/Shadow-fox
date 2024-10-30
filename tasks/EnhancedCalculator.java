import java.util.Scanner;

public class EnhancedCalculator {

    // Basic Arithmetic Operations
    public static double performBasicArithmetic(int operation, double num1, double num2) {
        switch (operation) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is undefined.");
                    return 0;
                }
                return num1 / num2;
            default:
                System.out.println("Invalid operation.");
                return 0;
        }
    }

    // Scientific Calculations
    public static double performScientificOperation(int choice, double num1, double num2) {
        switch (choice) {
            case 1:
                if (num1 < 0) {
                    System.out.println("Error: Square root of a negative number is not real.");
                    return 0;
                }
                return Math.sqrt(num1);
            case 2:
                return Math.pow(num1, num2);
            default:
                System.out.println("Invalid scientific operation.");
                return 0;
        }
    }

    // Unit Conversion Methods
    public static double convertTemperature(int type, double temperature) {
        if (type == 1) {
            return (temperature * 9 / 5) + 32; // Celsius to Fahrenheit
        } else if (type == 2) {
            return (temperature - 32) * 5 / 9; // Fahrenheit to Celsius
        } else {
            System.out.println("Invalid conversion type.");
            return 0;
        }
    }

    public static double convertCurrency(int choice, double amount) {
        double conversionRate = 83.0; // Example rate
        if (choice == 1) {
            return amount * conversionRate; // USD to INR
        } else if (choice == 2) {
            return amount / conversionRate; // INR to USD
        } else {
            System.out.println("Invalid currency conversion.");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to the Enhanced Calculator!");

        while (isRunning) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Basic Arithmetic
                    System.out.println("Enter first number:");
                    double num1 = scanner.nextDouble();
                    System.out.println("Enter second number:");
                    double num2 = scanner.nextDouble();
                    System.out.println("Choose operation: 1-Add, 2-Subtract, 3-Multiply, 4-Divide");
                    int operation = scanner.nextInt();
                    double basicResult = performBasicArithmetic(operation, num1, num2);
                    System.out.println("Result: " + basicResult);
                    break;

                case 2: // Scientific Calculations
                    System.out.println("Choose operation: 1-Square Root, 2-Power");
                    int sciChoice = scanner.nextInt();
                    if (sciChoice == 1) {
                        System.out.println("Enter the number:");
                        double number = scanner.nextDouble();
                        System.out.println("Square Root: " + performScientificOperation(sciChoice, number, 0));
                    } else if (sciChoice == 2) {
                        System.out.println("Enter base:");
                        double base = scanner.nextDouble();
                        System.out.println("Enter exponent:");
                        double exponent = scanner.nextDouble();
                        System.out.println("Result: " + performScientificOperation(sciChoice, base, exponent));
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 3: // Unit Conversions
                    System.out.println("Choose conversion: 1-Temperature, 2-Currency");
                    int convChoice = scanner.nextInt();

                    if (convChoice == 1) {
                        System.out.println("Choose: 1-Celsius to Fahrenheit, 2-Fahrenheit to Celsius");
                        int tempChoice = scanner.nextInt();
                        System.out.println("Enter the temperature:");
                        double temperature = scanner.nextDouble();
                        System.out.println("Converted Temperature: " + convertTemperature(tempChoice, temperature));
                    } else if (convChoice == 2) {
                        System.out.println("Choose: 1-USD to INR, 2-INR to USD");
                        int currencyChoice = scanner.nextInt();
                        System.out.println("Enter the amount:");
                        double amount = scanner.nextDouble();
                        System.out.println("Converted Currency: " + convertCurrency(currencyChoice, amount));
                    } else {
                        System.out.println("Invalid conversion.");
                    }
                    break;

                case 4: // Exit
                    isRunning = false;
                    System.out.println("Exiting the calculator. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
