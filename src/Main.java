public class Main {
    public static void main(String[] args) {
        Participant p1 = new Participant("Alice", 22);
        Participant p2 = new Participant("Bob", 28);

        Event meeting = new Event("Tech Talk", 15.5, true);

        Organizer org1 = new Organizer("John", 5);
        Organizer org2 = new Organizer("Sara", 10);

        System.out.println("=== SYSTEM INFO ===");
        meeting.printInfo();
        org1.printInfo();
        org2.printInfo();

        System.out.println("\n=== COMPARISON ===");
        int result = org1.compareExperience(org2);
        if (result < 0) {
            System.out.println(org2.getName() + " has more experience than " + org1.getName());
        } else if (result > 0) {
            System.out.println(org1.getName() + " has more experience than " + org2.getName());
        } else {
            System.out.println("They have equal experience.");
        }

        System.out.println("\n=== PARTICIPANTS LIST ===");
        Participant[] guests = {p1, p2};
        for (int i = 0; i < guests.length; i++) {
            System.out.println("Guest " + (i + 1) + ": " + guests[i].getName());
        }
    }
}