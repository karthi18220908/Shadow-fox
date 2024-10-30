import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a contact entry
class ContactEntry {
    private String name;
    private String phone;
    private String email;

    public ContactEntry(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManagementApp {
    private static ArrayList<ContactEntry> contactList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean runApp = true;
        System.out.println("Welcome to the Contact Management Application!");

        while (runApp) {
            displayMenu();
            int userChoice = input.nextInt();
            input.nextLine();  // Consume newline

            switch (userChoice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    listAllContacts();
                    break;
                case 3:
                    modifyExistingContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    runApp = false;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the main menu
    private static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add a Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Update a Contact");
        System.out.println("4. Delete a Contact");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    // Add a new contact
    private static void addNewContact() {
        System.out.print("Enter Contact Name: ");
        String name = input.nextLine();
        
        String phone;
        do {
            System.out.print("Enter 10-digit Phone Number: ");
            phone = input.nextLine();
            if (!validatePhoneNumber(phone)) {
                System.out.println("Invalid phone number. Please enter a valid 10-digit phone number.");
            }
        } while (!validatePhoneNumber(phone));
        
        String email;
        do {
            System.out.print("Enter Email (must end with '@gmail.com'): ");
            email = input.nextLine();
            if (!validateEmail(email)) {
                System.out.println("Invalid email. Please ensure it ends with '@gmail.com'.");
            }
        } while (!validateEmail(email));

        contactList.add(new ContactEntry(name, phone, email));
        System.out.println("Contact successfully added.");
    }

    // Display all contacts
    private static void listAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("\nAll Contacts:");
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println((i + 1) + ". " + contactList.get(i));
            }
        }
    }

    // Update an existing contact
    private static void modifyExistingContact() {
        listAllContacts();
        if (!contactList.isEmpty()) {
            System.out.print("Enter the number of the contact to update: ");
            int index = input.nextInt();
            input.nextLine();  // Consume newline

            if (index >= 1 && index <= contactList.size()) {
                ContactEntry selectedContact = contactList.get(index - 1);
                
                System.out.print("Update Name (Current: " + selectedContact.getName() + "): ");
                String newName = input.nextLine();
                if (!newName.isEmpty()) {
                    selectedContact.setName(newName);
                }

                System.out.print("Update Phone Number (Current: " + selectedContact.getPhone() + "): ");
                String newPhone = input.nextLine();
                if (!newPhone.isEmpty() && validatePhoneNumber(newPhone)) {
                    selectedContact.setPhone(newPhone);
                } else if (!newPhone.isEmpty()) {
                    System.out.println("Invalid phone number. Keeping the current number.");
                }

                System.out.print("Update Email (Current: " + selectedContact.getEmail() + "): ");
                String newEmail = input.nextLine();
                if (!newEmail.isEmpty() && validateEmail(newEmail)) {
                    selectedContact.setEmail(newEmail);
                } else if (!newEmail.isEmpty()) {
                    System.out.println("Invalid email. Keeping the current email.");
                }

                System.out.println("Contact successfully updated.");
            } else {
                System.out.println("Invalid contact selection.");
            }
        }
    }

    // Delete a contact
    private static void removeContact() {
        listAllContacts();
        if (!contactList.isEmpty()) {
            System.out.print("Enter the number of the contact to delete: ");
            int index = input.nextInt();
            input.nextLine();  // Consume newline

            if (index >= 1 && index <= contactList.size()) {
                contactList.remove(index - 1);
                System.out.println("Contact successfully deleted.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }
    }

    // Phone number validation (must be exactly 10 digits)
    private static boolean validatePhoneNumber(String phone) {
        return phone.matches("\\d{10}");
    }

    // Email validation (must end with "@gmail.com")
    private static boolean validateEmail(String email) {
        return email.endsWith("@gmail.com");
    }
}
