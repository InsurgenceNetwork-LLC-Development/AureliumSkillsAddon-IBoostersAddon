package com.insurgencedev.aureliumskillsaddon.listeners;

import com.archyx.aureliumskills.api.event.XpGainEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.data.BoosterFindResult;

public final class AureliumSkillsEventListener implements Listener {

    @EventHandler
    private void onGain(XpGainEvent event) {
        final String TYPE = "Skills";
        final String NAMESPACE = "AURELIUM_SKILLS";
        final double[] totalMulti = {0};

        BoosterFindResult pResult = IBoosterAPI.INSTANCE.getCache(event.getPlayer()).getBoosterDataManager().findActiveBooster(TYPE, NAMESPACE);
        if (pResult instanceof BoosterFindResult.Success boosterResult) {
            totalMulti[0] += boosterResult.getBoosterData().getMultiplier();
        }

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findGlobalBooster(TYPE, NAMESPACE, globalBooster -> {
            totalMulti[0] += globalBooster.getMultiplier();
            return null;
        }, () -> null);

        if (totalMulti[0] > 0) {
            event.setAmount(calculateAmount(event.getAmount(), totalMulti[0]));
        }
    }

    private double calculateAmount(double amount, double multi) {
        return amount * (multi < 1 ? 1 + multi : multi);
    }
}
