package demo.campaign.levels.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.bosses.GoblinKing;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.EarthChest;
import demo.domain.items.grassset.GrassChestplate;
import demo.domain.items.leafset.LeafDaggers;

public class ForestBoss extends Level{
	
	private DropController dropCtrl;
	
	public ForestBoss(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Forest Boss");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new GoblinKing(5));
		return bots;
	}
	@Override
	public void printStoryBefore() {
		
	}
	@Override
	public void printStoryAfter() {
		System.out.println("\nSorath:");
		System.out.println("  That looked easy, with you we might be able to win this war.");
		System.out.println("  Anyway this is Sabrael, commander of The Angelic Forces, she will be");
		System.out.println("  guiding you through the game.");
		
		System.out.println("\nSabrael:");
		System.out.println("  Hi I am Sabrael.");
		System.out.println("  Here take this. It is a Legendary Leaf Daggers, it will be useful when fighting Earth ");
		System.out.println("  monsters like those goblins. You can equip it in Inventory Menu by ");
		System.out.println("  typing  “equip Leaf Daggers”.\n");
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new EarthChest());
			dropCtrl.addGear(new GrassChestplate());
			dropCtrl.addGear(new LeafDaggers());
		}
	}
}
