package Comands;

import App.ControlInput;
import App.Dispatcher;
import com.google.inject.Inject;

import java.io.*;

public class Execute_script extends ComandsAbstract {

    private final ControlInput control;

    @Inject
    Execute_script(ControlInput control){
        this.control = control;
    }

    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        InputStream input;
        String line = null;
        try {
            String FILE = "D:/Consol_3.1/src/main/resources/Do_files/" + arg + ".txt";
            input = new FileInputStream(FILE);

            BufferedReader buff = new BufferedReader(new InputStreamReader(input));

            while (buff.ready()) {
                line = buff.readLine();
                line = control.sanitize(line);
                dispatcher.Dispatch(line);
            }
        } catch (IOException e) {
            System.out.println("Невнерно введено имя файла");
        }

    }
}
