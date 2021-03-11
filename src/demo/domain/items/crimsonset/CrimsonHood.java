package demo.domain.items.crimsonset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class CrimsonHood extends Gear{

	public CrimsonHood() {
		super("Helmet","Crimson Hood",100,Rarity.MYTHICAL,Element.NONELEMENTAL,new Stats(150, 50));
	}

}
