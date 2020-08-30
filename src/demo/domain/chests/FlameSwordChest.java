package demo.domain.chests;

import java.util.ArrayList;
import java.util.List;

import demo.domain.Chest;
import demo.domain.Gear;
import demo.domain.items.flameset.FlameSword;

public class FlameSwordChest extends Chest {
	
	private List<Gear> dropPoolLegendary;
	
	public FlameSwordChest() {
		//giving chest name to super class
		super("Fire Chest",0, 0, 1);
		//initialising rare drop pool list
		//initialising legendary drop pool list
		this.dropPoolLegendary = new ArrayList<>();
		//setting drop pool items
		this.setDropPool();
		//setting drop pools to super class
		super.setLegendaryDropPool(dropPoolLegendary);
	}
	private void setDropPool() {
		this.setLegendaries();
	}
	private void setLegendaries() {
		this.dropPoolLegendary.add(new FlameSword());
	}
}
