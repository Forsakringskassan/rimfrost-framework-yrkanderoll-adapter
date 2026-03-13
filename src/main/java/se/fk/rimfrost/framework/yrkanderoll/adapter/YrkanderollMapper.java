package se.fk.rimfrost.framework.yrkanderoll.adapter;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.framework.yrkanderoll.adapter.dto.Yrkanderoll;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetYrkanderollResponse;
import se.fk.rimfrost.framework.yrkanderoll.adapter.dto.ImmutableYrkanderoll;

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
