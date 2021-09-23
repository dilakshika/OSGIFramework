package osgi_food_service_producer;



import java.util.ArrayList;

import java.util.Collections;

public class FoodServiceImpl implements FoodService{
	
	
	ArrayList<String> items = new ArrayList<String>();
	ArrayList<Float> price = new ArrayList<Float>();
	
	
		public void defaultList() {
			
			items.add("Rice and Curry");
			price.add((float) 200.00);
			
			items.add("Fried Rice");
			price.add((float) 280.00);
			
			items.add("Kottu");
			price.add((float) 250.00);
			
			items.add("Noodles");
			price.add((float) 180.00);
			
			items.add("Pizza");
			price.add((float) 1000.00);
		}

		public void printItemList() {
			System.out.println("------------Item List-------------");
			for (int i = 0; i < price.size(); i++)
			  {
		        System.out.println(i+1 + "  " +items.get(i) +"  Rs:"+price.get(i));
		      }
			System.out.println("----------------------------------");
		}
		
		public String LoginVerification(String username,String password) {
			if((username.equals("admin")) && (password.equals("123"))){
				return "admin";
			}
			else if((username.equals("cashier")) && (password.equals("789"))) {
				return "cashier";
			}else {
				return "invalid";
			}
		}
		
		public void addItem(String itemName, float itemPrice) {
			items.add(itemName);
			price.add((float) itemPrice);
		}
		
		public void removeItem(int itemId) {
			items.remove(itemId-1);
			price.remove(itemId-1);
		}
		
		public float calculateBill(int itemId, int Qty,int count) {
			float itemPrice = price.get(itemId-1);
			float total = (itemPrice*Qty);
			System.out.println((count+1) +") "+ items.get(itemId-1) +" X "+ Qty + " = " + total);
			return total;
		}
		
		public float calcSubTotal(float total, float discount) {
			float subtotal = (total-((total/100)*discount));
			return subtotal;
		}

		public int getListSize() {
			
			return items.size();
		}
		
		public float calcBalance(float subTotal, float cash) {
			
			return (cash - subTotal);
		}
		
		 public void   Book_AC_Room(int no_of_rooms,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList ReserveRooms) {
				// TODO Auto-generated method stub
				 
				if(no_of_rooms <= Avaiable_AC_Rooms.size())
				{
					for(int i=0;i<no_of_rooms;i++)
					{
					  int j=0;
					  int room = (int) Avaiable_AC_Rooms.remove(j);
					  ReserveRooms.add(room);
					}
					System.out.println("**********************************************");
					
					Total_Room_Charge = no_of_rooms * 2000;
					
				    System.out.println("Total Room Charges:"+Total_Room_Charge);
				    System.out.print("\n");
				    Collections.sort(Avaiable_AC_Rooms);
				    Collections.sort(Avaiable_NON_AC_Rooms);
				    System.out.println("Available AC Rooms"+ "\n" +Avaiable_AC_Rooms);
				    System.out.println("Available non AC Rooms"+ "\n" +Avaiable_NON_AC_Rooms);
				    System.out.print("\n");
					
				}
				else
				{
					System.out.println("Sorry!!!Number of Available AC Rooms less than No of Rooms that You want");
				}	
			
		      }
			
