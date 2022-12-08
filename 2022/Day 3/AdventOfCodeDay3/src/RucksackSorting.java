import java.util.List;

public class RucksackSorting {
    String compartmentOne;
    String compartmentTwo;
    String commonLetter;

    int getTotalsForRepeatingCharacters(String rucksack) {
        createCompartments(rucksack);
        char commonLetter = findCommonItem();
        LetterToNumberUtil letterToNumberUtil = new LetterToNumberUtil();
        return letterToNumberUtil.letterToNumber(commonLetter);
    }

    void createCompartments(String rucksack) {
        int length = rucksack.length();
        compartmentOne = rucksack.substring(0, (length / 2));
        compartmentTwo = rucksack.substring((length / 2));
    }

    char findCommonItem() {
        char commonChar = 0;
        for (int i = 0; i < compartmentOne.length(); i++){
            for (int k = 0; k < compartmentOne.length(); k++) {
                if (compartmentOne.charAt(i) == compartmentTwo.charAt(k)){
                    commonLetter = String.valueOf(commonChar);
                    commonChar = compartmentOne.charAt(i);
                } 
            }
        }
        return commonChar;
    }
}
