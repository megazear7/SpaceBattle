

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class GuiTest extends JFrame implements ActionListener {

    private String input, output;
    private static final int LINES_IN_TEXT_AREAS = 5;
    private static final int LINE_LENGTHS_IN_TEXT_AREAS = 20;
    private static final int ROWS_IN_THIS_GRID = 1;
    private static final int COLUMNS_IN_THIS_GRID = 1;
    private static final int ROWS_IN_BUTTON_PANEL_GRID = 3;
    private static final int COLUMNS_IN_BUTTON_PANEL_GRID = 1;

    private final JTextArea inputText;
    private final JTextArea outputText;
    
    private Input gameInput;
    
    private final JButton submitButton;

    public String commandText(){
    	return this.inputText.getText();
    }

    public void addHistory(String history){
    	String oldText = this.outputText.getText();
    	this.outputText.setText(history + oldText);
    }

    
    public static void main(String[] args) {
        /*
         * Create an instance of this class, which is a JFrame in which the
         * constructor sets up everything that will appear in the main
         * application window to begin with, and also starts up the interaction
         * process by registering a callback method with each GUI widget that
         * the user can manipulate. The actual callback method, actionPerformed
         * (declared in ActionListener and implemented in this class), is called
         * by a widget whenever the user manipulates it, e.g., presses a button.
         * (The reference returned by the constructor may be ignored, as the
         * main program is done with its job once the constructor returns!)
         */
    }

    public GuiTest(Input gameInput) {
        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("Simple GUI Demo");
        this.gameInput = gameInput;
    	
        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */

        // Set up the model variables ----------------------------------------

        /*
         * Initialize model variable values; both start as empty strings
         */
        this.input = "";
        this.output = "";

        // Set up the GUI widgets --------------------------------------------

        /*
         * Create widgets
         */
        this.submitButton = new JButton("Submit Command");
        this.outputText = new JTextArea("", LINES_IN_TEXT_AREAS,
                LINE_LENGTHS_IN_TEXT_AREAS);        this.inputText = new JTextArea("", LINES_IN_TEXT_AREAS,
                LINE_LENGTHS_IN_TEXT_AREAS);


        /*
         * Text areas should wrap lines, and outputText should be read-only
         */
        this.inputText.setEditable(true);
        this.inputText.setLineWrap(true);
        this.inputText.setWrapStyleWord(true);
        this.outputText.setEditable(false);
        this.outputText.setLineWrap(true);
        this.outputText.setWrapStyleWord(true);

        /*
         * Create scroll panes for the text areas in case text is long enough to
         * require scrolling in one or both dimensions
         */
        JScrollPane inputTextScrollPane = new JScrollPane(this.inputText);

        JPanel buttonPanel = new JPanel(new GridLayout(
                ROWS_IN_BUTTON_PANEL_GRID, COLUMNS_IN_BUTTON_PANEL_GRID));
        /*
         * Add the buttons to the button panel, from left to right and top to
         * bottom
         */
        buttonPanel.add(this.inputText);
        buttonPanel.add(this.outputText);
        buttonPanel.add(this.submitButton);
       
        this.setLayout(new GridLayout(ROWS_IN_THIS_GRID, COLUMNS_IN_THIS_GRID));

        this.add(buttonPanel);

        /*
         * Organize main window using grid layout
         */
        /*
         * Add scroll panes and button panel to main window, from left to right
         * and top to bottom
         */
        this.add(inputTextScrollPane);

        // Set up the observers ----------------------------------------------
        this.submitButton.addActionListener(this);

        /*
         * Register this object as the observer for all GUI events
         */

        // Set up the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized for the widgets in
         * it, that it exits this program when closed, and that it becomes
         * visible to the user now
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
        Object source = event.getSource();
        
        if(source == this.submitButton){
        	this.gameInput.giveCommand(this.inputText.getText());
        	this.inputText.setText("");
        }
        
        this.setCursor(Cursor.getDefaultCursor());
		
	}

}
