package me.lca.skush.file;

import me.lca.skush.Ambien;
import me.lca.skush.module.Module;
import net.minecraft.client.Minecraft;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import java.io.File;

public class FileManager {
    private static final String DIRECTORY = Minecraft.getMinecraft().mcDataDir + "\\Ambientus";

    public void createMainDirectory() {
        File folder = new File(DIRECTORY);
        if(!folder.exists())
            folder.mkdir();
    }

    public void saveModules() {
        JsonObject json = new JsonObject();
        JsonArray array = new JsonArray();
        for(Module m : Ambien.INSTANCE.moduleManager.getModules()) {
            JsonObject module = new JsonObject();
            module.put("name", m.getName());
            //module
        }
    }
}
