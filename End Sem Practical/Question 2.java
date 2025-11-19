import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Compile time:");
        try {
            FileReader fr = new FileReader("abc.txt");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        System.out.println("Run time:");
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
