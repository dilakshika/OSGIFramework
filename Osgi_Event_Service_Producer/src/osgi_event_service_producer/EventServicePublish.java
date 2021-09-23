package osgi_event_service_producer;

import java.util.ArrayList;

public interface EventServicePublish {
	
	public void Book_Outdoor_Events(int no_of_events,ArrayList Avaiable_Outdoor_Events,ArrayList Avaiable_Indoor_Events,ArrayList Booked_Events);
	public void Book_Indoor_Events(int no_of_events,ArrayList Avaiable_Indoor_Events,ArrayList Avaiable_Outdoor_Events,ArrayList Booked_Events);
	public void ReleaseEvent(int Booked_Eventno,ArrayList Avaiable_Outdoor_Events,ArrayList Avaiable_Indoor_Events,ArrayList Booked_Events);
	public String LoginVerification(String username,String password);
	public void Add_Outdoor_Indoor_Events(String EventType,ArrayList Avaiable_AC_Events,ArrayList Avaiable_Outdoor_Events,int eventno);
	public void Remove_Outdoor_Indoor_Events(String EventType,ArrayList Avaiable_Outdoor_Events,ArrayList Avaiable_Indoor_Events,int eventno);
	

	/* public String publishService(); */
}
