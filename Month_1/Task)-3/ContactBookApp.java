import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String n, String p, String e) {
        name = n;
        phone = p;
        email = e;
    }

    void display() {
        System.out.println("Name: " + name + ", Phone: " + phone + ", Email: " + email);
    }
}

public class ContactBookApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contact[] contacts = new Contact[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n--- Contact Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. List All Contacts");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    contacts[count] = new Contact(name, phone, email);
                    count++;
                    System.out.println("Contact added.");
                    break;

                case 2:
                    System.out.print("Enter name to delete: ");
                    String nameToDelete = sc.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < count; i++) {
                        if (contacts[i].name.equalsIgnoreCase(nameToDelete)) {
                            for (int j = i; j < count - 1; j++) {
                                contacts[j] = contacts[j + 1];
                            }
                            count--;
                            deleted = true;
                            System.out.println("Contact deleted.");
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (contacts[i].name.equalsIgnoreCase(nameToSearch)) {
                            System.out.println("Contact found:");
                            contacts[i].display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No contacts to show.");
                    } else {
                        System.out.println("\n--- Contact List ---");
                        for (int i = 0; i < count; i++) {
                            contacts[i].display();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting Contact Book...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
