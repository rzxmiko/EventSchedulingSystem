import java.util.*;
public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        manager.addParticipant(new Participant("Alice", 21));
        manager.addParticipant(new Participant("Bob", 28));
        manager.addParticipant(new Participant("Charlie", 17)); // Для теста фильтра

        System.out.println("--- All ---");
        manager.printAll();

        System.out.println("\n--- Sorted ---");
        manager.sortByAge();
        manager.printAll();

        System.out.println("\n--- Search ---");
        manager.findByName("Alice");

        // --- ДОБАВЛЕН ВЫЗОВ ФИЛЬТРАЦИИ ---
        System.out.println("\n--- Filtering: Adults Only (18+) ---");
        manager.filterByAge(18);
    }
}