import java.util.ArrayList;
import java.util.Scanner;

public class TvShowConstructor {
    private String showName;
    private int numEpisodes;
    private String showGenre;
    private boolean familyFriendly;

    public TvShowConstructor(String showName, int numEpisodes, String showGenre, boolean familyFriendly) {
        this.showName = showName;
        this.numEpisodes = numEpisodes;
        this.showGenre = showGenre;
        this.familyFriendly = familyFriendly;
    }

    public String getShowName() {
        return showName;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }

    public String getGenre() {
        return showGenre;
    }

    public boolean isFamilyFriendly() {
        return familyFriendly;
    }

    @Override
    public String toString() {
        return "Your favorite TV Show is " + showName + " with " + numEpisodes + " episodes. " +
                "The genre is " + showGenre + " and it is " + (familyFriendly ? "" : "not ") + "family friendly.";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TvShowConstructor> tvShows = new ArrayList<>();

        while (true) {
            System.out.print("What is the name of your favorite TV show? (To end session enter nothing)");
            String showName = scanner.nextLine();

            if (showName.isEmpty()) {
                break;
            }

            System.out.print("How many episodes does it have? ");
            int numEpisodes = scanner.nextInt();
            scanner.nextLine();

            System.out.print("What is the genre? ");
            String showGenre = scanner.nextLine();

            System.out.print("Is it family friendly? (y/n) ");
            boolean familyFriendly = scanner.nextLine().equalsIgnoreCase("y");

            TvShowConstructor tvShow = new TvShowConstructor(showName, numEpisodes, showGenre, familyFriendly);
            tvShows.add(tvShow);
        }

        System.out.println("\nList of TV Shows:");
        System.out.println();
        for (TvShowConstructor tvShowConstructor : tvShows) {
            TvShow tvShow = new TvShow(tvShowConstructor.getShowName(), tvShowConstructor.getNumEpisodes(), tvShowConstructor.getGenre());
            System.out.println(tvShow.toString());
        }
    }
}
