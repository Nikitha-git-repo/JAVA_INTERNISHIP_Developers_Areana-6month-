import java.io.*;
import java.util.Scanner;

public class ContactBook {

    private static final String FILE_NAME = "contacts.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--------------------");
            System.out.println("| Contact Book Menu |");
            System.out.println("|  1. Add Contact   |");
            System.out.println("|  2. View Contacts |");
            System.out.println("|  3. Exit          |");
            System.out.println("--------------------");
            System.out.print("\nEnter choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    System.out.println("\nExiting Contact Book. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void addContact(Scanner scanner) {
        try {
            System.out.print("\nEnter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            FileWriter writer = new FileWriter(FILE_NAME, true); 
            writer.write("Name: " + name + ", Phone: " + phone + ", Email: " + email + "\n");
            writer.close();

            System.out.println("\nContact saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewContacts() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("\nNo contacts found.");
                return;
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\nContact List :\n");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("\nError reading from file: " + e.getMessage());
        }
    }
}