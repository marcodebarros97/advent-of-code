import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CleaningPairsConverter {
    List<Integer> createRange(String cleaningRange) {
        String[] rangeStartAndEnd = cleaningRange.split("-");
        return IntStream.rangeClosed(Integer.valueOf(rangeStartAndEnd[0]), Integer.valueOf(rangeStartAndEnd[1]))
                .boxed().collect(Collectors.toList());
    }
}
