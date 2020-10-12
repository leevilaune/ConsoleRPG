package demo.campaign.locations.earth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.campaign.levels.forest.*;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Location;
import demo.domain.Player;

public class Forest extends Location{

	private Player p;
	private Scanner r;
	private DropController dc;
	
	public Forest(Scanner r, Player p, DropController dc) {
		super(r, p, "Forest");
		
		this.p = p;
		this.r = r;
		this.dc = dc;
		
		super.setLevels(setLevels());
		super.setLocked(false);
	}

	public List<Level> setLevels(){
		List<Level> levels = new ArrayList<>();
		levels.add(new Forest1(p, r, dc));
		levels.add(new Forest2(p, r, dc));
		levels.add(new Forest3(p, r, dc));
		levels.add(new Forest4(p, r, dc));
		levels.add(new ForestBoss(p, r, dc));
		
		return levels;
	}
}
