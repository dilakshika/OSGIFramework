package osgi_room_service_producer;


import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;

import osgi_room_service_producer.RoomReservationService;
import osgi_room_service_producer.RoomReservationServiceImpl;

import org.osgi.framework.ServiceEvent;

public class Activator implements BundleActivator {
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("Language","English");
		bundleContext.registerService(RoomReservationService.class.getName(),new RoomReservationServiceImpl(),props);
		System.out.println("Room Producer Service registered and started successfully!!!");
		
	}
	@Override

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Room Producer Service  stop successfully!!!");
	}
}
