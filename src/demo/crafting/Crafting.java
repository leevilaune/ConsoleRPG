package demo.crafting;

import java.util.ArrayList;
import java.util.List;

import demo.domain.Equipment;
import demo.domain.Gear;
import demo.domain.Inventory;
import demo.domain.MaterialInventory;

import demo.domain.items.campaign.GoblinDagger;

public class Crafting {
	
	private Inventory inv;
	private MaterialInventory mInv;
	private Equipment equip;
	
	private List<Gear> craftableItems;
	
	public Crafting(Inventory i, Equipment e, MaterialInventory mi) {
		this.inv = i;
		this.mInv = mi;
		this.equip = e;
		
		this.craftableItems = new ArrayList<>();
		setCraftableItems();
	}
	
	public void setCraftableItems() {
		GoblinDagger goblinDagger = new GoblinDagger();
		goblinDagger.setMaterialInventory(mInv);
		this.craftableItems.add(goblinDagger);
	}
	
	public void craft(String name) {
		System.out.println("Crafting");
		for(Gear g: this.craftableItems) {
			System.out.println(g);
			if(g.getName().equals(name)) {
				System.out.println("Crafting " + g.getName());
				if(g.getRecipe().areMet(mInv.getMaterials())) {
					g.getRecipe().craft();
					if(this.equip.checkIfEquipped(g.getName())) {
						this.equip.upgrade(g.getID());
					}else if(inv.checkIfInInventory(g)) {
						inv.boost(g.getName());
						System.out.println("  Boosted " + g);
					}
					else {
						inv.addItem(g);
						System.out.println("  You Crafted: " + g);
					}
				}else {
					System.out.println("You dont have enough materials");
				}
			}
		}
	}
	public void listCraftables() {
		for(Gear g: this.craftableItems) {
			System.out.println(g.getRecipe());
		}
	}
	private Gear getCraftableItem() {
		return null;
	}
	
}
