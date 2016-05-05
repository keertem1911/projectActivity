package com.technologyActivitybaseFun;

import java.util.Random;

public class InviteNumber {
	private static final int n=6;
	public static String getInviteNumber(){
		StringBuilder stringBuilder=new StringBuilder();
		Random random=new Random();
		for(int i=0;i<n;++i)
			stringBuilder.append(random.nextInt(10));
		
		return stringBuilder.toString();
	}
	public static void main(String[] args) {
		System.out.println(getInviteNumber());
	}
}
