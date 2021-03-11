package demo.domain;

import java.util.*;

import demo.campaign.levels.forest.*;

public class LevelController {
	
	public List<Level> controller;
	
	public LevelController(Player p, Scanner r, DropController dc) {
		this.controller = new ArrayList<>();
		this.setLevels(p, r, dc);
	}
	private void setLevels(Player p, Scanner r, DropController dc) {
		this.controller.add(new Forest1(p,r,dc));
	}
	public Level getLevel(String name) {
		for(Level l: this.controller) {
			if(l.getName().equals(name)) {
				return l;
			}
		}
		return null;
	}
}

