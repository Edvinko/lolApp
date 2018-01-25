package com.example.pc.leagueoflegendsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pc.leagueoflegendsapp.model.Champion;

public class AbilitiesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.abilities_fragment, container, false);

        Champion champion = ((ChampionDetailsActivity) getActivity()).getChampion();

        // Header
        ImageView roleIcon = view.findViewById(R.id.roleIcon);
        roleIcon.setImageResource(champion.getRoleImageId());

        TextView txtChampName = view.findViewById(R.id.txtChampName);
        txtChampName.setText(champion.getName());

        TextView txtEpithet = view.findViewById(R.id.txtEpithet);
        txtEpithet.setText(champion.getEpithet());

        // Passive
        TextView spellP_name = view.findViewById(R.id.spellP_name);
        spellP_name.setText(champion.getSpellP().getName());

        ImageView spellP_image = view.findViewById(R.id.spellP_img);
        Glide.with(getContext()).load(champion.getSpellP().getIconUrl()).into(spellP_image);

        TextView spellP_guide = view.findViewById(R.id.spellP_guide);
        spellP_guide.setText(champion.getSpellP().getGuide());

        // Q
        TextView spellQ_name = view.findViewById(R.id.spellQ_name);
        spellQ_name.setText(champion.getSpellQ().getName());

        ImageView spellQ_image = view.findViewById(R.id.spellQ_img);
        Glide.with(getContext()).load(champion.getSpellQ().getIconUrl()).into(spellQ_image);

        TextView spellQ_guide = view.findViewById(R.id.spellQ_guide);
        spellQ_guide.setText(champion.getSpellQ().getGuide());

        // W
        TextView spellW_name = view.findViewById(R.id.spellW_name);
        spellW_name.setText(champion.getSpellW().getName());

        ImageView spellW_image = view.findViewById(R.id.spellW_img);
        Glide.with(getContext()).load(champion.getSpellW().getIconUrl()).into(spellW_image);

        TextView spellW_guide = view.findViewById(R.id.spellW_guide);
        spellW_guide.setText(champion.getSpellW().getGuide());

        // E
        TextView spellE_name = view.findViewById(R.id.spellE_name);
        spellE_name.setText(champion.getSpellE().getName());

        TextView spellE_guide = view.findViewById(R.id.spellE_guide);
        spellE_guide.setText(champion.getSpellE().getGuide());

        ImageView spellE_image = view.findViewById(R.id.spellE_img);
        Glide.with(getContext()).load(champion.getSpellE().getIconUrl()).into(spellE_image);

        // R
        TextView spellR_name = view.findViewById(R.id.spellR_name);
        spellR_name.setText(champion.getSpellR().getName());

        ImageView spellR_image = view.findViewById(R.id.spellR_img);
        Glide.with(getContext()).load(champion.getSpellR().getIconUrl()).into(spellR_image);

        TextView spellR_guide = view.findViewById(R.id.spellR_guide);
        spellR_guide.setText(champion.getSpellR().getGuide());

        return view;

    }
}
