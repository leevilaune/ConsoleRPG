package demo.ui;

import java.util.ArrayList;
import java.util.Scanner;

import demo.domain.Equipment;
import demo.domain.Gear;
import demo.domain.Inventory;
import demo.domain.ItemIndex;
import demo.domain.chests.BasicChest;
import demo.domain.enums.Rarity;
import demo.domain.items.starterset.*;

public class InventoryMenu {
	
	private Scanner reader;
	private Inventory inv;
	private ItemIndex index;
	private Equipment equip;
	
	public InventoryMenu(Inventory inv, ItemIndex ii, Equipment e, Scanner r) {
		this.reader = r;
		this.inv = inv;
		this.index = ii;
		this.equip = e;
	}
	public void start() {
		
		this.printCommandList();
		
		while(true) {
			System.out.print("> ");
			String command = reader.nextLine();
			String[] parts = command.split(" ");
			if(command.equals("close")) {
				break;
			}else if(command.equals("list inv")) {
				this.inv.listItems();
			}else if(command.equals("clear")) {
				clear();
			}else if(parts[0].equals("equip")) {
				equip(command);
			}else if(command.equals("list equip")) {
				this.equip.printEquipment();
			}else if(command.contains("boost")) {
				boost(command);
				System.out.println("Invalid Command");
			}else if(command.contains("details")) {
				details(command);
			}
			else if(command.contains("add")) {
				add(command);
			}
			else {
				System.out.println("Invalid Command");
			}
		}
		System.out.println("--Closed Inventory Menu--");
	}
	private void equip(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length == 2) {
			Gear g = inv.getItemByName(parts[1]);
			if(inv.checkIfInInventory(g)) {
				if(g.getID().equals("Weapon")) {
					this.inv.addItem(this.equip.getWeapon());
					this.equip.setWeapon(g);
					this.inv.removeItem(g);
				}
				if(g.getID().equals("Helmet")) {
					this.inv.addItem(this.equip.getHelmet());
					this.equip.setHelmet(g);
					this.inv.removeItem(g);
				}
				if(g.getID().equals("Chestplate")) {
					this.inv.addItem(this.equip.getChestplate());
					this.equip.setChestplate(g);
					this.inv.removeItem(g);
				}
				if(g.getID().equals("Pants")) {
					this.inv.addItem(this.equip.getPants());
					this.equip.setPants(g);
					this.inv.removeItem(g);
				}
				if(g.getID().equals("Boots")) {
					this.inv.addItem(this.equip.getBoots());
					this.equip.setBoots(g);
					this.inv.removeItem(g);
				}
			}
		}
	}
	private void boost(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length == 2) {
			
			inv.boost(parts[1]);
		}
	}
	private void details(String command) {
		String[] parts = command.split(" ", 2);
		inv.getItemByName(parts[1]).printDetails();
	}
	private void add(String command) {
		String[] parts = command.split(" ", 2);
		if(parts.length > 1) {
			Gear g = index.getGear(parts[1]);
			inv.addItem(g);
			index.setFound(parts[1]);
		}else {
			System.out.println("  You need to use 'add [item name]'");
		}
	}
	private void clear() {

		ArrayList<Gear> toBeRemoved = new ArrayList<>();
		
		for(Gear g: this.inv.getInv()) {
			toBeRemoved.add(g);
		}
		equip.setWeapon(new AdventurerSword());
		equip.setHelmet(new BasicHelmet());
		equip.setChestplate(new BasicChestplate());
		equip.setPants(new BasicPants());
		equip.setBoots(new BasicBoots());
		
		this.inv.getInv().removeAll(toBeRemoved);
	}
	private void printCommandList() {
		System.out.println("--Inventory Menu Commands--");
		System.out.println("  close    	- closes inventory menu");
		System.out.println("  list inv 	- lists content of your inventory");
		System.out.println("  list equip    - list equipment");
		System.out.println("  equip [item]	- equips item to slot");
		//System.out.println("  boost [item]  - boost item");
	}
}
