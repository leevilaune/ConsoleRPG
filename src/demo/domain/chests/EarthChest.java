package demo.domain.chests;

import java.util.*;

import demo.domain.Chest;
import demo.domain.Gear;
import demo.domain.items.grassset.GrassBlade;
import demo.domain.items.grassset.GrassBoots;
import demo.domain.items.grassset.GrassChestplate;
import demo.domain.items.grassset.GrassCrown;
import demo.domain.items.grassset.GrassPants;
import demo.domain.items.leafset.LeafBoots;
import demo.domain.items.leafset.LeafChestplate;
import demo.domain.items.leafset.LeafCrown;
import demo.domain.items.leafset.LeafDaggers;
import demo.domain.items.leafset.LeafPants;

public class EarthChest extends Chest{
	
	//declaring rare drop pool list
	private List<Gear> dropPoolRare;
	//declaring legendary drop pool list
	private List<Gear> dropPoolLegendary;

	public EarthChest() {
		//giving chest name to super class
		super("Earth Chest",0, 1, 0.3);
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
		//setting Grass Set
		this.dropPoolRare.add(new GrassBlade());
		this.dropPoolRare.add(new GrassCrown());
		this.dropPoolRare.add(new GrassChestplate());
		this.dropPoolRare.add(new GrassPants());
		this.dropPoolRare.add(new GrassBoots());
		
	}
	public void setLegendaryItems() {
		//setting Leaf Set
		this.dropPoolLegendary.add(new LeafDaggers());
		this.dropPoolLegendary.add(new LeafCrown());
		this.dropPoolLegendary.add(new LeafChestplate());
		this.dropPoolLegendary.add(new LeafPants());
		this.dropPoolLegendary.add(new LeafBoots());
	}
}	