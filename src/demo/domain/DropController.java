package demo.domain;

public class DropController {
	
	private Player player;
	private Inventory inv;
	private ChestInventory chestInv;
	private MaterialInventory mInv;
	private Equipment equip;
	
	public DropController(Player p, Inventory inv, ChestInventory cInv, MaterialInventory mInv, Equipment e) {
		this.player = p;
		this.inv = inv;
		this.chestInv = cInv;
		this.mInv = mInv;
		this.equip = e;
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
		if(this.equip.checkIfEquipped(g.getName())) {
			this.equip.upgrade(g.getID());
		}else if(inv.checkIfInInventory(g)) {
			inv.boost(g.getName());
			System.out.println("Boosted " + g);
		}
		else {
			inv.addItem(g);
			System.out.println("You got " + g);
		}
	}
	public void addMaterial(Material m, int a) {
		//this.mInv.addMaterial(m, a);
		//System.out.println("You got " + m);
	}
}
