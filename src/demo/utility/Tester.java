package demo.utility;

import java.util.Scanner;

import demo.domain.*;
import demo.raid.levels.GoblinQueenRaid;

public class Tester {
	
	private Player p;
	private Scanner r;
	private Equipment e;
	private Inventory i;
	private ChestInventory ci;
	private MaterialInventory mi;
	private DropController dc;
	
	public Tester() {
		this.e = new Equipment(new ItemIndex());
		this.i = new Inventory(new ItemIndex());
		this.ci = new ChestInventory(i,e);
		this.mi = new MaterialInventory();
		this.p = new Player(e);
		this.r = new Scanner(System.in);
		
		this.dc = new DropController(p, i, ci, mi, e);
	}
	public void testGoblinQueenDrops(int times) {
		GoblinQueenRaid gqr = new GoblinQueenRaid(p,r,dc);
		gqr.setCompleted(true);
		for(int i = 0; i<=times; i++) {
			gqr.loot();
			//System.out.println(i);
		}
		System.out.println("");
		this.i.listItems();
	}
}	
