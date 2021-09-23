package osgi_event_service_producer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EventServicePublishImpl implements EventServicePublish {

	float Total_Event_Charge = (float) 0.0;
	 int Release_Event;

	 public void   Book_Outdoor_Events(int no_of_events,ArrayList Avaiable_Outdoor_Events,ArrayList Avaiable_Indoor_Events,ArrayList Booked_Events) {
			// TODO Auto-generated method stub
			 
			if(no_of_events <= Avaiable_Outdoor_Events.size())
			{
				for(int i=0;i<no_of_events;i++)
				{
				  int j=0;
				  int event = (int) Avaiable_Outdoor_Events.remove(j);
				  Booked_Events.add(event);
				}
				System.out.println("****************");
				
				Total_Event_Charge = no_of_events * 2000;
				
			    System.out.println("Total Event Charges:"+Total_Event_Charge);
			    System.out.print("\n");
			    Collections.sort(Avaiable_Outdoor_Events);
			    Collections.sort(Avaiable_Indoor_Events);
			    System.out.println("Available Outdoor Events"+ "\n" +Avaiable_Outdoor_Events);
			    System.out.println("Available Indoor Events"+ "\n" +Avaiable_Indoor_Events);
			    System.out.print("\n");
				
			}
			else
			{
				System.out.println("Sorry!!!Number of Available AC Events less than No of Events that You want");
			}	
		
	      }
		
		public void   Book_Indoor_Events(int no_of_events,ArrayList Avaiable_Indoor_Events,ArrayList Avaiable_Outdoor_Events,ArrayList Booked_Events) {
			// TODO Auto-generated method stub
			 
			if(no_of_events <= Avaiable_Indoor_Events.size())
			{
				for(int i=0;i<no_of_events;i++)
				{  
					int j=0;
				    int event = (int) Avaiable_Indoor_Events.remove(j);
				    Booked_Events.add(event);
				    
				}
			    System.out.print("\n");
				Total_Event_Charge = no_of_events * 1500;
				
				System.out.println("****************");
				
			    System.out.println("Total Event Charges:"+Total_Event_Charge);
			    System.out.print("\n");
			    
			    System.out.println("Available Outdoor Events"+ "\n"+ Avaiable_Outdoor_Events);
			    System.out.println("Available Indoor Events"+ "\n" +Avaiable_Indoor_Events);
			    System.out.print("\n");
			}
			else
			{
				System.out.println("Sorry!!!Number of Available Indoor Events less than No of Events  that You want ");
			}	
			
		
	      }
		public void  ReleaseEvent(int Booked_Eventno,ArrayList Avaiable_Outdoor_Events,ArrayList Avaiable_Indoor_Events,ArrayList Booked_Events)
		{
			  for(int i=0;i<Booked_Events.size();i++)
			  {
				   if(Booked_Eventno == (int)Booked_Events.get(i))
				   {
					   if((int)Booked_Events.get(i) <= 5)
					   {
						   Avaiable_Outdoor_Events.add((int)Booked_Events.get(i));
						   Booked_Events.remove(i);
						   Collections.sort(Avaiable_Outdoor_Events);
						    Collections.sort(Avaiable_Indoor_Events);
						   System.out.println("Available Outdoor Events"+Avaiable_Outdoor_Events);
						   System.out.println("Available Indoor Events"+Avaiable_Indoor_Events);
						   System.out.print("\n");
					   }
					   else if((int)Booked_Events.get(i) >=5 && (int)Booked_Events.get(i) <=10 )
					   {
						   Avaiable_Indoor_Events.add((int)Booked_Events.get(i));
						   Booked_Events.remove(i);
						    Collections.sort(Avaiable_Outdoor_Events);
						    Collections.sort(Avaiable_Indoor_Events);
						   System.out.println("Available Outdoor Events"+Avaiable_Outdoor_Events);
						   System.out.println("Available Indoor Events"+Avaiable_Indoor_Events);
						   System.out.print("\n");
					   }
					   
					   
					   
				   }
				  
				  
			  }
			
				
		}
	    
		public String LoginVerification(String username,String password)
		 {
			
	    	if((username.equals("Admin")) && (password.equals("123")))
	    	{
				return "admin";
			}
			else if((username.equals("Cashier")) && (password.equals("123")))
			{
				return "cashier";
			}else
			{
				return "invalid";
			}
			
			
			
		 }
		public void Add_Outdoor_Indoor_Events(String EventType,ArrayList Avaiable_Outdoor_Events,ArrayList Avaiable_Indoor_Events,int eventno)
		{
			if(EventType.equals("OUTDOOR") || EventType.equals("outdoor"))
			{
				Avaiable_Outdoor_Events.add(eventno);
				 System.out.println("****************");
				 System.out.println("New Outdoor Event Added - "+"Event Number"+eventno);  
		       	  
				
				    Collections.sort(Avaiable_Outdoor_Events);
				    Collections.sort(Avaiable_Indoor_Events);
				    System.out.println("Available Outdoor Events:"+Avaiable_Outdoor_Events);
				    System.out.println("Available Indoor Events:"+Avaiable_Indoor_Events);
				
			}
			 else if(EventType.equals("INDOOR") || EventType.equals("indoor"))
	        {
	       	   Avaiable_Indoor_Events.add(eventno);
	       	   System.out.println("****************");
	       	   System.out.println("New Indoor Events Added - "+"Event Number"+eventno);  
	       	  
	       	    Collections.sort(Avaiable_Outdoor_Events);
			    Collections.sort(Avaiable_Indoor_Events);
			    System.out.println("Available Outdoor Events:"+Avaiable_Outdoor_Events);
			    System.out.println("Available Indoor Events:"+Avaiable_Indoor_Events);
	        }	 
			
		}
		public void Remove_Outdoor_Indoor_Events(String EventType,ArrayList Avaiable_Outdoor_Events,ArrayList Avaiable_Indoor_Events,int eventno)
		{
			if(EventType.equals("OUTDOOR") || EventType.equals("outdoor"))
			{
				for(int i=0;i<Avaiable_Outdoor_Events.size();i++)
				{
					if(eventno == (int)Avaiable_Outdoor_Events.get(i))
					{
						Avaiable_Outdoor_Events.remove(i);
						 System.out.println("****************");
						 System.out.println("New Outdoor Events Removed "+"Event Number"+eventno);  
				       	  
					    
					    Collections.sort(Avaiable_Outdoor_Events);
					    Collections.sort(Avaiable_Indoor_Events);
					    System.out.println("Available Outdoor Events"+ "\n"+ Avaiable_Outdoor_Events);
					    System.out.println("Available Indoor Events"+ "\n" + Avaiable_Indoor_Events);
					}
					
				}
			}
			 else if(EventType.equals("INDOOR") || EventType.equals("indoor"))
	        { 
				 for(int i=0;i<Avaiable_Indoor_Events.size();i++)
					{
						if(eventno == (int)Avaiable_Indoor_Events.get(i))
						{
							Avaiable_Indoor_Events.remove(i);
							 System.out.println("****************");
							 System.out.println("Non Indoor Event Removed "+"Event Number"+eventno);  
					       	  
							
							
							Collections.sort(Avaiable_Outdoor_Events);
							Collections.sort(Avaiable_Indoor_Events);
							System.out.println("Available Outdoor Events:"+ "\n" +Avaiable_Outdoor_Events);
							System.out.println("Available Indoor Events:"+"\n"+ Avaiable_Indoor_Events);
						}
						
					}
	       	  
	       	  
	        }	
			
		}
	}


