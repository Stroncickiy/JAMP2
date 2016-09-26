package com.epam.observer;

import java.util.ArrayList;
import java.util.List;

public class Magazine {
	private List<Observer> readers = new ArrayList<>();

	public void subscribe(Observer reader) {
		readers.add(reader);
	}

	public void unsubscrbe(Observer reader) {
		readers.remove(reader);
	}

	public void notifySubscribers(String news) {
		for (Observer observer : readers) {
			observer.update(news);
		}
	}

}
