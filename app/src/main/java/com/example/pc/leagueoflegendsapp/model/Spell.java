package com.example.pc.leagueoflegendsapp.model;

import java.io.Serializable;

/**
 * Created by PC on 1/18/2018.
 */

public class Spell implements Serializable {

    private String iconUrl;
    private String name;
    private String guide;

    public Spell(String name, String guide, String iconUrl) {
        this.iconUrl = iconUrl;
        this.name = name;
        this.guide = guide;
    }

    public String getName() {
        return name;
    }

    public String getGuide() {
        return guide;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
