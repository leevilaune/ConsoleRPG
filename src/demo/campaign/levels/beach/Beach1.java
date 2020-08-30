package demo.campaign.levels.beach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.Siren;
import demo.combat.bots.WaterSpirit;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.aquaticset.AquaticSword;

public class Beach1 extends Level{
	
	private DropController dropCtrl;
	
	public Beach1(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "The Beach - 1");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new Siren(1, 6));
		bots.add(new Siren(2, 6));
		bots.add(new WaterSpirit(3,6));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		if(!super.isCompleted()) {
			System.out.println("\nNarrator: ");
			System.out.println("  Welcome to The Beaches of The Great Ocean, a place where nasty");
			System.out.println("  sea creatures live. Like Sirens and Water Spirits.");
			System.out.println("  You need to fight your way through The Beach.\n");
		}
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new AquaticSword());
		}
	}
}
