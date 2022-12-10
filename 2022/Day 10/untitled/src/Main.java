import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, Integer> signalStrength = new HashMap<>();
    static int count = 0;
    static int pos = 0;
    static String resultString = "";
    static int X = 1;


    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        List<String> commands = fileManager.readInput();
        for (String command : commands) {
            String[] commandSplit = command.split(" ");
            if (commandSplit[0].equals("noop")) {
                doCycle(X);
            } else {
                doCycle(X);
                doCycle(X);
                int amount = Integer.valueOf(commandSplit[1]);
                X = amount + X;
            }
        }
        int total = signalStrength.values().stream().reduce(0, Integer::sum);
        System.out.println("value:" + total);
        System.out.println(resultString);
    }

    static void doCycle(int X) {
        printImage(X);
        count++;
        if (count == 20 || (count - 20) % 40 == 0) {
            signalStrength.put(count, (X * count));
        }
    }

    static void printImage(int X) {
        if (count > 0 && count % 40 == 0) {
            pos = 0;
            resultString += "\n";
        }
        if (pos == X || pos == X - 1 || pos == X + 1){
            resultString += "#";
        } else {
            resultString += ".";
        }
        pos++;
    }
}