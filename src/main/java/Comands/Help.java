package Comands;

import App.Console;
import App.Dispatcher;
import com.google.inject.Inject;

import java.util.Map;

public class Help extends ComandsAbstract {
    private final Console console;

    @Inject
    Help(Console console){
        this.console = console;
    }
    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        for (Map.Entry entry : dispatcher.comandMap.entrySet())
            if(entry.getKey().equals("help"))
                console.printPrompt(entry.getKey() + " Выводит список команд для работы с консолью");
            else if(entry.getKey().equals("info"))
                console.printPrompt(entry.getKey() + " Выводит информацию о коллекции");
            else if(entry.getKey().equals("insert"))
                console.printPrompt(entry.getKey() + " Создает объект класса, для создания обязательно указывать ключ");
            else if(entry.getKey().equals("show"))
                console.printPrompt(entry.getKey() + " Выводит содержимое коллекции");
            else if(entry.getKey().equals("history"))
                console.printPrompt(entry.getKey() + " Выводит последнии 7 исполненных команд");
            else if(entry.getKey().equals("exit"))
                console.printPrompt(entry.getKey() + " Окончание работы программы");
            else if(entry.getKey().equals("clear"))
                console.printPrompt(entry.getKey() + " Очищает коллекцию от всех элементов");
            else if(entry.getKey().equals("average_of_height"))
                console.printPrompt(entry.getKey() + " Выводит среднее значение поля height для всех элементов коллекции");
            else if(entry.getKey().equals("update"))
                console.printPrompt(entry.getKey() + " Обновляет значение элемента коллекции, id которого равен заданному, тебует аргумента id");
            else if(entry.getKey().equals("remove_key"))
                console.printPrompt(entry.getKey() + " удалить элемент из коллекции по его ключу, требует аргумент ключа");
            else if(entry.getKey().equals("replace_if_greater"))
                console.printPrompt(entry.getKey() + " Заменяет значение по ключу, если новое значение больше старого");
            else if(entry.getKey().equals("execute_script"))
                console.printPrompt(entry.getKey() + " Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
            else if(entry.getKey().equals("save"))
                console.printPrompt(entry.getKey() + " Сохраняет коллекцию");
            else if(entry.getKey().equals("replace_if_lowe"))
                console.printPrompt(entry.getKey() + " Заменяет значение по ключу, если новое значение меньше старого");
            else
                console.printPrompt((String) entry.getKey());
    }
}
