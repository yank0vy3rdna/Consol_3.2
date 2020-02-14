package Comands;

import App.Dispatcher;

import java.io.IOException;

public interface Comands {
    void doComand(Dispatcher dispatcher, String arg) throws IOException;
}
