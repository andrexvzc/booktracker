import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Interface {
    private BookRepository bookRepository;
    private List<Book> books;
    private Scanner scanner = new Scanner(System.in);

    public Interface(List<Book> books, BookRepository bookRepository) {
        this.books = books;
        this.bookRepository = bookRepository;

    }


    public void MainMenu () {
        System.out.println("1. Select a book");
        System.out.println("2. Add a book");
        System.out.println("0. Exit");
        int mainChoice = scanner.nextInt();
        scanner.nextLine();
        switch (mainChoice) {
            case 1:
                listAllBooks();
                break;
            case 2:
                System.out.println("ADD A BOOK");
                addBookMenu();
                break;
            case 0:
                System.out.println("EXITING");
                break;
        }
    }
    public void BookMenu (Book book) {
        if(book.getHaveRead()) {
            System.out.println("1. Unmark as read");
        } else {
            System.out.println("1. Mark as read");
        }
        System.out.println("2. Remove book");
        if (book.reviewExists) {
            System.out.println("3. Delete review");
        } else {
            System.out.println("3. Add a review");
        }
        if (book.reviewExists) {
            System.out.println("4. See review");
        }
        System.out.println("0. Back");
        int bookMenuChoice = scanner.nextInt();
        scanner.nextLine();
        switch (bookMenuChoice) {
            case 1:
                if(book.getHaveRead()) {
                    book.setHaveNotRead();
                } else {
                    book.setHaveRead();
                }
                BookMenu(book);
                break;
            case 2:
                deleteBook(book);
                break;
            case 3:
                if (book.reviewExists) {
                    book.removeReview();
                    System.out.println("Review deleted");

                    BookMenu(book);
                } else {
                    ReviewExistingBook(book);
                }break;

            case 4:
                if (book.reviewExists) {
                    book.getReview();
                    System.out.println("PRESS ENTER TO CONTINUE");
                    scanner.nextLine();
                    BookMenu(book);
                } else {
                    System.out.println("Invalid choice");
                    BookMenu(book);
                } break;
            case 0:
                listAllBooks();
                break;
            default:
                System.out.println("Invalid choice");
                BookMenu(book);
                break;
        }
    }



    public void ReviewExistingBook (Book book) {
        System.out.println(book);
        System.out.println("1. Rate the book");
        int bookRating = scanner.nextInt();
        scanner.nextLine();
        System.out.println("2. Add a comment");
        String bookReview = scanner.nextLine();
        scanner.nextLine();
        book.addReview(book, bookRating, bookReview);
        book.getReview();
        System.out.println("PRESS ENTER TO CONTINUE");
        scanner.nextLine();
        BookRepository.saveBooks();
        BookMenu(book);

    }

    public void addBookMenu () {

        System.out.println("Enter the title of the book:");
        String titleField = scanner.nextLine();

        System.out.println("Enter the author of the book:");
        String authorField = scanner.nextLine();

        System.out.println("Enter the year of the book:");
        int yearField = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the number of pages of the book:");
        int pagesField = scanner.nextInt();
        scanner.nextLine();

        bookRepository.addBook(new Book(titleField, authorField, yearField, pagesField));
        System.out.println("BOOK SUCCESSFULLY ADDED");
        MainMenu();
    }

    public void listAllBooks () {
        System.out.println("SELECT A BOOK");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i+1) + ". " + books.get(i));
        }
        System.out.println("0. Back");
        selectBook();
    }
    public void selectBook () {
        int bookChoice = scanner.nextInt();
        scanner.nextLine();
        if (bookChoice == 0) {
            MainMenu();
        } else {
        int bookIndex = bookChoice - 1;
        Book selectedBook = books.get(bookIndex);
        BookMenu(selectedBook);}
    }

    public void deleteBook (Book book) {
        bookRepository.removeBook(book);
        System.out.println("BOOK REMOVED");
        BookRepository.saveBooks();
        MainMenu();
    }

}
