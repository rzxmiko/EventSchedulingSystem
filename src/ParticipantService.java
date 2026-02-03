import java.sql.SQLException;
import java.util.Scanner;
public class ParticipantService {
    private ParticipantDAO participantDAO;

    public ParticipantService(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    public void showParticipants() throws SQLException {
        participantDAO.showParticipants();
    }

    public void createParticipant() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        participantDAO.createParticipant(name, age);
    }

    public void updateParticipant() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id участника: ");
        int id = scanner.nextInt();
        System.out.print("Введите новый возраст: ");
        int newAge = scanner.nextInt();

        participantDAO.updateParticipant(id, newAge);
    }

    public void deleteParticipant() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id участника для удаления: ");
        int id = scanner.nextInt();

        participantDAO.deleteParticipant(id);
    }
}