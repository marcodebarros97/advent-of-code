import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> rucksackList = fileReader.readFile();
        RucksackSorting rucksackSorting = new RucksackSorting();
        AtomicInteger totalForPartOne = new AtomicInteger();
        rucksackList.forEach(rucksack -> {
            totalForPartOne.addAndGet(rucksackSorting.sortRucksackAndPrioritise(rucksack));
        });

        AtomicInteger totalForPartTwo = new AtomicInteger();
        List<RucksackGroup> rucksackGroupList = fileReader.readFileForRucksackGroup();
        rucksackGroupList.forEach(rucksackGroup -> {
            totalForPartTwo.addAndGet(rucksackSorting.sortRucksackAndPrioritiseGroup(rucksackGroup));
        });

        System.out.println("Part one total " + totalForPartOne);
        System.out.println("Part two total " + totalForPartTwo);
    }
}