package InterFace1;
import java.io.*;
import java.net.URL;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NameComponentHelper;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


/*
public class Client2 extends Thread   {
	static InterFace2 ob;
	public static String oldcourseID,oldcourseID1,newcourseID,newcourseID1,studentID1;
	public void run() {
		
		  String msg=ob.swapCourse("comps1111", newcourseID, oldcourseID);
		  System.out.print(msg);
		}
	
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		 ORB orb = ORB.init(args,null);
         try
         {
        	 org.omg.CORBA.Object objref  = orb.resolve_initial_references("NameService");
        	 NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);
        	 ob=InterFace2Helper.narrow(ncRef.resolve_str("COMP"));
         }catch(Exception e)
         {
        	 
         }
         newcourseID="comp2222";
         oldcourseID="comp1111";
         System.out.println(newcourseID+" "+oldcourseID);
         Thread t1=new Thread();
         t1.start();
         newcourseID="comp3333";
         oldcourseID="comp4444";
         System.out.println(newcourseID+" "+oldcourseID);
         Thread t2=new Thread();
         t2.start();
   
	}
}
*/





import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;


public class Client2 {
	static InterFace ob,ob1;
	public static String msg;
    int cho=1,cho1=0;
	public static void main(String[] args) {
		
		try {
			 URL compURL = new URL("http://localhost:8080/comp?wsdl");
		        URL soenURL = new URL("http://localhost:8081/soen?wsdl");
		        URL inseURL = new URL("http://localhost:8082/inse?wsdl");
		 		QName Qname = new QName("http://InterFace1/", "ImpInterFaceService");                    // ImpInterFaceService
		 		Service compService = Service.create(compURL, Qname);
		 		Service soenService = Service.create(soenURL, Qname);
		 		Service inseService = Service.create(inseURL, Qname);
		 		
		 		ob = compService.getPort(InterFace.class);
		 		ob1 = soenService.getPort(InterFace.class);
		 		
        	 ob.UserId("comps1111");
        	 ob1.UserId("inses1111");
			Runnable task1 = () -> {
				msg=ob.enrolCourse("comps2222", "comp4444", "summer");
				System.out.println("\nThread 1:enrolCourse--------------");
				System.out.println(msg);					
			};
			Thread thread1 = new Thread(task1);
			
			Runnable task2 = () -> {
				msg=	ob.enrolCourse("comps1111", "comp4444", "summer");
				System.out.println("\nThread 2:enrolCourse--------------");
				System.out.println(msg);
		
			};
			Thread thread2 = new Thread(task2);
			
			
			
			Runnable task3 = () -> {
				msg=ob.swapCourse("comps1111", "comp5555", "comp2222");
				System.out.println("\nThread 3:swapCourse--------------");
				System.out.println(msg);
		
			};
			Thread thread3 = new Thread(task3);
			Runnable task4 = () -> {
				msg=ob.swapCourse("comps2222", "comp5555", "comp2222");      
		
				System.out.println("\nThread 4:swapCourse--------------");
				System.out.println(msg);
	
			};
			Thread thread4 = new Thread(task4);
			
			
			Runnable task5 = () -> {
				msg=ob.dropCourse("comps2222",  "comp2222");
				System.out.println("\nThread 5:dropCourse--------------");
				System.out.println(msg);
				//msg="no space available in this subject in this term";
		
			};
			Thread thread5 = new Thread(task5);
			Runnable task6 = () -> {
				msg=	ob.dropCourse("comps1111", "comp1111");      
			
				System.out.println("\nThread 6:dropCourse--------------");
				System.out.println(msg);
		
			};
			Thread thread6 = new Thread(task6);
			
			
			
			Runnable task7 = () -> {
				msg=ob.getClassSchedule("comps2222");
				System.out.println("\nThread 7:getClassSchedule--------------");
				System.out.println(msg);
		
			};
			Thread thread7 = new Thread(task7);
			Runnable task8 = () -> {
				msg=	ob.getClassSchedule("comps1111");      
			
				System.out.println("\nThread 8:getClassSchedule--------------");
				System.out.println(msg);
			
			};
			Thread thread8 = new Thread(task8);
			
			
			 ob.UserId("compa1111");
			Runnable task9 = () -> {
				msg=ob.listCourseAvailability("winter");
				System.out.println("\nThread 9:listCourseAvailability--------------");
				System.out.println(msg);
				
			};
			Thread thread9 = new Thread(task9);
			Runnable task10 = () -> {
				msg=	ob.listCourseAvailability("fall");      
				System.out.println("\nThread 10:listCourseAvailability--------------");
				System.out.println(msg);
			
			};
			Thread thread10 = new Thread(task10);
			
			
			Runnable task11 = () -> {
				msg=ob.addCourse("comp0000", "winter");
				System.out.println("\nThread 11:addCourse--------------");
				System.out.println(msg);
			
			};
			Thread thread11 = new Thread(task11);
			Runnable task12 = () -> {
				msg=	ob.addCourse("comp0001", "winter");      
				System.out.println("\nThread 12:addCourse--------------");
				System.out.println(msg);
			
			};
			Thread thread12 = new Thread(task12);
			
			
			Runnable task13 = () -> {
				msg=ob.removeCourse("comp2222", "winter");
				System.out.println("\nThread 13:removeCourse--------------");
				System.out.println(msg);
			
			};
			Thread thread13 = new Thread(task13);
			Runnable task14 = () -> {
				msg=	ob.removeCourse("comp3333", "summer");      
				System.out.println("\nThread 14:removeCourse--------------");
				System.out.println(msg);
		
			};
			Thread thread14 = new Thread(task14);
			
            
            
         
			
            while(cho==1)
		{
                
            System.out.println();
			System.out.println("1-> enrol course");
			System.out.println("2-> drop course");
			System.out.println("3-> get class schedule");
			System.out.println("4-> add course");
			System.out.println("5-> remove course");
			System.out.println("6-> list course availability");
			System.out.println("7-> swap class ");
			System.out.println();
                
            cho1=scanner.nextInt();
                
            if(cho1==1)
            {
			System.out.println("Thread 1 started");
			thread1.start();
			System.out.println("Thread 2 started");
			thread2.start();
            }
            else if(cho1==7)
            {
			System.out.println("Thread 3 started");
			thread3.start();
			System.out.println("Thread 4 started");
			thread4.start();
            }
            else if(cho1==2)
            {
			System.out.println("Thread 5 started");
			thread5.start();
			System.out.println("Thread 6 started");
			thread6.start();
            }
            else if(cho1==3)
            {
			System.out.println("Thread 7 started");
			thread7.start();
			System.out.println("Thread 8 started");
			thread8.start();
            }
            else if(cho1==6)
            {
			System.out.println("Thread 9 started");
			thread9.start();
			System.out.println("Thread 10 started");
			thread10.start();
            }
            else if(cho1==4)
            {
			System.out.println("Thread 11 started");
			thread11.start();
			System.out.println("Thread 12 started");
			thread12.start();
            }
            else if(cho1==5)
            {
			System.out.println("Thread 13 started");
			thread13.start();
			System.out.println("Thread 14 started");
			thread14.start();
            }
                
        System.out.print("\nwanna continue? 1/0");
		cho=scanner.nextInt();
        }
		}catch(Exception e){
		}
	}
}

