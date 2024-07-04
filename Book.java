import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;


    private String title;
    private String author;
    private int year;
    private int pages;
    private double price;
    private boolean haveRead;
    public boolean reviewExists;

    public Book(String title, String author, int year, int pages, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.haveRead = false;
        this.reviewExists = false;
    }

    public void setHaveRead(boolean haveRead) {
        this.haveRead = haveRead;
    }

    public void setReviewExists() {
        this.reviewExists = true;
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

    public double getPrice() {
        return price;
    }

    public boolean getHaveRead() {
        return haveRead;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + "), " + pages + " pages, $" + price;
    }
}
