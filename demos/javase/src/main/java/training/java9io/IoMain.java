package training.java9io;

import java.io.*;
import java.util.Scanner;

public class IoMain {

    public static void main(String[] args) {
        new Scanner("jack,john,jane").useDelimiter(",")
                .tokens().forEach(System.out::println);

        new Scanner("jack,JOHN,jane")
                .findAll("[a-z]+")
                .map(result -> result.group(0))
                .forEach(System.out::println);

        try {
            byte[] bytes = IoMain.class.getResourceAsStream("/employees.txt").readAllBytes();
            String value = new String(bytes);
            System.out.println(value);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        try {
            InputStream is = IoMain.class.getResourceAsStream("/employees.txt");
            OutputStream os = new BufferedOutputStream(new FileOutputStream("emps.txt"));
            is.transferTo(os);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not transfer", ioe);
        }
    }
}
