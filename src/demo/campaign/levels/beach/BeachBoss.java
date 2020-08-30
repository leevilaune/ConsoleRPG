package demo.campaign.levels.beach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.bosses.WaterDragon;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.WaterChest;
import demo.domain.items.aquaticset.AquaticSword;

public class BeachBoss extends Level{
private DropController dropCtrl;
	
	public BeachBoss(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "The Beach Boss");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new WaterDragon(10));
		return bots;
	}
	@Override
	public void start() {
		
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new WaterChest());
			dropCtrl.addGear(new AquaticSword());
		}
	}
}
