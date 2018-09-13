package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Inventory {
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static double foodHrs, waterHrs;
	public static int initiative;

	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Inventory", 251, 62);
	}
}
