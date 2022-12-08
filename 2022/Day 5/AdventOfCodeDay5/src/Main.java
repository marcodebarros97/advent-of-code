import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        List<Move> moveList = fileManager.createListOfMoves();
        System.out.println("Top Crates sequence: " + partOne(moveList));
        System.out.println("Top Crates sequence with new machine: " + partTwo(moveList));
    }

    static String partOne(List<Move> moveList){
        CrateManager crateManager = new CrateManager();
        return crateManager.getTopCrates(moveList);
    }

    static String partTwo(List<Move> moveList){
        CrateManager crateManager = new CrateManager();
        return crateManager.getTopCrates9001(moveList);
    }
}