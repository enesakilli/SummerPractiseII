import java.util.ArrayList;

public class Language extends Library implements language_interface
{
    // Sistemdeki Language kitaplarini tutmak icin
    static ArrayList<Language> Array_Language = new ArrayList<Language>(); // Dinamik olarak ekle cikar yapilacagi icin static
    // Sistemdeki odunc alinan Language kitaplarini tutmak icin
    static ArrayList<Language> Array_Language_Borrowed = new ArrayList<Language>();
    private String type;

    private String languageOfBook;

    public Language(String bookName, String author, int numOfPages, String releaseDate, String type, String languageOfBook)
    { // Constructor
        super(bookName, author, numOfPages, releaseDate);
        this.type = type;
        this.languageOfBook = languageOfBook;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getLanguageOfBook() {return languageOfBook;}

    public void setLanguageOfBook(String languageOfBook) {this.languageOfBook = languageOfBook;}

    static void addLanguage(Language language_book)
    {
        Array_Language.add(language_book);
    }

    // Language classa ozel bilgileri getir methodu
    String get_information_Language(Language language_book)
    {
        String language_book_information = "---NOVEL---\n" + "System Order(important while choosing book) : " + Array_Language.indexOf(language_book)
                + "\n Book Barcode: " + language_book.getID() + "\n Book Name: " + language_book.getBookName()
                + "\n Book Author: " + language_book.getAuthor() + "\n Number of Pages: " + language_book.getNumOfPages()
                + "\n Book Release Date: " + language_book.getReleaseDate() + "\n Novel Type: " + language_book.getType()
                + "\n Language of Book: " + language_book.getLanguageOfBook();
        return getInformation(language_book_information);
    }

    // Language classa ozel odunc kitap bilgileri getir methodu
    String get_information_language_borrowed(Language language_book)
    {
        String language_book_information = "---NOVEL---\n" + "System Order(important while choosing book) : " + Array_Language_Borrowed.indexOf(language_book)
                + "\n Book Barcode: " + language_book.getID() + "\n Book Name: " + language_book.getBookName()
                + "\n Book Author: " + language_book.getAuthor() + "\n Number of Pages: " + language_book.getNumOfPages()
                + "\n Book Release Date: " + language_book.getReleaseDate() + "\n Novel Type: " + language_book.getType()
                + "\n Language of Book: " + language_book.getLanguageOfBook();
        return getInformation(language_book_information);
    }

    // INTERFACE OVERRIDE
    @Override
    public void addBook(Language language_book)
    {
        Array_Language.add(language_book);
        System.out.println(language_book.getBookName() + " named book added to the System.");
    }

    @Override
    public void removeBook(Language language_book)
    { // Normal yapinca java.util.ConcurrentModificationException hatasi veriyor, bilgi silme isleminin onune gecmek icin
        // TryCatch ile oldu

        try
        {
            for(Language language : Array_Language)
            {
                if(language_book.getID() == language.getID()) // ID ler tutarsa silecek yoksa sonrakine gececek, tarama islemi
                {
                    Array_Language.remove(Array_Language.indexOf(language_book));
                }
            }
            System.out.println(language_book.getBookName() + " named book has been removed from the System");
        } catch (Exception e)
        {
            System.out.println(language_book.getBookName() + " named book has been removed from the System");
        }
    }

    @Override
    public void borrowBook(Language language_book)
    {
        Array_Language_Borrowed.add(language_book); // Buraya ekler
        Array_Language.remove(Array_Language.indexOf(language_book)); // Buradan siler
        // removenin icine index sayisi atmamiz gerekir
        System.out.println(language_book.getBookName() + " named book removed from System and added to the Borrowed Books"
                + "\n Do not forget to return the book before the deadline!");
    }

    @Override
    public void giveBackBook(Language language_book)
    { // Burda da oduncten silip sisteme geri eklicez
        Array_Language.add(language_book);
        Array_Language_Borrowed.remove(Array_Language_Borrowed.indexOf(language_book));

        System.out.println(language_book.getBookName() + " named book added the system again"
                + "\n Thank you for bring the book before the deadline!");

    }
}
