package eu.nomme.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import eu.nomme.client.places.AboutPlace;
import eu.nomme.client.places.CataloguePlace;
import eu.nomme.client.places.ContactPlace;
import eu.nomme.client.places.HomePlace;
import eu.nomme.client.places.OrderPlace;


@WithTokenizers({ HomePlace.Tokenizer.class, AboutPlace.Tokenizer.class,
	ContactPlace.Tokenizer.class, CataloguePlace.Tokenizer.class, OrderPlace.Tokenizer.class  })
public interface SitePlaceHistoryMapper extends PlaceHistoryMapper {
}
