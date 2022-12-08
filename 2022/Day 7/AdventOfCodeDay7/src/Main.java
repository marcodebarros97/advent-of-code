import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DirectoryEntry rootDirectory = new DirectoryEntry(null,"/");
        DirectoryEntry currentDirectory = rootDirectory;
        List<DirectoryEntry> allDirectories = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/FileSystem.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(" ");
                if ("$".equals(lines[0])) {
                    if ("cd".equals(lines[1])) {
                        if ("/".equals(lines[2])) {
                            currentDirectory = rootDirectory;
                        } else if ("..".equals(lines[2])) {
                            currentDirectory = currentDirectory.getParent();
                        } else {
                            currentDirectory = currentDirectory.getDir(lines[2]);
                        }
                    }
                } else if ("dir".equals(lines[0])) {
                    DirectoryEntry directoryEntry = new DirectoryEntry(currentDirectory, lines[1]);
                    currentDirectory.addFile(directoryEntry);
                    allDirectories.add(directoryEntry);
                } else {
                    currentDirectory.addFile(new FileEntry(lines[1], Long.parseLong(lines[0])));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long count1 = 0;
        for (DirectoryEntry directoryEntry : allDirectories){
            long size = directoryEntry.size();
            if (directoryEntry.size() < 100000) {
                count1 += size;
            }
        }
        System.out.println(count1);

        long sizeOfRoot = rootDirectory.size();
        long spaceLeft = 70000000 - sizeOfRoot;
        long spaceToRemove = 30000000 - spaceLeft;

        List<DirectoryEntry> candidates = new ArrayList<>();

        for (DirectoryEntry de : allDirectories) {
            if (de.size() > spaceToRemove) {
                candidates.add(de);
            }
        }

        candidates.add(rootDirectory);

        candidates.sort((a, b) -> (int)(a.size() - b.size()));

        System.out.println(candidates.get(0).size());
    }
}