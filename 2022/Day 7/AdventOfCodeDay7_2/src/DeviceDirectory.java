import java.util.ArrayList;
import java.util.List;

public class DeviceDirectory {
    private String name;
    private int size;
    private List<DeviceFile> deviceFileList = new ArrayList<>();

    private DeviceDirectory parentDirectory;

    public DeviceDirectory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFiles(DeviceFile deviceFile){
        this.size += deviceFile.getSize();
        if (this.parentDirectory != null){
            int parentSize = this.parentDirectory.getSize();
            this.parentDirectory.setSize(parentSize + deviceFile.getSize());
        }
        deviceFileList.add(deviceFile);
    }

    public DeviceDirectory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(DeviceDirectory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
