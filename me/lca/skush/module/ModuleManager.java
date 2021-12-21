package me.lca.skush.module;

import me.lca.skush.module.impl.combat.KillAura;
import me.lca.skush.module.impl.combat.Velocity;
import me.lca.skush.module.impl.exploits.SentinelFixer;
import me.lca.skush.module.impl.hud.ClickGui;
import me.lca.skush.module.impl.hud.HUD;
import me.lca.skush.module.impl.hud.TabGUI;
import me.lca.skush.module.impl.movement.Fly;
import me.lca.skush.module.impl.movement.InventoryMove;
import me.lca.skush.module.impl.movement.NoSlowDown;
import me.lca.skush.module.impl.movement.Sprint;
import me.lca.skush.module.impl.player.*;
import me.lca.skush.module.impl.visual.*;
import me.lca.skush.module.impl.world.Scaffold;

import java.util.ArrayList;

public class ModuleManager {

    private ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        init();
    }

    public void init() {
        /* Combat */
        addModule(new KillAura());
        addModule(new Velocity());
        /* Exploit */
        addModule(new SentinelFixer());
        /* Movement */
        addModule(new Sprint());
        addModule(new Fly());
        addModule(new InventoryMove());
        addModule(new NoSlowDown());
        /* Player */
        addModule(new AutoArmor());
        addModule(new InvManager());
        addModule(new InvCleaner());
        addModule(new ChestStealer());
        addModule(new MiddleClick());
        addModule(new PingSpoof());
        /* Visual */
        addModule(new BedESP());
        addModule(new ESP());
        addModule(new ChestESP());
        addModule(new ItemPhysics());
        addModule(new NameTags());
        /* World */
        addModule(new Scaffold());
        /* HUD */
        addModule(new ClickGui());
        addModule(new HUD());
        addModule(new TabGUI());
    }

    private void addModule(Module mod) {
        modules.add(mod);
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public ArrayList<Module> getModules(Category category) {
        ArrayList<Module> modules = new ArrayList<>();
        for (Module m : this.modules) {
            if (m.getCategory().equals(category))
                modules.add(m);
        }
        return modules;
    }

    public Module getModule(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
