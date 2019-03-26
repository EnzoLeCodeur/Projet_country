package enzo.brembilla.projet_mobile;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import enzo.brembilla.projet_mobile.Model.Pays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity activity;

    private RestPaysApi restPaysApi;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){

        //Pour ceux qui veulent aller plus loin
        //Singleton
        //Pour ceux qui veulent aller encore plus loin
        // Injection de dépendances

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restPaysApi = retrofit.create(RestPaysApi.class);
        makeApiCall();
    }

    private void makeApiCall() {
        Call<List<Pays>> call = restPaysApi.getListPays();
        call.enqueue(new Callback<List<Pays>>() {
            @Override
            public void onResponse(Call<List<Pays>> call,
                                   Response<List<Pays>> response) {
                List<Pays> listPays = response.body();
                storeData(listPays);
                activity.showList(listPays);
            }

            @Override
            public void onFailure(Call<List<Pays>> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }

    private void storeData(List<Pays> listPays) {
        //TODO

    }

    private List<Pays> getListFromDataBase() {
        //TODO Implement With real logic
        return new ArrayList<>();
    }

    private boolean hasDataInDataBase() {
        //TODO Implement With real logic
        return true;
    }
}
