package com.epam;

import com.epam.observer.Magazine;
import com.epam.observer.Observer;

public class ObserverSample {
	public static void exec(){
		Observer vasya = new Observer("Vasya Pupkin");
		Observer max = new Observer("Max Kontarev");
		Observer slava = new Observer("Slava Strontsitskyy");
		
		Magazine magazine = new  Magazine();
		magazine.subscribe(vasya);
		magazine.subscribe(max);
		magazine.subscribe(slava);
		
		magazine.notifySubscribers(" <EPAM> has joined IT cluster");  // will be read by all 3 subscribers
		magazine.unsubscrbe(max);
		magazine.unsubscrbe(slava);
		
		magazine.notifySubscribers(" <EPAM>  has opened office in India and China"); // will be read only by Vasya
		
		
		
		
	}
}
