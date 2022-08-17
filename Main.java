import java.util.Scanner;

public class Main
{
    static boolean wannaContinue()
    {
        boolean devam = false;
        Scanner scanner = new Scanner(System.in);

        try
        {
            System.out.println("----------------------");
            System.out.println("Continue to program? (Yes 1, No 2)");
                int continueInput = scanner.nextInt();

            if(continueInput == 1)
            {
                devam = true;
            }
            else if (continueInput == 2)
            {
                return devam;
            } // Default false atadik yani false olarak devam edecek
            else
            {System.out.println("Wrong Input, Program is Terminating ");
                  return devam;
            } // False olarak devam edecek
        }catch (Exception e)
        {
            System.out.println("Wrong Input, Program is Terminating ");
        }finally // Her ihtimalde burasi olacak, alerti verir durdurur
        {
            return devam; // En kotu ihtimal kullanici devam etmez
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Scientific s1 = new Scientific("JAVA101", "EFA", 444, "15.07.2012", "Software", false);
        Scientific s2 = new Scientific("PYTHON201", "TBA", 75, "15.07.2014", "Software", true);
        Scientific.addScientific(s1);
        Scientific.addScientific(s2);

        Novel n1 = new Novel("LOTR", "Tolkien", 150, "01.01.2015", "Story Novel");
        Novel n2 = new Novel("POTC", "Sparrow", 500, "01.09.2001", "Movie Novel");
        Novel.addNovel(n1);
        Novel.addNovel(n2);

        Language l1 = new Language("ENG101", "Instuctor1", 150, "22.08.2015", "English C1", "English");
        Language l2 = new Language("GER201", "Instuctor2", 123, "22.08.2018", "German B2", "German");
        Language.addLanguage(l1);
        Language.addLanguage(l2);

        String star = "************************************************";
        String line = "------------------------------------------------";

        String message_library = "Hello, Welcome to Our Library\n" +
                                "There are 3 Type of Book in Our System: \n" +
                                "*SCIENTIFIC* - *NOVEL* - *LANGUAGE*\n" +
                                "Which one do you want to choose? \n" +
                                "Press 1 for Scientific\n" +
                                "Press 2 for Novel\n" +
                                "Press 3 for Language\n" +
                                "Press 0 for Exit: ";

        String message_library2 = "Press 1 to Add a book\n" +
                                "Press 2 to Remove a book\n" +
                                "Press 3 to Borrow a book\n" +
                                "Press 4 to Return Borrowed book: ";

        String warning = "Please pay attention to input types! ";

        try
        {
            while (true)
            {
                System.out.println(star);
                System.out.println(message_library);
                    int input1 = scanner.nextInt();

                if(input1 == 1)
                {
                    System.out.println(star);
                    System.out.println("All of the Scientific Books in the System... ");

                    for(Scientific scientific : Scientific.Array_Scientific)
                    {
                        System.out.println(line);
                        System.out.println(scientific.get_information_scientific(scientific));
                        System.out.println(line);
                    }

                    // 1 - 2 - 3 - 4

                    System.out.println(message_library2);
                        int input2 = scanner.nextInt();

                    if(input2 == 1)
                    {
                        System.out.println("Enter the Information of Book: ");
                        scanner.nextLine(); // 2'li 2'li bastirmasini engellemek icin
                        System.out.println("Name of the Scientific Book: ");
                            String book_name = scanner.nextLine();
                        System.out.println("Author of the Scientific Book: ");
                            String book_author = scanner.nextLine();
                        System.out.println("Page Number of the Scientific Book: ");
                            int book_pageNumber = scanner.nextInt();
                            scanner.nextLine(); // int input alirsan nextline koy
                        System.out.println("Release Date of the Scientific Book(DD/MM/YYYY): ");
                            String book_releaseDate = scanner.nextLine();
                        System.out.println("Type of the Scientific Book: ");
                            String book_type = scanner.nextLine();

                        boolean book_isArticle = false;

                        try
                        {
                            System.out.println("Is Scientific Book and Article? (true/false): ");
                                book_isArticle = scanner.nextBoolean();
                           /*
                                if(book_isArticle)
                                {
                                    book_isArticle = true;
                                }
                            */
                        }catch (Exception e)
                        {
                            System.out.println("Only enter (true/false) \n Program is ending...");
                            return;
                        }

                        Scientific s3 = new Scientific(book_name, book_author, book_pageNumber, book_releaseDate, book_type, book_isArticle);
                        s1.addBook(s3); // Kaydediyoruz
                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000); // Bekleme
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                        else if(input2 == 2)
                        {

                            if(Scientific.Array_Scientific.isEmpty()) // Sistem bossa
                            {
                                System.out.println("There is no Scientific Book in the System\n" + "Going back to the start of the Program");
                                Thread.sleep(1000);
                                continue;
                            }

                            // Kullanici index sirasini verip sildirme islemi yapar
                            System.out.println("Which one do you want to delete from the List?");
                            System.out.println("Please enter the System Number of the book(First number in Information): ");

                                int scientific_book_order = scanner.nextInt();

                                if((scientific_book_order > Scientific.Array_Scientific.size()))
                                {
                                    System.out.println("You entered bigger than in the system. Program is going to stop.");
                                    return;
                                }
                                else
                                {  // Inputu yollariz input dogruysa o siradaki bilgiyi remove book a yollar ve Array Sci. icinden siler
                                    s1.removeBook(Scientific.Array_Scientific.get(scientific_book_order));
                                }

                                if(wannaContinue()) // Devam mi diye soruyoruz
                                {
                                    continue;
                                }
                                else
                                {
                                    System.out.println("Exiting From Library.");
                                    Thread.sleep(2000);
                                    System.out.println("Exited From Library.");
                                    return;
                                }
                        }
                                else if(input2 == 3) // Odunc alma kismi
                                {
                                    if(Scientific.Array_Scientific.isEmpty()) // Doluluk orani
                                    {
                                        System.out.println("There is no Scientific Book in the System\n" + "Going back to the start of the Program");
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                    System.out.println("Which one do you want to borrow from the List? ");
                                    System.out.println("Please enter the System Number of the book (First number in Informations): ");

                                        int scientific_book_order = scanner.nextInt();

                                    if(scientific_book_order > Scientific.Array_Scientific.size())
                                    {
                                        System.out.println("You entered bigger than in the system. Program is going to stop.");
                                        return;
                                    }
                                    else
                                    {   // Verileri depoladigimiz yere gidip, .get ile sira numarasini veriyoruz
                                        s1.borrowBook(Scientific.Array_Scientific.get(scientific_book_order));
                                        // Secilen indextekini Arrayden cikar odunc al fonksiyonuna yolla, orda da odunc ala kaydedip scientificden silecek
                                    }

                                    if(wannaContinue()) // Devam mi diye soruyoruz
                                    {
                                        continue;
                                    }
                                    else
                                    {
                                        System.out.println("Exiting From Library.");
                                        Thread.sleep(2000);
                                        System.out.println("Exited From Library.");
                                        return;
                                    }
                                }
                                    else if(input2 == 4) // Alinan kitabi geri getirme
                                    {
                                    // Odunc alinan tum kitaplari gostericez
                                    System.out.println(star);
                                    System.out.println("Books borrowed by you: ");

                                    if(Scientific.Array_Scientific_Borrowed.isEmpty()) // Doluluk orani
                                    {
                                        System.out.println("There is no Scientific Book in the System\n" + "Going back to the start of the Program");
                                        Thread.sleep(1000);
                                        continue;
                                    }

                                    for(Scientific scientific : Scientific.Array_Scientific_Borrowed)
                                    {
                                        System.out.println(line);
                                        System.out.println(scientific.get_information_scientific_borrowed(scientific));
                                    }

                                    System.out.println("Which book do you want to return? ");
                                    System.out.println("Enter the system number of the book you want to return in the system (First number in Information): ");

                                        int scientific_book_order = scanner.nextInt();

                                    if(scientific_book_order > Scientific.Array_Scientific_Borrowed.size())
                                    {
                                        System.out.println("You entered bigger than in the system. Program is going to stop.");
                                        return;
                                    }
                                    else
                                    {   // Arrayin icine gidip icindeki bilgiyi buna yollayacagiz
                                        s1.giveBackBook(Scientific.Array_Scientific_Borrowed.get(scientific_book_order));
                                    }

                                    if(wannaContinue()) // Devam mi diye soruyoruz
                                    {
                                        continue;
                                    }
                                    else
                                    {
                                        System.out.println("Exiting From Library.");
                                        Thread.sleep(2000);
                                        System.out.println("Exited From Library.");
                                        return;
                                    }
                                }
                }
                else if(input1 == 2)
                {
                    System.out.println(star);
                    System.out.println("All of the Novels in the System... ");

                    for(Novel novel : Novel.Array_Novel)
                    {
                        System.out.println(line);
                        System.out.println(novel.get_information_Novel(novel));
                        System.out.println(line);
                    }

                    // 1 - 2 - 3 - 4

                    System.out.println(message_library2);
                    int input2 = scanner.nextInt();

                    if(input2 == 1)
                    {
                        System.out.println("Enter the Information of Book: ");
                        scanner.nextLine(); // 2'li 2'li bastirmasini engellemek icin
                        System.out.println("Name of the Novel: ");
                        String book_name = scanner.nextLine();
                        System.out.println("Author of the Novel: ");
                        String book_author = scanner.nextLine();
                        System.out.println("Page Number of the Novel: ");
                        int book_pageNumber = scanner.nextInt();
                        scanner.nextLine(); // int input alirsan nextline koy
                        System.out.println("Release Date of the Novel(DD/MM/YYYY): ");
                        String book_releaseDate = scanner.nextLine();
                        System.out.println("Type of the Novel: ");
                        String book_type = scanner.nextLine();


                        Novel n3 = new Novel(book_name, book_author, book_pageNumber, book_releaseDate, book_type);
                        n3.addBook(n3); // Kaydediyoruz
                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000); // Bekleme
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                    else if(input2 == 2)
                    {

                        if(Novel.Array_Novel.isEmpty()) // Sistem bossa
                        {
                            System.out.println("There is no Novel in the System\n" + "Going back to the start of the Program");
                            Thread.sleep(1000);
                            continue;
                        }

                        // Kullanici index sirasini verip sildirme islemi yapar
                        System.out.println("Which one do you want to delete from the List?");
                        System.out.println("Please enter the System Number of the book(First number in Information): ");

                        int novel_book_order = scanner.nextInt();

                        if((novel_book_order > Novel.Array_Novel.size()))
                        {
                            System.out.println("You entered bigger than in the system. Program is going to stop.");
                            return;
                        }
                        else
                        {  // Inputu yollariz input dogruysa o siradaki bilgiyi remove book a yollar ve Array Sci. icinden siler
                            n1.removeBook(Novel.Array_Novel.get(novel_book_order));
                        }

                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000);
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                    else if(input2 == 3) // Odunc alma kismi
                    {
                        if(Novel.Array_Novel.isEmpty()) // Doluluk orani
                        {
                            System.out.println("There is no Novel in the System\n" + "Going back to the start of the Program");
                            Thread.sleep(1000);
                            continue;
                        }
                        System.out.println("Which one do you want to borrow from the List? ");
                        System.out.println("Please enter the System Number of the book (First number in Information): ");

                        int novel_book_order = scanner.nextInt();

                        if(novel_book_order > Novel.Array_Novel.size())
                        {
                            System.out.println("You entered bigger than in the system. Program is going to stop.");
                            return;
                        }
                        else
                        {   // Verileri depoladigimiz yere gidip, .get ile sira numarasini veriyoruz
                            n1.borrowBook(Novel.Array_Novel.get(novel_book_order));
                            // Secilen indextekini Arrayden cikar odunc al fonksiyonuna yolla, orda da odunc ala kaydedip scientificden silecek
                        }

                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000);
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                    else if(input2 == 4) // Alinan kitabi geri getirme
                    {
                        // Odunc alinan tum kitaplari gostericez
                        System.out.println(star);
                        System.out.println("Books borrowed by you: ");

                        if(Novel.Array_Novel_Borrowed.isEmpty()) // Doluluk orani
                        {
                            System.out.println("There is no Novel in the System\n" + "Going back to the start of the Program");
                            Thread.sleep(1000);
                            continue;
                        }

                        for(Novel novel : Novel.Array_Novel_Borrowed)
                        {
                            System.out.println(line);
                            System.out.println(novel.get_information_novel_borrowed(novel));
                        }

                        System.out.println("Which book do you want to return? ");
                        System.out.println("Enter the system number of the book you want to return in the system (First number in Information): ");

                        int novel_book_order = scanner.nextInt();

                        if(novel_book_order > Novel.Array_Novel_Borrowed.size())
                        {
                            System.out.println("You entered bigger than in the system. Program is going to stop.");
                            return;
                        }
                        else
                        {   // Arrayin icine gidip icindeki bilgiyi buna yollayacagiz
                            n1.giveBackBook(Novel.Array_Novel_Borrowed.get(novel_book_order));
                        }

                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000);
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                }
                else if(input1 == 3)
                {
                    System.out.println(star);
                    System.out.println("All of the Language Book in the System... ");

                    for(Language language : Language.Array_Language)
                    {
                        System.out.println(line);
                        System.out.println(language.get_information_Language(language));
                        System.out.println(line);
                    }

                    // 1 - 2 - 3 - 4

                    System.out.println(message_library2);
                    int input2 = scanner.nextInt();

                    if(input2 == 1)
                    {
                        System.out.println("Enter the Information of Book: ");
                        scanner.nextLine(); // 2'li 2'li bastirmasini engellemek icin
                        System.out.println("Name of the Language Book: ");
                        String book_name = scanner.nextLine();
                        System.out.println("Author of the Language Book: ");
                        String book_author = scanner.nextLine();
                        System.out.println("Page Number of the Language Book: ");
                        int book_pageNumber = scanner.nextInt();
                        scanner.nextLine(); // int input alirsan nextline koy
                        System.out.println("Release Date of the Language Book(DD/MM/YYYY): ");
                        String book_releaseDate = scanner.nextLine();
                        System.out.println("Type of the Language Book: ");
                        String book_type = scanner.nextLine();
                        System.out.println("Language of the Language Book: ");
                        String book_language = scanner.nextLine();


                        Language l3 = new Language(book_name, book_author, book_pageNumber, book_releaseDate, book_type, book_language);
                        l3.addBook(l3); // Kaydediyoruz
                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000); // Bekleme
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                    else if(input2 == 2)
                    {

                        if(Language.Array_Language.isEmpty()) // Sistem bossa
                        {
                            System.out.println("There is no Language Book in the System\n" + "Going back to the start of the Program");
                            Thread.sleep(1000);
                            continue;
                        }

                        // Kullanici index sirasini verip sildirme islemi yapar
                        System.out.println("Which one do you want to delete from the List?");
                        System.out.println("Please enter the System Number of the book(First number in Information): ");

                        int language_book_order = scanner.nextInt();

                        if((language_book_order > Language.Array_Language.size()))
                        {
                            System.out.println("You entered bigger than in the system. Program is going to stop.");
                            return;
                        }
                        else
                        {  // Inputu yollariz input dogruysa o siradaki bilgiyi remove book a yollar ve Array Sci. icinden siler
                            l1.removeBook(Language.Array_Language.get(language_book_order));
                        }

                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000);
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                    else if(input2 == 3) // Odunc alma kismi
                    {
                        if(Language.Array_Language.isEmpty()) // Doluluk orani
                        {
                            System.out.println("There is no Language Book in the System\n" + "Going back to the start of the Program");
                            Thread.sleep(1000);
                            continue;
                        }
                        System.out.println("Which one do you want to borrow from the List? ");
                        System.out.println("Please enter the System Number of the book (First number in Information): ");

                        int language_book_order = scanner.nextInt();

                        if(language_book_order > Language.Array_Language.size())
                        {
                            System.out.println("You entered bigger than in the system. Program is going to stop.");
                            return;
                        }
                        else
                        {   // Verileri depoladigimiz yere gidip, .get ile sira numarasini veriyoruz
                            l1.borrowBook(Language.Array_Language.get(language_book_order));
                            // Secilen indextekini Arrayden cikar odunc al fonksiyonuna yolla, orda da odunc ala kaydedip scientificden silecek
                        }

                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000);
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                    else if(input2 == 4) // Alinan kitabi geri getirme
                    {
                        // Odunc alinan tum kitaplari gostericez
                        System.out.println(star);
                        System.out.println("Books borrowed by you: ");

                        if(Language.Array_Language_Borrowed.isEmpty()) // Doluluk orani
                        {
                            System.out.println("There is no Language Book in the System\n" + "Going back to the start of the Program");
                            Thread.sleep(1000);
                            continue;
                        }

                        for(Language language : Language.Array_Language_Borrowed)
                        {
                            System.out.println(line);
                            System.out.println(language.get_information_language_borrowed(language));
                        }

                        System.out.println("Which book do you want to return? ");
                        System.out.println("Enter the system number of the book you want to return in the system (First number in Information): ");

                        int language_book_order = scanner.nextInt();

                        if(language_book_order > Language.Array_Language_Borrowed.size())
                        {
                            System.out.println("You entered bigger than in the system. Program is going to stop.");
                            return;
                        }
                        else
                        {   // Arrayin icine gidip icindeki bilgiyi buna yollayacagiz
                            l1.giveBackBook(Language.Array_Language_Borrowed.get(language_book_order));
                        }

                        if(wannaContinue()) // Devam mi diye soruyoruz
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Exiting From Library.");
                            Thread.sleep(2000);
                            System.out.println("Exited From Library.");
                            return;
                        }
                    }
                }
                else if(input1 == 0)
                {
                    System.out.println("See you later.");
                    System.out.println("Library is going to shut down.");
                        Thread.sleep(1000);
                    System.out.println("Terminated.");
                    return;
                }
                else
                {
                    System.out.println(warning);
                    System.out.println("You entered a different entry than expected. Library shutting down.");
                    return;
                }
            }
        }catch (Exception e)
        {
            System.out.println("An error happened. " + warning);
            System.out.println("Error Message: " + e);
        }
    }
}


