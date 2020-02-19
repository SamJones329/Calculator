package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {
    
    JButton add, sub, mult, div, one, two, three, four, five, six, seven, eight,
        nine, zero, clearEverything, clear, backspace, leftParentheses, 
        rightParentheses, equals, decimal;
    JTextField io;
    Dimension DIM = new Dimension(400, 400);
    Font defaultFont = new Font("Helvetica", Font.PLAIN, 30);
    private final int BUTTON_SIZE = 1;
    
    
    /**
     * Creates a new JFrame containing all the GUI for the calculator.
     */
    public GUI(){
        
        //creates and centers frame, handles exit
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        
        //creating the buttons
        add = new JButton("+");
        sub = new JButton("-");
        mult = new JButton("*");
        div = new JButton("/");
        leftParentheses = new JButton("(");
        rightParentheses = new JButton(")");
        clear = new JButton("C");
        clearEverything = new JButton("CE");
        equals = new JButton("=");
        backspace = new JButton("X");
        decimal = new JButton (".");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        io = new JTextField(9);
        
        //adding listeners for the buttons
        add.addActionListener(new listenForButton());
        sub.addActionListener(new listenForButton());
        mult.addActionListener(new listenForButton());
        div.addActionListener(new listenForButton());
        leftParentheses.addActionListener(new listenForButton());
        rightParentheses.addActionListener(new listenForButton());
        clear.addActionListener(new listenForButton());
        clearEverything.addActionListener(new listenForButton());
        equals.addActionListener(new listenForButton());
        backspace.addActionListener(new listenForButton());
        decimal.addActionListener(new listenForButton());
        one.addActionListener(new listenForButton());
        two.addActionListener(new listenForButton());
        three.addActionListener(new listenForButton());
        four.addActionListener(new listenForButton());
        five.addActionListener(new listenForButton());
        six.addActionListener(new listenForButton());
        seven.addActionListener(new listenForButton());
        eight.addActionListener(new listenForButton());
        nine.addActionListener(new listenForButton());
        zero.addActionListener(new listenForButton());
        
        //setting the buttons to be unfocusable
        add.setFocusable(false);
        sub.setFocusable(false);
        mult.setFocusable(false);
        div.setFocusable(false);
        leftParentheses.setFocusable(false);
        rightParentheses.setFocusable(false);
        clear.setFocusable(false);
        clearEverything.setFocusable(false);
        equals.setFocusable(false);
        backspace.setFocusable(false);
        decimal.setFocusable(false);
        one.setFocusable(false);
        two.setFocusable(false);
        three.setFocusable(false);
        four.setFocusable(false);
        five.setFocusable(false);
        six.setFocusable(false);
        seven.setFocusable(false);
        eight.setFocusable(false);
        nine.setFocusable(false);
        zero.setFocusable(false);
        
        //adding the components to the grid
        addComp(mainPanel, io, 0, 0, 4, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Font("Helvetica", Font.PLAIN, 40), 0);
        //addComp(mainPanel, clearEverything, 3, 0, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, leftParentheses, 0, 1, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, .7);
        addComp(mainPanel, rightParentheses, 1, 1, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 1);
        addComp(mainPanel, backspace, 2, 1, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, div, 3, 1, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, .85);
        addComp(mainPanel, one, 0, 2, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, two, 1, 2, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, three, 2, 2, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, mult, 3, 2, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, four, 0, 3, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, five, 1, 3, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, six, 2, 3, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, sub, 3, 3, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, seven, 0, 4, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, eight, 1, 4, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, nine, 2, 4, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, add, 3, 4, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, clear, 0, 5, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, zero, 1, 5, BUTTON_SIZE, BUTTON_SIZE, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        addComp(mainPanel, decimal, 2, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0.4);
        addComp(mainPanel, equals, 3, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, defaultFont, 0);
        
        //finishes handling of panel and JFrame, set the JTextField as unfocusable
        io.setFocusable(false);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        //this.setSize(DIM);
        this.setResizable(false);
    }
    
    
    /**
     * Helper method for adding components to GridBagLayout.
     * @param thePanel - The panel to be added to.
     * @param comp - The component to be modified.
     * @param xPos - The x-position of the component.
     * @param yPos - The y-position of the component.
     * @param compWidth - The width of the component.
     * @param compHeight - The height of the component.
     * @param place - The anchor of the component.
     * @param stretch - The fill of the component.
     * @param font - The font of the component.
     * @param xWeight - The weight of the component in x-direction (y defaults 
     * to 1). This value generally requires the most tweaking.
     */
    private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch, Font font, double xWeight){
	
	GridBagConstraints gridConstraints = new GridBagConstraints();
	
        comp.setFont(font);
	gridConstraints.gridx = xPos;
	gridConstraints.gridy = yPos;
	gridConstraints.gridwidth = compWidth;
	gridConstraints.gridheight = compHeight;
	gridConstraints.weightx = xWeight;
	gridConstraints.weighty = 1;
	gridConstraints.insets = new Insets(5,5,5,5);
	gridConstraints.anchor = place;
        gridConstraints.fill = stretch;
        
        thePanel.add(comp, gridConstraints);
        thePanel.addKeyListener(new listenForKeys());
    }
    
    
    
    
    //Button Listener Subclass
    private class listenForButton implements ActionListener{

        /**
         * Handles modifying text of the IO window based on buttons pressed.
         * @param e - The event of a button being pressed.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = io.getText();
            if(e.getSource() == one)
                io.setText(text + 1);
            else if(e.getSource() == two)
                io.setText(text + 2);
            else if(e.getSource() == three)
                io.setText(text + 3);
            else if(e.getSource() == four)
                io.setText(text + 4);
            else if(e.getSource() == five)
                io.setText(text + 5);
            else if(e.getSource() == six)
                io.setText(text + 6);
            else if(e.getSource() == seven)
                io.setText(text + 7);
            else if(e.getSource() == eight)
                io.setText(text + 8);
            else if(e.getSource() == nine)
                io.setText(text + 9);
            else if(e.getSource() == zero)
                io.setText(text + 0);
            else if(e.getSource() == add){
                switch(text.substring(text.length()-1, text.length())){
                    case "+":
                        break;
                    case "-":
                        io.setText(text.substring(0, text.length()-1) + "+");
                        break;
                    case "*":
                        io.setText(text.substring(0, text.length()-1) + "+");
                        break;
                    case "/":
                        io.setText(text.substring(0, text.length()-1) + "+");
                        break;
                    default:
                        io.setText(text.substring(0, text.length()) + "+");
                        break;
                }
            }
            else if(e.getSource() == sub)
                switch(text.substring(text.length()-1, text.length())){
                    case "-":
                        break;
                    case "+":
                        io.setText(text.substring(0, text.length()-1) + "-");
                        break;
                    case "*":
                        io.setText(text.substring(0, text.length()-1) + "-");
                        break;
                    case "/":
                        io.setText(text.substring(0, text.length()-1) + "-");
                        break;
                    default:
                        io.setText(text.substring(0, text.length()) + "-");
                        break;
                }
            else if(e.getSource() == mult)
                switch(text.substring(text.length()-1, text.length())){
                    case "*":
                        break;
                    case "-":
                        io.setText(text.substring(0, text.length()-1) + "*");
                        break;
                    case "+":
                        io.setText(text.substring(0, text.length()-1) + "*");
                        break;
                    case "/":
                        io.setText(text.substring(0, text.length()-1) + "*");
                        break;
                    default:
                        io.setText(text.substring(0, text.length()) + "*");
                        break;
                }
            else if(e.getSource() == div)
                switch(text.substring(text.length()-1, text.length())){
                    case "/":
                        break;
                    case "-":
                        io.setText(text.substring(0, text.length()-1) + "/");
                        break;
                    case "*":
                        io.setText(text.substring(0, text.length()-1) + "/");
                        break;
                    case "+":
                        io.setText(text.substring(0, text.length()-1) + "/");
                        break;
                    default:
                        io.setText(text.substring(0, text.length()) + "/");
                        break;
                }
            else if(e.getSource() == leftParentheses)
                io.setText(text + "(");
            else if(e.getSource() == rightParentheses)
                io.setText(text + ")");
            else if(e.getSource() == decimal)
                io.setText(text + ".");
            else if(e.getSource() == backspace)
                io.setText(text.substring(0, text.length()-1));
            else if(e.getSource() == equals)
                io.setText(Calculator.evaluate(text));
            else if(e.getSource() == clear)
                io.setText("");
        }
        
    }
    
    
    
    
    //Key Listener Subclass
    private class listenForKeys implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        /**
         * Handles modifying text of the IO window based on keys pressed.
         * @param e - The event of a key being pressed.
         */
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_1:
                    io.setText(io.getText() + "1");
                    break;
                case KeyEvent.VK_2:
                    io.setText(io.getText() + "2");
                    break;
                case KeyEvent.VK_3:
                    io.setText(io.getText() + "3");
                    break;
                case KeyEvent.VK_4:
                    io.setText(io.getText() + "4");
                    break;
                case KeyEvent.VK_5:
                    io.setText(io.getText() + "5");
                    break;
                case KeyEvent.VK_6:
                    io.setText(io.getText() + "6");
                    break;
                case KeyEvent.VK_7:
                    io.setText(io.getText() + "7");
                    break;
                case KeyEvent.VK_8:
                    io.setText(io.getText() + "8");
                    break;
                case KeyEvent.VK_9:
                    io.setText(io.getText() + "9");
                    break;
                case KeyEvent.VK_0:
                    io.setText(io.getText() + "0");
                    break;
                case KeyEvent.VK_PLUS:
                    io.setText(io.getText() + "+");
                    break;
                case KeyEvent.VK_MINUS:
                    io.setText(io.getText() + "-");
                    break;
                case KeyEvent.VK_ASTERISK:
                    io.setText(io.getText() + "*");
                    break;
                case KeyEvent.VK_SLASH:
                    io.setText(io.getText() + "/");
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    io.setText(io.getText().substring(0, io.getText().length()-1));
                    break;
                case KeyEvent.VK_ENTER:
                    io.setText(Calculator.evaluate(io.getText()));
                    break;
                case KeyEvent.VK_DELETE:
                    io.setText("");
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
