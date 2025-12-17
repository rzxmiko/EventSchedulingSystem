public class Event {
    private String title;
    private double price;
    private boolean isOnline;

    public Event(String title, double price, boolean isOnline) {
        this.title = title;
        this.price = price;
        this.isOnline = isOnline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void printInfo() {
        System.out.println("Event: " + title + ", Price: $" + price + ", Online: " + isOnline);
    }
}