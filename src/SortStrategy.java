import java.util.List;
import java.util.Comparator;

public class SortByAge implements SortStrategy {
    @Override
    public void sort(List<Participant> participants) {
        participants.sort(Comparator.comparingInt(Participant::getAge));
    }
}