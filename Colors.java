package project;
import java.util.*;
public class Colors
{
	static String reset="\u001B[0m";    // 0 reset
    static String bold="\u001B[1m"; // 1 for bold
    static String blink ="\u001B[5m";  //blink
    static String under="\u001B[21m"; // underline
    static String red="\u001B[31m";     // text colors 31 - 37
    static String green="\u001B[32m";
    static String yellow="\u001B[33m";
    static String blue="\u001B[34m";
    static String cyan="\u001B[35m";
    static String purple="\u001B[36m";
    static String backblue="\u001B[104m";   // 101 - 107 background colors
    static String backcyan="\u001B[105m";
    static String backpurple="\u001B[106m";
    static String backwhite="\u001B[107m";
    static String backred="\u001B[101m";
    static String backgreen="\u001B[102m";
    static String backyellow="\u001B[103m";
    static Scanner sc=new Scanner(System.in); //Scanner class
    public static void loading()
    {
    	//For loading Animation.
	   for(int i=0;i<10;i++)
	   {
	      System.out.print(green+bold+". ");
	      try{
	      Thread.sleep(300);
	      }
	      catch(Exception e){}
	   }
    }
    public static void animation()
    {
    	for(int i=1;i<20;i++)
	   {
	      if(i%3==1)
	      {
	          System.out.print(".");
	      }
	      else if(i%3==2)
	      {
	          System.out.print(".");
	      }
	      else
	      {
	          System.out.print(".");
	      }
	      try{
	          Thread.sleep(100);
	      }
	      catch(Exception e){}
	   }
	   System.out.print("."+" ");
    }
    public static void movieLoadingAnimation(String k)
    {
    	for(int i=0;i<k.length();i++)
		{
		    char ch=k.charAt(i);
//		    for(char j='0';j<=ch;j++)
//		    {
		        System.out.print(ch);
			    try{
			        Thread.sleep(50);
			    }
			    catch(Exception e){}
//			}
			System.out.print(" ");
		}
    }
    public static void exit()
	{
    	System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*************************************************************************"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*                                                                       *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*                                                                       *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*    _____   _   _      _      _   _   _  __   __   __   ___    _   _   *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*   |_   _| | | | |    / \\    | \\ | | | |/ /   \\ \\ / /  / _ \\  | | | |  *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*     | |   | |_| |   / _ \\   |  \\| | | ' /     \\ V /  | | | | | | | |  *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*     | |   |  _  |  / ___ \\  | |\\  | | . \\      | |   | |_| | | |_| |  *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*     |_|   |_| |_| /_/   \\_\\ |_| \\_| |_|\\_\\     |_|    \\___/   \\___/   *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*                                                                       *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.green+Colors.bold+"*                               VISIT AGAIN..                           *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*                                                                       *"+Colors.reset);
        System.out.println("\t\t\t\t"+Colors.backyellow+Colors.purple+Colors.bold+"*************************************************************************"+Colors.reset);
  
		return;
	}
}
