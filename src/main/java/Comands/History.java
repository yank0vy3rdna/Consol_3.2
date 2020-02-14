package Comands;

import App.Dispatcher;

public class History extends ComandsAbstract {
    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        for (int i = 0; i < 7; i++) {
            if(dispatcher.CommandHistory[i] != null)
                System.out.println(dispatcher.CommandHistory[i]);
        }
    }
}
