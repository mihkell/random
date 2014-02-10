package eu.nomme.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import eu.nomme.client.activities.ui.AboutUI;
import eu.nomme.client.activities.ui.CatalogueUI;
import eu.nomme.client.activities.ui.HomeUI;
import eu.nomme.client.activities.ui.OrderUI;
import eu.nomme.client.activities.ui.interfaces.IAboutUI;
import eu.nomme.client.activities.ui.interfaces.ICatalogueUI;
import eu.nomme.client.activities.ui.interfaces.IContactUI;
import eu.nomme.client.activities.ui.interfaces.IHomeUI;
import eu.nomme.client.activities.ui.interfaces.IOrderUI;

public class ClientFactoryImpl implements ClientFactory {
	
	
	
	private EventBus eventBus =  new SimpleEventBus();
	
	private PlaceController placeController = new PlaceController(eventBus);
	
	private SitePlaceHistoryMapper sitePlaceHistoryMapper;
	
	private ICatalogueUI catalogueUI = new CatalogueUI();

	private IAboutUI aboutUI = new AboutUI();
	
	private IOrderUI orderUI = new OrderUI();
	
	private IHomeUI homeUI;

	private SimplePanel mainPanel;
	
	public ClientFactoryImpl(SimplePanel simplePanel, SimplePanel mainPanel){
		
		this.mainPanel = mainPanel;
		homeUI = new HomeUI(simplePanel);
		
	}
	

	@Override
	public EventBus getEventBus() {
		
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public IHomeUI getHomeUI() {
		return homeUI;
	}

	@Override
	public void setSitePlaceHistoryMapper(
			SitePlaceHistoryMapper sitePlaceHistoryMapper) {
				this.sitePlaceHistoryMapper = sitePlaceHistoryMapper;
	}
	
	public SitePlaceHistoryMapper getHistoryMapper(){
		return sitePlaceHistoryMapper;
	}


	@Override
	public IAboutUI getAboutUI() {
		return aboutUI ;
	}


	@Override
	public ICatalogueUI getCatalogueUI() {
		return catalogueUI;
	}


	@Override
	public IOrderUI getOrderUI() {
		return orderUI;
	}


	@Override
	public IContactUI geContactUI() {
		return null;
	}


	/**
	 * @return the mainPanel
	 */
	public SimplePanel getMainPanel() {
		return mainPanel;
	}
}
