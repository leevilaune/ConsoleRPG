package demo.domain;

public class LevelingController {

	private int level;
	private int totalXp;
	private int xp;
	private int xpTillLevel;
	
	public LevelingController(int level,int experience,int totalExperience,int experienceUntilLevel) {
		this.level = level;
		this.totalXp = totalExperience;
		this.xp = experience;
		this.xpTillLevel = experienceUntilLevel;
	}
	public LevelingController() {
		this.level = 1;
		this.xp = 0;
		this.totalXp = 0;
		this.xpTillLevel = getXpForLevel();
	}
	public int getXpForLevel() {
		int xpToLevel = (int) Math.pow(this.level*10, 1.5);
		return xpToLevel;
	}
	public int getXpForLevel(int lvl) {
		int xpToLevel = (int) Math.pow(lvl*10, 1.5);
		return xpToLevel;
	}
	public void levelUp() {
		this.level++;
		this.xp = 0;
	}
	public void tryLevelUp() {
		int saveXP = 0;
		int xpForLevel = getXpForLevel(this.level);
		if(this.xp >= xpForLevel) {
			if(this.xp > xpForLevel) {
				saveXP = xp-xpForLevel; 
			}
			levelUp();
			addXP(saveXP);
		}
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return this.level;
	}
	public void setXP(int experience){
		this.xp = experience;
	}
	public int getXP() {
		return this.xp;
	}
	public void addXP(int addingXp) {
		this.xp += addingXp;
		tryLevelUp();
	}
	public String toString() {
		return this.level + 
				"  \n" + this.xp + "/" + getXpForLevel();
	}
}

