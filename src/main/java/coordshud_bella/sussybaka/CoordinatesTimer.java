package coordshud_bella.sussybaka;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CoordinatesTimer {
    public static void run(final Plugin plugin) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
            public void run() {
                for (Player p : plugin.getServer().getOnlinePlayers()) {
                    if ((Utils.checkPlayerList(p) && !Utils.getDefaultOn()) || (!Utils.checkPlayerList(p) && Utils.getDefaultOn())) {
                        Location l = p.getLocation();
                        String biome = l.getBlock().getBiome().toString();
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, (new ComponentBuilder(
                                ChatColor.GOLD + "XYZ: " + ChatColor.WHITE + l.getBlockX() + " " + l.getBlockY() + " " + l.getBlockZ() + "  " +
                                        ChatColor.GOLD + String.format("%-4s", new Object[]{Utils.rpGetPlayerDirection(p)}) +
                                        biome)).create());
                    }
                }
            }
        }, 0L, Utils.getTicks());
    }
}
