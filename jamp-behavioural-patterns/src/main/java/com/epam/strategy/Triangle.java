package com.epam.strategy;

public class Triangle {
	private int katet1;
	private int katet2;
	private int hypotenuza;

	public Triangle(int katet1, int katet2, int hypotenuza) {
		this.katet1 = katet1;
		this.katet2 = katet2;
		this.hypotenuza = hypotenuza;

	}

	public int getKatet1() {
		return katet1;
	}

	public void setKatet1(int katet1) {
		this.katet1 = katet1;
	}

	public int getKatet2() {
		return katet2;
	}

	public void setKatet2(int katet2) {
		this.katet2 = katet2;
	}

	public int getHypotenuza() {
		return hypotenuza;
	}

	public void setHypotenuza(int hypotenuza) {
		this.hypotenuza = hypotenuza;
	}

}
