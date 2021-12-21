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
import net.minecraft.entity.EntityLivingBase;

@ModuleInterface(name = "KillAura", displayName = "KillAura", description = "Attacks Entitys", category = Category.Combat, color = 0xFFFFFF)
public class KillAura extends Module {

    public static float yaw, pitch;
    public EntityLivingBase target;
    private final TimeUtil timeUtil = new TimeUtil();

    @Override
    public void setup() {
        super.setup();
        rSetting(new Setting("AuraRange", this, 4,3,6,false));
        rSetting(new Setting("AuraAPS", this, 13,5,20,true));
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void onUpdate(EventUpdate e) {
        target = AuraUtil.getTarget(getSetting("AuraRange").getValDouble());

        if (target != null) {

            float[] rotations = RotationUtil.getRotations(target);
            yaw = rotations[0];
            pitch = rotations[1];

            if (timeUtil.hasTimePassed((long) (1000 / getSetting("AuraAPS").getValDouble()))) {
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
        yaw = mc.thePlayer.rotationYaw;
        pitch = mc.thePlayer.rotationYaw;
        target = null;
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
