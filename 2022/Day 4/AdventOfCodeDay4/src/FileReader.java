import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    List<String> readCleaningPairsFile(){
        List<String> cleaningPairsList = new ArrayList<>();
        File cleaningPairs = new File("src/CleaningPairsInput.txt");
        try {
            Scanner scanner = new Scanner(cleaningPairs);
            while(scanner.hasNext()){
                cleaningPairsList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cleaningPairsList;
    }
}
