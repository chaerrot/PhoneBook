package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver03.PhoneBookManager;
import project1.ver03.PhoneInfo;

public class PhoneBookVer03
{
	public static void main(String[] args)
	{
//		PhoneInfo pi1 = new PhoneInfo("유비", "010-1111-1111", "1980-10-10");
//		pi1.showPhoneInfo();
//		
//		PhoneInfo pi2 = new PhoneInfo("손오공", "010-2222-2222");
//		pi2.showPhoneInfo();
		
		Scanner scan = new Scanner(System.in);
		
		PhoneBookManager handler = new PhoneBookManager(100);
		
		while(true) {
			printMenu();
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				//System.out.println("1. 데이터 입력: ");
				handler.dataInput();
				break;
				
			case 2:
				//System.out.println("2. 데이터 검색: ");
				handler.dataSearch();
				break;
			case 3:
				//System.out.println("3. 데이터 삭제: ");
				handler.dataDelete();
				break;
			case 4:
				//System.out.println("4. 주소록 출력: ");
				handler.dataAllShow();
				break;
			case 5:
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

