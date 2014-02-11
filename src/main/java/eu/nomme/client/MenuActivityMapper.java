package eu.nomme.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import eu.nomme.client.activities.HomeActivity;
import eu.nomme.client.places.AboutPlace;
import eu.nomme.client.places.CataloguePlace;
import eu.nomme.client.places.ContactPlace;
import eu.nomme.client.places.HomePlace;
import eu.nomme.client.places.OrderPlace;

public class MenuActivityMapper implements ActivityMapper {
	
	private HomeActivity homeActivity;

	public MenuActivityMapper(ClientFactory clientFactory) {
        homeActivity = new HomeActivity(clientFactory);
	}
	

	@Override
	public Activity getActivity(Place place) {
		if(place.getClass() == HomePlace.class || 
				place.getClass() == OrderPlace.class ||
				place.getClass() == AboutPlace.class || 
				place.getClass() == ContactPlace.class ||
				place.getClass() == CataloguePlace.class 
				)
			return homeActivity;
		
		return null;
	}

}
