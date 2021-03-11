package demo.campaign.levels.ruins;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import demo.combat.bots.earth.*;
import demo.crafting.materials.GoblinTooth;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.campaign.GoblinDagger;
import demo.domain.items.grassset.GrassBlade;

public class Ruins1 extends Level{

	private DropController dropCtrl;
	
	public Ruins1(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Ruins - 1");
		this.dropCtrl = dc;
	}
	public void loot() {
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassBlade());
			dropCtrl.addXP(10);
		}
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Ogre(1,6));
		bots.add(new DarkElf(2,6));
		bots.add(new DarkElf(3,6));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		loot();
	}
}
