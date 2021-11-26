package training.java9lang;

import java.util.Scanner;

public class EmployeeReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(EmployeeReader.class.getResourceAsStream("/employees.txt"));
        try (scanner) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }
}
