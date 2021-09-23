package osgi_game_service_producer;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

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
		bundleContext.registerService(ServicePublish.class.getName(),new ServicePublishImpl(),props);
		System.out.println("Game Producer Service registered and started successfully!!!");
		
	}
	@Override

	public void stop(BundleContext bundleContext) throws Exception {
		ServiceActivator.context = null;
		System.out.println("Game Producer Service  stop successfully!!!");
	}

}
