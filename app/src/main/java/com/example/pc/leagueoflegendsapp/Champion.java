package com.example.pc.leagueoflegendsapp;

import java.io.Serializable;

public class Champion implements Serializable {

    private int imageId;
    private String name;
    private String epithet;
    private String role;
    private String damageType;
    private String difficulity;
    private String story;

    private Spell spellP;
    private Spell spellQ;
    private Spell spellW;
    private Spell spellE;
    private Spell spellR;

    public Champion(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
