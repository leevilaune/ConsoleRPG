package demo.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import demo.combat.CombatTestScene;
import demo.crafting.Crafting;
import demo.domain.ChestInventory;
import demo.domain.DropController;
import demo.domain.Equipment;
import demo.domain.Inventory;
import demo.domain.ItemIndex;
import demo.domain.MaterialInventory;
import demo.domain.Player;
import demo.utility.SaveReader;
import demo.utility.Saver;

public class Menu {
	
	private File invSave;
	private File equipSave;
	
	private Scanner r;
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
	private CampaignMenu campMenu;
	private MaterialInventory mInv;
	private Crafting craft;
	private CraftMenu craftMenu;
	
	private SaveReader saveReader;
	private Saver saver;
	
	public Menu() throws FileNotFoundException {
		
		this.invSave = new File("inventory.csv");
		this.equipSave = new File("equipment.csv");
		
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
		this.campMenu = new CampaignMenu(r, player, dc);
		this.craftMenu = new CraftMenu(r, craft, mInv);
		
		this.saveReader = new SaveReader(invSave,equipSave,inv,equip,index);
		saveReader.readSaves();
	}
	public void start() {
		printCommandList();
		while(true) {
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
				this.combat = new CombatTestScene(player, r);
				combat.start();
			}else if(command.equals("campaign")) {
				campMenu.start();
			}else if(command.equals("craft")) {
	//			this.craftMenu.start();
			}
			else {
				System.out.println("Invalid command");
			}
		}
		this.saver = new Saver(invSave,equipSave, inv,equip);
		saver.save();
		System.out.println("--Closed--");
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
