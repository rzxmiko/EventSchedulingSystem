import java.util.*;
public class Organizer extends Person {
    private int experience;

    public Organizer(String name, int experience) {
        super(name);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return super.toString() + ", Experience: " + experience + " years";
    }
}