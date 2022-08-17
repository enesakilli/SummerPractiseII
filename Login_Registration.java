import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

class Registration // Javademostaki Registration txt'in icini silip calistirmak gerekiyor yoksa hata verir cunku username/passwordu kayit ediyor
{
    public void register() throws FileNotFoundException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        System.out.println(username);

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println(password);

        System.out.println("Confirm Password: ");
        String ConfirmPassword = scanner.nextLine();
        System.out.println(ConfirmPassword);

        System.out.println("Enter E-mail: ");
        String email = scanner.nextLine();
        System.out.println(email);

        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println(phoneNumber);

        username = username.trim();
        password = password.trim();
        ConfirmPassword = ConfirmPassword.trim();

        String userNameAndPassword = username + " " + password;

        if(password.equals(ConfirmPassword))
        {

            File file = new File("Registration.txt");
            Scanner content = new Scanner(file);

            int flag = 0;

            while (content.hasNextLine())
            {
                String data = content.nextLine();
                if(data.equals(userNameAndPassword))
                {
                    System.out.println("Already Registered!");
                    flag=1;
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");

                    System.out.println("Enter your Choice: ");
                    int choice=scanner.nextInt();
                    if(choice==1)
                    {
                        this.register();
                    }
                    else if(choice==2)
                    {
                        this.login();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option!");
                    }
                    break;
                }
                content.close();
            }

            if(flag==0)
            {
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("Registration.txt", true));
                    out.write(username + " " + password +"\n");
                    out.close();
                }
                catch (IOException e)
                {
                    System.out.println("Exception Occurred" + e);
                }

                System.out.println("Successfully Registered!");
                System.out.println("Please login!");
                this.login();
            }
        }
        else
        {
            System.out.println("Error Please Recheck.");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");

            System.out.println("Enter your Choice: ");
            int choice=scanner.nextInt();
            if(choice==1)
            {
                this.register();
            }
            else if(choice==2)
            {
                this.login();
            }
            else
            {
                System.out.println("Choose Proper Option!");
            }
        }
        scanner.close();
    }
    public void login()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String username = scanner.nextLine();
        System.out.println(username);

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println(password);

        username = username.trim();
        password = password.trim();
        String userNameAndPassword = username + " " + password;
        
        try
        {
            File file = new File("Registration.txt");
            Scanner content = new Scanner(file);

            int flag=0;

            while (content.hasNextLine())
            {
                String data = content.nextLine();
                if(data.equals(userNameAndPassword))
                {
                    System.out.println("Login Successful!");
                    System.out.println("Welcome to the Application.");
                    flag=1;
                    break;
                }
            }

            if(flag==0)
            {
                System.out.println("Login Failed");
                System.out.println("1. Registration. ");
                System.out.println("2. Login. ");

                System.out.println("Enter your Choice: ");
                int choice=scanner.nextInt();
                if(choice==1)
                {
                    this.register();
                }
                else if(choice==2)
                {
                    this.login();
                }
                else
                {
                    System.out.println("Choose Proper Option!");
                }
            }

            content.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error.");
            e.printStackTrace();
        }

        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        File obj = new File("Registration.txt");

        int choice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("IMPORTANT! If you are not Registered, you cannot Login. ");
        System.out.println("1. Registration. ");
        System.out.println("2. Login. ");

        System.out.println("Enter your Choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1)
        {
            Registration user = new Registration();
            user.register();
        }
        else if (choice == 2)
        {
            Registration user = new Registration();
            user.login();
        }
        else
        {
            System.out.println("Choose Proper Option!");
        }
        scanner.close();
    }
}