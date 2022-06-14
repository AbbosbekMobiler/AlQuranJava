package mobiler.abbosbek.alquranjava.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static Retrofit instance;

    public static Retrofit getRetrofit(){
        if (instance == null){
            instance = new Retrofit.Builder().baseUrl("http://api.alquran.cloud/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}