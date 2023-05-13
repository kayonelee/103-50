import java.sql.SQLOutput;

public class Counter {
    private int value;

    public Counter(int startValue) {
        this.value = startValue;
    }

    public Counter() {
        this.value = 0;
    }

    public int value() {
        return value;
    }
//METHOD TO INCREASE VALUE OF COUNTER BY 1
    public void increase() {
        value++;
    }
//METHOD TO DECREASE VALUE OF COUNTER BY 1
    public void decrease() {
        value--;
    }
//METHOD ADDED TO INCREASE VALUE BY THE GIVEN INCREASEBY-If the value of increaseBy is negative, the counter's value does not change.
    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            value += increaseBy;
        }
    }
//METHOD ADDED TO DECREASE VALUE BY THE GIVEN DECREASEBY-If the value of decreaseBy is negative, the counter's value does not change.
    public void decrease(int decreaseBy) {
        if (decreaseBy > 0) {
            value -= decreaseBy;
        }
    }

//EXAMPLE-Then create an example in your main class that uses each method available in the class, including the constructor methods.
    public static void main(String[] args) {
        // SET STARTING VALUE TO BE 4
        Counter counter1 = new Counter(4);
        System.out.println("Counter 1 value: " + counter1.value());

        // SET STARTING VALUE TO BE 0
        Counter counter2 = new Counter();
        System.out.println("Counter 2 value: " + counter2.value());
        System.out.println("------------------");

        counter1.increase();
        System.out.println("The counter 1 value after an increase of 1 is: " + counter1.value());

        counter2.decrease();
        System.out.println("The counter 2 value after the decrease of 1 is: " + counter2.value());


        counter1.increase(100);
        System.out.println("The new counter 1 value after an increase of 100 is: " + counter1.value());


        counter2.decrease(-10); //VALUE IS NEGATIVE BUT THE COUNTER VALUE WILL NOT CHANGE/REFLECT
        System.out.println("The new counter 2 value after the decrease of -10 is: " + counter2.value());
    }
}

