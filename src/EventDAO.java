import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EventDAO {
    private Connection connection;

    public EventDAO(Connection connection) {
        this.connection = connection;
    }

    public void createEvent(String eventName, String eventDate) throws SQLException {
        // Проверяем формат даты
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate;
        try {
            parsedDate = sdf.parse(eventDate); // Преобразуем строку в java.util.Date
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неверный формат даты. Ожидается формат: YYYY-MM-DD");
        }

        // Преобразуем java.util.Date в java.sql.Date
        Date sqlDate = new Date(parsedDate.getTime());

        String SQL_INSERT = "INSERT INTO events(event_name, event_date) VALUES (?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
        pstmt.setString(1, eventName);
        pstmt.setDate(2, sqlDate);  // Используем объект java.sql.Date
        pstmt.executeUpdate();
    }

    public void showEvents() throws SQLException {
        String SQL_SELECT = "SELECT * FROM events";
        PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("Id: " + rs.getInt("id") + " Event Name: " + rs.getString("event_name") + " Event Date: " + rs.getDate("event_date"));
        }
    }

    public void updateEvent(int eventId, String newEventName, String newEventDate) throws SQLException {
        // Проверка даты
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate;
        try {
            parsedDate = sdf.parse(newEventDate); // Преобразуем строку в java.util.Date
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неверный формат даты. Ожидается формат: YYYY-MM-DD");
        }

        // Преобразуем в java.sql.Date
        Date sqlDate = new Date(parsedDate.getTime());

        String SQL_UPDATE = "UPDATE events SET event_name = ?, event_date = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
        pstmt.setString(1, newEventName);
        pstmt.setDate(2, sqlDate);
        pstmt.setInt(3, eventId);
        pstmt.executeUpdate();
    }

    public void deleteEvent(int eventId) throws SQLException {
        String SQL_DELETE = "DELETE FROM events WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(SQL_DELETE);
        pstmt.setInt(1, eventId);
        pstmt.executeUpdate();
    }
}