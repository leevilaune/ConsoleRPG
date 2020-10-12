package demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storyline {
	
	private boolean isLocked;
	private boolean isCompleted;
	private String name;
	
	private Player p;
	private Scanner r;
	
	private List<Location> locations;
	
	public Storyline(Player p, Scanner r) {
		
		this.p = p;
		this.r = r;
		
		this.isLocked = true;
		this.isCompleted = false;
		
		this.locations = new ArrayList<>();
		
	}
	public void start() {
		printCommands();
		while(true) {
			cycleLocations();
			System.out.print("> ");
			String command = r.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.contains("start")) {
				startLocation(command);
			}else if(command.equals("list locations")) {
				listLocations();
			}
		}
		System.out.println("--Storyline Closed--");
	}
	
	public void printCommands() {
		System.out.println("--Storyline Commands--");
		System.out.println("  close            - closes storyline");
		System.out.println("  list             - lists commands");
		System.out.println("  list locations   - lists locations");
		System.out.println("  start [location] - open location");
	}
	
	public void startLocation(String c) {
		String[] parts = c.split(" ", 2);
		if(parts.length == 2) {
			for(Location l: this.locations) {
				if(l.getName().equals(parts[1])) {
					if(!l.isLocked()) {
						l.start();
					}else {
						System.out.println("Location is Locked");
					}
				}
			}
		}
	}
	public void cycleLocations() {
		for(Location l: this.locations) {
			l.setLocked(false);
			if(l.isCompleted()) {
				continue;
			}else {
				break;
			}
		}
		if(this.locations.get(this.locations.size()-1).isCompleted()) {
			this.isCompleted = true;
		}
	}
	public void listLocations() {
		for(Location l: this.locations) {
			System.out.println(l);
		}
	}
	
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	public List<Location> getLocations(){
		return this.locations;
	}
	public void setLocked(boolean b) {
		this.isLocked = b;
	}
	public boolean isLocked() {
		return this.isLocked;
	}
	public void setCompleted(boolean b) {
		this.isCompleted = b;
	}
	public boolean isCompleted() {
		return this.isCompleted;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name + "\n  Locked:    " + this.isLocked + "\n  Completed: " + this.isCompleted;
	}

}
