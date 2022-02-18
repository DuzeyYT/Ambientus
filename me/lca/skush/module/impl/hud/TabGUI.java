package me.lca.skush.module.impl.hud;

import me.lca.skush.Ambien;
import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.Event2D;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

@ModuleInterface(name = "TabGUI", displayName = "TabGUI", category = Category.HUD, color = 0xFFbf5002)
public class TabGUI extends Module {

    @EventTarget
    public void onRender(Event2D event) {
        ScaledResolution sr = new ScaledResolution(mc);
        
        int index = 0;
        float x = 26, y = 80;
        float height = Category.values().length * 15, width = 60;


        Gui.drawRect(x- 18, y- 11, x + width + 12, y + height - 4, new Color(0,0,0,230).getRGB());



        Gui.drawRect(x- 18, y- 10.5F, x + width -74.5F, y + height - 1,-1);
        Gui.drawRect(x- 18, y + height - 4, x + width + 12, y + height - 1, -1);


        Gui.drawRect(x+ 69, y- 10.5F, x + width + 12, y + height - 1, -1);


        // Client.blurHelper.blur2(x, y, x + width, y + height, 1);
        Gui.drawRect(x + 69, (y - 1) + (index * 14) + 1, x - 14.5F, y + 13 + (index * 14) - 1,
                new Color(20,102,52).getRGB());
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        drawImage(sr.getScaledWidth() / 140- 1, -4, 96, 96, new ResourceLocation("ambien/ambien.png"));
        for (int yT = 0; yT < Category.values().length; yT++) {

            Ambien.INSTANCE.fontManager.ambienFont.drawStringWithShadow(Category.values()[yT].name(),
                    x + (width - 8) / 2
                            - Ambien.INSTANCE.fontManager.ambienFont.getWidth(Category.values()[yT].name()) / 2,
                    y + (yT * 14) + 1, index == yT ? Color.white.getRGB() : Color.lightGray.getRGB());
        }
    }

    public static void drawImage(int x, int y, int width, int height, ResourceLocation resourceLocation) {
        mc.getTextureManager().bindTexture(resourceLocation);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, width, height);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
