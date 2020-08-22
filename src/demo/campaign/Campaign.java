package demo.campaign;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.campaign.levels.TutorialLevel;
import demo.campaign.levels.forest.*;
import demo.domain.DropController;
import demo.domain.Level;
import demo.domain.Player;

public class Campaign {
	
	private List<Level> levels;
	private Player p;
	private Scanner r;
	private DropController dc;
	
	public Campaign(Player p, Scanner r, DropController dc) {
		this.levels = new ArrayList<>();
		this.p = p;
		this.r = r;
		this.dc = dc;
		setLevels();
	}
	public void start(String level) {
		for(Level l: this.levels) {
			if(l.getName().equals(level)) {
				if(!l.isLocked()) {
					l.start();
					cycleLevels();
				}else {
					System.out.println("Level is Locked");
				}
			}
		}
	}
	private void cycleLevels() {
		for(Level l: this.levels) {
			l.setLocked(false);
			if(l.isCompleted()) {
				continue;
			}else {
				break;
			}
		}
	}
	private void setLevels() {
		this.levels.add(new Forest1(p, r, dc));
		this.levels.add(new Forest2(p, r, dc));
		this.levels.add(new Forest3(p, r, dc));
		this.levels.add(new Forest4(p, r, dc));
		this.levels.add(new ForestBoss(p, r, dc));
	}
	public void listLevels() {
		for(Level l: this.levels) {
			System.out.println(l);
		}
	}
	
}
