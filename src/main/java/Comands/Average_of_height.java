package Comands;

import App.Console;
import App.Dispatcher;
import SpaceMarine.SpaceMarine;
import com.google.inject.Inject;

import java.util.Map;

public class Average_of_height extends ComandsAbstract {

    private final Console console;

    @Inject
    Average_of_height(Console console){
        this.console = console;
    }

    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        int cnt = 0, height = 0;
        for (Map.Entry entry : dispatcher.MyCollection.entrySet()) {
            SpaceMarine marin = (SpaceMarine) entry.getValue();
            height = height + marin.getHeight();
            cnt++;
        }
        if(cnt == 0)
            cnt = 1;
        console.printPrompt(String.valueOf(height/cnt));
    }
}
