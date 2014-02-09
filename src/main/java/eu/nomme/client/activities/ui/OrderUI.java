package eu.nomme.client.activities.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import eu.nomme.client.activities.ui.interfaces.IOrderUI;

public class OrderUI extends Composite implements IOrderUI {

	private static OrderUIUiBinder uiBinder = GWT.create(OrderUIUiBinder.class);

	interface OrderUIUiBinder extends UiBinder<Widget, OrderUI> {
	}

	

	public OrderUI() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
	}
}
