import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Method to read data from the file
    public static String readEmployees() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("employees.txt")));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    // Method to write data to the file (overwrite)
    public static void writeEmployees(String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("employees.txt"));
        writer.write(data);
        writer.close();
    }

    // Method to append data to the file
    public static void appendEmployee(String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("employees.txt", true));
        writer.write(data);
        writer.close();
    }

    public static void main(String[] args) {
        // Add a check at the beginning to ensure the correct number of arguments
        if (args.length == 0) {
            System.out.println("Error: No arguments provided. Please provide a valid argument (e.g., l, s, +Name, ?Name).");
            return;
        }

        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String line = readEmployees();
                String[] employees = line.split(",");
                for (String emp : employees) {
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
                Random rand = new Random();
                int idx = rand.nextInt(employees.length);
                System.out.println(employees[idx]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String newEmployee = args[0].substring(1);
                appendEmployee(", " + newEmployee);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String line = readEmployees();
                String[] employees = line.split(",");
                boolean found = false;
                String targetName = args[0].substring(1);
                for (int i = 0; i < employees.length && !found; i++) {
                    if (employees[i].equals(targetName)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String line = readEmployees();
                char[] chars = line.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char character : chars) {
                    if (character == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String line = readEmployees();
                String[] employees = line.split(",");
                String targetToUpdate = args[0].substring(1);
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(targetToUpdate)) {
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
                String line = readEmployees();
                String[] employees = line.split(",");
                String targetToDelete = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(targetToDelete);
                writeEmployees(String.join(",", employeeList));
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}

