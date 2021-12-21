package de.Hero.clickgui.util;

import me.lca.skush.Ambien;

import java.awt.Color;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int) Ambien.INSTANCE.settingsManager.getSettingByName("GuiRed").getValDouble(), (int) Ambien.INSTANCE.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int)Ambien.INSTANCE.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
