package game;

public class Food extends Item {
	int food, water;

	@Override
	public void use() {
		Inventory.foodHrs += food;
		Inventory.waterHrs += water;
	}
}
