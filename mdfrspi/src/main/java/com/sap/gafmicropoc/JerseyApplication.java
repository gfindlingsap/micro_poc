/*
 * Created with [y] YaaS Service SDK version 4.13.6.
 */
package com.sap.gafmicropoc;


import com.sap.cloud.yaas.servicesdk.jerseysupport.features.BeanValidationFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.JerseyFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.JsonFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.PatchFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.SecurityFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.logging.RequestResponseLoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the REST application.
 */
public class JerseyApplication extends ResourceConfig
{

	private static final Logger LOG = LoggerFactory.getLogger(JerseyApplication.class);

	/**
	 * Initializes the jersey application.
	 */
	public JerseyApplication()
	{
		// enable error responses in JSON format
		register(JerseyFeature.class);

		// enable JSON support
		register(JsonFeature.class);

		// hybris-scopes support for @RolesAllowed
		register(SecurityFeature.class);

		// bean validation support
		register(BeanValidationFeature.class);

		// register resources and providers of the application
		packages(getClass().getPackage().toString());

		// patch support
		register(PatchFeature.class);

		// log incoming requests
		register(new RequestResponseLoggingFilter(LOG));
	}
}
