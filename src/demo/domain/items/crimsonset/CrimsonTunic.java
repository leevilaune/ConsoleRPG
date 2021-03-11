package demo.domain.items.crimsonset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class CrimsonTunic extends Gear{

	public CrimsonTunic() {
		super("Chestplate","Crimson Tunic",100,Rarity.MYTHICAL,Element.NONELEMENTAL,new Stats(170, 30));
	}

}
