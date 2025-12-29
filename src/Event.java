import java.util.*;
public class Event {
    private String title;
    private double price;
    private boolean isOnline;

    public Event(String title, double price, boolean isOnline) {
        this.title = title;
        this.price = price;
        this.isOnline = isOnline;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "Event: " + title + " ($" + price + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event.price, price) == 0 && Objects.equals(title, event.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}