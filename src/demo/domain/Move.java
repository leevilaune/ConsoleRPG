package demo.domain;

public interface Move {
	
	void printDescription();
	int getAttack();
	void setAttack();
	int getHeal();
	void setHeal();
	void execute(Character c);
	String getType();
	
}

