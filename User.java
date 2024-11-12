package project;

import java.util.Scanner;
import java.sql.*;
public class User
{
	static Scanner sc=new Scanner(System.in);
	static Registration obj=new Registration();
	static Account obj1=new Account();
	static String dbUser="",dbPass="";
	static int dbId=0;
	public void signup()throws SQLException
	{
			System.out.println(Colors.blue+Colors.bold+Colors.blink+Colors.backpurple+"");
		    System.out.println("\t\t _       _         _                                       _____            ___                                  				");
	        System.out.println("\t\t( )  _  ( )       (_ )                                    (_   _)          (  _`\\  _                             				");
	        System.out.println("\t\t| | ( ) | |   __   | |    ___    _     ___ ___     __       | |     _      | (_(_)(_)   __    ___   _   _  _ _   				");
	        System.out.println("\t\t| | | | | | /'__`\\ | |  /'___) /'_`\\ /' _ ` _ `\\ /'__`\\     | |   /'_`\\    `\\__ \\ | | /'_ `\\/` _ `\\( ) ( )( '_`\\ 				");
	        System.out.println("\t\t| (_/ \\_) |(  ___/ | | ( (___ ( (_) )| ( ) ( ) |(  ___/     | |  ( (_) )   ( )_) || |( (_) || ( ) || (_) || (_) )				");
	        System.out.println("\t\t`\\___x___/'`\\____)(___)`\\____)`\\___/'(_) (_) (_)`\\____)     (_)  `\\___/'   `\\____)(_)`\\__  |(_) (_)`\\___/'| ,__/ 				");
	        System.out.println("\t\t                                                                                     ( )_) |              | |    				");
	        System.out.println("\t\t                                                                                      \\___/'              (_)     				"+Colors.reset);
	  
		long number;String password;
		System.out.println(Colors.blue+Colors.bold+"\t\tPlease Enter your credentials...");
		System.out.print(Colors.cyan+"Enter Your UserName: ");
		String name=sc.nextLine();
		
					while(true)
					{
						System.out.print(Colors.cyan+Colors.bold+"Enter your password: ");
						password = sc.nextLine();
         				if(isValid(password))
	 					{
            				System.out.println(Colors.green+"The password is strong."+Colors.reset);
							break;
         				}
	 					else 
         				{
            				System.out.println(Colors.yellow+Colors.blink+"The password is weak. Please ensure it meets the following criteria:");
            				System.out.println("- At least 8 characters long");
            				System.out.println("- Contains at least one uppercase letter");
            				System.out.println("- Contains at least one lowercase letter");
            				System.out.println("- Contains at least one digit");
            				System.out.println("- Contains at least one special character (e.g., !@#$%^&*()_+{}[]|;:',.<>?/)"+Colors.reset);
         				}
					}
            		while (true)
	    			{
                		System.out.print(Colors.cyan+Colors.bold+"Re-enter the password: ");
                		String passwordConfirm = sc.nextLine();
                		if(password.equals(passwordConfirm))
						{
                    		System.out.println(Colors.green+Colors.bold+"Password confirmed."+Colors.reset);
                    		break;
                		} 
						else 
						{
                    		System.out.println(Colors.red+Colors.bold+"Password does not match. Please recheck it and enter again."+Colors.reset);
                		}
            		}
            		
            		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
            		String selNo="select User_Name,Password from users where User_Name=? and Password=?;";
            		PreparedStatement psNo1 =con1.prepareStatement(selNo);
            		psNo1.setString(1,name);
            		psNo1.setString(2,password);                    		
            		ResultSet rsNo1=psNo1.executeQuery();
            		while(rsNo1.next())
            		{
            			dbUser=rsNo1.getString("User_Name");
            			dbPass=rsNo1.getString("password");            				
            		}
        if(dbUser.equals(name)&&dbPass.equals(password))
        {
        	Colors.loading();
        	System.out.println(Colors.red+Colors.bold+"\t\tAccount  Alredy Exists!!\n So Please try with New UserName and Password or Login to your Account."+Colors.reset);
        	while(true)
    		{
    			try
    			{
	    			System.out.println(Colors.cyan+Colors.bold+"\n\t1.Home\t\t2.Login\t\t3.Exit");
	    			System.out.print("\tEnter your Choice:");
	    			String ch1=Colors.sc.nextLine();
	    			if(ch1.equals("1"))
	    			{
	    				main(null);
	    				break;
	    			}
	    			else if(ch1.equals("2"))
	    			{
	    				login();
	    				break;
	    			}
	    			else if(ch1.equals("3"))
	    			{
	    				Colors.exit();
	    				break;
	    			}
	    			else
	    			{
	    				System.out.println(Colors.red+Colors.bold+"Invalid Input Please Try Again!!.."+Colors.reset);
	    			}
    			}
    			catch(NumberFormatException e) {
    				System.out.println(Colors.red+Colors.bold+"\tYou have entered Invalid Input!!"+Colors.reset);
    			}
    		}
        	
        }
        else
        {
		while(true)
		{
		try
		{
		 System.out.print(Colors.cyan+Colors.bold+"Enter mobile number: ");
		 number=Long.parseLong(sc.nextLine());
		String num=number+"";
		if(num.length()==10)
		{
			if(num.charAt(0)>='6' && num.charAt(0)<='9')
			{
				//System.out.println("Your number is vaild");
				Colors.loading();
			    System.out.println(Colors.blue+Colors.bold+"\nOTP is sent to your Mobile Number..");
				int count=0,n=10;
				int OTP=1000+(int)(Math.random()*8999);
				while(true)
				{
					try
					{
					System.out.print(Colors.blue+Colors.bold+"\nYour OTP is   :--> "+OTP);
					System.out.print("\nEnter your OTP:--> ");
					int otp=Integer.parseInt(sc.nextLine());
					if(OTP==otp)
					{
						Colors.loading();
						System.out.println(Colors.green+Colors.bold+"\nYour Mobile Number Verified Successfully.. "+Colors.reset);
						
//						System.out.println("Successfully Created Your Account!!");
						break;
					}
					else
					{
						System.out.println(Colors.red+Colors.bold+"Please enter the OTP correctly!!"+Colors.reset);
						count++;
						if(count==3)
						{
							System.out.println(Colors.red+Colors.blink+Colors.bold+"Your chances are expired please try after some time"+Colors.reset);
							for(int i=1;i<=n;i++)
							{
								System.out.print(".");
								try
								{
									Thread.sleep(1000);
								}
								catch(Exception e){}
							}
							break;

						}
					}
					}
					catch(NumberFormatException e) {
						System.out.println(Colors.red+Colors.bold+"\tYou have entered Invalid Input!!"+Colors.reset);
					}
				}
				break;			
			}
			else
			System.out.println(Colors.bold+Colors.red+Colors.blink+"\nInvalid Mobile Number because Mobile Number Starting digit should be 6 or 7 or 8 or 9.\n\t\tPlease enter a valid mobile number :"+Colors.reset);
		}
		else
		System.out.println(Colors.bold+Colors.red+Colors.blink+"\nInvalid Mobile Number Because It doen't contain 10 Digits\n\tPlease enter valid Mobile Number!"+Colors.reset);
		}
		catch(NumberFormatException e) {
			System.out.println(Colors.red+Colors.bold+"\tYou have entered Invalid Charecters in Mobile Number!!"+Colors.reset);
		}
		}
		while(true)
		{
			try
			{
				System.out.println(Colors.cyan+Colors.bold+"Link your Bank For Payments...\n");
				System.out.println("\t\t\t\t-----<@>.Select Your Bank.<@>-----");
				System.out.println("\t\t\t\t\t1.SBI\t\t2.ICICI");
				System.out.print("\t\t\t\t----->");
				int BankSel=Integer.parseInt(sc.nextLine());
				if(BankSel==1)
				{
					boolean b=true;String verifyPin="";
							while(b)
							{
								System.out.println(Colors.purple+Colors.bold+"Set your 4 digit Transaction Pin for payments");
								System.out.print("Transaction Pin:");
								String enterdPin=sc.nextLine();
								if(enterdPin.length()==4)
								{
									for(int i=0;i<enterdPin.length();i++)
									{
										if(enterdPin.charAt(i)>='0'&&enterdPin.charAt(i)<='9')
										{
											b=false;
											verifyPin=enterdPin;
										}
										else  
										{
											System.out.println(Colors.red+Colors.bold+"Please Enter only Numerical Digits!!"+Colors.reset);
											b=true;
											break;
										}
									}
								}
								else 
								{
									System.out.println(Colors.red+Colors.bold+"Please Enter only 4 digit pin!!"+Colors.reset);
								}
							}
			obj1.setSBI_PIN(verifyPin);
			Colors.loading();
			System.out.println(Colors.green+Colors.blink+Colors.bold+"\nYour PIN Created Successfuly.. "+Colors.reset);
			System.out.println(Colors.cyan+"Your PIN is:"+obj1.getSBI_PIN()+""+Colors.reset);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
			String ins="insert into users(User_Name,Password,Mobile_No,SBI_PIN)values(?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(ins);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setLong(3, number);
			ps.setString(4, verifyPin);
			ps.executeUpdate();
			Colors.loading();
			System.out.println(Colors.green+Colors.bold+"\nSuccessfully Your Bank is Linked..!!");
			System.out.println("Account Created Successfully..!!"+Colors.reset);
			break;
		}
		else if(BankSel==2)
		{
			boolean b=true;String verifyPin="";
							while(b)
							{
								System.out.println(Colors.purple+Colors.bold+"Set your 4 digit Transaction Pin for payments");
								System.out.print("Transaction Pin:");
								String enterdPin=sc.nextLine();
								if(enterdPin.length()==4)
								{
									for(int i=0;i<enterdPin.length();i++)
									{
										if(enterdPin.charAt(i)>='0'&&enterdPin.charAt(i)<='9')
										{
											b=false;
											verifyPin=enterdPin;
										}
										else  
										{
											System.out.println(Colors.red+Colors.bold+"Please Enter only Numerical Digits!!"+Colors.reset);
											b=true;
											break;
										}
									}
								}
								else 
								{
									System.out.println(Colors.red+Colors.bold+"Please Enter only 4 digit pin!!"+Colors.reset);
								}
							}
			obj1.setICICI_PIN(verifyPin);
			Colors.loading();
			System.out.println(Colors.green+Colors.blink+Colors.bold+"\nYour PIN Created Successfuly.. "+Colors.reset);
			System.out.println(Colors.cyan+"Your PIN is:"+obj1.getICICI_PIN()+""+Colors.reset);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
			String ins="insert into users(User_Name,Password,Mobile_No,ICICI_PIN)values(?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(ins);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setLong(3, number);
			ps.setString(4, verifyPin);
			ps.executeUpdate();
			Colors.loading();
			System.out.println(Colors.green+Colors.bold+"\nSuccessfully Your Bank is Linked..!!");
			System.out.println("Account Created Successfully..!!"+Colors.reset);
			break;
		}
		else
		{
			System.out.println(Colors.red+Colors.bold+"Select a valid option."+Colors.reset);
		}
		}
		catch(NumberFormatException e) {
			System.out.println(Colors.red+Colors.bold+"\tYou have entered Invalid Input!!"+Colors.reset);
		}
			
		}
		//insert(name,password,number);
		obj=new Registration(name,password,number);
		while(true)
		{
			try
			{
			System.out.println(Colors.cyan+Colors.bold+"\n\t1.Home\t\t2.Login\t\t3.Exit");
			System.out.print("\tEnter your Choice:");
			String ch1=Colors.sc.nextLine();
			if(ch1.equals("1"))
			{
				main(null);
				break;
			}
			else if(ch1.equals("2"))
			{
				login();
				break;
			}
			else if(ch1.equals("3"))
			{
				AmazonPrime.exit();
				break;
			}
			else
			{
				System.out.println(Colors.red+Colors.bold+"Invalid Input Please Try Again!!.."+Colors.reset);
			}
			}
			catch(NumberFormatException e) {
				System.out.println(Colors.red+Colors.bold+"\tYou have entered Invalid Input!!"+Colors.reset);
			}
		}
        }
	}
	public boolean isValid(String password1)		//Checking Password validation Method.
   	{
        if (password1 == null || password1.length() < 8) 
		{
        	return false;
        }
        else
		{
        	boolean hasUppercase = false;
        	boolean hasLowercase = false;
        	boolean hasDigit = false;
        	boolean hasSpecial = false;
        	for (char c : password1.toCharArray()) 
			{
         		if (Character.isUpperCase(c))
	    		{
              		hasUppercase = true;
            	} 
            	else if (Character.isLowerCase(c))
 	    		{
                	hasLowercase = true;
            	} 
            	else if (Character.isDigit(c)) 
	    		{
                	hasDigit = true;
            	} 
            	else if ("!@#$%^&*()_+{}[]|;:',.<>?/".indexOf(c) >= 0)
	    		{
                	hasSpecial = true;
            	}
        	}
         	return hasUppercase && hasLowercase && hasDigit && hasSpecial;
		}
	}
	public void mobileVerify() throws SQLException
	{
		try
		{
		long mb=0l;boolean b=false;
		System.out.print(Colors.cyan+Colors.bold+"Enter Your Mobile Number:");
		long mbno=Long.parseLong(sc.nextLine());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
		String sel="select No,Mobile_No from users;";
		PreparedStatement p1=con.prepareStatement(sel);
		ResultSet rs=p1.executeQuery();
		while(rs.next())
		{
			if(rs.getInt("No")==dbId)
			{
				mb=rs.getLong(2);
				break;
			}
		}
		System.out.println("------->"+mb);
		if(mbno==mb)
		{
			Colors.loading();
			int OTP=1000+(int)(Math.random()*8999);
			while(true)
			{
				try
				{
				System.out.println(Colors.purple+Colors.bold+"\nYour OTP is :"+OTP);
				System.out.print("Enter your otp:");
				int otp=Integer.parseInt(sc.nextLine());
				if(OTP==otp)
				{
					Colors.loading();
					System.out.println(Colors.green+Colors.bold+"\nMobile Number Verified Successfully.."+Colors.reset);
					b=true;
					break;
				}
				else
				{
					System.out.println(Colors.red+Colors.bold+"Invalid OTP Please Enter valid OTP!!"+Colors.reset);
					
				}
				}
				catch(NumberFormatException e) {
					System.out.println(Colors.red+Colors.bold+"\tYou have entered Invalid Input!!"+Colors.reset);
				}
			}
		}
		else
		{
			System.out.println(Colors.red+Colors.bold+"Mobile Number Doesn't match with your account!!"+Colors.reset);
			System.out.println(Colors.blue+Colors.bold+"Please Enter Correct Mobile Number !!");
			while(true)
			{
			System.out.println(Colors.cyan+Colors.bold+"\t1.Try Again\t\t2.Exit");
			System.out.println("------->");
			String ch=sc.nextLine();
			if(ch.equals("1"))
			{
				mobileVerify();
				break;
			}
			else if(ch.equals("2"))
			{
				Colors.exit();
				break;
			}
			else
			{
				System.out.println(Colors.red+Colors.bold+"Please select a valid Choice"+Colors.reset);
				
			}
			}
		}
		}
		catch(NumberFormatException e) {
			System.out.println(Colors.red+Colors.bold+"\tYou have entered Invalid Input!!"+Colors.reset);
		}
		
	}
	public void login()	throws SQLException	//Login Method.
	{
		System.out.println(Colors.blue+Colors.bold+Colors.blink+Colors.backpurple+"");
		System.out.println("\t\t _       _         _                                       _____            _                             				");
	    System.out.println("\t\t( )  _  ( )       (_ )                                    (_   _)          ( )                   _        				");
	    System.out.println("\t\t| | ( ) | |   __   | |    ___    _     ___ ___     __       | |     _      | |       _      __  (_)  ___  				");
	    System.out.println("\t\t| | | | | | /'__`\\ | |  /'___) /'_`\\ /' _ ` _ `\\ /'__`\\     | |   /'_`\\    | |  _  /'_`\\  /'_ `\\| |/' _ `\\				");
	    System.out.println("\t\t| (_/ \\_) |(  ___/ | | ( (___ ( (_) )| ( ) ( ) |(  ___/     | |  ( (_) )   | |_( )( (_) )( (_) || || ( ) |				");
	    System.out.println("\t\t`\\___x___/'`\\____)(___)`\\____)`\\___/'(_) (_) (_)`\\____)     (_)  `\\___/'   (____/'`\\___/'`\\__  |(_)(_) (_) 				");
	    System.out.println("\t\t                                                                                         ( )_) |          				");
	    System.out.println("\t\t                                                                                          \\___/'          				"+Colors.reset);
		System.out.println(Colors.blue+Colors.bold+"Enter your credentials...");
		System.out.print(Colors.cyan+Colors.blink+Colors.bold+"Enter your username :");
		String user=sc.nextLine();
		System.out.print("Enter your password :");
		String pass=sc.nextLine();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
		String sel="select User_Name from users;";
		String sel1="select Password from users;";
		String selNo="select User_Name,Password,No from users where User_Name=? or Password=?;";
		PreparedStatement ps=con.prepareStatement(sel);
		PreparedStatement ps1=con.prepareStatement(sel1);
		PreparedStatement psNo =con.prepareStatement(selNo);
		psNo.setString(1,user);
		psNo.setString(2,pass);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.getString(1).equals(user))
			{
				dbUser=rs.getString(1);
				break;
			}
		}
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			if(rs1.getString(1).equals(pass))
			{
				dbPass=rs1.getString(1);
				break;
			}
		}
		ResultSet rsNo=psNo.executeQuery();
		while(rsNo.next())
		{
			dbId=rsNo.getInt(3);
				
		}
		if((user.equals(obj.getUserName()) && pass.equals(obj.getPassword()))||(user.equals(dbUser)&&pass.equals(dbPass)))
		{
			Colors.loading();
			System.out.print(Colors.reset+Colors.green+Colors.bold+"\nYour Login is Successfull!!"+Colors.reset);
			AmazonPrime.selection(); 
			
		}
		else if(!user.equals(obj.getUserName()) && !pass.equals(obj.getPassword())&&(!user.equals(dbUser)&&!pass.equals(dbPass)))
		{
			//System.out.println(dbUser+" "+dbPass+" "+dbId);
			Colors.loading();
			System.out.println(Colors.red+Colors.bold+"\nInvalid username and password"+Colors.reset);
			while(true) {
			System.out.println(Colors.cyan+Colors.bold+"\t1.To Know your UserName\t\t2.Try Again\t\t3.Home\t\t4.Exit");
			System.out.print("---->");
			String t=sc.nextLine();
			if(t.equals("1"))
			{
				boolean b=true;String uName="";long mb1=0l;
				while(b ) 
				{
				System.out.print(Colors.cyan+Colors.bold+"Enter your mobile number:");
				long e=Long.parseLong(sc.nextLine());
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
				String s1="select No,User_Name,Mobile_No from users where Mobile_No=?;";
				PreparedStatement prest=c1.prepareStatement(s1);
				prest.setLong(1,e);
				ResultSet rset=prest.executeQuery();
				while(rset.next())
				{
					dbId=rset.getInt("No");
					uName=rset.getString("User_Name");
					mb1=rset.getLong("Mobile_No");
					
				}
				if(e==obj.getMobile()||mb1==e)
				{
					Colors.loading();
					int OTP=1000+(int)(Math.random()*8999);
					while(true)
					{
						System.out.println(Colors.purple+Colors.bold+"\nYour OTP is :"+OTP);
						System.out.print("Enter your otp:");
						int otp=Integer.parseInt(sc.nextLine());
						if(OTP==otp)
						{
							Colors.loading();
							System.out.println(Colors.green+Colors.bold+"\nMobile Number Verified Successfully.."+Colors.reset);
							b=true;
							break;
						}
						else
						{
							System.out.println(Colors.red+Colors.bold+"Invalid OTP Please Enter valid OTP!!"+Colors.reset);
							
						}
					}
					if(e==obj.getMobile())
					{
					System.out.print(Colors.cyan+Colors.bold+"Fetching Your details");
					Colors.loading();
					System.out.println("\nYour username is "+obj.getUserName()+""+Colors.reset);
					login();
					b=false;
					}
					else
					{
						System.out.print(Colors.cyan+Colors.bold+"Fetching Your details");
						Colors.loading();
						System.out.println("\nYour username is :"+uName+""+Colors.reset);
						login();
						b=false;
					}
				}		
				else
				{
					System.out.println(Colors.red+Colors.bold+"You have entered Invalid mobile number"+Colors.reset);
					while(true)
					{
					System.out.println(Colors.cyan+Colors.bold+"\t1.Re-enter Again\t\t2.Home\t\t3.Exit");
					System.out.print("---->");
					String n=sc.nextLine();
					if(n.equals("1"))
					{
						b=true;
						break;
					}
					else if(n.equals("2"))
					{
						main(null);break;
					}
					else if(n.equals("3"))
					{
						Colors.exit();
						b=false;
						break;
					}
					else
					{
						System.out.println(Colors.red+Colors.bold+"Invalid Choice!!"+Colors.reset);
					}
					}
				}
				}
				break;
			}
			else if(t.equals("2"))
			{
				login();
				break;
			}
			else if(t.equals("3"))
			{
				main(null);break;
			}
			else if(t.equals("4"))
			{
				Colors.exit();break;
			}
			else
			{
				System.out.println(Colors.red+Colors.bold+"Invalid Input Please select valid Choice!!."+Colors.reset);
			}
			}
		}
		
		else if((!user.equals(obj.getUserName()))&&!(user.equals(dbUser))&&(pass.equals(obj.getUserName()))||(pass.equals(dbPass)))
		{
			//System.out.println(dbUser+" "+dbPass+" "+dbId);
			Colors.loading();
			System.out.println(Colors.red+Colors.bold+"\nYou have entered wrong user name!!"+Colors.reset);
			System.out.println(Colors.cyan+Colors.bold+"Do you want to reset your user name?");
			while(true) 
			{
			System.out.print(Colors.cyan+Colors.bold+"\t1.Reset-userName\t2.Try Again\t3.Home\t4.Exit\nEnter your Choice:");
			String y=sc.nextLine();
			if(y.equals("1"))
			{
//				System.out.println(dbUser+" "+dbPass+" "+dbId);
				mobileVerify();				
				System.out.print(Colors.cyan+Colors.bold+"\nEnter your new Username :");
				String newUsername=Colors.sc.nextLine();
				obj.setUserName(newUsername);
				System.out.println("Your new username is:"+ obj.getUserName());
//				System.out.println("Your UserName is Updated Successfuly..");
				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
				String sel2="update users set User_Name=? where No=?;";
				PreparedStatement ps2=con1.prepareStatement(sel2);
				ps2.setString(1,newUsername);
				ps2.setInt(2,dbId);
				Colors.loading();
				System.out.println(ps2.executeUpdate()+"Done");
				Colors.loading();
				System.out.println(Colors.green+Colors.bold+"\nYour UserName is Updated Successfuly.."+Colors.reset);
				while(true)
				{
					System.out.println(Colors.cyan+Colors.bold+"\n\t1.Home\t\t2.Login\t\t3.Exit");
					System.out.print("Enter your Choice:");
					String ch1=Colors.sc.nextLine();
					if(ch1.equals("1"))
					{
						main(null);
						break;
					}
					else if(ch1.equals("2"))
					{
						login();
						break;
					}
					else if(ch1.equals("3"))
					{
						AmazonPrime.exit();
						break;
					}
					else
					{
						System.out.println(Colors.red+Colors.bold+"Invalid Input Please Try Again!!.."+Colors.reset);
					}
				}
				break;
				
			}
			else if(y.equals("2"))
			{
				login();
				break;				
			}
			else if(y.equals("3"))
			{
				main(null);break;
			}
			else if(y.equals("4"))
			{
				AmazonPrime.exit();
				break;
			}
			else
			{
				System.out.println(Colors.red+Colors.bold+"Invalid Input Please Try Again!!.."+Colors.reset);
			}
		}

		}
		else if(!pass.equals(obj.getPassword())||!(pass.equals(dbPass)))
		{
			Colors.loading();
			System.out.println(Colors.red+Colors.bold+"\nYou have entered wrong password!!"+Colors.reset);
			System.out.println(Colors.blue+Colors.bold+"Do you want to reset your password?");
			while(true) 
			{
			System.out.print(Colors.cyan+Colors.bold+"\t1.Reset-Password\t\t2.Try Again\t\t3.Home\t\t4.Exit\nEnter your Choice:");
			String y=sc.nextLine();
			if(y.equals("1"))
			{
				//System.out.println(dbUser+" "+dbPass+" "+dbId);
				mobileVerify();				
				System.out.print(Colors.cyan+Colors.bold+"Enter your new Password :");
				String newPassword=Colors.sc.nextLine();
				obj.setPassword(newPassword);
				System.out.println("Your new Password is:"+ obj.getPassword());				
				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
				String sel2="update users set Password=? where No=?;";
				PreparedStatement ps2=con1.prepareStatement(sel2);
				ps2.setString(1,newPassword);
				ps2.setInt(2,dbId);
				Colors.loading();
				System.out.println(ps2.executeUpdate()+"Done");
				Colors.animation();
				System.out.println(Colors.green+Colors.bold+"\nYour Password is Updated Successfuly.."+Colors.reset);
				while(true)
				{
					System.out.println(Colors.cyan+Colors.bold+"\n\t1.Home\t\t2.Login\t\t3.Exit");
					System.out.print("Enter your Choice:");
					String ch1=Colors.sc.nextLine();
					if(ch1.equals("1"))
					{
						main(null);
						break;
					}
					else if(ch1.equals("2"))
					{
						login();
						break;
					}
					else if(ch1.equals("3"))
					{
						AmazonPrime.exit();
						break;
					}
					else
					{
						System.out.println(Colors.red+Colors.bold+"Invalid Input Please Try Again!!.."+Colors.reset);
					}
				}
				break;
				
			}
			else if(y.equals("2"))
			{
				login();
				break;				
			}
			else if(y.equals("3"))
			{
				main(null);break;
			}
			else if(y.equals("4"))
			{
				AmazonPrime.exit();
				break;
			}
			else
			{
				System.out.println(Colors.red+Colors.bold+"Invalid Input Please Try Again!!.."+Colors.reset);
			}
		}

		}
	}

	public static void main(String[] args)throws SQLException
	{
		 User ob=new User();
		
		 	
		    System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"+==============================================================+"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|                                                              |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|                                                              |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|   __        __         _                                     |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backpurple+Colors.blink+Colors.bold+"|   \\ \\      / /   ___  | |   ___    ___    _ __ ___     ___   |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backpurple+Colors.blink+Colors.bold+"|    \\ \\ /\\ / /   / _ \\ | |  / __|  / _ \\  | '_ ` _ \\   / _ \\  |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backpurple+Colors.blink+Colors.bold+"|     \\ V  V /   |  __/ | | | (__  | (_) | | | | | | | |  __/  |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backpurple+Colors.blink+Colors.bold+"|      \\_/\\_/     \\___| |_|  \\___|  \\___/  |_| |_| |_|  \\___|  |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|                                                              |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|    _       ____    _                     _   _               |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|   / |     / ___|  (_)   __ _   _ __     | | | |  _ __        |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|   | |     \\___ \\  | |  / _` | | '_ \\    | | | | | '_ \\       |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|   | |  _   ___) | | | | (_| | | | | |   | |_| | | |_) |      |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|   |_| (_) |____/  |_|  \\__, | |_| |_|    \\___/  | .__/       |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|                        |___/                    |_|          |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|    ____        _                       _                     |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|   |___ \\      | |       ___     __ _  (_)  _ __              |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|     __) |     | |      / _ \\   / _` | | | | '_ \\             |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|    / __/   _  | |___  | (_) | | (_| | | | | | | |            |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|   |_____| (_) |_____|  \\___/   \\__, | |_| |_| |_|            |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|                                |___/                         |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|                                                              |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"|                                                              |"+Colors.reset);
	        System.out.println("\t\t\t\t"+Colors.backgreen+Colors.blink+Colors.bold+"+==============================================================+"+Colors.reset);
	       
  
		
		while(true)
		{
			System.out.print(Colors.blue+Colors.blink+"\n------------->"+Colors.reset);
			try
			{
				int p= Integer.parseInt(sc.nextLine());
				if(p==1)
				{
					ob.signup();
					break;
				}
				else if(p==2)
				{
					ob.login();
					break;
				}
				else
				{
					System.out.println(Colors.red+Colors.bold+"You have entered wrong choice please try again!! "+Colors.reset);	
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println(Colors.red+Colors.bold+"\tYou have entered Invalid Input!!"+""+e+""+Colors.reset);
				
			}
		}

	}
}