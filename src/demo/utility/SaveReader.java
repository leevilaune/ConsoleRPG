package demo.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import demo.campaign.Campaign;
import demo.domain.ChestInventory;
import demo.domain.Equipment;
import demo.domain.Gear;
import demo.domain.Inventory;
import demo.domain.ItemIndex;
import demo.domain.Level;
import demo.domain.Player;
import demo.domain.chests.*;

public class SaveReader {
	
	private Scanner invReader;
	private Scanner equipReader;
	private Scanner campReader;
	private Scanner chestReader;
	private Scanner playerReader;
	private Inventory inv;
	private ItemIndex ind;
	private ItemIndex realInd;
	private Campaign camp;
	private ChestInventory chestInv;
	private Player player;
	private File invSave;
	private File equipSave;
	private File campSave;
	private File chestSave;
	private File playerSave;
	
	private Equipment equip;
	
	public SaveReader(File invSave,File equipSave,File campSave,File chestSave,File playerSave,
			Inventory inv, Equipment e, ItemIndex realInd, Campaign c, ChestInventory ci, Player p) throws FileNotFoundException {
		this.invSave = invSave;
		this.equipSave = equipSave;
		this.campSave = campSave;
		this.chestSave = chestSave;
		this.playerSave = playerSave;
		this.inv = inv;
		this.ind = new ItemIndex();
		this.equip = e;
		this.realInd = realInd;
		this.camp = c;
		this.chestInv = ci;
		this.player = p;
	}

	public void readSaves() {
		//System.out.println("saving");
		try {
			this.invReader = new Scanner(invSave);
			this.equipReader = new Scanner(equipSave);
			this.campReader = new Scanner(campSave);
			this.chestReader = new Scanner(chestSave);
			this.playerReader = new Scanner(playerSave);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readInv();
		readEquip();
		readCampaingProgress();
		readChests();
		readPlayer();
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
		equipReader.close();
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
	private void readCampaingProgress() {
		while(campReader.hasNextLine()) {
			String line = campReader.nextLine();
			String[] parts = line.split(",",3);
			//System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
			for(Level l: camp.getSave()) {
				if(l.getName().equals(parts[0])) {
					l.setLocked(Boolean.valueOf(parts[1]));
					l.setCompleted(Boolean.valueOf(parts[2]));
				}
			}
		}
		campReader.close();
	}
	private void readChests() {
		while(chestReader.hasNextLine()) {
			String line = chestReader.nextLine();
			String[] parts = line.split(",",2);
			if(parts[0].equals("Fire Chest")) {
				for(int i = 0; i < Integer.parseInt(parts[1]); i++) {
					chestInv.add(new FireChest());
				}
			}else if(parts[0].equals("Earth Chest")) {
				for(int i = 0; i < Integer.parseInt(parts[1]); i++) {
					chestInv.add(new EarthChest());
				}
			}else if(parts[0].equals("Basic Chest")) {
				for(int i = 0; i < Integer.parseInt(parts[1]); i++) {
					chestInv.add(new BasicChest());
				}
			}
		}
		chestReader.close();
	}
	private void readPlayer() {
		while(playerReader.hasNextLine()) {
			String line = playerReader.nextLine();
			System.out.println(line);
			String[] parts = line.split(",",3);
			player.setName(parts[0]);
			player.getLevelingController().setLevel(Integer.parseInt(parts[1]));
			player.getLevelingController().setXP(Integer.parseInt(parts[2]));
			
		}
	}
}
