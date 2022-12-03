import java.util.List;

public class GroupRuckSackSorting {
    String rucksackOne;
    String rucksackTwo;
    String rucksackThree;
    String commonLetter;

    int getTotalsForRepeatingCharacters(GroupRucksack rucksacks) {
        setRucksacks(rucksacks);
        char commonLetter = findCommonLetterInGroup();
        LetterToNumberUtil letterToNumberUtil = new LetterToNumberUtil();
        return letterToNumberUtil.letterToNumber(commonLetter);
    }

    void setRucksacks(GroupRucksack rucksacks) {
        rucksackOne = rucksacks.getRucksackOne();
        rucksackTwo = rucksacks.getRucksackTwo();
        rucksackThree = rucksacks.getRucksackThree();
    }

    char findCommonLetterInGroup() {
        char commonChar = 0;
        for (int i = 0; i < rucksackOne.length(); i++) {
            for (int j = 0; j < rucksackTwo.length(); j++) {
                for (int k = 0; k < rucksackThree.length(); k++) {
                    if (rucksackOne.charAt(i) == rucksackTwo.charAt(j) && rucksackThree.charAt(k) == rucksackTwo.charAt(j))
                        commonChar = rucksackOne.charAt(i);
                }
            }
        }
        return commonChar;
    }
}
