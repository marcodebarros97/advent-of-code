import java.util.ArrayList;
import java.util.List;

public class FileSystemManager {
    List<DeviceDirectory> createDirectories(List<String> fileSystem){
        DeviceDirectory root = new DeviceDirectory("/", false);
        DeviceDirectory currentDirectory = root;
        List<DeviceDirectory> allDirectories = new ArrayList<>();
        allDirectories.add(root);

        for (String line: fileSystem) {
            String[] lineSplit = line.split(" ");
            if ("$".equals(lineSplit[0])){
                if ("cd".equals(lineSplit[1])){
                    if ("/".equals(lineSplit[2])){
                        currentDirectory = root;
                    }
                    else if ("..".equals(lineSplit[2])){
                        currentDirectory = currentDirectory.getParentDirectory();
                    } else {
                        currentDirectory = getDirectoryByName(allDirectories, lineSplit[2]);
                    }
                }
            } else if ("dir".equals(lineSplit[0])) {
                DeviceDirectory directory = new DeviceDirectory(lineSplit[1], false);
                if (currentDirectory.getDirectoryName().equals(lineSplit[1]) &&
                        getDirectoryByName(allDirectories, currentDirectory.getDirectoryName()) != null){
                    directory.setSubDirectory(true);
                    directory.addSubDirectory(directory);
                    currentDirectory = directory;
                } else {
                    currentDirectory = directory;
                    allDirectories.add(directory);
                }
            }
        }
        return allDirectories;
    }

    private DeviceDirectory getDirectoryByName(List<DeviceDirectory> allDirectories, String directoryName) {
        for (DeviceDirectory deviceDirectory : allDirectories) {
            if (!deviceDirectory.getDirectoryName().equals(directoryName)) {
                for (DeviceDirectory subDirectory : deviceDirectory.getDeviceSubDirectories()) {
                    if (subDirectory.getDirectoryName().equals(directoryName)) {
                        return subDirectory;
                    }
                }
            } else if (deviceDirectory.getDirectoryName().equals(directoryName)) {
                return deviceDirectory;
            }
        }
        return null;
    }
}
