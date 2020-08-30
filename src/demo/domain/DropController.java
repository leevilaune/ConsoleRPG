package demo.domain;

public class DropController {
	
	private Player player;
	private Inventory inv;
	private ChestInventory chestInv;
	
	public DropController(Player p, Inventory inv, ChestInventory chestInv) {
		this.player = p;
		this.inv = inv;
		this.chestInv = chestInv;
	}
	public void awardCoins(int coins) {
		player.awardCoins(coins);
		System.out.println("You got "+ coins + " Coins");
	}
	public void addChest(Chest c) {
		this.chestInv.add(c);
		System.out.println("You got " + c);
	}
	public void addGear(Gear g) {
		this.inv.addItem(g);
		System.out.println("You got " + g);
	}
	
}
