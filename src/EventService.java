import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
        System.out.print("Введите дату события (в формате YYYY-MM-DD): ");
        String eventDate = scanner.next();

        if (!isValidDate(eventDate)) {
            System.out.println("Неверный формат даты. Ожидается формат: YYYY-MM-DD");
            return;
        }

        List<Organizer> organizers = eventDAO.getAllOrganizers();
        System.out.println("Выберите организатора по ID:");
        for (int i = 0; i < organizers.size(); i++) {
            System.out.println((i + 1) + ". " + organizers.get(i).getName());
        }

        System.out.print("Введите ID организатора: ");
        int organizerId = scanner.nextInt();

        if (organizerId < 1 || organizerId > organizers.size()) {
            System.out.println("Неверный ID организатора.");
            return;
        }

        eventDAO.createEvent(eventName, eventDate, organizerId);
    }

    public void updateEvent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id события для обновления: ");
        int eventId = scanner.nextInt();
        System.out.print("Введите новое название события: ");
        String newEventName = scanner.next();
        System.out.print("Введите новую дату события (в формате YYYY-MM-DD): ");
        String newEventDate = scanner.next();

        if (!isValidDate(newEventDate)) {
            System.out.println("Неверный формат даты. Ожидается формат: YYYY-MM-DD");
            return;
        }

        eventDAO.updateEvent(eventId, newEventName, newEventDate);
    }

    public void deleteEvent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id события для удаления: ");
        int eventId = scanner.nextInt();

        eventDAO.deleteEvent(eventId);
    }

    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}