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
import demo.domain.items.breezeset.BreezeSword;

public class Mistral1 extends Level{
	
	private DropController dropCtrl;
	
	public Mistral1(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Mistral - 1");
		super.setLocked(false);
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new FallenAngel(1, 11));
		bots.add(new Harpy(2,11));
		bots.add(new Harpy(3,11));
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
			dropCtrl.addGear(new BreezeSword());
		}
	}
}
