package eu.nomme.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.nomme.client.ClientFactory;
import eu.nomme.client.activities.ui.interfaces.ICatalogueUI;
import eu.nomme.client.activities.ui.interfaces.ICatalogueUI.CatalogueUIActivity;
import eu.nomme.client.rpcinterfaces.GetContentService;
import eu.nomme.client.rpcinterfaces.GetContentServiceAsync;

public class CatalogueActivity extends AbstractActivity implements CatalogueUIActivity{
	private ClientFactory clientFactory;
	private ICatalogueUI catalogueUI;

	public CatalogueActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	GetContentServiceAsync rpcGetContent = GWT.create(GetContentService.class);

	String catalogueIntro = "All our items are engraved with an individual serial number.\n"
			+ "We use natural gems in our jewelry. No synthetic gems are used.";

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {


		catalogueUI = clientFactory.getCatalogueUI();

		catalogueUI.setTopText(catalogueIntro);

		panel.setWidget(catalogueUI);

	}
	
	public void setGallery(){
		
		
		
	}
	
	

}
