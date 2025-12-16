package ph.com.bpi.M2Project2;

public class Book {

	// Unique identifier for the book
    private Integer id;
    // Title of the book
    private String title;
    // Author of the book
    private String author;
    // Indication if the book is borrowed
    private boolean borrowed;

    /* 
     Constructor to initialize a Book object with ID, title, and author.
   */
    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }
    
    //Getter for book ID
    public Integer getId() { return id; }
    //Getter for book title
    public String getTitle() { return title; }
    // Getter for book author
    public String getAuthor() { return author; }
    // Returns true if the book is borrowed
    public boolean isBorrowed() { return borrowed; }
    // status of the book (true = borrowed, false = available)
    public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }
}

