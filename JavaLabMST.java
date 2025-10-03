import java.util.*;

class EmptyStudentListException extends Exception {
    EmptyStudentListException(String msg) { super(msg); }
}

public class JavaLabMST {
    static ArrayList<String> studentList = new ArrayList<>();

    static void addStudent(String name) {
        studentList.add(name);
        System.out.println(name + " added successfully.");
    }

    static void removeStudent(String name) {
        if (studentList.remove(name))
            System.out.println(name + " removed successfully.");
        else
            System.out.println("Name not found!");
    }

    static void displayStudents() throws EmptyStudentListException {
        if (studentList.isEmpty())
            throw new EmptyStudentListException("Error: Student list is empty!");
        Collections.sort(studentList);
        System.out.println("Sorted names: " + String.join(", ", studentList));
    }

    static void calculateAverage(Scanner sc) {
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Enter numbers (type 'done' to finish):");
        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done")) break;
            try {
                nums.add(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }
        try {
            if (nums.isEmpty())
                throw new ArithmeticException("Error: List is empty! Cannot calculate average.");
            int sum = 0;
            for (int n : nums) sum += n;
            double avg = (double) sum / nums.size();
            System.out.println("Average: " + avg);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Calculate Average");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt(); sc.nextLine();
            try {
                switch (ch) {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        addStudent(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Enter name: ");
                        removeStudent(sc.nextLine());
                    }
                    case 3 -> displayStudents();
                    case 4 -> calculateAverage(sc);
                    case 5 -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (ch != 5);
        sc.close();
    }
}