package demo.raid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.domain.DropController;
import demo.domain.Player;
import demo.raid.levels.GoblinQueenRaid;
import demo.raid.levels.RaidLevel;

public class Raid {
	
	private List<RaidLevel> raids;
	
	private Player p;
	private Scanner r;
	private DropController dc;
	
	public Raid(Player p, Scanner r, DropController dc) {
		this.raids = new ArrayList<>();
		this.p = p;
		this.r = r;
		this.dc = dc;
		setRaids();
	}
	public void start(String name) {
		for(RaidLevel rl: this.raids) {
			if(rl.getName().equals(name)) {
				rl.start();
			}
		}
	}
	public void listRaids() {
		for(RaidLevel rl: this.raids) {
			System.out.println(rl);
		}
	}
	private void setRaids() {
		this.raids.add(new GoblinQueenRaid(p,r,dc));
	}
}
