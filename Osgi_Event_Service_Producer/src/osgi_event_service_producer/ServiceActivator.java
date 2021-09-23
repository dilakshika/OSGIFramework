package osgi_event_service_producer;


import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import osgi_event_service_producer.EventServicePublish;
import osgi_event_service_producer.EventServicePublishImpl;

public class ServiceActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		ServiceActivator.context = bundleContext;
		
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("Language","English");
		bundleContext.registerService(EventServicePublish.class.getName(),new EventServicePublishImpl(),props);
		System.out.println("Event Producer Service registered and started successfully!!!");
		
	}
	@Override

	public void stop(BundleContext bundleContext) throws Exception {
		ServiceActivator.context = null;
		System.out.println("Event Producer Service  stop successfully!!!");
	}
	/*ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Publisher Start");
		ServicePublish publisherService = new ServicePublishImpl();
		
		publishServiceRegistration = context.registerService(ServicePublish.class.getName(), publisherService, null);

			
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Publisher Stop");
		publishServiceRegistration.unregister();*/
	/* } */

}
