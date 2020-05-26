package pitShekelsCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pitShekelsSrc.ShekelData;

public class BalanceCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase(ShekelData.CMD1.getValue()) || label.equalsIgnoreCase("bal") || label.equalsIgnoreCase("info") || label.equalsIgnoreCase("playerinfo")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can use this command!");
				return true;
			}

			Player p = (Player) sender;

			if (args.length == 0) {
				new BalanceGUI(p, p);
			} else if (args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null) {
					new BalanceGUI(p, target);
				} else {
					sender.sendMessage("§6" + args[0] + " §cis not a valid §aonline §cplayer!");
				}
			} else {
				return false;
			}
		}
		return true;
	}

}
