package eu.nomme.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import eu.nomme.client.activities.AboutActivity;
import eu.nomme.client.activities.CatalogueActivity;
import eu.nomme.client.activities.ContactActivity;
import eu.nomme.client.activities.OrderActivity;
import eu.nomme.client.places.AboutPlace;
import eu.nomme.client.places.CataloguePlace;
import eu.nomme.client.places.ContactPlace;
import eu.nomme.client.places.OrderPlace;


/**
 * 
 */
public class ContentActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;

    public ContentActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;	
    }

    @Override
    public Activity getActivity(Place place) {
    	if(place.getClass() == AboutPlace.class) return new AboutActivity(clientFactory);
    	if(place.getClass() == OrderPlace.class) return new OrderActivity(clientFactory);
    	if(place.getClass() == CataloguePlace.class) return new CatalogueActivity(clientFactory);
    	if(place.getClass() == ContactPlace.class) return new ContactActivity(clientFactory);
    	
    	
   
        return null;
    }
}
