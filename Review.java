import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Review implements Serializable {
    private static final long serialVersionUID = 1L;

    private Book book;
    private Integer rating;
    private String comment;
    private LocalDate date;



    public Review(Book book, Integer rating, String comment) {
        this.book = book;
        this.rating = rating;
        this.comment = comment;
        this.date = LocalDate.now();
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
        return "+-----------------------------------------------------------------------------+\n" +
                "|   Review of "+ book.getTitle()+"                     \n" +
                "|      by "+book.getAuthor()+"                         \n" +
                "+-----------------------------------------------------------------------------+\n" +
                "| Rating     | "+this.rating+"                         \n" +
                "+-----------------------------------------------------------------------------+\n" +
                "| Comment    | "+this.comment+"                        \n" +
                "+-----------------------------------------------------------------------------+\n" +
                "| Date       | "+this.date+"                           \n" +
                "+-----------------------------------------------------------------------------+";
    }
}
