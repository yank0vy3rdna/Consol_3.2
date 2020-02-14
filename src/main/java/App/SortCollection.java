package App;

import SpaceMarine.SpaceMarine;

import java.util.Map;
import java.util.TreeMap;

public class SortCollection {

    void sort(Dispatcher dispatcher) {
        TreeMap<String, SpaceMarine> sorterCollection = new TreeMap<>(dispatcher.MyCollection);
        for (Map.Entry entry : sorterCollection.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Values:\n" + entry.getValue());
        }
    }

}
