package eu.nomme.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

import eu.nomme.client.places.HomePlace;

public class Nomme implements EntryPoint {
	
	private SimplePanel menuWidget = new SimplePanel();
	private SimplePanel contentWidget = new SimplePanel();
	private Place defaultPlace = new HomePlace();
	
	public void onModuleLoad() {
		
		ClientFactory clientFactory = new ClientFactoryImpl(contentWidget);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Menu mapper and manager
        ActivityMapper menuActivityMapper = new MenuActivityMapper(clientFactory);
        ActivityManager menuActivityManager = new ActivityManager(menuActivityMapper, eventBus);
        menuActivityManager.setDisplay(menuWidget);
        
        // Content mapper and manager
        ActivityMapper contentActivityMapper = new ContentActivityMapper(clientFactory);
        ActivityManager contentActivityManager = new ActivityManager(contentActivityMapper, eventBus);
        contentActivityManager.setDisplay(contentWidget);
        
        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        SitePlaceHistoryMapper historyMapper= GWT.create(SitePlaceHistoryMapper.class);
        final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        clientFactory.setSitePlaceHistoryMapper(historyMapper);
        
        RootPanel.get().add(menuWidget);
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();
        
		
		
		
	}

}
