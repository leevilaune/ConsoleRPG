package demo.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import demo.combat.bots.TargetDummy;
import demo.combat.bots.earth.Goblin;
import demo.crafting.materials.GoblinTooth;
import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.BasicChest;
import demo.domain.items.campaign.GoblinDagger;
import demo.domain.items.grassset.GrassBlade;

public class CombatTestScene extends Level {
	
	private Random random;
	private DropController dropCtrl;
	private Scanner r;
	private Player p;
	
	public CombatTestScene(Player p, Scanner r, DropController dc) {
		super(p, r, setBots(p.getLevel()), "Test");
		super.setLocked(false);
		this.random = new Random();
		this.dropCtrl = dc;
		
		this.r = r;
		this.p = p;
	}
	private static List<Bot> setBots(int level){
		List<Bot> bots = new ArrayList<>();
		bots.add(new TargetDummy());
		return bots;
	}

	@Override
	public void start() {
		super.setEnemies(setBots(p.getLevel()));
		super.start();
	}
}

