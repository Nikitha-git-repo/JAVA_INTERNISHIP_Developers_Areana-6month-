import java.io.*;
import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name.trim();
        this.phone = phone.trim();
        this.email = email.trim();
    }

    String toFileString() {
        return name + "," + phone + "," + email;
    }

    static Contact fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Contact(parts[0], parts[1], parts[2]);
        }
        return null;
    }

    void display() {
        System.out.println("Name: " + name + " | Phone: " + phone + " | Email: " + email);
    }
}

class ContactBook {
    final String FILE_NAME = "contacts.txt";

    void addContact(Contact c) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(c.toFileString());
            bw.newLine();
            System.out.println("Contact added.");
        } catch (IOException e) {
            System.out.println("Error saving contact.");
        }
    }

    List<Contact> readContacts() {
        List<Contact> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Contact c = Contact.fromFileString(line);
                if (c != null) list.add(c);
            }
        } catch (IOException e) {
            System.out.println("Error reading contacts.");
        }
        return list;
    }

    void listContacts() {
        List<Contact> list = readContacts();
        if (list.isEmpty()) {
            System.out.println("No contacts to show.");
        } else {
            System.out.println("\n--- Contact List ---");
            for (Contact c : list) {
                c.display();

                