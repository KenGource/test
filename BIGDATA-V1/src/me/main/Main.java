package me.main;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.aUniversal.EventoJoin;
import me.aUniversal.EventoQuit;
import me.aUniversal.EventoVoid;
import me.atualizacoes.ComandosAtualizacoes;
import me.configs.ConfigManager;
import me.spawn.ComandosSpawn;
import me.spawn.EventosSpawn;


public class Main extends JavaPlugin{
	
	
	private static Main instance;
    public static Main getInstace() {
        return instance;
    }
    public static ConfigManager mensagemvoid;
    public static ConfigManager mensagemspawn;
    public static ConfigManager localizacaospawn;
    public static ConfigManager atualizacao;
    public static ConfigManager universal;
	
	@Override
	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage("§3O plugin esta sendo carregado...");
		mensagemvoid = new ConfigManager(this, "Universal/Void/MensagensVoid");
		mensagemspawn = new ConfigManager(this, "Spawn/MensagensSpawn");
		localizacaospawn = new ConfigManager(this, "Spawn/LocalizacaoSpawn");
		atualizacao = new ConfigManager(this, "Spawn/LocalizacaoSpawn");
		universal = new ConfigManager(this, "Universal");
		mensagemvoid.saveDefault();
		mensagemspawn.saveDefault();
		localizacaospawn.saveDefault();
		atualizacao.saveDefault();
		universal.saveDefault();
	}
	
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
	    instance = this;
		Bukkit.getConsoleSender().sendMessage("§3O plugin foi carregado com sucesso!");
		new ComandosSpawn();
		new EventosSpawn();
		new ComandosAtualizacoes();
		
		
		new EventoJoin();
		new EventoQuit();
		new EventoVoid();
		
		
		CarregarEventos();
		CarregarComandos();
		
		
		
		CarregarEventosUniversal();
	}
	
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("§cO plugin foi desligado com sucesso!");
		
	}	
	public void CarregarEventos(){
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new EventosSpawn(), this);
	}
	
	
	public void CarregarEventosUniversal(){
		PluginManager universal = Bukkit.getPluginManager();
		universal.registerEvents(new EventoJoin(), this);
		universal.registerEvents(new EventoQuit(), this);
		universal.registerEvents(new EventoVoid(), this);
		
	}
	
	
	public void CarregarComandos(){
		// ---> SPAWN
		getCommand("spawn").setExecutor(new ComandosSpawn());
		getCommand("setspawn").setExecutor(new ComandosSpawn());
		getCommand("delspawn").setExecutor(new ComandosSpawn());
		getCommand("atualizacoes").setExecutor(new ComandosAtualizacoes());
		// ---------------------------------------------------------
		// --->
	}
	
	
	
	public static Location getLocationSpawn() {
		World world = Bukkit.getWorld(Main.localizacaospawn.getConfig().getString("Spawn.World"));
		double x = Main.localizacaospawn.getConfig().getDouble("Spawn.X");
		double y = Main.localizacaospawn.getConfig().getDouble("Spawn.Y");
		double z = Main.localizacaospawn.getConfig().getDouble("Spawn.Z");
		float pitch = (float) Main.localizacaospawn.getConfig().getDouble("Spawn.Pitch");
		float yaw = (float) Main.localizacaospawn.getConfig().getDouble("Spawn.Yaw");
		Location location = new Location(world, x, y, z);
		location.setPitch(pitch);
		location.setYaw(yaw);
		return location;
	}
	
	
}
