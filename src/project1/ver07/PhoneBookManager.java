package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	
	Scanner scan = new Scanner(System.in);
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	
	Iterator<PhoneInfo> itr = set.iterator();
	
	public PhoneInfo[] myPhoneInfo;
	//private int numOfPhoneInfo;
	
	public PhoneBookManager (int num) {
		myPhoneInfo = new PhoneInfo[100];
		//numOfPhoneInfo = 0;
	}
	
	public static void printMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택: ");		
	}
	
	public void dataInput()
	{
		String name, phoneNumber, major, companyName;
		int grade;
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1. 일반, 2. 동창, 3. 회사");
		System.out.print("선택>> ");
		int choice2 = scan.nextInt();
		scan.nextLine();
		
		System.out.print("이름: ");
		name = scan.nextLine();
		System.out.print("전화번호: ");
		phoneNumber = scan.nextLine();
		
		PhoneInfo phoneInfo = null;
		boolean hashCheck = false;
		
		switch (choice2) {
		case SubMenuItem.GENERAL:
			//System.out.println("1. 일반: ");
			phoneInfo = new PhoneInfo(name, phoneNumber);
			
			hashCheck = set.add(phoneInfo);
			break;
			
		case SubMenuItem.SCHOOL:
			//System.out.println("2. 동창: ");
			System.out.print("전공: ");
			major = scan.nextLine();
			System.out.print("학년: ");
			grade = scan.nextInt();
			phoneInfo = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			
			hashCheck = set.add(phoneInfo);
			break;
		case SubMenuItem.COMPANY:
			//System.out.println("3. 회사: ");
			System.out.print("회사: ");
			companyName = scan.nextLine();
			phoneInfo = new PhoneCompanyInfo(name, phoneNumber, companyName);
			
			hashCheck = set.add(phoneInfo);
			break;
		}
		if (hashCheck==false) {
			System.out.println(name +"은 이미 저장된 데이터입니다.");
			System.out.println("덮어쓸까요? Y(y)/ N(n)");
			String ans = scan.nextLine();
			
			if (ans.equalsIgnoreCase("Y")) {
				set.remove(phoneInfo);
				set.add(phoneInfo);
				System.out.println("입력한 정보가 저장되었습니다.");
			}
			else if (ans.equalsIgnoreCase("N")) {
				System.out.println("아무 데이터도 저장되지 않았습니다.");
			}
			else {
				System.out.println("Y(y)/ N(n)으로만 입력하세요.");
			}
		}
		else if (hashCheck==true) {
			System.out.println("데이터 입력이 완료되었습니다.");
		}
	}
	
	public void dataSearch() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름: ");
		String searchName = scan.nextLine();
		
		Iterator<PhoneInfo> itr = set.iterator();
		while (itr.hasNext()) {
			PhoneInfo pInfo = itr.next();
			
			if (searchName.equals(pInfo.name)) {
				pInfo.showPhoneInfo();
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
		
		Iterator<PhoneInfo> itr = set.iterator();
		while (itr.hasNext()) {
			PhoneInfo pInfo = itr.next();
			
			if(deleteName.equals(pInfo.name)) {
				itr.remove();
				deleteIndex =1;
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
		Iterator<PhoneInfo> itr = set.iterator();
		
		while (itr.hasNext()) {
			itr.next().showPhoneInfo();
		}
		System.out.println("주소록 전체가 출력되었습니다.");
	}
}
