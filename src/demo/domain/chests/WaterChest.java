package demo.domain.chests;

import java.util.*;

import demo.domain.Chest;
import demo.domain.Gear;
import demo.domain.items.aquaticset.*;
import demo.domain.items.oceanset.*;

public class WaterChest extends Chest{
	
	//declaring rare drop pool list
	private List<Gear> dropPoolRare;
	//declaring legendary drop pool list
	private List<Gear> dropPoolLegendary;

	public WaterChest() {
		//giving chest name to super class
		super("Water Chest",0, 1, 0.3);
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
		//setting Aquatic Set
		this.dropPoolRare.add(new AquaticSword());
		this.dropPoolRare.add(new AquaticChestplate());
		this.dropPoolRare.add(new AquaticHelmet());
		this.dropPoolRare.add(new AquaticBoots());
		this.dropPoolRare.add(new AquaticPants());
	}
	public void setLegendaryItems() {
		//setting Ocean Set
		this.dropPoolLegendary.add(new OceanBlades());
		this.dropPoolLegendary.add(new OceanCrown());
		this.dropPoolLegendary.add(new OceanChestplate());
		this.dropPoolLegendary.add(new OceanBoots());
		this.dropPoolLegendary.add(new OceanPants());
	}
}	
