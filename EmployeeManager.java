import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Method to read data from the file
    public static String readEmployees() throws IOException {
        // Task 5 Update
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE_PATH)));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    // Method to write data to the file (overwrite)
    public static void writeEmployees(String data) throws IOException {
        // Task 5 Update
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE_PATH));
        writer.write(data);
        writer.close();
    }

    // Method to append data to the file
    public static void appendEmployee(String data) throws IOException {
        // Task 5 Update
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE_PATH, true));
        writer.write(data);
        writer.close();
    }

    public static void main(String[] args) {
        // Add a check at the beginning to ensure the correct number of arguments
        if (args.length == 0) {
            System.out.println("Error: No arguments provided. Please provide a valid argument (e.g., l, s, +Name, ?Name, c, uName, dName).");
            return;
        }

        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                // Task 6 Update
                for (String emp : readEmployees().split(",")) {
                    System.out.println(emp);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String line = readEmployees();
                System.out.println(line);
                String[] employees = line.split(",");
                // Task 6 Update
                System.out.println(employees[new Random().nextInt(employees.length)]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                // Task 6 Update
                appendEmployee(", " + args[0].substring(1));
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                // Task 7 Update
                if (Arrays.asList(readEmployees().split(",")).contains(args[0].substring(1))) {
                    System.out.println("Employee '" + args[0].substring(1) + "' found!");
                } else {
                    System.out.println("Employee '" + args[0].substring(1) + "' not found!");
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                // Task 8 Update
                String text = readEmployees();
                System.out.println(text.split(",").length + " word(s) found " + text.length());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                // Task 6 Update
                String[] employees = readEmployees().split(",");
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(args[0].substring(1))) {
                        employees[i] = "Updated";
                    }
                }
                writeEmployees(String.join(",", employees));
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                // Task 6 Update
                List<String> employeeList = new ArrayList<>(Arrays.asList(readEmployees().split(",")));
                employeeList.remove(args[0].substring(1));
                writeEmployees(String.join(",", employeeList));
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        } else {
            // Task 9 Update
            System.out.println("Error: Invalid argument '" + args[0] + "'. Please provide a valid argument.");
        }
    }
}