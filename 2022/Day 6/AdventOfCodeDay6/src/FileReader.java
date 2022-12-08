import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    String readInputFile(){
        String deviceSignals = null;
        File input = new File("src/input.txt");
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()){
                deviceSignals = scanner.next();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deviceSignals;
    }
}
