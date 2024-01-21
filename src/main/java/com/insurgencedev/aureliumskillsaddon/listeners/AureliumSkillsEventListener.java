package com.insurgencedev.aureliumskillsaddon.listeners;

import com.archyx.aureliumskills.api.event.XpGainEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.models.booster.GlobalBoosterManager;
import org.insurgencedev.insurgenceboosters.settings.IBoostersPlayerCache;

public final class AureliumSkillsEventListener implements Listener {

    @EventHandler
    private void onGain(XpGainEvent event) {
        final String TYPE = "Skills";
        final String NAMESPACE = "AURELIUM_SKILLS";
        double totalMulti = 1;

        IBoostersPlayerCache.BoosterFindResult pResult = IBoosterAPI.getCache(event.getPlayer()).findActiveBooster(TYPE, NAMESPACE);
        if (pResult instanceof IBoostersPlayerCache.BoosterFindResult.Success boosterResult) {
            totalMulti += boosterResult.getBooster().getMultiplier();
        }

        GlobalBoosterManager.BoosterFindResult gResult = IBoosterAPI.getGlobalBoosterManager().findBooster(TYPE, NAMESPACE);
        if (gResult instanceof GlobalBoosterManager.BoosterFindResult.Success boosterResult) {
            totalMulti += boosterResult.getBooster().getMultiplier();
        }

        event.setAmount(calculateAmount(event.getAmount(), totalMulti));
    }

    private long calculateAmount(double amount, double multi) {
        return (long) (amount * (multi < 1 ? 1 + multi : multi));
    }
}
