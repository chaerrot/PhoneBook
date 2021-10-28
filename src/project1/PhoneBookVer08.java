package project1;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver08.PhoneBookManager;
import project1.ver08.PhoneInfo;
import project1.ver08.MenuSelectException;
import project1.ver08.AutoSaver;
import project1.ver08.MenuItem;

public class PhoneBookVer08 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		project1.ver08.PhoneBookManager handler = new project1.ver08.PhoneBookManager(100);
		AutoSaver as = new AutoSaver(handler);
		
			while(true) {
				try {
				handler.printMenu();
				
				int choice = scan.nextInt();
				
				if (choice < 1 || choice > 6)
					throw new MenuSelectException(choice);
				
				switch (choice) {
					case MenuItem.DATA_INPUT:
						scan.nextLine();
						//1. 데이터 입력: 
						handler.dataInput();
						break;
						
					case MenuItem.DATA_SEARCH:
						//2. 데이터 검색: 
						handler.dataSearch();
						break;
					case MenuItem.DATA_DELETE:
						//3. 데이터 삭제: 
						handler.dataDelete();
						break;
					case MenuItem.DATA_ALLSHOW:
						//4. 주소록 출력: 
						handler.dataAllShow();
						break;
					case MenuItem.DATA_SAVE:
					//5. 저장 옵션: 
						handler.saveOption(as);
						break;
					case MenuItem.QUIT:
						//6. 프로그램 종료: 
						handler.quitProgram();
						System.out.println("obj파일로 저장되었습니다.");
						System.out.println("프로그램을 종료합니다.");
						return;
					}
				}////end of try
				catch (MenuSelectException e) {
					e.getMessage();
					e.showWrongMenu();
				}
				/*catch (InputMismatchException e) {
					e.getMessage();
					System.out.println("숫자로만 입력해야 합니다.");
				}*/
			}////end of while
	}////end of main
}

