package demo.campaign.levels.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.EarthSpirit;
import demo.combat.bots.Goblin;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.grassset.GrassBoots;

public class Forest2 extends Level{
	
	private DropController dropCtrl;
	
	public Forest2(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "The Forest - 2");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new EarthSpirit(1, 3));
		bots.add(new EarthSpirit(2,3));
		bots.add(new Goblin(3,3));
		return bots;
	}
	@Override
	public void start() {
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassBoots());
			System.out.println("You got Basic Chest, Grass Boots");
		}
	}
}
