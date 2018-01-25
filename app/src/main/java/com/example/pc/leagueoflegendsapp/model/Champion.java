package com.example.pc.leagueoflegendsapp.model;

import com.example.pc.leagueoflegendsapp.R;

import java.io.Serializable;
import java.util.List;

public class Champion implements Serializable {

    private String iconUrl;
    private String splashUrl;
    private String name;
    private String epithet;
    private List<Role> roles;
    private DamageType damageType;
    private Difficulty difficulty;
    private String story;
    private RoleIcon roleIcon;

    private Spell spellP;
    private Spell spellQ;
    private Spell spellW;
    private Spell spellE;
    private Spell spellR;

    public Champion(String iconUrl, String splashUrl, String name, String epithet, List<Role> roles, DamageType damageType, Difficulty difficulty, String story, RoleIcon roleIcon, Spell spellP, Spell spellQ, Spell spellW, Spell spellE, Spell spellR) {

        this.iconUrl = iconUrl;
        this.splashUrl = splashUrl;
        this.name = name;
        this.epithet = epithet;
        this.roles = roles;
        this.damageType = damageType;
        this.difficulty = difficulty;
        this.story = story;
        this.roleIcon = roleIcon;
        this.spellP = spellP;
        this.spellQ = spellQ;
        this.spellW = spellW;
        this.spellE = spellE;
        this.spellR = spellR;
    }

    public String getSplashUrl() {
        return splashUrl;
    }

    public Spell getSpellP() {

        return spellP;
    }

    public Spell getSpellQ() {

        return spellQ;
    }

    public Spell getSpellW() {
        return spellW;
    }

    public Spell getSpellE() {
        return spellE;
    }

    public Spell getSpellR() {
        return spellR;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getName() {
        return name;
    }

    public String getEpithet() { return epithet; }



    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getRolesString() {
        String finalString = "";

        for (int i = 0; i < roles.size(); i++) {
            Role role = roles.get(i);

            String roleString = getRoleString(role);

            if (i == 0) {
                finalString = finalString.concat(roleString);
            } else {
                finalString = finalString.concat(", ").concat(roleString);
            }
        }

        return finalString;
    }

    public String getRoleString(Role role) {
        if (role == Role.FIGHTER) {
            return "Fighter";
        }
        if (role == Role.SUPPORT) {
            return  "Support";
        }
        if (role == Role.ASSASSIN) {
            return "Assassin";
        }
        if (role == Role.MAGE) {
            return "Mage";
        }
        if (role == Role.MARKSMAN) {
            return "Marksmen";
        }

        if (role == Role.TANK) {
            return "Tank";
        }
        return "";
    }


    public int getRoleImageId() {
        Role role = roles.get(0);

        if (role == Role.FIGHTER) {
            return R.drawable.fighter_icon;
        }
        if (role == Role.SUPPORT) {
            return R.drawable.support_icon;
        }
        if (role == Role.ASSASSIN) {
            return R.drawable.assassin_icon;
        }
        if (role == Role.MAGE) {
            return R.drawable.mage_icon;
        }
        if (role == Role.MARKSMAN) {
            return R.drawable.marksman_icon;
        }
        if (role == Role.TANK) {
            return R.drawable.tank_icon;
        }

        return R.drawable.fighter_icon;
    }

    public String getDamageType() {
        if (damageType == DamageType.MAGIC) {
            return "Magic";
        }

        if (damageType == DamageType.PHYSICAL) {
            return "Physical";
        }

        if (damageType == DamageType.HYBRID) {
            return "Hybrid";
        }

        return null;
    }

    public String getStory() {
        return story;
    }
}
