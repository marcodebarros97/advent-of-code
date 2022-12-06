public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        String deviceSignal = fileReader.readInputFile();
        DeviceSignalManager deviceSignalManager = new DeviceSignalManager();
        System.out.println("Marker: " + deviceSignalManager.positionOfMarker(deviceSignal));
        System.out.println("Marker: " + deviceSignalManager.positionOfMessage(deviceSignal));
    }
}