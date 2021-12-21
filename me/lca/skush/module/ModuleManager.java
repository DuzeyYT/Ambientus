package me.lca.skush.module;

import me.lca.skush.module.impl.combat.KillAura;
import me.lca.skush.module.impl.hud.ClickGui;
import me.lca.skush.module.impl.movement.Fly;
import me.lca.skush.module.impl.movement.Sprint;

import java.util.ArrayList;

public class ModuleManager {

    private ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        init();
    }

    public void init() {
        // Combat
        modules.add(new KillAura());
        // Movement
        modules.add(new Sprint());
        modules.add(new Fly());
        // Player

        // Visual

        // HUD
        modules.add(new ClickGui());
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
