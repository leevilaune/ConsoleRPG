package demo.domain.items.crimsonset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class CrimsonBow extends Gear{

	public CrimsonBow() {
		super("Weapon","Crimson Bow",100,Rarity.MYTHICAL,Element.NONELEMENTAL,new Stats(200, 0));
	}

}
