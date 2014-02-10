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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import eu.nomme.client.activities.ui.extra.SimpleLightBox;
import eu.nomme.client.activities.ui.interfaces.ICatalogueUI;
import eu.nomme.resource.SiteResource;

public class CatalogueUI extends Composite implements ICatalogueUI {

	private static CatalogueUIUiBinder uiBinder = GWT
			.create(CatalogueUIUiBinder.class);

	interface CatalogueUIUiBinder extends UiBinder<Widget, CatalogueUI> {
	}
	
	@UiField HTMLPanel cHtmlPanel;
	@UiField VerticalPanel gallery;
	
	public CatalogueUI() {
		initWidget(uiBinder.createAndBindUi(this));
		SiteResource.INSTANCE.catalogue().ensureInjected();
		
		String[] catNames = {"RingsCategory", "PendantsCategory"};
		
		final String[] imageArray = {"test1.jpg","test2.jpg","test3.jpg"};
		
		
		HashMap<String, List<String[]>> map = new HashMap<String, List<String[]>>();
		List<String[]> list = new ArrayList<String[]>();
		list.add(imageArray);
		list.add(imageArray);
		list.add(imageArray);
		list.add(imageArray);
		
		for(String s: catNames){
			
			map.put(s, list);
			
		}
		
		addCategory(map);

	}

	public void addCategory(Map<String,List<String[]>> Category){

		for(Entry<String, List<String[]>> entry: Category.entrySet()){
			
			HTML catName = new HTML(entry.getKey());
			FlowPanel catList = new FlowPanel();
			gallery.add(catName);
			gallery.add(catList);
			catName.setWidth("100%");
			
			
			
			
			
			for(final String[] urlArray: entry.getValue()){
				
				Image img = new Image(urlArray[0]);
				img.setWidth("200px");
				catList.add(img);
				
				img.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						SimpleLightBox slb = new SimpleLightBox();
						slb.setImage(urlArray);
						slb.setPopupWidth("40vw");
						slb.pop();
						
					}
				});
				
			}
			
			
		}
		

	}

}
