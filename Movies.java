package project;

import java.sql.*;
import java.util.InputMismatchException;

public class Movies extends Colors implements MovieInterface
{
	AmazonPrime obj =new AmazonPrime();
	public void displayMoviesHistory() throws SQLException
	{
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ott", "root", "Mahesh@17");
		 String s1="Select * from "+User.dbUser+"Movies;";
		 PreparedStatement ps=con.prepareStatement(s1);
		 ResultSet rs=ps.executeQuery();
		 System.out.println(cyan+bold+"\t\t\tYour Movies watch History");
		 while(rs.next())
		{
			System.out.println(blue+bold+"\t\t\t"+rs.getInt("No")+" "+rs.getString("Movie_Name")+reset);
		}

	}
	public void dbMovieInsert(String k) throws SQLException 
	{
	    // Establish a connection to the MySQL database
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ott", "root", "Mahesh@17");
	    
	    // Creating a table if it doesn't already exist
	    String createTableQuery = "CREATE TABLE IF NOT EXISTS "+User.dbUser+"Movies  (No INT AUTO_INCREMENT PRIMARY KEY, Movie_Name VARCHAR(100));";
	                              
	    try (PreparedStatement psCreate = con.prepareStatement(createTableQuery))
	    {
	        psCreate.executeUpdate();
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while creating table: " + e.getMessage());
	    }

	    // Inserting the movie name into the newly created table
	    String insertQuery = "INSERT INTO "+User.dbUser+"Movies (Movie_Name) VALUES (?);";
	    try (PreparedStatement psInsert = con.prepareStatement(insertQuery))
	    {
	        psInsert.setString(1, k);
	        int rowsInserted = psInsert.executeUpdate();
	        //System.out.println(rowsInserted + " record(s) inserted");
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while inserting record: " + e.getMessage());
	    }
	    finally
	    {
	        // Closing the connection
	        if (con != null) {
	            con.close();
	        }
	    }
	}

