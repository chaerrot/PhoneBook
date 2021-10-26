package project1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver05.PhoneBookManager;
import project1.ver05.PhoneInfo;
import project1.ver05.MenuItem;

public class PhoneBookVer05
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		project1.ver05.PhoneBookManager handler = new project1.ver05.PhoneBookManager(100);
		
		while(true) {
			printMenu();
			
			int choice = scan.nextInt();
			switch (choice) {
			case MenuItem.DATA_INPUT:
				//System.out.println("1. 데이터 입력: ");
				handler.dataInput();
				break;
				
			case MenuItem.DATA_SEARCH:
				//System.out.println("2. 데이터 검색: ");
				handler.dataSearch();
				break;
			case MenuItem.DATA_DELETE:
				//System.out.println("3. 데이터 삭제: ");
				handler.dataDelete();
				break;
			case MenuItem.DATA_ALLSHOW:
				//System.out.println("4. 주소록 출력: ");
				handler.dataAllShow();
				break;
			case MenuItem.QUIT:
				//System.out.println("5. 프로그램 종료: ");
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
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
}

