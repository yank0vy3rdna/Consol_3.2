import App.App;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Guice.createInjector().getInstance(App.class);

        Injector injector = Guice.createInjector(new Config());
        App app = injector.getInstance(App.class);

        app.startWork();
    }
}
