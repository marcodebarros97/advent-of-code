import java.util.Collections;
import java.util.List;

public class CleaningPairsSorting {

    CleaningPairsConverter cleaningPairsConverter = new CleaningPairsConverter();

    boolean countFullyOverlappingCleaningPairs(String cleaningPair){
        String[] splitCleaningRanges = cleaningPair.split(",");
        String cleaningRangeOne = splitCleaningRanges[0];
        String cleaningRangeTwo = splitCleaningRanges[1];

        List<Integer> firstRange = cleaningPairsConverter.createRange(cleaningRangeOne);
        List<Integer> secondRange = cleaningPairsConverter.createRange(cleaningRangeTwo);

        if (firstRange.containsAll(secondRange) || secondRange.containsAll(firstRange)){
            return true;
        } else {
            return false;
        }
    }

    boolean countAnyOverlappingCleaningPairs(String cleaningPair){
        String[] splitCleaningRanges = cleaningPair.split(",");
        String cleaningRangeOne = splitCleaningRanges[0];
        String cleaningRangeTwo = splitCleaningRanges[1];

        List<Integer> firstRange = cleaningPairsConverter.createRange(cleaningRangeOne);
        List<Integer> secondRange = cleaningPairsConverter.createRange(cleaningRangeTwo);

        if (!Collections.disjoint(firstRange, secondRange)){
            return true;
        } else {
            return false;
        }
    }
}
