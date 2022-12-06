import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceSignalManager {
    int positionOfMarker(String deviceSignal){
        List<Character> signalCharacters = new ArrayList<>();
        for (Character deviceSignalCharacter : deviceSignal.toCharArray()) {
            signalCharacters.add(deviceSignalCharacter);
        }

        for (int i = 4; i < deviceSignal.length(); i++) {
            List<Character> subSignalListCharacters = signalCharacters.subList(i-4, i);
            if (!containsDuplicate(subSignalListCharacters)){
                return i;
            }
        }
        return 0;
    }

    int positionOfMessage(String deviceSignal){
        List<Character> signalCharacters = new ArrayList<>();
        for (Character deviceSignalCharacter : deviceSignal.toCharArray()) {
            signalCharacters.add(deviceSignalCharacter);
        }

        for (int i = 14; i < deviceSignal.length(); i++) {
            List<Character> subSignalListCharacters = signalCharacters.subList(i-14, i);
            if (!containsDuplicate(subSignalListCharacters)){
                return i;
            }
        }
        return 0;
    }

    boolean containsDuplicate(List<Character> listToCheck){
        AtomicBoolean listHasDuplicates = new AtomicBoolean(false);
        List<Character> characters = new ArrayList<>();
        listToCheck.forEach(character -> {
            if (!characters.contains(character)){
                characters.add(character);
            } else {
                listHasDuplicates.set(true);
            }
        });
        return listHasDuplicates.get();
    }
}
