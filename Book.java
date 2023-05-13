import java.util.ArrayList;
import java.util.Scanner;

//ENCAPSULATION-SET TO PRIVATE-GETTER METHOD
public class Book {
    private String title;
    private int numPages;
    private int publicationYear;

    public Book(String title, int numPages, int publicationYear) {
        this.title = title;
        this.numPages = numPages;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("What is the name of your favorite book? (submit an empty string to end session) ");
            String title = scanner.nextLine();
            if (title.equals("")) {
                break;
            }

            System.out.print(" How many pages total? ");
            int numPages = Integer.parseInt(scanner.nextLine());

            System.out.print(" What year was it published? ");
            int publicationYear = Integer.parseInt(scanner.nextLine());

            books.add(new Book(title, numPages, publicationYear));
        }

// PRINTING
        System.out.print("What would you like to print? (name/everything): ");
        String printOption = scanner.nextLine();
        if (printOption.equals("name")) {
            for (Book book : books) {
                System.out.println(book.getTitle());
            }
        } else if (printOption.equals("everything")) {
            for (Book book : books) {
                System.out.println(book.getTitle() + " , " + book.getNumPages() + " pages, published in " + book.getPublicationYear() + ")");
            }
        } else {
            System.out.println("Invalid option");
        }
    }
}

