import java.util.ArrayList;
import java.util.Scanner;

public class AnimalConstructor {
    private String name;
    private boolean isDog;
    private int age;

    //CONSTRUCTOR-------------
    public AnimalConstructor(String name, boolean isDog) {
        this.name = name;
        this.isDog = isDog;
    }
    public AnimalConstructor(String name, boolean isDog, int age) {
        this.name = name;
        this.isDog = isDog;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public boolean isDog() {
        return isDog;

    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Animal: " + " Name: " + name + " , is considered a dog = " + isDog + " , age: " + age;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<AnimalConstructor> animals = new ArrayList<>();

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

            System.out.print("What is the age of the animal: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            AnimalConstructor animal = new AnimalConstructor(name, isDog);
            AnimalConstructor animalWithAge = new AnimalConstructor(name, isDog, age);

            animals.add(animalWithAge);
        }

        //PRINT USING A LOOP
        System.out.println("\nList of animals:");
        System.out.println();
        for (AnimalConstructor animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
