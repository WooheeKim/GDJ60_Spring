package com.woo.s1;

import org.springframework.stereotype.Component;

@Component
public class Gun {
	
	private Bullet bullet;
	
	public Gun() {
		
	}
	
	public Gun(Bullet bullet) {
		this.bullet = bullet;
	}
	
	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}

	public void trigger() {
		this.bullet.sound();
	}
	
}
