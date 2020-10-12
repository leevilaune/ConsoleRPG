package demo.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import demo.domain.Equipment;
import demo.domain.Gear;
import demo.domain.Inventory;

public class Saver {
	
	private PrintWriter invSaver;
	private PrintWriter equipSaver;
	private Inventory inv;
	private Equipment equip;
	
	public Saver(File invSave,File equipSave, Inventory i, Equipment e) {
		try {
			invSaver = new PrintWriter(invSave);
			equipSaver = new PrintWriter(equipSave);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.inv = i;
		this.equip = e;
	}
	public void save() {
		saveInv();
		saveEquip();
		invSaver.close();
		System.out.println("closed");
	}
	private void saveInv() {
		for(Gear g: this.inv.getInventory()) {
	//		System.out.println("saving");
			invSaver.append(g.getName() + "," + g.getLevel() + "\n");
			invSaver.flush();
		}
		invSaver.close();
	}
	private void saveEquip() {
	//	System.out.println("saving");
		equipSaver.append(equip.getWeapon().getName() + "," + equip.getWeapon().getLevel() + "\n");
	//	System.out.println("saving");
		equipSaver.append(equip.getHelmet().getName() + "," + equip.getHelmet().getLevel() + "\n");
	//	System.out.println("saving");
		equipSaver.append(equip.getChestplate().getName() + "," + equip.getChestplate().getLevel() + "\n");
	//	System.out.println("saving");
		equipSaver.append(equip.getPants().getName() + "," + equip.getPants().getLevel() + "\n");
	//	System.out.println("saving");
		equipSaver.append(equip.getBoots().getName() + "," + equip.getBoots().getLevel() + "\n");
		equipSaver.flush();
		equipSaver.close();
	}
}
