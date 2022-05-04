import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class LayoutExtravaganza extends JFrame {
    JPanel superPanel = new SuperPanel();

    public LayoutExtravaganza( ) {
        add(superPanel);
        setTitle("Layout Extravaganza!!");
        setLocation(-1400 , 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        pack();
        revalidate();
    }

    public static void main(String[] args) { new LayoutExtravaganza(); }
}

class SuperPanel extends JPanel {
    Border titledBorder;
    private final JPanel            flowLayoutPanel      = new FlowLayoutPanel();
    private final JPanel            boarderLayoutPanel   = new BoarderLayoutPanel();
    private final JPanel            gridLayoutPanel      = new GridLayoutPanel();
    private final JPanel            boxLayoutPanel       = new BoxLayoutPanel();
    private final JPanel            cardLayoutPanelFront = new CardLayoutPanel();
    private final JPanel            migLayout            = new MigLayoutPanel();
    private final JPanel            gridBagLayoutPanel   = new GridBagLayoutPanel();
    private final JPanel            springLayoutPanel    = new SpringLayoutPanel();
    private final ArrayList<JPanel> jPanelArrayList      = new ArrayList<>();

    public SuperPanel( ) {
        titledBorder = BorderFactory.createTitledBorder("NULL ---> Every Component's Location Is Specified");
        setBorder(titledBorder);
        add(springLayoutPanel);
        add(gridBagLayoutPanel);
        add(cardLayoutPanelFront);
        add(migLayout);
        add(boxLayoutPanel);
        add(gridLayoutPanel);
        add(boarderLayoutPanel);
        add(flowLayoutPanel);
        //        initArray();
        setLayout(null);
        setPreferredSize(new Dimension(790 , 800));
        setBackground(Color.GRAY);
        setVisible(true);
    }

    private void initArray( ) {
        jPanelArrayList.add(getFlowLayoutPanel());
        jPanelArrayList.add(getBoarderLayoutPanel());
        jPanelArrayList.add(getBoxLayoutPanel());
        jPanelArrayList.add(getCardLayoutPanelFront());
        jPanelArrayList.add(getGridLayoutPanel());
        jPanelArrayList.add(getMigLayout());
        jPanelArrayList.add(getSpringLayoutPanel());
        for (JPanel panel: jPanelArrayList) {
            System.out.println(panel);
        }
    }

    public void swapPanels(JPanel source) {
        JPanel temp = source;
        Random random = new Random();
        int arrayLocation = random.nextInt(0 , 6);
        int sourceLocation;
        for (int i = 0 ; i < jPanelArrayList.size() ; i++) {
            while (arrayLocation != jPanelArrayList.indexOf(i)) {

            }
        }

    }

    public JPanel getFlowLayoutPanel( ) { return flowLayoutPanel; }

    public JPanel getBoarderLayoutPanel( ) { return boarderLayoutPanel; }

    public JPanel getGridLayoutPanel( ) { return gridLayoutPanel; }

    public JPanel getBoxLayoutPanel( ) { return boxLayoutPanel; }

    public JPanel getCardLayoutPanelFront( ) { return cardLayoutPanelFront; }

    public JPanel getMigLayout( ) { return migLayout; }

    public JPanel getSpringLayoutPanel( ) { return springLayoutPanel; }
}

class GridBagLayoutPanel extends JPanel implements ActionListener {
    Border             titledBorder;
    GridBagConstraints gbc;
    GridBagLayout      gbl;
    JPanel             grid;
    JLabel             success;
    JTextArea          txtArea;
    JTextField         txtSign;

    public GridBagLayoutPanel( ) {
        titledBorder = BorderFactory.createTitledBorder("GridBagLayoutPanel()");
        setBorder(titledBorder);
        setBounds(10 , 540 , 510 , 250);//
        setLayout(new BoxLayout(this , BoxLayout.PAGE_AXIS));
        setBackground(new Color(0 , 175 , 0));

        gbc  = new GridBagConstraints();
        gbl  = new GridBagLayout();
        grid = new JPanel(new GridBagLayout());
        grid.setBackground(new Color(0 , 255 , 0));
        add(grid);

        txtArea = new JTextArea("""
                                The benefits of having a layout manager will help you organize you components in a specific fashion. With the use of Java Swing most of these layouts allow components to expand and retract. The layouts help designing a programs GUI front-end look. My LayoutExtravaganza program is extremely interactive and quite hilarious as you start clicking around on different things, haha.. I just had to make it more fun.
                                                                          
                                You may be surprised at how many tricks I put in here for mere entertainment.
                                Thanks for playing and sign if you agree! :)
                                Blaze
                                """);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(txtArea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton b1 = new JButton("This");
        JButton b2 = new JButton("Layout");
        JButton b3 = new JButton("Was");
        JButton b4 = new JButton("Hard");
        JSeparator sep1 = new JSeparator();
        txtSign = new JTextField("Sign here...");
        txtSign.setForeground(new Color(100 , 100 , 100));
        JButton btnSign = new JButton("Sign");
        JButton b5 = new JButton("At First");
        success = new JLabel("Successfully Signed?");

        gbc.fill   = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.ipadx  = 70;
        gbc.ipady  = 7;

        gbc.gridx      = 0;
        gbc.gridy      = 0;
        gbc.gridwidth  = 6;
        gbc.gridheight = 4;
        gbl.setConstraints(scrollPane , gbc);
        grid.add(scrollPane , gbc);

        gbc.fill       = GridBagConstraints.BOTH;
        gbc.gridx      = 6;
        gbc.gridy      = 0;
        gbc.gridwidth  = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(b1 , gbc);
        grid.add(b1 , gbc);
        b1.addActionListener(this);

        gbc.gridx      = 6;
        gbc.gridy      = 1;
        gbc.gridwidth  = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(b2 , gbc);
        grid.add(b2 , gbc);
        b2.addActionListener(this);

        gbc.gridx      = 6;
        gbc.gridy      = 2;
        gbc.gridwidth  = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(b3 , gbc);
        grid.add(b3 , gbc);
        b3.addActionListener(this);

        gbc.gridx      = 6;
        gbc.gridy      = 3;
        gbc.gridwidth  = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(b4 , gbc);
        grid.add(b4 , gbc);
        b4.addActionListener(this);

        gbc.fill       = GridBagConstraints.HORIZONTAL;
        gbc.gridx      = 0;
        gbc.gridy      = 4;
        gbc.gridwidth  = 6;
        gbc.gridheight = 1;
        gbl.setConstraints(sep1 , gbc);
        grid.add(sep1 , gbc);

        gbc.gridx      = 0;
        gbc.gridy      = 5;
        gbc.gridwidth  = 6;
        gbc.gridheight = 1;
        gbl.setConstraints(txtSign , gbc);
        grid.add(txtSign , gbc);
        txtSign.addActionListener(this);

        gbc.fill       = GridBagConstraints.BOTH;
        gbc.gridx      = 0;
        gbc.gridy      = 6;
        gbc.gridwidth  = 2;
        gbc.gridheight = 1;
        gbl.setConstraints(btnSign , gbc);
        grid.add(btnSign , gbc);
        btnSign.addActionListener(this);

        gbc.gridx      = 2;
        gbc.gridy      = 6;
        gbc.gridwidth  = 2;
        gbc.gridheight = 1;
        gbl.setConstraints(success , gbc);
        grid.add(success , gbc);

        gbc.fill       = GridBagConstraints.NONE;
        gbc.gridx      = 6;
        gbc.gridy      = 6;
        gbc.gridwidth  = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(b5 , gbc);
        grid.add(b5 , gbc);
        b5.addActionListener(this);

        setVisible(true);
    }

    // Tried this method to save repetition and found it difficult
    private void addGridItem(Container container ,
                             JComponent component ,
                             GridBagConstraints gbc ,
                             GridBagLayout gbl ,
                             int gx ,
                             int gy ,
                             int fill ,
                             int w ,
                             int h) {
        gbc.gridx      = gx;
        gbc.gridy      = gy;
        gbc.fill       = fill;
        gbc.gridwidth  = w;
        gbc.gridheight = h;
        gbc.insets     = new Insets(1 , 1 , 1 , 1);
        gbl.setConstraints(component , gbc);
        container.add(component , gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent source = (JComponent) e.getSource();
        source.setBackground(Color.BLACK);
        source.setForeground(Color.yellow);

        Point signbtn = new Point(17 , 180);
        if (source.getLocation().equals(signbtn.getLocation())) {
            if (!txtSign.getText().equalsIgnoreCase("Sign here...")) {
                success.setText("....I OWN YOUR SOUL!");
                txtArea.insert("YOU FORGOT TO READ THE FINE WRITING! I DEVILISHLY HID IT! MUAHAHAHAHA!\n\n\n\n\n\n" , 0);
                System.out.println(txtArea.getText().length());
                txtArea.insert("\n\n\n\n\n\n\n\n\n\n\nWhen you sign this, I own your soul, and you will do my bidding! --->" , 612);
            }
        }
    }
}

class SpringLayoutPanel extends JPanel implements ActionListener {
    JTextField textField;
    int        exit = 0;
    JButton    b1;
    JButton    b2;
    JButton    b3;
    JButton    b4;
    JButton[] btns = new JButton[4];

    public SpringLayoutPanel( ) {
        Border titledBorder = BorderFactory.createTitledBorder("SpringLayout()");
        setBorder(titledBorder);
        setBounds(530 , 540 , 250 , 250);
        setBackground(new Color(210 , 225 , 20));
        setVisible(true);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        b1 = new JButton("This");
        b2 = new JButton("Wasn't");
        b3 = new JButton("Hard.");
        b4 = new JButton("Layout");
        btns[0]=b1;
        btns[1]=b1;
        btns[2]=b1;
        btns[3]=b1;
        add(b1);
        b1.addActionListener(this);
        add(b2);
        b2.addActionListener(this);
        add(b3);
        b3.addActionListener(this);
        add(b4);
        b4.addActionListener(this);
        layout.putConstraint(SpringLayout.WEST , b1 , 25 , SpringLayout.WEST , this);
        layout.putConstraint(SpringLayout.NORTH , b1 , 10 , SpringLayout.NORTH , this);
        layout.putConstraint(SpringLayout.WEST , b2 , 50 , SpringLayout.WEST , this);
        layout.putConstraint(SpringLayout.NORTH , b2 , 10 , SpringLayout.SOUTH , b1);
        layout.putConstraint(SpringLayout.WEST , b3 , 75 , SpringLayout.WEST , this);
        layout.putConstraint(SpringLayout.NORTH , b3 , 10 , SpringLayout.SOUTH , b2);
        layout.putConstraint(SpringLayout.WEST , b4 , 15 , SpringLayout.EAST , b1);
        layout.putConstraint(SpringLayout.NORTH , b4 , 10 , SpringLayout.NORTH , this);
        JLabel label = new JLabel("Fancy Trick:");
        textField = new JTextField("Type 'Blaze', then -->" , 12);
        JButton btn1 = new JButton("Be Done!");
        JButton btn2 = new JButton("OoOOoOo");
        JCheckBox checkBox1 = new JCheckBox("You win?");
        JCheckBox checkBox2 = new JCheckBox("Joke?");
        add(label);
        add(textField);
        add(btn1);
        btn1.addActionListener(this);
        add(btn2);
        btn2.addActionListener(this);
        add(checkBox1);
        checkBox1.addActionListener(this);
        add(checkBox2);
        checkBox2.addActionListener(this);
        layout.putConstraint(SpringLayout.NORTH , label , 35 , SpringLayout.SOUTH , b3);
        layout.putConstraint(SpringLayout.NORTH , textField , 2 , SpringLayout.SOUTH , label);
        layout.putConstraint(SpringLayout.EAST , btn1 , -10 , SpringLayout.EAST , this);
        layout.putConstraint(SpringLayout.NORTH , btn1 , 10 , SpringLayout.SOUTH , b3);
        layout.putConstraint(SpringLayout.EAST , btn2 , -10 , SpringLayout.EAST , this);
        layout.putConstraint(SpringLayout.NORTH , btn2 , 10 , SpringLayout.SOUTH , btn1);
        layout.putConstraint(SpringLayout.EAST , checkBox1 , -10 , SpringLayout.EAST , this);
        layout.putConstraint(SpringLayout.NORTH , checkBox1 , 8 , SpringLayout.SOUTH , b4);
        layout.putConstraint(SpringLayout.WEST , checkBox2 , 10 , SpringLayout.WEST , this);
        layout.putConstraint(SpringLayout.SOUTH , checkBox2 , -5 , SpringLayout.NORTH , label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent source = (JComponent) e.getSource();
        Point joke = new Point(15 , 132);
        Point win = new Point(159 , 62);
        Point ooo = new Point(144 , 172);
        Point done = new Point(151 , 136);
        Random random = new Random();

        if (source.getLocation().equals(joke.getLocation())) {
            int q = -2, x = 0, y = 0;
            while (q == -2) {
                y = JOptionPane.showOptionDialog(this ,
                                                 "Do you want to see a joke?" ,
                                                 "JOKES!" ,
                                                 1 ,
                                                 1 ,
                                                 null ,
                                                 new String[] {"YES" , "Nah" , "?" , "!"} ,
                                                 0);
                x = y == -1 ? 5 : x;
                q = x == 6 ? 0 : q;
                x++;
            }
        }
        else if (source.getLocation().equals(win.getLocation())) {
            JOptionPane.showMessageDialog(this , "YOU WIN!");
        }
        else if (source.getLocation().equals(ooo.getLocation())) {
            if (textField.getText().equalsIgnoreCase("Blaze")) {
                JOptionPane.showConfirmDialog(this ,
                                              "<3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 "
                                              + "<3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3"
                                              + " <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 BLAZE <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 "
                                              + "<3 <3 LOVES <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 YOU! <3 <3 <3 <3 <3 "
                                              + "<3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3"
                                              + " <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3");
            }
        }
        else if (source.getLocation().equals(done.getLocation())) {
            if (exit == 1) JOptionPane.showMessageDialog(this ,
                                                         "Seriously though you'll regret it if you don't click everything and get your laughs!! :D");
            else if (exit == 2) System.exit(EXIT_ON_CLOSE);
            else JOptionPane.showMessageDialog(this , "Wait! Nooo, Click on EveRYthIng FIRST, then sign the form, and click this last!");
            exit++;
        }
        else {
            JButton temp = (JButton) source;
            int x = random.nextInt(0,3);
            System.out.println(x);
            if (!temp.getText().equals(btns[x].getText())){
                System.out.println(source.getLocation());
                System.out.println(temp.getLocation());
                System.out.println(btns[x].getLocation());
                btns[x].setLocation(temp.getLocation());
                source.setLocation(btns[x].getLocation());
                System.out.println(source.getLocation());
                System.out.println(temp.getLocation());
                System.out.println(btns[x].getLocation());
            }
        }
    }
}

class CardLayoutPanel extends JPanel implements ActionListener {
    JPanel firstCard, secCard, thirdCard, cardPane;
    String redStr, orangeStr, yellowStr;
    CardLayout card;

    public CardLayoutPanel( ) {
        Border titledBorder = BorderFactory.createTitledBorder("CardLayout() ---> Click ART!");
        setBorder(titledBorder);
        setBackground(new Color(250 , 5 , 10));
        setBounds(270 , 280 , 250 , 250);
        firstCard = new JPanel(new BorderLayout());
        secCard   = new JPanel(new BorderLayout());
        thirdCard = new JPanel(new BorderLayout());
        cardPane  = new JPanel();
        firstCard.setBackground(new Color(250 , 5 , 10));
        secCard.setBackground(new Color(250 , 105 , 0));
        thirdCard.setBackground(new Color(210 , 225 , 20));
        redStr    = "First - RED";
        orangeStr = "Second - ORANGE";
        yellowStr = "Third - YELLOW";
        JButton button1 = new JButton("Click Me!");
        button1.addActionListener(this);
        firstCard.add(button1 , BorderLayout.NORTH);
        JButton button2 = new JButton("Click Again!");
        button2.addActionListener(this);
        secCard.add(button2 , BorderLayout.NORTH);
        JButton button3 = new JButton("Click Me Super FAST!");
        button3.addActionListener(this);
        thirdCard.add(button3 , BorderLayout.NORTH);
        JLabel fire1 = new JLabel("FIRE!");
        fire1.setFont(new Font(Font.SERIF , Font.BOLD , 50));
        JLabel fire2 = new JLabel("FIRE!");
        fire2.setFont(new Font(Font.SERIF , Font.BOLD , 50));
        JLabel fire3 = new JLabel("FIRE!");
        fire3.setFont(new Font(Font.SERIF , Font.BOLD , 50));
        firstCard.add(fire1 , BorderLayout.WEST);
        secCard.add(fire2 , BorderLayout.PAGE_END);
        thirdCard.add(fire3 , BorderLayout.LINE_END);
        card = new CardLayout();
        cardPane.setLayout(card);
        cardPane.setPreferredSize(new Dimension(240 , 220));
        cardPane.add(firstCard , redStr);
        cardPane.add(secCard , orangeStr);
        cardPane.add(thirdCard , yellowStr);
        add(cardPane);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(cardPane);
    }
}

class MigLayoutPanel extends JPanel {
    public MigLayoutPanel( ) {
        Border titledBorder = BorderFactory.createTitledBorder("MigLayout() --> Custom .JAR!");
        setBorder(titledBorder);
        setLayout(new MigLayout());
        setBounds(530 , 280 , 250 , 250);
        setBackground(new Color(230 , 5 , 220));
        setVisible(true);

        JLabel lblFirstName = new JLabel("First Name");
        JLabel lblLastName = new JLabel("BONUS");
        JTextField txtFirstName = new JTextField("Blaze" , 20);
        JTextField txtLastName = new JTextField("So many options easily!" , 20);
        JButton btnCreate = new JButton("This");
        JButton btnDelete = new JButton("MIGLayout");
        JSlider jSlider = new JSlider();
        String[] values = new String[] {"THIS" , "IS" , "DOPE!"};
        SpinnerListModel sp = new SpinnerListModel(values);
        sp.setValue("IS");
        JSpinner jSpinner = new JSpinner(sp);
        JTextArea jTextArea = new JTextArea("WOW" , 5 , 5);
        jTextArea.setLineWrap(true);
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("So Cool!");
        JCheckBox jCheckBox = new JCheckBox("New FAV");
        jCheckBox.setSelected(true);

        add(lblFirstName);
        add(txtFirstName , "wrap");
        add(lblLastName);
        add(txtLastName , "wrap, span, gapright 20");
        add(btnCreate , "x 35, y 65, h 25, skip");
        add(btnDelete , "h 30, x 125, wrap");
        add(jSlider , "span, wrap");
        add(jSpinner , "w 100,h 30, push, skip");
        add(jTextArea , "wmax 50, wrap");
        add(comboBox , "x 15, y 170, w 100, h 50");
        add(jCheckBox , "skip");
    }
}

class BoxLayoutPanel extends JPanel implements ActionListener {
    public BoxLayoutPanel( ) {
        Border titledBorder = BorderFactory.createTitledBorder("BoxLayout(this,BoxLayout.Y_AXIS)");
        setBorder(titledBorder);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));
        setBounds(10 , 280 , 250 , 250);
        setBackground(new Color(110 , 5 , 250));
        setVisible(true);
        JButton b1 = new JButton("BoxLayout.Y_AXIS >>> Placed");
        JLabel l1 = new JLabel("Vertical");
        JButton b2 = new JButton("Till - (Regardless Dimensionsx1000)");
        JLabel l2 = new JLabel("Can't");
        JButton b3 = new JButton("Then");
        JLabel l3 = new JLabel("Squish");
        JButton b4 = new JButton("Components Inside Border");
        JLabel l4 = new JLabel("...Like");
        JButton b5 = new JButton("Sooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        b1.setPreferredSize(new Dimension(300 , 45));
        b2.setPreferredSize(new Dimension(1000 , 1000));
        b3.setPreferredSize(new Dimension(65 , 25));
        b4.setPreferredSize(new Dimension(65 , 36));
        b5.setPreferredSize(new Dimension(120 , 100));
        add(b1);
        b1.addActionListener(this);
        add(l1);
        add(b2);
        b2.addActionListener(this);
        add(l2);
        add(b3);
        b3.addActionListener(this);
        add(l3);
        add(b4);
        b4.addActionListener(this);
        add(l4);
        add(b5);
        b5.addActionListener(this);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b5.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent source = (JComponent) e.getSource();
        source.setVisible(false);
    }
}

class GridLayoutPanel extends JPanel implements ActionListener {
    protected final Random randNum = new Random();

    public GridLayoutPanel( ) {
        Border titledBorder = BorderFactory.createTitledBorder("GridLayout(3,3,3,3)");
        setBorder(titledBorder);
        setLayout(new GridLayout(3 , 3 , 3 , 3));
        setBounds(530 , 20 , 250 , 250);
        setBackground(new Color(15 , 165 , 196));
        setVisible(true);
        JButton b1 = new JButton("What");
        JButton b2 = new JButton("Does");
        JButton b3 = new JButton("This");
        JButton b4 = new JButton("Do,");
        JButton b5 = new JButton("Dare");
        JButton b6 = new JButton("You");
        JButton b7 = new JButton("To");
        JButton b8 = new JButton("Click");
        JButton b9 = new JButton("it!");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
    }

    public int getRandNum( ) {
        return randNum.nextInt(0 , 255);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        source.setBackground(new Color(getRandNum() , getRandNum() , getRandNum()));
    }
}

class BoarderLayoutPanel extends JPanel implements ActionListener {
    String[] northArr  = {"Never" ,
                          "Always" ,
                          "On Occation" ,
                          "Rarely" ,
                          "Definitely" ,
                          "Not on your Life" ,
                          "Forever" ,
                          "No Way" ,
                          "Certainly" ,
                          "If You"};
    String[] eastArr   = {"Eat" , "Guzzle" , "Snack" , "Rarely" , "Devour" , "Feast" , "Inhale" , "Graze" , "Chew" , "Munch"};
    String[] southArr  = {"Soggy" , "Oozing" , "Lumpy" , "Lucious" , "Divine" , "Spirited" , "Zesty" , "Juicy" , "Fluffy" , "Moist"};
    String[] westArr   = {"Waffles" , "Green Eggs" , "Boot" , "Spam" , "Neighbor" , "Escargot" , "Slime" , "Plants" , "Dragon" , "Eyeballs"};
    String[] centerArr = {"Copeesh?" , "Gadzooks!" , "Totes Mgee!" , "Durp?" , "Huzzah!" , "Porque?" , "Sure!" , "Skal!" , "Pardon?" , "aaaa..."};
    Random   random    = new Random();
    JButton  b3;
    JButton  b5;

    public BoarderLayoutPanel( ) {
        Border titledBorder = BorderFactory.createTitledBorder("BoarderLayout()");
        setBorder(titledBorder);
        setLayout(new BorderLayout());
        setBounds(270 , 20 , 250 , 250);
        setBackground(new Color(15 , 165 , 96));
        setVisible(true);
        JButton b1 = new JButton("NEVER");
        JButton b2 = new JButton("SOGGY");
        b3 = new JButton("EAT");
        JButton b4 = new JButton("WAFFLES");
        b5 = new JButton("COPEESH?");
        add(b1 , BorderLayout.NORTH);
        add(b2 , BorderLayout.SOUTH);
        add(b3 , BorderLayout.EAST);
        add(b4 , BorderLayout.WEST);
        add(b5 , BorderLayout.CENTER);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        Point north = new Point(5 , 18);
        Point east = new Point(189 , 44);
        Point south = new Point(5 , 219);
        Point west = new Point(5 , 44);
        Point center = new Point(93 , 44);
        System.out.println(source.getAccessibleContext());
        System.out.println(source.getAction());
        System.out.println(source.getFont());
        System.out.println(source.getMnemonic());
        System.out.println(source.getText());

        if (source.getLocation().equals(north.getLocation())) {
            int x = random.nextInt(0 , 9);
            source.setText(northArr[x]);
        }
        else if (source.getText().equals(b3.getText())) {
            int x = random.nextInt(0 , 9);
            source.setText(eastArr[x]);
        }
        else if (source.getLocation().equals(south.getLocation())) {
            int x = random.nextInt(0 , 9);
            source.setText(southArr[x]);
        }
        else if (source.getLocation().equals(west.getLocation())) {
            int x = random.nextInt(0 , 9);
            source.setText(westArr[x]);
        }
        else if (source.getText().equals(b5.getText())) {
            int x = random.nextInt(0 , 9);
            source.setText(centerArr[x]);
        }
    }
}

class FlowLayoutPanel extends JPanel implements ActionListener {
    public FlowLayoutPanel( ) {
        Border titledBorder = BorderFactory.createTitledBorder("FlowLayout()");
        setBorder(titledBorder);
        setLayout(new FlowLayout());
        setBounds(10 , 20 , 250 , 250);
        setBackground(new Color(250 , 105 , 0));
        setVisible(true);
        JButton b1 = new JButton("Placed");
        JLabel l1 = new JLabel("Horizontal");
        JButton b2 = new JButton("Till");
        JLabel l2 = new JLabel("Can't");
        JButton b3 = new JButton("Then");
        JLabel l3 = new JLabel("Next");
        JButton b4 = new JButton("Line");
        JLabel l4 = new JLabel("...Like");
        JButton b5 = new JButton("So");
        b1.setPreferredSize(new Dimension(100 , 45));
        b2.setPreferredSize(new Dimension(65 , 65));
        b3.setPreferredSize(new Dimension(65 , 25));
        b4.setPreferredSize(new Dimension(65 , 36));
        b5.setPreferredSize(new Dimension(120 , 100));
        add(b1);
        b1.addActionListener(this);
        add(l1);
        add(b2);
        b2.addActionListener(this);
        add(l2);
        add(b3);
        b3.addActionListener(this);
        add(l3);
        add(b4);
        b4.addActionListener(this);
        add(l4);
        add(b5);
        b5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent source = (JComponent) e.getSource();
        source.setToolTipText("Now that you clicked it... Duh, it's just a button.");
        source.setForeground(Color.lightGray);
    }
}


