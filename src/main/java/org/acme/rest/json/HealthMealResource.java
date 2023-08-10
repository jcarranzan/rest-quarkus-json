package org.acme.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("health-meals")
public class HealthMealResource {
  private Set<HealthyMeal> healthyMealSet = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

  public HealthMealResource() {
    healthyMealSet.add(new HealthyMeal("Broccoli with rice", "Broccoli is source of vitamins and fiber, while rice provides energy as carbohydrates"));
    healthyMealSet.add(new HealthyMeal("Kefir","rich in probiotics and benefits for digestion"));
  }
 @GET
  public Set<HealthyMeal> getHealthyMealSet() {
    return healthyMealSet;
  }
  @POST
  public Set<HealthyMeal> add(HealthyMeal healthyMeal) {
    healthyMealSet.add(healthyMeal);
    return healthyMealSet;
  }
  @DELETE
  public Set<HealthyMeal> delete (HealthyMeal healthyMeal) {
    healthyMealSet.removeIf(existHealthyMeal -> existHealthyMeal.name.contentEquals(healthyMeal.name));
    return healthyMealSet;
  }
}
