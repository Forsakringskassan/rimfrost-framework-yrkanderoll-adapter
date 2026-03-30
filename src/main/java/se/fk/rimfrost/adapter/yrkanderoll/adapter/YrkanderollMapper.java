package se.fk.rimfrost.adapter.yrkanderoll.adapter;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.adapter.yrkanderoll.model.ImmutableYrkanderoll;
import se.fk.rimfrost.adapter.yrkanderoll.model.Yrkanderoll;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetYrkanderollResponse;

@ApplicationScoped
public class YrkanderollMapper
{

   public Yrkanderoll toYrkanderoll(GetYrkanderollResponse apiResponse)
   {
      var responseBuilder = ImmutableYrkanderoll.builder()
            .id(apiResponse.getYrkanderoll().getId())
            .version(apiResponse.getYrkanderoll().getVersion())
            .namn(apiResponse.getYrkanderoll().getNamn());
      return responseBuilder.build();
   }
}
