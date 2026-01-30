import java.util.List;
import java.util.Comparator;
import java.util.*;

public class SortByAge implements SortStrategy {
    @Override
    public void sort(List<Participant> participants) {
        participants.sort(Comparator.comparingInt(Participant::getAge));
    }
}