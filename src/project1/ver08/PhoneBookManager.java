package project1.ver08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	
	Scanner scan = new Scanner(System.in);
	static HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	Iterator<PhoneInfo> itr = set.iterator();
	public PhoneInfo[] myPhoneInfo;
	
	public PhoneBookManager(int num) {
		myPhoneInfo = new PhoneInfo[100];
		loadData();
	}
	
	public static void printMenu()
	{
		System.out.println("====================메뉴를 선택하세요!====================");
		System.out.print("1. 주소록입력 ");
		System.out.print("2. 검색 ");
		System.out.print("3. 삭제 ");
		System.out.print("4. 출력 ");
		System.out.print("5. 저장옵션 ");
		System.out.println("6. 종료 ");
		System.out.println("==========================================================");
		
		System.out.print("메뉴선택: ");		
	}
	
	public void dataInput() throws MenuSelectException
	{
		String name, phoneNumber, major, companyName;
		int grade;
		int choice = 0;
		
		try {
			System.out.println("===========주소록 입력===========");
			System.out.println("1. 일반 2. 동창 3. 직장동료");
			System.out.print("선택>> ");
			choice = scan.nextInt();
			scan.nextLine();
		}
		catch (InputMismatchException e){
			System.out.println("숫자로만 입력해야 합니다.");
			//scan.next();
			return;
		}
		
		if (choice < 1 || choice > 3)
			throw new MenuSelectException(choice);
		
		System.out.print("이름: ");
		name = scan.nextLine();
		System.out.print("전화번호: ");
		phoneNumber = scan.nextLine();
		
		PhoneInfo phoneInfo = null;
		boolean hashCheck = false;
		
		switch (choice) {
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
				System.out.println("새로 입력한 정보가 저장되었습니다.");
			}
			else if (ans.equalsIgnoreCase("N")) {
				System.out.println("아무 데이터도 저장되지 않았습니다.");
			}
			else {
				System.out.println("Y(y)/ N(n)으로만 입력하세요.");
				return;
			}
		}
		else if (hashCheck==true) {
			System.out.println("데이터 입력이 완료되었습니다.");
		}
	}
	
	public int missMenu(int choice) throws MenuSelectException {
		if (choice < 1 || choice > 6)
			throw new MenuSelectException(choice);
		return choice;
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
				System.out.println("\n데이터 검색이 완료되었습니다.");
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
			System.out.println();
		}
		System.out.println("주소록 전체가 출력되었습니다.");
	}
	
	public void saveOption(AutoSaverT as) {
		int choice = 0;
		try {
			System.out.println("==저장옵션선택==");
			System.out.println("저장옵션을 선택하세요.");
			System.out.println("1. 자동저장On 2. 자동저장Off");
			System.out.println("선택: ");
			choice = scan.nextInt();
			
		}
		catch (InputMismatchException e) {
			System.out.println("숫자로 선택해주세요!!");
			return;
		}
		
		
		if (choice==1) {
			if (!as.isAlive()) {
				as.setDaemon(true);
				as.start(); //쓰레드시작
				System.out.println("자동저장을 시작합니다.");
			}
			else {
				System.err.println("이미 자동저장이 실행중입니다.");
			}
		}
		else if (choice==2) {
			if (as.isAlive()) {
				as.interrupt(); //쓰레드중지
				System.out.println("자동저장을 종료합니다.");				
			}
			else {
				System.out.println("자동저장이 실행되고 있지 않습니다.");
			}
		}
		else {
			System.out.println("옵션 선택이 잘못되었습니다.");
		}
	}
	
	public static void loadData() {
		try {
			ObjectInputStream ois
				= new ObjectInputStream
				(new FileInputStream("src/project1/ver08/PhoneBook.obj"));
			
			while (true) {
				PhoneInfo pInfo = (PhoneInfo)ois.readObject();
				set.add(pInfo);
				if (pInfo==null) break;
			}
			ois.close();
		}
		/*
		catch (FileNotFoundException e) {
			System.out.println("파일없음");
		}*/
		catch (EOFException e) {
			e.getMessage();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("데이터 복원 시 오류발생");
			e.printStackTrace();
		}
		
		System.out.println("기존 데이터 조회 완료");
	}
	
	public void saveData() {
		Iterator<PhoneInfo> itr = set.iterator();
		
		try {
			ObjectOutputStream oos
			= new ObjectOutputStream
			(new FileOutputStream("src/project1/ver08/PhoneBook.obj"));
			
			while (itr.hasNext()) {
				PhoneInfo pInfo = itr.next();
				oos.writeObject(pInfo);
			}
		}
		catch (Exception e) {
			System.out.println("직렬화 시 예외발생");
			e.printStackTrace();
		}
	}
	
	public void saveInfoTxt() {
		try
		{
			PrintWriter out = new PrintWriter
					(new FileWriter("src/project1/ver08/PhoneBook.txt"));
			
			for (PhoneInfo pInfo : set) {
				out.println(pInfo.toString());
				//out.write(pInfo.toString());
			}
			out.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
