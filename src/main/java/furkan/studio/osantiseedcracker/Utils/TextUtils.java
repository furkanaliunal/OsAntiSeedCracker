package furkan.studio.osantiseedcracker.Utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class TextUtils {
    public String prefix = "&6[&eOASC&6] &7";

    private final JavaPlugin plugin;
    public TextUtils(JavaPlugin plugin){
        this.plugin = plugin;
    }


    public String colorize(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public void sendMessageToConsole(String message){
        plugin.getServer().getConsoleSender().sendMessage(colorize(prefix + message));
    }
}
