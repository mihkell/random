package eu.nomme.shared;

import java.util.List;

public class SimpleItem implements JewelryItem {

	private List<String> images;
	private String type;
	private String name;

	@Override
	public boolean addImage(String url) {
		return images.add(url);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public List<String> getImages() {
		return images;
	}

	@Override
	public SimpleItem setName(String name) {
		this.name = name;
	
		return this;
	}

	@Override
	public SimpleItem setType(String type) {
		this.type = type;
		return this;
	}

	@Override
	public SimpleItem setImages(List<String> images) {
		this.images = images;
		return this;
	}

}
