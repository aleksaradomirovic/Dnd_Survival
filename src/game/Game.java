package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel {
	JFrame frame = new JFrame();
	Timer framerate = new Timer(1000 / 30, new ProcessUpdate());
	boolean inventoryActive = false;
	String playername;
	Inventory playerInv = new Inventory();

	void setup() {
		frame.add(this);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.addKeyListener(new KeyBoard());

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		start();
	}

	void start() {
		playername = JOptionPane.showInputDialog("Player name: ");
		if (playername != null) {
			framerate.start();
			frame.setVisible(true);
		} else {
			frame.dispose();
			frame = null;
		}
	}

	public static void main(String[] args) {
		new Game().setup();
	}

	@Override
	public void paintComponent(Graphics g) {
		drawGame(g);
	}

	void drawGame(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 600);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 200, 600);

		if (inventoryActive) {
			g.fillRect(250, 50, 500, 500);
			playerInv.draw(g);
		}

		g.setColor(Color.BLACK);
		g.drawString(playername, 1, 12);
	}

	class ProcessUpdate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	class KeyBoard implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_I) {
				System.out.println("Inventory");
				if (inventoryActive) {
					inventoryActive = false;
				} else {
					inventoryActive = true;
				}
			}
			System.out.println("press");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
