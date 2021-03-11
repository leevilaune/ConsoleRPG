package demo.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import demo.campaign.Campaign;
import demo.domain.Chest;
import demo.domain.ChestInventory;
import demo.domain.Equipment;
import demo.domain.Gear;
import demo.domain.Inventory;
import demo.domain.Level;
import demo.domain.Player;

public class Saver {
	
	private PrintWriter invSaver;
	private PrintWriter equipSaver;
	private PrintWriter campSaver;
	private PrintWriter chestSaver;
	private PrintWriter playerSaver;
	private Inventory inv;
	private Equipment equip;
	private Campaign camp;
	private ChestInventory chestInv;
	private Player player;
	
	public Saver(File invSave,File equipSave,File campSave,File chestSave,File playerSave,
			Inventory i, Equipment e, Campaign c,ChestInventory ci, Player p) {
		try {
			invSaver = new PrintWriter(invSave);
			equipSaver = new PrintWriter(equipSave);
			campSaver = new PrintWriter(campSave);
			chestSaver = new PrintWriter(chestSave);
			playerSaver = new PrintWriter(playerSave);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.inv = i;
		this.equip = e;
		this.camp = c;
		this.chestInv = ci;
		this.player = p;
	}
	public void save() {
		saveInv();
		saveEquip();
		saveCampaignProgress();
		saveChests();
		savePlayer();
		invSaver.close();
		//System.out.println("closed");
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
	private void saveCampaignProgress() {
		for(Level l: camp.getSave()) {
			campSaver.append(l.getSave());
			campSaver.flush();
		}
		campSaver.close();
	}
	private void saveChests() {
		int count = 1;
		for(Chest c: this.chestInv.getChests()) {
			chestSaver.append(c + "," + count + "\n");
			chestSaver.flush();
		}
		chestSaver.close();
	}
	private void savePlayer() {
		playerSaver.append(player.getName());
		playerSaver.append(",");
		playerSaver.append(String.valueOf(player.getLevelingController().getLevel()));
		playerSaver.append(",");
		playerSaver.append(String.valueOf(player.getLevelingController().getXP()));
		playerSaver.flush();
		playerSaver.close();
	}
	public void clear() {
		invSaver.write("");
		invSaver.flush();
		invSaver.close();
		
	}
}
