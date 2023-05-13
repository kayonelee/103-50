import java.util.ArrayList;
import java.util.Scanner;

//ENCAPSULATION---------------
public class TvShow {
    private String showName;
    private int numEpisodes;
    private String showGenre;

//CONSTRUCTOR-NO RETURN-THREE PARAMETERS
    public TvShow(String showName, int numEpisodes, String showGenre) {
        this.showName = showName;
        this.numEpisodes = numEpisodes;
        this.showGenre = showGenre;
    }
// THREE GETTER METHOD---Use getters within the toString() method to print the attributes.
    public String getShowName() {
        return showName;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }

    public String getGenre() {
        return showGenre;
    }

    @Override
    public String toString() {
        return " Your favorite TV Show is " + showName + " with " + numEpisodes + " episodes. " + "The genre is " + showGenre + " !! ";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TvShow> tvShows = new ArrayList<>();

//LOOPING UNTIL USER ENTERS NOTHING TO BREAK IT---------------
        while (true) {
            System.out.print("What is the name of your favorite TV show? (To end session enter nothing)");
            String showName = scanner.nextLine();

            if (showName.isEmpty()) {
                break;
            }

            System.out.print("How many episodes does it have? ");
            int numEpisodes = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("What is the genre? ");
            String showGenre = scanner.nextLine();

            TvShow tvShow = new TvShow(showName, numEpisodes, showGenre);
            tvShows.add(tvShow);
        }

        System.out.println("\nList the name of the TV Show:");
        System.out.println();
        for (TvShow tvShow : tvShows) {
            System.out.println(tvShow.toString());
        }
    }
}
