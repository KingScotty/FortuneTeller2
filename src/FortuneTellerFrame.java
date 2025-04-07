import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame  {
    private JTextArea fortuneTextArea;
    private ArrayList<String> fortunes;
    private int lastindex = -1;

    //frame stuff
    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
//makes it load as 75% the screen size, probably.
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);

        //title
        JLabel titleLabel = new JLabel("Esoteric Fortune Teller", SwingConstants.CENTER);
        /*
        ImageIcon imageicon = new ImageIcon("src/fortunteteller.png");
        titleLabel.setIcon(imageicon);*/
        ImageIcon imageicon = new ImageIcon("src/fortunteteller.png");
        setIconImage(imageicon.getImage());
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        add(titleLabel, BorderLayout.NORTH);

        //middle panel
        fortuneTextArea = new JTextArea(10,10);
        fortuneTextArea.setEditable(false);
        fortuneTextArea.setFont(new Font("Monospaced", Font.PLAIN, 24));
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        add(scrollPane, BorderLayout.CENTER);
//some buttons and stuff
        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        //fortune array list and button action

        fortunes = new ArrayList<>();
        addFortunes();
        Random rand = new Random();

        readButton.addActionListener(e -> {
            int index;
            int lastIndex = 0;
            do {
                index = rand.nextInt(fortunes.size());
            } while (index == lastIndex);
            lastIndex = index;
            fortuneTextArea.append(fortunes.get(index) + "\n");
        });
    }

    private void addFortunes() {
    }


}

