import javax.swing.*;
import java.awt.*;


public class DataGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private World world;
    
    public DataGUI() {
        world = new World("data/names.txt", "data/color.txt", "data/diets.txt", "data/status.txt");
        setTitle("Bird Data Analyzer");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        JButton analyzeColorButton = new JButton("Analyze by Color");
        JButton analyzeDietButton = new JButton("Analyze by Diet");
        JButton analyzeStatusButton = new JButton("Analyze by Status");
        JButton commonColorButton = new JButton("Find Most Common Color");
        JButton commonDietButton = new JButton("Find Most Common Diet");
        JButton commonStatusButton = new JButton("Find Most Common Status");
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

    private static String stringify(Bird[] arr) {
        String result = "";
        for(Bird s : arr) {
            result += s + "\n";
        }
        return result;
    }

    private void analyzeByColor(){
        Bird[] birds = world.searchByColor(inputField.getText());

        resultsArea.setText("Birds with color " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void analyzeByDiet(){
        Bird[] birds = world.searchByDiet(inputField.getText());
        resultsArea.setText("Birds with diet " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void analyzeByStatus(){
        Bird[] birds = world.searchByStatus(inputField.getText());
        resultsArea.setText("Birds with status " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void getMostCommonColor(){
        String count = world.getMostCommonColor();
        resultsArea.setText("Most common color: " + count);
    }

    private void getMostCommonDiet(){
        String count = world.getMostCommonDiet();
        resultsArea.setText("Most common diet "+ ": " + count);
    }

    private void getMostCommonStatus(){
        String count = world.getMostCommonStatus();
        resultsArea.setText("Most common status "+ ": " + count);
    }

    private void getStatusPercentage(){
        // double percentage = DataAnalyzer.statusPercentage();
        resultsArea.setText("Percentage of birds with status "+ ": " + "percentage" + "%");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}