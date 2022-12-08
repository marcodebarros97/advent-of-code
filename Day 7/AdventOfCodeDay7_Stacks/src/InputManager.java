import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    List<String> readInput() {
        List<String> fileSystem = new ArrayList<>();
        File file = new File("src/FileSystem.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                fileSystem.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fileSystem;
    }
}
