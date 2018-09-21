package com.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestMD5 {

	public static void main(String[] args) {
		
		try {
			
			String password = "123456";
			//1. 获取加密对象
			MessageDigest md = MessageDigest.getInstance("md5");
			//2. 对字符串进行加密
			byte[] result = md.digest(password.getBytes());
			
			System.out.println("密码有多少位:"+result.length+"\n");
			
			for (byte by : result) {
				String hexString = Integer.toHexString(by&0xFF);
				//System.out.print(hexString+" ");
				if(hexString.length()==1){
					hexString = "0"+hexString;
				}
				System.out.print(hexString+" ");
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
