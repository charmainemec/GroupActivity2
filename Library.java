package ph.com.bpi.m2project2;

public class Library extends Book{
	private Book[] books;
	public Library()
	{
		
	}
	public Library(Integer id, String title, String author)
	{
		this.setId(id);
		this.setTitle(title);
		this.setAuthor(author);
		this.isBorrowed();
	}

	// Array that holds all books in the library
    //private Book[] books = new Book[5];
    // Array that holds all active loan
    private Loan[] loans = new Loan[5];

    public Book[] addBook() 
    {
        Book[] bookData = {
            new Library(1, "Java Basics", "Author A"),
            new Library(2, "Advanced Java", "Author B"),
            new Library(3, "OOP Concepts", "Author C"),
            new Library(4, "Data Structures", "Author D"),
            new Library(5, "Algorithms", "Author E")
        };

        // Save
        this.books = bookData;
        // Return
        return bookData;
    }

    public Book[] getBooks() {
        return books != null ? books : new Book[0];
    }

   
    // Returns array of all books in the library
    /*public Book[] getBooks() 
    { 
    	return books; 
    }*/


    // Returns array of all active loans
    public Loan[] getLoans() 
    { 
    	return loans; 
    }
    
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

