package demo.domain;

public class Boost {
	
	private Inventory inv;
	
	public Boost(Inventory i) {
		this.inv = i;
	}
	
	public void boost(String name) {
		if(inv.getAmountOfGear(name) > 1) {
			Gear gear = inv.getItemByName(name);
			gear.upgrade();
			inv.removeItem(gear);
		}
	}
	
}
