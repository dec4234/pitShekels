package pitShekelsCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pitShekelsController.Shekels;
import pitShekelsSrc.ShekelData;

public class MoneyCommand implements CommandExecutor {

	Shekels s = new Shekels();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase(ShekelData.CMD2.getValue())) {
			if (sender instanceof Player) {
				if (args.length == 2) {
					Player pl = Bukkit.getPlayer(args[0]);
					if (pl != null) {
						s.checkPlayerDataCondition(pl);
						s.addMoney(pl, Double.parseDouble(args[1]));
					} else {
						sender.sendMessage("§e" + args[0] + " §cis not a valid online player!");
					}
					return true;
				}
				return false;
			} else {
				sender.sendMessage(ChatColor.RED + "Only players can use this command");
			}
		}
		return true;
	}

}
