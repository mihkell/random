package eu.nomme.client.activities.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import eu.nomme.client.activities.ui.extra.CatalogueRow;
import eu.nomme.client.activities.ui.extra.SimpleLightBox;
import eu.nomme.client.activities.ui.interfaces.ICatalogueUI;
import eu.nomme.resource.SiteResource;
import eu.nomme.resource.SiteResource.Catalogue;

public class CatalogueUI extends Composite implements ICatalogueUI {

	private static CatalogueUIUiBinder uiBinder = GWT
			.create(CatalogueUIUiBinder.class);

	interface CatalogueUIUiBinder extends UiBinder<Widget, CatalogueUI> {
	}

	@UiField HTMLPanel htmlPanel;
	@UiField VerticalPanel gallery;
	@UiField HTML topText;
	private Catalogue CSS;

	public CatalogueUI() {
		initWidget(uiBinder.createAndBindUi(this));
		SiteResource.INSTANCE.catalogue().ensureInjected();
		CSS = SiteResource.INSTANCE.catalogue();

		HashMap<String, List<String[]>> map = new HashMap<String, List<String[]>>();
		List<String[]> list = new ArrayList<String[]>();

		String[] catNames = { "Rings", "Pendants", "Bracelet", "Brooches", "Earrings", "Cufflinks"  };

		final String[] imageArray = { "test1.jpg", "test2.jpg", "test3.jpg" };

		list.add(imageArray);
		list.add(imageArray);
		list.add(imageArray);
		list.add(imageArray);

		for (String s : catNames) {

			map.put(s, list);

		}

		// gallery.add(new Image("src/main/resources/serverimg.jpg"));

		if (map.size() != 0)
			addCategory(map);

	}

	public void setTopText(String text) {

		this.topText.setText(text); 

	}

	public void addCategory(Map<String, List<String[]>> Category) {

		for (Entry<String, List<String[]>> entry : Category.entrySet()) {

			CatalogueRow row = new CatalogueRow(entry.getKey());
			
			for (final String[] urlArray : entry.getValue()) {

				Image img = new Image(urlArray[0]);
				
				img.addClickHandler(new ImgClickHandler(urlArray));
				
				row.addImage(img);
			}
			
			gallery.add(row);

		}

	}

	class ImgClickHandler implements ClickHandler{

		private String[] imgURL;

		public ImgClickHandler(String[] imgURL) {
			this.imgURL = imgURL;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			SimpleLightBox slb = new SimpleLightBox();
			slb.setImage(imgURL);
			slb.pop();

		}

	}

}
