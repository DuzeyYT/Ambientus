package me.lca.skush.clickgui.comp;

import me.lca.skush.clickgui.Clickgui;
import me.lca.skush.clickgui.setting.Setting;
import me.lca.skush.module.Module;

public class Comp {

    public double x, y, x2, y2;
    public Clickgui parent;
    public Module module;
    public Setting setting;

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {

    }

    public void mouseReleased(int mouseX, int mouseY, int state) {

    }

    public void drawScreen(int mouseX, int mouseY) {

    }

    public boolean isInside(int mouseX, int mouseY, double x, double y, double x2, double y2) {
        return (mouseX > x && mouseX < x2) && (mouseY > y && mouseY < y2);
    }

    public void keyTyped(char typedChar, int keyCode) {

    }

}
