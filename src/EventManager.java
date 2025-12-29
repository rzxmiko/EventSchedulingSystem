import java.util.*;
public class EventManager {
    private List<Participant> participants = new ArrayList<>();
    public void addParticipant(Participant p) {
        participants.add(p);
    }

    public void sortByAge() {
        participants.sort(Comparator.comparingInt(Participant::getAge));
    }

    public void findByName(String name) {
        for (Participant p : participants) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + p);
            }
        }
    }

    public void filterByAge(int minAge) {
        for (Participant p : participants) {
            if (p.getAge() >= minAge) {
                System.out.println(p);
            }
        }
    }

    public void printAll() {
        for (Participant p : participants) {
            System.out.println(p);
        }
    }
}