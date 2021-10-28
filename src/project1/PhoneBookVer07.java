package project1;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver07.PhoneBookManager;
import project1.ver07.PhoneInfo;
import project1.ver07.MenuSelectException;
import project1.ver07.MenuItem;

public class PhoneBookVer07 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		project1.ver07.PhoneBookManager handler = new project1.ver07.PhoneBookManager(100);
		
			while(true) {
				try {
				handler.printMenu();
				
				int choice = scan.nextInt();
				
				if (choice < 1 || choice > 5)
					throw new MenuSelectException(choice);
				
				//scan.nextLine();
				
				switch (choice) {
					case MenuItem.DATA_INPUT:
						scan.nextLine();
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
				}////end of try
				catch (MenuSelectException e) {
					e.getMessage();
					e.showWrongMenu();
				}
				catch (InputMismatchException e) {
					e.getMessage();
					System.out.println("숫자로만 입력해야 합니다.");
				}
			}////end of while
	}////end of main
}

