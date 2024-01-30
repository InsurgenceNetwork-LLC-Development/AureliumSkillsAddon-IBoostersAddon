package com.insurgencedev.aureliumskillsaddon;

import com.insurgencedev.aureliumskillsaddon.listeners.AureliumSkillsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "AureliumSkillsAddon", version = "1.0.3", author = "InsurgenceDev", description = "AureliumSkills Support")
public class AureliumSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("AureliumSkills")) {
            registerEvent(new AureliumSkillsEventListener());
        }
    }
}
