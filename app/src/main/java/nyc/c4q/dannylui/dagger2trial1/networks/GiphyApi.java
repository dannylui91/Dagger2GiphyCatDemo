package nyc.c4q.dannylui.dagger2trial1.networks;

import nyc.c4q.dannylui.dagger2trial1.models.GiphyResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dannylui on 1/13/17.
 */

public interface GiphyApi {
    @GET("v1/gifs/random")
    Call<GiphyResponse> getGif(
            @Query("api_key") String apiKey,
            @Query("tag") String tag);
}
