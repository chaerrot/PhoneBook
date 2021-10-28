package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver04.PhoneBookManager;
import project1.ver04.PhoneInfo;

public class PhoneBookVer04
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		project1.ver04.PhoneBookManager handler = new project1.ver04.PhoneBookManager(100);
		
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

