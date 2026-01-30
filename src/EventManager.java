import java.util.List;
import java.util.Comparator;
public class EventManager {
    private ParticipantRepository repository;
    private SortStrategy sortStrategy;

    public EventManager(ParticipantRepository repository, SortStrategy sortStrategy) {
        this.repository = repository;
        this.sortStrategy = sortStrategy;
    }

    public void printAllParticipants() throws SQLException {
        List<Participant> participants = repository.getAllParticipants();
        sortStrategy.sort(participants); // Использование стратегии сортировки
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }

    public void addParticipant(Participant participant) throws SQLException {
        repository.addParticipant(participant);
    }

    public void updateParticipantAge(int id, int newAge) throws SQLException {
        repository.updateParticipantAge(id, newAge);
    }

    public void deleteParticipant(int id) throws SQLException {
        repository.deleteParticipant(id);
    }
}