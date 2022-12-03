import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> strategyLines = fileReader.readInputStrategy();
        PlayerTotals playerTotals = new PlayerTotals();
        System.out.println("Player total = " + playerTotals.getTotal(strategyLines));
    }
}