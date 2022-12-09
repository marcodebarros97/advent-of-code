import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        File file = new File("src/Input.txt");
        List<String> fileSystem = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                fileSystem.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        DeviceDirectory root = new DeviceDirectory("/", null);
        DeviceDirectory currentDirectory = root;
        List<DeviceDirectory> allDirectories = new ArrayList<>();
        allDirectories.add(root);

        for (String line : fileSystem) {
            String[] lineSplit = line.split(" ");
            if ("$".equals(lineSplit[0])) {
                if ("cd".equals(lineSplit[1])) {
                    if ("/".equals(lineSplit[2])) {
                        currentDirectory = root;
                    } else if ("..".equals(lineSplit[2])) {
                        if (!currentDirectory.getName().equals("/")){
                            currentDirectory = currentDirectory.getParentDirectory();
                        }
                    } else {
                        currentDirectory = helpers.findDirectory(lineSplit[2], allDirectories);
                    }
                }
            } else if ("dir".equals(lineSplit[0])) {
                DeviceDirectory directory = new DeviceDirectory(lineSplit[1], currentDirectory);
                allDirectories.add(directory);
            } else {
                currentDirectory.addFiles(new DeviceFile(lineSplit[1], Integer.parseInt(lineSplit[0])));
            }
        }
        long count1 = 0;
        for (DeviceDirectory directory : allDirectories) {
            int size = directory.getSize();
            if (size < 100000) {
                count1 += size;
            }
        }
        System.out.println(count1);
    }
}

