import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceDirectory{
    private String directoryName;
    private Map<String, DeviceFile> files = new HashMap();
    private List<DeviceDirectory> deviceSubDirectories = new ArrayList<>();
    private DeviceDirectory parentDirectory;

    private boolean isSubDirectory;

    public DeviceDirectory(String directoryName, boolean isSubDirectory) {
        this.directoryName = directoryName;
        this.isSubDirectory = isSubDirectory;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public Map<String, DeviceFile> getFiles() {
        return files;
    }

    public void setFiles(Map<String, DeviceFile> files) {
        this.files = files;
    }

    public List<DeviceDirectory> getDeviceSubDirectories() {
        return deviceSubDirectories;
    }

    public void setDeviceSubDirectories(List<DeviceDirectory> deviceSubDirectories) {
        this.deviceSubDirectories = deviceSubDirectories;
    }

    public DeviceDirectory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(DeviceDirectory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public boolean isSubDirectory() {
        return isSubDirectory;
    }

    public void setSubDirectory(boolean subDirectory) {
        isSubDirectory = subDirectory;
    }

    void addFiles (String name, DeviceFile file){
        files.put(name, file);
    }

    void addSubDirectory(DeviceDirectory directory){
        deviceSubDirectories.add(directory);
    }
}
