package nyc.c4q.dannylui.dagger2trial1.networks;

import nyc.c4q.dannylui.dagger2trial1.models.GiphyResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dannylui on 1/13/17.
 */

public class GiphyClient {
    private static final String API_URL = "http://api.giphy.com/";
    private static GiphyClient instance;
    private final GiphyApi api;

    public static GiphyClient getInstance() {
        if (instance == null) {
            instance = new GiphyClient();
        }
        return instance;
    }

    private GiphyClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(GiphyApi.class);
    }

    public Call<GiphyResponse> getCatGif() {
        return api.getGif("dc6zaTOxFJmzC", "cat");
    }
}
