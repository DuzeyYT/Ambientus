package me.exeos.utils;

import me.exeos.interfaces.MinecraftInterface;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;

public final class AuraUtil implements MinecraftInterface {

    public static EntityLivingBase getTarget(double range) {
        EntityLivingBase entityLivingBase = null;
        for (Entity entity : mc.theWorld.loadedEntityList)
        {
            if (mc.thePlayer.getDistanceToEntity(entity) < range && shouldAttack((EntityLivingBase) entity)) {
                range = mc.thePlayer.getDistanceToEntity(entity);
                entityLivingBase = (EntityLivingBase)entity;
            }
        }
        return entityLivingBase;
    }

    public static boolean shouldAttack(EntityLivingBase target) {
        return target != mc.thePlayer && target.isEntityAlive() && mc.thePlayer.canEntityBeSeen(target);
    }

    public static void attack(EntityLivingBase target) {
        mc.thePlayer.swingItem();
        mc.getNetHandler().addToSendQueue(new C02PacketUseEntity(target, C02PacketUseEntity.Action.ATTACK));
    }

}
