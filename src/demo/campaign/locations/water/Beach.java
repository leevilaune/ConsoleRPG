package demo.campaign.locations.water;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.campaign.levels.beach.*;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Location;
import demo.domain.Player;

public class Beach extends Location {

	private Player p;
	private Scanner r;
	private DropController dc;
	
	public Beach(Scanner r, Player p, DropController dc) {
		super(r, p, "Beach");
		
		this.p = p;
		this.r = r;
		this.dc = dc;
		
		super.setLevels(setLevels());
	}

	public List<Level> setLevels(){
		List<Level> levels = new ArrayList<>();
		levels.add(new Beach1(p, r, dc));
		levels.add(new Beach2(p, r, dc));
		levels.add(new Beach3(p, r, dc));
		levels.add(new Beach4(p, r, dc));
		levels.add(new BeachBoss(p, r, dc));
		
		return levels;
	}
}
