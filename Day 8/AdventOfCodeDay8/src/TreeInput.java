import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeInput {
    List<String> readTreeInput(){
        List<String> trees = new ArrayList<>();
        File file = new File("src/TestInput.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                trees.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return trees;
    }
}
