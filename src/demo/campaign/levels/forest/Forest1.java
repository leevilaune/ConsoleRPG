package demo.campaign.levels.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.EarthSpirit;
import demo.combat.bots.Goblin;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Gear;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.grassset.GrassBlade;

public class Forest1 extends Level {
	
	private DropController dropCtrl;
	
	public Forest1(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "The Forest - 1");
		super.setLocked(false);
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Goblin(1, 1));
		bots.add(new EarthSpirit(2,1));
		bots.add(new Goblin(3,1));
		return bots;
	}
	@Override
	public void start() {
		System.out.println("\nNarrator:");
		System.out.println("  Welcome to The Plane of Elements, world of elements. ");
		System.out.println("  You arrived just in time, our resistance against The Lunar Circle is dying,");
		System.out.println("  and we need a strong hero to save The Plane of Elements.");
		System.out.println("  We are trying to get through The Forest and we need your help.\n");
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassBlade());
			System.out.println("You got Basic Chest, Grass Blade");
		}
	}
}
