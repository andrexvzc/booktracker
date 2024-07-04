import java.util.List;

public class Main {
    public static void main(String[] args) {


        BookRepository bookRepository = new BookRepository();
        List<Book> books = bookRepository.getBooks();
        Interface interface1 = new Interface(books, bookRepository);
        interface1.MainMenu();


    }
}