import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    List<String> readInputStrategy(){
        List<String> strategyLines = new ArrayList<>();
        File strategy = new File("src/Strategy.txt");
        try {
            Scanner scanner = new Scanner(strategy);
            while (scanner.hasNext()){
                strategyLines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return strategyLines;
    }
}
