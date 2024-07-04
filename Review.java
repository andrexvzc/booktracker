import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Review implements Serializable {
    private static final long serialVersionUID = 1L;

    private Book book;
    private Integer rating;
    private String comment;
    private LocalDate date;

    public Review(Book book, Integer rating, String comment, LocalDate date) {
        this.book = book;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        book.setReviewExists();
    }

    public Book getBook() {
        return book;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Review of " + book.getTitle() + " by " + book.getAuthor() + ": " + rating + " stars, " + comment + " on " + date;
    }
}
