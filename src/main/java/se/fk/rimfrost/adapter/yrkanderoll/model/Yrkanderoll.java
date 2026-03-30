package se.fk.rimfrost.adapter.yrkanderoll.model;

import org.immutables.value.Value;
import java.util.UUID;

@Value.Immutable
public interface Yrkanderoll
{

   UUID id();

   String version();

   String namn();
}
