package eu.nomme.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import eu.nomme.client.activities.ui.interfaces.IAboutUI;
import eu.nomme.client.activities.ui.interfaces.ICatalogueUI;
import eu.nomme.client.activities.ui.interfaces.IContactUI;
import eu.nomme.client.activities.ui.interfaces.IHomeUI;
import eu.nomme.client.activities.ui.interfaces.IOrderUI;
import eu.nomme.client.activities.ui.interfaces.IHomeUI.IHomeUIAcitvity;


public interface ClientFactory {

   
    EventBus getEventBus();

    PlaceController getPlaceController();
    
    IHomeUI getHomeUI();
    
    IAboutUI getAboutUI();
    
    ICatalogueUI getCatalogueUI();
    
    IOrderUI getOrderUI();
    
    IContactUI geContactUI();

    void setSitePlaceHistoryMapper(SitePlaceHistoryMapper sitePlaceHistoryMapper);

	SitePlaceHistoryMapper getHistoryMapper();
 

}
