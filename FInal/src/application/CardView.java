package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardView {

	private String name;
	private String color;
	private int number;
	

	private boolean isFaceDown=false;
	private Image image;
	private Image backImage;
	public CardView(String initName, String initColor, Image image, Image backImage) throws IllegalArgumentException{
		this.image=image;
		name = initName;
		color = initColor;
		this.backImage=backImage;
		if (initName.contains("BIG_BIRD"))
			number = 1;

		else if (initName.contains("ZOE"))
			number = 2;

		else if (initName.contains("COOKIE_MONSTER"))
			number = 3;

		else if (initName.contains("ELMO"))
			number = 4;

		else if (initName.contains("BABY_BEAR"))
			number = 5;

		else if (initName.contains("ROSITA"))
			number = 6;

		else if (initName.contains("GROVER"))
			number = 7;

		else if (initName.contains("BERT_AND_ERNIE"))
			number = 0;

		else if (initName.contains("OSCAR_THE_GROUCH"))
			number =0;

		else if (initName.equals("WILD_MONSTER")){
			number =0;
			color="";
		}
		else
			throw new IllegalArgumentException("Wrong Arguments Passed");
	}
	

	public void setFaceDown(boolean faceDown) {
		this.isFaceDown = faceDown;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getNumber() {
		return number;
	}
	
	public Image getImage() {
		return image;
	}
	public Image getBackImage() {
		return backImage;
	}


	public boolean equal(CardView card){
		
		if(this.name.equals(card.getName())&&this.color.equals(card.getColor())&&this.number==card.getNumber())
		return true;
		else
		return false;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	
	public String toString(){
		
		return "\nCard Name: " + name +"\nColor : "+color+ "\nNumber: "+number+"\n"; 
		
	}

}
