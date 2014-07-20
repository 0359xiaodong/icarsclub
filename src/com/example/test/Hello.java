package com.example.test;

public class Hello {
	public native String sayHello();
	
	public static native int sayHi();
	
	static{
		System.loadLibrary("Test");
	}
}
