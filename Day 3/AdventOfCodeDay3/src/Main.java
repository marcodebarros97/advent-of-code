import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> rucksackInputList = fileReader.createListOfRucksacks();
        List<GroupRucksack> groupRucksackList = fileReader.createListOfGroupRucksacks();
        RucksackSorting rucksackSorting = new RucksackSorting();
        int totalPartOne = partOne(rucksackInputList);
        int totalPartTwo = partTwo(groupRucksackList);

        System.out.println("Part One = " + totalPartOne);
        System.out.println("Part Two = " + totalPartTwo);
    }

    static int partOne(List<String> rucksackInputList) {
        RucksackSorting rucksackSorting = new RucksackSorting();
        int commonLetterTotals = 0;
        for (String rucksack :
                rucksackInputList) {
            commonLetterTotals += rucksackSorting.getTotalsForRepeatingCharacters(rucksack);
        }
        return commonLetterTotals;
    }

    static int partTwo(List<GroupRucksack> rucksackInputList) {
        GroupRuckSackSorting groupRuckSackSorting = new GroupRuckSackSorting();
        int commonLetterTotals = 0;
        for (GroupRucksack groupRucksack: rucksackInputList) {
            commonLetterTotals += groupRuckSackSorting.getTotalsForRepeatingCharacters(groupRucksack);
        }
        return commonLetterTotals;
    }
}