package ph.com.bpi.M2Project2;

public class Library {
	// Array that holds all books in the library
    private Book[] books = new Book[5];
    // Array that holds all active loan
    private Loan[] loans = new Loan[5];

    /*
     Add Book object to a specific index in book array.
     * */
    public void addBook(Book book, int index) {
        books[index] = book;
    }
    // Returns array of all books in the library
    public Book[] getBooks() { return books; }
    // Returns array of all active loans
    public Loan[] getLoans() { return loans; }
    
    // Add new loan to first avaiable loans array
    public void addLoan(Loan loan) {
        for (int i = 0; i < loans.length; i++) {
            if (loans[i] == null) {
                loans[i] = loan;
                break;
            }
        }
    }
    // Removes a Loan from the loans array
    public void removeLoan(int index) {
        loans[index] = null;
    }
}

