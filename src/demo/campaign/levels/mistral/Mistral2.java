package demo.campaign.levels.mistral;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.FallenAngel;
import demo.combat.bots.Harpy;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.breezeset.BreezeBoots;

public class Mistral2 extends Level {

	private DropController dropCtrl;
	
	public Mistral2(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Mistral - 2");
		super.setLocked(false);
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Harpy(1, 12));
		bots.add(new FallenAngel(2,12));
		bots.add(new Harpy(3,12));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		if(!super.isCompleted()) {
			//Set story here
		}
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new BreezeBoots());
		}
	}
}
