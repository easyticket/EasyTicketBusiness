package com.dise.tickets.auth.filter;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class JWTKey {
	
	private static KeyPairGenerator kpg;
	private static KeyPair kp;
	
	public JWTKey (){
		
		try {
			kpg = KeyPairGenerator.getInstance("RSA");
			kp = kpg.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static KeyPairGenerator getKpg() {
		return kpg;
	}

	public static void setKpg(KeyPairGenerator kpg) {
		JWTKey.kpg = kpg;
	}

	public static KeyPair getKp() {
		return kp;
	}

	public static void setKp(KeyPair kp) {
		JWTKey.kp = kp;
	}
	
	

}
