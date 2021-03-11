package demo.domain;

import java.util.*;

public class ChestInventory {
	
	private List<Chest> chests;
	private Inventory inv;
	private Equipment equip;
	
	public ChestInventory(Inventory i, Equipment e) {
		this.chests = new ArrayList<>();
		this.inv = i;
		this.equip = e;
	}
	public void add(Chest c) {
		this.chests.add(c);
	}
	public Gear open(int index) {
		int i = index;
		if(i >= this.chests.size()) {
			i = this.chests.size()-1;
		}
		Chest chest = this.chests.get(i);
		Gear opened = chest.open();
		this.chests.remove(i);
		return opened;
	}
	public List<Gear> openAll() {
		List<Gear> openedGear = new ArrayList<>();
		List<Chest> opened = new ArrayList<>();
 		for(Chest c: this.chests) {
 			Gear g = c.open();
 			if(this.equip.checkIfEquipped(g.getName())) {
				this.equip.upgrade(g.getID());
			}else if(inv.checkIfInInventory(g)) {
				inv.boost(g.getName());
				System.out.println("  Boosted " + g);
			}
			else {
				openedGear.add(g);
				inv.addItem(g);
				System.out.println("  You got: " + g);
			}
			opened.add(c);
		}
 		this.chests.removeAll(opened);
 		return openedGear;
	}
	public void listChests() {
		int index = 0;
		for(Chest c: this.chests) {
			System.out.println(index + ". " + c);
			index++;
		}
	}
	public boolean canOpen() {
		if(this.chests.size() > 0) {
			return true;
		}
		return false;
	}
	public List<Chest> getChests() {
		return this.chests;
	}
}
