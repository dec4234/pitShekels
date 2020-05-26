package pitShekelsCommands;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import pitShekelsController.Shekels;

@SuppressWarnings("deprecation")
public class BalanceGUI {

	Player p;
	Inventory inv;
	String pattern = "MM/dd/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String date;
	
	Shekels s = new Shekels();

	public BalanceGUI(Player p, Player target) {
		this.p = p;
		date = simpleDateFormat.format(new Date(target.getFirstPlayed()));
		
		openGUI(p, target);
	}

	public void openGUI(Player p, Player target) {
		inv = Bukkit.createInventory(null, 9, "§a§lBalance of §6§l" + target.getName());
		
		ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(target.getName());
		List<String> skullLore = new ArrayList<String>();
		skullLore.add("§6§lFirst played: §7" + date);
		skullLore.add("§a§lShekels: §d" + String.valueOf(s.getMoney(target)));
		meta.setDisplayName("§b§l" + target.getName());
		
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		meta.setLore(skullLore);
		skull.setItemMeta(meta);
		
		ItemStack barrier = new ItemStack(Material.BARRIER, 1);
		ItemMeta barrierMeta = barrier.getItemMeta();
		barrierMeta.setDisplayName("§c§lClose info page");
		List<String> barrierLore = new ArrayList<String>();
		barrierLore.add("§dClose the info page of §5" + target.getName());
		barrierMeta.setLore(barrierLore);
		barrier.setItemMeta(barrierMeta);
		
		inv.setItem(0, skull);
		inv.setItem(8, barrier);
		
		p.openInventory(inv);
	}
}
