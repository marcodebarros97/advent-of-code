import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        List<String> fileSystem = inputManager.readInput();
        FileSystemManager fileSystemManager = new FileSystemManager();
        List<DeviceDirectory> deviceDirectoryList = fileSystemManager.createDirectories(fileSystem);

    }
}