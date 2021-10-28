package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo
{
	String companyName; //회사명
	
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName)
	{
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	@Override
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.print(", "+ "회사: "+ companyName);
	}
	
}
