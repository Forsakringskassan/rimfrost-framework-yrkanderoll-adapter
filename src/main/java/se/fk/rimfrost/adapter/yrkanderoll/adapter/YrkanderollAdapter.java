package se.fk.rimfrost.adapter.yrkanderoll.adapter;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import se.fk.rimfrost.adapter.yrkanderoll.model.Yrkanderoll;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.YrkanderollControllerApi;
import java.util.UUID;

@SuppressWarnings("unused")
@ApplicationScoped
public class YrkanderollAdapter
{

   @ConfigProperty(name = "yrkanderoll.api.base-url")
   String yrkanderollBaseUrl;

   private YrkanderollControllerApi yrkanderollClient;

   @Inject
   YrkanderollMapper yrkanderollMapper;

   @PostConstruct
   void init()
   {
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.connectorProvider(new ApacheConnectorProvider());
      Client client = ClientBuilder.newClient(clientConfig);

      this.yrkanderollClient = WebResourceFactory.newResource(
            YrkanderollControllerApi.class,
            client.target(this.yrkanderollBaseUrl));
   }

   public Yrkanderoll getYrkanderoll(UUID yrkanderollId)
   {
      var apiResponse = yrkanderollClient.getYrkanderoll(yrkanderollId);
      return yrkanderollMapper.toYrkanderoll(apiResponse);
   }

}
