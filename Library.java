
// BASE CLASS

public class Library
{
    // counter, her nesne olusturuldugunda ID'si 1 artacak
    private static int ID_counter = 0;
    private int ID; // Bu olmazsa yeni olusturulan her sey 1 olarak baslar
    private String bookName;
    private String author;
    private int numOfPages;
    private String releaseDate;

    public Library(String bookName, String author, int numOfPages, String releaseDate)
    {
        this.bookName = bookName;
        this.author = author;
        this.numOfPages = numOfPages;
        this.releaseDate = releaseDate;
        ID_counter++; // Her nesne yaratilinca 1 artacak
        this.ID = ID_counter; // Yeni nesne ID'si 1,2... diye gidecek
    }


    public int getID()
    {
        return ID;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getNumOfPages()
    {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages)
    {
        this.numOfPages = numOfPages;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getInformation(String bookInformation)
    {
        return bookInformation;
    }
}
