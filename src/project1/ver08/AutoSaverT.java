package project1.ver08;

import java.io.FileWriter;
import java.io.PrintWriter;

public class AutoSaverT extends Thread 
{
	PhoneBookManager pm;

	public AutoSaverT(PhoneBookManager pm)
	{
		this.pm = pm;
	}
	
	@Override
	public void run()
	{
		try {
			while (true) {
				pm.saveInfoTxt();
				sleep(5000);
				System.out.println("주소록이 텍스트로 자동저장되었습니다.");
			}
		}
		catch (InterruptedException e) {
			System.out.println("자동저장 시 오류발생");
			e.printStackTrace();
		}
		catch (Exception e) {}
	}
}
