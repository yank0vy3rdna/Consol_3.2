package JSON;

import SpaceMarine.SpaceMarine;
import com.google.gson.stream.JsonWriter;
import App.Dispatcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JSON_Writer implements Writer{
    /**Путь к Json файлу*/
    private static final String FILENAME = "D:/Consol_3.1/src/main/resources/JSON_files/Info.json";

    /**
     * Запись в Json файл
     * @param dispatcher
     * @throws IOException
     */
    public void writeJSON(Dispatcher dispatcher) throws IOException {
        try (JsonWriter writer = new JsonWriter(new FileWriter(FILENAME))) {
            writer.beginObject();

            for (Map.Entry entry : dispatcher.MyCollection.entrySet()) {
                writer.name("kye").value((String) entry.getKey());
                SpaceMarine marin = (SpaceMarine) entry.getValue();
                writer.name("id").value(marin.getId());
                writer.name("name").value(marin.getName());
                writer.name("cord_x").value(marin.getCoordinates().getX());
                writer.name("cord_y").value(marin.getCoordinates().getY());
                writer.name("health").value(marin.getHealth());
                writer.name("height").value(marin.getHeight());
                writer.name("category").value(marin.getCategory().name());
                writer.name("achievement").value(marin.getAchievements());
                writer.name("name_chapter").value(marin.getChapter().getName());
                writer.name("world_chapter").value(marin.getChapter().getWorld());
                writer.name("creat_date").value(String.valueOf(marin.getCreationDate()));
            }

            writer.endObject();
        }
    }
}