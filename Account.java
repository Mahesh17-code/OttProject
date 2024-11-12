package project;

public class Account
{
	double wallet=10000;
	private String sbiPin="1111";
	private String iciciPin="2222";
	public void setSBI_PIN(String sbiPin)
	{
		this.sbiPin=sbiPin;
	}
	public void setICICI_PIN(String iciciPin)
	{
		this.iciciPin=iciciPin;
	}
	public String getSBI_PIN()
	{
		return sbiPin;
	}
	public String getICICI_PIN()
	{
		return iciciPin;
	}
}