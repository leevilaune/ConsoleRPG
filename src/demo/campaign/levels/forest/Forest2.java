package demo.campaign.levels.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.earth.EarthSpirit;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.grassset.GrassBoots;

public class Forest2 extends Level{
	
	private DropController dropCtrl;
	
	public Forest2(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Forest - 2");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new EarthSpirit(1,2));
		bots.add(new EarthSpirit(2,2));
		bots.add(new EarthSpirit(3,2));
		return bots;
	}
	@Override
	public void printStoryBefore() {
		System.out.println("\nSorath:");
		System.out.println("  Be careful there are alot of Earth Spirits around. There is clearing near here");
		System.out.println("  and they are restless so they wander around it. Whoa there are few over");
		System.out.println("  there.\n");
	}
	@Override
	public void printStoryAfter() {
		System.out.println("\nSorath");
		System.out.println("  Thanks, you saved me there. Those Spirits jumped out of nowhere, really");
		System.out.println("  gave me a scare. Glad you were here, I don't think any of my men could have");
		System.out.println("  taken out three Earth Spirits. Let's go clear that clearing.\n");
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassBoots());
		}
	}
}
