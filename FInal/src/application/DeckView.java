package application;

import java.util.Collections;
import java.util.Stack;

import javafx.application.Application;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DeckView {
	private CardView red_1;
	private CardView red_2;
	private CardView red_3;
	private CardView red_4;
	private CardView red_5;
	private CardView red_6;
	private CardView red_7;
	private CardView blue_1;
	private CardView blue_2;
	private CardView blue_3;
	private CardView blue_4;
	private CardView blue_5;
	private CardView blue_6;
	private CardView blue_7;
	private CardView yellow_1;
	private CardView yellow_2;
	private CardView yellow_3;
	private CardView yellow_4;
	private CardView yellow_5;
	private CardView yellow_6;
	private CardView yellow_7;
	private CardView yellow_Draw_2;
	private CardView blue_Draw;
	private CardView red_Draw;
	private CardView green_1;
	private CardView green_2;
	private CardView green_3;
	private CardView green_4;
	private CardView green_5;
	private CardView green_6;
	private CardView green_7;
	private CardView green_Draw_2;
	private CardView wildCard1;
	private CardView wildCard2;
	private CardView wildCard3;
	private CardView wildCard4;
	private Stack<CardView> drawPile;
	private Stack<CardView> discardPile;
	private Stack<ImageView> discardPileView;
	private Stack<ImageView> drawPileView;

	public Stack<ImageView> getDiscardPileView() {
		return discardPileView;
	}

	public void setDiscardPileView(Stack<ImageView> discardPileView) {
		this.discardPileView = discardPileView;
	}

	public Stack<ImageView> getDrawPileView() {
		return drawPileView;
	}

	public void setDrawPileView(Stack<ImageView> drawPileView) {
		this.drawPileView = drawPileView;
	}

	public Stack<CardView> getDrawPile() {
		return drawPile;
	}

	public Stack<CardView> getDiscardPile() {
		return discardPile;
	}

	public DeckView() {
		
		red_1 = new CardView("RED_BIG_BIRD", "red", new Image("scan/1_red.jpg", 175, 175, true, true), new Image("scan/back.jpg", 175, 175, true, true));

		red_2 = new CardView("RED_ZOE", "red", new Image("scan/2_red.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		red_3 = new CardView("RED_COOKIE_MONSTER", "red", new Image("scan/3_red.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		red_4 = new CardView("RED_ELMO", "red", new Image("scan/4_red.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		red_5 = new CardView("RED_BABY_BEAR", "red", new Image("scan/5_red.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		red_6 = new CardView("RED_ROSITA", "red", new Image("scan/6_red.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		red_7 = new CardView("RED_GROVER", "red", new Image("scan/7_red.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		red_Draw = new CardView("RED_BERT_AND_ERNIE", "red", new Image("scan/1_plus_red.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		blue_1 = new CardView("BLUE_BIG_BIRD", "blue", new Image("scan/1_blue.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		blue_2 = new CardView("BLUE_ZOE", "blue", new Image("scan/2_blue.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		blue_3 = new CardView("BLUE_COOKIE_MONSTER", "blue", new Image("scan/3_blue.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		blue_4 = new CardView("BLUE_ELMO", "blue", new Image("scan/4_blue.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		blue_5 = new CardView("BLUE_BABY_BEAR", "blue", new Image("scan/5_blue.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		blue_6 = new CardView("BLUE_ROSITA", "blue", new Image("scan/6_blue.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		blue_7 = new CardView("BLUE_GROVER", "blue", new Image("scan/7_blue.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		blue_Draw = new CardView("BLUE_BERT_AND_ERNIE", "blue", new Image("scan/1_plus_blue.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		yellow_1 = new CardView("YELLOW_BIG_BIRD", "yellow", new Image("scan/1_yellow.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		yellow_2 = new CardView("YELLOW_ZOE", "yellow", new Image("scan/2_yellow.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		yellow_3 = new CardView("YELLOW_COOKIE_MONSTER", "yellow", new Image("scan/3_yellow.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		yellow_4 = new CardView("YELLOW_ELMO", "yellow", new Image("scan/4_yellow.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		yellow_5 = new CardView("YELLOW_BABY_BEAR", "yellow", new Image("scan/5_yellow.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		yellow_6 = new CardView("YELLOW_ROSITA", "yellow", new Image("scan/6_yellow.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		yellow_7 = new CardView("YELLOW_GROVER", "yellow", new Image("scan/7_yellow.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		yellow_Draw_2 = new CardView("YELLOW_OSCAR_THE_GROUCH", "yellow", new Image("scan/2_plus_yellow.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		green_1 = new CardView("GREEN_BIG_BIRD", "green", new Image("scan/1_green.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		green_2 = new CardView("GREEN_ZOE", "green", new Image("scan/2_green.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		green_3 = new CardView("GREEN_COOKIE_MONSTER", "green", new Image("scan/3_green.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		green_4 = new CardView("GREEN_ELMO", "green", new Image("scan/4_green.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		green_5 = new CardView("GREEN_BABY_BEAR", "green", new Image("scan/5_green.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		green_6 = new CardView("GREEN_ROSITA", "green", new Image("scan/6_green.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		green_7 = new CardView("GREEN_GROVER", "green", new Image("scan/7_green.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		green_Draw_2 = new CardView("GREEN_OSCAR_THE_GROUCH", "green", new Image("scan/2_plus_green.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		wildCard1 = new CardView("WILD_MONSTER", "null", new Image("scan/wild.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		wildCard2 = new CardView("WILD_MONSTER", "null", new Image("scan/wild.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		wildCard3 = new CardView("WILD_MONSTER", "null", new Image("scan/wild.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		wildCard4 = new CardView("WILD_MONSTER", "null", new Image("scan/wild.jpg", 175, 175, true, true),new Image("scan/back.jpg", 175, 175, true, true));

		drawPile = new Stack<CardView>();
		discardPile = new Stack<CardView>();
		drawPileView = new Stack<ImageView>();
		discardPileView = new Stack<ImageView>();
	
		drawPile.add(red_1);

		drawPile.add(red_2);

		drawPile.add(red_3);
	
		drawPile.add(red_4);

		drawPile.add(red_5);

		drawPile.add(red_6);

		drawPile.add(red_7);

		drawPile.add(red_Draw);

		drawPile.add(blue_1);

		drawPile.add(blue_2);

		drawPile.add(blue_3);

		drawPile.add(blue_4);
	
		drawPile.add(blue_5);
	
		drawPile.add(blue_6);
	
		drawPile.add(blue_7);

		drawPile.add(blue_Draw);

		drawPile.add(yellow_1);

		drawPile.add(yellow_2);

		drawPile.add(yellow_3);
	
		drawPile.add(yellow_4);

		drawPile.add(yellow_5);
	
		drawPile.add(yellow_6);
	
		drawPile.add(yellow_7);
	
		drawPile.add(yellow_Draw_2);


		drawPile.add(green_1);

		drawPile.add(green_2);
	
		drawPile.add(green_3);
	
		drawPile.add(green_4);

		drawPile.add(green_5);

		drawPile.add(green_6);

		drawPile.add(green_7);

		drawPile.add(green_Draw_2);
	
		drawPile.add(wildCard1);

		drawPile.add(wildCard2);
		
		drawPile.add(wildCard3);
		
		drawPile.add(wildCard4);

	

	}
	public void reshuffle(){
		if (discardPile.size() > 0) {
			for (int i = discardPile.size()-2; i >=0; i--)
				drawPile.push(discardPile.remove(i));
			
		}
		for (int i = 0; i < drawPile.size(); i++) {
			if (drawPile.get(i).getName().equals("WILD_MONSTER") && drawPile.get(i).getColor() != null) {
				drawPile.get(i).setColor(null);
			}

		}
		Collections.shuffle(drawPile);

		for (int i = 0; i < drawPile.size(); i++) {
			drawPileView.add(i, new ImageView(drawPile.get(i).getImage()));
		}
		
	}
	public void drawPileFaceDown() {
		for (int i = 0; i < drawPile.size(); i++) {
			drawPile.get(i).setFaceDown(true);
		}

	}
	public void shuffleDrawPile() {
	
		if (discardPile.size() > 0) {
			for (int i = 0; i < discardPile.size(); i++)
				drawPile.push(discardPile.pop());
			
		}
		for (int i = 0; i < drawPile.size(); i++) {
			if (drawPile.get(i).getName().equals("WILD_MONSTER") && drawPile.get(i).getColor() != null) {
				drawPile.get(i).setColor(null);
			}

		}
		Collections.shuffle(drawPile);

		
	}

	public void turnOverToStart() {
		while (true) {
			drawPile.peek().setFaceDown(false);
			if ((drawPile.peek().getNumber()) == 0) {
				getDiscardPile().add(drawPile.pop());
				
				
			} else {
				getDiscardPile().add(drawPile.pop());
				
				break;
			}
		}

	}

}
