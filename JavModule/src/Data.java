import java.io.File;
import com.google.gson.Gson;

public class Data {

    private static Data dataIntance;
    private static GameAssets gameAssetsInstance;

    public static Data getDataIntance() {

        if(dataIntance == null) {

            dataIntance = new Data();
        }

        return dataIntance;
    }

    public static GameAssets getGameAssetsInstance() {

        if(gameAssetsInstance == null) {

            File dataFile = new File("assets/data.json");



        }

        return gameAssetsInstance;
    }
}
