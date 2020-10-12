package demo.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import demo.domain.Equipment;
import demo.domain.Gear;
import demo.domain.Inventory;
import demo.domain.ItemIndex;

public class SaveReader {
	
	private Scanner invReader;
	private FileReader fReader;
	private Scanner equipReader;
	private Inventory inv;
	private ItemIndex ind;
	private ItemIndex realInd;
	private File invSave;
	private File equipSave;
	
	private Equipment equip;
	
	public SaveReader(File invSave,File equipSave, Inventory inv, Equipment e, ItemIndex realInd) throws FileNotFoundException {
		this.inv = inv;
		this.ind = new ItemIndex();
		this.invSave = invSave;
		this.equipSave = equipSave;
		this.fReader = new FileReader(invSave);
		this.equip = e;
		this.realInd = realInd;
	}

	public void readSaves() {
		//System.out.println("saving");
		try {
			this.invReader = new Scanner(this.invSave);
			this.equipReader = new Scanner(this.equipSave);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readInv();
		readEquip();
	}
	private void readEquip() {
		while(equipReader.hasNextLine()) {
		//	System.out.println("reading equip");
			String line = equipReader.nextLine();
		//	System.out.println(line);
			String[] parts = line.split(",",2);
			Gear g = ind.getGear(parts[0]);
			realInd.setFound(g.getName());
			g.upgrade(Integer.parseInt(parts[1])-2);
			if(g.getID().equals("Weapon")) {
				equip.setWeapon(g);
			}else if(g.getID().equals("Helmet")) {
				equip.setHelmet(g);
			}else if(g.getID().equals("Chestplate")) {
				equip.setChestplate(g);
			}else if(g.getID().equals("Pants")) {
				equip.setPants(g);
			}else if(g.getID().equals("Boots")) {
				equip.setBoots(g);
			}
		}
	}
	private void readInv() {
		while (invReader.hasNextLine()) {
		//	System.out.println("reading inv");
			String line = invReader.nextLine();
		//	System.out.println(line);
			String[] parts = line.split(",",2);
			Gear g = ind.getGear(parts[0]);
			realInd.setFound(g.getName());
			g.upgrade(Integer.parseInt(parts[1])-2);
			inv.addItem(g);
		//	System.out.println(g);
	    }
		
		invReader.close();
	}
}
