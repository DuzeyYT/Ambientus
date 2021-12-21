package me.exeos.module.impl.movement;

import com.google.common.eventbus.Subscribe;
import me.exeos.Tutorial;
import me.exeos.event.impl.EventUpdate;
import me.exeos.interfaces.ModuleInterface;
import me.exeos.module.Category;
import me.exeos.module.Module;
import org.lwjgl.input.Keyboard;

@ModuleInterface(name = "Sprint", description = "Will automatically Sprint", category = Category.Movement)
public class Sprint extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {
        if (!mc.thePlayer.isCollidedHorizontally && mc.thePlayer.moveForward > 0) {
            mc.thePlayer.setSprinting(true);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.thePlayer.setSprinting(false);
    }

}
