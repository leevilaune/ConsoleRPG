package demo.raid.levels;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import demo.domain.Bot;
import demo.domain.DropController;
import demo.domain.Gear;
import demo.domain.Player;
import demo.domain.items.crimsonset.*;
import demo.raid.monsters.GoblinQueen;

public class GoblinQueenRaid extends RaidLevel{

	private DropController dropCtrl;
	private Random rand;
	private Player p;
	private int level;
	
	public GoblinQueenRaid(Player p,Scanner r,DropController dc) {
		super(p,r,setBoss(1),"Goblin Queen");
		this.dropCtrl = dc;
		this.rand = new Random();
		this.p = p;
		this.level = p.getEquipment().getTotalPower()/20;
		System.out.println(p.getEquipment().getTotalPower());
		System.out.println(level);
	}
	public void loot() {
		if(super.isCompleted()) {
			if(rand.nextDouble() < 0.4) {
				Gear g = randomizeDrop();
				dropCtrl.addGear(g);
				System.out.println(g);
			}
			dropCtrl.addXP(100);
		}
	}
	public Gear randomizeDrop() {
		List<Gear> crSet = new ArrayList<>();
		crSet.add(new CrimsonBow());
		crSet.add(new CrimsonHood());
		crSet.add(new CrimsonTunic());
		crSet.add(new CrimsonPants());
		crSet.add(new CrimsonBoots());
		return crSet.get(rand.nextInt(crSet.size()));
	}
	public static List<Bot> setBoss(int l){
		List<Bot> boss = new ArrayList<>();
		boss.add(new GoblinQueen(l));
		return boss;
	}
	@Override
	public void start() {
		super.setEnemies(setBoss(level));
		super.start();
		this.loot();
	}
}
