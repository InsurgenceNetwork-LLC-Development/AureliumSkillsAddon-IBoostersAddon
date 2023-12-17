package com.insurgencedev.aureliumskillsaddon;

import com.insurgencedev.aureliumskillsaddon.listeners.AureliumSkillsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "AureliumSkillsAddon", version = "1.0.0", author = "InsurgenceDev", description = "AureliumSkills Support")
public class AureliumSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        registerEvent(new AureliumSkillsEventListener());
    }
}
