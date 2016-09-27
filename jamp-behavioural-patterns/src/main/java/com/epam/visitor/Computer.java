package com.epam.visitor;

public class Computer {

	public void acceptActionPerformer(ActionPerformer visitor) {
		visitor.performAction(this);
	}

	public void useMouse(int oldx, int oldy, int newx, int newy) {
		System.out.println(" mouse movement from x=" + oldx + " y=" + oldy + " to x=" + newx + " y= " + newy);
	}

	public void useKeyboard(int keyCode) {
		System.out.println(" keyboard key " + keyCode + " pressed ");
	}

	public void showOnScreen(String picture) {
		System.out.println(" screen shows " + picture);
	}

}
