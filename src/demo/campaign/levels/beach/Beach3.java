package demo.campaign.levels.beach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.water.Siren;
import demo.combat.bots.water.WaterSpirit;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.aquaticset.AquaticHelmet;

public class Beach3 extends Level {
	
private DropController dropCtrl;
	
	public Beach3(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "The Beach - 3");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Siren(1, 8));
		bots.add(new WaterSpirit(2, 8));
		bots.add(new WaterSpirit(3,8));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new AquaticHelmet());
		}
	}
}
