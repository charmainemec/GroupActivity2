package ph.com.bpi.M2Project2;

public class Loan {
	//Name of user who borrowed book
    private User user;
    private Book book;

    /*
     Creates a Loan object of specific user with a specific book.
     */
    public Loan(User user, Book book) {
        this.user = user;
        this.book = book;
    }
    //Returns the User's name
    public User getUser() { return user; }
    // Returns the book that was borrowed
    public Book getBook() { return book; }
}

