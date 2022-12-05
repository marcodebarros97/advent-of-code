import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    List<Move> createListOfMoves() {
        List<Move> moveList = new ArrayList<>();
        File movesFile = new File("src/Moves.txt");
        try {
            Scanner scanner = new Scanner(movesFile);
            scanner.useDelimiter("\\D+");
            while (scanner.hasNext()) {
                int moveQuantity = scanner.nextInt();
                int moveFrom = scanner.nextInt();
                int moveTo = scanner.nextInt();

                moveList.add(new Move(moveQuantity, moveFrom, moveTo));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return moveList;
    }
}
