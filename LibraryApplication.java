package ph.com.bpi.M2Project2;

import java.util.Scanner;

public class LibraryApplication {
	// Name of user
    private User user;
    // Library that stores books and loan
    private Library library;

    // Handles user input, initializes data, and displays the main menu.
    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        this.user = new User(name);

        // Create the library instance
        this.library = new Library();

        // Initialize books in the library
        library.addBook(new Book(1, "Java Basics", "Author A"), 0);
        library.addBook(new Book(2, "Advanced Java", "Author B"), 1);
        library.addBook(new Book(3, "OOP Concepts", "Author C"), 2);
        library.addBook(new Book(4, "Data Structures", "Author D"), 3);
        library.addBook(new Book(5, "Algorithms", "Author E"), 4);

        boolean running = true;

        // Main Menu
        while (running) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("[1] Display All Books");
            System.out.println("[2] Display Available Books");
            System.out.println("[3] Display Borrowed Books");
            System.out.println("[4] Borrow Book");
            System.out.println("[5] Return Book");
            System.out.println("[6] Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            //Menu Selection
            if (choice == 1) displayAllBooks();
            else if (choice == 2) displayAvailableBooks();
            else if (choice == 3) displayBorrowedBooks();
            else if (choice == 4) borrowBook(scanner);
            else if (choice == 5) returnBook(scanner);
            else if (choice == 6) running = false;
            else System.out.println("Invalid selection.");
        }

        System.out.println("Program ended.");
    }
    // Displays all books in the library, regardless of status
    private void displayAllBooks() {
        System.out.println("\n--- ALL BOOKS ---");
        Book[] books = library.getBooks();

        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getId() + " - " + b.getTitle() + " by " + b.getAuthor());
        }
    }
    // Displays book that are available
    private void displayAvailableBooks() {
        System.out.println("\n--- AVAILABLE BOOKS ---");
        Book[] books = library.getBooks();
        boolean found = false;
        for (int i = 0; i < books.length; i++) {
            if (!books[i].isBorrowed()) { // && user.getBorrowedCount() < 6
                System.out.println(books[i].getId() + " - " + books[i].getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nothing to display.");
        }
    }
    
    // Displays borrowed books
    private void displayBorrowedBooks() {
        System.out.println("\n--- BORROWED BOOKS ---");
        Loan[] loans = library.getLoans();
        boolean found = false;
        for (int i = 0; i < loans.length; i++) {
            if (loans[i] != null) {
                System.out.println(loans[i].getBook().getTitle() +
                        " borrowed by " + loans[i].getUser().getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nothing to display.");
        }
    }
    
    // Borrow a book
    private void borrowBook(Scanner scanner) {

        if (user.getBorrowedCount() >= 5) {
            System.out.println("Nothing to borrow.");
            return;
        }

        System.out.println("\n--- BORROW A BOOK ---");
        displayAvailableBooks();

        System.out.print("Enter Book ID to borrow: ");
        int id = scanner.nextInt();

        Book[] books = library.getBooks();
        // Search for the book with the matching ID
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id && !books[i].isBorrowed()) {
            	// Mark book as borrowed
                books[i].setBorrowed(true);
                // Create a loan record
                Loan loan = new Loan(user, books[i]);
                library.addLoan(loan);
                // Update user's borrowed count
                user.incrementBorrowed();

                System.out.println("You borrowed: " + books[i].getTitle());
                return;
            }
        }

        System.out.println("Invalid selection.");
    }
    // Return borrowed book
    private void returnBook(Scanner scanner) {

        System.out.println("\n--- RETURN A BOOK ---");

        Loan[] loans = library.getLoans();
        boolean found = false;
        // Display all active loans
        for (int i = 0; i < loans.length; i++) {
            if (loans[i] != null) {
                System.out.println((i + 1) + ". " + loans[i].getBook().getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nothing to return.");
            return;
        }
        
        System.out.print("Select Book ID to return: ");
        int choice = scanner.nextInt();
        int index = choice - 1;
        
        // Validate selection
        if (index >= 0 && index < loans.length && loans[index] != null) {
        	
        	// Mark the book as available again
            Book book = loans[index].getBook();
            book.setBorrowed(false);
            // Remove the loan entry
            library.removeLoan(index);
            // Update User borrowed count
            user.decrementBorrowed();

            System.out.println("Book returned.");
        } else {
            System.out.println("Invalid selection.");
        }
    }
}

