import java.util.List;

public class Helpers {
    DeviceDirectory findDirectory(String name, List<DeviceDirectory> allDirectories) {
        for (DeviceDirectory deviceDirectory : allDirectories) {
            if (deviceDirectory.getName().equals(name)) {
                return deviceDirectory;
            }
        }
        return null;
    }
}
