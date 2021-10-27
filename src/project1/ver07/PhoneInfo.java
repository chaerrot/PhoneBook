package project1.ver07;

import java.util.Scanner;

public class PhoneInfo
{
	String name; //이름 
	String phoneNumber; //전화번호 
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return phoneNumber.equals(((PhoneInfo)obj).phoneNumber);
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
	
}
