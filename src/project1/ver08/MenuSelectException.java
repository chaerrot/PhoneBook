package project1.ver08;

public class MenuSelectException extends Exception
{
	private int choice;
	public MenuSelectException(int choice)
	{
		this.choice = choice;
	}
	public void showWrongMenu() {
		System.out.println(choice +"번 선택지는 없습니다.");
		System.out.println("다시 선택해주세요.");
	}
	
	
}
