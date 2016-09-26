package com.epam.mediator;

import java.util.ArrayList;
import java.util.List;

public class ATCMediator {

	private Plane planeOnRunway;
	private List<Plane> landingRequestors = new ArrayList<>();

	public synchronized boolean isRunwayClear() {
		return planeOnRunway == null;
	}

	public void registerLandingRequestor(Plane plane) {
		if (!landingRequestors.contains(plane)) {
			System.out.println("airport registered new landing requestor " + plane);
			landingRequestors.add(plane);
		}
	}

	public synchronized boolean requestLanding(Plane plane) {
		System.out.println("airport recieved landing requested from " + plane);
		if (isRunwayClear()) {
			if (choosePlaneToLand().equals(plane)) {
				System.out.println("airport permitted landing  for " + plane);
				return true;
			}
		} else {
			System.out.println(" runway occupied by " + planeOnRunway);
		}
		return false;
	}

	public synchronized void landOnRunway(Plane plane) {
		System.out.println(" landing of plane " + plane + " started");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println(" landing of plane " + plane + " finished ");
		landingRequestors.remove(plane);
		setRunwayClear();
	}

	private Plane choosePlaneToLand() {
		Plane chosenPlane = null;
		if (landingRequestors.size() > 0) {
			int maxPriority = landingRequestors.get(0).getPriority();
			chosenPlane = landingRequestors.get(0);
			for (Plane plane : landingRequestors) {
				if (plane.getPriority() > maxPriority) {
					maxPriority = plane.getPriority();
					chosenPlane = plane;
				}
			}
		}
		return chosenPlane;
	}

	public synchronized void setRunwayClear() {
		planeOnRunway = null;
	}
}
