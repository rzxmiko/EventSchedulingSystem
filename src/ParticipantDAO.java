import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipantDAO {
    private Connection connection;

    public ParticipantDAO(Connection connection) {
        this.connection = connection;
    }

    public void showParticipants() throws SQLException {
        String SQL_SELECT = "SELECT * FROM participants";
        PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("Id: " + rs.getInt("id") + " Name: " + rs.getString("name") + " Age: " + rs.getInt("age"));
        }
    }

    public void createParticipant(String name, int age) throws SQLException {
        String SQL_INSERT = "INSERT INTO participants(name, age) VALUES (?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.executeUpdate();
    }

    public void updateParticipant(int id, int newAge) throws SQLException {
        String SQL_UPDATE = "UPDATE participants SET age = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
        pstmt.setInt(1, newAge);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
    }

    public void deleteParticipant(int id) throws SQLException {
        String SQL_DELETE = "DELETE FROM participants WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(SQL_DELETE);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}