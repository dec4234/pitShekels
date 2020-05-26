package pitShekelsCommands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BalanceGUIEvents implements Listener{

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().contains("Balance")) {
			e.setCancelled(true);
			
			if(e.getSlot() == 8) {
				p.closeInventory();
			}
			
		}
	}
}
