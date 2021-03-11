package demo.domain.items.crimsonset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class CrimsonPants extends Gear {

	public CrimsonPants() {
		super("Pants","Crimson Pants",100,Rarity.MYTHICAL,Element.NONELEMENTAL,new Stats(160, 40));
	}

}
