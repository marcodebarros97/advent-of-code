import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    List<String> readInput() {
        List<String> commands = new ArrayList<>();
        File file = new File("src/input.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                commands.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return commands;
    }
}
