package JSON;

import App.Dispatcher;

import java.io.IOException;

public interface Reader {
    void readJASON(Dispatcher dispatcher) throws IOException;
}