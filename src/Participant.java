import java.util.Objects;
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
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Participant that = (Participant) o;
        return age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }
}