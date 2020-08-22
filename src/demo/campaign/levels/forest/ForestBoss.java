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

public class ForestBoss extends Level{
	
	private DropController dropCtrl;
	
	public ForestBoss(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "The Forest Boss");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new GoblinKing(5));
		return bots;
	}
	@Override
	public void start() {
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new EarthChest());
			dropCtrl.addGear(new GrassChestplate());
			System.out.println("You got Earth Chest, Grass Plate");
		}
	}
}
