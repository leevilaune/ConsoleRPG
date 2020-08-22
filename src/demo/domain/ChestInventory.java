package demo.domain;

import java.util.*;

public class ChestInventory {
	
	private List<Chest> chests;
	
	public ChestInventory() {
		this.chests = new ArrayList<>();
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
			openedGear.add(c.open());
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
}
