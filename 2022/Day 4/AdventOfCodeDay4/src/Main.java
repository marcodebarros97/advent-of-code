import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> cleaningPairs = fileReader.readCleaningPairsFile();
        System.out.println("Number of overlapping cleaning pairs is " + partOne(cleaningPairs));
        System.out.println("Number of any overlapping cleaning pairs is " + partTwo(cleaningPairs));
    }

    static int partOne(List<String> cleaningPairs) {
        CleaningPairsSorting cleaningPairsSorting = new CleaningPairsSorting();
        AtomicInteger overlapCounter = new AtomicInteger();
        cleaningPairs.forEach(cleaningPair -> {
            if (cleaningPairsSorting.countFullyOverlappingCleaningPairs(cleaningPair)) {
                overlapCounter.getAndIncrement();
            }
        });
        return overlapCounter.get();
    }

    static int partTwo(List<String> cleaningPairs) {
        CleaningPairsSorting cleaningPairsSorting = new CleaningPairsSorting();
        AtomicInteger overlapCounter = new AtomicInteger();
        cleaningPairs.forEach(cleaningPair -> {
            if (cleaningPairsSorting.countAnyOverlappingCleaningPairs(cleaningPair)) {
                overlapCounter.getAndIncrement();
            }
        });
        return overlapCounter.get();
    }
}