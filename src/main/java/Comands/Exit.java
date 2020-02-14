package Comands;

import App.Console;
import App.Dispatcher;
import com.google.inject.Inject;

public class Exit extends ComandsAbstract {
    private final Console console;

    @Inject
    Exit(Console console){
        this.console = console;
    }

    @Override
    public void doComand(Dispatcher dispatcher, String arg) {
        dispatcher.flagWork = false;
        console.printPrompt("Работа консоли звершена, до скорой встречи :)\n" +
                "              `..``.` ``                      \n" +
                "            `.```  `...````                   \n" +
                "          `..` `...```.``..`                  \n" +
                "..   `. `  `:oyyy/  `...````                  \n" +
                "`sso//syo:.. .+yyy/-.  `.`````                \n" +
                " :yyysoooo+. `.--`  .```... ``                \n" +
                "  .:osssyys/-`  ..``.-`  `..``                \n" +
                "  :/yyysoosys-``.--   .``....                 \n" +
                " :ysoosssosys:--  ..`...-` `.`            ``` \n" +
                "  `.o/osso//` .-....-`  .--.           .``...`\n" +
                "       `-``-....-.  `-.```.` `..`  ````...` `.\n" +
                "       .......   ...``.`  .-..``.```..` `..`..\n" +
                "    .....-`  `.```.`  `-.```.` `...` `.``...` \n" +
                " ``....   .````.   ...` ``  ...` `.````..  ```\n" +
                "`..   `````.`   ..```.` `..`  `.``..`   .`.``.\n" +
                "` ..`````   ..```.`  .-.` `.```..   `````..  `\n" +
                ".....   `.`````  `--`  .```.-.  `.````.   ...`\n" +
                "..  ..`````   ...` `.``.--`  ..``.-`  `...`.. \n" +
                "``.....`  `..` `.` `.-`  ..``.-.  `-....-.    \n" +
                " `-.` `...``.` `...   .``..-   .--..--  .`    \n" +
                "   `.-.`..``...` `..`.-:.  `:-..--   `        \n" +
                "        `...``......-` `-.....`               \n");
    }
}
