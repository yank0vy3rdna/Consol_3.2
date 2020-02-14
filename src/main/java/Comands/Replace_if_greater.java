package Comands;

import App.Console;
import App.ControlInput;
import App.Dispatcher;
import SpaceMarine.SpaceMarine;
import com.google.inject.Inject;

import java.util.Scanner;

public class Replace_if_greater extends ComandsAbstract{

    private final ControlInput control;
    private final Console console;
    private Scanner scan = new Scanner(System.in);
    private String[] value = new String[4];

    @Inject
    Replace_if_greater(ControlInput control, Console console){
        this.control = control;
        this.console = console;
    }

    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        while (true) {
            if (!arg.equals("") && dispatcher.MyCollection.get(arg) != null) {
                break;
            } else {
                console.printPrompt("Введите значение key");
                arg = scan.nextLine();
            }
        }

        SpaceMarine marin = dispatcher.MyCollection.get(arg);
        if(Float.parseFloat(value[0]) > marin.getCoordinates().getX() ){
            marin.getCoordinates().setX(Float.parseFloat(value[0]));
        }
        if(Double.parseDouble(value[1]) > marin.getCoordinates().getY()){
            marin.getCoordinates().setY(Double.parseDouble(value[1]));
        }
        if(Long.parseLong(value[2]) > marin.getHealth()){
            marin.setHealth(Long.parseLong(value[2]));
        }
        if(Integer.parseInt(value[3]) < marin.getHeight()){
            marin.setHeight(Integer.parseInt(value[3]));
        }
    }

    private void addParams(Dispatcher dispatcher){
        int cnt= 0;
        console.printPrompt("Введите новую координату x");
        value[cnt] = scan.nextLine().trim();
        inputNumberUpdate(cnt);
        cnt++;//1

        console.printPrompt("Введите новую координату y");
        value[cnt] = scan.nextLine().trim();
        inputNumberUpdate(cnt);
        cnt++;//2

        console.printPrompt("Введите новое количество здоровья");
        value[cnt] = scan.nextLine().trim();
        inputNumberUpdate(cnt);
        cnt++;//3

        console.printPrompt("Введите новую высоту корабля");
        value[cnt] = scan.nextLine().trim();
        inputNumberUpdate(cnt);
    }

    private void inputNumberUpdate(int cnt){
        while(!control.controlNumbers(value[cnt])){
            console.printPrompt("Error введите чило (нецелые числа вводяться с использованием точки)");
            value[cnt] = scan.nextLine().trim();
        }
    }
}
