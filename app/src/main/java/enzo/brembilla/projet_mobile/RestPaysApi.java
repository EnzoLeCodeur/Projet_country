package enzo.brembilla.projet_mobile;

import java.util.List;

import enzo.brembilla.projet_mobile.Model.Pays;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestPaysApi {

    @GET("all")
    Call<List<Pays>> getListPays();
}