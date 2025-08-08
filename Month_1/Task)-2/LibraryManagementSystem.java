import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isBorrowed;

    Book(String t, String a) {
        title = t;
        author = a;
        isBorrowed = false;
    }

    void display() {
        System.out.println(title + " by " + author + (isBorrowed ? " [Borrowed]" : " [Available]"));
    }

    void borrow() {
        isBorrowed = true;
    }

    void returnBook() {
        isBorrowed = false;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n--- Simple Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    books[count] = new Book(title, author);
                    count++;
                    System.out.println("Book added!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No books in library.");
                    } else {
                        System.out.println("\nList of Books:");
                        for (int i = 0; i < count; i++) {
                            books[i].display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter title to borrow: ");
                    String bTitle = sc.nextLine();
                    boolean foundBorrow = false;
                    for (int i = 0; i < count; i++) {
                        if (books[i].title.equalsIgnoreCase(bTitle)) {
                            if (!books[i].isBorrowed) {
                                books[i].borrow();
                                System.out.println("Book borrowed.");
                            } else {
                                System.out.println("Book already borrowed.");
                            }
                            foundBorrow = true;
                            break;
                        }
                    }
                    if (!foundBorrow) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter title to return: ");
                    String rTitle = sc.nextLine();
                    boolean foundReturn = false;
                    for (int i = 0; i < count; i++) {
                        if (books[i].title.equalsIgnoreCase(rTitle)) {
                            if (books[i].isBorrowed) {
                                books[i].returnBook();
                                System.out.println("Book returned.");
                            } else {
                                System.out.println("This book was not borrowed.");
                            }
                            foundReturn = true;
                            break;
                        }
                    }
                    if (!foundReturn) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 0:
                    System.out.println("Thank you! Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
