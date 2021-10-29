package project1.ver08;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class PhoneInfo implements Serializable
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
		System.out.print("이름: "+ name);
		System.out.print(", "+ "전화번호: "+ phoneNumber);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		PhoneInfo pInfo = (PhoneInfo)obj;
		if (pInfo.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
}
