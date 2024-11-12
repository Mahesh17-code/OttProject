package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Series extends Colors implements SeriesInterface
{
	
	//object creation for Amazon Class.
	AmazonPrime obj =new AmazonPrime();
	public void displaySeriesHistory() throws SQLException
	{
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ott", "root", "Mahesh@17");
		 String s1="Select * from "+User.dbUser+"Series;";
		 PreparedStatement ps=con.prepareStatement(s1);
		 ResultSet rs=ps.executeQuery();
		 System.out.println(cyan+bold+"\t\t\tYour Series watch History");
		 while(rs.next())
		{
			System.out.println(blue+bold+"\t\t\t"+rs.getInt("No")+" "+rs.getString("Series_Name")+reset);
		}

	}
	public void dbSeriesInsert(String k) throws SQLException 
	{	    
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ott", "root", "Mahesh@17");
	    String createTableQuery = "CREATE TABLE IF NOT EXISTS "+User.dbUser+"Series  (No INT AUTO_INCREMENT PRIMARY KEY, Series_Name VARCHAR(100));";                        
	    try (PreparedStatement psCreate = con.prepareStatement(createTableQuery))
	    {
	        psCreate.executeUpdate();
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while creating table: " + e.getMessage());
	    }
	    String insertQuery = "INSERT INTO "+User.dbUser+"Series (Series_Name) VALUES (?);";
	    try (PreparedStatement psInsert = con.prepareStatement(insertQuery))
	    {
	        psInsert.setString(1, k);
	        psInsert.executeUpdate();
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while inserting record: " + e.getMessage());
	    }
	    
	}
	// Displaying all Telugu Movies..
	public void TeluguSeries() throws SQLException
	{
		try
		{
		System.out.println(blue+bold+"Series Available in Telugu");
		System.out.println(green+bold+"\n1-PITTA KATHALU\n2-PARAMPARA\n3-PAAVA KADHAIGAL\n4-SAVE THE TIGERS\n5-HOSTEL DAYS\n6-90sA MIDDLE CLASS BIOPIC\n7-THE SOFTWARE DEVELOPER\n8-DHOOTHA\n9-9 HOURS\n10-MANSION 24\n");
		System.out.print(purple+"Enter The Series Name:");
		String seriesname=sc.nextLine();						//Taking the User Input.
		String noSpacesStr = seriesname.replaceAll("\\s", "");	//Removing all Spaces for the user input.
		if(AmazonPrime.subPlan>0)
		{
			if(noSpacesStr.equalsIgnoreCase("PITTAKATHALU"))	//comparing the user input by ignoring the cases with available movies.
			{
				try
				{
					String k="PITTA KATHALU";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);							
					System.out.println("DIRECTOR\t:\tNAG ASHWIN\nCINEMATOGRAPHY\t:\tNAVEEN YADAV\nPRODUCER\t:\tASHI DUA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSATYA DEV\nFEMALE ACTOR\t:\tSRUTHI HASSAN");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tAMALA PAUL, EESHA REBBA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tFOCUSING ON THE DARK SIDE OF THE LIVES OF WOMEN AND THEIR JOURNEY THROUGH LOVE,BETRAYAL AND PATRIARCHY."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr.equalsIgnoreCase("PARAMPARA"))
			{
				try
				{
					String k="PARAMPARA";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);						
					System.out.println("DIRECTOR\t:\tKRISHNA VIJAY L\nCINEMATOGRAPHY\t:\tS.V.VISHWESHWAR\nPRODUCER\t:\tSHOBU YARLAGADDA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tJAGAPATHI BABU\nFEMALE ACTOR\t:\tAAKANKSHA SINGH");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSARATH KUMAR, NAINA GUNGULY");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTHE STORY OF PARAMPARA TRACKS THE JOURNEY OF GOPI(NAVVEN CHANDRA) A THIRD-GENERATION BOY OF THE POWERFUL NAIDU FAMILY.\n\t\t\tHE IS THE SON OF MOHAN RAO(JAGAPATHI BABU) AND HOLDS GRUDGE AGAINST NAIDU(SARATH KUMAR) FOR TAKING HIS DADS POSITION."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr .equalsIgnoreCase("PAAVAKADHAIGAL"))
			{
				try
				{
					String k="PAAVA KADHAIGAL";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);				
					System.out.println("DIRECTOR\t:\tSUDHA KONGARA\nCINEMATOGRAPHY\t:\tSURESH BALA\nPRODUCER\t:\tASHI DUA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tKALI DAS JAYARAM\nFEMALE ACTOR\t:\tSAI PALLAVI");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tANJALI, GOUTHAM");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTO EXPLORE UNIQUE STORIES OF WHO DARE TO DREAM AND DESIRE THOSE WHO DETERMINE BY STAND IN THEIR WAY."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr.equalsIgnoreCase("SAVETHETIGERS"))
			{
				try
				{
					String k="SAVE THE TIGERS";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tTEJA KAKUMANU\nCINEMATOGRAPHY\t:\tS.V.VISHWESHWAR\nPRODUCER\t:\tMAHI V RAGHAV");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tPRIYADARSHI PULIKONDA\nFEMALE ACTOR\t:\tJORDAR SUJATHA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tABHINAV GOMATAM,KRISHNA CHAITANYA, PAVANI GANGIREDDY, DEVIYANI SHARMA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tREVOLVES AROUND THREE FRUStaTED HUSBANDS WHO MEET BY CHANCE AND HOW THEIR RANTS OVER THEIR MARITAL PROBLEMS SET OFF A SERIES OF CRAZY EVENTS."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr.equalsIgnoreCase("HOSTELDAYS"))
			{
				try
				{
					String k="HOSTEL DAYS";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tADITHYA MANDALA\nCINEMATOGRAPHY\t:\tFAHAD ABDUL MAJEED\nPRODUCER\t:\tARUNABH KUMAR");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tAKSHAY LAGUSANI\nFEMALE ACTOR\t:\tANANNYAA AKULAA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tAISHWARYA HOLLAKAL, RAJEEV KANAKALA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tFOLLOWS THE JOURNEY OF 6 ENGINEERING STUDENTS AS THEY NAVIGATE THROUGH THEIR LIVES IN THR FIRST YEAR OF AN ENGINEERING HOSTEL."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr.equalsIgnoreCase("90sAMIDDLECLASSBIOPIC"))
			{
				try
				{
					String k="90S-A MIDDLE CLASS BIOPIC";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tADITHYA HASSAN\nCINEMATOGRAPHY\t:\tAZEEM MOHAMMAD\nPRODUCER\t:\tNAVEEN");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSHIVAJI\nFEMALE ACTOR\t:\tVASANTHIKA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tMOULI, ANIL, VASUKI ANAND");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA NOSTALGIC TRIP DOWN MEMORY LANE DELVING INTO THE EVERY DAY OF AN MIDDLE CLASS FAMILY."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr.equalsIgnoreCase("THESOFTWAREDEVELOPER"))
			{
				try
				{
					String k="THE SOFTWARE DEVELOPER";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tK SUBBU\nCINEMATOGRAPHY\t:\tVAMSHI SRINIVAS\nPRODUCER\t:\tVANDANA BANDARU");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSHANMUKH JASHWANTH\nFEMALE ACTOR\t:\tVAISHNAVI CHAITANYA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tIDURI SREE PRIYA, PRUTHVI MUKKA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA GROUP OF FOUR PEOPLE INCLUDING SHANNU WORKS IN A SOFTWARE COMPANY WHEN A NEW GIRL VAISNAVI JOINS THEIR TEAM \n\t\t\tSHANNU FALLS IN LOVE WITH VAISNAVI AND TRIES TO SPEND TIME WITH HER BUT SHE TREATS HIM LIKE A FRIEND."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr.equalsIgnoreCase("DHOOTHA"))
			{
				try
				{
					String k="DHOOTHA";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tVIKRAM K KUMAR\nCINEMATOGRAPHY\t:\tMIKOLAJ SYGULA\nPRODUCER\t:\tSHARRATH KUMAR");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tNAGA CHAITANYA\nFEMALE ACTOR\t:\tPARVATHY THIRUVOTHU");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSRIKANH MURALI, PRACHI DESAI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tIN THIS SUPERNATURAL THILLER, JOURNALIST SAGAR's LIFE TURNS UPSIDE DOWN WHEN NEWSPAPER PREDICT CHILLING \n\t\t\tINCIDENTS THAT INFOLD IN HIS LIFE."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr.equalsIgnoreCase("9HOURS"))
			{
				try
				{
					String k="9 HOURS";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tNIRANJAN KAUSHIK\nCINEMATOGRAPHY\t:\tMANOJH REDDY KATASANI\nPRODUCER\t:\tY.RAJEEV REDDY");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tTARAKARATNA NANDAMURI\nFEMALE ACTOR\t:\tPREETHI ASRANI");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tAJAY, ROHINI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTHREE PRISONERS ESCAPE FROM HYDERABAD CENTRAL JAIL TO FORM THREE TEAMS TO LOOT THREE BANKS. WHILE TWO TEAMS \n\t\t\tEXECUTE THE HEIST SUCCESSFULLY, WHAT HAPPENS TO THE THIRD TEAM?."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
			else if(noSpacesStr.equalsIgnoreCase("MANSION24"))
			{
				try
				{
					String k="MANSION 24";
					dbSeriesInsert(k);
					System.out.print(cyan+bold+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tOHMKAR\nCINEMATOGRAPHY\t:\tB.RAJASEKAR\nPRODUCER\t:\tASHWIN BABU");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSATYARAJ\nFEMALE ACTOR\t:\tVARALAKSHMI");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tAVIKA GOR, BINDU MADHAVI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA BRAVE YOUNG WOMAN SEARCHES FOR HER MISSING FATHER IN AN OLD MANSION, BUT THE MANSION IS FILLED WITH SCARY \n\t\t\tTHINGS THAT KEEP HAPPENING TO HER. AS SHE EXPLORES THE MANSION, SHE ENCOUNTERS CREEPY SUPERNATURAL EVENTS."+reset);
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
							TeluguSeries();			//calling Telugu series method.
							break;
						}
						else if(next==2)
						{
							obj.series();			//calling series method which is Amazon class which is used change language..
							break;
						}
						else if(next==3)
						{
							AmazonPrime.selection();			//Dispaly Main Menu Present in Amazon class...
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();				//Display Series History.
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
							Colors.exit();				// calling Exit function To exit from the App.
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
				System.out.println(red+bold+blink+"\tResult not found\nchoose a series available from the list"+reset);
				TeluguSeries();
			}
		}
		else 
		{
			System.out.println(red+bold+blink+"\tSorry You Don't Have Any Subscription Plan. "+reset);
			System.out.println(yellow+"Please Select a valid Subscription plan to Watch movies and series"+reset);
			obj.subscriptionPlans();
		}
		}
		catch(InputMismatchException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset+""+e);
			TeluguSeries();
		}
	}
	public void EnglishSeries() throws SQLException
	{
		try
		{
		System.out.println(blue+"Series Available in English");
		System.out.println(green+"\n1-GAMES OF THRONES\n2-BREAKING BAD\n3-DEXTER\n4-DAREDEVIL\n5-LIMITLESS\n6-SHERLOCK\n7-PEAKY BLINDERS\n8-NARCOS\n9-HOW I MET YOUR MOTHER\n10-MONEY HEIST\n");
		System.out.print(purple+bold+"Enter The Series Name:");
		String seriesname=sc.nextLine();
		String noSpacesStr = seriesname.replaceAll("\\s", "");
		if(AmazonPrime.subPlan>0)
		{
			if(noSpacesStr.equalsIgnoreCase("GAMESOFTHRONES"))
			{
				try
				{
					String k="GAME OF THRONES";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tTHE DUFFER BROTHERS\nCINEMATOGRAPHY\t:\tTIM IVES\nPRODUCER\t:\tKARL GAJDUSEK");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tPETER DINKLAGE\nFEMALE ACTOR\t:\tEMILIA CLARKE");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tKIT HARINGTON, LENA HEADY");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tNINE NOBEL FAMILIES FIGHT FOR CONTROL OVER THE LANDS OF WESTEROS, WHILE AN ANCIEN ENEMY RETURNS AFTER BEING DORMANT FOR MILLENNIA."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("BREAKINGBAD"))
			{
				try
				{
					String k="BREAKING BAD";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tVINCE GILLIGAN\nCINEMATOGRAPHY\t:\tMICHAEL SLOVIS\nPRODUCER\t:\tSTEWART A.LYNOS");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tBRYAN CRANSTON\nFEMALE ACTOR\t:\tANNA GUNN");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tAARON, BETSY BRANDT");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA CHEMISTRY TEACHER DIAGNOSED WITH INOPERABLE LUNG CANCER TURNS TO MANUFACTURING \n\t\t\tAND SELLING METHAMPHETAMINE WITH A FORMER STUDENT TO SECURE HIS FAMILIY'S FUTURE."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("DEXTER"))
			{
				try
				{
					String k="DEXTER";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tJAMES MANOS.JR \nCINEMATOGRAPHY\t:\tTERRY STACEY\nPRODUCER\t:\tTIMOTHY SCHLATTMANN");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tMICHAEL C.HALL\nFEMALE ACTOR\t:\tJENNIFER CARPENTER");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tDAVID ZAYAS, LUNALAUREN VELEZ");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tHE'S SMART. HE'S LOVABLE. HE'S DEXTER MORGAN, AMERICAS FAVORITE SERIAL KILLER, WHO \n\t\t\tSPENDS HIS DAYS SOLVING CRIMES AND HIS NIGHTS COMMITTING THEM."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("DAREDEVIL"))
			{
				try
				{
					String k="DAREDEVIL";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tDREW GODDARD\nCINEMATOGRAPHY\t:\tMATTHEW J.LIOYD\nPRODUCER\t:\tKATI JOHNSTON");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tCHARLIE COC\nFEMALE ACTOR\t:\tDEBORAH ANN WOLL");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tVINCENT D'ONOFRIO, AYELET ZURER");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA BLIND LAWYER BY DAY, VIGILANTE BY NIGHT. MATT MURDOCK FIGHTS THE CRIME OF NEW YORK AS DAREDEVIL."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("LIMITLESS"))
			{
				try
				{
					String k="LIMITLESS";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tCRAIG SWEENY\nCINEMATOGRAPHY\t:\tJIMMY LINDSEY\nPRODUCER\t:\tTODD PHILIPS");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tJAKE MCDORMAN\nFEMALE ACTOR\t:\tJENNIFER CARPENTER");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tHILL HARPER, MARY ELIZABETH");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA MYSTERIOUS PILL THAT ENABLES THE USER TO ACCESS 100% OF HIS BRAIN'S ABILITIES \n\t\t\tTRANSFORMS A STRUGGLING WRITER INTO A FINANCIAL WIZAD, BUT IT ALSO PUTS HIM IN A NEW WORLD WITH MANY DANGERS."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("SHERLOCK"))
			{
				try
				{
					String k="SHERLOCK";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tMARK GATISS\nCINEMATOGRAPHY\t:\tFABIAN WAGNER\nPRODUCER\t:\tSUE VERTUE");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tBENEDICT CUMBERBATCH\nFEMALE ACTOR\t:\tUNA STUBBS");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tMARTIN FREMAN, LOUISE BREALEY");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTHE QUIRKY SPIN ON CONAN DOYLE'S ICONIC SLEUTH PITCHES HIM AS A(HIGH-FUNCTIONING SOCIOPATH) \n\t\t\tIN MODERB-DAY LONDON. ASSISTING HIM IN HIS INVESTIGATIONS:AFGANISTAN WAR VET JOHN WATSON, WHO'S INTRODUCED TO HOMLES BY A MUTUAL ACQUAINTANCE."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("PEAKYBLINDERS"))
			{
				try
				{
					String k="PEAKY BLINDERS";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tOTTO BATHURST\nCINEMATOGRAPHY\t:\tGEORGE STEEL\nPRODUCER\t:\tJAMIE GLAZEBROOK");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tCILLIAN MURPHY\nFEMALE ACTOR\t:\tSOPHIE RUNDLE");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tPAUL ANDERSON, HELEN MCCROCY");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA GANGSTER FAMILY EPIC SET IN 1900s ENGLAND, CENTERING ON A GANG WHO SEW RAZOR BLADES \n\t\t\tIN THE PEAKS OF THEIR CAPS, AND THEIR FIERCE BOSS TOMMY SHELBY."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("NARCOS"))
			{
				try
				{
					String k="NARCOS";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tANDRES BAIZ\nCINEMATOGRAPHY\t:\tADRIAN TEIJIDO\nPRODUCER\t:\tJESSE ROSE MOORE");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tWAGNER MOURA\nFEMALE ACTOR\t:\tPAULINA GAITAN");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tPEDRO PASCAL, JUAN MURCIA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA CHRONICLED LOOK AT THE CRIMINAL EXPLOITS OF COLOMBIAN DRUG LORD PABLO ESCOBAR, AS WELL \n\t\t\tAS THE MANY OTHER DRUG KINGPINS WHO PLAGUED THE COUNTRY THROUGH THE YEARS."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("HOWIMETYOURMOTHER"))
			{
				try
				{
					String k="MET YOUR MOTHER";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tPAMELA FRYMAN\nCINEMATOGRAPHY\t:\tCHRIS LA FOUNTAINE\nPRODUCER\t:\tCARTER BAYS");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tJASH RADNOR\nFEMALE ACTOR\t:\tCOBIE SMULDERS");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tJASON SEGEL, ALYSON HANNIGAN");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA FATHER RECOUNTS TO HIS CHILDREN-THROUGH A SERIES OF FLASHBACKS-THE JOURNEY HE AND HIS \n\t\t\tFOUR BEST FRIENDS TOOK LEADING UP TO HIM MEETING THEIR MOTHER."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
			else if(noSpacesStr.equalsIgnoreCase("MONEYHEIST"))
			{
				try
				{
					String k="MONEY HEIST";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tJESUS COLMENAR\nCINEMATOGRAPHY\t:\tMIGUE AMOEDO\nPRODUCER\t:\tALEX PINA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tALVARO MORTE\nFEMALE ACTOR\t:\tURSULA CORBERO");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tPEDRO ALONSO, ITZIAR ITUNO");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tAN UNUSUAL GROUP OF ROBBERS ATTEMPT TO CRAZY OUT THE MOST PERFECT ROBBERY IN SPANISH \n\t\t\tHISTORY-STEALING 2.4 BILLION EUROS FROM THE ROYAL MINT OF SPAIN."+reset);
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
							EnglishSeries();	//calling English Series
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling main menu method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series Watch history.
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
							obj.exit();			//calling exit method
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
				System.out.println(red+bold+blink+"\tResult not found\nchoose a series available from the list"+reset);
				EnglishSeries();
			}
		}
		else 
		{
			System.out.println(red+bold+blink+"Sorry You Don't Have Any Subscription Plan. "+reset);
			System.out.println(yellow+bold+"Please Select a valid Subscription plan to Watch movies and series"+reset);
			obj.subscriptionPlans();
		}
		}
		catch(InputMismatchException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset+""+e);
			EnglishSeries();
		}
	}
	public void HindiSeries() throws SQLException
	{
		try
		{
		System.out.println(blue+bold+"Series Available in Hindi");
		System.out.println(green+"\n1-MIRZAPUR\n2-SCAM 1992\n3-CRIMINAL JUSTICE\n4-PANCHAYAT\n5-ASUR\n6-FARZI\n7-INSIDE EDGE\n8-CAMPUS DIARIES\n9-ASPIRANTS\n10-FLAMES\n");
		System.out.print(purple+bold+"Enter The Series Name:");
		String seriesname=sc.nextLine();
		String noSpacesStr = seriesname.replaceAll("\\s", "");
		if(AmazonPrime.subPlan>0)
		{
			if(noSpacesStr.equalsIgnoreCase("MIRZAPUR"))
			{
				try
				{
					String k="MIRZAPUR";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tGURMMEET SINGH\nCINEMATOGRAPHY\t:\tSANJAY KAPOOR\nPRODUCER\t:\tFARHAN AKHTAR");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tALI FAIZAL\nFEMALE ACTOR\t:\tHARSHITHA GAUR");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tDIVYENDU SHARMA, SHWETA TRIPATHI");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA SHOCKING INCIDENT AT A WEDDING PROCESSING IGNITES A SERIES OF EVENTS ENTANGING THE LIVE OF TWO FAMILIES IN THE LAWLESS\n\t\t\tCITY OF MIRZAPUR."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("SCAM1992"))
			{
				try
				{
					String k="SCAM 1992";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tHANSAL MEHTA\nCINEMATOGRAPHY\t:\tPRATHAM MEHTA\nPRODUCER\t:\tINDRANIL CHAKRABORTY");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tPRATIK GANDHI\nFEMALE ACTOR\t:\tSHREYA DHANWANTHARY");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tHEMANT KHER, ANJALI BAROT");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tTHE RISE AND FALL OF HARSHAD MEHTA, A STOCKBROKER WHO SINGLE-HANDEDLY TOOK THE STOCK MARKET TO GREAT HEIGHTS, IS DEPICTED."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("CRIMINALJUSTICE"))
			{
				try
				{
					String k="CRIMINAL JUSTICE";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tTIGMANSHU DHULIA\nCINEMATOGRAPHY\t:\tABHIJIT DESHPANDE\nPRODUCER\t:\tMYLEETTA AGA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tVIKRANT MASSEY\nFEMALE ACTOR\t:\tRUCHA INAMDER");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tPANKAJ TRIPATHI, ANUPRIYA GOENKA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tSEX, DRUGS AND GRUESOME MURDER. AN EDGY ONE NIGHT STAND TURNS INTO A NIGHTMARE FOR ADITYA, WHEN HE WAKES UP WITH BLOOD \n\t\t\tON HIS HANDS. THE EVIDENCE IS STACKED AGAINST HIM, BUT HE DOESN'T REMEMBER THE GRISLY CRIME. IS HE GUILTY OR NOT?."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("PANCHAYAT"))
			{
				try
				{
					String k="PANCHAYAT";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tDEEPAK KUMAR\nCINEMATOGRAPHY\t:\tAMITABHA SINGH\nPRODUCER\t:\tPRAJESH MISHRA");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tJITENDRA KUMAR\nFEMALE ACTOR\t:\tSANVIKAA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tFAISAL MALIK, NEENA GUPTA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA COMEDY-DRAMA, WHICH CAPTURES THE JOURNEY OF AN ENGINEERING GRADUATE ABHISHEK, WHO FOR LACK OF BETTER JOB OPTION JOINS \n\t\t\tAS SECRATERY OF A PANCHAYAT OFFICE ON A REMOTE VILLAGE OF UTTER PRADESH."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("ASUR"))
			{
				try
				{
					String k="ASUR WELCOME TO YOUR DARKSIDE";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tONI SEN\nCINEMATOGRAPHY\t:\tSAYAK BHATTACHARYA\nPRODUCER\t:\tVIKAS AGARWAL");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tARSHAD WARSI\nFEMALE ACTOR\t:\tANUPRIYA GOENKA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tAMALA PAUL, EESHA REBBA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tSHUBH TURNS FOR REVENGE AND THIS SEASON HE TAKES THE CHALLENGE TO A WHOLE NEW LEVEL. WITH THE HEROES FALLEN APART, WHILE \n\t\t\tA DESOLATE DHANANJAY RAJPOOT AND A TORN NIKHIL NAIR BE ABLE TO STOP HIM."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("FARZI"))
			{
				try
				{
					String k="FARZI";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tKRISHNA D.K\nCINEMATOGRAPHY\t:\tPANKAJ KUMAR\nPRODUCER\t:\tKRISHNA D.K");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tSHAHID KAPOOR\nFEMALE ACTOR\t:\tRAASHI KHANNA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tVIJAY SETHUPATHI, KAY KAY MENON");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tAN ARTIST WHO GETS PULLED INTO THE MURKY HIGH STACKES OF A CON JOB AND A FIERY TASK FORCE OFFICER ON THE MISSION TO RID \n\t\t\tTHE COUNTRY OF HIS MENACES IN A FAST-PACED, EDGY ONE-OF-A-KIND THRILLER."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}	
			else if(noSpacesStr.equalsIgnoreCase("INSIDEEDGE"))
			{
				try
				{
					String k="INSIDE EDGE";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tKARAN ANSHUMAN\nCINEMATOGRAPHY\t:\tVIVEK SHAH\nPRODUCER\t:\tRITESH SIDHWANI");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tTANUJ VIRWANI\nFEMALE ACTOR\t:\tSAYANI GUPTA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tVIVEK OBEROI, RICHA CHADHA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tINSIDE EDGE IS THE STORY OF THE MUMBAI MAVERICKS, A T20 CRICKET FRANCHIES PLAYING IN THE POWERPLAY LEAGUE. SET IN A LANDSCAPE \n\t\t\tOF CONFLICTING INTRESTS, WHERE SELFISHNESS IS ALMOST A VIRTUE, WHERE SEX, MONEY, AND POWER ARE MERE MEANS TO AN END."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("CAMPUSDIARIES"))
			{
				try
				{
					String k="CAMPUS DIARIES";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tPREM MISTRY\nCINEMATOGRAPHY\t:\tJERIN PAUL\nPRODUCER\t:\tABHISHEK YADAV");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tHARSH BENIWAL\nFEMALE ACTOR\t:\tSRISHTI RINDANI");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tRITVIK SAHORE, SALONI KHANNA");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tCAMPUS DIARIES IS A COMING-OF-AGE DRAMA OF SIX STUDENTS AT EXCEL UNIVERSITY."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("ASPIRANTS"))
			{
				try
				{
					String k="ASPIRANTS";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tAPOORV SINGH KARKI\nCINEMATOGRAPHY\t:\tGEORGY JOHN\nPRODUCER\t:\tJOSHNA BHAT");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tNAVEEN KASTURIA\nFEMALE ACTOR\t:\tNAMITA DUBEY");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSHIVANKIT SINGH PARIHAR, TENGAM CELINE");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tIT IS THE STORY OF THE JOURNEY OF THREE UPSC(PUBLIC SERVICE COMPETITIVE EXAMS IN INDIA)ASPIRANTS AND THEIR FRIENSHIP \n\t\t\tAGAINST ALL ODDS."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else if(noSpacesStr.equalsIgnoreCase("FLAMES"))
			{
				try
				{
					String k="FLAMES";
					dbSeriesInsert(k);
					System.out.print(cyan+"SERIES NAME\t:\t");
					movieLoadingAnimation(k);
					System.out.println();
					Thread.sleep(500);					
					System.out.println("DIRECTOR\t:\tAPOORV SINGH KARKI\nCINEMATOGRAPHY\t:\tGEORGY JOHN\nPRODUCER\t:\tARUNABH KUMAR");
					Thread.sleep(500);
					System.out.println("MALE ACTOR\t:\tRITVIK SAHORE\nFEMALE ACTOR\t:\tTANYA MANIKTALA");
					Thread.sleep(500);
					System.out.println("SIDE ROLES\t:\tSHHIVAM KAKAR, SUNAKSHI GROVER");
					Thread.sleep(500);
					System.out.println("SUMMARY\t\t:\tA TEENAGE ROMANCE FROM THE TIMELINERS THAT AIMS STRAIGNT FROM THE HEARTS. THIS WEB-SERIES IS THE STORY OF A YOUNG ROMANCE \n\t\t\tUNFOLDING AS A CHEMICAL REACTION."+reset);
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
							HindiSeries();		//calling HindiSeries
							break;
						}
						else if(next==2)
						{
							obj.series();		//calling series method
							break;
						}
						else if(next==3)
						{
							obj.selection();	//calling selection method
							break;
						}
						else if(next==4)
						{
							displaySeriesHistory();		//Displaying series history.
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
							obj.exit();			//calling exit method
							break;
						}
						else 
						{
							System.out.println(red+bold+blink+"\t\tInvalid choice!!!"+reset);
						}
					}
					catch(NumberFormatException e) {
						System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset);
					}
				}
			}
			else
			{
				System.out.println(red+bold+blink+"\tResult not found\nchoose a series available from the list"+reset);
				HindiSeries();
			}
		}
		else 
		{
			System.out.println(red+bold+blink+"\tSorry You Don't Have Any Subscription Plan. "+reset);
			System.out.println(yellow+"Please Select a valid Subscription plan to Watch movies and series"+reset);
			obj.subscriptionPlans();
		}
		}
		catch(InputMismatchException e) {
			System.out.println(red+bold+"\tYou have entered Invalid Input!!"+reset+""+e);
			HindiSeries();
		}
	}
}