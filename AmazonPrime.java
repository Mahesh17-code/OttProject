package project;
import java.sql.*;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.text.ParseException;
public class AmazonPrime extends Colors
{
	static String dbSbiPin="";
	static String dbIciciPin="";
	static 			//static block to print welcome statement.
	{
		try
		{		System.out.println(Colors.cyan+Colors.backwhite+bold+"");
			    System.out.println("\t\t         ##   ##  #######   ####     #####    #####   ##   ##  #######           ########  #####   				");Thread.sleep(500);
		        System.out.println("\t\t         ##   ##   ##  ##    ##     ##   ##  ##   ##  ### ###   ##  ##           #  ##  # ##   ##  				");Thread.sleep(500);
		        System.out.println("\t\t         ##   ##   ##        ##     ##       ##   ##  #######   ##                  ##    ##   ##  				");Thread.sleep(500);
		        System.out.println("\t\t         ## # ##   ####      ##     ##       ##   ##  ## # ##   ####                ##    ##   ##  				");Thread.sleep(500);
		        System.out.println("\t\t         #######   ##        ##     ##       ##   ##  ##   ##   ##                  ##    ##   ##  				");Thread.sleep(500);
		        System.out.println("\t\t         ### ###   ##  ##    ## ##  ##   ##  ##   ##  ##   ##   ##  ##              ##    ##   ##  				");Thread.sleep(500);
		        System.out.println("\t\t         ##   ##  #######   ######   #####    #####   ##   ##  #######             ####    #####   				");Thread.sleep(500);
		        System.out.println("\t\t                                                                                                    					");Thread.sleep(500);
		        System.out.println("\t\t #####   ######## ######   #######     ##    ##   ##           ##   ##   #####   ######    ####    ######   				");Thread.sleep(500);
		        System.out.println("\t\t##   ##  #  ##  #  ##  ##   ##  ##    ####   ### ###           ##   ##  ##   ##   ##  ##    ##      ##  ##  				");Thread.sleep(500);
		        System.out.println("\t\t##          ##     ##  ##   ##       ##  ##  #######           ##   ##  ##   ##   ##  ##    ##      ##  ##  				");Thread.sleep(500);
		        System.out.println("\t\t #####      ##     #####    ####     ######  ## # ##           ## # ##  ##   ##   #####     ##      ##  ##  				");Thread.sleep(500);
		        System.out.println("\t\t     ##     ##     ####     ##       ##  ##  ##   ##           #######  ##   ##   ####      ##      ##  ##  				");Thread.sleep(500);
		        System.out.println("\t\t##   ##     ##     ## ##    ##  ##   ##  ##  ##   ##           ### ###  ##   ##   ## ##     ## ##   ##  ##  				");Thread.sleep(500);
		        System.out.println("\t\t #####     ####   ###  ##  #######   ##  ##  ##   ##           ##   ##   #####   ###  ##   ######  ######   				");Thread.sleep(500);
		        System.out.println("\t\t                                                                                                            				 "+Colors.reset);Thread.sleep(500);
		   	}
		catch(InterruptedException e){}
  
	}
	
	static double subPlan=0;
	static Date startDate=null;
	static Date endDate=null;
	public static void selection()throws SQLException 
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
		String s1="select Plan_Amount,Plan_End_Date from subscriptions where User_Name=?;";
		PreparedStatement ps=con.prepareStatement(s1);
		ps.setString(1,User.dbUser);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			subPlan=rs.getInt("Plan_Amount");
			endDate=rs.getDate("Plan_End_Date");
		}
		System.out.print(Colors.cyan+bold+"1-Movies\n2-Series\n3-Subscription Plans\n4-Subsciption Details\n5-Watch History\n6-Exit");
		System.out.print("\nEnter your choice:");
		try
		{
			AmazonPrime obj=new AmazonPrime();
		int n=Integer.parseInt(sc.nextLine());
		if(n==1)
		{
			obj.movies();
		}
		else if(n==2)
		{
			obj.series();
		}
		else if(n==3)
		{
			obj.subscriptionPlans();
		}
		else if(n==4)
		{
			obj.subscriptionDetails();
		}
		else if(n==5)
		{
			obj.history();
		}
		else if(n==6)
		{
			Colors.exit();
		}
		else
		{
			System.out.println(Colors.red+"You have selected wrong choice Please select correct choice!!"+Colors.reset);
			selection();
		}
		}
		catch(NumberFormatException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
			selection();
		}
	}
	public void history() throws SQLException
	{
		try
		{
		System.out.println(cyan+bold+"\t\t1-Movies Watch History\t\t\t2-Series Watch History\t\t3.MainMenu\t\t4.Exit");
		System.out.print("\t---->");
		int opt=Integer.parseInt(sc.nextLine());
		if(opt==1)
		{
			try
			{
			new Movies().displayMoviesHistory();
			}
			catch(Exception e)
			{
				System.out.println(red+bold+"\t\tYou Don't Have any Movies History!!"+reset);
				System.out.println(purple+bold+"\tPlease Watch any Movies to get Movies History.."+reset);
				history();
			}
			while(true)
			{
				try
				{
					System.out.println(cyan+bold+"\n\t1.Display Movies\t\t2.MainMenu\t\t3.Watch History\t\t4.Exit"+reset);
					System.out.print(cyan+bold+"\t\t---->");
					int sel=Integer.parseInt(sc.nextLine());
					if(sel==1)
					{
						movies();break;
					}
					else if(sel==2)
					{
						selection();break;
					}
					else if(sel==3)
					{
						history();break;
					}
					else if(sel==4)
					{
						exit();break;
					}
					else
					{
						System.out.println(red+bold+"Invalid Choice!! Please Select Correct Choice."+reset);
					}
				}
				catch(NumberFormatException e) {
					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					
				}
			}
		}
		else if(opt==2)
		{
			try
			{
			new Series().displaySeriesHistory();
			}
			catch(Exception e)
			{
				System.out.println(red+bold+"\t\tYou Don't Have any Series History!!"+reset);
				System.out.println(purple+bold+"\tPlease Watch any Series to get Series History.."+reset);
				history();
			}
			while(true)
			{
				try
				{
					System.out.println(cyan+bold+"\n\t1.Display Series\t\t2.MainMenu\t\t3.Watch History\t\t4.Exit"+reset);
					System.out.print("\t\t---->");
					int sel=Integer.parseInt(sc.nextLine());
					if(sel==1)
					{
						series();break;
					}
					else if(sel==2)
					{
						selection();break;
					}
					else if(sel==3)
					{
						history();break;
					}
					else if(sel==4)
					{
						exit();break;
					}
					else
					{
						System.out.println(red+bold+"Invalid Choice!! Please Select Correct Choice."+reset);
					}
				}
				catch(NumberFormatException e) {
					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					
				}
			}
		}
		else if(opt==3)
		{
			selection();
		}
		else if(opt==4)
		{
			Colors.exit();
		}
		else
		{
			System.out.println(red+bold+"Invalid Choice!! Please Select Correct Choice."+reset);
			history();
		}
		}
		catch(NumberFormatException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
			history();
		}
	}
