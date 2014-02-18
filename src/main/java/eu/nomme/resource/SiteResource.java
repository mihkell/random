package eu.nomme.resource;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface SiteResource extends ClientBundle {

	public interface LightBox extends CssResource{

		String htmlPanel();
		String imageContainer();
		String thumnail();
		String thumnailContainer();
		String width();
		String mainImage();
		String backNext();
		String backBtn();
		String nextBtn();

	}

	public interface Catalogue extends CssResource{

		String htmlPanel();
		String topText();
		String gallery();

	}
	public interface CatalogueRowCss extends CssResource{

		String categoryName();
		String clippedImage();
		String itemsList();

	}
	public interface Menu extends CssResource{

		String htmlPanel();
		String sideMenus();
		String menuItem();
		String centerMenu();
		String centerMenuFront();
		String visible();
		String centerRow();
		String clicked();

	}

	public interface TextContent extends CssResource{

		String htmlPanel();
		String textImage();
		String textImageSize();
		String textBox();


	}
	
	public interface Order extends CssResource{

		String htmlPanel();
		String etsy();
		String contact();
		String container();
		String text();
		
	}


	public static final SiteResource INSTANCE = GWT.create(SiteResource.class);

	@Source("eu/nomme/resource/css/Order.css")
	Order order(); 
	
	@Source("eu/nomme/resource/css/TextContent.css")
	TextContent textContent(); 

	@Source("eu/nomme/resource/css/Nomme.css")
	Menu menu(); 

	@Source("eu/nomme/resource/css/Catalogue.css")
	Catalogue catalogue();
	
	@Source("eu/nomme/resource/css/CatalogueRow.css")
	CatalogueRowCss catalogueRow();

	@Source("eu/nomme/resource/css/SimpleLightBox.css")
	LightBox lightBox();

	@Source("eu/nomme/resource/img/about.jpg")
	ImageResource aboutimg();

	@Source("eu/nomme/resource/mainText.rtf")
	TextResource aboutText();


}
