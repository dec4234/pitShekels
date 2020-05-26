package pitShekelsSrc;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import pitShekelsCommands.BalanceCommand;
import pitShekelsCommands.BalanceGUIEvents;
import pitShekelsCommands.MobKillEvents;

public class PitShekelsMain extends JavaPlugin{
	
	public File ymlFile = new File(this.getDataFolder() + "/playerdata.yml");
    public FileConfiguration ymlConfig = YamlConfiguration.loadConfiguration(ymlFile);
    
    private static PitShekelsMain instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		Bukkit.getPluginManager().registerEvents(new BalanceGUIEvents(), this);
		Bukkit.getPluginManager().registerEvents(new MobKillEvents(), this);
		getCommand(ShekelData.CMD1.getValue()).setExecutor(new BalanceCommand());
		// getCommand(ShekelData.CMD2.getValue()).setExecutor(new MoneyCommand());
	}

	public void saveYml(FileConfiguration ymlConfig, File ymlFile) {
        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
	public static PitShekelsMain getInstance() { return instance; }
}
