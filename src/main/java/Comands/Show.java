package Comands;

import App.Dispatcher;
import SpaceMarine.SpaceMarine;

import java.util.Map;


public class Show extends ComandsAbstract {
    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        for (Map.Entry entry : dispatcher.MyCollection.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            SpaceMarine marin = (SpaceMarine) entry.getValue();
            System.out.println("Values:\n" + marin.getAllInfo());
        }
    }
}