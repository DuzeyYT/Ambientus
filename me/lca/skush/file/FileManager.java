package me.lca.skush.file;

import me.lca.skush.Ambien;
import me.lca.skush.module.Module;
import net.minecraft.client.Minecraft;
import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static final String DIRECTORY = Minecraft.getMinecraft().mcDataDir + "\\Ambientus";

    public void createMainDirectory() {
        File folder = new File(DIRECTORY);
        if(!folder.exists())
            folder.mkdir();
    }

    public void saveModules() {
        File export = new File(DIRECTORY + "\\modules.json");

        JsonObject json = new JsonObject();
        JsonArray array = new JsonArray();
        for(Module m : Ambien.INSTANCE.moduleManager.getModules()) {
            JsonObject module = new JsonObject();
            module.put("name", m.getName());
            module.put("state", m.isToggled());
            array.add(module);
        }
        json.put("modules", array);
        try {
            FileWriter writer = new FileWriter(export);
            writer.write(Jsoner.prettyPrint(json.toJson()));
            writer.flush();
        } catch (IOException ignored) {}
    }
    public void loadModules() {
        File input = new File(DIRECTORY + "\\modules.json");
        try {
            FileReader reader = new FileReader(input);
            JsonObject json = (JsonObject) Jsoner.deserialize(reader);
            JsonArray array = (JsonArray) json.get("modules");
            for (Object obj : array) {
                JsonObject moduleObject = (JsonObject) obj;
                String name = moduleObject.get("name").toString();
                boolean state = Boolean.parseBoolean(moduleObject.get("state").toString());
                Module mod = Ambien.INSTANCE.moduleManager.getModule(name);
                if(mod != null && state) {
                    mod.toggle();
                }
            }
        } catch (IOException | DeserializationException ignored) { }
    }
}
