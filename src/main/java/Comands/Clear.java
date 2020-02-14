package Comands;

import App.Dispatcher;

public class Clear extends ComandsAbstract {
    @Override
    public void doComand(Dispatcher dispatcher, String arg) {

        String[] keys= new String[dispatcher.MyCollection.size()];
        int cnt = 0;

        for (String key : dispatcher.MyCollection.keySet()) {
            keys[cnt] = key;
            cnt++;
        }

        for(String e: keys)
            remove(e,dispatcher);

    }

    private void remove(String key, Dispatcher dispatcher){
        dispatcher.MyCollection.remove(key);
    }
}