	public void TeluguMovies() throws SQLException
	{
		try
		{
		System.out.println(Colors.blue+bold+"Telugu Movies Available"+Colors.reset);
		System.out.println(Colors.green+bold+"\n1-RRR\n2-BAAHUBALI PART1\n3-KALKI\n4-DEVERA\n5-GABBER SINGH\n6-PUSHPA\n7-JAWAN\n8-RANGASTALAM\n9-KGF\n10-SALAAR\n");
		System.out.print(Colors.blue+bold+"Enter The Movie Name:");
		String moviename=sc.nextLine();						//Taking the User Input.
		String noSpacesStr = moviename.replaceAll("\\s", "");
		if(AmazonPrime.subPlan>0)
		{
			if(noSpacesStr.equalsIgnoreCase("RRR"))
			{
				try
				{
					String k="RRR";
					dbMovieInsert(k);
		   			System.out.print(cyan+"Movie NAME\t:\t");
		   			Colors.movieLoadingAnimation(k);
		      		System.out.println("");
		      		Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tS.S.RAJAMOULI\nCINEMATOGRAPHY\t:\tK.K.SENTHI KUMAR\nPRODUCER\t:\tD.V.V.DANAYYA AND M.M.SRIVALLI");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tNTR,RAM CHARAN\nFEMALE ACTOR\t:\tALIA BHATT");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tRAJEEV KANAKALA,RAHUL RAMAKRISHNA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tRRR IS A 2022 INDIAN ACTION DRAMA FIL ABOUT TWO INDIAN REVOLUTIONARIES ,ALLURI SIRARAMARAJU AND KOMARAM BHEEM ,WHO FIGHT AGAINST THE BRITISH RAJ IN THE 1920s.\n\t\t\tTHE FILM IS SET IN PRE-INDEPENDENT INDIA AND IS BASED ON A FICTIONAL STORY THAT INCORPORATES REAL EVENTS."+reset);
		      	
		      	}
		      	catch(Exception e){}
		      	System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}					      	
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
		      	
		   }	
			else if(noSpacesStr.equalsIgnoreCase("BAAHUBALIPART1"))
			{
				try
				{
					String k="BAAHUBALI-THE BEGINNING";
					dbMovieInsert(k);
		   			System.out.print(cyan+"Movie NAME\t:\t");
		   			Colors.movieLoadingAnimation(k);
		      		System.out.println("");
					Thread.sleep(600);
					System.out.println("DIRECTOR\t:\tS.S.RAJAMOULI\nCINEMATOGRAPHY\t:\tSENTIKUMAR\nPRODUCER\t:\tK.RAHAVENDRA RAO");
					Thread.sleep(600);
					System.out.println("MALE ACTOR\t:\tPRABHAS\nFEMALE ACTOR\t:\tANUSHAKA SETTY");
					Thread.sleep(600);
					System.out.println("SIDE ROLES\t:\tTAMANNA,RAMYA KRISHNA,SATYARAJ,TANIKELLA BHARANI");
					Thread.sleep(600);
					System.out.println("SUMMARY\t\t:\tIN THE KINGDOM OF MAHISHMATI,WHILE PURSUING HIS LOVE,SHIVUDU LEARNS ABOUT THE CONFLICT RIDDEN PAST OF HIS FAMILY AND HIS LEGACY.\n\t\t\tHE MUST NOW PREPARE HIMSELF TO FACE HIS NEWFOUND ARCH-ENEMY."+reset);
			
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Displaying Movie History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("KALKI"))
			{
				try 
				{
					String k="KALKI 2898AD";
					dbMovieInsert(k);
					System.out.print(cyan+"M0VIE NAME\t:\t");
					movieLoadingAnimation(k);
		      		System.out.println("");
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tNAG ASHWIN\nCINEMATOGRAPHY\t:\tDJORDJE STAIJKOVIC\nPRODUCER\t:\tASHWANI DUTT");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tPRABHAS\nFEMALE ACTOR\t:\tDEEPIKA PODUKONE");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tANNABEN,PASUPATHI,S.S.RAJAMOULI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA MODERN AVATAR OF THE HINDU GOD VISHNU ,IS SAID TO HAVE DESCENDED ON EARTH TO PROTECT THE WORLD FROM EVIL FORCES."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Displaying Movie History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}

			}
			else if(noSpacesStr.equalsIgnoreCase("DEVARA"))
			{
				try
				{
					String k="DEVARA PART1";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
			      	System.out.println("");
			      	Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tKORATALA SHIVA\nCINEMATOGRAPHY\t:\tR.RATNAVELU\nPRODUCER\t:\tNANDAMURI KALYAN RAM");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tNTR\nFEMALE ACTOR\t:\tJANHI KAPOOR");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tPRAKASH RAJ,MEKASRIKAN,CHAIRA ROY");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tWEAPONS RECITE THE STORY OF ONE MAN AND TERRIFYING TALE."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display watch history.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("GABBERSINGH"))
			{
				try
				{
					String k="GABBER SINGH";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
			      	System.out.println("");
			      	Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tHARISH SHANKAR\nCINEMATOGRAPHY\t:\tJAYANAN VINCENT\nPRODUCER\t:\tBANDLA GANESH");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tPAVAN KALYAN\nFEMALE ACTOR\t:\tSHURTHI HASAN");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSUBHASHINI,TANIKELLA BHARANI,AJAY");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tINSPIRED A FILM CHARACTER,VENKATARATNAM,A POLICEMAN,CALLS HIMSELF GABBAR SINGH.HE IS POSTED IN A VILLAGE \n\t\t\tWHERE A LOCAL THUG WANTS TO JOIN POLITICS AND ASLO LURES HIS STEPBROTHER TO JOIN HIM."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display watch history.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("PUSHPA"))
			{
				try
				{
					String k="PUSHPA-THE RISE";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
			      	System.out.println("");
			      	Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tSUKUMAR\nCINEMATOGRAPHY\t:\tMIROSLAW BROZEK\nPRODUCER\t:\tNAVEEN YERNENI,YALAMENCHALI RAVI SHANKAR");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tALLU ARJUN\nFEMALE ACTOR\t:\tRASMIKA MANDANNA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSAMANTHA.ANASUYA BHARADWAJ,SUNIL");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA LABOUR NAMED PUSHPA MAKES ENEMIES AS HE RISES IN THE WORLD OF RED SANDALWOOD SMUGGLING.HOWEVER,VIOLENCE ERUPTS \n\t\t\tWHEN THE POLICE ATTEMPT TO BRING DOWN HIS LEAGAL BUSINESS"+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display watch history.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}	
			else if(noSpacesStr.equalsIgnoreCase("JAWAN"))
			{
				try
				{
					String k="JAWAN";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
			      	System.out.println("");
			      	Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tATLEE KUMAR\nCINEMATOGRAPHY\t:\tG.K.VISHNU\nPRODUCER\t:\tGAURIKHAN,GAURAV VERMA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSHAH RUKH KHAN\nFEMALE ACTOR\t:\tNAYANATHARA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tDEEPIKA PODUKUNE,PRIYAMANI,GIRIJA OAK,YOGI BABU");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA MAN IS DRIVEN BY A PERSONAL VENDETTA TO RECTIFY THE WORNGS IN SOCIETY,WHILE KEEPING A PROMISE MADE YEARS AGO.\n\t\t\tHE COMES UP AGAINST A MONSTROUS OUTLAW WITH NO FEAR,WHO CAUSED EXTREME SUFFERING TO MANY."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display watch history.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("RANGASTALAM"))
			{
				try
				{
					String k="RANGASTALAM";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
			      	System.out.println("");
			      	Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tSUKUMAR BANDREDDI\nCINEMATOGRAPHY\t:\tR.RATNAVELU\nPRODUCER\t:\tMOHAN CHERUKURI,NEVEEN YERNENI");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tRAM CHARAN\nFEMALE ACTOR\t:\tSAMANTHA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tAADHI,ANASUYA BHARADWAJ,JAGAPATHI BABU");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tCHITTI BABU IS A HAPPY-GO-LUCKY MAN WHO HAS A HEARING DISABILITY.HIS BROTHER KUMAR BABU RETURNS FROM DUBAI \n\t\t\tONLY TO SEE THAT NOTHING IN THE VILLAGE HAS CHANGED,SO HE DECIDES TO GO UP AGAINST THE DREADED PRESIDENT."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display watch history.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("KGF"))
			{
				try
				{
					String k="KGF-CHAPTER1";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t"); 
					movieLoadingAnimation(k);
			      	System.out.println("");
			      	Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tPRASANTH NEEL\nCINEMATOGRAPHY\t:\tBHUVAN GOWDA\nPRODUCER\t:\tVIJAY KIRAGANDHUR");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tYASH\nFEMALE ACTOR\t:\tSRINIDHI SHETTY");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tRAMACHANDRA RAJU,ACHYUTH KUMAR,SRINIVASA MURTHY");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tROCKEY,A YOUNG MAN,SEEKS POWER WEALTHIN ORDER TO FULFIL A PROMISE TO HIS DYING MOTHER.HIS QUEST TAKES HIM TO MUMBAI,\n\t\t\tWHERE HE BECOMES INVOKED WITH THE NOTORIOUS GOLD MAFIA."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display watch history.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("SALAAR"))
			{
				try
				{
					String k="SALAAR PART1-CEASEFIRE";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
			      	System.out.println("");
			      	Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tPRASANTH NEEL\nCINEMATOGRAPHY\t:\tBHUVAN GOWDA\nPRODUCER\t:\tK.V.RAMARAO");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tPRABHAS\nFEMALE ACTOR\t:\tSHURTHI HASAN");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tJAGAPATHI BABU,BRAMHAMAJI,JHANSI,SAPTHAGIRI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tJUST WHEN THE PRINCE OF KHANSAAR IS ABOUT TO RISE TO THE THRONE,A PLAN OF OVERTHROWING HIM IS EXERCISED AND ONLY ONE MAN CAN HELP HIM RETRIVE POWER."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							TeluguMovies();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display watch history.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else
			{
				System.out.println(red+"\tResult not found\nchoose a movie available from the list"+reset);
				TeluguMovies();
			}
		}
		else 
		{
			System.out.println(red+"\n\t\tSorry You Don't Have Any Subscription Plan. "+reset);
			System.out.println(yellow+"Please Select a valid Subscription plan to Watch movies and series"+reset);
			obj.subscriptionPlans();
		}
		}
		catch(InputMismatchException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset+""+e);
			TeluguMovies();
		}
	}
	public void HindiMovies() throws SQLException
	{
		try
		{
		System.out.println(blue+"Hindi Movies Available:");
		System.out.println(green+"\n1-STREET 2\n2-DUNKI\n3-PATHAAN\n4-DABANGG\n5-SULTAN\n6-12th FAIL\n7-DANGAL\n8-3 IDIOTS\n9-TALVAR\n10-ROCK ON\n");
		System.out.print(purple+"Enter The Movie Name:");
		String moviename=sc.nextLine();						//Taking the User Input.
		String noSpacesStr = moviename.replaceAll("\\s", "");
		if(obj.subPlan>0)
		{
			if(noSpacesStr.equalsIgnoreCase("STREET2"))
			{
				try
				{
					String k="STREET-2";
					dbMovieInsert(k);
					System.out.print(cyan+"Movie NAME\t:\t");
					movieLoadingAnimation(k);
			      	System.out.println("");
			      	Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tAMAR KAUSHIK\nCINEMATOGRAPHY\t:\tJISHNU BHATTOCHARJEE\nPRODUCER\t:\tMODDOCK FILMS");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tRAJKUMAR RAO\nFEMALE ACTOR\t:\tTAMANNAH BAHATIA,SHARDHA KAPOOR");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tANAYA SINGH,SUNITHA RAJWAR,PANKAJ TRIPATHI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTHE TOWN OF CHANDERI IS BEING HAUNTED AGAIN. THIS TIME, WOMEN ARE MYSTERIOUSLY ABDUTED BY A TERRIFYING HEADLESS ENTITY. ONCE AGAIN,\n\t\t\tIT'S UP TO VICKY AND HIS FRIENDS TO SAVE THEIR TOWN AND LOVED ONES."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}

			}
			else if(noSpacesStr.equalsIgnoreCase("DUNKI"))
			{
				try
				{
					String k="DUNKI";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println("");
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tRAJKUMAR HIRANI\nCINEMATOGRAPHY\t:\tC.K.MURALEEDHRN,AMIT ROY\nPRODUCER\t:\tJYOTHI DESHPANDE");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSHAH RUKH KHAN\nFEMALE ACTOR\t:\tTAAPSEE PANNU");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tDEVEN BHOJANI,SURINDERPAL SINGH,KETAN DESAI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA GROUP OF FRIENDS SET OUT ON A PERILOUS JOURNEY TO EMIGRATE TO THE UNITED KINGDOM VIA A CLANDESTINE ROUTE CALLED 'DONKEY FLIGHT',\n\t\t\tRISKING THEIR LIVES IN THE PROCESS."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("PATHAAN"))
			{
				try
				{
					String k="PATHAAN";
					dbMovieInsert(k);
					System.out.print(cyan+"M0VIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println("");
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tSIDDHARATH ANAND\nCINEMATOGRAPHY\t:\tSATCHITH PAULOSE\nPRODUCER\t:\tADITYA CHOPRA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSHAH RUKH KHAN\nFEMALE ACTOR\t:\tDEEPIKA PADUKONE");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSALMAN KHAN,DIMPLE KAPADIA,VIRAF PATEL");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA PAKISTANI GENERAL HIRES A PRIVATE TERROR OUTFIT TO CONDUCT ATTACKS IN INDIA WHILE PATHAAN, AN INDIAN SECRET AGENT, IS ON A MISSION TO FORM A SPECIAL UNIT."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("DABANGG"))
			{
				try
				{
					String k="DABANGG";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println("");
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tARBAAZ KHAN,PRABU DEVA\nCINEMATOGRAPHY\t:\tLALIT PANDIT\nPRODUCER\t:\tARBAAZ KHAN");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSALMAN KHAN\nFEMALE ACTOR\t:\tKARENNA KAPOOR,SAIEE MANJREKAR");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSONUSOOD,OMPUR,SONKSHI SINHA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTHE BIGGEST HIT OF HINDI CINEMA IN RECENT TIMES, THIS HIGH-VOLTAGE TONGUE-IN-CHEEK CRIME CAPER TELLS THE STORY OF CHULBUL PANDEY,\n\t\t\tAN UTTAR PRADESH COP WHO CALLS HIMSELF ROBIN HOOD PANDEY. CHULBUL DELIGHTS IN FLEXING HIS MUSCLES, PICKING FIGHTS AND CAUSING MAYHEM. INSTEAD OF ARRESTING VIOLENT THIEVES,\n\t\tCHULBUL HAPPILY ROBS THE ROBBERS, KEEPING THE MONEY LOCKED UP IN HIS MOTHER'S SAFE."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("SULTHAN"))
			{
				try
				{
					String k="SULTHAN";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tALI ABBAS ZAFAR\nCINEMATOGRAPHY\t:\tARTUR ZURAWSKI\nPRODUCER\t:\tYASH RAJ FILMS");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSALMAN KHAN\nFEMALE ACTOR\t:\tANUSHKA SHARMA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tRANDEEP HOODA,AMIT SADH");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tDETERMINED TO WIN HER RESPECT, SULTAN DEDICATES HIMSELF TO INTENSE TRAINING AND ULTIMATELY WINS A STATE-LEVEL WRESTLING TOURNAMENT, AND AARFA.\n\t\t\tTHEY EVENTUALLY GET MARRIED AND BECOME FAMOUS WRESTLERS, REPRESENTING INDIA IN VARIOUS INTERNATIONAL GAMES"+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("12thFAIL"))
			{
				try
				{
					String k="12th FAIL";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tVIDHU VINOD CHOPRA\nCINEMATOGRAPHY\t:\tRANGARAJAN RAMABADRAN\nPRODUCER\t:\tVIDHU VINOD CHOPRA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tVIKRANT MASSEY\nFEMALE ACTOR\t:\tMEDHA SHANKAR");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tGEETA AGRWAL,ANANT JOSHI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tIPS OFFICER MANOJ KUMAR SHARMA FEARLESSLY EMBRACES THE IDEA OF RESTARTING HIS ACADEMIC JOURNEY AND RECLAIMING HIS DESTINY \n\t\t\tAT A PLACE WHERE MILLIONS OF STUDENTS ATTEMPT THE WORLD'S TOUGHEST COMPETITIVE EXAM: UPSC."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}	
			else if(noSpacesStr.equalsIgnoreCase("DANGAL"))
			{
				try
				{
					String k="DANGAL";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tNITESH TIWARI\nCINEMATOGRAPHY\t:\tSATYAJIT PANDE\nPRODUCER\t:\tAAMIR KHAN,KIRAN RAO");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tAAMIR KHAN\nFEMALE ACTOR\t:\tSAKSHI TANWAR");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSANYA MALTHOTRA,FATIMA SANA SHAIKH,APARASHKI KHURANA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tMAHAVIR SINGH PHOGAT, A FORMER WRESTLER, DECIDES TO FULFIL HIS DREAM OF WINNING A GOLD MEDAL FOR HIS COUNTRY \n\t\t\tBY TRAINING HIS DAUGHTERS FOR THE COMMONWEALTH GAMES DESPITE THE EXISTING SOCIAL STIGMAS."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("3IDIOTS"))
			{
				try
				{
					String k="3-IDIOTS";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tRAJKUMAR HAIRANI\nCINEMATOGRAPHY\t:\tC.K.MURALEEDHARAN\nPRODUCER\t:\tVIDHU VINOD CHOPRA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tAAMIR KHAN\nFEMALE ACTOR\t:\tMONA SINGH");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tBOMAN IRANI,OMI VADIYA,RAHUL KUMAR");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tIN COLLEGE, FARHAN AND RAJU FORM A GREAT BOND WITH RANCHO DUE TO HIS POSITIVE AND REFRESHING OUTLOOK TO LIFE. \n\t\t\tYEARS LATER, A BET GIVES THEM A CHANCE TO LOOK FOR THEIR LONG-LOST FRIEND WHOSE EXISTENCE SEEMS RATHER ELUSIVE."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("TALVAR"))
			{
				try
				{
					String k="TALVAR";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tMEGHNA GULZAR\nCINEMATOGRAPHY\t:\tPANKAJ KUMAR\nPRODUCER\t:\tVISHAL BHARDWAJ");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tIRFAN KHAN\nFEMALE ACTOR\t:\tKANKANA SEN SHARMA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\t.AHARDENED COP DEALS WITH THREE CONFLICTING PERSPECTIVES INVOLVING A BRUTAL DOUBLE MURDER. \n\t\t\tTHE CASE IS COMPLICATED AS THE PRIME SUSPECTS ARE THE PARENTS WHO SUPPOSEDLY KILLED THEIR TEENAGE A DAUGHTER."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("ROCKON"))
			{
				try
				{
					String k="ROCK ON!!";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tABHISHEK KAPOOR\nCINEMATOGRAPHY\t:\tJASON WEST\nPRODUCER\t:\tABHISHEK KAPOOR");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tARAJUN RAMPAL\nFEMALE ACTOR\t:\tKOEL PURIE");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSAI GUNDEWAR,PRACHI DESAI,NICOLETTE BIRD");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tADITYA, JOE, KEDAR AND ROB FORM A ROCK BAND, BUT BREAK UP AFTER THEY FAIL TO MAKE A SUCCESS OF IT. \n\t\t\tTHEY ESTABLISH REGULAR LIVES UNTIL THEY DECIDE TO REUNITE AND TAKE ANOTHER SHOT AT FULFILLING THEIR DREAMS"+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							HindiMovies();			//calling Hindi movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History.
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else
			{
				System.out.println(red+"\tResult not found\nchoose a movie available from the list"+reset);
				HindiMovies();
			}
		}
		else 
		{
			System.out.println(red+"\t\tSorry You Don't Have Any Subscription Plan. "+reset);
			System.out.println(yellow+"Please Select a valid Subscription plan to Watch movies and series"+reset);
			obj.subscriptionPlans();
		}
		}
		catch(InputMismatchException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset+""+e);
			HindiMovies();
		}
	}
	public void EnglishMovies() throws SQLException
	{
		try
		{
		System.out.println(blue+"Movies Available");
		System.out.println(green+"\n1-GOD FATHER\n2-JOKER\n3-AVATAR\n4-THE HABBIT\n5-EVERST\n6-ESCAPE PLAN\n7-LEON\n8-THE UNION\n9-JACKPOT\n10-TRANSFORMERS\n");
		System.out.print(purple+"Enter The Movie Name:");
		String moviename=sc.nextLine();						//Taking the User Input.
		String noSpacesStr = moviename.replaceAll("\\s", "");
		if(obj.subPlan>0)
		{
			if(noSpacesStr.equalsIgnoreCase("GODFATHER"))
			{
				try
				{
					String k="GOD FATHER";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tFRANICS FORD COPPOLA\nCINEMATOGRAPHY\t:\tGORDON WILLIS\nPRODUCER\t:\tRUDDY");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tMICHAEL CORLENONE\nFEMALE ACTOR\t:\tDIANE KEATON");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tJOHN MARLEY,RICHARD CONTE,RUDY BOND");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tWIDELY REGARDED AS ONE OF THE GREATEST FILMS OF ALL TIME, THIS MOB DRAMA, BASED ON MARIO PUZO'S NOVEL OF THE SAME NAME,\n\t\t\tFOCUSES ON THE POWERFUL ITALIAN-AMERICAN CRIME FAMILY OF DON VITO CORLEONE (MARLON BRANDO). WHEN THE DON'S YOUNGEST SON, MICHAEL (AL PACINO), RELUCTANTLY JOINS THE MAFIA,\n\t\t HE BECOMES INVOLVED IN THE INEVITABLE CYCLE OF VIOLENCE AND BETRAYAL."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("JOKER"))
			{
				try
				{
					String k="JOKER";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tTODD PHILLIPS\nCINEMATOGRAPHY\t:\tLAWRENCE SHER\nPRODUCER\t:\tTODD PHILLIPS,COOPER");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tJOAQUIN\nFEMALE ACTOR\t:\tZAZIE BEETZ");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tARTHUR FLECK,PENNY FLECK,GENEUFLAND");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tFOREVER ALONE IN A CROWD, FAILED COMEDIAN ARTHUR FLECK SEEKS CONNECTION AS HE WALKS THE STREETS OF GOTHAM CITY.\n\t\t\tARTHUR WEARS TWO MASKS -- THE ONE HE PAINTS FOR HIS DAY JOB AS A CLOWN, AND THE GUISE HE PROJECTS IN A FUTILE ATTEMPT TO FEEL LIKE HE'S PART OF THE WORLD AROUND HIM"+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}

			}
			else if(noSpacesStr.equalsIgnoreCase("AVATHAR"))
			{
				try
				{
					String k="AVATHAR";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tJAMES CAMERON\nCINEMATOGRAPHY\t:\tMAURO FIORE\nPRODUCER\t:\tJON LANDAU");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tZOE SALDANA\nFEMALE ACTOR\t:\tJAKE SULLY,ZUKO");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tMILES SOCORRO,VARANG,PAYAKAN");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\t.ON THE LUSH ALIEN WORLD OF PANDORA LIVE THE NA'VI, BEINGS WHO APPEAR PRIMITIVE BUT ARE HIGHLY EVOLVED. BECAUSE THE PLANET'S ENVIRONMENT IS POISONOUS,\n\t\t\tHUMAN/NA'VI HYBRIDS, CALLED AVATARS, MUST LINK TO HUMAN MINDS TO ALLOW FOR FREE MOVEMENT ON PANDORA."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("THEHABBIT"))
			{
				try
				{
					String k="THE HABBIT";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("MOVIE NAME\t:\tTHE HABBIT");
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tPETER JACKSON\nCINEMATOGRAPHY\t:\tANDREW LESNIE\nPRODUCER\t:\tZANE WEINER,FRAN WALSH");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tBILBO BAGGINS\nFEMALE ACTOR\t:\tCATE BLACHETT,RUBY");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tBILBO BAGGINS,OIN,KILI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tBILBO BAGGINS (MARTIN FREEMAN) LIVES A SIMPLE LIFE WITH HIS FELLOW HOBBITS IN THE SHIRE, UNTIL THE WIZARD GANDALF (IAN MCKELLEN) ARRIVES AND CONVINCES\n\t\t\tHIM TO JOIN A GROUP OF DWARVES ON A QUEST TO RECLAIM THE KINGDOM OF EREBOR."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("EVEREST"))
			{
				try
				{
					String k="EVEREST";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);
					System.out.println("DIRECTOR\t:\tJASON CLARKE\nCINEMATOGRAPHY\t:\tSALVATORE TATINO\nPRODUCER\t:\tBALTASAR KARMAKUR");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tJASON CLARKE\nFEMALE ACTOR\t:\tELIZABETH DEBICKI");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tMILES SOCORRO,OIN,KILI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tON THE MORNING OF MAY 10, 1996, CLIMBERS (JASON CLARKE, JOSH BROLIN) FROM TWO EXPEDITIONS START THEIR FINAL ASCENT TOWARD THE SUMMIT OF MOUNT EVEREST, THE HIGHEST POINT ON EARTH.\n\t\t\tWITH LITTLE WARNING, A VIOLENT STORM STRIKES THE MOUNTAIN, ENGULFING THE ADVENTURERS IN ONE OF THE FIERCEST BLIZZARDS EVER ENCOUNTERED BY MAN."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("ESCAPEPLAN"))
			{
				try
				{
					String k="ESCAPE PLAN";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tMIKAEL HAFSTROM\nCINEMATOGRAPHY\t:\tBRENDAN GALVIN\nPRODUCER\t:\tMARK CANTON,RANDALL EMMETT");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tRAY BRESLIN\nFEMALE ACTOR\t:\tARMY RAYAN ABIGAIL");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tJIM COVIEZEL,VINNIE JONES");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTOUGH AND CHISELED RAY BRESLIN (SYLVESTER STALLONE) KNOWS HOW TO INFILTRATE A PRISON -- AND BUST OUT OF ONE. HIS LATEST JOB LEADS TO A DOUBLE-CROSS,\n\t\t\tLEAVING HIM STUCK IN A HIGH-TECH FACILITY WITH THE WORST THAT SOCIETY HAS TO OFFER. LUCKILY FOR RAY, HE MEETS EMIL ROTTMAYER (ARNOLD SCHWARZENEGGER)."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}	
			else if(noSpacesStr.equalsIgnoreCase("LEON"))
			{
				try
				{
					String k="LEON";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tLUC BESSON\nCINEMATOGRAPHY\t:\tTHIERRY ARBOGAST\nPRODUCER\t:\tPATRICE LEDOUX");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tGEN MURGUIA\nFEMALE ACTOR\t:\tNATALLIE PORTMAN");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tMATHILIDA,LEON,NORMAN STANSFIELD");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tMATHILDA (NATALIE PORTMAN) IS ONLY 12 YEARS OLD, BUT IS ALREADY FAMILIAR WITH THE DARK SIDE OF LIFE: HER ABUSIVE FATHER STORES DRUGS FOR CORRUPT POLICE OFFICERS, AND HER MOTHER NEGLECTS HER.\n\t\t\tLÉON (JEAN RENO), WHO LIVES DOWN THE HALL, TENDS TO HIS HOUSEPLANTS AND WORKS AS A HIRED HITMAN FOR MOBSTER TONY (DANNY AIELLO)."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("THEUNION"))
			{
				try
				{
					String k="THE UNION";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);						
					System.out.println("DIRECTOR\t:\tJULIAN FARINO\nCINEMATOGRAPHY\t:\tJOE BORTON\nPRODUCER\t:\tMOHAN CHERUKURI,MARK WAHLBERG");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tMIKE MCKENNA\nFEMALE ACTOR\t:\tHALLE BERRYY");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tMARK WAHLBERG,J.K.SIMMIONS");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTHE UNION IS IN TURMOIL AFTER A BOTCHED OPERATION IN TRIESTE, WHICH LED TO SEVERAL AGENTS' DEATHS. IN DESPERATE NEED OF A FRESH FACE, THEY TURN TO MIKE,\n\t\t\tA NOBODY, FOR A CRITICAL MISSION TO RETRIEVE GOVERNMENT INTELLIGENCE ABOUT LAW ENFORCEMENT AGENTS IN VARIOUS AGENCIES."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("JACKPOT"))
			{
				try
				{
					String k="JACKPOT";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);						
					System.out.println("DIRECTOR\t:\tPAUL FEIG\nCINEMATOGRAPHY\t:\tJOHN SCHWARTZMAN\nPRODUCER\t:\tPAUL FEIG,JOE ROTH");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tKATIE KIM\nFEMALE ACTOR\t:\tJYOTHIKA,REVATHI");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tYOGI BABU,ANAND RAJ,SAMUTHIRAKANI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tIN THE NEAR FUTURE, A 'GRAND LOTTERY' HAS BEEN NEWLY ESTABLISHED IN CALIFORNIA - THE CATCH: KILL THE WINNER BEFORE SUNDOWN TO LEGALLY CLAIM THEIR MULTI-BILLION DOLLAR JACKPOT."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}

			}
			else if(noSpacesStr.equalsIgnoreCase("TRANSFORMERS"))
			{
				try
				{
					String k="TRANSFORMERS";
					dbMovieInsert(k);
					System.out.print(cyan+"MOVIE NAME\t:\t ");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);						
					System.out.println("DIRECTOR\t:\tJASH COOLENY\nCINEMATOGRAPHY\t:\tCHIRSTOPHER BATTEY\nPRODUCER\t:\tMICHAEL BAY");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tOPTIMUS PRIME\nFEMALE ACTOR\t:\tSCARLETT JOHANSSON ELITA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tCHRIS HEMSWORTH,BRIAN TYREE HENRY");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTHE FATE OF HUMANITY IS AT STAKE WHEN TWO RACES OF ROBOTS, THE GOOD AUTOBOTS AND THE VILLAINOUS DECEPTICONS, BRING THEIR WAR TO EARTH.\n\t\t\tTHE ROBOTS HAVE THE ABILITY TO CHANGE INTO DIFFERENT MECHANICAL OBJECTS AS THEY SEEK THE KEY TO ULTIMATE POWER, BUT ONLY HUMAN SAM WITWICKY CAN SAVE THE WORLD FROM TOTAL DESTRUCTION."+reset);
				}
				catch(Exception e){}
				System.out.println();
				while(true)
				{
					try
					{
						System.out.println(blue+bold+"\t1-To Watch Another Series\t\t2-Change Language\t\t3-MainMenu\t\t4-Watch History\t\t5-Exit ");
						System.out.print("Enter Your Choice:");
						int next=Integer.parseInt(sc.nextLine());
						if(next==1)
						{
							EnglishMovies();			//calling English movies method.
							break;
						}
						else if(next==2)
						{
							obj.movies();			//calling movies method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							obj.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displayMoviesHistory();		//Display Watch History
							while(true)
							{
								try
								{
									System.out.println(blue+bold+"\t1-To Watch Another Movie\t\t2-Change Language\t\t3-MainMenu\t\t4-Exit ");
									System.out.print("\t----->");
									int n=Integer.parseInt(sc.nextLine());
									if(n==1)
									{
										TeluguMovies();			//calling Telugu series method.
										break;
									}
									else if(n==2)
									{
										obj.movies();			//calling series method which is Amazon class which is used change language..
										break;
									}
									else if(n==3)
									{
										obj.selection();			//Dispaly Main Menu Present in Amazon class...
										break;
									}									
									else if(n==4)
									{
										obj.exit();				// calling Exit function To exit from the App.
										break;
									}
									else 
									{
										System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
									}
								}
								catch(NumberFormatException e) {
									System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
								}
							}
							break;
						}
						else if(next==5)
						{
							obj.exit();				// calling Exit function To exit from the App.
							break;
						}
						else 
						{
							System.out.println(red+bold+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else
			{
				System.out.println(red+"\tResult not found\nchoose a movie available from the list"+reset);
				EnglishMovies();
			}
		}
		else 
		{
			System.out.println(red+"\t\tSorry You Don't Have Any Subscription Plan. "+reset);
			System.out.println(yellow+"Please Select a valid Subscription plan to Watch movies and series"+reset);
			obj.subscriptionPlans();
		}
		}
		catch(InputMismatchException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset+""+e);
			EnglishMovies();
		}
	}	
		
}