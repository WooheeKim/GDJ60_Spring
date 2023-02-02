package com.woo.s1;

import org.springframework.stereotype.Component;

@Component
public class Soldier {
	
	private Gun gun;
	
	public Soldier() {
		this.gun = new Gun();
	}
	
	public Soldier(Gun gun) {
		this.gun = gun;
	}
	
	public void setGun(Gun gun) {
		this.gun=gun;
	}
	
	public void useGun() {
		this.gun.trigger();
	}
	
}
