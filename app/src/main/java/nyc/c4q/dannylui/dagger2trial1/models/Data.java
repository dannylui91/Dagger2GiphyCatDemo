package nyc.c4q.dannylui.dagger2trial1.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dannylui on 1/13/17.
 */
public class Data {
    @SerializedName("image_original_url")
    private String imageOriginalUrl;

    public String getImageOriginalUrl() {
        return imageOriginalUrl;
    }
}
