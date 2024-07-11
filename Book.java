import java.io.Serializable;
import java.time.LocalDate;

public class  Book implements Serializable {
    private static final long serialVersionUID = 1L;


    private String title;
    private String author;
    private int year;
    private int pages;
    private boolean haveRead;
    public boolean reviewExists;
    private Review review;

    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.haveRead = false;
        this.reviewExists = false;
    }

    public void addReview(Book book, Integer rating, String comment) {
        this.review = new Review(book, rating, comment);
        setReviewExists();
        setHaveRead();

    }
    public void getReview() {
        System.out.println(this.review);
    }

    public void setHaveRead() {
        this.haveRead = true;
    }

    public void setHaveNotRead() {
        this.haveRead = false;
    }

    public void setReviewExists() {
        this.reviewExists = true;
    }

    public void removeReview() {
        this.review = null;
        this.reviewExists = false;
    }

    public Book getBook() {
        return this;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }


    public boolean getHaveRead() {
        return haveRead;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + "), " + pages + " pages";
    }
}
