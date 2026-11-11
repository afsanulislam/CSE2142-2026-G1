import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Task 10 Update: rename method for getting all emp data 
    public static String getAllEmployees() throws IOException {
        // Task 5 Update
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE_PATH)));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    // Task 10 Update: method to save all data into file
    public static void saveAllEmployees(String data) throws IOException {
        // Task 5 Update
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE_PATH));
        writer.write(data);
        writer.close();
    }

    // Task 10 Update: method for adding new emplyee
    public static void addNewEmployee(String data) throws IOException {
        // Task 5 Update
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE_PATH, true));
        writer.write(data);
        writer.close();
    }

    public static void main(String[] args) {
        // Task 10 Update: cheking if user not give any argument
        if (args.length == 0) {
            System.out.println("Error: No arguments provided. Please provide a valid argument (e.g., l, s, +Name, ?Name, c, uName, dName).");
            return;
        }

        // Task 10 Update: taking the fast argument in a variable
        String userCmd = args[0];

        // Check arguments
        if (userCmd.equals("l")) {
            // Task 10 Update: this is loading oparetion for show all emp
            System.out.println("Loading data ...");
            try {
                // Task 6 Update
                for (String emp : getAllEmployees().split(",")) {
                    System.out.println(emp);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (userCmd.equals("s")) {
            // Task 10 Update: searching a random emplyee from file
            System.out.println("Loading data ...");
            try {
                String line = getAllEmployees();
                System.out.println(line);
                String[] employees = line.split(",");
                // Task 6 Update
                System.out.println(employees[new Random().nextInt(employees.length)]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (userCmd.contains("+")) {
            // Task 10 Update: add new emplye to the file
            System.out.println("Loading data ...");
            try {
                // Task 6 Update
                addNewEmployee(", " + userCmd.substring(1));
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (userCmd.contains("?")) {
            // Task 10 Update: find if a employe is exist or not
            System.out.println("Loading data ...");
            try {
                // Task 7 Update
                if (Arrays.asList(getAllEmployees().split(",")).contains(userCmd.substring(1))) {
                    System.out.println("Employee '" + userCmd.substring(1) + "' found!");
                } else {
                    System.out.println("Employee '" + userCmd.substring(1) + "' not found!");
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (userCmd.contains("c")) {
            // Task 10 Update: count how many words is in there
            System.out.println("Loading data ...");
            try {
                // Task 8 Update
                String text = getAllEmployees();
                System.out.println(text.split(",").length + " word(s) found " + text.length());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (userCmd.contains("u")) {
            // Task 10 Update: update a emplyee name to Updated
            System.out.println("Loading data ...");
            try {
                // Task 6 Update
                String[] employees = getAllEmployees().split(",");
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(userCmd.substring(1))) {
                        employees[i] = "Updated";
                    }
                }
                saveAllEmployees(String.join(",", employees));
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (userCmd.contains("d")) {
            // Task 10 Update: delet a employee form the list
            System.out.println("Loading data ...");
            try {
                // Task 6 Update
                List<String> employeeList = new ArrayList<>(Arrays.asList(getAllEmployees().split(",")));
                employeeList.remove(userCmd.substring(1));
                saveAllEmployees(String.join(",", employeeList));
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        } else {
            // Task 9 Update
            System.out.println("Error: Invalid argument '" + userCmd + "'. Please provide a valid argument.");
        }
    }
}