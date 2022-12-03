import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    List<String> readFile() {
        List<String> rucksackList = new ArrayList<>();
        File input = new File("src/RucksackInput.txt");
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                rucksackList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rucksackList;
    }

    List<RucksackGroup> readFileForRucksackGroup() {
        List<RucksackGroup> rucksackGroupList = new ArrayList<>();
        File input = new File("src/RucksackInput.txt");
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                RucksackGroup rucksackGroup = new RucksackGroup(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                rucksackGroupList.add(rucksackGroup);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rucksackGroupList;
    }
}
