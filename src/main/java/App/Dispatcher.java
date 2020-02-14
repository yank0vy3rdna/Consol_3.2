package App;

import Comands.*;
import SpaceMarine.SpaceMarine;
import com.google.inject.Inject;

import java.io.IOException;
import java.util.HashMap;

public class Dispatcher {

    private final SortCollection sort;
    public HashMap<String, SpaceMarine> MyCollection = new HashMap<String, SpaceMarine>();

    public String[] CommandHistory = new String[7];
    private int cnt_command = 0;

    private final Console console;
    public boolean flagWork = true;
    public int Id_controller = 1;//

    public HashMap<String, ComandsAbstract> comandMap = new HashMap<String, ComandsAbstract>();

    @Inject
    Dispatcher(SortCollection sort,Exit exit, Console console, Help help,Save save,Execute_script execute,Replace_if_greater greater,Replace_if_lowe lowe, InsertElement insert, History history, Info info, Show show, Update update,Clear clear, Remove_key remove, Average_of_height height){
        comandMap.put("help", help);
        comandMap.put("insert", insert);
        comandMap.put("history", history);
        comandMap.put("info", info);
        comandMap.put("show", show);
        comandMap.put("exit", exit);
        comandMap.put("update", update);
        comandMap.put("clear", clear);
        comandMap.put("remove_key", remove);
        comandMap.put("average_of_height", height);
        comandMap.put("replace_if_greater", greater);
        comandMap.put("replace_if_lowe", lowe);
        comandMap.put("execute_script", execute);
        comandMap.put("save",save);
        this.console = console;
        this.sort = sort;
    }

    public void Dispatch(String value) throws IOException {
        String[] ComandArr = value.split(":");
        value = ComandArr[0].trim().toLowerCase();
        if(comandMap.get(value) != null){
            ComandsAbstract command = comandMap.get(value);
            command.doComand(this, ComandArr[1].trim());
            if(cnt_command < 7){
                CommandHistory[cnt_command] = value;
                cnt_command++;
            }else{
                CommandHistory[0] = value;
                swop();
            }
        }else if(!value.equals(""))
            console.printPrompt("Такой команды не существует :>");
        sort.sort(this);
    }

    private void swop(){
        for(int i=0;i<6;i++){
            String element = CommandHistory[i];
            CommandHistory[i] = CommandHistory[i+1];
            CommandHistory[i+1] = element;
        }

    }


}
