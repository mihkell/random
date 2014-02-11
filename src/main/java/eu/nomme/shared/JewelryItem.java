package eu.nomme.shared;

import java.util.List;

public interface JewelryItem {
	
	boolean addImage(String url);

	String getName();
	String getType();
	List<String> getImages();
	
	JewelryItem setName(String name);
	JewelryItem setType(String type);
	JewelryItem setImages(List<String> images);
	
	
}
