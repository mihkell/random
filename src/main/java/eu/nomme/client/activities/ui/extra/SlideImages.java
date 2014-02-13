package eu.nomme.client.activities.ui.extra;

import java.util.List;

import com.google.gwt.user.client.ui.Image;


public class SlideImages {

	private Image[] imgArray;
	private int currentImg;
	protected int lenght;

	public SlideImages() {

	}

	public void newSet(List<String> imgUrlList){

		newSet((String[]) imgUrlList.toArray());

	}


	public void newSet(String[] imgUrlArray){
		lenght = 0;
		imgArray = null;
		currentImg = 0;
		
		configureThis(imgUrlArray);

	}

	private void configureThis(String[] imgUrlArray) {

		if(imgUrlArray == null || imgUrlArray.length == 0){
			this.imgArray = new Image[0];
			return;
		}

		this.imgArray = new Image[imgUrlArray.length];

		int i = 0;

		for(String url:imgUrlArray){

			Image img = new Image(url);
			setImgId(img, i);
			this.imgArray[i] = img;
			i++;

		}

		setProperties();

	}

	private void setProperties() {
		this.lenght = this.imgArray.length;
		this.currentImg = 0;

	}

	public Image next(){
		if(lenght-1 == currentImg){
			currentImg = 0;
			return imgArray[currentImg];
		}else{
			currentImg++;
			return imgArray[currentImg];
			
		}
	}

	public Image previous(){
		if(currentImg == 0){
			currentImg = lenght-1;
			return imgArray[currentImg];
		}else{
			currentImg--;
			return imgArray[currentImg];
		}
	}



	private void setImgId(Image img, int id){
		img.getElement().setAttribute("data-id", ""+id);
	}

	public int getId(Image img){

		String dataId = img.getElement().getAttribute("data-id");

		int id = Integer.parseInt(dataId);

		return id;

	}


	/**
	 * @return the currentImg
	 */
	public Image getCurrentImg() {
		return imgArray[currentImg];
	}


	/**
	 * @param currentImg the currentImg to set
	 */
	public Image setCurrentImg(int index) {
		if(index > lenght || index < 0 ){
			this.currentImg = lenght-1;
		}else{
			this.currentImg = index;
		}
		return imgArray[currentImg];
	}

	public Image setCurrentImg(String index){

		try {
			Integer.parseInt(index);
		} catch (NumberFormatException e) {

		}

		return imgArray[currentImg];

	}


}
