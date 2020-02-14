package Comands;

import App.Console;
import App.ControlInput;
import App.Dispatcher;
import SpaceMarine.SpaceMarine;
import com.google.inject.Inject;

import java.util.Map;
import java.util.Scanner;

public class Update extends ComandsAbstract {

    private final Console console;
    private final ControlInput control;
    private String[] value = new String[9];

    @Inject
    Update(Console console, ControlInput control){
        this.console = console;
        this.control = control;
    }

    private Scanner scan = new Scanner(System.in);

    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        int id = 0;
        while (true)
            if(arg.matches("-?\\d+(\\d+)?")) {
                id = Integer.parseInt(arg);
                break;
            }else{
                console.printPrompt("Введите значение id (целое число)");
                arg = scan.nextLine();
            }

        for (Map.Entry entry : dispatcher.MyCollection.entrySet()) {
            SpaceMarine marin = (SpaceMarine) entry.getValue();
            if(id == marin.getId()){
                addParams(dispatcher);
                SpaceMarine marine = new SpaceMarine(id,value[0],Float.parseFloat(value[1]),Double.parseDouble(value[2]),Long.parseLong(value[3]), Integer.parseInt(value[4]), value[5],value[6],value[7],value[8]);
                String key = (String) entry.getKey();
                dispatcher.MyCollection.remove(entry.getKey());
                dispatcher.MyCollection.put(key,marine);
            }
        }
    }

    private void addParams(Dispatcher dispatcher){
        int cnt= 0;
        console.printPrompt("Введите имя корабля");
        value[cnt] = scan.nextLine().trim();
        while(true){
            if(value[cnt].equals(" ") || value[cnt].equals("") || value[cnt] == null || value[cnt].equals("null") || control.controlNumbers(value[cnt])) {
                console.printPrompt("Введите значение заново (оно должно быть строкой)");
                value[cnt] = scan.nextLine().trim();
            }else if(serchInMap(dispatcher,value[cnt])){
                console.printPrompt("Данное имя уже существует введите новое");
                value[cnt] = scan.nextLine().trim();
            }else
                break;
        }
        cnt++;//0

        console.printPrompt("Введите координату x");
        value[cnt] = scan.nextLine().trim();
        inputNumberUpdate(cnt);
        cnt++;//1

        console.printPrompt("Введите координату y");
        value[cnt] = scan.nextLine().trim();
        inputNumberUpdate(cnt);
        cnt++;//2

        console.printPrompt("Введите количество здоровья");
        value[cnt] = scan.nextLine().trim();
        inputNumberUpdate(cnt);
        cnt++;//3

        console.printPrompt("Введите высоту корабля");
        value[cnt] = scan.nextLine().trim();
        inputNumberUpdate(cnt);
        cnt++;//4

        console.printPrompt("Введите название последней ачивки");
        value[cnt] = scan.nextLine().trim();
        inputStringUpdate(cnt);
        cnt++;//5

        console.printPrompt("Введите название главы");
        value[cnt] = scan.nextLine().trim();
        inputStringUpdate(cnt);
        cnt++;//5

        console.printPrompt("Введите название мира");
        value[cnt] = scan.nextLine().trim();
        inputStringUpdate(cnt);
        cnt++;//6

        console.printPrompt("Введите тип корабля" + "\n" + "Список доступных типов:\n" + "SCOUT\n" + "ASSAULT\n" + "TERMINATOR\n" + "APOTHECARY\n" + "Тип: ");
        value[cnt] = scan.nextLine().trim().toLowerCase();
        while(true){
            if(value[cnt].equals("scout") || value[cnt].equals("assault") || value[cnt].equals("terminator") || value[cnt].equals("apothecary")) {
                break;
            }else
                console.printPrompt("Введите значение заново");
            value[cnt] = scan.nextLine().trim().toLowerCase();
        }
        //7
    }

    private void inputStringUpdate(int cnt){
        while(true){
            if(value[cnt].equals(" ") || value[cnt].equals("") || value[cnt] == null || value[cnt].equals("null") || control.controlNumbers(value[cnt])) {
                console.printPrompt("Введите значение заново (оно должно быть строкой)");
                value[cnt] = scan.nextLine().trim();
            }else
                break;
        }
    }

    private void inputNumberUpdate(int cnt){
        while(!control.controlNumbers(value[cnt])){
            console.printPrompt("Error введите чило (нецелые числа вводяться с использованием точки)");
            value[cnt] = scan.nextLine().trim();
        }
    }

    private boolean serchInMap(Dispatcher dispatcher, String element){
        for (SpaceMarine value : dispatcher.MyCollection.values()) {
            if(value.getName().equals(element))
                return true;
        }
        return false;
    }
}
