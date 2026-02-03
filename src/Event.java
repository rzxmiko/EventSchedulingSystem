import java.util.*;

public class Event {
    private String title;
    private double price;
    private Organizer organizer;
    private List<Participant> participants;

    public Event(String title, double price, Organizer organizer) {
        this.title = title;
        this.price = price;
        this.organizer = organizer;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    public void showParticipants() {
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }

    @Override
    public String toString() {
        return "Event: " + title + " ($" + price + "), " + organizer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event.price, price) == 0 && Objects.equals(title, event.title) && Objects.equals(organizer, event.organizer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, organizer);
    }
}