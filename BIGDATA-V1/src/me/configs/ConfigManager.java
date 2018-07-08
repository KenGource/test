package me.configs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.main.Main;
 
public class ConfigManager {
 
    private File file;
    private FileConfiguration fconfig;
    private JavaPlugin plugin;
 
    public ConfigManager(JavaPlugin plugin, String nome) {
        this.plugin = plugin;
        file = new File(plugin.getDataFolder(), nome + ".yml");
        reloadConfig();
    }
 
    public FileConfiguration getConfig() {
        return fconfig;
    }
 
    public File getFile() {
        return file;
    }
 
    @SuppressWarnings("deprecation")
	public void reloadConfig() {
        fconfig = YamlConfiguration.loadConfiguration(file);
        InputStream imputStream = plugin.getResource(file.getName());
        if (imputStream != null) {
            YamlConfiguration imputConfig =
                YamlConfiguration.loadConfiguration(imputStream);
            getConfig().setDefaults(imputConfig);
        }
    }
 
    public void saveConfig() {
        try {
            getConfig().save(file);
        } catch (IOException e) {
        	Main.getInstace().getServer().getConsoleSender().sendMessage("§c O arquivo §e" + file + " §cnão foi salvo");
        }
    }
 
    public void saveDefault() {
    	if(!(file.exists())){
            getConfig().options().copyDefaults(true);
   			Bukkit.getConsoleSender().sendMessage("§3O §e" + file + " §3foi criado!");
        saveConfig();
    	}
    }
 
    public void saveDefaultConfig() {
    	if(!file.exists())
        plugin.saveResource(file.getName(), false);
    }
 
}
