package me.oveln.welcomehitokoto;

import me.oveln.utils.CU;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class main extends JavaPlugin {

    private Logger logger;
    private PluginDescriptionFile descriptionFile;
    private static main instance;

    @Override
    public void onEnable() {
        descriptionFile = getDescription();
        logger = getLogger();
        instance = this;

        registerConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoin(),this);

        StringBuilder addends = new StringBuilder();
        addends.append("&a")
                .append(descriptionFile.getName())
                .append(descriptionFile.getVersion())
                .append(" 启动成功 &作者")
                .append(descriptionFile.getAuthors().get(0));
        logger.info(CU.t(addends.toString()));

    }

    public void onDisable() {
        logger = null;
    }

    public void registerConfig() {
        saveDefaultConfig();
    }
    public static main getInstance() {
        return instance;
    }

}