			public void   Book_NON_AC_Room(int no_of_rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Avaiable_AC_Rooms,ArrayList ReserveRooms) {
				// TODO Auto-generated method stub
				 
				if(no_of_rooms <= Avaiable_NON_AC_Rooms.size())
				{
					for(int i=0;i<no_of_rooms;i++)
					{  
						int j=0;
					    int room = (int) Avaiable_NON_AC_Rooms.remove(j);
					    ReserveRooms.add(room);
					    
					}
				    System.out.print("\n");
					Total_Room_Charge = no_of_rooms * 1500;
					
					System.out.println("**********************************************");
					
				    System.out.println("Total Room Charges:"+Total_Room_Charge);
				    System.out.print("\n");
				    
				    System.out.println("Available AC Rooms"+ "\n"+ Avaiable_AC_Rooms);
				    System.out.println("Available non AC Rooms"+ "\n" +Avaiable_NON_AC_Rooms);
				    System.out.print("\n");
				}
				else
				{
					System.out.println("Sorry!!!Number of Available NON AC Rooms less than No of Rooms  that You want ");
				}	
				
			
		      }
			public void  ReleaseRoom(int Booked_Roomno,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Booked_Rooms)
			{
				  for(int i=0;i<Booked_Rooms.size();i++)
				  {
					   if(Booked_Roomno == (int)Booked_Rooms.get(i))
					   {
						   if((int)Booked_Rooms.get(i) <= 5)
						   {
							   Avaiable_AC_Rooms.add((int)Booked_Rooms.get(i));
							   Booked_Rooms.remove(i);
							   Collections.sort(Avaiable_AC_Rooms);
							    Collections.sort(Avaiable_NON_AC_Rooms);
							   System.out.println("Available AC Rooms"+Avaiable_AC_Rooms);
							   System.out.println("Available Non AC Rooms"+Avaiable_NON_AC_Rooms);
							   System.out.print("\n");
						   }
						   else if((int)Booked_Rooms.get(i) >=5 && (int)Booked_Rooms.get(i) <=10 )
						   {
							   Avaiable_NON_AC_Rooms.add((int)Booked_Rooms.get(i));
							   Booked_Rooms.remove(i);
							    Collections.sort(Avaiable_AC_Rooms);
							    Collections.sort(Avaiable_NON_AC_Rooms);
							   System.out.println("Available AC Rooms"+Avaiable_AC_Rooms);
							   System.out.println("Available Non AC Rooms"+Avaiable_NON_AC_Rooms);
							   System.out.print("\n");
						   }
						   
						   
						   
					   }
					  
					  
				  }
				
					
			}
			 float Total_Room_Charge = (float) 0.0;
			 int Release_Room;

		    
				
				
			 
			public void Add_Ac_NonAc_Room(String RoomType,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,int roomno)
			{
				if(RoomType.equals("AC") || RoomType.equals("ac"))
				{
					Avaiable_AC_Rooms.add(roomno);
					 System.out.println("**********************************************");
					 System.out.println("New AC Room Added - "+"Room Number"+roomno);  
			       	  
					
					    Collections.sort(Avaiable_AC_Rooms);
					    Collections.sort(Avaiable_NON_AC_Rooms);
					    System.out.println("Available AC Rooms:"+Avaiable_AC_Rooms);
					    System.out.println("Available Non AC Rooms:"+Avaiable_NON_AC_Rooms);
					
				}
				 else if(RoomType.equals("NONAC") || RoomType.equals("nonac"))
		        {
		       	   Avaiable_NON_AC_Rooms.add(roomno);
		       	   System.out.println("**********************************************");
		       	   System.out.println("New Non AC Room Added - "+"Room Number"+roomno);  
		       	  
		       	    Collections.sort(Avaiable_AC_Rooms);
				    Collections.sort(Avaiable_NON_AC_Rooms);
				    System.out.println("Available AC Rooms:"+Avaiable_AC_Rooms);
				    System.out.println("Available Non AC Rooms:"+Avaiable_NON_AC_Rooms);
		        }	 
				
			}
			public void Remove_Ac_NonAc_Room(String RoomType,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,int roomno)
			{
				if(RoomType.equals("AC") || RoomType.equals("ac"))
				{
					for(int i=0;i<Avaiable_AC_Rooms.size();i++)
					{
						if(roomno == (int)Avaiable_AC_Rooms.get(i))
						{
							Avaiable_AC_Rooms.remove(i);
							 System.out.println("**********************************************");
							 System.out.println("New AC Room Removed "+"Room Number"+roomno);  
					       	  
						    
						    Collections.sort(Avaiable_AC_Rooms);
						    Collections.sort(Avaiable_NON_AC_Rooms);
						    System.out.println("Available AC Rooms"+ "\n"+ Avaiable_AC_Rooms);
						    System.out.println("Available Non AC Rooms"+ "\n" + Avaiable_NON_AC_Rooms);
						}
						
					}
				}
				 else if(RoomType.equals("NONAC") || RoomType.equals("nonac"))
		        { 
					 for(int i=0;i<Avaiable_NON_AC_Rooms.size();i++)
						{
							if(roomno == (int)Avaiable_NON_AC_Rooms.get(i))
							{
								Avaiable_NON_AC_Rooms.remove(i);
								 System.out.println("**********************************************");
								 System.out.println("Non AC Room Removed "+"Room Number"+roomno);  
						       	  
								
								
								Collections.sort(Avaiable_AC_Rooms);
								Collections.sort(Avaiable_NON_AC_Rooms);
								System.out.println("Available AC Rooms:"+ "\n" +Avaiable_AC_Rooms);
								System.out.println("Available NON AC Rooms:"+"\n"+ Avaiable_NON_AC_Rooms);
							}
							
						}
		       	  
		       	  
		        }	
				
			}
			

		
}
