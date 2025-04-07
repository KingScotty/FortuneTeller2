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
        JLabel titleLabel = new JLabel("Esoteric Fortune Teller");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centers the whole label in the NORTH panel

        ImageIcon rawIcon = new ImageIcon("src/fortunteteller.png");
        Image scaledImage = rawIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(scaledImage);

        titleLabel.setIcon(imageicon);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // 👈 Put text below image
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER); // 👈 Center text under image

        setIconImage(imageicon.getImage());
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        add(titleLabel, BorderLayout.NORTH);
      /*  //title
       // JLabel titleLabel = new JLabel("Esoteric Fortune Teller", SwingConstants.CENTER);
        JLabel titleLabel = new JLabel("Esoteric Fortune Teller");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon rawIcon = new ImageIcon("src/fortunteteller.png");
        Image scaledImage = rawIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(scaledImage);
       /* ImageIcon imageicon = new ImageIcon("src/fortunteteller.png");

        titleLabel.setIcon(imageicon);
      /*  ImageIcon imageicon = new ImageIcon("src/fortunteteller.png");*/ /*
        setIconImage(imageicon.getImage());
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        add(titleLabel, BorderLayout.NORTH);
        */

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
        fortunes.add("You have been chosen by the Segfault Spirits. They whisper in hexadecimal.");
        fortunes.add("A forbidden algorithm lies in your future. Use it wisely, or not at all.");
        fortunes.add("Today, the bugs will hide... but they are always watching.");
        fortunes.add("The compiler understands you better than your friends do.");
        fortunes.add("Your next 'simple fix' will unravel the fabric of your codebase.");
        fortunes.add("Ancient code from 2003 awaits your sacrifice.");
        fortunes.add("Beware the off-by-one demon. He strikes when you’re tired.");
        fortunes.add("A pull request rejected is not a failure, but a test of resolve.");
        fortunes.add("You will soon write a method so pure, even Linus will nod.");
        fortunes.add("Every null pointer is a ghost of a forgotten variable.");
        fortunes.add("The logs are lying to you. Trust your instincts.");
        fortunes.add("One day, you will stare into the abyss of legacy code—and it will stare back.");
    }


}

