import java.util.ArrayList;
import java.util.Scanner;

public class BookConstructor {
    private String title;
    private int numPages;
    private int publicationYear;
    private boolean recommend;

    public BookConstructor(String title, int numPages, int publicationYear, boolean recommend) {
        this.title = title;
        this.numPages = numPages;
        this.publicationYear = publicationYear;
        this.recommend = recommend;
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

    public boolean isRecommended() {
        return recommend;
    }

    public static void main(String[] args) {
        ArrayList<BookConstructor> books = new ArrayList<>();
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

            System.out.print(" Do you recommend this book? (true/false) ");
            boolean recommend = Boolean.parseBoolean(scanner.nextLine());

            books.add(new BookConstructor(title, numPages, publicationYear, recommend));
        }

        // PRINTING
        System.out.print("What would you like to print? (name/everything): ");
        String printOption = scanner.nextLine();
        if (printOption.equals("name")) {
            for (BookConstructor book : books) {
                System.out.println(book.getTitle());
            }
        } else if (printOption.equals("everything")) {
            for (BookConstructor book : books) {
                System.out.println(book.getTitle() + " , " + book.getNumPages() + " pages, published in " + book.getPublicationYear() + ", recommended: " + book.isRecommended());
            }
        } else {
            System.out.println("Invalid option");
        }
    }
}
