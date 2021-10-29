package project1;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver08.PhoneBookManager;
import project1.ver08.PhoneInfo;
import project1.ver08.MenuSelectException;
import project1.ver08.AutoSaverT;
import project1.ver08.MenuItem;

public class PhoneBookVer08 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		PhoneBookManager handler = new PhoneBookManager(100);
		AutoSaverT as = new AutoSaverT(handler);
		
			while(true) {
				int choice = 0;
				
				try {
					handler.printMenu();
					choice = scan.nextInt();
					handler.missMenu(choice);
				}
				catch (MenuSelectException e) {
					e.showWrongMenu();
				}
				catch (InputMismatchException e) {
					System.out.println("숫자로 선택해주세요.");
					scan.next();
				}
				catch (Exception e) {
					System.out.println("예외발생");
					e.printStackTrace();
				}
				
				switch (choice) {
					case MenuItem.DATA_INPUT:
						//1. 데이터 입력: 
						try {
							//scan.nextLine();
							handler.dataInput();
							break;
						}
						catch (MenuSelectException e) {
							
							e.showWrongMenu();
							break;
						}
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
						if (!as.isAlive()) {
							as = new AutoSaverT(handler);
							handler.saveOption(as);
						}
						else if (as.isAlive()) {
							handler.saveOption(as);
						}
						break;
					case MenuItem.QUIT:
						//6. 프로그램 종료: 
						handler.saveData();
						System.out.println("obj파일로 저장되었습니다.");
						System.out.println("프로그램을 종료합니다.");
						return;
					}
			}////end of while
	}////end of main
}

