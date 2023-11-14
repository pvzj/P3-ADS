/*
Jeremy Chen
ADS : B Period
Lewellen
11/15/23
Class that implements the GUI for the flashcards
 */

package Final;

// imports, using swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI {
    // main frame that encompasses everything
    private static JFrame frame = new JFrame("Flashcards");
    // set that is being added to
    private static FlashcardSet set = new FlashcardSet();
    // tracker that keeps track of which card is being displayed
    private static int currentFlashcardIndex = 0;
    // boolean that keeps track of if the term or definition is being displayed
    private static boolean isDisplayingTerm = true;
    // card that is being displayed
    private static JButton displayCard;
    
    // constants
    
    // color variable for term and definition
    // if they weren't final, the colors of the cards might get changed
    private static final Color TERM_COLOR = new Color(227, 234, 255);
    private static final Color DEF_COLOR = new Color(158, 181, 247);
    // constants that dictate how big the cards are displayed (in pixels)
    private static final int CARD_WIDTH = 480;
    private static final int CARD_HEIGHT = 288;
    
    // array containing dropdown options
    private static final String[] POSSIBLE_SORTS = {
        "oldest to newest",
        "newest to oldest",
        "alphabetical",
        "shortest to longest term"
    };
    
    // method to initialize GUI
    public void init() {
        // main panel containing everything
        JPanel mainPanel = new JPanel();
        
        // add one element to ensure the set isn't empty
        set.addFlashCard("Term", "Definition");
        
        // set main panel to boxLayout
        // this allows for there to be defined rows of content
        mainPanel.setLayout(
                new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // top bar, contains sorting algorithms and remove current element
        JPanel sortByAndRemoveBar = new JPanel();
        
        // add label and dropdown for different sorts
        sortByAndRemoveBar.add(new JLabel("Sort by: "));
        JComboBox dropdown = new JComboBox(POSSIBLE_SORTS);
        //add listener for dropdown to detect changes in choice
        dropdown.addActionListener(new SortFlashcardsListener(dropdown));
        sortByAndRemoveBar.add(dropdown);
        
        // remove button
        JButton remove = new JButton("Remove Current Element");
        sortByAndRemoveBar.add(remove);
        // add listener to detect when it is pressed
        remove.addActionListener(new removeFlashcardListener());
        
        
        // middle part, contains the flashcard itself
        JPanel flashcardArea = new JPanel();
        // initialize the settings for the index card
        initCard();
        // resize panel
        flashcardArea.setPreferredSize(
                new Dimension(CARD_WIDTH, CARD_HEIGHT));
        // add card to panel
        flashcardArea.add(displayCard);
        
        
        // bottom bar, place to add new flashcards
        JPanel addFlashcardBar = new JPanel();
        // add labels and text fields for adding
        addFlashcardBar.add(new JLabel("Term: "));
        JTextField termField = new JTextField(10);
        addFlashcardBar.add(termField);
        addFlashcardBar.add(new JLabel("Definition: "));
        JTextField definitionField = new JTextField(10);
        addFlashcardBar.add(definitionField);
        //submit button
        JButton addFlashcardSubmitButton = new JButton("Add Flashcard");
        // add listener to submit button to detect when it is pressed
        addFlashcardSubmitButton.addActionListener(
                new AddFlashcardListener(termField, definitionField));
        // add button to bottom panel
        addFlashcardBar.add(addFlashcardSubmitButton);
        
        // add each of the panels to the main panel
        mainPanel.add(sortByAndRemoveBar);
        mainPanel.add(flashcardArea);
        mainPanel.add(addFlashcardBar);
        
        // add main panel to frame
        frame.setContentPane(mainPanel);
        // prevent it from being resized
        frame.setResizable(false);
        // ensure the sizes are optimal
        frame.pack();
        // make sure terminal closes when window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set it to be visible
        frame.setVisible(true);
    }
    
    // initializes displayCard
    private void initCard() {
        Flashcard defaultCard = set.getFlashcard(0);
        
        // initializes displayCard as a button with its term
        displayCard = new JButton(defaultCard.getTerm());
        
        // set background, make sure the button is only a rectangle
        // with no border, boxes, etc.
        displayCard.setBackground(TERM_COLOR);
        displayCard.setOpaque(true);
        displayCard.setBorderPainted(false);
        displayCard.setFocusPainted(false);
        displayCard.setPreferredSize(
                new Dimension(CARD_WIDTH, CARD_HEIGHT));
        
        // set font of text and center it
        displayCard.setFont(new Font("Helvetica", Font.PLAIN, 30));
        displayCard.setHorizontalAlignment(JButton.CENTER);
        
        // add listeners
        // CardActionListener detects the card being clicked
        displayCard.addActionListener(new CardActionListener());
        // CardKeyListener detects certain keys being pressed
        displayCard.addKeyListener(new CardKeyListener());
        
        // set the card to be visible
        displayCard.setVisible(true);
    }
    
    // draws card given a text and a color
    // returns nothing
    private void drawCard(String text, Color color) {
        // changes the display's text and background color
        displayCard.setText(text);
        displayCard.setBackground(color);
    }
    
    // displays flashcard given its index number in the set
    // automatically displays the term of the element
    private void drawCardGivenIndex(int index) {
        // get targeted card
        Flashcard targetCard = set.getFlashcard(index);
        // draw the targeted card
        drawCard(targetCard.getTerm(), TERM_COLOR);
        
        // update relevant indices
        currentFlashcardIndex = index;
        isDisplayingTerm = true;
    }
    // make sure the index is inbounds
    // if the index moves out of the range, loop it
    private void checkCardCycleAndDisplayCard() {
        // mod index by size to get the looped size
        // floorMod works with negative numbers (i.e -1 mod 2 = 1)
        // rather than %, where -1 mod 2 = -1
        int index = Math.floorMod(currentFlashcardIndex, set.size());
        // draw card with new index
        drawCardGivenIndex(index);
    }
    
    // toggles the state of the current card
    private void flipCard() {
        // log the card flip
        System.out.println("card flip ");
        
        // get the currently displayed card
        Flashcard currentCard = set.getFlashcard(currentFlashcardIndex);
        
        // if the term is currently being displayed
        // draw its definition, change its color
        // otherwise do the reverse
        if (isDisplayingTerm) {
            drawCard(currentCard.getDefinition(), DEF_COLOR);
        } else {
            drawCard(currentCard.getTerm(), TERM_COLOR);
        }
        // update isDisplayingTerm
        isDisplayingTerm = !isDisplayingTerm;
    }
    
    // display the next card in the set
    private void nextCard() {
        // print for logging
        System.out.println("next card");
        // increment index, display the card with the new index
        currentFlashcardIndex++;
        checkCardCycleAndDisplayCard();
    }
    
    // display the previous card in the set
    private void previousCard() {
        // print for logging
        System.out.println("previous card");
        // decrement index, display the card with the new index
        currentFlashcardIndex--;
        checkCardCycleAndDisplayCard();
    }
    
    // action listeners
    
    // listener that detects if the current card is being clicked
    private class CardActionListener implements ActionListener {
        // if the action is performed, flip the card
        // takes in the ActionEvent, but not used
        @Override
        public void actionPerformed(ActionEvent e) {
            flipCard();
        }
        
    }
    // listener that detects if certain keys are being pressed
    private class CardKeyListener implements KeyListener {
        // condition if a key is pressed
        // takes in KeyEvent that contains data on what keys there are
        @Override
        public void keyPressed(KeyEvent e) {
            // if the up or down arrowkey is pressed, flip the card
            if (e.getKeyCode() == KeyEvent.VK_UP 
                    || e.getKeyCode() == KeyEvent.VK_DOWN) {
                flipCard();
            }
            // if the right arrow is pressed, move to the next card
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                nextCard();
            }
            
            // if the left arrow is pressed, move to the previous card
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                previousCard();
            }
        }
        
        // unused conditions, not necessary for flashcards
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
    
    // listener for adding a new flashcard
    private class AddFlashcardListener implements ActionListener {
        // store text fields where data is being inputted
        private JTextField termField;
        private JTextField definitionField;
        
        // constructor, set two textFields
        public AddFlashcardListener(
                JTextField termField, JTextField definitionField) {
            this.termField = termField;
            this.definitionField = definitionField;
        }
        
        // if the submit button is pressed, check the term/definition
        // then add the new flashcard
        @Override
        public void actionPerformed(ActionEvent e) {
            // get the term and definition
            String term = termField.getText();
            String definition = definitionField.getText();
            
            // check if the term or definition is empty
            if (term.length() == 0) {
                errorMessage("Term cannot be empty");
            } else if (definition.length() == 0) {
                errorMessage("Definition cannot be empty");
            // then check if the term already exists, 
            // add the flashcard to the set
            } else if (!set.addFlashCard(term, definition)) {
                errorMessage("Term already exists in set");
            }
            // clear the textFields
            termField.setText("");
            definitionField.setText("");
        }
        
    }
    // listener to remove a flashcard
    private class removeFlashcardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // check if the set has only one element, to prevent the set from
            // being empty
            if (set.size() == 1) {
                errorMessage("Cannot have no cards in set");
                return;
            }
            // remove the flashcard
            set.removeFlashcard(currentFlashcardIndex);
            // change the displayed card to the next card
            // the index is automatically adjusted
            checkCardCycleAndDisplayCard();
        }
        
    }
    
    // listener to pick a sorting method to sort the cards
    private class SortFlashcardsListener implements ActionListener {
        // stored dropdown menu
        private JComboBox dropdown;
        
        // constructor, get dropdown
        public SortFlashcardsListener(JComboBox dropdown) {
            this.dropdown = dropdown;
        }
        
        // detects if an element is changed
        @Override
        public void actionPerformed(ActionEvent e) {
            // get the selected item
            String selectedItem = (String) dropdown.getSelectedItem();
            
            // create sorting object, choose inherited sort type based on choice
            QuickSort sortingAlgorithm = null;
            switch(selectedItem) {
                case "oldest to newest":
                    // print for logging
                    System.out.println("oldest to newest");
                    // change the sortingAlgorithm object
                    sortingAlgorithm = new OldestToNewestSort();
                    break;
                case "newest to oldest":
                    // print for logging
                    System.out.println("newest to oldest");
                    // change the sortingAlgorithm object
                    sortingAlgorithm = new NewestToOldestSort();
                    break;
                case "alphabetical":
                    // print for logging
                    System.out.println("alphabetical sort");
                    // change the sortingAlgorithm object
                    sortingAlgorithm = new AlphabeticalSort();
                    break;
                case "shortest to longest term":
                    // print for logging
                    System.out.println("shortest to longest");
                    // change the sortingAlgorithm object
                    sortingAlgorithm = new LengthSort();
                    break;
                default:
                    // in case the answer choices didn't match for some reason
                    // throw error
                    throw new IllegalArgumentException(
                            "selected item doesn't match");
            }
            // sort the set, the compare methods will be selected because of
            // polymorphism
            sortingAlgorithm.sort(set.getSet(), set.size());
            // return to the first element
            drawCardGivenIndex(0);
        }
        
    }
    // create pop up with inputted error message
    private static void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message,
                "Error", JOptionPane.WARNING_MESSAGE);
    }
}

