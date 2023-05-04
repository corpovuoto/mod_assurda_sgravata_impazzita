package coordshud_bella.sussybaka;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Sussybaka extends JavaPlugin {
    public void onEnable() {
        getLogger().info("CoordinatesHUD Enabled");
        saveDefaultConfig();
        Utils.readConfig(getConfig(), (Plugin) this);
        getCommand("coordinates").setExecutor(new Coordinates());
        CoordinatesTimer.run((Plugin) this);
    }


    public void onDisable() {
        getLogger().info("CoordinatesHUD Disabled");
    }
}