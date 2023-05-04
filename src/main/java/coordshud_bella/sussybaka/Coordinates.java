package coordshud_bella.sussybaka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coordinates implements CommandExecutor, TabCompleter {
    private static final List<String> COMMANDS = Arrays.asList(new String[]{"toggle"});

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0 || !args[0].toLowerCase().equals("toggle")) {
                Utils.sendMsg((CommandSender) player, "/coordinates toggle");
                return true;
            }
            if (!Utils.checkPlayerList(player)) {
                Utils.savePlayer(player);
            } else {

                Utils.removePlayer(player);
            }
            Utils.sendMsg((CommandSender) player, "Coordinates HUD is now " + (((Utils.checkPlayerList(player) && !Utils.getDefaultOn()) || (!Utils.checkPlayerList(player) && Utils.getDefaultOn())) ? "enabled" : "disabled") + ".");
            return true;
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return (args.length > 0) ? (List<String>) StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList()) : null;
    }
}
