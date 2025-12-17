public class Organizer {
    private String name;
    private int experience;

    public Organizer(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int compareExperience(Organizer other) {
        return Integer.compare(this.experience, other.experience);
    }

    public void printInfo() {
        System.out.println("Organizer: " + name + ", Experience: " + experience + " years");
    }
}