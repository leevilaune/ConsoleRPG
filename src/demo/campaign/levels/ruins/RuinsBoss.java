package demo.campaign.levels.ruins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.combat.bots.earth.DarkElf;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.grassset.GrassBlade;

public class RuinsBoss extends Level{
	
	private DropController dropCtrl;
	
	public RuinsBoss(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(), "Ruins Boss");
		this.dropCtrl = dc;
	}
	private static List<Bot> setBots(){
		List<Bot> bots = new ArrayList<>();
		bots.add(new DarkElf(1,2));
		return bots;
	}
	@Override
	public void start() {
		super.setEnemies(setBots());
		super.start();
		if(super.isCompleted()) {
			dropCtrl.addChest(new BasicChest());
			dropCtrl.addGear(new GrassBlade());
		}
	}
}
