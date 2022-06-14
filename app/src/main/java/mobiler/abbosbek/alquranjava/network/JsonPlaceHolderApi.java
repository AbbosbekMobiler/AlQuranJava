package mobiler.abbosbek.alquranjava.network;

import mobiler.abbosbek.alquranjava.response.SurahResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("surah")
    Call<SurahResponse> getSurah();
}
