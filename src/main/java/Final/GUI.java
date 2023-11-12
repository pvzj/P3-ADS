/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Final;

/**
 *
 * @author jchen
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GUI { //GUI for chessboard
    private static JFrame frame = new JFrame("Flashcards"); //title
    private static FlashcardSet set = new FlashcardSet();
    private static int currentFlashcardIndex = 0;
    private static boolean isDisplayingTerm = true;
    private static JButton displayCard;
    
    private static final Color TERM_COLOR = new Color(227, 234, 255);
    private static final Color DEF_COLOR = new Color(158, 181, 247);
    private static final String[] possibleSorts = {
        "oldest to newest",
        "newest to oldest",
        "alphabetical",
        "shortest to longest term"
    };
    public void init() { //create GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        
        set.addFlashCard("a", "A");
        set.addFlashCard("b", "B");
        set.addFlashCard("c", "C");
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel upperButtons = new JPanel();
        upperButtons.add(new JLabel("Sort by: "));
        JComboBox dropdown = new JComboBox(possibleSorts);
        dropdown.addActionListener(new SortFlashcardsListener(dropdown));
        upperButtons.add(dropdown);
        JButton remove = new JButton("hi");
        upperButtons.add(remove);
        remove.addActionListener(new removeFlashcardListener());
        
        JPanel flashcardArea = new JPanel();
        initCard(set.getFlashcard(0).getTerm(), TERM_COLOR);
        flashcardArea.add(displayCard);
        flashcardArea.setPreferredSize(new Dimension(480, 288));
        
        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Term: "));
        JTextField termField = new JTextField(10);
        bottom.add(termField);
        bottom.add(new JLabel("Definition: "));
        JTextField definitionField = new JTextField(10);
        bottom.add(definitionField);
        
        JButton addFlashcardSubmitButton = new JButton("Add Flashcard");
        addFlashcardSubmitButton.addActionListener(new AddFlashcardListener(termField, definitionField));
        bottom.add(addFlashcardSubmitButton);
        
        
        mainPanel.add(upperButtons);
        mainPanel.add(flashcardArea);
        mainPanel.add(bottom);
        
//        frame.setPreferredSize(new Dimension(480, 288)); //set dimensions
        
        frame.setContentPane(mainPanel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true); //set visible
    }
    
    private void initCard(String text, Color c) {
//        removeAll();
        
        displayCard = new JButton(text);
        
        displayCard.setBackground(c);
        displayCard.setOpaque(true);
        displayCard.setBorderPainted(false);
        displayCard.setFocusPainted(false);
        
        displayCard.setFont(new Font("Helvetica", Font.PLAIN, 30));
        displayCard.setHorizontalAlignment(JButton.CENTER);
        displayCard.setPreferredSize(new Dimension(480, 288));
        
        displayCard.addActionListener(new CardActionListener());
        
        displayCard.setVisible(true);
        
        displayCard.addKeyListener(new CardKeyListener());
//        
//        revalidate();
//        repaint();
    }
    
    private void drawCardGivenIndex(int index) {
        isDisplayingTerm = true;
        Flashcard currentCard = set.getFlashcard(index);
        
        drawCard(currentCard.getTerm(), TERM_COLOR);
        currentFlashcardIndex = index;
    }
    
    private void drawCard(String text, Color c) {
        displayCard.setText(text);
        displayCard.setBackground(c);
    }
    
    private void flipCard() {
        System.out.println("card flip ");
            
        Flashcard currentCard = set.getFlashcard(currentFlashcardIndex);

        if (isDisplayingTerm) {
            drawCard(currentCard.getDefinition(), DEF_COLOR);
        } else {
            drawCard(currentCard.getTerm(), TERM_COLOR);
        }

        isDisplayingTerm = !isDisplayingTerm;
    }
    
    private void nextCard() {
        System.out.println("next card");
        currentFlashcardIndex++;
        checkCardCycleAndDisplayCard();
    }
    
    private void previousCard() {
        System.out.println("previous card");
        currentFlashcardIndex--;
        checkCardCycleAndDisplayCard();
    }
    
    private void checkCardCycleAndDisplayCard() {
        int index = Math.floorMod(currentFlashcardIndex, set.size());
        drawCardGivenIndex(index);
    }
    
    private class CardActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            flipCard();
        }
        
    }
    
    private class CardKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                flipCard();
            }
            
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                nextCard();
            }
            
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                previousCard();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
    
    private class AddFlashcardListener implements ActionListener {
        private JTextField termField;
        private JTextField definitionField;
        
        public AddFlashcardListener(JTextField termField, JTextField definitionField) {
            this.termField = termField;
            this.definitionField = definitionField;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String term = termField.getText();
            String definition = definitionField.getText();
            
            if (term.length() == 0) {
                errorMessage("Term cannot be empty");
            } else if (definition.length() == 0) {
                errorMessage("Definition cannot be empty");
            } else if (!set.addFlashCard(term, definition)) {
                errorMessage("Term already exists in set");
            }
            
            termField.setText("");
            definitionField.setText("");
        }
        
    }  
    
    private static void errorMessage(String message) {
        JOptionPane.showMessageDialog(null,message , "Error", JOptionPane.WARNING_MESSAGE);
    }
    
    private class removeFlashcardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (set.size() == 1) {
                errorMessage("Cannot have no cards in set");
                return;
            }
            
            set.removeFlashcard(currentFlashcardIndex);
            
            checkCardCycleAndDisplayCard();
        }
        
    }
    
    private class SortFlashcardsListener implements ActionListener {
        private JComboBox dropdown;
        
        public SortFlashcardsListener(JComboBox dropdown) {
            this.dropdown = dropdown;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedItem = (String) dropdown.getSelectedItem();
            
            QuickSort sortingAlgorithm = null;
            switch(selectedItem) {
                case "oldest to newest":
                    System.out.println("oldest to newest");
                    sortingAlgorithm = new OldestToNewestSort();
                    break;
                case "newest to oldest":
                    System.out.println("newest to oldest");
                    sortingAlgorithm = new NewestToOldestSort();
                    break;
                case "alphabetical":
                    System.out.println("alphabetical sort");
                    sortingAlgorithm = new AlphabeticalSort();
                    break;
                case "shortest to longest term":
                    System.out.println("shortest to longest");
                    sortingAlgorithm = new LengthSort();
                    break;
                default:
                    throw new IllegalArgumentException("selected item doesn't match");
            }
            sortingAlgorithm.sort(set.getSet(), set.size());
            drawCardGivenIndex(0);
        }
        
    }
}

