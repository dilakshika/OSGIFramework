package osgi_game_service_producer;


import java.util.ArrayList;
import java.util.Collections;

public class ServicePublishImpl implements ServicePublish {

	float Total_Game_Charge = (float) 0.0;
	 int Release_Game;

	 public void   Book_Field_Game(int no_of_games,ArrayList Avaiable_Field_Games,ArrayList Avaiable_Water_Games,ArrayList ReserveGames) {
			// TODO Auto-generated method stub
			 
			if(no_of_games <= Avaiable_Field_Games.size())
			{
				for(int i=0;i<no_of_games;i++)
				{
				  int j=0;
				  int game = (int) Avaiable_Field_Games.remove(j);
				  ReserveGames.add(game);
				}
				System.out.println("**********************************************");
				
				Total_Game_Charge = no_of_games * 3000;
				
			    System.out.println("Total Game Charges:"+Total_Game_Charge);
			    System.out.print("\n");
			    Collections.sort(Avaiable_Field_Games);
			    Collections.sort(Avaiable_Water_Games);
			    System.out.println("Available Field Games"+ "\n" +Avaiable_Field_Games);
			    System.out.println("Available Water Games"+ "\n" +Avaiable_Water_Games);
			    System.out.print("\n");
				
			}
			else
			{
				System.out.println("Sorry!!!Number of Available Field Games less than No of Games that You want");
			}	
		
	      }
		
		public void   Book_Water_Game(int no_of_games,ArrayList Avaiable_Water_Games,ArrayList Avaiable_Field_Games,ArrayList ReserveGames) {
			// TODO Auto-generated method stub
			 
			if(no_of_games <= Avaiable_Water_Games.size())
			{
				for(int i=0;i<no_of_games;i++)
				{  
					int j=0;
				    int game = (int) Avaiable_Water_Games.remove(j);
				    ReserveGames.add(game);
				    
				}
			    System.out.print("\n");
			    Total_Game_Charge = no_of_games * 5000;
				
				System.out.println("**********************************************");
				
			    System.out.println("Total Room Charges:"+Total_Game_Charge);
			    System.out.print("\n");
			    
			    System.out.println("Available Field Games"+ "\n"+ Avaiable_Field_Games);
			    System.out.println("Available Water Games"+ "\n" +Avaiable_Water_Games);
			    System.out.print("\n");
			}
			else
			{
				System.out.println("Sorry!!!Number of Available Water Games less than No of Games  that You want ");
			}	
			
		
	      }
		public void  ReleaseGame(int Booked_Gameno,ArrayList Avaiable_Field_Games,ArrayList Avaiable_Water_Games,ArrayList Booked_Games)
		{
			  for(int i=0;i<Booked_Games.size();i++)
			  {
				   if(Booked_Gameno == (int)Booked_Games.get(i))
				   {
					   if((int)Booked_Games.get(i) <= 5)
					   {
						   Avaiable_Field_Games.add((int)Booked_Games.get(i));
						   Booked_Games.remove(i);
						   Collections.sort(Avaiable_Field_Games);
						    Collections.sort(Avaiable_Water_Games);
						   System.out.println("Available Field Games"+Avaiable_Field_Games);
						   System.out.println("Available Water Games"+Avaiable_Water_Games);
						   System.out.print("\n");
					   }
					   else if((int)Booked_Games.get(i) >=5 && (int)Booked_Games.get(i) <=10 )
					   {
						   Avaiable_Water_Games.add((int)Booked_Games.get(i));
						   Booked_Games.remove(i);
						    Collections.sort(Avaiable_Field_Games);
						    Collections.sort(Avaiable_Water_Games);
						   System.out.println("Available Field Games"+Avaiable_Field_Games);
						   System.out.println("Available Water Gamess"+Avaiable_Water_Games);
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
		public void Add_Field_Water_Games(String GameType,ArrayList Avaiable_Field_Games,ArrayList Avaiable_Water_Games,int gameno)
		{
			if(GameType.equals("Field") || GameType.equals("field"))
			{
				Avaiable_Field_Games.add(gameno);
				 System.out.println("**********************************************");
				 System.out.println("New Field Game Added - "+"Game Number"+gameno);  
		       	  
				
				    Collections.sort(Avaiable_Field_Games);
				    Collections.sort(Avaiable_Water_Games);
				    System.out.println("Available Field Games:"+Avaiable_Field_Games);
				    System.out.println("Available Water Games:"+Avaiable_Water_Games);
				
			}
			 else if(GameType.equals("Water") || GameType.equals("water"))
	        {
				 Avaiable_Water_Games.add(gameno);
	       	   System.out.println("**********************************************");
	       	   System.out.println("New Water Game Added - "+"Game Number"+gameno);  
	       	  
	       	    Collections.sort(Avaiable_Field_Games);
			    Collections.sort(Avaiable_Water_Games);
			    System.out.println("Available Field Games:"+Avaiable_Field_Games);
			    System.out.println("Available Water Games:"+Avaiable_Water_Games);
	        }	 
			
		}
		public void Remove_Field_Water_Games(String GameType,ArrayList Avaiable_Field_Games,ArrayList Avaiable_Water_Games,int gameno)
		{
			if(GameType.equals("Field") || GameType.equals("field"))
			{
				for(int i=0;i<Avaiable_Field_Games.size();i++)
				{
					if(gameno == (int)Avaiable_Field_Games.get(i))
					{
						Avaiable_Field_Games.remove(i);
						 System.out.println("**********************************************");
						 System.out.println("New Field Game Removed "+"Game Number"+gameno);  
				       	  
					    
					    Collections.sort(Avaiable_Field_Games);
					    Collections.sort(Avaiable_Water_Games);
					    System.out.println("Available Field Games"+ "\n"+ Avaiable_Field_Games);
					    System.out.println("Available Water Games"+ "\n" + Avaiable_Water_Games);
					}
					
				}
			}
			 else if(GameType.equals("Water") || GameType.equals("water"))
	        { 
				 for(int i=0;i<Avaiable_Water_Games.size();i++)
					{
						if(gameno == (int)Avaiable_Water_Games.get(i))
						{
							Avaiable_Water_Games.remove(i);
							 System.out.println("**********************************************");
							 System.out.println("Water Games Removed "+"Game Number"+gameno);  
					       	  
							
							
							Collections.sort(Avaiable_Field_Games);
							Collections.sort(Avaiable_Water_Games);
							System.out.println("Available Field Games:"+ "\n" +Avaiable_Field_Games);
							System.out.println("Available Water Games:"+"\n"+ Avaiable_Water_Games);
						}
						
					}
	       	  
	       	  
	        }	
			
		}
}

