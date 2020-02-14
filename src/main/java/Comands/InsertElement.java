package Comands;

import App.Console;
import App.ControlInput;
import App.Dispatcher;
import SpaceMarine.SpaceMarine;
import com.google.inject.Inject;

import java.util.Scanner;

public class InsertElement extends ComandsAbstract {

    private final Console console;
    private final ControlInput control;
    private Scanner scan = new Scanner(System.in);
    private String[] value = new String[9];

    @Inject
    InsertElement(Console console, ControlInput control){
        this.console = console;
        this.control = control;
    }

    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        String[] args = arg.split(" ");
        while (true)
        if(args[0].equals("")) {
            console.printPrompt("Error\n" + "Введите значение ключа: ");
            args[0] = scan.nextLine().trim();
        }else {
            addParams(dispatcher);
            SpaceMarine marine = new SpaceMarine(dispatcher.Id_controller,value[0],Float.parseFloat(value[1]),Double.parseDouble(value[2]),Long.parseLong(value[3]), Integer.parseInt(value[4]), value[5],value[6],value[7],value[8]);
            dispatcher.MyCollection.put(args[0],marine);
            dispatcher.Id_controller = dispatcher.Id_controller + 1;
            break;
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
            }else if(serchInMap(dispatcher,value[cnt].trim())){
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
        cnt++;//6

        console.printPrompt("Введите название мира");
        value[cnt] = scan.nextLine().trim();
        inputStringUpdate(cnt);
        cnt++;//7

        console.printPrompt("Введите тип корабля" + "\n" + "Список доступных типов:\n" + "SCOUT\n" + "ASSAULT\n" + "TERMINATOR\n" + "APOTHECARY\n" + "Тип: ");
        value[cnt] = scan.nextLine().trim().toLowerCase();
        while(true){
            if(value[cnt].equals("scout") || value[cnt].equals("assault") || value[cnt].equals("terminator") || value[cnt].equals("apothecary")) {
                break;
            }else
                console.printPrompt("Введите значение заново");
                value[cnt] = scan.nextLine().trim().toLowerCase();
        }
        //8
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
            if(value.getName().trim().equals(element))
                return true;
        }
        return false;
    }
}