package pitShekelsController;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import pitShekelsSrc.PitShekelsMain;
import psScoreboard.ScoreboardData;

public class Shekels {

    FileConfiguration config;
    RandomCollection<Double> random = new RandomCollection<>();

    public Shekels() {
        config = PitShekelsMain.getInstance().ymlConfig;

    }

    public double getMoney(Player p) {
        checkPlayerDataCondition(p);

        return config.getDouble(p.getUniqueId().toString());
    }

    public void addMoney(Player p, double d) {
        double i = getMoney(p);

        config.set(p.getUniqueId().toString(), i + d);
        saveData();
        updateScoreboardMoney(p);
    }

    public void subtractMoney(Player p, double d) {
        double i = getMoney(p);
        if (canAfford(p, d)) {
            config.set(p.getUniqueId().toString(), i - d);
        }
        saveData();
        updateScoreboardMoney(p);
    }

    public boolean canAfford(Player p, double d) {
        if (getMoney(p) >= d) {
            return true;
        } else {
        	p.sendMessage(ChatColor.RED + "You can not afford to buy this");
        }
        return false;
    }

    public void updateScoreboardMoney(Player p) {
        p.getScoreboard().getTeam(ScoreboardData.TEAM3.getValue()).setSuffix(" §a" + getMoney(p));
    }

    public void checkPlayerDataCondition(Player p) {
        if (!config.contains(p.getUniqueId().toString())) {
            config.set(p.getUniqueId().toString(), 0);
        }
    }

    public void saveData() {
        PitShekelsMain.getInstance().saveYml(config, PitShekelsMain.getInstance().ymlFile);
    }

    public double grabRandomLow() {
        random.add(0.8, 0.0);
        random.add(0.1, 0.125);
        random.add(0.08, 0.25);
        random.add(0.02, 0.5);

        return random.next();
    }
    
    public double grabRandomMedium() {
        random.add(0.2, 0.0);
        random.add(0.3, 0.25);
        random.add(0.4, 0.5);
        random.add(0.1, 1.0);

        return random.next();
    }
    
    public double grabRandomHigh() {
        random.add(0.2, 0.5);
        random.add(0.3, 0.75);
        random.add(0.4, 1.5);
        random.add(0.1, 2.0);

        return random.next();
    }
}
