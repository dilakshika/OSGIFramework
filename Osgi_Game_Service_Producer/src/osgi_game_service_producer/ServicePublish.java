package osgi_game_service_producer;


import java.util.ArrayList;

public interface ServicePublish {

	public void Book_Field_Game(int no_of_games,ArrayList Avaiable_Field_Games,ArrayList Avaiable_Water_Games,ArrayList Booked_Games);
	public void Book_Water_Game(int no_of_games,ArrayList Avaiable_Water_Games,ArrayList Avaiable_Field_Games,ArrayList Booked_Games);
	public void ReleaseGame(int Booked_Gameno,ArrayList Avaiable_Field_Games,ArrayList Avaiable_Water_Games,ArrayList Booked_Games);
	public String LoginVerification(String username,String password);
	public void Add_Field_Water_Games(String GameType,ArrayList Avaiable_Field_Games,ArrayList Avaiable_Water_Games,int roomno);
	public void Remove_Field_Water_Games(String GameType,ArrayList Avaiable_Field_Games,ArrayList Avaiable_Water_Games,int roomno);
}
