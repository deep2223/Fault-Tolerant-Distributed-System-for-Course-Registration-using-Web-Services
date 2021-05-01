package InterFace1;


import java.util.Scanner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import InterFace1.InterFace;

@WebService(endpointInterface = "InterFace1.InterFace")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ImpInterFace implements InterFace {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id2;
	public static String courseID1;
	public static String semester1;
	public static String studentID1;
	public static String userid;
	public char id3;
	public int capacity;
	static boolean flag= false;
	static int capa;
	public static final DateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Scanner scanner = new Scanner(System.in);

	public  void default_values()
	{
		capa=0;
	}
	
	public void UserId (String id)
	{
		userid=id;
	}
	
	
	
	
	
	
	@Override
	public  synchronized String  listCourseAvailability(String semester)
   {
		
		String list="";
		if((userid.substring(0, 4)).equals("comp"))
		{
			Server1 SerVer1= new Server1();
			 list=semester+" - ";
			String s2=SerVer1.listCourseAvailabilitys1send(semester);
			list = list+s2;
			return list;
		}else if((userid.substring(0, 4)).equals("soen"))
		{
			Server2 SerVer2= new Server2();
			 list=semester+" - ";
			String s2=SerVer2.listCourseAvailabilitys2send(semester);
			list = list+s2;
			return list;
			
		}else if((userid.substring(0, 4)).equals("inse"))
		{
			Server3 SerVer3= new Server3();
			 list=semester+" - ";
			String s2=SerVer3.listCourseAvailabilitys3send(semester);
			list = list+s2;
			return list;
		}
		
		
		return list;
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	
	

	
	public ImpInterFace()  {
		
		// TODO Auto-generated constructor stub
			if(flag==false)
			{
				default_values();
				flag=true;
			}
		
	}
	
	
	public ImpInterFace(int a) {
		
		// TODO Auto-generated constructor stub
			super();
		
	}
	public ImpInterFace(String studentID,String id2,char id3) {
		
		// TODO Auto-generated constructor stub
		this.studentID1=studentID;
		this.id2=id2;
		this.id3=id3;
		System.out.print(studentID+id2+"6666"+id3);
		
	}
	

	@Override
	public synchronized void courseCapacity(int Capacity)  {
		// TODO Auto-generated method stub
		capa=(int) Capacity;
	}
	
	
	
	
	
	@Override
	public synchronized String addCourse(String courseID, String semester)
	{
		String addc = null;
		
		if(courseID.substring(0, 4).equals("comp"))
		{
		Server1 S1=new Server1();
		
		addc=S1.addCourseserver(courseID, semester, capa, userid);
		return addc;
		}
		else if(courseID.substring(0, 4).equals("soen"))
		{
		Server2 S2=new Server2();
		addc=S2.addCourseserver(courseID, semester, capa, userid);
		return addc;
		}
		else if(courseID.substring(0, 4).equals("inse"))
		{
		Server3 S3=new Server3();
		addc=S3.addCourseserver(courseID, semester, capa, userid);
		return addc;
		}
		return addc;
	}

	
	@Override
	public synchronized String removeCourse(String courseID, String semester) 
 {
		
		String addc = null;
		
		if(courseID.substring(0, 4).equals("comp"))
		{
		Server1 S1=new Server1();
		
		addc=S1.removeCourseserver(courseID, semester);
		return addc;
		}
		else if(courseID.substring(0, 4).equals("soen"))
		{
		Server2 S2=new Server2();
		addc=S2.removeCourseserver(courseID, semester);
		return addc;
		}
		else if(courseID.substring(0, 4).equals("inse"))
		{
		Server3 S3=new Server3();
		addc=S3.removeCourseserver(courseID, semester);
		return addc;
		}
		return addc;
	}

	
	
	@Override
	public synchronized String getClassSchedule(String studentID)
 {
		// TODO Auto-generated method stub
		
		String list = null;
		
		if(studentID.substring(0, 4).equals("comp"))
		{
			Server1 S1=new Server1();
			list=S1.getClassSchedules1(studentID);
			return list;
			
		}else if(studentID.substring(0, 4).equals("soen"))
		{
			Server2 S2=new Server2();
			list=S2.getClassSchedules2(studentID);
			return list;
		}
		else if(studentID.substring(0, 4).equals("inse"))
		{
			Server3 S3=new Server3();
			list=S3.getClassSchedules3(studentID);
			return list;
		}
		
		
		return list;
	}
	
	

	
	@Override
  public synchronized String enrolCourse(String studentID, String courseID, String semester) 
 {
		
	String stat,stat1;
	Server1 ser1=new Server1(); 
	Server2 ser2=new Server2();
	Server3 ser3=new Server3(); 
	
	  if(userid.substring(0, 4).equals("comp"))
		{
			if(studentID.substring(0, 4).equals("comp"))
			{

					stat=ser1.enrolCourseserver(studentID,courseID,semester);
					return stat;			
			}
			else
			{
				return "you can not enroll another department's student";
			}
			
		}
	  else if(userid.substring(0, 4).equals("soen"))
		{
			if(studentID.substring(0, 4).equals("soen"))
			{
	
					stat=ser2.enrolCourseserver1(studentID,courseID,semester);
					return stat;			
			} 
			else
			{
				return "you can not enroll another department's student";
			}
			
		}
	  else if(userid.substring(0, 4).equals("inse"))
		{
			if(studentID.substring(0, 4).equals("inse"))
			{
				
					stat=ser3.enrolCourseserver2(studentID,courseID,semester);
					return stat;			
			}
			else
			{
				return "you can not enroll another department's student";
			}
			
		}
		
		
		return semester;
		
	}
	

	
	
	@Override 
	public synchronized String dropCourse(String studentID, String courseID)
 {
		String stat,stat1;
		Server1 ser1=new Server1(); 
		Server2 ser2=new Server2();
		Server3 ser3=new Server3(); 
		
		  if(userid.substring(0, 4).equals("comp"))
			{
				if(studentID.substring(0, 4).equals("comp"))
				{   		    
						stat=ser1.dropCourseserver(studentID,courseID);  
						return stat;	
					
				}
				else
				{
					return "you can not drop course of another department's student";
				}
				
			}
		  else if(userid.substring(0, 4).equals("soen"))
			{
				if(studentID.substring(0, 4).equals("soen"))
				{
					
					stat=ser2.dropCourseserver1(studentID,courseID);  
					return stat;
					
				} 
				else
				{
					return "you can not drop course of another department's student";
				}
				
			}
		  else if(userid.substring(0, 4).equals("inse"))
			{
				if(studentID.substring(0, 4).equals("inse"))
				{
					
					stat=ser3.dropCourseserver2(studentID,courseID);  
					return stat;
				}
				else
				{
					return "you can not drop course of another department's student";
				}
				
			}
			
			
			return null;
	}

	@Override
	public synchronized String swapCourse(String studentID, String newcourseID, String oldcourseID) 
	{

		Server1 S1=new Server1();
		Server2 S2=new Server2();
		Server3 S3=new Server3();
		String list = null;
		
		if(studentID.substring(0, 4).equals("comp"))
		{
			
			list=S1.swapCourse1(studentID,newcourseID,oldcourseID);
			return list;
			
		}else if(studentID.substring(0, 4).equals("soen"))
		{
		
			list=S2.swapCourse2(studentID,newcourseID,oldcourseID);
			return list;
		}
		else if(studentID.substring(0, 4).equals("inse"))
		{
		
			list=S3.swapCourse3(studentID,newcourseID,oldcourseID);
			return list;
		}
		
		
		return list;
		
	}


	


}
