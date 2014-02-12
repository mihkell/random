package eu.nomme.client.activities.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import eu.nomme.client.activities.ui.interfaces.IOrderUI;
import eu.nomme.resource.SiteResource;
import eu.nomme.resource.SiteResource.Order;

public class OrderUI extends Composite implements IOrderUI {

	private static OrderUIUiBinder uiBinder = GWT.create(OrderUIUiBinder.class);

	interface OrderUIUiBinder extends UiBinder<Widget, OrderUI> {
	}

	@UiField HTMLPanel htmlPanel;
	
	@UiField FlowPanel etsy;
	
	@UiField FlowPanel contact;

	private Order CSS;
	
	

	public OrderUI() {
		initWidget(uiBinder.createAndBindUi(this));
		SiteResource.INSTANCE.order().ensureInjected();
		CSS = SiteResource.INSTANCE.order();
		
		
		
		
	}
}
