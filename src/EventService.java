import java.sql.SQLException;
import java.util.Scanner;

public class EventService {
    private EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void showEvents() throws SQLException {
        eventDAO.showEvents();
    }

    public void createEvent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название события: ");
        String eventName = scanner.next();
        System.out.print("Введите дату события: ");
        String eventDate = scanner.next();

        eventDAO.createEvent(eventName, eventDate);
    }

    public void updateEvent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id события для обновления: ");
        int eventId = scanner.nextInt();
        System.out.print("Введите новое название события: ");
        String newEventName = scanner.next();
        System.out.print("Введите новую дату события: ");
        String newEventDate = scanner.next();

        eventDAO.updateEvent(eventId, newEventName, newEventDate);
    }

    public void deleteEvent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id события для удаления: ");
        int eventId = scanner.nextInt();

        eventDAO.deleteEvent(eventId);
    }
}