package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02
{
	public static void main(String[] args)
	{
//		PhoneInfo pi1 = new PhoneInfo("유비", "010-1111-1111", "1980-10-10");
//		pi1.showPhoneInfo();
//		
//		PhoneInfo pi2 = new PhoneInfo("손오공", "010-2222-2222");
//		pi2.showPhoneInfo();
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			menuShow();
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				//System.out.println("1. 데이터 입력: ");
				dataInsert();
				break;
			case 2:
				//System.out.println("2. 프로그램 종료: ");
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	public static void dataInsert()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("전화번호: ");
		String phoneNumber = scan.nextLine();
		System.out.print("생년월일: ");
		String birthday = scan.nextLine();
		
		PhoneInfo pi = new PhoneInfo(name, phoneNumber, birthday);
		pi.showPhoneInfo();
	}

	public static void menuShow()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력: ");
		System.out.println("2. 프로그램 종료: ");
		System.out.print("선택: ");		
	}
	
}
