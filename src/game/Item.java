package game;

public class Item {
	int amount;
	String name;

	public void add() {
		amount++;
	}

	public void remove() {
		amount--;
	}

	public void add(int a) {
		amount += a;
	}

	public void remove(int a) {
		amount -= a;
	}

	public void use() {
	}
}
