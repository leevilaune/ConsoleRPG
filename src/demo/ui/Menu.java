package demo.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import demo.campaign.Campaign;
import demo.combat.CombatTestScene;
import demo.crafting.Crafting;
import demo.domain.ChestInventory;
import demo.domain.DropController;
import demo.domain.Equipment;
import demo.domain.Inventory;
import demo.domain.ItemIndex;
import demo.domain.MaterialInventory;
import demo.domain.Player;
import demo.raid.Raid;
import demo.utility.SaveReader;
import demo.utility.Saver;

public class Menu {
	
	private File invSave;
	private File equipSave;
	private File campSave;
	private File chestSave;
	private File playerSave;
	
	private Scanner r;
	private Campaign camp;
	private ItemIndex index;
	private IndexMenu indMenu;
	private Inventory inv;
	private InventoryMenu invMenu;
	private ChestInventory chestInv;
	private ChestMenu chestMenu;
	private Equipment equip;
	private Player player;
	private CombatTestScene combat;
	private DropController dc;
	private Raid raid;
	private CampaignMenu campMenu;
	private MaterialInventory mInv;
	private Crafting craft;
	private CraftMenu craftMenu;
	private RaidMenu raidMenu;
	private PlayerMenu playerMenu;
	
	private SaveReader saveReader;
	private Saver saver;
	
	public Menu() throws FileNotFoundException {
		
		this.invSave = new File("inventory.csv");
		this.equipSave = new File("equipment.csv");
		this.campSave = new File("campaign.csv");
		this.chestSave = new File("chests.csv");
		this.playerSave = new File("player.csv");
		
		this.r = new Scanner(System.in);
		this.index = new ItemIndex();
		this.equip = new Equipment(index);
		this.indMenu = new IndexMenu(r, index);
		this.inv = new Inventory(index);
		this.chestInv = new ChestInventory(inv, equip);
		this.invMenu = new InventoryMenu(inv, index, equip, r);
		this.chestMenu = new ChestMenu(r, index, inv, chestInv, equip);
		this.player = new Player(this.equip);
		this.mInv = new MaterialInventory();
		this.craft = new Crafting(inv, equip, mInv);
		this.dc = new DropController(player, inv, chestInv, mInv, equip);
		this.camp = new Campaign(player, r, dc);
		this.raid = new Raid(player, r, dc);
		this.campMenu = new CampaignMenu(r, player, dc, camp);
		this.craftMenu = new CraftMenu(r, craft, mInv);
		this.raidMenu = new RaidMenu(raid, r);
		this.playerMenu = new PlayerMenu(player, r);
		
		this.saveReader = new SaveReader(invSave,equipSave,campSave,chestSave,playerSave,
				inv,equip,index,camp,chestInv,player);
		saveReader.readSaves();
	}
	public void start() {
		this.saver = new Saver(invSave,equipSave,campSave,chestSave,playerSave,
				inv,equip,camp,chestInv,player);
		printCommandList();
		while(true) {
			saver.save();
			System.out.print("> ");
			String command = r.nextLine();
			if(command.equals("close")) {
				break;
			}else if(command.equals("list")) {
				printCommandList();
			}else if(command.equals("index")){
				indMenu.start();
			}else if(command.equals("inv")){
				invMenu.start();
			}else if(command.equals("chest")) {
				chestMenu.start();
			}else if(command.equals("combat")) {
				this.combat = new CombatTestScene(player, r,dc);
				combat.start();
			}else if(command.equals("campaign")) {
				campMenu.start();
			}else if(command.equals("craft")) {
				this.craftMenu.start();
			}else if(command.equals("raid")) {
				this.raidMenu.start();
			}else if(command.equals("clr")) {
				clearSaves();
			}else if(command.equals("player")) {
				playerMenu.start();
			}
			else {
				System.out.println("Invalid command");
			}
			
		}
		System.out.println("--Closed--");
	}
	private void clearSaves() {
		System.out.println("Saves cleared please restart your game");
	}
	private void printCommandList() {
		System.out.println("--Main Menu Commands--");
		System.out.println("  close    - closes the game");
		System.out.println("  list 	   - lists all commands");
		System.out.println("  index    - opens index menu");
		System.out.println("  inv	   - opens inventory menu");
		System.out.println("  chest    - opens chest menu");
		System.out.println("  combat   - opens combat menu");
		System.out.println("  campaign - opens campaign menu");
	//	System.out.println("  craft    - opens crafting menu");
	}
	
}
