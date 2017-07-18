package application;

import java.util.Scanner;

import javafx.scene.image.ImageView;

public class UnoView {
	private CardView currentCard;
	private DeckView unoDeck;
	private Player human;
	private Player computer;
	private Player currentPlayer;
	private int matchCount;

	public int getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(int matchCount) {
		this.matchCount = matchCount;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void setCurrentCard(CardView currentCard) {
		this.currentCard = currentCard;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	private boolean gameOver = false;

	public Player getHuman() {
		return human;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public Player getComputer() {
		return computer;
	}

	public CardView getCurrentCard() {
		return currentCard;
	}

	public UnoView() {

		human = new Player("name");
		computer = new Player("Computer");
		unoDeck = new DeckView();

	}

	public DeckView getUnoDeck() {
		return unoDeck;
	}

	public void deal() {

	}

	public void gameSetting2() {

	}

	public void gameSetting3() {

	}

	public void gameProceed() {
		unoDeck.shuffleDrawPile();
		gameSetting2();
		gameSetting3();

		deal();

		unoDeck.drawPileFaceDown();

		unoDeck.turnOverToStart();
		currentCard = getUnoDeck().getDiscardPile().peek();

		while (gameOver == false) {

			playerTakeTurn();
		}

	}

	public boolean matches(CardView card) {

		if (currentCard.getName().contains("BERT_AND_ERNIE")) {
			if (matchCount == 0) {
				
				return false;
			}

		} else if (currentCard.getName().contains("OSCAR_THE_GROUCH")) {
			if (matchCount == 0) {

				return false;
			}
		}

		if (matchCount == 0) {
			if (card.getName().equals("WILD_MONSTER") && currentCard.getName().contains("BERT_AND_ERNIE"))
				return false;
			if (card.getName().equals("WILD_MONSTER") && currentCard.getName().contains("OSCAR_THE_GROUCH"))
				return false;
		}
		if (matchCount == 1) {
			if (currentCard.getName().equals("WILD_MONSTER")) {
				matchCount = 0;
				return true;
			}
			if (currentCard.getName().contains("BERT_AND_ERNIE")) {

				if (card.getName().contains("BERT_AND_ERNIE")) {
					matchCount = 0;
					return true;
				} else {

					return false;
				}

			} else if (currentCard.getName().contains("OSCAR_THE_GROUCH")) {
				{
					if (card.getName().contains("OSCAR_THE_GROUCH")) {
						matchCount=0;
						return true;
					} else {

						return false;
					}
				}

			}

		}
		if (card.getName().equals("WILD_MONSTER") || card.getColor().equals(currentCard.getColor())
				|| (card.getNumber() == currentCard.getNumber() && card.getNumber() != 0)) {
			matchCount = 0;
			return true;
		}

		return false;

	}

	public void draw() {

		currentPlayer.draw(unoDeck.getDrawPile().pop());
		matchCount = 1;
	}

	public void playerTakeTurn() {

		if (human.getCards().size() == 0) {

		gameOver = true;
			return;
		}
		if (computer.getCards().size() == 0) {
			gameOver = true;
			return;
		}

		if (unoDeck.getDrawPile().size() <= 2) {
	
			unoDeck.shuffleDrawPile();
			unoDeck.turnOverToStart();
		}
		if (currentPlayer == human) {
			Scanner input = new Scanner(System.in);
			if (currentCard.getName().contains("BERT_AND_ERNIE")) {
		
			}
			if (currentCard.getName().contains("OSCAR_THE_GROUCH")) {
		
			}

			String index = "";
			int counter = 0;
			while (true) {

					try {

					index = input.next();
					if (Integer.parseInt(index) >= human.getCards().size()) {
							continue;
					}
					if (matches(human.getCards().get(Integer.parseInt(index))) == false) {
							continue;

					}
					if (human.getCards().size() == 2) {

						if (!index.equalsIgnoreCase("uno") && (!index.equalsIgnoreCase("draw") && counter == 0)) {
				
							draw();

							currentPlayer = computer;
							return;
						}

					}
				} catch (NumberFormatException ex) {
					if (human.getCards().size() == 2) {

						if (index.equalsIgnoreCase("uno")) {

						counter++;
							continue;
						}
						if (!index.equalsIgnoreCase("uno") && (!index.equalsIgnoreCase("draw") && counter == 0)) {
						
							draw();
							input.close();
							currentPlayer = computer;
							return;
						}
					}
					if (index.equals("draw")) {
						if (currentCard.getName().contains("OSCAR_THE_GROUCH")) {

							draw();
						}

						draw();
						currentPlayer = computer;
						return;
					} else {
						continue;
					}
				}

				break;
			}
			String color = "";
			if (human.getCards().get(Integer.parseInt(index)).getName().equals("WILD_MONSTER")) {
				while (true) {

						color = input.next();

					if (!(color.equalsIgnoreCase("yellow") || color.equalsIgnoreCase("red")
							|| color.equalsIgnoreCase("blue") || color.equalsIgnoreCase("green"))) {
							continue;
					}

					getUnoDeck().getDiscardPile().peek().setColor(color);
					currentCard = human.getCards().get(Integer.parseInt(index));
					unoDeck.getDiscardPile().push(human.discard(human.getCards().get(Integer.parseInt(index))));
					currentCard.setColor(color);
					currentPlayer = computer;
					return;

				}

			} else {
				unoDeck.getDiscardPile().push(human.discard(human.getCards().get(Integer.parseInt(index))));
				currentCard = getUnoDeck().getDiscardPile().peek();
				currentPlayer = computer;
				return;
			}

		} else {

			if (unoDeck.getDiscardPile().size() != 1) {
				if (currentCard.getName().contains("BERT_AND_ERNIE")) {
					draw();

				}
				if (currentCard.getName().contains("OSCAR_THE_GROUCH")) {
					draw();
					draw();
				}
			}
			if (computer.getCards().size() == 2) {
				String[] dumbComputer = { "ooo", "ohhh", "un??", " I won! ", "uno" };
				String declare = dumbComputer[(int) (Math.random() * dumbComputer.length)];
					if (declare.equalsIgnoreCase("uno")) {
				}
				if (!declare.equalsIgnoreCase("uno")) {
			
					draw();
					currentPlayer = human;
					return;

				}

			}

			String[] color = { "yellow", "blue", "red", "green" };
			String computerChoice = "";

			for (int i = 0; i < computer.getCards().size(); i++) {

				if (matches(computer.getCards().get(i)) == false)
					continue;
				else {
					if (computer.getCards().get(i).getName().equals("WILD_MONSTER")) {

							computerChoice = color[(int) (Math.random() * (color.length))];
				
						unoDeck.getDiscardPile().push(computer.discard(computer.getCards().get(i)));
						getUnoDeck().getDiscardPile().peek().setColor(computerChoice);
						currentCard = getUnoDeck().getDiscardPile().peek();
						currentPlayer = human;
						return;
					} else {
							unoDeck.getDiscardPile().push(computer.discard(computer.getCards().get(i)));
						currentCard = getUnoDeck().getDiscardPile().peek();
						currentPlayer = human;
						return;
					}
				}

			}

				draw();
			currentPlayer = human;
			return;

		}

	}

}
