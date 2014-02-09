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

import eu.nomme.client.activities.ui.interfaces.ICatalogueUI;

public class CatalogueUI extends Composite implements ICatalogueUI {

	private static CatalogueUIUiBinder uiBinder = GWT
			.create(CatalogueUIUiBinder.class);

	interface CatalogueUIUiBinder extends UiBinder<Widget, CatalogueUI> {
	}

	public CatalogueUI() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

}
