package com.insurgencedev.aureliumskillsaddon;

import com.insurgencedev.aureliumskillsaddon.listeners.AureliumSkillsEventListener;
import org.bukkit.Bukkit;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "AureliumSkillsAddon", version = "1.0.1", author = "InsurgenceDev", description = "AureliumSkills Support")
public class AureliumSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Bukkit.getPluginManager().isPluginEnabled("AureliumSkills")) {
            registerEvent(new AureliumSkillsEventListener());
        }
    }
}
