import java.io.File;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Data {

    private static Data dataIntance;
    private static GameAssets gameAssetsInstance;

    public static Data getDataIntance() {

        if (dataIntance == null) {

            dataIntance = new Data();
        }

        return dataIntance;
    }

    public static GameAssets getGameAssetsInstance() {

        if (gameAssetsInstance == null) {

            File dataFile = new File("");
            Gson gson = new Gson();
            JsonReader reader;

            try {

                reader = new JsonReader(new FileReader(dataFile));
            } catch (FileNotFoundException e) {

                e.printStackTrace();
                return null;
            }


            gameAssetsInstance = gson.fromJson(reader, GameAssets.class);

        }

        return gameAssetsInstance;
    }
}
