public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
    private double price;

    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.price = price;
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

    public String toString() {
        return title + " by " + author + " (" + year + "), " + pages + " pages, $" + price;
    }
}
