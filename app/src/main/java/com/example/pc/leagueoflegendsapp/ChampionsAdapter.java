package com.example.pc.leagueoflegendsapp;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 1/18/2018.
 */

public class ChampionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Champion> champions = makeChampions();
    private MainActivity activity;

    // Recycler view kad se prikaze na ekranu, njemu treba po jedan view holder za svaki red u listi.
    // U tom trenutku, recycler view pita svog adaptera (a to je ova klasa) da mu da neki view koji
    // mu ne treba (nije trenutno prikazan). Ako adapter nema takav view, pozvat ce ovu metodu,
    // u kojoj je developer duzan da kreira novu instancu view holdera i returna je.
    // Ako adapter ima view koji mu trenutno ne treba, on ga reciklira tako sto samo pozove
    // onBindViewHolder metodu da na postojeci view holder postavi nove podatke i prikaze ga.

    // Scenario:
    // 1. Aplikacija se prikaze na ekran
    // 2. Recycler view skonta da ima 140 heroja ukupno (gleda u listi heroja).
    // 3. Za svakog heroja mu treba view holder da bi ga prikazao na ekranu
    // 4. Na pocetku nema nijedan kreiran view holder, pa ce adapter pozvati metodu onCreateViewHolder da mu kreira novi
    // 5. Nakon sto je kreiran view holder, poziva se metoda onBindViewHolder, gdje je taj novokreirani view holder proslijedjen kao parametar 'holder'
    // 6. U onBindViewHolder se text view i image view postave na vrijednosti uzete iz heroja na poziciji 0
    // 7. Prvi heroj je uspjesno prikazan na ekranu

    // 8. Sad ide sljedeci heroj - na poziciji 1
    // 9. Recycler view-u je potreban jos jedan view holder, a trenutno u memoriji ima samo jedan, koji se vec koristi za onog prvog heroja,
    //        pa adapter opet poziva onCreateViewHolder da mu kreira jos jedan
    // 10. Poziva se onBindViewHolder sa ovim novim view holderom i pozicijom 1, gdje postavimo text i sliku od heroja na poziciji 1
    //
    // 11. I tako jos 7 puta, dok se ne popuni cijeli ekran svim redovima koji na njega mogu stati
    //
    // 12. Kad podjes scrollati prema dole, onaj prvi view holder s vrha ode van ekrana, ali se ne unisti, nego ga adapter cuva
    // 13. Recycler view kaze adapteru da mu treba novi view holder za heroja koji odozdo dolazi na ekran
    // 14. Ovaj put adapter ima jedan view holder viska, pa nece pozvati metodu onCreateViewHolder, nego ce vratiti holder koji vec ima i koji je otisao s ekrana maloprije
    // 15. Na tom view holderu, koji u ovom trenutku ima postavljene podatke od prvog heroja s liste, koji se sad vise ne vidi, pozove se onBindViewHolder s pozicijom recimo 10
    // 16. Na taj view holder se postave podaci heroja na poziciji 10
    // 17. I tako u nedogled
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChampionViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.xml_za_jednog_heroja, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Champion champion = champions.get(position);

        ((TextView) holder.itemView.findViewById(R.id.nameChamp)).setText(champion.getName());
        ((ImageView) holder.itemView.findViewById(R.id.imageChamp)).setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), champion.getImageId()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ChampionDetailsActivity.class);
                intent.putExtra(ChampionDetailsActivity.KEY_CHAMPION, champion);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    private List<Champion> makeChampions() {
        List<Champion> champions = new ArrayList<>();

        champions.add(new Champion(R.drawable.aatrox, "Aatrox"));
        champions.add(new Champion(R.drawable.ahri, "Ahri"));
        champions.add(new Champion(R.drawable.akali, "Akali"));
        champions.add(new Champion(R.drawable.alistar, "Alistar"));
        champions.add(new Champion(R.drawable.amumu, "Amumu"));
        champions.add(new Champion(R.drawable.anivia, "Anivia"));
        champions.add(new Champion(R.drawable.annie, "Annie"));
        champions.add(new Champion(R.drawable.ashe, "Ashe"));
        champions.add(new Champion(R.drawable.aurelion_sol, "Aurelion Sol"));
        champions.add(new Champion(R.drawable.azir, "Azir"));
        champions.add(new Champion(R.drawable.bard, "Bard"));

        return champions;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }
}
