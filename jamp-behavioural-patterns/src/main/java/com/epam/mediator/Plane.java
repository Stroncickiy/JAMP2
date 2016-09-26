package com.epam.mediator;

import java.util.Random;

public class Plane implements Runnable {
	private int priority;
	private String name;
	private ATCMediator airport;
	private boolean isLanded = false;

	public Plane(int priority, String name, ATCMediator airport) {
		super();
		this.priority = priority;
		this.name = name;
		this.airport = airport;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priority;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority != other.priority)
			return false;
		return true;
	}

	@Override
	public void run() {
		airport.registerLandingRequestor(this);
		try {
			Thread.currentThread().sleep(200);
		} catch (InterruptedException e1) {
		}
		while (!isLanded()) {
			boolean landingRequestAccepted = airport.requestLanding(this);
			if (landingRequestAccepted) {
				airport.landOnRunway(this);
				setLanded(true);
			} else {
				System.out.println(" airport declined landing request.. waiting 2-3 seconds ");
				try {
					Thread.currentThread().sleep(2000 + new Random().nextInt(1000));
				} catch (InterruptedException e) {
				}
			}

		}

	}

	public boolean isLanded() {
		return isLanded;
	}

	public void setLanded(boolean isLanded) {
		this.isLanded = isLanded;
	}

	@Override
	public String toString() {
		return name + "[" + priority + "]";
	}

}
