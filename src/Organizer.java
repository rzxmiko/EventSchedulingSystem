import java.util.Objects;
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
        return super.toString() + ", Experience: " + experience;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Organizer organizer = (Organizer) o;
        return experience == organizer.experience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experience);
    }
}