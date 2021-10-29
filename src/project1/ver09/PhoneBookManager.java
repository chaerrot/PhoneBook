package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	ArrayList<PhoneInfo> lists;
	
	private Connection con;
	private PreparedStatement ps;
	
	public PhoneBookManager (int num) {
		lists = new ArrayList<PhoneInfo>();
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
		PhoneInfo pInfo = null;
		try {
			DBConnect();
			
			String sql = "INSERT INTO phonebook_tb VALUES "
					+ " (seq_phonebook.nextval, ?, ?, ?) ";
			//왜?
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, pInfo.name);
			ps.setString(2, pInfo.phoneNumber);
			ps.setString(3, pInfo.birthday);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("데이터 입력을 시작합니다..");
			System.out.print("이름: ");
			String name = scan.nextLine();
			System.out.print("전화번호: ");
			String phoneNumber = scan.nextLine();
			System.out.print("생년월일: ");
			String birthday = scan.nextLine();
			
			lists.add(new PhoneInfo(name, phoneNumber, birthday));
			
		}
		catch (SQLException e) {
			System.out.println("DB 연결실패");
		}
		
		
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
	
	public void DBConnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "kosmo";
			String pass = "1234";
			
			Connection con = DriverManager.getConnection(url, id, pass);
			if (con!=null) {
				System.out.println("Oracle 연결성공");
			}
			else {
				System.out.println("Oracle 연결실패");
			}
		}
		catch (Exception e) {
			System.out.println("Oralce 연결시 예외발생");
			e.printStackTrace();
		}
	}
	
}
