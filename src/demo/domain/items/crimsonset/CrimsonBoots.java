package demo.domain.items.crimsonset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class CrimsonBoots extends Gear{
	
	public CrimsonBoots() {
		super("Boots","Crimson Boots",100,Rarity.MYTHICAL,Element.NONELEMENTAL,new Stats(150, 50));
	}

}
