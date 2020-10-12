package demo.domain;

import java.util.*;

public class Inventory {
	
	private List<Gear> inv;
	private ItemIndex itemIndex;
	
	public Inventory(ItemIndex ii) {
		this.inv = new ArrayList<>();
		this.itemIndex = ii;
	}
	public List<Gear> getInv(){
		return this.inv;
	}
	public boolean checkIfInInventory(Gear itemToCheck) {
		for(Gear g: this.inv) {
			if(itemToCheck == null) {
				System.out.println("Gear doesn't Exist");
				return false;
			}
			if(g.getName().contains(itemToCheck.getName())) {
				return true;
			}
		}
		return false;
	}
	public void printAmountOfItem(String name) {
		int amount = 0;
		Gear gear = itemIndex.getGear(name);
		for(Gear g: this.inv) {
			if(g.getName().equals(name)) {
				amount++;
			}
		}
		System.out.println(gear + " " + amount + "x");
	}
	public void addItem(Gear g) {
		this.inv.add(g);
	}
	public void addAllItems(List<Gear> items) {
		this.inv.addAll(items);
	}
	public void removeItem(Gear g) {
		this.inv.remove(g);
	}
	public void removeAllItems(List<Gear> items) {
		this.inv.removeAll(items);
	}
	public void boost(String name) {
		getItemByName(name).upgrade();
	}
	public Gear getItemByName(String name) {
	
		Gear i = null;
		for(Gear item: this.inv) {
			if(item.getName().equals(name)) {
				i = item;
			}
		}
		return i;
	}
	public void listItems() {
		this.inv.forEach(i-> System.out.println(i + ", " + i.getLevel()));
	}
	public int getAmountOfGear(String name) {
		Gear gear = this.itemIndex.getGear(name);
		if(gear != null) {
			int amount = 0;
			for(Gear g: this.inv) {
				if(g.getName().equals(gear.getName())) {
					amount++;
				}
			}
			return amount;
		}
		return -1;
	}
	public List<Gear> getItemsForBoost(String name){
		List<Gear> gear = new ArrayList<>();
		for(Gear g: this.inv) {
			if(g.getName().equals(name)) {
				gear.add(g);
			}
		}
		return gear;
	}
	public List<Gear> getInventory(){
		return this.inv;
	}
}
