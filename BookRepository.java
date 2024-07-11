import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static List<Book> books;
    private static final String FILE_NAME = "books.ser";

    public BookRepository() {
        books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void removeBook(Book book) {
        book.removeReview();

        books.remove(book);
        saveBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    private void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            books = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
