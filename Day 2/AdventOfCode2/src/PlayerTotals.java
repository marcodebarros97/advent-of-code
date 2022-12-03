import java.util.List;
import java.util.Map;

public class PlayerTotals {
    public static Map<String, Integer> pointRules = Map.of(
            "A X", 4,
            "A Y", 8,
            "A Z", 3,
            "B X", 1,
            "B Y", 5,
            "B Z", 9,
            "C X", 7,
            "C Y", 2,
            "C Z", 6
    );
    public static Map<String, Integer> pointRules2 = Map.of(
            "A X", 3,
            "A Y", 4,
            "A Z", 8,
            "B X", 1,
            "B Y", 5,
            "B Z", 9,
            "C X", 2,
            "C Y", 6,
            "C Z", 7
    );

    public int getTotal(List<String> rounds) {
        int score = 0;
        for (String line : rounds) {
            int roundTotal = pointRules.get(line);
            score += roundTotal;
        }
        return score;
    }
}
