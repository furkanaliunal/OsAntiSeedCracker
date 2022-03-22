package furkan.studio.osantiseedcracker.Packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.FieldAccessException;
import org.bukkit.plugin.java.JavaPlugin;

public class RespawnPacket extends PacketAdapter {
    public RespawnPacket(JavaPlugin plugin){
        super(plugin, ListenerPriority.HIGHEST, PacketType.Play.Server.RESPAWN);
    }
    @Override
    public void onPacketSending(PacketEvent event) {
        PacketContainer packet = event.getPacket();
        try {
            packet.getLongs().write(0, plugin.getConfig().getLong("replacing-seed"));
        } catch (FieldAccessException ex) {
            ex.printStackTrace();
        }
        event.setPacket(packet);
    }
}
