package pitShekelsCommands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import pitShekelsController.Shekels;

public class MobKillEvents implements Listener {

	Shekels s = new Shekels();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMobDeath(EntityDeathEvent e) {
		if (!(e.getEntity() instanceof Player) && e.getEntity().getKiller() != null) {
			Player p = e.getEntity().getKiller();
			if (e.getEntity().getMaxHealth() < 10) {
				s.addMoney(p, s.grabRandomLow());
			} else if (e.getEntity().getMaxHealth() < 25) {
				s.addMoney(p, s.grabRandomMedium());
			} else {
				s.addMoney(p, s.grabRandomHigh());
			}
		}
	}
}
