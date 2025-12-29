import java.util.*;
public class Participant extends Person {
    private int age;

    public Participant(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return super.toString() + ", Age: " + age;
    }
}