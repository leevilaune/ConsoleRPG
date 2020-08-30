package demo.campaign.levels.beach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.Siren;
import demo.combat.bots.WaterSpirit;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.aquaticset.AquaticBoots;

public class Beach2 extends Level{
	
	private DropController dropCtrl;
	
	public Beach2(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "The Beach - 2");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new WaterSpirit(1, 7));
		bots.add(new Siren(2, 7));
		bots.add(new WaterSpirit(3,7));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new AquaticBoots());
		}
	}
}
