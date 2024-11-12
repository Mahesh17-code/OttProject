package project;

public class Registration
{
	private String username="amazon";
	private String password="amazon@123";
	private long mobile=9848044635l;

	public void setUserName(String username)
	{
		this.username=username;		
	}
	public void setPassword( String password)
	{	
		this.password=password;		
	}
	public void setter2(long mobile)
	{
		this.mobile=mobile;
	}
	public String getUserName()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public long getMobile()
	{
		return mobile;
	}
	public Registration()
	{
	}
	public Registration(String username, String password, long mobile)
	{
	this.username=username;
	this.password=password;
	this.mobile=mobile;
	}
}