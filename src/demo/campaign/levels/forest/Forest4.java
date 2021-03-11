package demo.campaign.levels.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import demo.combat.bots.earth.EarthSpirit;
import demo.combat.bots.earth.Goblin;
import demo.crafting.materials.GoblinTooth;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.campaign.GoblinDagger;
import demo.domain.items.grassset.GrassBlade;
import demo.domain.items.grassset.GrassPants;

public class Forest4 extends Level{
	
	private Random random;
	private DropController dropCtrl;
	
	public Forest4(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Forest - 4");
		this.random = new Random();
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Goblin(1, 4));
		bots.add(new EarthSpirit(2,4));
		bots.add(new EarthSpirit(3,4));
		return bots;
	}
	public void loot() {
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassPants());
			if(random.nextDouble() < 0.25) {
				dropCtrl.addGear(new GoblinDagger());
			}
			if(random.nextDouble()< 0.9) {
				dropCtrl.addMaterial(new GoblinTooth(), random.nextInt(5));
			}
			dropCtrl.addXP(10);
		}
	}
	@Override
	public void printStoryBefore() {
		System.out.println("\nSorath:");
		System.out.println("  Ok second try, go on my mark.");
		System.out.println("  ");
	}
	@Override
	public void printStoryAfter() {
		
	}

	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		loot();
	}
}
