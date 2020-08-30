package demo.ui;

import java.util.List;
import java.util.Scanner;

import demo.domain.ChestInventory;
import demo.domain.Equipment;
import demo.domain.Gear;
import demo.domain.Inventory;
import demo.domain.ItemIndex;
import demo.domain.chests.*;
import demo.utility.UsefulMethods;

public class ChestMenu {
	
	private UsefulMethods useful;
	private Scanner r;
	private ItemIndex index;
	private Inventory inv;
	private ChestInventory chestInv;
	private Equipment equip;
	
	public ChestMenu(Scanner r, ItemIndex ii, Inventory i, ChestInventory ci, Equipment e) {
		this.useful = new UsefulMethods();
		this.r = r;
		this.index = ii;
		this.inv = i;
		this.chestInv = ci;
		this.equip = e;
	}
	public void start() {
		
		this.printCommands();
		
		while(true) {
			System.out.print("> ");
			String command = r.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.equals("list")) {
				this.printCommands();
			}else if(command.equals("list chests")) {
				this.chestInv.listChests();
			}else if(command.equals("open")||command.equals("add")) {
				continue;	
			}else if(command.equals("open all")) {
				openAll();
			}else if(command.contains("open")) {
				open(command);
			}
			else if(command.contains("add")) {
				add(command);
			}
		}
		System.out.println("--Chest Menu Closed--");
	}
	public void open(String command) {
		if(this.chestInv.canOpen() ) {
			String[] parts = command.split(" ", 2);
			if(this.useful.isNumeric(parts[1])&&Integer.parseInt(parts[1]) >= 0&&parts.length == 2) {
				Gear g = chestInv.open(Integer.parseInt(parts[1]));
				this.index.setFound(g.getName());
				if(this.equip.checkIfEquipped(g.getName())) {
					this.equip.upgrade(g.getID());
				}else if(inv.checkIfInInventory(g)) {
					inv.boost(g.getName());
					System.out.println("boosted");
				}
				else {
					inv.addItem(g);
				}
				System.out.println("  You got: " + g);
			}else {
				System.out.println("Invalid Number");
			}
		}else {
			System.out.println("No chests in inventory");
		}
	}
	private void openAll() {
		List<Gear> opened = this.chestInv.openAll();
		for(Gear g: opened) {
			this.index.setFound(g.getName());
			System.out.println("  You got: " + g);
		}
	}
	public void add(String command) {
		String[] parts = command.split(" ", 3);
		int amount = 1;
		if(parts.length == 3) {
			amount = Integer.parseInt(parts[2]);
		}
		for(int i = 0; i < amount; i++) {
			if(parts[1].equals("Fire")) {
				this.chestInv.add(new FireChest());
			}
			if(parts[1].equals("Water")) {
				this.chestInv.add(new WaterChest());
			}
			if(parts[1].equals("Earth")) {
				this.chestInv.add(new EarthChest());
			}
			if(parts[1].equals("Basic")) {
				this.chestInv.add(new BasicChest());
			}
			if(parts[1].equals("Flame")) {
				this.chestInv.add(new FlameSwordChest());
			}
		}
	}
	private void printCommands() {
		System.out.println("--Chest Menu Commands--");
		System.out.println("  close	      - closes chest menu");
		System.out.println("  list        - list commands");
		System.out.println("  list chests - list chest inventory");
		System.out.println("  open [nro]  - opens chest");	
		System.out.println("  open all    - opens all your chests");
	}
}	
