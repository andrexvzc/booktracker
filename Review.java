import java.util.Date;

public class Review extends  Book{
    private Integer rating;
    private String comment;
    private Date date;

    public Review(String title, String author, int year, int pages) {
        super(title, author, year, pages);
    }
}
