import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DirectorySearch directorySearch = new DirectorySearch();
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

        DeviceDirectory root = new DeviceDirectory("/");
        DeviceDirectory currentDirectory = root;
        List<DeviceDirectory> allDirectories = new ArrayList<>();

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
                        currentDirectory = directorySearch.findDirectory(lineSplit[2], allDirectories);
                    }
                }
            } else if ("dir".equals(lineSplit[0])) {
                DeviceDirectory directory = new DeviceDirectory(lineSplit[1]);
                directory.setParentDirectory(currentDirectory);
                allDirectories.add(directory);
            } else {
                currentDirectory.addFiles(new DeviceFile(lineSplit[1], Integer.parseInt(lineSplit[0])));
            }
        }
        int count = 0;
        for (DeviceDirectory directory : allDirectories) {
            int size = directory.getSize();
            if (size < 100000) {
                count += size;
            }
        }

        //Answer is supposed to be: 1792222
        System.out.println(count);
    }
}

