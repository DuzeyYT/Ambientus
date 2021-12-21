package me.lca.skush.module.impl.combat;

import com.google.common.eventbus.Subscribe;
import me.lca.skush.clickgui.setting.Setting;
import me.lca.skush.event.impl.EventPreUpdate;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import me.lca.skush.utils.AuraUtil;
import me.lca.skush.utils.RotationUtil;
import me.lca.skush.utils.TimeUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

import java.awt.*;
import java.util.ArrayList;

@ModuleInterface(name = "KillAura", displayName = "KillAura", description = "Attacks Entitys", category = Category.Combat, color = 0xFFb8d81c)
public class KillAura extends Module {

    public static float yaw, pitch;
    public EntityLivingBase target;
    private final TimeUtil timeUtil = new TimeUtil();
    public static ArrayList<Entity> bots = new ArrayList<>();
    @Override
    public void setup() {
        super.setup();
        rSetting(new Setting("AuraRange", this, 4, 3, 6, false));
        rSetting(new Setting("AuraAPS", this, 13, 5, 20, true));
        rSetting(new Setting("Antibots",  this, false));

    }



    @Subscribe
    @SuppressWarnings("unused")
    public void onUpdate(EventUpdate e) {


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

            float[] rotations = RotationUtil.getRotations(target);
            yaw = rotations[0];
            pitch = rotations[1];

            if (timeUtil.hasTimeReached((long) (1000 / getSetting("AuraAPS").getValDouble()))) {
                AuraUtil.attack(target);
                timeUtil.reset();
            }
        }
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void onPreUpdate(EventPreUpdate e) {
        if (target == null)
            return;

        mc.thePlayer.rotationYawHead = yaw;
        mc.thePlayer.renderYawOffset = yaw;
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
        bots.clear();
        super.onDisable();
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
