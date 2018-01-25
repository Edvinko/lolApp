package com.example.pc.leagueoflegendsapp;

import com.example.pc.leagueoflegendsapp.model.Champion;
import com.example.pc.leagueoflegendsapp.model.DamageType;
import com.example.pc.leagueoflegendsapp.model.Difficulty;
import com.example.pc.leagueoflegendsapp.model.Role;
import com.example.pc.leagueoflegendsapp.model.RoleIcon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by PC on 1/21/2018.
 */

public class ChampionsApiResponse {
    public HashMap<String, ChampionItem> data;

    public static class ChampionItem {
        public String name;
        public String title;
        public String lore;
        public Image image;
        public Info info;
        public List<String> tags;
        public List<Spell> spells;
        public Spell passive;

        public int id;
        public String key;
    }

    public static class Image {
        public String full;
    }

    public static class Info {
        public int difficulty;
        public int attack;
        public int magic;
    }

    public static class Spell {
        public String name;
        public String description;
        public Image image;
    }

    public List<Champion> toChampions() {
        List<Champion> responseChampions = new ArrayList<>();

        Iterator<String> championIterator = data.keySet().iterator();
        while (championIterator.hasNext()) {
            String key = championIterator.next();

            ChampionItem championItem = data.get(key);

            // Convert difficulty
            int responseDifficulty = championItem.info.difficulty;
            Difficulty difficulty;
            if (responseDifficulty <= 3) {
                difficulty = Difficulty.EASY;
            } else if (responseDifficulty >= 4 && responseDifficulty <= 9) {
                difficulty = Difficulty.MEDIUM;
            } else {
                difficulty = Difficulty.HARD;
            }

            // Convert damage type
            int responseAttack = championItem.info.attack;
            int responseMagic = championItem.info.magic;
            DamageType damageType;
            int dmgDifference = responseAttack - responseMagic;
            if (dmgDifference >= -2 && dmgDifference <= 2) {
                damageType = DamageType.HYBRID;
            } else if (dmgDifference < 0) {
                damageType = DamageType.MAGIC;
            } else {
                damageType = DamageType.PHYSICAL;
            }

            // Convert roles
            List<Role> roles = new ArrayList<>();
            for (String role : championItem.tags) {
                if (role.equals("Assassin")) {
                    roles.add(Role.ASSASSIN);
                }

                if (role.equals("Fighter")) {
                    roles.add(Role.FIGHTER);
                }

                if (role.equals("Support")) {
                    roles.add(Role.SUPPORT);
                }

                if (role.equals("Mage")) {
                    roles.add(Role.MAGE);
                }

                if (role.equals("Marksman")) {
                    roles.add(Role.MARKSMAN);
                }

                if (role.equals("Tank")) {
                    roles.add(Role.TANK);
                }
            }

            // Convert spells
            List<Spell> responseSpells = championItem.spells;

            com.example.pc.leagueoflegendsapp.model.Spell spellP = new com.example.pc.leagueoflegendsapp.model.Spell(championItem.passive.name, championItem.passive.description, LolStaticDataApi.BASE_PASSIVE_SPELL_ICON + championItem.passive.image.full);
            com.example.pc.leagueoflegendsapp.model.Spell spellQ = new com.example.pc.leagueoflegendsapp.model.Spell(responseSpells.get(0).name, responseSpells.get(0).description, LolStaticDataApi.BASE_SPELL_ICON_URL + responseSpells.get(0).image.full);
            com.example.pc.leagueoflegendsapp.model.Spell spellW = new com.example.pc.leagueoflegendsapp.model.Spell(responseSpells.get(1).name, responseSpells.get(1).description, LolStaticDataApi.BASE_SPELL_ICON_URL + responseSpells.get(1).image.full);
            com.example.pc.leagueoflegendsapp.model.Spell spellE = new com.example.pc.leagueoflegendsapp.model.Spell(responseSpells.get(2).name, responseSpells.get(2).description, LolStaticDataApi.BASE_SPELL_ICON_URL + responseSpells.get(2).image.full);
            com.example.pc.leagueoflegendsapp.model.Spell spellR = new com.example.pc.leagueoflegendsapp.model.Spell(responseSpells.get(3).name, responseSpells.get(3).description, LolStaticDataApi.BASE_SPELL_ICON_URL + responseSpells.get(3).image.full);

            responseChampions.add(new Champion(
                    LolStaticDataApi.BASE_ICON_URL + championItem.image.full,
                    LolStaticDataApi.BASE_CHAMP_SPLASH + championItem.key + "_0.jpg",
                    championItem.name,
                    championItem.title,
                    roles, damageType,
                    difficulty,
                    championItem.lore,
                    RoleIcon.FIGHTER_ICON,
                    spellP, spellQ, spellW, spellE, spellR));
        }

        return responseChampions;
    }
}
