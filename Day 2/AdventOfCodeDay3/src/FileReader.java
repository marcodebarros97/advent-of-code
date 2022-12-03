import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    List<String> createListOfRucksacks(){
        List<String> rucksackList = new ArrayList<>();
        File input = new File("src/RucksackInput.txt");
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()){
                rucksackList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rucksackList;
    }

    List<GroupRucksack> createListOfGroupRucksacks(){
        List<GroupRucksack> groupRucksackList = new ArrayList<>();
        File input = new File("src/RucksackInput.txt");
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()){
                String rucksackOne = scanner.nextLine();
                String rucksackTwo = scanner.nextLine();
                String rucksackThree = scanner.nextLine();
                groupRucksackList.add(new GroupRucksack(rucksackOne, rucksackTwo, rucksackThree));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return groupRucksackList;
    }
}
