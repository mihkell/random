package eu.nomme.resource;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface SiteResource extends ClientBundle {

	public interface LightBox extends CssResource{

		String htmlPanel();
		String imageContainer();
		String thumnail();
		String thumnailContainer();
		String width();

	}
	
	public interface Catalogue extends CssResource{
		
	}
	
	public static final SiteResource INSTANCE = GWT.create(SiteResource.class);
	
	@Source("eu/nomme/resource/css/Catalogue.css")
	Catalogue catalogue();

	@Source("eu/nomme/resource/css/SimpleLightBox.css")
	LightBox lightBox();
	
	@Source("eu/nomme/resource/img/test.jpg")
	ImageResource testImg();
	@Source("eu/nomme/resource/img/test1.jpg")
	ImageResource testImg1();
	@Source("eu/nomme/resource/img/test1-thum.jpg")
	ImageResource testImg1thum();
	@Source("eu/nomme/resource/img/test2.jpg")
	ImageResource testImg2();
	@Source("eu/nomme/resource/img/test2-thum.jpg")
	ImageResource testImg2thum();
	@Source("eu/nomme/resource/img/test3.jpg")
	ImageResource testImg3();
	@Source("eu/nomme/resource/img/test3-thum.jpg")
	ImageResource testImg3thum();
	

}
