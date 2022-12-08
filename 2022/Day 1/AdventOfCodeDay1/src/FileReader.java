import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    List<Long> readFileIntoList() {
        File calorieFile = new File("src/CalorieInput.txt");
        try {
            List<Long> calorieTotalList = new ArrayList<>();
            Long calorieCurrentTotal = Long.valueOf(0);
            Scanner scanner = new Scanner(calorieFile);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.equals("") || line.equals(null)){
                    calorieTotalList.add(calorieCurrentTotal);
                    calorieCurrentTotal = Long.valueOf(0);
                } else {
                    calorieCurrentTotal += Long.valueOf(line);
                }
            }
            return calorieTotalList;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
