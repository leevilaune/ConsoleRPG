package demo.campaign.levels.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import demo.combat.bots.earth.Goblin;
import demo.crafting.materials.GoblinTooth;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.campaign.GoblinDagger;
import demo.domain.items.grassset.GrassBlade;

public class Forest1 extends Level {
	
	private Random random;
	private DropController dropCtrl;
	private Scanner r;
	private Player p;
	
	public Forest1(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(p.getLevel()), "Forest - 1");
		super.setLocked(false);
		this.random = new Random();
		this.dropCtrl = dc;
		
		this.r = r;
		this.p = p;
	}
	private static List<Bot> setBots(int level){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Goblin(1,1));
		bots.add(new Goblin(2,1));
		bots.add(new Goblin(3,1));
		return bots;
	}
	public void loot() {
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassBlade());
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
		System.out.println("  Hi, I am Sorath, i am lieutenant in The Angelic Forces");
		System.out.println("  Welcome to The Plane of Elements, world of elements. ");
		System.out.println("  What is your name?");
		System.out.print("Input a name for your character: ");
		String name = r.nextLine();
		p.setName(name);
		System.out.println("  You arrived just in time, our resistance against The Lunar Circle is dying,");
		System.out.println("  and we need a strong hero to save The Plane of Elements.");
		System.out.println("  We are trying to get through The Forest and we need your help.\n");
	}
	@Override
	public void printStoryAfter() {
		System.out.println("\nSorath:");
		System.out.println("  Nice killing. Glad we found you, but we don't have time to rest, ");
		System.out.println("  we need to keep going. We can rest when we have cleared this forest.\n");
	}

	@Override
	public void start() {
		super.setEnemies(setBots(p.getLevel()));
		super.start();
		this.loot();
	}
}
