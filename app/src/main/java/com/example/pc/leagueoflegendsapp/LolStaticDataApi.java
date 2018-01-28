package com.example.pc.leagueoflegendsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by PC on 1/21/2018.
 */

public interface LolStaticDataApi {
    String BASE_ICON_URL = "https://ddragon.leagueoflegends.com/cdn/7.10.1/img/champion/";
    String BASE_SPELL_ICON_URL = "http://ddragon.leagueoflegends.com/cdn/7.10.1/img/spell/";
    String BASE_CHAMP_SPLASH = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/";
    String BASE_PASSIVE_SPELL_ICON = "http://ddragon.leagueoflegends.com/cdn/6.24.1/img/passive/";

    @Headers("X-Riot-Token: RGAPI-02c24f1a-e932-49bd-b031-e50456f31393")
    @GET("/lol/static-data/v3/champions?tags=lore&tags=image&tags=info&tags=tags&tags=spells&tags=passive")
    Call<ChampionsApiResponse> getChampions();
}
