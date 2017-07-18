package application;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class Player {

	private String name;
	private ArrayList<CardView> cards;
	private ArrayList<ImageView> cardsView;
	private boolean firstStarter = false;
	
	public Player(String initName) {
		name = initName;
		cards = new ArrayList<CardView>();
		cardsView = new ArrayList<ImageView>();
		
	}

	public void setFirstStarter(boolean firstStarter) {
		this.firstStarter = firstStarter;
	}

	public boolean isFirstStarter() {
		return firstStarter;
	}

	public CardView discard(CardView discarded) throws IllegalArgumentException {

		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals(discarded)) {
				return cards.remove(i);
				
			}
		}
		throw new IllegalArgumentException("You don't have that card");

	}
	
	public ArrayList<CardView> getCards() {
		return cards;
	}

	public void draw(CardView drawn) {

		cards.add(drawn);

	}
	public void draw(ImageView drawn) {

		cardsView.add(drawn);

	}

	public ArrayList<ImageView> getCardsView() {
		return cardsView;
	}

	public String toString() {
	
		return name;
	}

}
