package demo.domain;

public interface Character {
	
	void attack(Character c);
	void heal();
	void setHP(int hp);
	int getHP();
}
