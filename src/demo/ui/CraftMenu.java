package demo.ui;

import java.util.Scanner;

import demo.crafting.Crafting;
import demo.domain.MaterialInventory;

public class CraftMenu {
	
	private Scanner r;
	private Crafting craft;
	private MaterialInventory mInv;
	
	public CraftMenu(Scanner r, Crafting c, MaterialInventory mInv) {
		this.r = r;
		this.craft = c;
		this.mInv = mInv;
	}
	
	public void start() {
		printCommands();
		while(true) {
			System.out.print("> ");
			String command = r.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.equals("list craftables")) {
				craft.listCraftables();
			}else if(command.equals("list materials")) {
				mInv.listMaterials();
			}
			else if(command.contains("craft")) {
				craft(command);
			}
		}
	}
	private void printCommands() {
		System.out.println("--Crafting Commands--");
		System.out.println("  close           - closes craft menu");
		System.out.println("  list craftables - lists craftable items");
		System.out.println("  list materials  - lists your materials");
		System.out.println("  craft [item]    - crafts items");
	}
	public void craft(String command) {
		String[] parts = command.split(" ", 2);
		craft.craft(parts[1]);
	}
}
