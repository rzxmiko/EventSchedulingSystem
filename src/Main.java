import java.util.*;
public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        manager.addParticipant(new Participant("Alice", 21));
        manager.addParticipant(new Participant("Bob", 28));
        manager.addParticipant(new Participant("Charlie", 20));

        System.out.println("--- All ---");
        manager.printAll();

        System.out.println("\n--- Sorted ---");
        manager.sortByAge();
        manager.printAll();

        System.out.println("\n--- Search ---");
        manager.findByName("Alice");
    }
}