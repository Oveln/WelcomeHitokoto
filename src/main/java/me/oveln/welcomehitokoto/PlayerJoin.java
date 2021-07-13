package me.oveln.welcomehitokoto;

import me.oveln.utils.CU;
import me.oveln.utils.hitokoto;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerJoin implements Listener {

    @EventHandler
    public boolean onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = main.getInstance().getConfig();
        List<String> strings = config.getStringList("texts");

        for (String text:strings) {
            String ret = text.replace("%player%" , player.getName());
            if (ret.contains("%hitokoto%")) ret = ret.replace("%hitokoto%", hitokoto.gethitokoto());
            player.sendMessage(CU.t(ret));
        }
        return true;
    }
}
