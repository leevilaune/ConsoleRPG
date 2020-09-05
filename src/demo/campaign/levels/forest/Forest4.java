package demo.campaign.levels.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.earth.EarthSpirit;
import demo.combat.bots.earth.Goblin;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.grassset.GrassPants;

public class Forest4 extends Level{
private DropController dropCtrl;
	
	public Forest4(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Forest - 4");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Goblin(1, 4));
		bots.add(new EarthSpirit(2,4));
		bots.add(new EarthSpirit(3,4));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassPants());
		}
	}
}
