package demo.domain;

public class ClassBase {
	
	private String className;
	private Move attack;
	private Move block;
	private Move heal;
	private Move ultim;
	
	public ClassBase(String cn,
			Move a,
			Move b,
			Move h,
			Move u) {
		this.className = cn;
		this.attack = a;
		this.block = b;
		this.heal = h;
		this.ultim = u;
	}
	public Move getAttack() {
		return this.attack;
	}
	public Move getBlock() {
		return this.block;
	}
	public Move getHeal() {
		return this.heal;
	}
	public Move getUltimate() {
		return this.ultim;
	}
	@Override
	public String toString() {
		return this.className + 
				"\n  " + this.attack.printDescription();
	}
}
