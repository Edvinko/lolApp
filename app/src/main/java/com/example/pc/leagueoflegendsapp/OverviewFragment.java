package com.example.pc.leagueoflegendsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.leagueoflegendsapp.model.Champion;
import com.example.pc.leagueoflegendsapp.model.Difficulty;

public class OverviewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.overview_fragment, container, false);

        Champion champion = ((ChampionDetailsActivity) getActivity()).getChampion();

        ImageView roleIcon = view.findViewById(R.id.roleIcon);
        roleIcon.setImageResource(champion.getRoleImageId());

        TextView txtChampName = view.findViewById(R.id.txtChampName);
        txtChampName.setText(champion.getName());

        TextView txtEpithet = view.findViewById(R.id.txtEpithet);
        txtEpithet.setText(champion.getEpithet());

        TextView txtRole = view.findViewById(R.id.txtRole);
        txtRole.setText(champion.getRolesString());

        TextView txtDamageType = view.findViewById(R.id.txtDamageType);
        txtDamageType.setText(champion.getDamageType());

        // Difficulty
        View ez = view.findViewById(R.id.ez);
        View med = view.findViewById(R.id.med);
        View hard = view.findViewById(R.id.hard);
        if (champion.getDifficulty() == Difficulty.EASY) {
            ez.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ez));
            med.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlue));
            hard.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlue));
        } else if (champion.getDifficulty() == Difficulty.MEDIUM) {
            ez.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ez));
            med.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.med));
            hard.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlue));
        } else {
            ez.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ez));
            med.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.med));
            hard.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hard));
        }

        TextView champStory = view.findViewById(R.id.champStory);
        champStory.setText(champion.getStory());

        return view;
    }
}
