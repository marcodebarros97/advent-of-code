import java.util.List;

public class RucksackSorting {
    int sortRucksackAndPrioritise(String rucksack) {
        String compartmentOne = rucksack.substring(0, rucksack.length() / 2);
        String compartmentTwo = rucksack.substring(rucksack.length() / 2);
        int letterAsNumber = 0;
        for (int i = 0; i < compartmentOne.length(); i++) {
            for (int j = 0; j < compartmentTwo.length(); j++) {
                if (compartmentOne.charAt(i) == compartmentTwo.charAt(j)) {
                    letterAsNumber = getNumberFromLetter(compartmentOne.charAt(i));
                }
            }
        }
        return letterAsNumber;
    }

    int sortRucksackAndPrioritiseGroup(RucksackGroup rucksackGroup) {
        String rucksackOne = rucksackGroup.getRucksackOne();
        String rucksackTwo = rucksackGroup.getRucksackTwo();
        String rucksackThree = rucksackGroup.getRucksackThree();

        int letterAsNumber = 0;
        for (int i = 0; i < rucksackOne.length(); i++) {
            for (int j = 0; j < rucksackTwo.length(); j++) {
                for (int k = 0; k < rucksackThree.length(); k++) {
                    if (rucksackOne.charAt(i) == rucksackTwo.charAt(j) && rucksackTwo.charAt(j) == rucksackThree.charAt(k)) {
                        letterAsNumber = getNumberFromLetter(rucksackOne.charAt(i));
                    }
                }
            }
        }
        return letterAsNumber;
    }


    private int getNumberFromLetter(char rucksackItem) {
        return !Character.isUpperCase(rucksackItem) ? rucksackItem - 'a' + 1 : rucksackItem - 'A' + 27;
    }
}
