package demo.domain.chests;

import java.util.ArrayList;
import java.util.List;

import demo.domain.Chest;
import demo.domain.Gear;

import demo.domain.items.starterset.*;
import demo.domain.items.grassset.*;
import demo.domain.items.aquaticset.*;
import demo.domain.items.emberset.*;
import demo.domain.items.leafset.*;
import demo.domain.items.oceanset.*;
import demo.domain.items.flameset.*;

public class BasicChest extends Chest{
	
	private List<Gear> dropPoolCommons;
	private List<Gear> dropPoolRares;
	private List<Gear> dropPoolLegendaries;

	public BasicChest() {
		super("Basic Chest", 1, 0.4, 0.01);
		this.dropPoolCommons = new ArrayList<>();
		this.dropPoolRares = new ArrayList<>();
		this.dropPoolLegendaries = new ArrayList<>();
		
		this.setDropPool();
		
		super.setCommonDropPool(dropPoolCommons);
		super.setRareDropPool(dropPoolRares);
		super.setLegendaryDropPool(dropPoolLegendaries);
	}	
	private void setDropPool() {
		this.setDropPoolCommons();
		this.setDropPoolRares();
		this.setDropPoolLegendaries();
	}
	private void setDropPoolCommons() {
		//adding Basic Set
		this.dropPoolCommons.add(new AdventurerSword());
		this.dropPoolCommons.add(new BasicBoots());
		this.dropPoolCommons.add(new BasicHelmet());
		this.dropPoolCommons.add(new BasicChestplate());
		this.dropPoolCommons.add(new BasicPants());
	}
	private void setDropPoolRares() {
		//adding Grass Set
		this.dropPoolRares.add(new GrassBlade());
		this.dropPoolRares.add(new GrassChestplate());
		this.dropPoolRares.add(new GrassCrown());
		this.dropPoolRares.add(new GrassBoots());
		this.dropPoolRares.add(new GrassPants());
		//adding Aquatic Set
		this.dropPoolRares.add(new AquaticHelmet());
		this.dropPoolRares.add(new AquaticChestplate());
		this.dropPoolRares.add(new AquaticSword());
		this.dropPoolRares.add(new AquaticPants());
		this.dropPoolRares.add(new AquaticBoots());
		//adding Ember Set
		this.dropPoolRares.add(new EmberPants());
		this.dropPoolRares.add(new EmberHelmet());
		this.dropPoolRares.add(new EmberSword());
		this.dropPoolRares.add(new EmberBoots());
		this.dropPoolRares.add(new EmberChestplate());
	}
	private void setDropPoolLegendaries() {
		//adding Leaf Set
		this.dropPoolLegendaries.add(new LeafDaggers());
		this.dropPoolLegendaries.add(new LeafCrown());
		this.dropPoolLegendaries.add(new LeafChestplate());
		this.dropPoolLegendaries.add(new LeafPants());
		this.dropPoolLegendaries.add(new LeafBoots());
		//adding Ocean Set
		this.dropPoolLegendaries.add(new OceanBlades());
		this.dropPoolLegendaries.add(new OceanCrown());
		this.dropPoolLegendaries.add(new OceanPants());
		this.dropPoolLegendaries.add(new OceanChestplate());
		this.dropPoolLegendaries.add(new OceanBoots());
		//adding Flame Set
		this.dropPoolLegendaries.add(new FlameHelmet());
		this.dropPoolLegendaries.add(new FlameChestplate());
		this.dropPoolLegendaries.add(new FlameBoots());
		this.dropPoolLegendaries.add(new FlamePants());
		this.dropPoolLegendaries.add(new FlameSword());
	}

}
