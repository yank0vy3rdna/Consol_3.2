package JSON;

import App.Dispatcher;
import SpaceMarine.SpaceMarine;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;


public class JSON_Reader implements Reader{
    private static final String FILENAME = "D:\\Consol_3.1\\src\\main\\resources\\JSON_files\\Info.json";

    /**
     * Чтение из json файла
     * @throws IOException
     */

    public void readJASON(Dispatcher dispatcher) throws IOException {
        String key = null;
        String[] value = new String[6];
        int id = 0,height=0,cnt = 0;
        long health=0;
        double y=0;
        float x=0;

        try (JsonReader reader = new JsonReader(new FileReader(FILENAME))) {
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                    case "kye":
                        key = reader.nextString();
                        cnt++;
                        break;
                    case "id":
                        id = Integer.parseInt(reader.nextString());
                        if(dispatcher.Id_controller < id)
                            dispatcher.Id_controller = id+1;
                        cnt++;
                        break;
                    case "name":
                        value[0] = reader.nextString();
                        cnt++;
                        break;
                    case "cord_x":
                        x = Float.parseFloat(reader.nextString());
                        cnt++;
                        break;
                    case "cord_y":
                        y = Double.parseDouble(reader.nextString());
                        cnt++;
                        break;
                    case "health":
                        health = Long.parseLong(reader.nextString());
                        cnt++;
                        break;
                    case "height":
                        height = Integer.parseInt(reader.nextString());
                        cnt++;
                        break;
                    case "category":
                        value[1] = reader.nextString();
                        cnt++;
                        break;
                    case "achievement":
                        value[2] = reader.nextString();
                        cnt++;
                        break;
                    case "name_chapter":
                        value[3] = reader.nextString();
                        cnt++;
                        break;
                    case "world_chapter":
                        value[4] = reader.nextString();
                        cnt++;
                        break;
                    case "creat_date":
                        value[5] = reader.nextString();
                        cnt++;
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
                if(cnt == 12){
                    SpaceMarine marine = new SpaceMarine(id,value[0],x,y,health,height,value[2],value[3],value[4],value[1]);
                    marine.setCreationDate(value[5]);
                    dispatcher.MyCollection.put(key,marine);
                    cnt=0;
                }
            }
            reader.endObject();

        }catch (IOException e) {
           System.out.println("Мега дурка, файл пуст!!!\nКак и твоя голова");
        }
    }
}