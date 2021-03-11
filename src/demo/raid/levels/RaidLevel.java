package demo.raid.levels;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.domain.Bot;
import demo.domain.Level;
import demo.domain.Player;

public class RaidLevel extends Level{

	public RaidLevel(Player p, Scanner r,List<Bot> boss, String name) {
		super(p, r, boss, name);
		super.setLocked(false);
	}
}
