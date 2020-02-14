package Comands;

import App.Console;
import App.Dispatcher;
import com.google.inject.Inject;

public class Info extends ComandsAbstract {

    private final Console console;

    @Inject
    Info(Console console){
        this.console = console;
    }

    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        console.printPrompt("Количество элементов коллекции: " + dispatcher.MyCollection.size());
        console.printPrompt("Тип коллекции: " + dispatcher.MyCollection.getClass().getTypeName());
    }
}
