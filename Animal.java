import java.util.ArrayList;
import java.util.Scanner;

public class Animal {
    private String name;
    private boolean isDog;

//CONSTRUCTOR-------------
    public Animal(String name, boolean isDog) {
        this.name = name;
        this.isDog = isDog;
    }

    public String getName() {
        return name;
    }

    public boolean isDog() {
        return isDog;
    }

    @Override
    public String toString() {
        return "Animal: " + " Name: " + name + " , is considered a dog = " + isDog;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();

        while (true) {
            System.out.print("Enter your animal or pet name (To exit please enter nothing): ");
            String name = scanner.nextLine();

//BREAK IF USER ENTERS NOTHING
            if (name.isEmpty()) {
                break;
            }

            System.out.print("Is it a dog? (true/false): ");
            boolean isDog = scanner.nextBoolean();
            scanner.nextLine();

            Animal animal = new Animal(name, isDog);
            animals.add(animal);
        }
//PRINT USING A LOOP
        System.out.println("\nList of animals:");
        System.out.println();
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
