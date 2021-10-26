package project1.ver03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	ArrayList<PhoneInfo> lists;
	
	public PhoneBookManager (int num) {
		lists = new ArrayList<PhoneInfo>();
	}
	
	public void dataInput()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 입력을 시작합니다..");
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("전화번호: ");
		String phoneNumber = scan.nextLine();
		System.out.print("생년월일: ");
		String birthday = scan.nextLine();
		
		lists.add(new PhoneInfo(name, phoneNumber, birthday));
		
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	public void dataSearch() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름: ");
		String searchName = scan.nextLine();
		
		Iterator<PhoneInfo> itr = lists.iterator();
		while (itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if (searchName.compareTo(pi.getName())==0) {
				pi.showPhoneInfo();
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
		
		for (PhoneInfo pi : lists) {
			if (deleteName.compareTo(pi.getName())==0) {
				lists.remove(pi);
				deleteIndex = 1;
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
		for (int i=0; i<lists.size(); i++) {
			lists.get(i).showPhoneInfo();
		}
		System.out.println("주소록 전체가 출력되었습니다.");
	}
	
}
