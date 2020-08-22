package demo.domain.chests;

import java.util.*;

import demo.domain.Chest;
import demo.domain.Gear;
import demo.domain.items.emberset.*;
import demo.domain.items.flameset.*;

public class FireChest extends Chest{
	
	//declaring rare drop pool list
	private List<Gear> dropPoolRare;
	//declaring legendary drop pool list
	private List<Gear> dropPoolLegendary;

	public FireChest() {
		//giving chest name to super class
		super("Fire Chest",0, 1, 0.2);
		//initialising rare drop pool list
		this.dropPoolRare = new ArrayList<>();
		//initialising legendary drop pool list
		this.dropPoolLegendary = new ArrayList<>();
		//setting drop pool items
		this.setDropPool();
		//setting drop pools to super class
		super.setRareDropPool(dropPoolRare);
		super.setLegendaryDropPool(dropPoolLegendary);
	}
	public void setDropPool() {
		this.setRareItems();
		this.setLegendaryItems();
	}
	
	public void setRareItems() {
		//setting Ember Set
		this.dropPoolRare.add(new EmberSword());
		this.dropPoolRare.add(new EmberPants());
		this.dropPoolRare.add(new EmberChestplate());
		this.dropPoolRare.add(new EmberBoots());
		this.dropPoolRare.add(new EmberHelmet());
		
	}
	public void setLegendaryItems() {
		//setting Flame Set
		this.dropPoolLegendary.add(new FlameSword());
		this.dropPoolLegendary.add(new FlameChestplate());
		this.dropPoolLegendary.add(new FlameHelmet());
		this.dropPoolLegendary.add(new FlameBoots());
		this.dropPoolLegendary.add(new FlamePants());
	}
}	
