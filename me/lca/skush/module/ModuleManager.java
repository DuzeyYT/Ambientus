package me.lca.skush.module;

import me.lca.skush.module.impl.combat.KillAura;
import me.lca.skush.module.impl.hud.ClickGui;
import me.lca.skush.module.impl.hud.HUD;
import me.lca.skush.module.impl.movement.Fly;
import me.lca.skush.module.impl.movement.Sprint;

import java.util.ArrayList;

public class ModuleManager {

    private ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        init();
    }

    public void init() {
        /* Combat */
        addModule(new KillAura());

        /* Movement */
        addModule(new Sprint());
        addModule(new Fly());

        /* Player */

        /* Visual */

        /* HUD */
        addModule(new ClickGui());
        addModule(new HUD());
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
