package project1.ver06;


import java.util.Scanner;

import project1.ver06.PhoneBookManager;

public class PhoneBookManager {
	
	public PhoneInfo[] myPhoneInfo;
	private int numOfPhoneInfo;
	
	String name, phoneNumber, major, grade, companyName;
	Scanner scan = new Scanner(System.in);
	
	public PhoneBookManager (int num) {
		myPhoneInfo = new PhoneInfo[100];
		numOfPhoneInfo = 0;
	}
	
	
	public void dataInput()
	{
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1. 일반, 2. 동창, 3. 회사");
		System.out.print("선택>> ");
		int choice2 = scan.nextInt();
		
		switch (choice2) {
		case SubMenuItem.GENERAL:
			//System.out.println("1. 일반: ");
			dataInputGeneral();
			break;
			
		case SubMenuItem.SCHOOL:
			//System.out.println("2. 동창: ");
			dataInputSchool();
			break;
		case SubMenuItem.COMPANY:
			//System.out.println("3. 회사: ");
			dataInputCompany();
			break;
		}
	}
		
	public void dataInputGeneral() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("전화번호: ");
		String phoneNumber = scan.nextLine();
		myPhoneInfo[numOfPhoneInfo++] = new PhoneInfo(name, phoneNumber);
		
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	public void dataInputSchool() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("전화번호: ");
		String phoneNumber = scan.nextLine();
		System.out.print("전공: ");
		String major = scan.nextLine();
		System.out.print("학년: ");
		int grade = scan.nextInt();
		
		myPhoneInfo[numOfPhoneInfo++] = new PhoneSchoolInfo(name, phoneNumber, major, grade);
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	public void dataInputCompany() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("전화번호: ");
		String phoneNumber = scan.nextLine();
		System.out.print("회사: ");
		String companyName = scan.nextLine();
		
		myPhoneInfo[numOfPhoneInfo++] = new PhoneCompanyInfo(name, phoneNumber, companyName);
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	public void dataSearch() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름: ");
		String searchName = scan.nextLine();
		
		for (int i=0; i<numOfPhoneInfo; i++) {
			if (searchName.compareTo(myPhoneInfo[i].name)==0) {
				myPhoneInfo[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				isFind = true; 
			}
		}
		if (isFind == false) {
			System.out.println("찾는 정보가 없습니다.");
		}
	}
	
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름: ");
		String deleteName = scan.nextLine();
		int deleteIndex = -1;
		
		for (int i=0; i<numOfPhoneInfo; i++) {
			if (deleteName.compareTo(myPhoneInfo[i].name)==0) {
				for (int j=i; j<numOfPhoneInfo-1; j++) {
					myPhoneInfo[j] = myPhoneInfo[j+1];
				}
				deleteIndex = i;
				numOfPhoneInfo--;
				break;
			}
		}
		if (deleteIndex== -1) {
			System.out.println("삭제된 데이터가 없습니다.");
		}
		else {
			System.out.println("데이터가 삭제되었습니다.");
		}
	}
	
	public void dataAllShow() { 
		for (int i=0; i<numOfPhoneInfo; i++) {
			myPhoneInfo[i].showPhoneInfo();
		}
		System.out.println("주소록 전체가 출력되었습니다.");
	}
}
