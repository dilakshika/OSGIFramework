package osgi_food_service_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext Context) throws Exception {
		System.out.println("Food Billing Service Start !!!");
		FoodService foodservice = new FoodServiceImpl();
		publishServiceRegistration = Context.registerService(
				FoodService.class.getName(), foodservice, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Food Billing Service Stop!!!");
		publishServiceRegistration.unregister();
	}
}
