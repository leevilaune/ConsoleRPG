package demo.domain;

import java.util.List;

import demo.domain.classes.*;

import java.util.ArrayList;

public class ClassController {
	
	private Player p;
	
	private List<String> classNames;
	
	public ClassController(Player p) {
		this.classNames = new ArrayList<>();
		this.p = p;
	}
	public ClassBase getPlayerClass(String className) {
		if(className.equals("Assassin")) {
			return new Assassin(p);
		}else if(className.equals("Warrior")) {
			return new Warrior(p);
		}
		return null;
	}
}
