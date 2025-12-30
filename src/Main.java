public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        manager.addParticipant(new Participant("Alice", 21));
        manager.addParticipant(new Participant("Bob", 28));
        manager.addParticipant(new Participant("Charlie", 17));

        System.out.println("All");
        manager.printAll();

        System.out.println("\nSorted by Age");
        manager.sortByAge();
        manager.printAll();

        System.out.println("\nSearch");
        manager.findByName("Alice");

        System.out.println("\nFilter 18+");
        manager.filterByAge(18);
    }
}