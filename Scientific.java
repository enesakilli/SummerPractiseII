import java.util.ArrayList;

// Library base classini inherite eder ve sci_interfacei implement eder
public class Scientific extends Library implements scientific_interface
{
    // Sistemdeki bilimsel Scientific tutmak icin
    static ArrayList<Scientific> Array_Scientific = new ArrayList<Scientific>();// Dinamik olarak ekle cikar yapilacagi icin static
    // Sistemdeki odunc alinan Scientific kitaplari tutmak icin
    static ArrayList<Scientific> Array_Scientific_Borrowed = new ArrayList<Scientific>();
    private String type;
    private boolean isArticle;

    public Scientific(String bookName, String author, int numOfPages, String releaseDate, String type, boolean isArticle)
    { // Constructor
        super(bookName, author, numOfPages, releaseDate);
        this.type = type;
        this.isArticle = isArticle;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public boolean isArticle()
    {
        return isArticle;
    }

    public void setArticle(boolean article)
    {
        isArticle = article;
    }

    static void addScientific(Scientific scientific_book)
    {
        Array_Scientific.add(scientific_book);
    }

    // Scientific classa ozel bilgileri getir methodu
    String get_information_scientific(Scientific scientific_book)
    {
        String isArticle_String = "NOT Article"; // default Article degil

        if(scientific_book.isArticle) // == 1 boolean olcak?
        {
            isArticle_String = "Article";
        }

        // Sirasini gostericez, ona gore secim yapilacak     // Sirayi gosteriyor       // Index i bilip ona gore ekleyip silme islemi yapacak
        String scientific_book_information = "---SCIENTIFIC---\n" + "System Order(important while choosing book) : " + Array_Scientific.indexOf(scientific_book)
                                             + "\n Book Barcode: " + scientific_book.getID() + "\n Book Name: " + scientific_book.getBookName()
                                             + "\n Book Author: " + scientific_book.getAuthor() + "\n Number of Pages: " + scientific_book.getNumOfPages()
                                             + "\n Book Release Date: " + scientific_book.getReleaseDate() + "\n Article Type: " + isArticle_String
                                             + "\n Text Content: " + scientific_book.getType();
        return getInformation(scientific_book_information);
    }

    // Scientific classa ozel odunc kitap bilgileri getir methodu
    String get_information_scientific_borrowed(Scientific scientific_book)
    {
        String isArticle_String = "NOT Article"; // default Article degil

        if(scientific_book.isArticle) // == 1 boolean olcak?
        {
            isArticle_String = "Article";
        }

        // Sirasini gostericez, ona gore secim yapilacak
        String scientific_book_information = "---SCIENTIFIC---\n" + "System Order(important while choosing book) : " + Array_Scientific_Borrowed.indexOf(scientific_book)
                + "\n Book Barcode: " + scientific_book.getID() + "\n Book Name: " + scientific_book.getBookName()
                + "\n Book Author: " + scientific_book.getAuthor() + "\n Number of Pages: " + scientific_book.getNumOfPages()
                + "\n Book Release Date: " + scientific_book.getReleaseDate() + "\n Article Type: " + isArticle_String
                + "\n Text Content: " + scientific_book.getType();
        return getInformation(scientific_book_information);
    }

    // INTERFACE OVERRIDE
    @Override
    public void addBook(Scientific scientific_book)
    {
        Array_Scientific.add(scientific_book);
        System.out.println(scientific_book.getBookName() + " named book added to the System.");
    }

    @Override
    public void removeBook(Scientific scientific_book)
    { // Normal yapinca java.util.ConcurrentModificationException hatasi veriyor, bilgi silme isleminin onune gecmek icin
      // TryCatch ile oldu

        try
        {
            for(Scientific scientific : Array_Scientific)
            {
                if(scientific_book.getID() == scientific.getID()) // ID ler tutarsa silecek yoksa sonrakine gececek, tarama islemi
                {
                    Array_Scientific.remove(Array_Scientific.indexOf(scientific_book));
                }
            }
            System.out.println(scientific_book.getBookName() + " named book has been removed from the System");
        } catch (Exception e)
        {
            System.out.println(scientific_book.getBookName() + " named book has been removed from the System");
        }
    }

    @Override
    public void borrowBook(Scientific scientific_book)
    {
        Array_Scientific_Borrowed.add(scientific_book); // Buraya ekler
        Array_Scientific.remove(Array_Scientific.indexOf(scientific_book)); // Buradan siler
                               // removenin icine index sayisi atmamiz gerekir
        System.out.println(scientific_book.getBookName() + " named book removed from System and added to the Borrowed Books"
                          + "\nDo not forget to return the book before the deadline!");
    }

    @Override
    public void giveBackBook(Scientific scientific_book)
    { // Burda da oduncten silip sisteme geri eklicez
        Array_Scientific.add(scientific_book);
        Array_Scientific_Borrowed.remove(Array_Scientific_Borrowed.indexOf(scientific_book));

        System.out.println(scientific_book.getBookName() + " named book added the system again"
                          + "\nThank you for bring the book before the deadline!");
    }
}
