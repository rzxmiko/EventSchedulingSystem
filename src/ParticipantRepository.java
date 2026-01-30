public class ParticipantRepository {
    private Connection connection;

    public ParticipantRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Participant> getAllParticipants() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SELECT = "SELECT * FROM participants";
        ResultSet rs = statement.executeQuery(SQL_SELECT);

        List<Participant> participants = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            participants.add(new Participant(name, age));
        }
        return participants;
    }

    public void addParticipant(Participant participant) throws SQLException {
        String SQL_INSERT = "INSERT INTO participants(name, age) VALUES (?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
        pstmt.setString(1, participant.getName());
        pstmt.setInt(2, participant.getAge());
        pstmt.executeUpdate();
    }

    public void updateParticipantAge(int id, int newAge) throws SQLException {
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