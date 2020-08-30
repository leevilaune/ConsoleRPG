package demo.campaign.levels.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.EarthSpirit;
import demo.combat.bots.Goblin;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.grassset.GrassCrown;

public class Forest3 extends Level {
	
	private DropController dropCtrl;
	
	public Forest3(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "The Forest - 3");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Goblin(1, 3));
		bots.add(new EarthSpirit(2,3));
		bots.add(new EarthSpirit(3,3));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassCrown());
		}
	}
}
