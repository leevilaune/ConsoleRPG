package demo.domain;

public class DropController {
	
	private Inventory inv;
	private ChestInventory chestInv;
	
	public DropController(Inventory inv, ChestInventory chestInv) {
		this.inv = inv;
		this.chestInv = chestInv;
	}
	public void addChest(Chest c) {
		this.chestInv.add(c);
	}
	public void addGear(Gear g) {
		this.inv.addItem(g);
	}
	
}