//	public static boolean PlanExpiryCheck() 
//	{
//	        Date end = endDate;
//	        Date d=new Date();
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
//			Date s=sdf.format(d);			
//			try 
//			{				
//				s= sdf.parse(s);
//			}
//			catch (ParseException e) 
//			{
//				System.out.println("Invalid date format: " + e.getMessage());
//			}			
//	        Date currentDate =;
//
//	        // Check if the current date is after the end date
//	        if (currentDate.isAfter(endDate)) {
//	            System.out.println("Plan expired.");
//	        } else {
//	            System.out.println("Plan is still active.");
//	        }
//	    }
//	}
	public  void movies()throws SQLException	
	{
			while(true)
			{
				System.out.println(Colors.cyan+"Choose a Language\n1-TELUGU\n2-ENGLISH\n3-HINDI");
				System.out.print("Enter your choice:");
				try {
				int i=Integer.parseInt(sc.nextLine());
				if(i==1)
				{
					Movies x=new Movies();
					x.TeluguMovies();
					break;
				}
				else if(i==2)
				{
					Movies x=new Movies();
					x.EnglishMovies();
					break;
				}
				else if(i==3)
				{
					Movies x=new Movies();
					x.HindiMovies();
					break;
				}
				else
				{
					System.out.println(Colors.red+"Invalid choice!!"+Colors.reset);
				}
				}
				catch(NumberFormatException e) {
					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					movies();
				}
			}

	}
	public  void series()throws SQLException
	{
		while(true)
			{
				System.out.println(Colors.cyan+"Choose a Language\n1-TELUGU\n2-ENGLISH\n3-HINDI");
				System.out.print("Enter your choice:");
				try
				{
				int i=Integer.parseInt(sc.nextLine());
				if(i==1)
				{
					Series x=new Series();
					x.TeluguSeries();
					break;
				}
				else if(i==2)
				{
					Series x=new Series();
					x.EnglishSeries();
					break;
				}
				else if(i==3)
				{
					Series x=new Series();
					x.HindiSeries();
					break;
				}
				else
				{
					System.out.println(Colors.red+"Invalid choice!!"+Colors.reset);
				}
				}
				catch(NumberFormatException e) {
					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					series();
				}
			}
	}
	public  void subscriptionPlans()throws SQLException//COMPLETED
	{
		if(subPlan>0)
		{
			System.out.println(red+bold+"\t Sorry You have Already a Subscription plan.."+reset);
			while(true)
			{
				System.out.println(blue+bold+"\t1.Display SubscriptionPlan Details\t\t2.MainMenu\t\t3.Exit");
				System.out.print("\t---->");
				String select=sc.nextLine();
				if(select.equals("1"))
				{
					subscriptionDetails();
					break;
				}
				else if(select.equals("2"))
				{
					selection();
					break;
				}
				else if(select.equals("3"))
				{
					exit();
					break;
				}
				else
				{
					System.out.println(red+bold+"\t\tInvalid Choice!! Plrease Select Valid Choice.."+reset);
				}
			}
		}
		else
		{
		try
		{
		while(true)
		{
			System.out.println(Colors.cyan+bold+"\t1-Subscription Plans\t\t2-Main Menu\t\t3-Exit");
			System.out.print("\t--->");
			int choice=Integer.parseInt(sc.nextLine());
			if(choice==1)
			{
				while(true)
				{
					try
					{
				System.out.println(Colors.blue+Colors.bold+"\n\tSubscription Plans");
				System.out.println("\n1-  1 Month    	199 Rs/-");
				System.out.println("2-  3 Months	499 Rs/-");
				System.out.println("3-  6 Months	1099 Rs/-");
				System.out.println("4-  1 Year	1899 Rs/-");
				System.out.print("\nSelect your Subscription plan:"+Colors.reset);
				int selectSubPlan=Integer.parseInt(sc.nextLine());
				if(selectSubPlan==1)
				{
					System.out.println(Colors.yellow+"\n\t\tBenefits of The Plan");
					System.out.println(Colors.green+"\n1.You can Watch All Movies in 1080P Quality 24/7. ");
					System.out.println("2.You can Login upto 3 Devices.");
					while(true)
					{
						System.out.println(Colors.cyan+"\n\tPress 1 to proceed payment\n\tpress 2 for Goback");
						System.out.print("\t--->");
						int opt=Integer.parseInt(sc.nextLine());
						if(opt==1)
						{
							System.out.println(Colors.purple+"\n\tSubscription plan amount is Rs.199/-");
							System.out.println("\tPlan Validity 1 Month. ");
							payment(199);
							break;
						}
						else if(opt==2)
						{
							subscriptionPlans();
							break;
						}
						else 
						{
							System.out.println(Colors.red+"\tplease select a valid option!!."+Colors.reset);
						}
					}
					break;

				}
				else if(selectSubPlan==2)
				{
					System.out.println(Colors.yellow+"\n\t\tBenefits of The Plan");
					System.out.println(Colors.green+"\n1.You can Watch All Movies in 2160P Quality 24/7. ");
					System.out.println("2.You can Login upto 6 Devices.");
					while(true)
					{
						System.out.println(Colors.cyan+"\n\tPress 1 to proceed payment\n\tpress 2 for Goback");
						System.out.print("\t--->");
						int opt=Integer.parseInt(sc.nextLine());
						if(opt==1)
						{
							System.out.println(Colors.purple+"\n\tSubscription plan amount is Rs.499/-");
							System.out.println("\tPlan Validity 3 Month. ");
							payment(499);
							break;
						}
						else if(opt==2)
						{
							subscriptionPlans();
							break;
						}
						else 
						{
							System.out.println(Colors.red+"\tplease select a valid option!!."+Colors.reset);
						}
					}
					break;
				}
				else if(selectSubPlan==3)
				{
					System.out.println(Colors.yellow+"\n\t\tBenefits of The Plan");
					System.out.println(Colors.green+"\n1.You can Watch All Movies in 4k Quality 24/7. ");
					System.out.println("2.You can Login upto 10 Devices.");
					while(true)
					{
						System.out.println(Colors.cyan+"\n\tPress 1 to proceed payment\n\tpress 2 for Goback");
						System.out.print("\t--->");
						int opt=Integer.parseInt(sc.nextLine());
						if(opt==1)
						{
							System.out.println(Colors.purple+"\n\tSubscription plan amount is Rs.1099/-");
							System.out.println("\tPlan Validity 6 Month. ");
							payment(1099);
							break;
						}
						else if(opt==2)
						{
							subscriptionPlans();
							break;
						}
						else 
						{
							System.out.println(Colors.red+"\tplease select a valid option!!."+Colors.reset);
						}
					}
					break;
				}
				else if(selectSubPlan==4)
				{
					System.out.println(Colors.yellow+"\n\t\tBenefits of The Plan");
					System.out.println(Colors.green+"\n1.You can Watch All Movies in 4k Quality 24/7. ");
					System.out.println("2.You can Login upto 12 Devices.");
					while(true)
					{
						System.out.println(Colors.cyan+"\n\tPress 1 to proceed payment\n\tpress 2 for Goback");
						System.out.print("\t--->");
						int opt=Integer.parseInt(sc.nextLine());
						if(opt==1)
						{
							System.out.println(Colors.purple+"\n\tSubscription plan amount is Rs.1899/-");
							System.out.println("\tPlan Validity 1 Year. ");
							payment(1899);
							break;
						}
						else if(opt==2)
						{
							subscriptionPlans();
							break;
						}
						else 
						{
							System.out.println(Colors.red+"\tplease select a valid option!!."+Colors.reset);
						}
					}
					break;
				}
				else 
				{
					System.out.println(Colors.red+"You have selected wrong choice Please select valid choice!!"+Colors.reset);
					subscriptionPlans();
				}
				}
				catch(NumberFormatException e) {
					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
						
					}
				}
				
				break;
			}
			else if(choice==2)
			{
				selection();
				break;
			}
			else if(choice==3)
			{
				exit();
				break;
			}
			else 
			{
				System.out.println(Colors.red+"\t\t..Please Select a valid choice!!..."+Colors.reset);
			}
		}
		}
		catch(NumberFormatException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
			subscriptionPlans();
		}
		}
	}	
	public  void subscriptionDetails()throws SQLException
	{
		Date start=null,end=null;
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
		String s1="select Plan_Amount,Plan_Start_Date,Plan_End_Date from subscriptions where User_Name=?;";
		PreparedStatement ps=con.prepareStatement(s1);
		ps.setString(1,User.dbUser);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			subPlan=rs.getInt("Plan_Amount");
			start=rs.getDate("Plan_Start_Date");
			end=rs.getDate("Plan_End_Date");
			
		}
		if(subPlan<=0)
		{
			System.out.println(Colors.red+Colors.blink+"\n   		..Sorry you dontn't have any subscription plans!!..");
			System.out.println(" 	..Please Select a Subscription plan to Watch Movies and Series.. "+Colors.reset);
			while(true)
			{
				try
				{
				System.out.println(Colors.cyan+Colors.bold+"\t1-Display Subscription Plans\t\t2-Go Back\t\t3-Exit");
				System.out.print("\t--->");
				int choice=Integer.parseInt(sc.nextLine());
				if(choice==1)
				{
					subscriptionPlans();
					break;
				}
				else if(choice==2)
				{
					selection();
					break;
				}
				else if (choice==3) 
				{
					exit();
					break;
				}
				else 
				{
					System.out.println(Colors.red+Colors.bold+"\t\t..Please Select a valid choice!!..."+Colors.reset);
				}
				}
				catch(NumberFormatException e) {
					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					
				}
			}
		}
		else 
		{
			System.out.println(Colors.yellow+Colors.bold+"\n\t\t\t\t@@##--....YOUR SUBSCRIPTION PLAN DETAILS....--##@@"+Colors.reset);
			if(subPlan==199)
			{
				System.out.println(Colors.purple+Colors.bold+"\n\t\tBenefits\n"+Colors.reset);
				System.out.println(Colors.cyan+Colors.bold+"1.You can Watch All Movies in 1080P Quality 24/7. ");
				System.out.println("2.You can Login upto 3 Devices.");
				System.out.println("\nSubscription plan amount is Rs.199/-");
				System.out.println("Plan Validity 1 Month. ");
				Date startDate = start;
        		Date endDate = end;
        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        		System.out.println(Colors.green+Colors.bold+"Subscription Plan Validity Details:\nFrom : " + dateFormat.format(startDate) + "\nTo   : " + dateFormat.format(endDate));
        		System.out.println();
        		while(true)
        		{
        			try
        			{
	        		System.out.println(Colors.cyan+bold+"\t1-MainMenu\t\t2-Exit");
	        		System.out.print("\n\t--->:");
	        		int opt=Integer.parseInt(sc.nextLine());
	        		if(opt==1)
	        		{
	        			selection();
	        			break;
	        		}
	        		else if(opt==2)
	        		{
	        			exit();
	        			break;
	        		}
	        		else 
	        		{
	        			System.out.println(Colors.red+bold+"Invalid choice!!"+Colors.reset);
	        		}
        			}
        			catch(NumberFormatException e) {
    					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
    					
    				}
	        	}
			}
			else if(subPlan==499)
			{
				System.out.println(Colors.purple+Colors.bold+"\n\t\tBenefits\n"+Colors.reset);
				System.out.println(Colors.cyan+Colors.bold+"1.You can Watch All Movies in 2160P Quality 24/7. ");
				System.out.println("2.You can Login upto 6 Devices.");
				System.out.println("\nSubscription plan amount is Rs.499/-");
				System.out.println("Plan Validity 3 Months. ");
				Date startDate = start;
        		Date endDate = end;
        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        		System.out.println(Colors.green+"Subscription Plan Validity Details:\nFrom : " + dateFormat.format(startDate) + "\nTo   : " + dateFormat.format(endDate));
        		System.out.println();
        		while(true)
        		{
        			try
        			{
        			System.out.println(Colors.cyan+"\t1-MainMenu\t\t2-Exit");
	        		System.out.print("\n\t--->:");
	        		int opt=Integer.parseInt(sc.nextLine());
	        		if(opt==1)
	        		{
	        			selection();
	        			break;
	        		}
	        		else if(opt==2)
	        		{
	        			exit();
	        			break;
	        		}
	        		else 
	        		{
	        			System.out.println(Colors.red+"Invalid choice!!"+Colors.reset);
	        		}
        			}
        			catch(NumberFormatException e) {
    					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
    					
    				}
	        	}
			}
			else if(subPlan==1099)
			{
				System.out.println(Colors.purple+"\n\t\tBenefits\n"+Colors.reset);
				System.out.println(Colors.cyan+"1.You can Watch All Movies in 4k Quality 24/7. ");
				System.out.println("2.You can Login upto 10 Devices.");
				System.out.println("\nSubscription plan amount is Rs.1099/-");
				System.out.println("Plan Validity 6 Months. ");
				Date startDate = start;
        		Date endDate =end;
        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        		System.out.println(Colors.green+"Subscription Plan Validity Details:\nFrom : " + dateFormat.format(startDate) + "\nTo   : " + dateFormat.format(endDate));
        		System.out.println();
        		while(true)
        		{
        			try
        			{
        			System.out.println(Colors.cyan+"\t1-MainMenu\t\t2-Exit");
	        		System.out.print("\n\t--->:");
	        		int opt=Integer.parseInt(sc.nextLine());
	        		if(opt==1)
	        		{
	        			selection();
	        			break;
	        		}
	        		else if(opt==2)
	        		{
	        			exit();
	        			break;
	        		}
	        		else 
	        		{
	        			System.out.println(Colors.red+"Invalid choice!!"+Colors.reset);
	        		}
        			}
        			catch(NumberFormatException e) {
    					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
    					
    				}
	        	}
			}
			else if(subPlan==1899)
			{
				System.out.println(Colors.purple+Colors.bold+"\n\t\tBenefits\n"+Colors.reset);
				System.out.println(Colors.cyan+Colors.bold+"1.You can Watch All Movies in 4k Quality 24/7. ");
				System.out.println("2.You can Login upto 12 Devices.");
				System.out.println("\nSubscription plan amount is Rs.1899/-");
				System.out.println("Plan Validity 1 Year . ");
				Date startDate =start;       	 		
        		Date endDate = end;
        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        		System.out.println(Colors.green+"Subscription Plan Validity Details:\nFrom : " + dateFormat.format(startDate) + "\nTo   : " + dateFormat.format(endDate));
        		System.out.println();
        		while(true)
        		{
        			try
        			{
        			System.out.println(Colors.cyan+Colors.bold+"\t1-MainMenu\t\t2-Exit");
	        		System.out.print("\n\t--->:");
	        		int opt=Integer.parseInt(sc.nextLine());
	        		if(opt==1)
	        		{
	        			selection();
	        			break;
	        		}
	        		else if(opt==2)
	        		{
	        			exit();
	        			break;
	        		}
	        		else 
	        		{
	        			System.out.println(Colors.red+Colors.bold+"Invalid choice!!"+Colors.reset);
	        		}
        			}
        			catch(NumberFormatException e) {
    					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
    					
    				}
	        	}
			}

		}
	}
	public static void payment(double plan)throws SQLException
	{
		try
		{
			System.out.println(Colors.cyan+Colors.bold+"\n\t\tSelect Your Payment Options");
			System.out.println("\t1-Phone Pe\t\t2-Google Pay\t\t3-Paytm");
			System.out.print("Select Your choice:");
			int n=Integer.parseInt(sc.nextLine());
			if(n==1)
			{
				phonePe(plan);

			}
			else if(n==2)
			{
				googlePay(plan);
			}
			else if(n==3)
			{
				paytm(plan);
			}
			else  
			{
				System.out.println(Colors.red+Colors.bold+"Please Select valid Payment option!!.."+Colors.reset);
				payment(plan);
			}
		}
		catch(NumberFormatException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
			payment(plan);
		}
	}
	//phone pe payment method.
	public static void phonePe(double amount)throws SQLException
	{
		try
		{
			System.out.println(Colors.purple+bold+"");
			System.out.println("\t\t\t\t##   ##  ### ###  ####      ## ##    ## ##   ##   ##  ### ###           #### ##   ## ##            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t##   ##   ##  ##   ##      ##   ##  ##   ##   ## ##    ##  ##           # ## ##  ##   ##           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t##   ##   ##       ##      ##       ##   ##  # ### #   ##                 ##     ##   ##           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t## # ##   ## ##    ##      ##       ##   ##  ## # ##   ## ##              ##     ##   ##           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t# ### #   ##       ##      ##       ##   ##  ##   ##   ##                 ##     ##   ##           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t ## ##    ##  ##   ##  ##  ##   ##  ##   ##  ##   ##   ##  ##             ##     ##   ##           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t##   ##  ### ###  ### ###   ## ##    ## ##   ##   ##  ### ###            ####     ## ##            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                                                                                                    ");Thread.sleep(500);
	        System.out.println("\t\t\t\t         ### ##   ###  ##   ## ##   ###  ##  ### ###           ### ##   ### ###                    ");Thread.sleep(500);
	        System.out.println("\t\t\t\t          ##  ##   ##  ##  ##   ##    ## ##   ##  ##            ##  ##   ##  ##                    ");Thread.sleep(500);
	        System.out.println("\t\t\t\t          ##  ##   ##  ##  ##   ##   # ## #   ##                ##  ##   ##                        ");Thread.sleep(500);
	        System.out.println("\t\t\t\t          ##  ##   ## ###  ##   ##   ## ##    ## ##             ##  ##   ## ##                     ");Thread.sleep(500);
	        System.out.println("\t\t\t\t          ## ##    ##  ##  ##   ##   ##  ##   ##                ## ##    ##                        ");Thread.sleep(500);
	        System.out.println("\t\t\t\t          ##       ##  ##  ##   ##   ##  ##   ##  ##            ##       ##  ##                    ");Thread.sleep(500);
	        System.out.println("\t\t\t\t         ####     ###  ##   ## ##   ###  ##  ### ###           ####     ### ###                    "+Colors.reset);Thread.sleep(500);
   
		}
		catch(InterruptedException e){}
		System.out.println(Colors.yellow+"\tYour plan amount is:"+amount);
		while(true)
		{
			try
			{
			System.out.println(Colors.cyan+"\n\tPress 1 to continue payment\n\tPress 2 to Goback");
			System.out.print("\t--->");
			int ch=Integer.parseInt(sc.nextLine());
			if(ch==1)
			{
				while(true)
				{
					try
					{
					System.out.println(Colors.cyan+"\n\t\tSelect your Bank");
					System.out.println("\t1-SBI\t\t\t2-ICICI");
					System.out.print("\tSelect your Bank:");
					int selectBank=Integer.parseInt(sc.nextLine());
					String verifyPin="";
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
					String sel="select User_Name,Password,SBI_PIN,ICICI_PIN from users";
					PreparedStatement ps=con.prepareStatement(sel);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						if(rs.getString(1).equals(User.dbUser)&&rs.getString(2).equals(User.dbPass))
						{
							dbSbiPin=rs.getString(3);
							dbIciciPin=rs.getString(4);
							break;
						}
					}
					if(selectBank==1)
					{
						if(dbSbiPin.equals("0"))
						{
							System.out.println(Colors.red+"\tSorry you don't have any SBI Account Linked For this account."+Colors.reset);
						}
						else
						{
						int c=4;
						System.out.println(Colors.purple+"\tTotal payable amount is:"+amount);
						while(c>0)
						{
							boolean validInput = false;
					        while (!validInput) 
					        {
					            System.out.println(Colors.blue+"Enter your 4-digit Transaction Pin to complete payment");
					            System.out.print("Transaction Pin: ");
					            String enteredPin = sc.nextLine();
					            // Check if length is 4
					            if (enteredPin.length() != 4) 
					            {
					                System.out.println(Colors.red+"\tPlease enter 4 digits only"+Colors.reset);
					            } 
					            else 
					            {
					                // Check if all characters are digits
					                boolean isNumeric = true;
					                for (int i = 0; i < enteredPin.length(); i++) 
					                {
					                    if (!Character.isDigit(enteredPin.charAt(i))) 
					                    {
					                        isNumeric = false;
					                        break;
					                    }
					                }
					                if (isNumeric) 
					                {
					                    verifyPin = enteredPin;
					                    validInput = true;
					                } 
					                else 
					                {
					                    System.out.println(Colors.red+bold+"\tPlease enter only numerical digits!!"+Colors.reset);
					                    
					                }
					            }
					        }
							System.out.print(Colors.green+".......Verifying your PIN");
							loading();
							Account obj=new Account();
							if(verifyPin.equals(obj.getSBI_PIN())||verifyPin.equals(dbSbiPin))
							{
								System.out.println(green+bold+"\n......PIN Verified Successfully......"+reset);
								obj.wallet=obj.wallet-amount;
								subPlan=amount;
								System.out.println(green+blink+"....Your Transaction is Successful..."+reset);
								// Generate unique transaction Id..
								long transactionId=1000000000l+(long)(Math.random()*8999999999l);		
								System.out.println(green+"Transaction ID:"+transactionId);
								Date d=new Date();
								// System.out.println(d);
								SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy"); 
								String s=sdf.format(d);
								// To update startDate.
								try 
								{
            						// Convert string to date
            						startDate = sdf.parse(s);
            						//System.out.println("Date object: " + date);
        						}
        						catch (ParseException e) 
        						{
            						System.out.println("Invalid date format: " + e.getMessage());
        						}
								System.out.println(blue+bold+blink+"Date :"+s);
								subInsert(User.dbUser,transactionId,amount);
								animation();
								System.out.println(blue+"\nRedirecting to Main Menu....."+reset);
								selection();
								break;

							}
							else  
							{
								System.out.println(red+bold+"\nYou have Enterd wrong Transaction Pin!!..");
								System.out.println(blink+"Please Enter Correct Transaction Pin!!.. ");
								c--;
								System.out.println(blink+"You Have Remaining "+c+" Attempts!!.."+reset);
								
							}
						}
						if(c==0)
						{
							System.out.println(red+bold+blink+".......Transaction Cancelled!!....."+reset);
							while(true)
							{
								try
								{
								System.out.println(cyan+"\n\t\t1.Try Again\t\t2.Exit");
								System.out.print("\t---->");
								int userChoice=Integer.parseInt(sc.nextLine());
								if(userChoice==1)
								{
									payment(amount);
									break;
								}
								else if(userChoice==2) 
								{
									exit();
									break;
								}
								else 
								{
									System.out.println(red+"\tEnter a valid Input..."+reset);
								}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
						}
						break;
						}					

					}
					else if(selectBank==2)
					{
						if(dbIciciPin.equals("0"))
						{
							System.out.println(red+"Sorry you don't have any ICICI Account Linked For this account."+reset);
						}
						else
						{
						int c=4;
						System.out.println(Colors.purple+"\tTotal payable amount is:"+amount);
						while(c>0)
						{
							boolean b=true;
							while(b)
							{
								System.out.println(Colors.blue+"Enter your 4-digit Transaction Pin to complete payment");
					            System.out.print("Transaction Pin: ");
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
											System.out.println(red+"\tPlease Enter only Numerical Digits!!"+red);
											b=true;
											break;
										}
									}
								}
								else 
								{
									System.out.println(Colors.red+"\tPlease enter 4 digits only"+Colors.reset);
								}
							}
							System.out.print(green+".......Verifying your PIN");
							loading();
							Account obj=new Account();
							if(verifyPin.equals(obj.getICICI_PIN())||verifyPin.equals(dbIciciPin))
							{
								System.out.println(green+bold+"\n......PIN Verified Successfully......"+reset);
								obj.wallet=obj.wallet-amount;
								subPlan=amount;
								System.out.println(green+blink+"....Your Transaction is Successful..."+reset);
								// Generate unique transaction Id..
								long transactionId=1000000000l+(long)(Math.random()*8999999999l);		
								System.out.println(green+"Transaction ID:"+transactionId);
								Date d=new Date();
								// System.out.println(d);
								SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy"); 
								String s=sdf.format(d);
								// To update startDate.
								try 
								{
            						// Convert string to date
            						startDate = sdf.parse(s);
            						//System.out.println("Date object: " + date);
        						}
        						catch (ParseException e) 
        						{
            						System.out.println("Invalid date format: " + e.getMessage());
        						}
								System.out.println(green+"Date :"+s);
								subInsert(User.dbUser,transactionId,amount);
								animation();
								System.out.println(blue+"\nRedirecting to Main Menu....."+reset);
								selection();
								break;
							}
							else  
							{
								System.out.println(red+bold+"\nYou have Enterd wrong Transaction Pin!!..");
								System.out.println(blink+"Please Enter Correct Transaction Pin!!.. ");
								c--;
								System.out.println(blink+"You Have Remaining "+c+" Attempts!!.."+reset);
								
							}
						}
						if(c==0)
						{
							System.out.println(red+bold+blink+".......Transaction Cancelled!!....."+reset);
							while(true)
							{
								try
								{
								System.out.println(cyan+"\n\t\t1.Try Again\t\t2.Exit");
								System.out.print("\t---->");
								int userChoice=Integer.parseInt(sc.nextLine());
								if(userChoice==1)
								{
									payment(amount);
									break;
								}
								else if(userChoice==2) 
								{
									exit();
									break;
								}
								else 
								{
									System.out.println(red+"\tEnter a valid Input..."+reset);
								}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
						}
						break;
						}
						
					}
					else  
					{
						System.out.println(red+blink+bold+"Please Select a Valid Bank!!.. "+reset);
					}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
						
					}
				}
				break;
			}
			else if(ch==2)
			{
				payment(amount);
				break;
			}
			else 
			{
				System.out.println(red+bold+"Invalid choice Please select valid choice!!"+reset);
			}
		}
		catch(NumberFormatException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
		}
		}
	}
	//Google pay payment method.
	public static void googlePay(double amount)throws SQLException
	{
		try
		{
				System.out.println(blue+bold+"");
			    System.out.println("\t\t\t\t##   ##  #######  ####       ####    #####   ##   ##  #######            # #####  #####            ");Thread.sleep(500);
		        System.out.println("\t\t\t\t##   ##   ##   #   ##       ##  ##  ### ###  ### ###   ##   #           ## ## ## ### ###           ");Thread.sleep(500);
		        System.out.println("\t\t\t\t##   ##   ##       ##      ##       ##   ##  #######   ##                  ##    ##   ##           ");Thread.sleep(500);
		        System.out.println("\t\t\t\t## # ##   ####     ##      ##       ##   ##  ## # ##   ####                ##    ##   ##           ");Thread.sleep(500);
		        System.out.println("\t\t\t\t#######   ##       ##      ##       ##   ##  ##   ##   ##                  ##    ##   ##           ");Thread.sleep(500);
		        System.out.println("\t\t\t\t### ###   ##   #   ##  ##   ##  ##  ### ###  ##   ##   ##   #              ##    ### ###           ");Thread.sleep(500);
		        System.out.println("\t\t\t\t##   ##  #######  #######    ####    #####   ### ###  #######             ####    #####            ");Thread.sleep(500);
		        System.out.println("\t\t\t\t                                                                                                    ");Thread.sleep(500);
		        System.out.println("\t\t\t\t #####    #####    #####    #####   ####     #######           ######     ###    ###  ###          ");Thread.sleep(500);
		        System.out.println("\t\t\t\t##   ##  ### ###  ### ###  ##   ##   ##       ##   #            ##  ##   ## ##    ##  ##           ");Thread.sleep(500);
		        System.out.println("\t\t\t\t##       ##   ##  ##   ##  ##        ##       ##                ##  ##  ##   ##    ####            ");Thread.sleep(500);
		        System.out.println("\t\t\t\t## ####  ##   ##  ##   ##  ## ####   ##       ####              #####   ##   ##     ##             ");Thread.sleep(500);
		        System.out.println("\t\t\t\t##   ##  ##   ##  ##   ##  ##   ##   ##       ##                ##      #######     ##             ");Thread.sleep(500);
		        System.out.println("\t\t\t\t##   ##  ### ###  ### ###  ##   ##   ##  ##   ##   #            ##      ##   ##     ##             ");Thread.sleep(500);
		        System.out.println("\t\t\t\t #####    #####    #####    #####   #######  #######           ####     ##   ##    ####            "+reset);Thread.sleep(500);
 
		}
		catch(InterruptedException e){}
		System.out.println(Colors.yellow+"\tYour plan amount is:"+amount);
		while(true)
		{
			try
			{
			System.out.println(Colors.cyan+"\n\tPress 1 to continue payment\n\tPress 2 to Goback");
			System.out.print("\t--->");
			int ch=Integer.parseInt(sc.nextLine());
			if(ch==1)
			{
				while(true)
				{
					try
					{
					System.out.println(Colors.cyan+"\n\t\tSelect your Bank");
					System.out.println("\t1-SBI\t\t\t2-ICICI");
					System.out.print("\tSelect your Bank:");
					int selectBank=Integer.parseInt(sc.nextLine());
					String verifyPin="";
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
					String sel="select User_Name,Password,SBI_PIN,ICICI_PIN from users";
					PreparedStatement ps=con.prepareStatement(sel);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						if(rs.getString(1).equals(User.dbUser)&&rs.getString(2).equals(User.dbPass))
						{
							dbSbiPin=rs.getString(3);
							dbIciciPin=rs.getString(4);
							break;
						}
					}
					if(selectBank==1)
					{
						if(dbSbiPin.equals("0"))
						{
							System.out.println(red+"\tSorry you don't have any SBI Account Linked For this account."+reset);
						}
						else
						{
						int c=4;
						System.out.println(Colors.purple+"\tTotal payable amount is:"+amount);
						while(c>0)
						{
							boolean validInput = false;
					        while (!validInput) 
					        {
					            System.out.println(blue+"Enter your 4-digit Transaction Pin to complete payment");
					            System.out.print("Transaction Pin: ");
					            String enteredPin = sc.nextLine();
					            // Check if length is 4
					            if (enteredPin.length() != 4) 
					            {
					            	 System.out.println(Colors.red+"\tPlease enter 4 digits only"+Colors.reset);
					            } 
					            else 
					            {
					                // Check if all characters are digits
					                boolean isNumeric = true;
					                for (int i = 0; i < enteredPin.length(); i++) 
					                {
					                    if (!Character.isDigit(enteredPin.charAt(i))) 
					                    {
					                        isNumeric = false;
					                        break;
					                    }
					                }
					                if (isNumeric) 
					                {
					                    verifyPin = enteredPin;
					                    validInput = true;
					                } 
					                else 
					                {
					                    System.out.println(red+"\tPlease enter only numerical digits!!"+reset);
					                }
					            }
					        }
							System.out.print(green+".......Verifying your PIN");
							loading();
							Account obj=new Account();
							if(verifyPin.equals(obj.getSBI_PIN())||verifyPin.equals(dbSbiPin))
							{
								System.out.println(green+bold+"\n......PIN Verified Successfully......"+reset);
								obj.wallet=obj.wallet-amount;
								subPlan=amount;
								System.out.println(green+blink+"....Your Transaction is Successful..."+reset);
								// Generate unique transaction Id..
								long transactionId=1000000000l+(long)(Math.random()*8999999999l);		
								System.out.println(green+"Transaction ID:"+transactionId);
								Date d=new Date();
								// System.out.println(d);
								SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy"); 
								String s=sdf.format(d);
								// To update startDate.
								try 
								{
            						// Convert string to date
            						startDate = sdf.parse(s);
            						//System.out.println("Date object: " + date);
        						}
        						catch (ParseException e) 
        						{
            						System.out.println("Invalid date format: " + e.getMessage());
        						}
								System.out.println("Date :"+s);
								subInsert(User.dbUser,transactionId,amount);
								animation();
								System.out.println(blue+"\nRedirecting to Main Menu....."+reset);
								selection();
								break;

							}
							else  
							{
								System.out.println(red+bold+"\nYou have Enterd wrong Transaction Pin!!..");
								System.out.println(blink+"Please Enter Correct Transaction Pin!!.. ");
								c--;
								System.out.println(blink+"You Have Remaining "+c+" Attempts!!.."+reset);
								
							}
						}
						if(c==0)
						{
							System.out.println(red+bold+blink+".......Transaction Cancelled!!....."+reset);
							while(true)
							{
								try
								{
								System.out.println(cyan+"\n\t\t1.Try Again\t\t2.Exit");
								System.out.print("\t---->");
								int userChoice=Integer.parseInt(sc.nextLine());
								if(userChoice==1)
								{
									payment(amount);
									break;
								}
								else if(userChoice==2) 
								{
									exit();
									break;
								}
								else 
								{
									System.out.println(red+"\tEnter a valid Input..."+reset);
								}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
						}
						break;
						}						

					}
					else if(selectBank==2)
					{
						if(dbIciciPin.equals("0"))
						{
							System.out.println(red+"Sorry you don't have any ICICI Account Linked For this account.");
						}
						else
						{
						int c=4;
						System.out.println(Colors.purple+"\tTotal payable amount is:"+amount);
						while(c>0)
						{
							boolean b=true;
							while(b)
							{
								System.out.println(blue+"Enter your 4 digit Transaction Pin to complete payment");
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
											System.out.println(red+"\tPlease Enter only Numerical Digits!!"+reset);
											b=true;
											break;
										}
									}
								}
								else 
								{
									System.out.println(red+"\tPlease Enter only 4 digit pin!!"+reset);
								}
							}
							System.out.print(green+".......Verifying your PIN");
							loading();
							Account obj=new Account();
							if(verifyPin.equals(obj.getICICI_PIN())||verifyPin.equals(dbIciciPin))
							{
								System.out.println(green+bold+"\n......PIN Verified Successfully......"+reset);
								obj.wallet=obj.wallet-amount;
								subPlan=amount;
								System.out.println(green+blink+"....Your Transaction is Successful..."+reset);
								// Generate unique transaction Id..
								long transactionId=1000000000l+(long)(Math.random()*8999999999l);		
								System.out.println(green+"Transaction ID:"+transactionId);
								Date d=new Date();
								// System.out.println(d);
								SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy"); 
								String s=sdf.format(d);
								// To update startDate.
								try 
								{
            						// Convert string to date
            						startDate = sdf.parse(s);
            						//System.out.println("Date object: " + date);
        						}
        						catch (ParseException e) 
        						{
            						System.out.println("Invalid date format: " + e.getMessage());
        						}
								System.out.println("Date :"+s);
								subInsert(User.dbUser,transactionId,amount);
								animation();
								System.out.println(blue+"\nRedirecting to Main Menu....."+reset);
								selection();
								break;

							}
							else  
							{
								System.out.println(red+bold+"\nYou have Enterd wrong Transaction Pin!!..");
								System.out.println(blink+"Please Enter Correct Transaction Pin!!.. ");
								c--;
								System.out.println(blink+"You Have Remaining "+c+" Attempts!!.."+reset);
								
							}
						}
						if(c==0)
						{
							System.out.println(red+bold+blink+".......Transaction Cancelled!!....."+reset);
							while(true)
							{
								try
								{
								System.out.println(cyan+"\n\t\t1.Try Again\t\t2.Exit");
								System.out.print("\t---->");
								int userChoice=Integer.parseInt(sc.nextLine());
								if(userChoice==1)
								{
									payment(amount);
									break;
								}
								else if(userChoice==2) 
								{
									exit();
									break;
								}
								else 
								{
									System.out.println(red+"\tEnter a valid Input..."+reset);
								}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
						}
						break;
						}
					}
					else  
					{
						System.out.println(red+bold+blink+"Please Select a Valid Bank!!. "+reset);
					}
				}
				catch(NumberFormatException e) {
					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
				}
				}
				break;
			}
			else if(ch==2)
			{
				payment(amount);
				break;
			}
			else 
			{
				System.out.println(red+"\tInvalid choice Please select valid choice!!"+reset);
			}
		}
		catch(NumberFormatException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
		}
		}
	}
	static void subInsert(String name,long tId,double plan) throws SQLException
	{		
		String s1="";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
		if(plan==199)
			s1="insert into subscriptions(User_Name,TransactionId,Date_Of_Transaction,Time_Of_Transaction,Plan_Amount,Plan_Start_Date,Plan_End_Date)values(?,?,current_date(),current_time(),?,current_date(),DATE_ADD(current_date(), INTERVAL 1 MONTH));";
		else if(plan==499)
			s1="insert into subscriptions(User_Name,TransactionId,Date_Of_Transaction,Time_Of_Transaction,Plan_Amount,Plan_Start_Date,Plan_End_Date)values(?,?,current_date(),current_time(),?,current_date(),DATE_ADD(current_date(), INTERVAL 3 MONTH));";
		else if(plan==1099)
			s1="insert into subscriptions(User_Name,TransactionId,Date_Of_Transaction,Time_Of_Transaction,Plan_Amount,Plan_Start_Date,Plan_End_Date)values(?,?,current_date(),current_time(),?,current_date(),DATE_ADD(current_date(), INTERVAL 6 MONTH));";
		else if(plan==1899)
			s1="insert into subscriptions(User_Name,TransactionId,Date_Of_Transaction,Time_Of_Transaction,Plan_Amount,Plan_Start_Date,Plan_End_Date)values(?,?,current_date(),current_time(),?,current_date(),DATE_ADD(current_date(), INTERVAL 1 YEAR));";
		PreparedStatement ps=con.prepareStatement(s1);
		ps.setString(1, name);
		ps.setLong(2, tId);
		ps.setDouble(3, plan);
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	//Paytm payment Method.
	public static void paytm(double amount)throws SQLException,ClassCastException
	{
		try
		{
			System.out.println(cyan+bold+blink+"");
			System.out.println("\t\t\t\t##   ##  #######  ####       ####    #####   ##   ##  #######            # #####  #####            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t##   ##   ##   #   ##       ##  ##  ### ###  ### ###   ##   #           ## ## ## ### ###           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t##   ##   ##       ##      ##       ##   ##  #######   ##                  ##    ##   ##           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t## # ##   ####     ##      ##       ##   ##  ## # ##   ####                ##    ##   ##           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t#######   ##       ##      ##       ##   ##  ##   ##   ##                  ##    ##   ##           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t### ###   ##   #   ##  ##   ##  ##  ### ###  ##   ##   ##   #              ##    ### ###           ");Thread.sleep(500);
	        System.out.println("\t\t\t\t##   ##  #######  #######    ####    #####   ### ###  #######             ####    #####            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                                                                                                    ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                           ######     ###    ###  ###  ######  ##   ##                            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                            ##  ##   ## ##    ##  ##  ## ## ## ### ###                            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                            ##  ##  ##   ##    ####      ##    #######                            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                            #####   ##   ##     ##       ##    ## # ##                            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                            ##      #######     ##       ##    ##   ##                            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                            ##      ##   ##     ##       ##    ##   ##                            ");Thread.sleep(500);
	        System.out.println("\t\t\t\t                           ####     ##   ##    ####     ####   ##   ##                            "+reset);Thread.sleep(500);
 
		}
		catch(InterruptedException e){}
		System.out.println(Colors.yellow+"\tYour plan amount is:"+amount);
		while(true)
		{
			try
			{
			System.out.println(Colors.cyan+"\n\tPress 1 to continue payment\n\tPress 2 to Goback");
			System.out.print("\t--->");
			int ch=Integer.parseInt(sc.nextLine());
			if(ch==1)
			{
				while(true)
				{
					try
					{
					System.out.println(Colors.cyan+"\n\t\tSelect your Bank");
					System.out.println("\t1-SBI\t\t\t2-ICICI");
					System.out.print("\tSelect your Bank:");
					int selectBank=Integer.parseInt(sc.nextLine());
					String verifyPin="";
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ott","root","Mahesh@17");
					String sel="select User_Name,Password,SBI_PIN,ICICI_PIN from users";
					PreparedStatement ps=con.prepareStatement(sel);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						if(rs.getString(1).equals(User.dbUser)&&rs.getString(2).equals(User.dbPass))
						{
							dbSbiPin=rs.getString(3);
							dbIciciPin=rs.getString(4);
							break;
						}
					}
					if(selectBank==1)
					{
						if(dbSbiPin.equals("0"))
						{
							System.out.println(red+"Sorry you don't have any SBI Account Linked For this account."+reset);
						}
						else
						{
						int c=4;
						System.out.println(Colors.purple+"\tTotal payable amount is:"+amount);
						while(c>0)
						{
							boolean validInput = false;
					        while (!validInput) 
					        {
					            System.out.println(blue+"Enter your 4-digit Transaction Pin to complete payment");
					            System.out.print("Transaction Pin: ");
					            String enteredPin = sc.nextLine();
					            // Check if length is 4
					            if (enteredPin.length() != 4) 
					            {
					                System.out.println(red+"\tPlease enter 4 digits only"+reset);
					            } 
					            else 
					            {
					                // Check if all characters are digits
					                boolean isNumeric = true;
					                for (int i = 0; i < enteredPin.length(); i++) 
					                {
					                    if (!Character.isDigit(enteredPin.charAt(i))) 
					                    {
					                        isNumeric = false;
					                        break;
					                    }
					                }
					                if (isNumeric) 
					                {
					                    verifyPin = enteredPin;
					                    validInput = true;
					                } 
					                else 
					                {
					                    System.out.println(red+"\tPlease enter only numerical digits!!"+reset);
					                }
					            }
					        }
							System.out.print(green+".......Verifying your PIN");
							loading();
							Account obj=new Account();
							if(verifyPin.equals(obj.getSBI_PIN())||verifyPin.equals(dbSbiPin))
							{
								System.out.println(green+bold+"\n......PIN Verified Successfully......"+reset);
								obj.wallet=obj.wallet-amount;
								subPlan=amount;
								System.out.println(green+blink+"....Your Transaction is Successful..."+reset);
								// Generate unique transaction Id..
								long transactionId=1000000000l+(long)(Math.random()*8999999999l);		
								System.out.println(green+"Transaction ID:"+transactionId);
								Date d=new Date();
								// System.out.println(d);
								SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy"); 
								String s=sdf.format(d);
								// To update startDate.
								try 
								{
            						// Convert string to date
            						startDate = sdf.parse(s);
            						//System.out.println("Date object: " + date);
        						}
        						catch (ParseException e) 
        						{
            						System.out.println("Invalid date format: " + e.getMessage());
        						}
								System.out.println("Date :"+s);
								subInsert(User.dbUser,transactionId,amount);
								animation();
								System.out.println(blue+"\nRedirecting to Main Menu....."+reset);
								selection();
								break;

							}
							else  
							{
								System.out.println(red+bold+"\nYou have Enterd wrong Transaction Pin!!..");
								System.out.println(blink+"Please Enter Correct Transaction Pin!!.. ");
								c--;
								System.out.println(blink+"You Have Remaining "+c+" Attempts!!.."+reset);
								
							}
						}
						if(c==0)
						{
							System.out.println(red+bold+blink+".......Transaction Cancelled!!....."+reset);
							while(true)
							{
								try
								{
								System.out.println(cyan+"\n\t\t1.Try Again\t\t2.Exit");
								System.out.print("\t---->");
								int userChoice=Integer.parseInt(sc.nextLine());
								if(userChoice==1)
								{
									payment(amount);
									break;
								}
								else if(userChoice==2) 
								{
									exit();
									break;
								}
								else 
								{
									System.out.println(red+"\tEnter a valid Input..."+reset);
								}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
						}
						break;
						}

					}
					else if(selectBank==2)
					{
						if(dbIciciPin.equals("0"))
						{
							System.out.println(red+"Sorry you don't have any ICICI Account Linked For this account."+reset);
						}
						else
						{
						int c=4;
						System.out.println(yellow+"\tTotal payable amount is:"+amount);
						while(c>0)
						{
							boolean b=true;
							while(b)
							{
								System.out.println(blue+"Enter your 4 digit Transaction Pin to complete payment");
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
											System.out.println(red+"\tPlease Enter only Numerical Digits!!"+reset);
											b=true;
											break;
										}
									}
								}
								else 
								{
									System.out.println(red+"Please Enter only 4 digit pin!!"+reset);
								}
							}
							System.out.print(green+".......Verifying your PIN");
							loading();
							Account obj=new Account();
							if(verifyPin.equals(obj.getICICI_PIN())||verifyPin.equals(dbIciciPin))
							{
								System.out.println(green+bold+"\n......PIN Verified Successfully......"+reset);
								obj.wallet=obj.wallet-amount;
								subPlan=amount;
								System.out.println(green+blink+"....Your Transaction is Successful..."+reset);
								// Generate unique transaction Id..
								long transactionId=1000000000l+(long)(Math.random()*8999999999l);		
								System.out.println(green+"Transaction ID:"+transactionId);
								Date d=new Date();
								// System.out.println(d);
								SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy"); 
								String s=sdf.format(d);
								// To update startDate.
								try 
								{
            						// Convert string to date
            						startDate = sdf.parse(s);
            						//System.out.println("Date object: " + date);
        						}
        						catch (ParseException e) 
        						{
            						System.out.println("Invalid date format: " + e.getMessage());
        						}
								System.out.println("Date :"+s);
								subInsert(User.dbUser,transactionId,amount);
								animation();
								System.out.println(blue+"\nRedirecting to Main Menu....."+reset);
								selection();
								break;

							}
							else  
							{
								System.out.println(red+bold+"\nYou have Enterd wrong Transaction Pin!!..");
								System.out.println(blink+"Please Enter Correct Transaction Pin!!.. ");
								c--;
								System.out.println(blink+"You Have Remaining "+c+" Attempts!!.."+reset);
								
							}
						}
						if(c==0)
						{
							System.out.println(red+bold+blink+".......Transaction Cancelled!!....."+reset);
							while(true)
							{
								try
								{
								System.out.println(cyan+"\n\t\t1.Try Again\t\t2.Exit");
								System.out.print("\t---->");
								int userChoice=Integer.parseInt(sc.nextLine());
								if(userChoice==1)
								{
									payment(amount);
									break;
								}
								else if(userChoice==2) 
								{
									exit();
									break;
								}
								else 
								{
									System.out.println(red+"\tEnter a valid Input..."+reset);
								}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
						}
						break;
						}
					}
					else  
					{
						System.out.println(red+bold+blink+"Please Select a Valid Bank!!. "+reset);
					}
				}
				catch(NumberFormatException e) {
					System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
				}
				}
				break;
			}
			else if(ch==2)
			{
				payment(amount);
				break;
			}
			else 
			{
				System.out.println(red+blink+bold+"\tInvalid choice Please select valid choice!!"+reset);
			}
			}
			catch(NumberFormatException e) {
				System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
			}
		}
	}

	
	
}