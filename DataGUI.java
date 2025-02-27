import javax.swing.*;
import java.awt.*;


public class DataGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    
    public DataGUI() {
        setTitle("Bird Data Analyzer");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        JButton analyzeColorButton = new JButton("Analyze by Color");
        JButton analyzeDietButton = new JButton("Analyze by Diet");
        JButton analyzeStatusButton = new JButton("Analyze by Status");
        JButton commonColorButton = new JButton("Count with Color");
        JButton commonDietButton = new JButton("Count with Diet");
        JButton commonStatusButton = new JButton("Count with Status");
        JButton statusPercentageButton = new JButton("Status Percentage");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        add(inputField);
        add(analyzeColorButton);
        add(analyzeDietButton);
        add(analyzeStatusButton);
        add(commonColorButton);
        add(commonDietButton);
        add(commonStatusButton);
        add(statusPercentageButton);
        add(new JScrollPane(resultsArea));

        analyzeColorButton.addActionListener(e -> analyzeByColor());
        analyzeDietButton.addActionListener(e -> analyzeByDiet());
        analyzeStatusButton.addActionListener(e -> analyzeByStatus());
        commonColorButton.addActionListener(e -> getMostCommonColor());
        commonDietButton.addActionListener(e -> getMostCommonDiet());
        commonStatusButton.addActionListener(e -> getMostCommonStatus());
        statusPercentageButton.addActionListener(e -> getStatusPercentage());
    }

    private static String stringify(String[] arr) {
        String result = "";
        for(String s : arr) {
            result += s + "\n";
        }
        return result;
    }

    private void analyzeByColor(){
        String[] birds = DataAnalyzer.birdsWithColor(inputField.getText());

        resultsArea.setText("Birds with color " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void analyzeByDiet(){
        String[] birds = DataAnalyzer.birdsWithDiet(inputField.getText());
        resultsArea.setText("Birds with diet " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void analyzeByStatus(){
        String[] birds = DataAnalyzer.birdsWithStatus(inputField.getText());
        resultsArea.setText("Birds with status " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void getMostCommonColor(){
        int count = DataAnalyzer.countWithColor(inputField.getText());
        resultsArea.setText("Number of birds with color " + inputField.getText() + ": " + count);
    }

    private void getMostCommonDiet(){
        int count = DataAnalyzer.countWithDiet(inputField.getText());
        resultsArea.setText("Number of birds with diet " + inputField.getText() + ": " + count);
    }

    private void getMostCommonStatus(){
        int count = DataAnalyzer.countWithStatus(inputField.getText());
        resultsArea.setText("Number of birds with status " + inputField.getText() + ": " + count);
    }

    private void getStatusPercentage(){
        double percentage = DataAnalyzer.statusPercentage(inputField.getText());
        resultsArea.setText("Percentage of birds with status " + inputField.getText() + ": " + percentage + "%");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}