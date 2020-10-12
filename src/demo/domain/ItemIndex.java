package demo.domain;

import java.util.*;
import demo.domain.items.starterset.*;
import demo.domain.items.grassset.*;
import demo.domain.items.aquaticset.*;
import demo.domain.items.breezeset.BreezeSword;
import demo.domain.items.campaign.GoblinDagger;
import demo.domain.items.emberset.*;
import demo.domain.items.leafset.*;
import demo.domain.items.oceanset.*;
import demo.domain.items.flameset.*;

public class ItemIndex {
	
	private List<Gear> commons;
	private List<Gear> rares;
	private List<Gear> legendaries;
	
	public ItemIndex() {
		this.commons = new ArrayList<>();
		this.rares = new ArrayList<>();
		this.legendaries = new ArrayList<>();
		this.setCommons();
		this.setRares();
		this.setLegendaries();
	}
	public void setFound(String name) {
		if(getGear(name) == null) {
			System.out.println("Gear not Found");
		}else {
			this.getGear(name).setFound(true);
		}
	}
	private void setCommons() {
		//setting Basic Set
		this.commons.add(new AdventurerSword());
		this.commons.add(new BasicHelmet());
		this.commons.add(new BasicChestplate());
		this.commons.add(new BasicPants());
		this.commons.add(new BasicBoots());
		//adding campaing commons
		this.commons.add(new GoblinDagger());
	}
	private void setRares() {
		//setting Breeze Set
		this.rares.add(new BreezeSword());
		//setting Grass Set
		this.rares.add(new GrassBlade());
		this.rares.add(new GrassCrown());
		this.rares.add(new GrassChestplate());
		this.rares.add(new GrassPants());
		this.rares.add(new GrassBoots());
		//setting Aquatic Set
		this.rares.add(new AquaticSword());
		this.rares.add(new AquaticHelmet());
		this.rares.add(new AquaticChestplate());
		this.rares.add(new AquaticPants());
		this.rares.add(new AquaticBoots());
		//setting Ember Set
		this.rares.add(new EmberSword());
		this.rares.add(new EmberHelmet());
		this.rares.add(new EmberChestplate());
		this.rares.add(new EmberPants());
		this.rares.add(new EmberBoots());
	}
	private void setLegendaries() {
		//setting Leaf Set
		this.legendaries.add(new LeafDaggers());
		this.legendaries.add(new LeafCrown());
		this.legendaries.add(new LeafChestplate());
		this.legendaries.add(new LeafPants());
		this.legendaries.add(new LeafBoots());
		//setting Ocean Set
		this.legendaries.add(new OceanBlades());
		this.legendaries.add(new OceanCrown());
		this.legendaries.add(new OceanChestplate());
		this.legendaries.add(new OceanPants());
		this.legendaries.add(new OceanBoots());
		//setting Flame Set
		this.legendaries.add(new FlameSword());
		this.legendaries.add(new FlameHelmet());
		this.legendaries.add(new FlameChestplate());
		this.legendaries.add(new FlamePants());
		this.legendaries.add(new FlameBoots());
	}
	public void listItems() {
		System.out.println("--Commons------");
		for(Gear g: this.commons) {
			System.out.println("  " + g + ", " + g.isFound());
		}
		System.out.println("\n--Rares--------");
		for(Gear g: this.rares) {
			System.out.println("  " + g + ", " + g.isFound());
		}
		System.out.println("\n--Legendaries--");
		for(Gear g: this.legendaries) {
			System.out.println("  " + g + ", " + g.isFound());
		}
	}
	public void getDetails(String name) {
		Gear g = getGear(name);
		g.printDetails();
	}
	public Gear getGear(String name) {
		for(Gear g: this.commons) {
			if(g.getName().equals(name)) {
				return g;
			}
		}
		for(Gear g: this.rares) {
			if(g.getName().equals(name)) {
				return g;
			}
		}
		for(Gear g: this.legendaries) {
			if(g.getName().equals(name)) {
				return g;
			}
		}
		return null;
	}
}
