package me.lca.skush.utils;

import me.lca.skush.interfaces.MinecraftInterface;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;

public final class AuraUtil implements MinecraftInterface {

    public static EntityLivingBase getTarget(double range) {
        EntityPlayer entityPlayer = null;
        for (Entity entity : mc.theWorld.loadedEntityList)
        {
            if (mc.thePlayer.getDistanceToEntity(entity) < range && shouldAttack((EntityLivingBase) entity)) {
                range = mc.thePlayer.getDistanceToEntity(entity);
                entityPlayer = (EntityPlayer)entity;
            }
        }
        return entityPlayer;
    }

    public static boolean shouldAttack(EntityLivingBase target) {
        return target != mc.thePlayer && target.isEntityAlive() && mc.thePlayer.canEntityBeSeen(target);
    }

    public static void attack(EntityLivingBase target) {
        mc.thePlayer.swingItem();
        mc.getNetHandler().addToSendQueue(new C02PacketUseEntity(target, C02PacketUseEntity.Action.ATTACK));
    }

}
