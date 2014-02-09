package eu.nomme.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class CataloguePlace extends Place {
	
	@Prefix("CATALOGUE")
	public static class Tokenizer implements PlaceTokenizer<CataloguePlace>{

		@Override
		public CataloguePlace getPlace(String token) {
			return new CataloguePlace();
		}

		@Override
		public String getToken(CataloguePlace place) {
			return "catalogue";
		}
		
		
		
	}

}
