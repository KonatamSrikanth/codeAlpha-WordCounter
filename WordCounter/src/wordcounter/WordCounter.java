package wordcounter;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordCounter extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounter() {
     
        setTitle("Word Counter");
        setSize(555, 455);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

      
        textArea    = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word Count: 0");

     
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);
        countButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        int wordCount = countWords(text);
        resultLabel.setText("Word Count: " + wordCount);
    }
    
    	private int countWords(String text) {
    	    
    	    text = text.trim();
    	    if (text.isEmpty()) {
    	        return 0; 
    	    }
    	    
    	    String[] words = text.split("\\s+");
    	    int count = 0;
    	    for (String word : words) {
    	        if (!word.isEmpty()) {
    	            count++;
    	        }
    	    }
    	    return count;
    	}


    public static void main(String[] args) {
        new WordCounter();
    }
}
