package osgi_hotal_grand_consumer;


import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import osgi_food_service_producer.FoodService;
import osgi_food_service_producer.FoodServiceImpl;
import osgi_room_service_producer.RoomReservationService;
import osgi_room_service_producer.RoomReservationServiceImpl;
import osgi_room_service_producer.RoomReservationService;
import osgi_game_service_producer.ServicePublish;
import osgi_game_service_producer.ServicePublishImpl;
import osgi_event_service_producer.EventServicePublish;
import osgi_event_service_producer.EventServicePublishImpl;



public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext Context) throws Exception {
		System.out.println("Start Hotel Consumer Service");
		serviceReference = Context.getServiceReference(FoodService.class.getName());
		FoodService foodBillingService = (FoodService) Context.getService(serviceReference);

try
		{  
			Scanner scanner = new Scanner(System.in);
	
	//Food---------------------------- 
			String username, password,choice,itemName,fieldChoice ;
			float itemPrice, discount,cash, balance;
			int itemId,field;
			FoodService foodbillingservice = new FoodServiceImpl();
			foodbillingservice.defaultList();
	//Room-----------------------------------------------------
			String Book_Release_Room,Room_Add_type;
	    	int Booked_Room_No,Add_Room_No,Remove_Room_No;
	    	String Room_type = null;
			int no_of_rooms = 0;
			float Total_Room_Charge;
			 
			ArrayList<Integer> Avaiable_AC_Rooms  = new ArrayList<Integer>();
			ArrayList<Integer> Avaiable_NON_AC_Rooms  = new ArrayList<Integer>();
			ArrayList<Integer> Booked_Rooms = new ArrayList<Integer>();
			
			RoomReservationService roomservice = new RoomReservationServiceImpl();
			
			
			 Avaiable_AC_Rooms.add(1);
			 Avaiable_AC_Rooms.add(2);
			 Avaiable_AC_Rooms.add(3);
			 Avaiable_AC_Rooms.add(4);
			 Avaiable_AC_Rooms.add(5);
			 
			 
			 Avaiable_NON_AC_Rooms.add(6);
			 Avaiable_NON_AC_Rooms.add(7);
			 Avaiable_NON_AC_Rooms.add(8);
			 Avaiable_NON_AC_Rooms.add(9);
			 Avaiable_NON_AC_Rooms.add(10);
			
			
	//Game--------------------------------	
			String Book_Release_Game,Game_Add_type,Game_Remove_type;
	    	int Booked_Game_No,Add_Game_No,Remove_Game_No;
	    	String Game_type = null;
			int no_of_games = 0;
			float Total_Game_Charge;
			
			ServicePublish gameservice = new ServicePublishImpl();
			
			ArrayList<Integer> Avaiable_Field_Games  = new ArrayList<Integer>();
			ArrayList<Integer> Avaiable_Water_Games  = new ArrayList<Integer>();
			ArrayList<Integer> Booked_Games = new ArrayList<Integer>();
			
			Avaiable_Field_Games.add(1);
			Avaiable_Field_Games.add(2);
			Avaiable_Field_Games.add(3);
			Avaiable_Field_Games.add(4);
			Avaiable_Field_Games.add(5);
			 
			 
			 Avaiable_Water_Games.add(6);
			 Avaiable_Water_Games.add(7);
			 Avaiable_Water_Games.add(8);
			 Avaiable_Water_Games.add(9);
			 Avaiable_Water_Games.add(10);
			
	//Event----------------------------------
			String Book_Release_Event,Event_Add_type,Event_Remove_type;
	    	int Booked_Event_No,Add_Event_No,Remove_Event_No;
	    	String Event_type = null;
			int no_of_event = 0;
			float Total_Event_Charge;
			
			EventServicePublish eventservice = new EventServicePublishImpl();
			
			ArrayList<Integer> Avaiable_Outdoor_Events  = new ArrayList<Integer>();
			ArrayList<Integer> Avaiable_Indoor_Events  = new ArrayList<Integer>();
			ArrayList<Integer> Booked_Events = new ArrayList<Integer>();
			 
			Avaiable_Outdoor_Events.add(1);
			 Avaiable_Outdoor_Events.add(2);
			 Avaiable_Outdoor_Events.add(3);
			 Avaiable_Outdoor_Events.add(4);
			 Avaiable_Outdoor_Events.add(5);
			 
			 
			 Avaiable_Indoor_Events.add(6);
			 Avaiable_Indoor_Events.add(7);
			 Avaiable_Indoor_Events.add(8);
			 Avaiable_Indoor_Events.add(9);
			 Avaiable_Indoor_Events.add(10);
			
			
			while(true) {
				System.out.println("<< if you wont exit enter 'end' for username >>");
				System.out.println("====== Login =========================");
				System.out.print("Enter UserName : ");
				username = scanner.next();
				if( username.equals("end")) {
					System.out.println("Ending Food billing");
					break;
				}
				System.out.print("Enter Password : ");
				password = scanner.next();
				System.out.println("======================================\n");
				choice = foodbillingservice.LoginVerification(username, password);
				if(choice=="admin") {
					System.out.println("~~~~~~~~~~~ Welcome Admin ~~~~~~~~~~~");
					System.out.println("1. Food");
					System.out.println("2. Rooms");
					System.out.println("3. Game");
					System.out.println("4. Event");
					System.out.println("Enter the Fields(1,2,3,4):");
					field = scanner.nextInt();
					
					if(field==1) {
					
						foodbillingservice.printItemList();
						while(true) {
							System.out.print("You wont Add item or Remove item or logout (add / remove / logout) :");
							choice = scanner.next();
							if(choice.equals("add")) {
								System.out.print("Enter Item Name : ");
								itemName = scanner.next();
								System.out.print("Enter Item Price : ");
								itemPrice = scanner.nextFloat();
								foodbillingservice.addItem(itemName, itemPrice);
								foodbillingservice.printItemList();
							}else if(choice.equals("remove")) {
								System.out.print("Enter Item Id : ");
								itemId = scanner.nextInt();
								foodbillingservice.removeItem(itemId);
								foodbillingservice.printItemList();
							}else if(choice.equals("logout")) {
								break;
							}else {
								System.out.println("Error: Invalide input");
							}
						}
					}
					if(field==2) {
						
						 
						
						 
						
						
						System.out.println("====================== Welcome Admin!======================");
						
						System.out.println("Available A/C Rooms" +"\n" +Avaiable_AC_Rooms);
						System.out.println("Available NON A/C Rooms"+"\n" +Avaiable_NON_AC_Rooms);
						
						System.out.print("You want to Add Room or Remove Room or Logout (add / remove) :");
						choice = scanner.next();
						
						if(choice.equals("add"))
						{
							  System.out.print("Enter The Room Type(AC,ac or NON AC,non ac):");
					          Room_Add_type = scanner.next();
					          
					          System.out.print("Add Room No :");
					          Add_Room_No = scanner.nextInt();
					          
					          roomservice.Add_Ac_NonAc_Room(Room_Add_type,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Add_Room_No);
							
						}
						else if(choice.equals("remove"))
						{
							  System.out.print("Enter The Room Type(AC,ac or NON AC,non ac):");
					          Room_Add_type = scanner.next();
					          
					          System.out.print("Remove Room Number:");
					          Remove_Room_No = scanner.nextInt();
								
					          roomservice.Remove_Ac_NonAc_Room(Room_Add_type, Avaiable_AC_Rooms, Avaiable_NON_AC_Rooms, Remove_Room_No);
						}	
					}
					
					else if(field == 3) {
						 
						
						 System.out.println("\n");
						 
						
						 System.out.println("========================= Welcome Admin!=========================");
							System.out.println("Available Field Games" +"\n" +Avaiable_Field_Games);
							System.out.println("Available Water Games"+"\n" +Avaiable_Water_Games);
					        
							System.out.print("You want to Add a Game or Remove a Game or Logout (add / remove) :");
							choice = scanner.next();
							
							if(choice.equals("add"))
							{
								  System.out.print("Enter The Game Type(Field,Field or Water,Water):");
						          Game_Add_type = scanner.next();
						          
						          System.out.print("Add Game ID No :");
						          Add_Game_No = scanner.nextInt();
						          
						          gameservice.Add_Field_Water_Games(Game_Add_type,Avaiable_Field_Games,Avaiable_Water_Games,Add_Game_No);
								
							}
							else if(choice.equals("remove"))
							{
								  System.out.print("Enter The Game Type(Field,Field or Water,Water):");
						          Game_Remove_type = scanner.next();
						          
						          System.out.print("Remove Game ID No:");
						          Remove_Game_No = scanner.nextInt();
									
						          gameservice.Remove_Field_Water_Games(Game_Remove_type, Avaiable_Field_Games, Avaiable_Water_Games, Remove_Game_No);
							}
						 
					}
					else if(field == 4) {
						
						 
						
						 System.out.println("\n");
						 
						
						 System.out.println("========================= Welcome Admin!=========================");
							System.out.println("Available Outdoor Events" +"\n" +Avaiable_Outdoor_Events);
							System.out.println("Available Indoor Events"+"\n" +Avaiable_Indoor_Events);
					        
							System.out.print("You want to Add Event or Remove Event or Logout (add / remove) :");
							choice = scanner.next();
							
							if(choice.equals("add"))
							{
								  System.out.print("Enter The Event Type(OUTDOOR EVENTS ,outdoor events or INDOOR EVENTS,indoor events):");
						          Event_Add_type = scanner.next();
						          
						          System.out.print("Add Event No :");
						          Add_Event_No = scanner.nextInt();
						          
						          eventservice.Add_Outdoor_Indoor_Events(Event_Add_type,Avaiable_Outdoor_Events,Avaiable_Indoor_Events,Add_Event_No);
								
							}
							else if(choice.equals("remove"))
							{
								  System.out.print("Enter The Event Type(OUTDOOR EVENTS , outdoor evnts or INDOOR EVENTS , indoor events):");
						          Event_Add_type = scanner.next();
						          
						          System.out.print("Remove Event Number:");
						          Remove_Event_No = scanner.nextInt();
									
						          eventservice.Remove_Outdoor_Indoor_Events(Event_Add_type, Avaiable_Outdoor_Events, Avaiable_Indoor_Events, Remove_Event_No);
							}	
						
					}
					else {
						System.out.print("Invalid");
					}
				}
			
				else if (choice == "cashier") {

					System.out.println("~~~~~~~~~~~ Welcome Cashier ~~~~~~~~~~~");
					System.out.println("1. Food");
					System.out.println("2. Rooms");
					System.out.println("3. Game");
					System.out.println("4. Event");
					
					System.out.println("Enter the Fields(1,2,3,4):");
					field = scanner.nextInt();
					
					if(field==1) {
					
						while(true) {
							float total =0;
							System.out.print("You wont logout? (y / n) : ");
							choice = scanner.next();
							System.out.print("\n");
							if(choice.equals("y")) {
								break;
							}else {
								foodbillingservice.printItemList();
								System.out.println("<< If need get total enter 0 >>");
								System.out.println("_______________Bill_________________");
								int count = 0;
								while(true) {
									System.out.print("Enter Item Id : ");
									itemId = scanner.nextInt();
									if(itemId == 0) {
										break;
									}else if((itemId<=foodbillingservice.getListSize()) && itemId>0) {
										System.out.print("Enter Qty : ");
										int Qty = (int) scanner.nextFloat();
										total = total + foodbillingservice.calculateBill(itemId, Qty, count);
										System.out.println("---------------------------");
										count++;
									}else {
										System.out.println("Error : invalide input");
									}
								}
								System.out.println("---------------------------");
								System.out.println("Tatal Amount = " + total);
								System.out.print("Enter Discount % : " );
								discount = scanner.nextFloat();
								float subTotal = foodbillingservice.calcSubTotal(total, discount);
								System.out.println("===========================");
								System.out.println("Sub Tatal = " + subTotal);
								System.out.println("===========================");
								System.out.print("Enter Cash : " );
								cash = scanner.nextFloat();
								balance = foodbillingservice.calcBalance(subTotal, cash);
								System.out.println("Balance = " + balance);
								System.out.println("No of Items = " + count);
								System.out.println("____________________________________");
					}
					
					
						}
					}
					else if(field==2) {
						 
						System.out.println("========================= Welcome Cashier=========================");
				    	
				    	 System.out.println("1. A/C Room Charge: Rs 2500/=");
						 System.out.println("2. Non A/C Room Charge: Rs 2000/=");		    	
				    	 
						 System.out.println("\n");
						 
						 System.out.println("Available A/C Rooms:"+ "\n" +Avaiable_AC_Rooms);
						 System.out.println("Available NON A/C Rooms:" + "\n" +Avaiable_NON_AC_Rooms);
						 
					  	  
					     System.out.print("Enter The Room Service Type(BOOK,book or RELEASE,Release):");
				         Book_Release_Room = scanner.next();
				         
				         if((Book_Release_Room.equals("BOOK") || Book_Release_Room.equals("book")) )
				         { 
					          System.out.print("Enter The Room Type(AC,ac or NON_AC,non_ac):");
					          Room_type = scanner.next();
					
					         System.out.print("Enter The Number Of Rooms:");
					         no_of_rooms = scanner.nextInt();
				         }
					    
					
					 if(Room_type.length() == 0 || Book_Release_Room.length() == 0)
					 {
						 break;
					 }	 
					 else if(roomservice == null)
					 {
						 System.out.println("No Service Available");
					 }		 
					 else if((Book_Release_Room.equals("BOOK") || Book_Release_Room.equals("book")) )
					 {  
						
						 if(Room_type.equals("AC") || Room_type.equals("ac"))
						 { 
							 roomservice.Book_AC_Room(no_of_rooms,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Booked_Rooms);
						 
						 }
						 else if(Room_type.equals("NON_AC") || Room_type.equals("non_ac"))
						 {
							 roomservice.Book_NON_AC_Room(no_of_rooms,Avaiable_NON_AC_Rooms,Avaiable_AC_Rooms,Booked_Rooms);
						 }
						 else
						 {
							 System.out.println("Room Type is not  Available");
						 }	 
				  
					 }	 
					 else if((Book_Release_Room.equals("RELEASE") || Book_Release_Room.equals("release")))
					 {
						 
							 
							 System.out.print("Enter The Release Room No:");
		                     Booked_Room_No = scanner.nextInt();
							 
							 roomservice.ReleaseRoom(Booked_Room_No,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Booked_Rooms);
					    
					 }
					 else
					 {
						 System.out.println("Type is not Available");
						 
					 }						 
				   } 
				else if(field==3){
					
					 
					System.out.println("========================= Welcome Cashier=========================");
			    	
			    	 System.out.println("1. Field Game Per Charge: Rs 3000/=");
					 System.out.println("2. Water Games Per Charge: Rs 5000/=");		    	
			    	 
					 System.out.println("\n");
					 
					 System.out.println("Available Field Games:"+ "\n" +Avaiable_Field_Games);
					 System.out.println("Available Water Games:" + "\n" +Avaiable_Water_Games);
					 
				  	  
				     System.out.print("Enter The Game Service Type(BOOK,book or RELEASE,Release):");
			         Book_Release_Game = scanner.next();
			         
			         if((Book_Release_Game.equals("BOOK") || Book_Release_Game.equals("book")) )
			         { 
				          System.out.print("Enter The Game Type(Field,Field or Water,Water):");
				          Game_type = scanner.next();
				
				         System.out.print("Enter The Number Of Games:");
				         no_of_games = scanner.nextInt();
			         }
				    
				
				 if(Game_type.length() == 0 || Book_Release_Game.length() == 0)
				 {
					 break;
				 }	 
				 else if(gameservice == null)
				 {
					 System.out.println("No Service Available");
				 }		 
				 else if((Book_Release_Game.equals("BOOK") || Book_Release_Game.equals("book")) )
				 {  
					
					 if(Game_type.equals("Field") || Game_type.equals("field"))
					 { 
						 gameservice.Book_Field_Game(no_of_games,Avaiable_Field_Games,Avaiable_Water_Games,Booked_Games);
					 
					 }
					 else if(Game_type.equals("Water") || Game_type.equals("water"))
					 {
						 gameservice.Book_Water_Game(no_of_games,Avaiable_Water_Games,Avaiable_Field_Games,Booked_Games);
					 }
					 else
					 {
						 System.out.println("Game Type is not  Available");
					 }	 
			  
				 }	 
				 else if((Book_Release_Game.equals("RELEASE") || Book_Release_Game.equals("release")))
				 {
					 
						 
						 System.out.print("Enter The Release Game No:");
	                     Booked_Game_No = scanner.nextInt();
						 
	                     gameservice.ReleaseGame(Booked_Game_No,Avaiable_Water_Games,Avaiable_Field_Games,Booked_Games);
				    
				 }
				 else
				 {
					 System.out.println("Type is not Available");
					 
				 }	
				 
					
					}
				else if(field==4) {
					
					
					System.out.println("========================= Welcome Cashier=========================");
			    	
			    	 System.out.println("1. Outdoor Event Charge: Rs 2000/=");
					 System.out.println("2. Indoor Event Charge: Rs 1500/=");		    	
			    	 
					 System.out.println("\n");
					 
					 System.out.println("Available Outdoor Events:"+ "\n" +Avaiable_Outdoor_Events);
					 System.out.println("Available Indoor Events:" + "\n" +Avaiable_Indoor_Events);
					 
				  	  
				     System.out.print("Enter The Event Service Type(BOOK,book or RELEASE,Release):");
			         Book_Release_Event = scanner.next();
			         
			         if((Book_Release_Event.equals("BOOK") || Book_Release_Event.equals("book")) )
			         { 
				          System.out.print("Enter The Event Type(OUTDOOR EVENTS,outdoor events or INDOOR EVENTS,indoor events):");
				          Event_type = scanner.next();
				
				         System.out.print("Enter The Number Of Events:");
				         no_of_event = scanner.nextInt();
			         }
				    
				
				 if(Event_type.length() == 0 || Book_Release_Event.length() == 0)
				 {
					 break;
				 }	 
				 else if(eventservice == null)
				 {
					 System.out.println("No Service Available");
				 }		 
				 else if((Book_Release_Event.equals("BOOK") || Book_Release_Event.equals("book")) )
				 {  
					
					 if(Event_type.equals("OUTDOOR") || Event_type.equals("outdoor"))
					 { 
						 eventservice.Book_Outdoor_Events(no_of_event,Avaiable_Outdoor_Events,Avaiable_Indoor_Events,Booked_Events);
					 
					 }
					 else if(Event_type.equals("INDOOR") || Event_type.equals("indoor"))
					 {
						 eventservice.Book_Indoor_Events(no_of_event,Avaiable_Indoor_Events,Avaiable_Outdoor_Events,Booked_Events);
					 }
					 else
					 {
						 System.out.println("Event Type is not  Available");
					 }	 
			  
				 }	 
				 else if((Book_Release_Event.equals("RELEASE") || Book_Release_Event.equals("release")))
				 {
					 
						 
						 System.out.print("Enter The Release Event No:");
	                     Booked_Event_No = scanner.nextInt();
						 
						 eventservice.ReleaseEvent(Booked_Event_No,Avaiable_Outdoor_Events,Avaiable_Indoor_Events,Booked_Events);
				    
				 }
				 else
				 {
					 System.out.println("Type is not Available");
					 
				 }	
				 
				}
				    
				
				}
				else {
					System.out.println("Incorrect login");
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}

	public void stop(BundleContext Context) throws Exception {
		System.out.println("Stop Hotel Consumer Service!!!Good Bye!");
		Context.ungetService(serviceReference);
	}
}