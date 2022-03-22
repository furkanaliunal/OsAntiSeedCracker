package furkan.studio.osantiseedcracker;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import furkan.studio.osantiseedcracker.Packets.LoginPacket;
import furkan.studio.osantiseedcracker.Packets.RespawnPacket;
import furkan.studio.osantiseedcracker.Utils.TextUtils;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class OsAntiSeedCracker extends JavaPlugin {


    private TextUtils textUtils;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        PluginCommand osASC = getCommand("osantiseedcracker");
        osASC.setExecutor(new OsASCCommand(this));

        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.addPacketListener(new LoginPacket(this));
        protocolManager.addPacketListener(new RespawnPacket(this));

        textUtils = new TextUtils(this);
        textUtils.sendMessageToConsole("Plugin is loaded successfully.");
    }

    @Override
    public void onDisable() {
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.removePacketListeners(this);
    }
}
