package nyc.c4q.dannylui.dagger2trial1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import nyc.c4q.dannylui.dagger2trial1.dagger.MyApp;
import nyc.c4q.dannylui.dagger2trial1.models.GiphyResponse;
import nyc.c4q.dannylui.dagger2trial1.networks.GiphyClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Inject GiphyClient giphyClient;
    @Inject SharedPreferences sharedPreferences;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApp) getApplication()).getAppComponent().inject(this);
        imageView = (ImageView) findViewById(R.id.image_view);

        Call<GiphyResponse> call = giphyClient.getCatGif();
        call.enqueue(new Callback<GiphyResponse>() {
            @Override
            public void onResponse(Call<GiphyResponse> call, Response<GiphyResponse> response) {
                GiphyResponse model = response.body();
                String imageUrl = model.getData().getImageOriginalUrl();
                Glide.with(MainActivity.this).load(imageUrl).into(imageView);

            }

            @Override
            public void onFailure(Call<GiphyResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
