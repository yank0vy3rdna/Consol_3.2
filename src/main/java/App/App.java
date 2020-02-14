package App;

import JSON.JSON_Reader;
import com.google.inject.Inject;

import java.io.IOException;
import java.util.Scanner;

public class App implements App_Interface {

    private final Dispatcher dispatcher;
    private final Console console;
    private final ControlInput control;
    private final JSON_Reader reader;
    private final SortCollection sort;

    @Inject
    App(Dispatcher dispatcher, Console console, ControlInput control, JSON_Reader reader,SortCollection sort){
        this.dispatcher = dispatcher;
        this.console = console;
        this.control = control;
        this.reader = reader;
        this.sort = sort;
    }

    private String value;
    private Scanner scan = new Scanner(System.in);

    public void startWork() throws IOException {
        reader.readJASON(dispatcher);
        while (dispatcher.flagWork){
            console.printPrompt("");
            value = scan.nextLine();
            value = control.sanitize(value);
            dispatcher.Dispatch(value);
        }
    }

}
