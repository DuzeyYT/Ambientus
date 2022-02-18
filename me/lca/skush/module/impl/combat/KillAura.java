package me.lca.skush.module.impl.combat;

import me.lca.skush.clickgui.setting.Setting;
import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventPreUpdate;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import me.lca.skush.utils.AuraUtil;
import me.lca.skush.utils.RotationUtil;
import me.lca.skush.utils.TimeUtil;
import me.lca.skush.utils.TimeUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Rotations;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@ModuleInterface(name = "KillAura", displayName = "KillAura", description = "Attacks Entitys", category = Category.Combat, color = 0xFFb8d81c)
public class KillAura extends Module {

    public static float yaw, pitch;
    public EntityLivingBase target;
    private final TimeUtils timeUtil = new TimeUtils();
    public static ArrayList<Entity> bots = new ArrayList<>();
    @Override
    public void setup() {
        super.setup();
        rSetting(new Setting("AuraRange", this, 4, 3, 6, false));
        rSetting(new Setting("MinCPS", this, 13, 5, 20, true));
        rSetting(new Setting("MaxCPS", this, 13, 5, 20, true));
        rSetting(new Setting("Antibots",  this, false));

    }

    @EventTarget
    @SuppressWarnings("unused")
    public void onUpdate(EventUpdate e) {
        if (!mc.thePlayer.isSwingInProgress) {
            if (mc.thePlayer.getHeldItem() != null)
                if (mc.thePlayer.getHeldItem().getItem() instanceof net.minecraft.item.ItemSword) {
                    mc.gameSettings.keyBindUseItem.pressed = false;
                }
        }

        if (getSetting("Antibots").getValBoolean()) {
            for (final Object entity : mc.theWorld.getLoadedEntityList())
                if (entity instanceof EntityPlayer)
                    if ((isBot((EntityPlayer) entity) || ((EntityPlayer) entity).isInvisible())
                            && entity != mc.thePlayer) {
                        bots.add((EntityPlayer) entity);
                        mc.theWorld.removeEntity((Entity) entity);
                    }
                }



        target = AuraUtil.getTarget(getSetting("AuraRange").getValDouble());

        if (target != null) {

            float[] rotations = RotationUtil.Intavee(mc.thePlayer, target);
            yaw = rotations[0];
            pitch = rotations[1];
            final float CPS = (float) MathHelper.getRandomDoubleInRange(new Random(), getSetting("MinCPS").getValDouble(), getSetting("MaxCPS").getValDouble());
            if (timeUtil.hasReached((long) (1000 / CPS))) {
                AuraUtil.attack(target);
                timeUtil.reset();
            }
        }
        if (mc.thePlayer.isSwingInProgress &&  mc.thePlayer.hurtTime != 0 ) {
            if (mc.thePlayer.getHeldItem() != null)
                if (mc.thePlayer.getHeldItem().getItem() instanceof net.minecraft.item.ItemSword) {
                    //mc.gameSettings.keyBindUseItem.pressed = true;
                }

        }
    }

    @EventTarget
    @SuppressWarnings("unused")
    public void onPreUpdate(EventPreUpdate e) {
        if (target == null)
            return;
        float[] rotations = RotationUtil.Intavee(mc.thePlayer, target);
        pitch = rotations[1];
        mc.thePlayer.rotationYawHead = yaw;
        mc.thePlayer.renderYawOffset = yaw;
        mc.thePlayer.rotationPitchHead = rotations[1];
        e.setRotation(new float[] {yaw, pitch});
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if(mc.thePlayer == null) return;
        yaw = mc.thePlayer.rotationYaw;
        pitch = mc.thePlayer.rotationYaw;
        target = null;
    }

    @Override
    public void onDisable() {

        super.onDisable();
        bots.clear();
    }
    boolean isBot(EntityPlayer player) {
        if (!isInTablist(player))
            return true;
        return invalidName(player);
    }

    boolean isInTablist(EntityPlayer player) {
        if (Minecraft.getMinecraft().isSingleplayer())
            return false;
        for (final NetworkPlayerInfo playerInfo : Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap())
            if (playerInfo.getGameProfile().getName().equalsIgnoreCase(player.getName()))
                return true;
        return false;
    }

    boolean invalidName(Entity e) {
        if (e.getName().contains("-"))
            return true;
        if (e.getName().contains("/"))
            return true;
        if (e.getName().contains("|"))
            return true;
        if (e.getName().contains("<"))
            return true;
        if (e.getName().contains(">"))
            return true;
        if (e.getName().contains("ยง"))
            return true;
        return false;
    }
}
