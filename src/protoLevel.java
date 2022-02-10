import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.*;

import java.util.ArrayList;
public class protoLevel {
    private JsonElement myLevel;

    //1. pass in level id
    //open thw json
    //find level
    //
    private class Platforms{
        public int x;
        public int y;
        public String colour;
        public int w;
        public int h;
    }
    ArrayList<Platforms>platforms = new ArrayList<>();
    private int lvlID;
    public String name;
    public int getLvlID() {
        return lvlID;
    }

    public void setLvlID(int lvlID) {
        this.lvlID = lvlID;
    }


    public void readLevel() {
        File level = new File("C:/Users/alexa/IdeaProjects/game/assets/levels.json");
        JsonElement reader;
        {
            try {
                //lvlID = 1;

                reader = JsonParser.parseReader(new FileReader(level));
                //find lvl #
                //read lvl var. <- from lvlJsonObject level_object = reader.getAsJsonObject();
                JsonObject levelObject = reader.getAsJsonObject();
                JsonArray myLevels = levelObject.get("levels").getAsJsonArray();
                JsonObject myLevel = myLevels.get(lvlID - 1).getAsJsonObject();
                JsonArray myPlatforms = myLevel.get("platforms").getAsJsonArray();
                for (JsonElement X : myPlatforms
                ) {
                    JsonObject plat = X.getAsJsonObject();
                    Platforms platformObject = new Platforms();
                    platformObject.x = plat.get("x").getAsInt();
                    platformObject.y = plat.get("y").getAsInt();
                    platformObject.w = plat.get("w").getAsInt();
                    platformObject.h = plat.get("h").getAsInt();
                    platformObject.colour = plat.get("color").getAsString();
                    platforms.add(platformObject);
                    System.out.println(platforms);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}


