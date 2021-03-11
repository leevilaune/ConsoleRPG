package demo.campaign.levels.forest;

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
import demo.domain.items.grassset.GrassCrown;

public class Forest3 extends Level {
	
	private Random random;
	private DropController dropCtrl;
	private Player p;
	
	public Forest3(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Forest - 3");
		this.random = new Random();
		this.dropCtrl = dc;
		this.p = p;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Goblin(1,3));
		bots.add(new GoblinCommander(2,3));
		bots.add(new Goblin(3,3));
		return bots;
	}
	public void loot() {
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassCrown());
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
		System.out.println("  That's the clearing. Prepare to go on my mark.");
		System.out.println("  Wait, what is that Goblin doing there? I have never heard");
		System.out.println("  that Goblin would be in a clearing. Usually they hate open and prefer their");
		System.out.println("  underground houses or thick Forest.");
		
		System.out.println("\nGoblin:");
		System.out.println("  Hey what are you doing here?? Who are you??");
		
		System.out.println("\nSorath:");
		System.out.println("  " + p.getName() + ", little help?\n");
		
	}
	@Override
	public void printStoryAfter() {
		System.out.println("\nSorath:");
		System.out.println("  Are they even hard for you? It looks so easy but i don't know anyone who");
		System.out.println("  Don’t struggle fighting goblins. Even that goblin commander looked easy.");
		System.out.println("  Anyway let's go to take that clearing now. After that we have cleared this");
		System.out.println("  forest.\n");
	}

	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		loot();
	}
}
