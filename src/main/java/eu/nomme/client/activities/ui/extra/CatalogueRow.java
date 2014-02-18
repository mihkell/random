package eu.nomme.client.activities.ui.extra;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import eu.nomme.resource.SiteResource;
import eu.nomme.resource.SiteResource.CatalogueRowCss;

public class CatalogueRow extends Composite {

	private static CatalogueRowUiBinder uiBinder = GWT
			.create(CatalogueRowUiBinder.class);

	interface CatalogueRowUiBinder extends UiBinder<Widget, CatalogueRow> {
	}


	@UiField HeadingElement titleH2;
	
	@UiField SpanElement title;
	
	@UiField FlowPanel container;

	private CatalogueRowCss CSS;

	public CatalogueRow(String titleText) {
		initWidget(uiBinder.createAndBindUi(this));
		
		SiteResource.INSTANCE.catalogueRow().ensureInjected();
		
		CSS = SiteResource.INSTANCE.catalogueRow();
		
		setTitel(titleText);
		
	}

	public void setTitel(String titleString){

		title.setInnerHTML(titleString);

	}

	public void addImage(Image img){

		img.setStyleName(CSS.clippedImage());
		
		container.add(img);

	}



}
