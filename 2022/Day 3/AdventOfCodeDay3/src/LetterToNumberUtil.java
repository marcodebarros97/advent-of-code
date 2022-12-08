public class LetterToNumberUtil {
    public int letterToNumber(char item) {
        int number = 0;
        if (item >= 'a' && item <= 'z') {
            number = item - 'a' + 1;
        } else {
            if (item >= 'A' && item <= 'Z') {
                number = item - 'A' + 27;
            }
        }
        return number;
    }
}
