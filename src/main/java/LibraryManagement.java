class Book {
    protected String title;
    protected String author;
    protected String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}

// Subclass for Fiction Books
class FictionBook extends Book {
    private String genre;

    public FictionBook(String title, String author, String isbn, String genre) {
        super(title, author, isbn);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
        System.out.println("Type: Fiction");
    }
}

// Subclass for Non-Fiction Books
class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook(String title, String author, String isbn, String subject) {
        super(title, author, isbn);
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Type: Non-Fiction");
    }
}

// Main class to demonstrate functionality
public class LibraryManagement {
    public static void main(String[] args) {
        FictionBook fiction = new FictionBook("1984", "George Orwell", "1234567890", "Dystopian");
        NonFictionBook nonFiction = new NonFictionBook("A Brief History of Time", "Stephen Hawking", "0987654321", "Science");

        System.out.println("Fiction Book Details:");
        fiction.displayInfo();

        System.out.println("\nNon-Fiction Book Details:");
        nonFiction.displayInfo();
    }
}

