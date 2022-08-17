import java.util.ArrayList;

public class Novel extends Library implements novel_interface
{
    // Sistemdeki Novel kitaplari tutmak icin
    static ArrayList<Novel> Array_Novel = new ArrayList<Novel>();// Dinamik olarak ekle cikar yapilacagi icin static
    // Sistemdeki odunc alinan Novel kitaplari tutmak icin
    static ArrayList<Novel> Array_Novel_Borrowed = new ArrayList<Novel>();
    private String type;

    public Novel(String bookName, String author, int numOfPages, String releaseDate, String type)
    { // Constructor
        super(bookName, author, numOfPages, releaseDate);
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    static void addNovel(Novel novel_book)
    {
        Array_Novel.add(novel_book);
    }

    // Novel classa ozel bilgileri getir methodu
    String get_information_Novel(Novel novel_book)
    {
        String novel_book_information = "---NOVEL---\n" + "System Order(important while choosing book) : " + Array_Novel.indexOf(novel_book)
                + "\n Book Barcode: " + novel_book.getID() + "\n Book Name: " + novel_book.getBookName()
                + "\n Book Author: " + novel_book.getAuthor() + "\n Number of Pages: " + novel_book.getNumOfPages()
                + "\n Book Release Date: " + novel_book.getReleaseDate() + "\n Novel Type: " + novel_book.getType();
        return getInformation(novel_book_information);
    }

    // Novel classa ozel odunc kitap bilgileri getir methodu
    String get_information_novel_borrowed(Novel novel_book)
    {
        String novel_book_information = "---NOVEL---\n" + "System Order(important while choosing book) : " + Array_Novel_Borrowed.indexOf(novel_book)
                + "\n Book Barcode: " + novel_book.getID() + "\n Book Name: " + novel_book.getBookName()
                + "\n Book Author: " + novel_book.getAuthor() + "\n Number of Pages: " + novel_book.getNumOfPages()
                + "\n Book Release Date: " + novel_book.getReleaseDate() + "\n Novel Type: " + novel_book.getType();
        return getInformation(novel_book_information);
    }

    // INTERFACE OVERRIDE
    @Override
    public void addBook(Novel novel_book)
    {
        Array_Novel.add(novel_book);
        System.out.println(novel_book.getBookName() + " named book added to the System.");
    }

    @Override
    public void removeBook(Novel novel_book)
    { // Normal yapinca java.util.ConcurrentModificationException hatasi veriyor, bilgi silme isleminin onune gecmek icin
        // TryCatch ile oldu

        try
        {
            for(Novel novel : Array_Novel)
            {
                if(novel_book.getID() == novel.getID()) // ID ler tutarsa silecek yoksa sonrakine gececek, tarama islemi
                {
                    Array_Novel.remove(Array_Novel.indexOf(novel_book));
                }
            }
            System.out.println(novel_book.getBookName() + " named book has been removed from the System");
        } catch (Exception e)
        {
            System.out.println(novel_book.getBookName() + " named book has been removed from the System");
        }
    }

    @Override
    public void borrowBook(Novel novel_book)
    {
        Array_Novel_Borrowed.add(novel_book); // Buraya ekler
        Array_Novel.remove(Array_Novel.indexOf(novel_book)); // Buradan siler
        // removenin icine index sayisi atmamiz gerekir
        System.out.println(novel_book.getBookName() + " named book removed from System and added to the Borrowed Books"
                + "\n Do not forget to return the book before the deadline!");
    }

    @Override
    public void giveBackBook(Novel novel_book)
    { // Burda da oduncten silip sisteme geri eklicez
        Array_Novel.add(novel_book);
        Array_Novel_Borrowed.remove(Array_Novel_Borrowed.indexOf(novel_book));

        System.out.println(novel_book.getBookName() + " named book added the system again"
                + "\n Thank you for bring the book before the deadline!");
    }
}
