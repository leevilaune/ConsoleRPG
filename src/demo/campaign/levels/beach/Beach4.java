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
import demo.domain.items.aquaticset.AquaticPants;

public class Beach4 extends Level{
	private DropController dropCtrl;
	
	public Beach4(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Beach - 4");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Siren(1, 9));
		bots.add(new WaterSpirit(2, 9));
		bots.add(new Siren(3,9));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new AquaticPants());
		}
	}
}
