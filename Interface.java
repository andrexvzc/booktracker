import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Interface {
    private BookRepository bookRepository;
    private List<Book> books;

    public Interface(List<Book> books, BookRepository bookRepository) {
        this.books = books;
        this.bookRepository = bookRepository;

    }


    public void MainMenu () {
        System.out.println("1. Select a book");
        System.out.println("2. Add a book");
        System.out.println("3. Add a review");
        System.out.println("4. Exit");
        Scanner option = new Scanner(System.in);
        int mainChoice = option.nextInt();
        switch (mainChoice) {
            case 1:
                System.out.println("1. Select a book");
                listAllBooks();
                break;
            case 2:
                System.out.println("2. Add a book");
                break;
            case 3:
                System.out.println("3. Add a review");
                break;
            case 4:
                System.out.println("4. Exit");
                break;
        }
    }
    public void BookMenu (Book book) {
        if(book.getHaveRead()) {
            System.out.println("1. Unmark's as read'");
        } else {
            System.out.println("1. Mark as read");
        }
        System.out.println("2. Remove book");
        if (book.reviewExists) {
            System.out.println("3.Delete review");
        } else {
            System.out.println("3. Add a review");
        }
        System.out.println(book.reviewExists);
        System.out.println("4. Back");
        Scanner option = new Scanner(System.in);
        int bookMenuChoice = option.nextInt();
        switch (bookMenuChoice) {
            case 1:
                if(book.getHaveRead()) {
                    System.out.println("1. Mark as unread");
                } else {
                    System.out.println("1. Mark as read");
                }
                break;
            case 2:
                System.out.println("2. Remove book");
                break;
            case 3:
                if (book.reviewExists) {
                    System.out.println("3.Delete review");
                } else {
                    System.out.println("3. Add a review");
                }

                ReviewExistingBook(book);
                break;
            case 4:
                System.out.println("4. Back");
                break;

        }
    }



    public void ReviewExistingBook (Book book) {
        System.out.println(book);
        System.out.println("1. Rate the book");
        Scanner rating = new Scanner(System.in);
        int bookRating = rating.nextInt();
        System.out.println("2. Add a comment");
        Scanner review = new Scanner(System.in);
        String bookReview = rating.next();
        LocalDate date = LocalDate.now();
        Review newReview = new Review(book, bookRating, bookReview, date);
        System.out.println(newReview);
        System.out.println("3. Back");

    }
    public void ReviewMenu () {
        System.out.println("1. Rate existing book");
        System.out.println("2. Rate new book");
        System.out.println("3. Back");
    }
    public void addBookMenu (boolean wantsReview) {
        System.out.println("Enter the title of the book:");
        System.out.println("Enter the author of the book:");
        System.out.println("Enter the year of the book:");
        System.out.println("Enter the number of pages of the book:");
        System.out.println("Enter the price of the book:");
        if (wantsReview) {

        }
    }
    public void addReviewMenu () {
        System.out.println("Enter the rating of the book:");
        System.out.println("Enter the comment of the book:");
    }
    public void listAllBooks () {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + ". " + books.get(i));
        }
        selectBook();
    }
    public void selectBook () {
        Scanner option = new Scanner(System.in);
        int bookChoice = option.nextInt();
        Book selectedBook = books.get(bookChoice);
        BookMenu(selectedBook);
    }
}
