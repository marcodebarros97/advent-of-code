import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FileReader fileReader = new FileReader();
        List<Long> calorieTotalList = fileReader.readFileIntoList();
        Collections.sort(calorieTotalList, Collections.reverseOrder());
        List<Long> top3 = calorieTotalList.stream().limit(3).collect(Collectors.toList());
        Long total = top3.stream().collect(Collectors.summingLong(Long::longValue)).longValue();
        System.out.println("Highest calorie amount held by an elf: " + total);
    }
}