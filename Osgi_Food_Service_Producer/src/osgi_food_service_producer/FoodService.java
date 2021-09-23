package osgi_food_service_producer;

import java.util.ArrayList;
public interface FoodService {

	public void defaultList();
	public void printItemList();
	public String LoginVerification(String username,String password);
	public void addItem(String itemName, float itemPrice);
	public void removeItem(int itemId);
	public float calculateBill(int itemId, int Qty,int count);
	public float calcSubTotal(float total, float discount);
	public int getListSize();
	public float calcBalance(float subTotal, float cash);
	
	public void Book_AC_Room(int no_of_rooms,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Booked_Rooms);
	public void Book_NON_AC_Room(int no_of_rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Avaiable_AC_Rooms,ArrayList Booked_Rooms);
	public void ReleaseRoom(int Booked_Roomno,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Booked_Rooms);
	public void Add_Ac_NonAc_Room(String RoomType,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,int roomno);
	public void Remove_Ac_NonAc_Room(String RoomType,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,int roomno);


}