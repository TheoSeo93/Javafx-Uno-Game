package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Controller implements Initializable {
	private int index;
	private int unoCounter = 0;
	private UnoView uno = new UnoView();
	private int counter = 0;
	private boolean wildCard;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane Anchor;

	@FXML
	private HBox ComputerHBox;

	@FXML
	private ImageView FinishButton;

	@FXML
	private Button blue;

	@FXML
	private StackPane discardPile;

	@FXML
	private Button drawButton;

	@FXML
	private StackPane drawPile;

	@FXML
	private Button green;

	@FXML
	private HBox humanHBox;

	@FXML
	private Button red;

	@FXML
	private Button startButton;

	@FXML
	private TextArea txtField;

	@FXML
	private Button yellow;

	void reset() {
		if(uno.getComputer().getCards().get(0).getNumber()==0||uno.getHuman().getCards().get(0).getNumber()==0){

			ImageView temp = new ImageView(uno.getComputer().getCards().get(0).getImage());
			uno.getUnoDeck().getDiscardPile().push(uno.getComputer().getCards().remove(0));
			ComputerHBox.getChildren().remove(0);

			discardPile.getChildren().add(temp);

			uno.getUnoDeck().getDiscardPile().push(uno.getHuman().discard(uno.getHuman().getCards().get(0)));
			discardPile.getChildren().add(humanHBox.getChildren().remove(0));

			reshuffle();

			computerDraw();
			humanDraw();
			
		}

	}

	@FXML
	void blueSelected() {
		if (wildCard == true) {
			uno.getCurrentCard().setColor("blue");
			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
			txtField.insertText(0, "\nThe color is blue");
			uno.setCurrentPlayer(uno.getComputer());
			wildCard = false;

		}

	}

	@FXML
	void greenSelected() {
		if (wildCard == true) {
			uno.getCurrentCard().setColor("green");
			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
			txtField.insertText(0, "\nThe color is green");
			uno.setCurrentPlayer(uno.getComputer());
			wildCard = false;
		}
	}

	@FXML
	void redSelcted() {
		if (wildCard == true) {
			uno.getCurrentCard().setColor("red");
			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
			txtField.insertText(0, "\nThe color is red");
			uno.setCurrentPlayer(uno.getComputer());
			wildCard = false;
		}
	}

	@FXML
	void yellowSelected() {
		if (wildCard == true) {
			uno.getCurrentCard().setColor("yellow");
			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
			txtField.insertText(0, "\nThe color is yellow");
			uno.setCurrentPlayer(uno.getComputer());
			wildCard = false;
		}
	}

	void reshuffle() {
		uno.getUnoDeck().reshuffle();
		if (discardPile.getChildren().size() > 0) {
			for (int i = 0; i < discardPile.getChildren().size() - 1; i++)
				discardPile.getChildren().remove(i);
		}

		for (int i = 0; i < uno.getUnoDeck().getDrawPile().size(); i++) {
			ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().get(i).getBackImage());
			drawPile.getChildren().add(i, temp);

		}
	}

	void shuffle() {
		uno.getUnoDeck().shuffleDrawPile();
		if (discardPile.getChildren().size() > 0)
			discardPile.getChildren().clear();

		humanHBox.getChildren().clear();
		ComputerHBox.getChildren().clear();
		for (int i = 0; i < uno.getUnoDeck().getDrawPile().size(); i++) {
			ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().get(i).getBackImage());
			drawPile.getChildren().set(i, temp);

		}
	}

	@FXML
	void mouseMoved(MouseEvent event) {
		if (wildCard == false) {
			if (counter == 5) {
				if (uno.getCurrentPlayer() == uno.getComputer()) {

					sleep(1000);
					computerTakeTurn();

				}
			}
		}
	}

	void computerTakeTurn() {

		if (wildCard == false) {
			if (uno.getCurrentPlayer().getCards().size() == 0) {
				txtField.setText("Unlucky! Computer is the winner!");
				startButton.setText("Computer Won");
			}
			if (uno.getUnoDeck().getDrawPile().size() == 0)
				reshuffle();

			if (uno.getComputer().getCards().size() == 2) {
				String[] dumbComputer = { "", "uno" };
				String declare = dumbComputer[(int) (Math.random() * dumbComputer.length)];

				txtField.insertText(0, "Computer declared " + declare + " ! ");

				if (declare.equalsIgnoreCase("uno")) {

					txtField.setText("Computer: UNO!");

				}

				if (!declare.equalsIgnoreCase("uno")) {

					txtField.setText("Computer forgot to shout out UNO!");
					computerDraw();
				}
			}
		}

		String[] color = { "yellow", "blue", "red", "green" };
		String computerChoice = "";

		for (int i = 0; i < uno.getComputer().getCards().size(); i++) {

			if (uno.matches(uno.getComputer().getCards().get(i)) == false)
				continue;
			if (uno.matches(uno.getComputer().getCards().get(i)) == true) {

				if (uno.getComputer().getCards().get(i).getName().equals("WILD_MONSTER")) {

					computerChoice = color[(int) (Math.random() * (color.length))];
					txtField.setText("Computer sets the color into " + computerChoice);

					computerDiscard(i);

					uno.getUnoDeck().getDiscardPile().peek().setColor(computerChoice);

					uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
					if (uno.getCurrentPlayer().getCards().size() == 0) {
						txtField.setText("Unlucky! Computer is the winner!");
						startButton.setText("Computer Won");
					}
					uno.setCurrentPlayer(uno.getHuman());

					return;
				} else {
					computerDiscard(i);

					uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
					if (uno.getCurrentPlayer().getCards().size() == 0) {
						txtField.setText("Unlucky! Computer is the winner!");
						startButton.setText("Computer Won");
					}
					uno.setCurrentPlayer(uno.getHuman());
					return;
				}
			}

		}

		computerDraw();
		uno.setCurrentPlayer(uno.getHuman());
		return;

	}

	void computerDraw() {

		if (counter == 5) {

			if (uno.getCurrentCard().getName().contains("BERT_AND_ERNIE"))
				uno.setMatchCount(1);
			if (uno.getMatchCount() == 0) {
				if (uno.getCurrentCard().getName().contains("OSCAR_THE_GROUCH")) {
					uno.setMatchCount(1);
					uno.getComputer().draw(uno.getUnoDeck().getDrawPile().pop());

					ImageView computerC = (ImageView) drawPile.getChildren().remove(drawPile.getChildren().size() - 1);
					ComputerHBox.getChildren().add(computerC);
				}
			}
		}

		ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().peek().getBackImage());
		drawPile.getChildren().remove(drawPile.getChildren().size() - 1);
		uno.getComputer().draw(uno.getUnoDeck().getDrawPile().pop());
		ComputerHBox.getChildren().add(temp);
		txtField.insertText(0, "\nComputer drew a card");

	}

	void humanDraw() {
		ImageView pass = new ImageView(uno.getUnoDeck().getDrawPile().peek().getImage());
		uno.getHuman().draw(uno.getUnoDeck().getDrawPile().pop());
		drawPile.getChildren().remove(drawPile.getChildren().size() - 1);

		humanHBox.getChildren().add(pass);

		txtField.insertText(0, "\nYou drew a card");

		uno.setCurrentPlayer(uno.getComputer());
	}

	void humanDiscard(int n) {
		uno.getUnoDeck().getDiscardPile().push(uno.getHuman().discard(uno.getHuman().getCards().get(n)));
		discardPile.getChildren().add(humanHBox.getChildren().remove(n));
	}

	@FXML
	void discard(MouseEvent event) {
		if (wildCard == false) {
			ArrayList<ImageView> arr = new ArrayList<ImageView>();
			for (int i = 0; i < humanHBox.getChildren().size(); i++) {
				arr.add((ImageView) humanHBox.getChildren().get(i));
			}
			for (int i = 0; i < humanHBox.getChildren().size(); i++) {
				arr.get(i).setOnMouseClicked(this::handle);

			}
		}
	}

	public void handle(MouseEvent event) {

		if (counter >= 4 && uno.getCurrentPlayer() == uno.getHuman()) {
			if (humanHBox.getChildren().get(0) == event.getTarget())
				index = 0;
			else if (humanHBox.getChildren().get(1) == event.getTarget())
				index = 1;
			else if (humanHBox.getChildren().get(2) == event.getTarget())
				index = 2;
			else if (humanHBox.getChildren().get(3) == event.getTarget())
				index = 3;
			else if (humanHBox.getChildren().get(4) == event.getTarget())
				index = 4;
			else if (humanHBox.getChildren().get(5) == event.getTarget())
				index = 5;
			else if (humanHBox.getChildren().get(6) == event.getTarget())
				index = 6;
			else if (humanHBox.getChildren().get(7) == event.getTarget())
				index = 7;
			else if (humanHBox.getChildren().get(8) == event.getTarget())
				index = 8;
			else if (humanHBox.getChildren().get(9) == event.getTarget())
				index = 9;
			else if (humanHBox.getChildren().get(10) == event.getTarget())
				index = 10;
			else if (humanHBox.getChildren().get(11) == event.getTarget())
				index = 11;
			else if (humanHBox.getChildren().get(12) == event.getTarget())
				index = 12;

			if (uno.getHuman().getCards().size() == 2) {

				if (unoCounter == 0) {
					txtField.insertText(0, "\nFailed to shout out uno");

					humanDraw();

					uno.setCurrentPlayer(uno.getComputer());

				}
				if (unoCounter != 0)
					unoCounter = 0;
			}

			if (uno.getHuman().getCards().get(index).getName().equals("WILD_MONSTER")) {
				txtField.insertText(0, "\nYou threw a wild card! Pick a color.");

				humanDiscard(index);
				uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());

				if (uno.getCurrentPlayer().getCards().size() == 0) {
					txtField.setText("Congratulations! You won!");
					startButton.setText("User Won");
				}
				wildCard = true;

				return;

			}
			if (uno.matches(uno.getHuman().getCards().get(index))) {
				uno.getUnoDeck().getDiscardPile().push(uno.getHuman().getCards().get(index));
				humanDiscard(index);
				uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
				if (uno.getCurrentPlayer().getCards().size() == 0) {
					txtField.setText("Congratulations! You won!");
					startButton.setText("User Won");
				}
				uno.setCurrentPlayer(uno.getComputer());
				return;
			} else
				return;
		}
	}

	void computerDiscard(int i) {

		if (uno.matches(uno.getComputer().getCards().get(i))) {

			ImageView temp = new ImageView(uno.getComputer().getCards().get(i).getImage());
			uno.getUnoDeck().getDiscardPile().push(uno.getComputer().getCards().remove(i));
			ComputerHBox.getChildren().remove(i);

			discardPile.getChildren().add(temp);
			return;
		}

	}

	@FXML

	void drawClicked() {

		if (wildCard == false) {
			if (uno.getCurrentPlayer() == uno.getHuman() && uno.getMatchCount() == 0) {

				if (uno.getCurrentCard().getName().contains("BERT_AND_ERNIE"))
					uno.setMatchCount(1);

				if (uno.getCurrentCard().getName().contains("OSCAR_THE_GROUCH")) {
					uno.setMatchCount(1);
					humanDraw();
				}
				humanDraw();

				uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
				uno.setCurrentPlayer(uno.getComputer());
			} else

			{
				humanDraw();
				uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
				uno.setCurrentPlayer(uno.getComputer());

				return;

			}
		}

	}

	public void sleep(int time) {

		try {

			Thread.sleep(time);
		} catch (Exception ex) {
		}
	}

	void deal() {

		for (int i = 0; i < 5; i++) {

			humanDraw();
			computerDraw();
			txtField.insertText(0, "\nGame Setting....3: Reshuffled and 5 cards are given to each player.");
			if (uno.getComputer().isFirstStarter()) {
				
				uno.setCurrentPlayer(uno.getComputer());

			} else {
				
				uno.setCurrentPlayer(uno.getHuman());
			}

		}
	}

	@FXML
	void handleStartButton() {
		if (uno.getComputer().getCards().size() == 2) {
			computerDraw();

		}

		if (counter == 5 && uno.getCurrentPlayer().getCards().size() == 2) {
			txtField.setText("UNO!");
			unoCounter++;

		}

		if (counter == 0) {

			for (int i = 0; i < uno.getUnoDeck().getDrawPile().size(); i++) {
				ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().get(i).getImage());

				drawPile.getChildren().add(temp);

			}

			txtField.insertText(0, "\nGame Setting#1....Shuffled!  Press Start again to proceed setting of this game");
			shuffle();

			counter++;

		} else if (counter == 1) {
			do{
			computerDraw();
			humanDraw();
			reset();
			
			}while(uno.getComputer().getCards().get(0).getNumber()==0||uno.getHuman().getCards().get(0).getNumber()==0);
			ImageView temp1 = new ImageView(uno.getComputer().getCards().get(0).getImage());
			ComputerHBox.getChildren().set(0, temp1);
			ImageView temp = new ImageView(uno.getHuman().getCards().get(0).getImage());
			humanHBox.getChildren().set(0, temp);
			if (uno.getComputer().getCards().get(0).getNumber() > uno.getHuman().getCards().get(0).getNumber()) {
				uno.getComputer().setFirstStarter(true);

			} else {
				uno.getHuman().setFirstStarter(true);
			}

			if (uno.getHuman().isFirstStarter() == true)
				txtField.insertText(0, "\nGame Setting....2: User's card number is bigger.  User starts first!");
			else
				txtField.insertText(0, "\nGame Setting....2: Computer's card number is bigger.  Computer starts first!");
			counter++;

		} else if (counter == 2) {
			uno.getHuman().discard(uno.getHuman().getCards().get(0));

			uno.getComputer().discard(uno.getComputer().getCards().get(0));

			shuffle();

			deal();
			
			counter++;
		} else if (counter == 3) {
			while (true) {
				CardView top = uno.getUnoDeck().getDrawPile().peek();
				top.setFaceDown(false);
				if ((top.getNumber()) == 0) {
					ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().peek().getImage());
					uno.getUnoDeck().getDiscardPile().add(uno.getUnoDeck().getDrawPile().pop());
					drawPile.getChildren().remove(drawPile.getChildren().size() - 1);
					discardPile.getChildren().add(temp);
					txtField.insertText(0,
							"\nGame Setting....4: Turn over to start. It's not a number card, so click start button again to turn it over");

					return;
				} else {
					CardView tempCard = uno.getUnoDeck().getDrawPile().pop();
					ImageView temp = new ImageView(tempCard.getImage());
					uno.getUnoDeck().getDiscardPile().add(tempCard);
					drawPile.getChildren().remove(drawPile.getChildren().size() - 1);

					// (ImageView)
					// drawPile.getChildren().remove(drawPile.getChildren().size()-1);
					discardPile.getChildren().add(temp);

					break;
				}

			}

			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());// currentCard

			String name = "";
			if (uno.getCurrentPlayer() == uno.getComputer()) {
				name = " Computer";

				txtField.insertText(0,
						"\nGame Setting....4: Now Game has started. Computer starts first! press start again");
				counter++;
			} else {
				name = " You ";
				txtField.insertText(0, "\nGame Setting....4: Now Game has started. First Player is " + name);
				counter++;
			}
		}

		else if (counter == 4) {
			if (uno.getCurrentPlayer() == uno.getComputer()) {
				computerTakeTurn();
				uno.setCurrentPlayer(uno.getHuman());
			} else if (counter == 4 && uno.getCurrentPlayer() == uno.getHuman()) {
				txtField.insertText(0, "\nPress one more to start");

			}
			counter++;

		} else if (counter == 5
				&& (uno.getHuman().getCards().size() != 0 || uno.getComputer().getCards().size() != 0)) {

			txtField.insertText(0, "\n***UNO has started***");
			startButton.setText("UNO");

			if (uno.getUnoDeck().getDrawPile().size() <= 2) {
				txtField.setText("Press UNO to reshuffle");

				reshuffle();

			}

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
