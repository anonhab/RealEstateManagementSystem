package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class realproject extends JFrame implements ActionListener {
    public static int ch = 0;
    private static final long serialVersionUID = 1L;
    private JPanel textPanel, inputPanel;
    JPanel appoint = new JPanel();
    JPanel appro = new JPanel();
    JScrollPane apos = new JScrollPane(appoint);
    JScrollPane aprvd = new JScrollPane(appro);
    private JTextField textField;
    private String name, message;
    private Font meiryoFont = new Font("Meiryo", Font.PLAIN, 14);
    private Border blankBorder = BorderFactory.createEmptyBorder(10, 10, 20, 10);// top,r,b,l
    private ChatClient3 chatClient;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    protected JTextArea textArea, userArea;
    protected JFrame frame;
    protected JButton privateMsgButton;
    protected JPanel clientPanel, userPanel;
    private JFileChooser fileChooser = new JFileChooser();
    public JButton chooseButton, updateButton, contactbutton, profile1;
    private JPanel proupdate = new JPanel();
    private JScrollPane proupscrol = new JScrollPane(proupdate);
    public static File selectedFile;
    private static String user_id_for_post;
    private JPanel proform = new JPanel(null);
    JPanel rightcont = new JPanel();
    JPanel myaccount = new JPanel(new GridLayout(20, 1, 4, 2));
    JPanel rigJPanel3 = new JPanel();
    private JTextArea descriptionTextArea;
    private Connection conn;
    JButton postButton = new JButton("POST");
    private JComboBox<String> conditionComboBox, addressComboBox, locationComboBox;
    private JRadioButton male, female, males, females, malea, femalea;
    private JPasswordField passwordField, passwordFields, passwordFielda;
    private JTextField searcfiled, priceTextField, squareMeterTextField, titleTextField, firstNameTextField,
            lastNameTextField,
            emailTextField, user_idb, userNameTextField,
            cityTextField,
            firstNameTextFields, lastNameTextFields, user_ids, emailTextFields, userNameTextFields,
            cityTextFields, firstNameTextFielda, lastNameTextFielda, user_ida, emailTextFielda, userNameTextFielda,
            cityTextFielda;
    private JSpinner age, ages, bedroomsSpinner, bathroomsSpinner, agea;
    CardLayout cl = new CardLayout();

    public realproject() {

        setTitle("Real Estate Management System");
        setSize(1340, 701);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel leftcon = new JPanel(cl);
        JPanel mainPanel = new JPanel(new BorderLayout());
        // Top Label
        JLabel topLabel = new JLabel("         Real Estate Management System");
        JLabel topLabel1 = new JLabel("                     Welecome Back");
        topLabel.setFont(new Font("System Bold", Font.BOLD, 29));
        topLabel.setPreferredSize(new Dimension(696, 30));
        topLabel1.setFont(new Font("System Bold", Font.BOLD, 29));
        topLabel1.setPreferredSize(new Dimension(696, 30));
        JPanel northcon = new JPanel(cl);
        northcon.setPreferredSize(new Dimension(696, 40));
        JPanel welecom = new JPanel();
        JPanel weleback = new JPanel();
        JPanel welebackbuyer = new JPanel();
        JLabel welbac = new JLabel("                Welecome Back Dear Buyer");
        welbac.setFont(new Font("System Bold", Font.BOLD, 29));
        welbac.setPreferredSize(new Dimension(696, 30));
        welecom.add(topLabel);
        weleback.add(topLabel1);
        welebackbuyer.add(welbac);
        JPanel welforadmin = new JPanel();
        JLabel weladm = new JLabel("Welcome, Admin! Your leadership is key to our success.");
        weladm.setFont(new Font("System Bold", Font.BOLD, 20));
        weladm.setPreferredSize(new Dimension(696, 30));
        welforadmin.add(weladm);
        welforadmin.setBackground(Color.ORANGE);
        weleback.setBackground(Color.orange);
        welebackbuyer.setBackground(Color.orange);
        northcon.add(welecom, "welecom");
        northcon.add(weleback, "weleback");
        northcon.add(welebackbuyer, "welforbuyer");
        northcon.add(welforadmin, "weladmin");
        mainPanel.add(northcon, BorderLayout.NORTH);
        // Left Panel
        JPanel leftPanel = new JPanel(null);
        leftPanel.setPreferredSize(new Dimension(851, 511));
        leftPanel.setBackground(Color.lightGray);
        // add backgroung image on left panel
        ImageIcon logoIcon = new ImageIcon("/home/anon/Documents/pro/gb/java/src/lolol.png");
        JLabel logoLabel = new JLabel(logoIcon);
        // logoLabel.setBounds(1, 1, 200, 150);
        logoLabel.setSize(742, 450);

        leftPanel.add(logoLabel);
        JLabel sloganLabel1 = new JLabel("Where Dreams Meet Foundations");
        sloganLabel1.setFont(new Font("System Bold", Font.BOLD, 17));
        sloganLabel1.setBounds(220, 456, 334, 55);
        leftPanel.add(sloganLabel1);
        JLabel sloganLabel2 = new JLabel("Your Real Estate Journey");
        sloganLabel2.setFont(new Font("System Bold", Font.BOLD, 17));
        sloganLabel2.setBounds(260, 501, 246, 18);
        leftPanel.add(sloganLabel2);
        JLabel sloganLabel3 = new JLabel("Starts Here");
        sloganLabel3.setFont(new Font("System Bold", Font.BOLD, 17));
        sloganLabel3.setBounds(300, 532, 154, 16);
        // sloganLabel3.setForeground(new Color(192, 201, 7));
        leftPanel.add(sloganLabel3);
        JButton registerButton = new JButton("Sign Up");
        registerButton.addActionListener(this);
        registerButton.setFont(new Font("System Bold", Font.BOLD, 15));
        registerButton.setBounds(70, 578, 112, 29);
        leftPanel.add(registerButton);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setFont(new Font("System Bold", Font.BOLD, 14));
        loginButton.setBounds(608, 578, 102, 29);
        leftPanel.add(loginButton);
        leftPanel.add(sloganLabel1);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(12, 5, 1, 10));
        centerPanel.setPreferredSize(new Dimension(1, 511));
        JButton profile = new JButton("POST");
        profile.addActionListener(this);
        profile.setFont(new Font("System Bold", Font.BOLD, 14));
        profile1 = new JButton("Message");
        profile1.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton profile2 = new JButton("My Properties");
        profile2.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton profile3 = new JButton("My Appointemnt");
        profile3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Appointemnt(user_id_for_post);
                cl.show(rightcont, "appo");
                
            }

        });
        JButton progile4 = new JButton("My Account");
        JButton profile5 = new JButton("Logout");

        profile3.setFont(new Font("System Bold", Font.BOLD, 14));

        progile4.setFont(new Font("System Bold", Font.BOLD, 14));
        profile3.setFont(new Font("System Bold", Font.BOLD, 14));
        profile5.setFont(new Font("System Bold", Font.BOLD, 14));
        centerPanel.add(profile);
        centerPanel.add(profile1);
        centerPanel.add(profile2);
        centerPanel.add(profile3);
        centerPanel.add(progile4);
        centerPanel.add(profile5);

        centerPanel.setBackground(Color.darkGray);
        /////
        JPanel test = new JPanel();
        JButton but = new JButton("test");
        test.add(but);
        //////////////////////// for bu
        leftcon.add(leftPanel, "leftpanel");
        leftcon.add(test, "test");
        leftcon.add(centerPanel, "centerpanel");
        mainPanel.add(leftcon, BorderLayout.WEST);
        // Right Panel for buyer registeration
        JPanel rightPanel = new JPanel(new GridLayout(23, 18, 0, 10));
        rightPanel.setPreferredSize(new Dimension(471, 481));
        rightPanel.setBackground(Color.WHITE);
        JLabel registerLabel = new JLabel("                 Buyer Register Form");
        registerLabel.setFont(new Font("System BOLD", Font.BOLD, 18));
        registerLabel.setBounds(80, 26, 166, 19);
        rightPanel.add(registerLabel);
        JLabel firstNameLabel = new JLabel("First name");
        rightPanel.add(firstNameLabel);
        firstNameTextField = new JTextField();
        rightPanel.add(firstNameTextField);
        JLabel lastNameLabel = new JLabel("Last name");
        rightPanel.add(lastNameLabel);
        lastNameTextField = new JTextField();
        rightPanel.add(lastNameTextField);
        JLabel emailLabel = new JLabel("Email");
        rightPanel.add(emailLabel);
        emailTextField = new JTextField();
        rightPanel.add(emailTextField);
        JLabel useridb = new JLabel("User_ID");
        rightPanel.add(useridb);
        user_idb = new JTextField();
        rightPanel.add(user_idb);
        JLabel passwordLabel = new JLabel("Password");
        rightPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        rightPanel.add(passwordField);
        JLabel sex = new JLabel("Sex");
        rightPanel.add(sex);
        male = new JRadioButton("Male");
        rightPanel.add(male);
        female = new JRadioButton("Female");
        rightPanel.add(female);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        JLabel Age = new JLabel("Age");
        rightPanel.add(Age);
        SpinnerModel value = new SpinnerNumberModel(5, 0, 10, 1);
        age = new JSpinner(value);
        rightPanel.add(age);
        JLabel userNameLabel = new JLabel("Address");
        rightPanel.add(userNameLabel);
        userNameTextField = new JTextField();
        rightPanel.add(userNameTextField);
        JLabel cityLabel = new JLabel("City");
        rightPanel.add(cityLabel);
        cityTextField = new JTextField();
        rightPanel.add(cityTextField);
        JButton saveButton = new JButton("Sign Up");
        rightPanel.add(saveButton);
        // right panel for seller
        JPanel rightPanel_seller = new JPanel(new GridLayout(23, 18, 0, 10));
        rightPanel_seller.setPreferredSize(new Dimension(471, 481));
        rightPanel_seller.setBackground(Color.CYAN);
        JLabel registerLabels = new JLabel("                   Seller Register Form");
        registerLabels.setFont(new Font("System BOLD", Font.BOLD, 18));
        registerLabels.setBounds(80, 26, 166, 19);
        rightPanel_seller.add(registerLabels);
        JLabel firstNameLabels = new JLabel("First name");
        rightPanel_seller.add(firstNameLabels);
        firstNameTextFields = new JTextField();
        rightPanel_seller.add(firstNameTextFields);
        JLabel lastNameLabels = new JLabel("Last name");
        rightPanel_seller.add(lastNameLabels);
        lastNameTextFields = new JTextField();
        rightPanel_seller.add(lastNameTextFields);
        JLabel emailLabels = new JLabel("Email");
        rightPanel_seller.add(emailLabels);
        emailTextFields = new JTextField();
        rightPanel_seller.add(emailTextFields);
        JLabel userids = new JLabel("User_id");
        rightPanel_seller.add(userids);
        user_ids = new JTextField();
        rightPanel_seller.add(user_ids);
        JLabel passwordLabels = new JLabel("Password");
        rightPanel_seller.add(passwordLabels);
        passwordFields = new JPasswordField();
        rightPanel_seller.add(passwordFields);
        JLabel sexs = new JLabel("Sex");
        rightPanel_seller.add(sexs);
        males = new JRadioButton("Male");
        rightPanel_seller.add(males);
        females = new JRadioButton("Female");
        rightPanel_seller.add(females);
        ButtonGroup bgs = new ButtonGroup();
        bgs.add(males);
        bgs.add(females);
        JLabel Ages = new JLabel("Age");
        rightPanel_seller.add(Ages);
        SpinnerModel values = new SpinnerNumberModel(22, 21, 50, 1);
        ages = new JSpinner(values);
        rightPanel_seller.add(ages);
        JLabel userNameLabels = new JLabel("Address");
        rightPanel_seller.add(userNameLabels);
        userNameTextFields = new JTextField();
        rightPanel_seller.add(userNameTextFields);
        JLabel cityLabels = new JLabel("City");
        rightPanel_seller.add(cityLabels);
        cityTextFields = new JTextField();
        rightPanel_seller.add(cityTextFields);
        JButton saveButtons = new JButton("Sign Up");
        saveButtons.addActionListener(this);
        rightPanel_seller.add(saveButtons);
        // //////////////////////// for buyer
        JPanel leftbuyer = new JPanel();
        leftbuyer.setLayout(new GridLayout(12, 5, 1, 10));
        leftbuyer.setPreferredSize(new Dimension(1, 511));
        JButton buyrprofile = new JButton("View POSTs");
        buyrprofile.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton buysearch = new JButton("Search POSTs");
        buysearch.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton buyrprofile3 = new JButton("Appointemnt");
        buyrprofile3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 cl.show(rightcont, "approved");
                  approcheck(user_id_for_post);
                }
                });

        JButton buyrprofile4 = new JButton("Profile");
        JButton buyrprofile5 = new JButton("Logout");
        buyrprofile3.setFont(new Font("System Bold", Font.BOLD, 14));

        progile4.setFont(new Font("System Bold", Font.BOLD, 14));
        buyrprofile3.setFont(new Font("System Bold", Font.BOLD, 14));
        buyrprofile5.setFont(new Font("System Bold", Font.BOLD, 14));
        leftbuyer.add(buyrprofile);
        leftbuyer.add(buysearch);
        leftbuyer.add(buyrprofile3);
        leftbuyer.add(buyrprofile4);
        leftbuyer.add(buyrprofile5);

        leftbuyer.setBackground(Color.black);
        leftcon.add(leftbuyer, "ffff");
        JPanel manageusr = new JPanel();
        JButton seller = new JButton("Seller");
        seller.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retriveruser("Seller");
                cl.show(rightcont, "prosclor");

            }
        });
        seller.setBounds(10, 10, 100, 24);
        manageusr.add(seller);
        JButton buyeer = new JButton("Buyer");
        buyeer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retriverbuyer("Buyer");
                cl.show(rightcont, "prosclor");
                ;
            }
        });
        buyeer.setBounds(120, 10, 100, 24);
        manageusr.add(buyeer);
        JScrollPane scrollPane_manageusr = new JScrollPane(manageusr);
        scrollPane_manageusr.setViewportBorder(new BevelBorder(BevelBorder.LOWERED));
        scrollPane_manageusr.setBounds(230, 10, 200, 200);

        JPanel leftadmin = new JPanel();

        leftadmin.setLayout(new GridLayout(12, 5, 1, 10));
        leftadmin.setPreferredSize(new Dimension(1, 511));
        JButton adminprofile = new JButton("Manage Admins");
        adminprofile.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton adminsearch = new JButton("Manage Users");
        adminsearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(rightcont, "adminuser");
            }
        });
        adminsearch.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton adminprofile1 = new JButton("Manage Properties");
        adminprofile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retriver("all");
                adminview();
                cl.show(rightcont, "viewpro");
            }
        });
        adminprofile1.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton adminprofile3 = new JButton("Edit Profile");
        adminprofile3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myaccadmin(user_id_for_post);
                cl.show(rightcont, "myaccount");
            }
        });
        JButton adminprofile4 = new JButton("Report");
        adminprofile4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retrieveReportsForUser();
                cl.show(rightcont, "prosclor");
            }
        });

        JButton adminprofile5 = new JButton("Logout");
        adminprofile5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPanel.setPreferredSize(new Dimension(851, 511));
                rightPanel.setPreferredSize(new Dimension(471, 481));
                cl.show(northcon, "welecom");
                cl.show(leftcon, "test");
                cl.show(leftcon, "leftpanel");
                cl.show(rightcont, "prolist");
            }
        });

        adminprofile3.setFont(new Font("System Bold", Font.BOLD, 14));

        progile4.setFont(new Font("System Bold", Font.BOLD, 14));
        adminprofile3.setFont(new Font("System Bold", Font.BOLD, 14));
        adminprofile5.setFont(new Font("System Bold", Font.BOLD, 14));
        leftadmin.add(adminprofile);
        leftadmin.add(adminsearch);
        leftadmin.add(adminprofile1);
        leftadmin.add(adminprofile3);
        leftadmin.add(adminprofile4);
        leftadmin.add(adminprofile5);
        leftadmin.setBackground(Color.black);
        leftcon.add(leftadmin, "admin");

        // right panel for agent
        JPanel rightPanel_agent = new JPanel(new GridLayout(23, 18, 0, 10));
        rightPanel_agent.setPreferredSize(new Dimension(471, 481));
        rightPanel_agent.setBackground(Color.LIGHT_GRAY);
        JLabel registerLabela = new JLabel("                   AGENT Register Form");
        registerLabela.setFont(new Font("System BOLD", Font.BOLD, 18));
        registerLabela.setBounds(80, 26, 166, 19);
        rightPanel_agent.add(registerLabela);
        JLabel firstNameLabela = new JLabel("First name");
        rightPanel_agent.add(firstNameLabela);
        firstNameTextFielda = new JTextField();
        rightPanel_agent.add(firstNameTextFielda);
        JLabel lastNameLabela = new JLabel("Last name");
        rightPanel_agent.add(lastNameLabela);
        lastNameTextFielda = new JTextField();
        rightPanel_agent.add(lastNameTextFielda);
        JLabel emailLabela = new JLabel("Email");
        rightPanel_agent.add(emailLabela);
        emailTextFielda = new JTextField();
        rightPanel_agent.add(emailTextFielda);
        JLabel userida = new JLabel("User_ID");
        rightPanel_agent.add(userida);
        user_ida = new JTextField();
        rightPanel_agent.add(user_ida);
        JLabel passwordLabela = new JLabel("Password");
        rightPanel_agent.add(passwordLabela);
        passwordFielda = new JPasswordField();
        rightPanel_agent.add(passwordFielda);
        JLabel sexa = new JLabel("Sex");
        rightPanel_agent.add(sexa);
        malea = new JRadioButton("Male");
        rightPanel_agent.add(malea);
        femalea = new JRadioButton("Female");
        rightPanel_agent.add(femalea);
        ButtonGroup bga = new ButtonGroup();
        bga.add(malea);
        bga.add(females);
        JLabel Agea = new JLabel("Age");
        rightPanel_agent.add(Agea);
        SpinnerModel valuea = new SpinnerNumberModel(22, 21, 50, 1);
        agea = new JSpinner(valuea);
        rightPanel_agent.add(agea);
        JLabel userNameLabela = new JLabel("Address");
        rightPanel_agent.add(userNameLabela);
        userNameTextFielda = new JTextField();
        rightPanel_agent.add(userNameTextFielda);
        JLabel cityLabela = new JLabel("City");
        rightPanel_agent.add(cityLabela);
        cityTextFielda = new JTextField();
        rightPanel_agent.add(cityTextFielda);
        JButton saveButtona = new JButton("Sign Up");
        saveButtona.addActionListener(this);
        rightPanel_agent.add(saveButtona);
        JLabel user_id = new JLabel("user_id");
        JPanel rightPanel2 = new JPanel(new GridLayout(19, 18, 0, 10));
        rightPanel2.add(user_id);
        JTextField user_idtext = new JTextField();
        rightPanel2.add(user_idtext);
        JLabel pass = new JLabel("Password");
        pass.setBounds(44, 137, 72, 16);
        rightPanel2.add(pass);
        JPasswordField passt = new JPasswordField();
        passt.setBounds(123, 133, 200, 24);
        rightPanel2.add(passt);
        JButton login = new JButton("Login");
        login.setBounds(44, 229, 72, 16);
        rightPanel2.add(login);
        login.addActionListener(this);
        JButton login2 = new JButton("Don't you hava account?");
        login2.setBounds(123, 229, 130, 16);
        rightPanel2.add(login2);

        JLabel cr = new JLabel("Create Your Account Today and");
        JLabel cr2 = new JLabel("Start Your Property Journey!");
        JPanel rightregistertype = new JPanel(null);
        cr.setBounds(30, 107, 376, 50);
        cr.setFont(new Font("System Bold", Font.BOLD, 21));
        cr2.setBounds(70, 157, 376, 50);
        cr2.setFont(new Font("System Bold", Font.BOLD, 21));
        rightregistertype.setPreferredSize(new Dimension(471, 481));
        JButton asbuyer = new JButton("AS A Buyer");
        asbuyer.setBounds(160, 307, 166, 50);
        asbuyer.addActionListener(this);
        JButton asseller = new JButton("AS A Seller");
        asseller.setBounds(160, 367, 166, 50);
        asseller.addActionListener(this);
        JButton asagent = new JButton("AS Agent");
        asagent.setBounds(160, 427, 166, 50);
        asagent.addActionListener(this);
        rightregistertype.add(cr);
        rightregistertype.add(cr2);
        rightregistertype.add(asbuyer);
        rightregistertype.add(asseller);
        rightregistertype.add(asagent);
        rightcont.setLayout(cl);

        ////////////////////////////////////////////////////////////
        JPanel contentPanel = new JPanel();

        JLabel trading = new JLabel("                    Trending Houses");
        trading.setFont(new Font("Times New Roman", Font.BOLD, 10));
        trading.setForeground(Color.ORANGE);
        trading.setBackground(Color.BLACK);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        contentPanel.add(trading);
        initializeDatabase();
        try {
            String sql = "SELECT * FROM realpropforseller";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String location = resultSet.getString("location");
                String address = resultSet.getString("address");
                String squareMeter = resultSet.getString("square_meter");
                String condition = resultSet.getString("conditionn");
                String description = resultSet.getString("description");
                int bathrooms = resultSet.getInt("bathrooms");
                int bedrooms = resultSet.getInt("bedrooms");
                String price = resultSet.getString("price");
                byte[] imageBytes = resultSet.getBytes("image");
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(new ByteArrayInputStream(imageBytes)));
                JLabel imageLabel = new JLabel();
                imageLabel.setIcon(imageIcon);
                imageLabel.setPreferredSize(new Dimension(271, 301));
                JLabel titlee = new JLabel("Title:");
                titlee.setFont(new Font("Times New Roman", Font.BOLD, 19));
                titlee.setForeground(Color.BLUE);
                JLabel titlvale = new JLabel("null");
                titlvale.setText(title);
                JLabel dis = new JLabel("Discription:");
                dis.setFont(new Font("Times New Roman", Font.BOLD, 19));
                dis.setForeground(Color.BLUE);
                JLabel disval = new JLabel("null");
                disval.setText(description);
                JLabel cond = new JLabel("Condition:");
                cond.setFont(new Font("System Bold", Font.BOLD, 19));
                cond.setForeground(Color.BLUE);
                JLabel condvalue = new JLabel("null");
                condvalue.setText(condition);
                JLabel loc = new JLabel("Location:");
                loc.setFont(new Font("System Bold", Font.BOLD, 19));
                loc.setForeground(Color.BLUE);
                JLabel locvalue = new JLabel("null");
                locvalue.setText(location);
                JLabel bath = new JLabel("Batherooms:");
                bath.setFont(new Font("System Bold", Font.BOLD, 19));
                bath.setForeground(Color.BLUE);
                JLabel bathvalu = new JLabel("null");
                String bathh = String.valueOf(bathrooms);
                bathvalu.setText(bathh);
                JLabel bed = new JLabel("Bedrooms:");
                bed.setFont(new Font("System Bold", Font.BOLD, 19));
                bed.setForeground(Color.BLUE);
                JLabel bedvalu = new JLabel("null");
                String bedvalue = String.valueOf(bedrooms);
                bedvalu.setText(bedvalue);
                JLabel squarem = new JLabel("Square Meter:");
                squarem.setFont(new Font("System Bold", Font.BOLD, 19));
                squarem.setForeground(Color.BLUE);
                JLabel squvalue = new JLabel("null");
                String squvalu = String.valueOf(squareMeter);
                squvalue.setText(squvalu);
                JLabel Address = new JLabel("Address:");
                Address.setFont(new Font("System Bold", Font.BOLD, 19));
                Address.setForeground(Color.BLUE);
                JLabel addresvalu = new JLabel("null");
                addresvalu.setText(address);
                JLabel pricelabel = new JLabel("Price:");
                pricelabel.setFont(new Font("System Bold", Font.BOLD, 19));
                pricelabel.setForeground(Color.BLUE);
                JLabel pricvalue = new JLabel("null");
                String priceva = String.valueOf(price);
                pricvalue.setText(priceva);
                JButton conntact = new JButton("Contact");
                conntact.setFont(new Font("System Bold", Font.BOLD, 19));
                contentPanel.add(titlee);
                contentPanel.add(titlvale);
                contentPanel.add(imageLabel);
                contentPanel.add(dis);
                contentPanel.add(disval);
                contentPanel.add(cond);
                contentPanel.add(condvalue);
                contentPanel.add(loc);
                contentPanel.add(locvalue);
                contentPanel.add(bath);
                contentPanel.add(bathvalu);
                contentPanel.add(bed);
                contentPanel.add(bedvalu);
                contentPanel.add(squarem);
                contentPanel.add(squvalue);
                contentPanel.add(Address);
                contentPanel.add(addresvalu);
                contentPanel.add(pricelabel);
                contentPanel.add(pricvalue);
                contentPanel.add(conntact);

                conntact.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == conntact) {
                            JOptionPane.showMessageDialog(rightcont, "Please Login First");
                        }
                    }
                });

                JLabel finish = new JLabel("\n ----------------------------------------------\n");
                contentPanel.add(finish);

            }

            resultSet.close();
            statement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rightcont, "Error: Failed to retrieve properties.");
        }
        JPanel chattsys = new JPanel(new GridLayout(3, 3, 3, 3));

        chattsys.add(getTextPanel());
        chattsys.add(getInputPanel());
        chattsys.add(getUsersPanel());
        JPanel addadmin = new JPanel();
        addadmin.setLayout(new GridLayout(19, 2, 10, 10));

        // Add input fields for admin attributes
        addadmin.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        addadmin.add(firstNameField);

        addadmin.add(new JLabel("Last Name:"));
        JTextField lastNameField = new JTextField();
        addadmin.add(lastNameField);

        addadmin.add(new JLabel("Username:"));
        JTextField emailField = new JTextField();
        addadmin.add(emailField);

        addadmin.add(new JLabel("Email:"));
        JTextField addressField = new JTextField();
        addadmin.add(addressField);

        addadmin.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        addadmin.add(passwordField);

        // Add button to perform the add operation
        JButton addButton = new JButton("Add Admin");
        addButton.addActionListener(e -> addAdmin(firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText(),
                addressField.getText(),
                new String(passwordField.getPassword())));
        addadmin.add(addButton);

        JPanel search = new JPanel(new GridLayout(22, 3, 3, 3));
        JLabel searchby = new JLabel("Search By Location Or by Price Under");
        searchby.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        searcfiled = new JTextField();
        JButton searchh = new JButton("Search");

        JPanel manageadmin = new JPanel();
        JButton addadminn = new JButton("Add Admin");
        addadminn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(rightcont, "addadmin");
            }
        });
        addadminn.setBounds(10, 10, 100, 24);

        manageadmin.add(addadminn);
        JButton removeadmin = new JButton("Remove Admin");
        removeadmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retriveradmin();
                cl.show(rightcont, "prosclor");
            }
        });
        removeadmin.setBounds(120, 10, 100, 24);
        manageadmin.add(removeadmin);
        JScrollPane scrollPane_manageadmins = new JScrollPane();
        scrollPane_manageadmins.setViewportBorder(new BevelBorder(BevelBorder.LOWERED));
        scrollPane_manageadmins.setBounds(230, 10, 200, 200);
        searchh.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        search.add(searchby);
        search.add(searcfiled);
        search.add(searchh);
        rightcont.add(scrollPane, "prolist");
        rigJPanel3.setLayout(new BoxLayout(rigJPanel3, BoxLayout.Y_AXIS));
        rigJPanel3.add(trading);
        JScrollPane chatss = new JScrollPane(rigJPanel3);
        rightcont.add(rightregistertype, "rtype");
        rightcont.add(rightPanel, "1");
        rightcont.add(rightPanel2, "2");
        rightcont.add(rightPanel_seller, "seller");
        rightcont.add(rightPanel_agent, "agent");
        rightcont.add(proupscrol, "prosclor");
        rightcont.add(search, "search");
        rightcont.add(chatss, "3");
        rightcont.add(myaccount, "myaccount");
        rightcont.add(manageadmin, "manageadmin");
        rightcont.add(chattsys, "chatsystem");
        rightcont.add(scrollPane_manageusr, "adminuser");
        rightcont.add(addadmin, "addadmin");
        rightcont.add(apos, "appo");
        rightcont.add(aprvd, "approved");
        registerButton.addActionListener(this);
        saveButton.addActionListener(this);
        mainPanel.add(rightcont, BorderLayout.EAST);
        getContentPane().add(mainPanel);

        rightcont.add(proform, "proform");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == registerButton) {

                    cl.show(rightcont, "rtype");
                }
            }

        });
        progile4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myacc(user_id_for_post);
                cl.show(rightcont, "myaccount");

            }
        });
        searchh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String value = searcfiled.getText();
                searchbyloction(value);
                cl.show(rightcont, "prosclor");

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == saveButton) {

                    insertDataIntoDatabase();
                }
            }
        });
        saveButtons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == saveButtons) {

                    insertDataIntoDatabases();
                }
            }
        });
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == postButton) {

                    insertProperty(user_id_for_post);
                }
            }

        });
        saveButtona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == saveButtona) {

                    insertDataIntoDatabasea();
                }
            }
        });
        uploadproperties();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginButton) {

                    cl.show(rightcont, "2");
                }
            }
        });
        login2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == login2) {
                    cl.show(rightcont, "1");
                }
            }
        });
        asseller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == asseller) {
                    cl.show(rightcont, "seller");
                }
            }
        });
        asbuyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == asbuyer) {
                    cl.show(rightcont, "1");
                }
            }
        });
        asagent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == asagent) {
                    cl.show(rightcont, "agent");
                }
            }
        });

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == chooseButton) {
                    image_uploder();
                }
            }
        });
        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatts(user_id_for_post);
                cl.show(rightcont, "proform");

            }
        });
        profile1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatts(user_id_for_post);

                cl.show(rightcont, "3");
            }
        });
        // leftcon leftPanel right prolist nort welecom
        profile2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));

                proupdate.revalidate();
                proupdate.repaint();
                retriver(user_id_for_post);
                cl.show(rightcont, "prosclor");
            }
        });

        retriver(user_id_for_post);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == login) {
                    user_id_for_post = user_idtext.getText();
                    String password = new String(passt.getPassword());
                    if (verifyLogin(user_id_for_post, password)) {
                        leftPanel.setPreferredSize(new Dimension(151, 511));
                        rightPanel.setPreferredSize(new Dimension(1175, 481));
                        retriver(user_id_for_post);
                        // insertProperty(username);
                        cl.show(northcon, "welforbuyer");
                        cl.show(leftcon, "ffff");
                        cl.show(rightcont, "3");
                         cl.show(rightcont, "prosclor");

                    } else if (verifyLogins(user_id_for_post, password)) {
                        leftPanel.setPreferredSize(new Dimension(151, 511));
                        rightPanel.setPreferredSize(new Dimension(1175, 481));
                        // retriver(password);
                        chatts(user_id_for_post);

                        cl.show(northcon, "weleback");
                        cl.show(leftcon, "centerpanel");

                        cl.show(rightcont, "3");
                        // Perform actions after successful login
                    } else if (verifyLogina(user_id_for_post, password)) {
                        leftPanel.setPreferredSize(new Dimension(151, 511));
                        rightPanel.setPreferredSize(new Dimension(1175, 481));
                        // insertProperty(user_id_for_post);
                        cl.show(northcon, "weleback");
                        cl.show(leftcon, "centerpanel");
                        cl.show(rightcont, "3");
                        // Perform actions after successful login
                    } else if (verifyLoginadmin(user_id_for_post, password)) {
                        leftPanel.setPreferredSize(new Dimension(161, 511));
                        rightPanel.setPreferredSize(new Dimension(1160, 481));
                        retriver(user_id_for_post);
                        // insertProperty(username);
                        cl.show(northcon, "weladmin");
                        cl.show(leftcon, "admin");
                        cl.show(rightcont, "3");
                        // Perform actions after successful login
                    } else {

                        JOptionPane.showMessageDialog(leftPanel, "Invalid Username or Password", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        profile5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftPanel.setPreferredSize(new Dimension(851, 511));
                rightPanel.setPreferredSize(new Dimension(471, 481));
                cl.show(northcon, "welecom");
                cl.show(leftcon, "test");
                cl.show(leftcon, "leftpanel");
                cl.show(rightcont, "prolist");

            }
        });
        buyrprofile5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftPanel.setPreferredSize(new Dimension(851, 511));
                rightPanel.setPreferredSize(new Dimension(471, 481));
                cl.show(northcon, "welecom");
                cl.show(leftcon, "test");
                cl.show(leftcon, "leftpanel");
                cl.show(rightcont, "prolist");

            }
        });
        adminprofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(rightcont, "manageadmin");
            }
        });
        buyrprofile4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(rightcont, "myaccount2");
                myaccbuyer(user_id_for_post);
                cl.show(rightcont, "myaccount");

            }
        });

        buyrprofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retriverforbuyer();
                cl.show(rightcont, "search");
                cl.show(rightcont, "prosclor");

            }
        });
        buysearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retriverforbuyer();
                cl.show(rightcont, "search");
            }
        });
        initializeDatabase();
    }

    private boolean verifyLogin(String user_id, String password) {
        try {
            String sql = "SELECT * FROM realbuyer WHERE user_id = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // If a record is found, login is successful
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Failed to verify login.");
            return false;
        }
    }

    private void image_uploder() {

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            chooseButton.setText("File Selected ");
        } else {
            chooseButton.setText("No File Selected");
        }
    }

    private boolean verifyLogins(String user_id, String password) {
        try {
            String sql = "SELECT * FROM realseller WHERE user_id = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If a record is found, login is successful
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Failed to verify login.");
            return false;
        }
    }

    private void uploadproperties() {
        JLabel titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        titleLabel.setBounds(38, 97, 85, 16);
        JLabel imageLabel = new JLabel("Select an image");
        imageLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        imageLabel.setBounds(38, 135, 175, 21);
        JLabel locationLabel = new JLabel("Property location");
        locationLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        locationLabel.setBounds(38, 172, 175, 21);
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        addressLabel.setBounds(42, 209, 91, 21);
        JLabel squareMeterLabel = new JLabel("Square meter");
        squareMeterLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        squareMeterLabel.setBounds(38, 284, 145, 21);
        JLabel conditionLabel = new JLabel("Condition");
        conditionLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        conditionLabel.setBounds(38, 248, 107, 21);
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        descriptionLabel.setBounds(50, 373, 121, 21);
        JLabel bathroomsLabel = new JLabel("Bathrooms");
        bathroomsLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        bathroomsLabel.setBounds(441, 97, 121, 16);
        JLabel bedroomsLabel = new JLabel("Bedrooms");
        bedroomsLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        bedroomsLabel.setBounds(441, 135, 121, 16);
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        priceLabel.setBounds(441, 172, 121, 16);
        priceTextField = new JTextField();
        priceTextField.setBounds(603, 171, 78, 24);
        squareMeterTextField = new JTextField();
        squareMeterTextField.setBounds(219, 283, 107, 24);
        descriptionTextArea = new JTextArea(4, 1);
        descriptionTextArea.setPreferredSize(new Dimension(10, 60));
        descriptionTextArea.setLineWrap(false);
        descriptionTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        descriptionTextArea.setBounds(215, 349, 308, 91);
        String[] location = { "Addis Ababa",
                "Dire Dawa",
                "Gondar",
                "Bahir Dar",
                "Mekelle",
                "Jimma",
                "Hawassa",
                "Arba Minch", "Harar", "Awasa", "Dessie", "Adama", "Hosaena", "Nekemte", "Shashamane", "Jijiga",
                "Debre Markos", "Dila", "Gambela", "Asosa" };
        String[] condition = { "New", "Old", "Fairly used" };
        locationComboBox = new JComboBox<>(location);
        locationComboBox.setBounds(219, 171, 150, 24);
        addressComboBox = new JComboBox<>(location);
        addressComboBox.setBounds(219, 208, 150, 24);
        conditionComboBox = new JComboBox<>(condition);
        conditionComboBox.setBounds(219, 247, 150, 24);
        chooseButton = new JButton("Choose File");
        chooseButton.setBounds(219, 134, 150, 24);
        chooseButton.addActionListener(this);
        bathroomsSpinner = new JSpinner();
        bathroomsSpinner.setBounds(603, 96, 78, 24);
        bedroomsSpinner = new JSpinner();
        bedroomsSpinner.setBounds(603, 134, 78, 24);
        titleTextField = new JTextField();
        titleTextField.setBounds(219, 96, 150, 24);

        postButton.setFont(new Font("Arial", Font.BOLD, 13));
        postButton.setBounds(566, 439, 107, 24);

        proform.setPreferredSize(new Dimension(81, 481));
        proform.setBackground(Color.LIGHT_GRAY);
        proform.setLayout(null);
        proform.add(titleLabel);
        proform.add(imageLabel);
        proform.add(locationLabel);
        proform.add(addressLabel);
        proform.add(squareMeterLabel);
        proform.add(conditionLabel);
        proform.add(descriptionLabel);
        proform.add(bathroomsLabel);
        proform.add(bedroomsLabel);
        proform.add(priceLabel);
        proform.add(priceTextField);
        proform.add(squareMeterTextField);
        proform.add(descriptionTextArea);
        proform.add(locationComboBox);
        proform.add(addressComboBox);
        proform.add(conditionComboBox);
        proform.add(chooseButton);
        proform.add(bathroomsSpinner);
        proform.add(bedroomsSpinner);
        proform.add(titleTextField);
        proform.add(postButton);
    }

    private boolean verifyLogina(String user_id, String password) {
        try {
            String sql = "SELECT * FROM realagent WHERE user_id = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // If a record is found, login is successful
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Failed to verify login.");
            return false;
        }
    }

    private boolean verifyLoginadmin(String user_id, String password) {
        try {
            String sql = "SELECT * FROM Admins WHERE Username = ? AND Password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If a record is found, login is successful
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Failed to verify login.");
            return false;
        }
    }

    private void insertDataIntoDatabases() {
        String user_id = user_ids.getText();
        String firstnames = firstNameTextFields.getText();
        String lastNames = lastNameTextFields.getText();
        String emaildatas = emailTextFields.getText();
        String address = userNameTextFields.getText();
        String citydatas = cityTextFields.getText();
        String passwordTexts = new String(passwordFields.getPassword());
        String genders = males.isSelected() ? "Male" : "Female";
        int ageValues = (int) ages.getValue();
        try {
            String sqls = "INSERT INTO realseller (user_id,first_name, last_name, email, address, city, password, gender, age) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatements = conn.prepareStatement(sqls);
            int datas = preparedStatements.getMaxRows();
            if (firstnames.length() == 0 || lastNames.length() == 0 || user_id.length() == 0 | emaildatas.length() == 0
                    || address.length() == 0
                    || citydatas.length() == 0 || passwordTexts.length() == 0 || genders.length() == 0
                    || ageValues < 7) {
                JOptionPane.showMessageDialog(this, "Please fill the form.");
            } else {
                preparedStatements.setString(1, user_id);
                preparedStatements.setString(2, firstnames);
                preparedStatements.setString(3, lastNames);
                preparedStatements.setString(4, emaildatas);
                preparedStatements.setString(5, address);
                preparedStatements.setString(6, citydatas);
                preparedStatements.setString(7, passwordTexts);
                preparedStatements.setString(8, genders);
                preparedStatements.setInt(9, ageValues);
                JOptionPane.showMessageDialog(this, "WELCOME:  " + firstnames);
            }
            int rowsInserted = preparedStatements.executeUpdate();// CHECK THE EXECUTION IF THE VALUE IS GRETER 0
            if (rowsInserted > datas) {
                JOptionPane.showMessageDialog(this, "User registered successfully.");
                user_ids.setText("");
                firstNameTextFields.setText(""); // Clear text fields after successful registration
                lastNameTextFields.setText("");
                passwordFields.setText("");
                emailTextFields.setText("");
                cityTextFields.setText("");
                userNameTextFields.setText("");
                males.setSelected(false);
                females.setSelected(false);
                ages.setValue(0);

            } else {
                JOptionPane.showMessageDialog(this, "Registration failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Registration failed.");
        }
    }

    private void insertDataIntoDatabasea() {
        String user_id = user_ida.getText();
        String firstnamea = firstNameTextFielda.getText();
        String lastNamea = lastNameTextFielda.getText();
        String emaildataa = emailTextFielda.getText();
        String addresa = userNameTextFielda.getText();
        String citydataa = cityTextFielda.getText();
        String passwordTexta = new String(passwordFielda.getPassword());
        String gendera = malea.isSelected() ? "Male" : "Female";
        int ageValuea = (int) agea.getValue();
        try {
            String sqla = "INSERT INTO realagent (user_id,first_name, last_name, email, address, city, password, gender, age) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementa = conn.prepareStatement(sqla);
            int dataa = preparedStatementa.getMaxRows();
            if (firstnamea.length() == 0 || lastNamea.length() == 0 || user_id.length() == 0 | emaildataa.length() == 0
                    || addresa.length() == 0
                    || citydataa.length() == 0 || passwordTexta.length() == 0 || gendera.length() == 0
                    || ageValuea < 7) {
                JOptionPane.showMessageDialog(this, "Please  fill the form.");
            } else {
                preparedStatementa.setString(1, user_id);
                preparedStatementa.setString(2, firstnamea);
                preparedStatementa.setString(3, lastNamea);
                preparedStatementa.setString(4, emaildataa);
                preparedStatementa.setString(5, addresa);
                preparedStatementa.setString(6, citydataa);
                preparedStatementa.setString(7, passwordTexta);
                preparedStatementa.setString(8, gendera);
                preparedStatementa.setInt(9, ageValuea);
                JOptionPane.showMessageDialog(this, "WELCOME:  " + firstnamea);
            }
            int rowsInserted = preparedStatementa.executeUpdate();// CHECK THE EXECUTION IF THE VALUE IS GRETER 0

            if (rowsInserted > dataa) {
                JOptionPane.showMessageDialog(this, "User registered successfully.");
                user_ida.setText("");
                firstNameTextFielda.setText(""); // Clear text fields after successful registration
                lastNameTextFielda.setText("");
                passwordFielda.setText("");
                emailTextFielda.setText("");
                cityTextFielda.setText("");
                userNameTextFielda.setText("");
                malea.setSelected(false);
                femalea.setSelected(false);
                agea.setValue(0);
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Registration failed.");
        }
    }

    private void insertDataIntoDatabase() {
        String user_id = user_idb.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String emaildata = emailTextField.getText();
        String addre = userNameTextField.getText();
        String citydata = cityTextField.getText();
        String passwordText = new String(passwordField.getPassword());
        String gender = male.isSelected() ? "Male" : "Female";
        int ageValue = (int) age.getValue();
        try {
            String sql = "INSERT INTO realbuyer (user_id,first_name, last_name, email, address, city, password, gender, age) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            int data = preparedStatement.getMaxRows();
            if (firstName.length() == 0 || lastName.length() == 0 || user_id.length() == 0 | emaildata.length() == 0
                    || addre.length() == 0
                    || citydata.length() == 0 || passwordText.length() == 0 || gender.length() == 0 || ageValue < 7) {
                JOptionPane.showMessageDialog(this, "Please fill the form.");
            } else {
                preparedStatement.setString(1, user_id);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, emaildata);
                preparedStatement.setString(5, addre);
                preparedStatement.setString(6, citydata);
                preparedStatement.setString(7, passwordText);
                preparedStatement.setString(8, gender);
                preparedStatement.setInt(9, ageValue);
                JOptionPane.showMessageDialog(this, "WELCOME:  " + firstName);
            }
            int rowsInserted = preparedStatement.executeUpdate();// CHECK THE EXECUTION IF THE VALUE IS GRETER 0
            if (rowsInserted > data) {
                JOptionPane.showMessageDialog(this, "User registered successfully.");
                user_idb.setText("");
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                passwordField.setText("");
                emailTextField.setText("");
                cityTextField.setText("");
                userNameTextField.setText("");
                male.setSelected(false);
                female.setSelected(false);
                age.setValue(0);
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Registration failed.");
        }
    }

    private void chatts(String usr) {
        initializeDatabase();
        try {
            int sms = 0;
            String sql = "SELECT * FROM chatt WHERE userid = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usr);
            ResultSet resultSet = preparedStatement.executeQuery();
            rigJPanel3.removeAll();
            while (resultSet.next()) {
                String from = resultSet.getString("fromuser");
                String recivedmsg = resultSet.getString("recivedmessage");
                String proporty = resultSet.getString("property_title");
                JLabel fromb = new JLabel("From:");
                fromb.setFont(new Font("Times New Roman", Font.BOLD, 19));
                fromb.setForeground(Color.BLUE);
                JLabel fromvalue = new JLabel("null");
                fromvalue.setText(from);
                JLabel recivedmsgJLabel = new JLabel("Recived Massage:");
                recivedmsgJLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
                recivedmsgJLabel.setForeground(Color.BLUE);
                JLabel recivedmsgvalue = new JLabel("null");
                recivedmsgvalue.setText(recivedmsg);
                JLabel prot = new JLabel("On Property title");
                prot.setFont(new Font("Times New Roman", Font.BOLD, 19));
                prot.setForeground(Color.BLUE);
                JLabel proptitle = new JLabel("null");
                proptitle.setText(proporty);
                JButton conntact = new JButton("Contact");
                conntact.setFont(new Font("System Bold", Font.BOLD, 19));
                rigJPanel3.add(fromb);
                rigJPanel3.add(fromvalue);
                rigJPanel3.add(recivedmsgJLabel);
                rigJPanel3.add(recivedmsgvalue);
                rigJPanel3.add(prot);
                rigJPanel3.add(proptitle);

                rigJPanel3.add(conntact);
                sms++;
                conntact.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String name = user_id_for_post;
                        try {
                            initchat(name);
                            cl.show(rightcont, "chatsystem");
                        } catch (RemoteException e1) {
                            e1.printStackTrace();
                        }

                    }
                });
                JLabel finish = new JLabel("\n ----------------------------------------------\n");
                rigJPanel3.add(finish);

            }
            profile1.setText("Message:(" + sms + ")");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rightcont, "Error: Failed to retrieve messages.");
        }
    }

     public void Appointemnt(String usr) {
        try {
            String sql = "SELECT * FROM appointments WHERE user_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usr);
            ResultSet resultSet = preparedStatement.executeQuery();
            appoint.removeAll();

            while (resultSet.next()) {
                int appointmentId = resultSet.getInt("appointment_id");
                String appointmentDate = resultSet.getString("appointment_date");
                String appointmentTime = resultSet.getString("appointment_time");
                String additionalNotes = resultSet.getString("additional_notes");
                String propertyTitle = resultSet.getString("property_title");
                String propertyPrice = resultSet.getString("property_price");
                String fromUser = resultSet.getString("from_user");

                // Create a JPanel for each appointment
                JPanel appointmentPanel = new JPanel(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                gbc.gridy = 0;

                // Add labels and values to appointmentPanel
                addLabelToPanel(appointmentPanel, gbc, "Appointment ID:", String.valueOf(appointmentId));
                addLabelToPanel(appointmentPanel, gbc, "Appointment Date:", appointmentDate);
                addLabelToPanel(appointmentPanel, gbc, "Appointment Time:", appointmentTime);
                addLabelToPanel(appointmentPanel, gbc, "Additional Notes:", additionalNotes);
                addLabelToPanel(appointmentPanel, gbc, "Property Title:", propertyTitle);
                addLabelToPanel(appointmentPanel, gbc, "Property Price:", propertyPrice);
                addLabelToPanel(appointmentPanel, gbc, "From User:", fromUser);

                JButton contactButton = new JButton("Contact");
                contactButton.setVisible(false);
                contactButton.setFont(new Font("System Bold", Font.BOLD, 19));
                gbc.gridy++;
                appointmentPanel.add(contactButton, gbc);
                JButton approved = new JButton("APPROVE TO CONTACT");
                approved.setBackground(Color.GREEN);
                approved.setForeground(Color.WHITE);
                approved.setFont(new Font("System Bold", Font.BOLD, 20));
                gbc.gridy++;
                appointmentPanel.add(approved, gbc);
                approved.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       contactButton.setVisible(true);
                       approved.setVisible(false);
                        // Assuming you have title and price variables available
                        String title = propertyTitle;
                        String  price = propertyPrice;  
                        String sql3 = "INSERT INTO approved (title, price,to_user) VALUES (?,?,?)";
                        try {
                            PreparedStatement statement = conn.prepareStatement(sql3);
                            statement.setString(1, title);
                            statement.setString(2, price);
                            statement.setString(3, fromUser);
                            statement.executeUpdate();
                
                            JOptionPane.showMessageDialog(rightcont, "Property approved.");
                
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(rightcont, "ERROR: Failed to approve property.");
                        }
                    }
                });
                

                contactButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cl.show(rightcont, "chatsystem");
                        try {
                            initchat(user_id_for_post);
                        } catch (RemoteException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

                // Add appointmentPanel to appoint
                appoint.add(appointmentPanel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rightcont, "Error: Failed to retrieve Appointments.");
        }
    }
    public void approcheck(String usr) {
        try {
            String sql = "SELECT * FROM approved WHERE to_user = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usr);
            ResultSet resultSet = preparedStatement.executeQuery();
            appro.removeAll();
    
            while (resultSet.next()) {
                JPanel appointmentPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                JLabel app = new JLabel("YOU APPOINTEMNT IS APPROVED");
                app.setFont(new Font("System Bold", Font.BOLD, 19));
                appointmentPanel.add(app, gbc);
                String appointmentTitle = getStringOrNull(resultSet, "title");
                String appointmentPrice = getStringOrNull(resultSet, "price");
                String toUser = getStringOrNull(resultSet, "to_user");
    
                
                
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                gbc.gridy = 0;
                
                gbc.gridx++;

    
                addLabelToPanel(appointmentPanel, gbc, " Appointment Title:", appointmentTitle);
                addLabelToPanel(appointmentPanel, gbc, "Appointment Price:", appointmentPrice);
                addLabelToPanel(appointmentPanel, gbc, "To User:", toUser);
    
                JButton contactButton = new JButton("Chat NOW");

            contactButton.setFont(new Font("System Bold", Font.BOLD, 19));
                gbc.gridy++;
                appointmentPanel.add(contactButton, gbc);
    
                contactButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cl.show(rightcont, "chatsystem");
                        try {
                            initchat(user_id_for_post);
                        } catch (RemoteException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
    
                // Add appointmentPanel to appro
                appro.add(appointmentPanel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rightcont, "Error: Failed to retrieve Approved Appointments.");
        }
    }
    
    private String getStringOrNull(ResultSet resultSet, String columnName) {
        try {
            String value = resultSet.getString(columnName);
            return resultSet.wasNull() ? null : value;
        } catch (SQLException e) {
            // Handle the exception as needed
            return null;
        }
    }
    public void adminview() {
        JPanel contentPanel = new JPanel();

        JLabel trading = new JLabel(" ");
        trading.setFont(new Font("Times New Roman", Font.BOLD, 10));
        trading.setForeground(Color.ORANGE);
        trading.setBackground(Color.BLACK);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane2 = new JScrollPane(contentPanel);
        rightcont.add(scrollPane2, "viewpro");
        contentPanel.add(trading);
        initializeDatabase();
        try {
            String sql = "SELECT * FROM realpropforseller";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String location = resultSet.getString("location");
                String address = resultSet.getString("address");
                String squareMeter = resultSet.getString("square_meter");
                String condition = resultSet.getString("conditionn");
                String description = resultSet.getString("description");
                int bathrooms = resultSet.getInt("bathrooms");
                int bedrooms = resultSet.getInt("bedrooms");
                String price = resultSet.getString("price");
                byte[] imageBytes = resultSet.getBytes("image");
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(new ByteArrayInputStream(imageBytes)));
                JLabel imageLabel = new JLabel();
                imageLabel.setIcon(imageIcon);
                imageLabel.setPreferredSize(new Dimension(271, 301));
                JLabel titlee = new JLabel("Title:");
                titlee.setFont(new Font("Times New Roman", Font.BOLD, 19));
                titlee.setForeground(Color.BLUE);
                JLabel titlvale = new JLabel("null");
                titlvale.setText(title);
                JLabel dis = new JLabel("Discription:");
                dis.setFont(new Font("Times New Roman", Font.BOLD, 19));
                dis.setForeground(Color.BLUE);
                JLabel disval = new JLabel("null");
                disval.setText(description);
                JLabel cond = new JLabel("Condition:");
                cond.setFont(new Font("System Bold", Font.BOLD, 19));
                cond.setForeground(Color.BLUE);
                JLabel condvalue = new JLabel("null");
                condvalue.setText(condition);
                JLabel loc = new JLabel("Location:");
                loc.setFont(new Font("System Bold", Font.BOLD, 19));
                loc.setForeground(Color.BLUE);
                JLabel locvalue = new JLabel("null");
                locvalue.setText(location);
                JLabel bath = new JLabel("Batherooms:");
                bath.setFont(new Font("System Bold", Font.BOLD, 19));
                bath.setForeground(Color.BLUE);
                JLabel bathvalu = new JLabel("null");
                String bathh = String.valueOf(bathrooms);
                bathvalu.setText(bathh);
                JLabel bed = new JLabel("Bedrooms:");
                bed.setFont(new Font("System Bold", Font.BOLD, 19));
                bed.setForeground(Color.BLUE);
                JLabel bedvalu = new JLabel("null");
                String bedvalue = String.valueOf(bedrooms);
                bedvalu.setText(bedvalue);
                JLabel squarem = new JLabel("Square Meter:");
                squarem.setFont(new Font("System Bold", Font.BOLD, 19));
                squarem.setForeground(Color.BLUE);
                JLabel squvalue = new JLabel("null");
                String squvalu = String.valueOf(squareMeter);
                squvalue.setText(squvalu);
                JLabel Address = new JLabel("Address:");
                Address.setFont(new Font("System Bold", Font.BOLD, 19));
                Address.setForeground(Color.BLUE);
                JLabel addresvalu = new JLabel("null");
                addresvalu.setText(address);
                JLabel pricelabel = new JLabel("Price:");
                pricelabel.setFont(new Font("System Bold", Font.BOLD, 19));
                pricelabel.setForeground(Color.BLUE);
                JLabel pricvalue = new JLabel("null");
                String priceva = String.valueOf(price);
                pricvalue.setText(priceva);
                JButton conntact = new JButton("Contact");
                conntact.setFont(new Font("System Bold", Font.BOLD, 19));
                contentPanel.add(titlee);
                contentPanel.add(titlvale);
                contentPanel.add(imageLabel);
                contentPanel.add(dis);
                contentPanel.add(disval);
                contentPanel.add(cond);
                contentPanel.add(condvalue);
                contentPanel.add(loc);
                contentPanel.add(locvalue);
                contentPanel.add(bath);
                contentPanel.add(bathvalu);
                contentPanel.add(bed);
                contentPanel.add(bedvalu);
                contentPanel.add(squarem);
                contentPanel.add(squvalue);
                contentPanel.add(Address);
                contentPanel.add(addresvalu);
                contentPanel.add(pricelabel);
                contentPanel.add(pricvalue);

                JButton Delete = new JButton("Delete");
                Delete.setFont(new Font("System Bold", Font.BOLD, 19));
                Delete.setBounds(885, 83, 125, 26);
                contentPanel.add(Delete);
                Delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int confirmation = JOptionPane.showConfirmDialog(imageLabel,
                                "Just Think you ARE gonna Delete Title: " + title);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            deleterow(title);
                            retriver(title);
                        }

                    }
                });

                JLabel finish = new JLabel("\n ----------------------------------------------\n");
                contentPanel.add(finish);

            }

            resultSet.close();
            statement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rightcont, "Error: Failed to retrieve properties.");
        }
    }

    private void retriver(String pass) {
        proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));
        initializeDatabase();
        try {
            String sql2 = "SELECT * FROM realpropforseller WHERE user_id='" + pass + "'";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            proupdate.removeAll();
            while (resultSet2.next()) {
                String user_id = resultSet2.getString("user_id");
                String title = resultSet2.getString("title");
                String location = resultSet2.getString("location");
                String address = resultSet2.getString("address");
                String squareMeter = resultSet2.getString("square_meter");
                String condition = resultSet2.getString("conditionn");
                String description = resultSet2.getString("description");
                int bathrooms = resultSet2.getInt("bathrooms");
                int bedrooms = resultSet2.getInt("bedrooms");
                String price = resultSet2.getString("price");
                byte[] imageBytes = resultSet2.getBytes("image");
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(new ByteArrayInputStream(imageBytes)));
                JLabel imageLabel = new JLabel();
                imageLabel.setIcon(imageIcon);
                imageLabel.setPreferredSize(new Dimension(271, 301));
                JLabel titlee = new JLabel("Title:");
                titlee.setFont(new Font("Times New Roman", Font.BOLD, 19));
                titlee.setForeground(Color.BLUE);
                JLabel titlvale = new JLabel("null");
                titlvale.setText(title);
                JLabel dis = new JLabel("Discription:");
                dis.setFont(new Font("Times New Roman", Font.BOLD, 19));
                dis.setForeground(Color.BLUE);
                JLabel disval = new JLabel("null");
                disval.setText(description);
                JLabel cond = new JLabel("Condition:");
                cond.setFont(new Font("System Bold", Font.BOLD, 19));
                cond.setForeground(Color.BLUE);
                JLabel condvalue = new JLabel("null");
                condvalue.setText(condition);
                JLabel loc = new JLabel("Location:");
                loc.setFont(new Font("System Bold", Font.BOLD, 19));
                loc.setForeground(Color.BLUE);
                JLabel locvalue = new JLabel("null");
                locvalue.setText(location);
                JLabel bath = new JLabel("Batherooms:");
                bath.setFont(new Font("System Bold", Font.BOLD, 19));
                bath.setForeground(Color.BLUE);
                JLabel bathvalu = new JLabel("null");
                String bathh = String.valueOf(bathrooms);
                bathvalu.setText(bathh);
                JLabel bed = new JLabel("Bedrooms:");
                bed.setFont(new Font("System Bold", Font.BOLD, 19));
                bed.setForeground(Color.BLUE);
                JLabel bedvalu = new JLabel("null");
                String bedvalue = String.valueOf(bedrooms);
                bedvalu.setText(bedvalue);
                JLabel squarem = new JLabel("Square Meter:");
                squarem.setFont(new Font("System Bold", Font.BOLD, 19));
                squarem.setForeground(Color.BLUE);
                JLabel squvalue = new JLabel("null");
                String squvalu = String.valueOf(squareMeter);
                squvalue.setText(squvalu);
                JLabel Address = new JLabel("Address:");
                Address.setFont(new Font("System Bold", Font.BOLD, 19));
                Address.setForeground(Color.BLUE);
                JLabel addresvalu = new JLabel("null");
                addresvalu.setText(address);
                JLabel pricelabel = new JLabel("Price:");
                pricelabel.setFont(new Font("System Bold", Font.BOLD, 19));
                pricelabel.setForeground(Color.BLUE);
                JLabel pricvalue = new JLabel("null");
                String priceva = String.valueOf(price);
                pricvalue.setText(priceva);
                proupdate.add(titlee);
                proupdate.add(titlvale);
                proupdate.add(imageLabel);
                proupdate.add(dis);
                proupdate.add(disval);
                proupdate.add(cond);
                proupdate.add(condvalue);
                proupdate.add(loc);
                proupdate.add(locvalue);
                proupdate.add(bath);
                proupdate.add(bathvalu);
                proupdate.add(bed);
                proupdate.add(bedvalu);
                proupdate.add(squarem);
                proupdate.add(squvalue);
                proupdate.add(Address);
                proupdate.add(addresvalu);
                proupdate.add(pricelabel);
                proupdate.add(pricvalue);
                updateButton = new JButton("Update");
                updateButton.setFont(new Font("System Bold", Font.BOLD, 19));
                updateButton.setBounds(455, 83, 108, 26);
                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        uploadpropertiess upc = new uploadpropertiess();
                        upc.value(title);
                        retriver(title);
                    }
                });
                proupdate.add(updateButton);
                JButton Delete = new JButton("Delete");
                Delete.setFont(new Font("System Bold", Font.BOLD, 19));
                Delete.setBounds(885, 83, 125, 26);
                proupdate.add(Delete);
                Delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int confirmation = JOptionPane.showConfirmDialog(imageLabel,
                                "Just Think you ARE gonna Delete Title: " + title);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            deleterow(title);
                            retriver(title);
                        }

                    }
                });
                JButton sold = new JButton("SOLD");
                sold.setFont(new Font("System Bold", Font.BOLD, 19));
                sold.setBounds(885, 83, 125, 26);
                proupdate.add(sold);
                sold.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addReport(user_id, title, price, address);
                        deleterow(title);
                    }
                });

            }
            resultSet2.close();
            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve for  update properties.");
        }
    }

    private void retrieveReportsForUser() {
        proupdate.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // Adjust spacing as needed
        initializeDatabase();

        try {
            String sql = "SELECT * FROM report";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    proupdate.removeAll();

                    while (resultSet.next()) {
                        int reportId = resultSet.getInt("id");
                        String userName = resultSet.getString("user_id");
                        String title = resultSet.getString("title");
                        String price = resultSet.getString("price");
                        String address = resultSet.getString("address");

                        // Create a JPanel for each report's information
                        JPanel reportPanel = new JPanel(new GridBagLayout());
                        reportPanel.setBorder(BorderFactory.createTitledBorder("SOLD"));

                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.WEST;
                        gbc.gridx = 0;
                        gbc.gridy = 0;

                        // Add labels for report information
                        addLabelToPanel(reportPanel, gbc, "Report ID:", String.valueOf(reportId));
                        addLabelToPanel(reportPanel, gbc, "Username:", userName);
                        addLabelToPanel(reportPanel, gbc, "Title:", title);
                        addLabelToPanel(reportPanel, gbc, "Price:", price);
                        addLabelToPanel(reportPanel, gbc, "Address:", address);
                        proupdate.add(reportPanel);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve report information.");
        }
    }

    private void retriveruser(String seller) {
        proupdate.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // Adjust spacing as needed
        initializeDatabase();

        try {
            String sql2 = "SELECT * FROM realseller";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            proupdate.removeAll();

            while (resultSet2.next()) {
                String username = resultSet2.getString("user_id");
                String firstname = resultSet2.getString("first_name");
                String lastname = resultSet2.getString("last_name");
                String email = resultSet2.getString("email");
                String address = resultSet2.getString("address");
                String city = resultSet2.getString("city");
                String password = resultSet2.getString("password");
                String gender = resultSet2.getString("gender");
                int age = resultSet2.getInt("age");

                // Create a JPanel for each user's information
                JPanel userPanel = new JPanel(new GridBagLayout());
                userPanel.setBorder(BorderFactory.createTitledBorder(seller));

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                gbc.gridy = 0;

                // Add labels for user information
                addLabelToPanel(userPanel, gbc, "First Name:", firstname);
                addLabelToPanel(userPanel, gbc, "Last Name:", lastname);
                addLabelToPanel(userPanel, gbc, "Email:", email);
                addLabelToPanel(userPanel, gbc, "Address:", address);
                addLabelToPanel(userPanel, gbc, "City:", city);
                addLabelToPanel(userPanel, gbc, "Password:", password);
                addLabelToPanel(userPanel, gbc, "Gender:", gender);
                addLabelToPanel(userPanel, gbc, "Age:", String.valueOf(age));

                // Add Delete button
                JButton deleteButton = new JButton("Delete");
                deleteButton.setFont(new Font("System Bold", Font.BOLD, 12));
                deleteButton.addActionListener(e -> {
                    int confirmation = JOptionPane.showConfirmDialog(proupdate,
                            "Are you sure you want to delete user: " + username);
                    if (confirmation == JOptionPane.YES_OPTION) {

                        deleterowuser(username);
                        retriveruser(seller);
                    }
                });
                gbc.gridy++;
                userPanel.add(deleteButton, gbc);

                // Add View Properties button

                gbc.gridy++;
                // Add the userPanel to proupdate
                proupdate.add(userPanel);
            }

            resultSet2.close();
            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve user information.");
        }
    }

    private void retriverbuyer(String buyer) {
        proupdate.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // Adjust spacing as needed
        initializeDatabase();

        try {
            String sql2 = "SELECT * FROM realbuyer";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            proupdate.removeAll();

            while (resultSet2.next()) {
                String username = resultSet2.getString("user_id");
                String firstname = resultSet2.getString("first_name");
                String lastname = resultSet2.getString("last_name");
                String email = resultSet2.getString("email");
                String address = resultSet2.getString("address");
                String city = resultSet2.getString("city");
                String password = resultSet2.getString("password");
                String gender = resultSet2.getString("gender");
                int age = resultSet2.getInt("age");

                // Create a JPanel for each user's information
                JPanel userPanel = new JPanel(new GridBagLayout());
                userPanel.setBorder(BorderFactory.createTitledBorder(buyer));

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                gbc.gridy = 0;

                // Add labels for user information
                addLabelToPanel(userPanel, gbc, "First Name:", firstname);
                addLabelToPanel(userPanel, gbc, "Last Name:", lastname);
                addLabelToPanel(userPanel, gbc, "Email:", email);
                addLabelToPanel(userPanel, gbc, "Address:", address);
                addLabelToPanel(userPanel, gbc, "City:", city);
                addLabelToPanel(userPanel, gbc, "Password:", password);
                addLabelToPanel(userPanel, gbc, "Gender:", gender);
                addLabelToPanel(userPanel, gbc, "Age:", String.valueOf(age));

                // Add Delete button
                JButton deleteButton = new JButton("Delete");
                deleteButton.setFont(new Font("System Bold", Font.BOLD, 12));
                deleteButton.addActionListener(e -> {
                    int confirmation = JOptionPane.showConfirmDialog(proupdate,
                            "Are you sure you want to delete user: " + username);
                    if (confirmation == JOptionPane.YES_OPTION) {

                        deleterowbuyer(username);
                        retriverbuyer(buyer);
                    }
                });
                gbc.gridy++;
                userPanel.add(deleteButton, gbc);

                // Add View Properties button

                gbc.gridy++;
                // Add the userPanel to proupdate
                proupdate.add(userPanel);
            }

            resultSet2.close();
            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve user information.");
        }
    }

    private void addReport(String userId, String title, String price, String address) {
        try {
            // Perform the database insertion
            String insertSql = "INSERT INTO report (user_id, title, price, address) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
                insertStatement.setString(1, userId);
                insertStatement.setString(2, title);
                insertStatement.setString(3, price);
                insertStatement.setString(4, address);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    // Insert successful
                    JOptionPane.showMessageDialog(this, "Report added successfully.");
                    // You may want to perform additional actions after successful insertion
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Failed to add report.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Failed to add report.");
        }
    }

    private void addAdmin(String firstName, String lastName, String email, String address, String password) {
        try {
            // Perform the database insertion
            String insertSql = "INSERT INTO Admins (FirstName, LastName, Username, EmailAddress, Password) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
                insertStatement.setString(1, firstName);
                insertStatement.setString(2, lastName);
                insertStatement.setString(3, email);
                insertStatement.setString(4, address);
                insertStatement.setString(5, password);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    // Insert successful
                    JOptionPane.showMessageDialog(this, "Admin added successfully.");
                    // You may want to perform additional actions after successful insertion
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Failed to add admin.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Failed to add admin.");
        }
    }

    private void retriveradmin() {
        proupdate.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // Adjust spacing as needed
        initializeDatabase();

        try {
            String sql2 = "SELECT * FROM Admins";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            proupdate.removeAll();

            while (resultSet2.next()) {

                String firstname = resultSet2.getString("FirstName");
                String lastname = resultSet2.getString("LastName");
                String email = resultSet2.getString("Username");
                String address = resultSet2.getString("EmailAddress");
                String password = resultSet2.getString("Password");

                // Create a JPanel for each user's information
                JPanel userPanel = new JPanel(new GridBagLayout());
                userPanel.setBorder(BorderFactory.createTitledBorder(firstname));

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                gbc.gridy = 0;

                // Add labels for user information
                addLabelToPanel(userPanel, gbc, "First Name:", firstname);
                addLabelToPanel(userPanel, gbc, "Last Name:", lastname);
                addLabelToPanel(userPanel, gbc, "Username:", email);
                addLabelToPanel(userPanel, gbc, "EmailAddress:", address);
                addLabelToPanel(userPanel, gbc, "Password:", password);

                // Add Delete button
                JButton deleteButton = new JButton("Delete");
                deleteButton.setFont(new Font("System Bold", Font.BOLD, 12));
                deleteButton.addActionListener(e -> {
                    int confirmation = JOptionPane.showConfirmDialog(proupdate,
                            "Are you sure you want to delete user: " + firstname);
                    if (confirmation == JOptionPane.YES_OPTION) {

                        deleterowadmin(email);
                        // retriveruser();
                    }
                });
                gbc.gridy++;
                userPanel.add(deleteButton, gbc);
                proupdate.add(userPanel);
            }

            resultSet2.close();
            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve user information.");
        }
    }

    // Helper method to add JLabel to a panel
    private void addLabelToPanel(JPanel panel, GridBagConstraints gbc, String labelText, String value) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        panel.add(label, gbc);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy++;
        panel.add(valueLabel, gbc);
    }

    private void retriverforbuyer() {
        proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));
        initializeDatabase();
        try {
            String sql2 = "SELECT * FROM realpropforseller ";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            proupdate.removeAll();
            while (resultSet2.next()) {
                String usrname = resultSet2.getString("user_id");
                String title = resultSet2.getString("title");
                String location = resultSet2.getString("location");
                String address = resultSet2.getString("address");
                String squareMeter = resultSet2.getString("square_meter");
                String condition = resultSet2.getString("conditionn");
                String description = resultSet2.getString("description");
                int bathrooms = resultSet2.getInt("bathrooms");
                int bedrooms = resultSet2.getInt("bedrooms");
                String price = resultSet2.getString("price");
                byte[] imageBytes = resultSet2.getBytes("image");
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(new ByteArrayInputStream(imageBytes)));
                JLabel imageLabel = new JLabel();
                imageLabel.setIcon(imageIcon);
                imageLabel.setPreferredSize(new Dimension(271, 301));
                JLabel titlee = new JLabel("Title:");
                titlee.setFont(new Font("Times New Roman", Font.BOLD, 19));
                titlee.setForeground(Color.BLUE);
                JLabel titlvale = new JLabel("null");
                titlvale.setText(title);
                JLabel usernam = new JLabel("selleUser name");
                usernam.setFont(new Font("Times New Roman", Font.BOLD, 19));
                usernam.setForeground(Color.BLUE);
                JLabel uservale = new JLabel("null");
                uservale.setText(usrname);
                JLabel dis = new JLabel("Discription:");
                dis.setFont(new Font("Times New Roman", Font.BOLD, 19));
                dis.setForeground(Color.BLUE);
                JLabel disval = new JLabel("null");
                disval.setText(description);
                JLabel cond = new JLabel("Condition:");
                cond.setFont(new Font("System Bold", Font.BOLD, 19));
                cond.setForeground(Color.BLUE);
                JLabel condvalue = new JLabel("null");
                condvalue.setText(condition);
                JLabel loc = new JLabel("Location:");
                loc.setFont(new Font("System Bold", Font.BOLD, 19));
                loc.setForeground(Color.BLUE);
                JLabel locvalue = new JLabel("null");
                locvalue.setText(location);
                JLabel bath = new JLabel("Batherooms:");
                bath.setFont(new Font("System Bold", Font.BOLD, 19));
                bath.setForeground(Color.BLUE);
                JLabel bathvalu = new JLabel("null");
                String bathh = String.valueOf(bathrooms);
                bathvalu.setText(bathh);
                JLabel bed = new JLabel("Bedrooms:");
                bed.setFont(new Font("System Bold", Font.BOLD, 19));
                bed.setForeground(Color.BLUE);
                JLabel bedvalu = new JLabel("null");
                String bedvalue = String.valueOf(bedrooms);
                bedvalu.setText(bedvalue);
                JLabel squarem = new JLabel("Square Meter:");
                squarem.setFont(new Font("System Bold", Font.BOLD, 19));
                squarem.setForeground(Color.BLUE);
                JLabel squvalue = new JLabel("null");
                String squvalu = String.valueOf(squareMeter);
                squvalue.setText(squvalu);
                JLabel Address = new JLabel("Address:");
                Address.setFont(new Font("System Bold", Font.BOLD, 19));
                Address.setForeground(Color.BLUE);
                JLabel addresvalu = new JLabel("null");
                addresvalu.setText(address);
                JLabel pricelabel = new JLabel("Price:");
                pricelabel.setFont(new Font("System Bold", Font.BOLD, 19));
                pricelabel.setForeground(Color.BLUE);
                JLabel pricvalue = new JLabel("null");
                String priceva = String.valueOf(price);
                pricvalue.setText(priceva);

                proupdate.add(usernam);
                proupdate.add(uservale);
                proupdate.add(titlee);
                proupdate.add(titlvale);
                proupdate.add(imageLabel);
                proupdate.add(dis);
                proupdate.add(disval);
                proupdate.add(cond);
                proupdate.add(condvalue);
                proupdate.add(loc);
                proupdate.add(locvalue);
                proupdate.add(bath);
                proupdate.add(bathvalu);
                proupdate.add(bed);
                proupdate.add(bedvalu);
                proupdate.add(squarem);
                proupdate.add(squvalue);
                proupdate.add(Address);
                proupdate.add(addresvalu);
                proupdate.add(pricelabel);
                proupdate.add(pricvalue);
                contactbutton = new JButton("Contact The Seller");
                contactbutton.setFont(new Font("System Bold", Font.BOLD, 19));
                contactbutton.setBounds(455, 83, 108, 26);
                proupdate.add(contactbutton);

                contactbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String sql = "INSERT INTO chatt (userid, recivedmessage,fromuser,property_title) VALUES (?, ?,?,?)";
                        String from = user_id_for_post;
                        String contmsg = "I want to buy it";
                        String titl = title;
                        try {
                            PreparedStatement ppt = conn.prepareStatement(sql);

                            ppt.setString(1, usrname);
                            ppt.setString(2, contmsg);
                            ppt.setString(3, from);
                            ppt.setString(4, titl);
                            ppt.executeUpdate();
                            ppt.close();
                        } catch (SQLException we) {
                            we.printStackTrace();
                        }

                        String name = from;
                        try {

                            cl.show(rightcont, "chatsystem");
                            initchat(name);
                        } catch (RemoteException e1) {
                            e1.printStackTrace();
                        }

                    }
                });

            }
            resultSet2.close();
            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve for  update properties.");
        }
    }

    private void searchbyloction(String locationn) {
        proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));
        initializeDatabase();
        try {
            String sql2 = "SELECT * FROM realpropforseller WHERE location='" + locationn + "' OR PRICE<'" + locationn
                    + "'";

            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            proupdate.removeAll();
            while (resultSet2.next()) {
                String title = resultSet2.getString("title");
                String location = resultSet2.getString("location");
                String address = resultSet2.getString("address");
                String squareMeter = resultSet2.getString("square_meter");
                String condition = resultSet2.getString("conditionn");
                String description = resultSet2.getString("description");
                int bathrooms = resultSet2.getInt("bathrooms");
                int bedrooms = resultSet2.getInt("bedrooms");
                String price = resultSet2.getString("price");
                byte[] imageBytes = resultSet2.getBytes("image");
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(new ByteArrayInputStream(imageBytes)));
                JLabel imageLabel = new JLabel();
                imageLabel.setIcon(imageIcon);
                imageLabel.setPreferredSize(new Dimension(271, 301));
                JLabel titlee = new JLabel("Title:");
                titlee.setFont(new Font("Times New Roman", Font.BOLD, 19));
                titlee.setForeground(Color.BLUE);
                JLabel titlvale = new JLabel("null");
                titlvale.setText(title);
                JLabel dis = new JLabel("Discription:");
                dis.setFont(new Font("Times New Roman", Font.BOLD, 19));
                dis.setForeground(Color.BLUE);
                JLabel disval = new JLabel("null");
                disval.setText(description);
                JLabel cond = new JLabel("Condition:");
                cond.setFont(new Font("System Bold", Font.BOLD, 19));
                cond.setForeground(Color.BLUE);
                JLabel condvalue = new JLabel("null");
                condvalue.setText(condition);
                JLabel loc = new JLabel("Location:");
                loc.setFont(new Font("System Bold", Font.BOLD, 19));
                loc.setForeground(Color.BLUE);
                JLabel locvalue = new JLabel("null");
                locvalue.setText(location);
                JLabel bath = new JLabel("Batherooms:");
                bath.setFont(new Font("System Bold", Font.BOLD, 19));
                bath.setForeground(Color.BLUE);
                JLabel bathvalu = new JLabel("null");
                String bathh = String.valueOf(bathrooms);
                bathvalu.setText(bathh);
                JLabel bed = new JLabel("Bedrooms:");
                bed.setFont(new Font("System Bold", Font.BOLD, 19));
                bed.setForeground(Color.BLUE);
                JLabel bedvalu = new JLabel("null");
                String bedvalue = String.valueOf(bedrooms);
                bedvalu.setText(bedvalue);
                JLabel squarem = new JLabel("Square Meter:");
                squarem.setFont(new Font("System Bold", Font.BOLD, 19));
                squarem.setForeground(Color.BLUE);
                JLabel squvalue = new JLabel("null");
                String squvalu = String.valueOf(squareMeter);
                squvalue.setText(squvalu);
                JLabel Address = new JLabel("Address:");
                Address.setFont(new Font("System Bold", Font.BOLD, 19));
                Address.setForeground(Color.BLUE);
                JLabel addresvalu = new JLabel("null");
                addresvalu.setText(address);
                JLabel pricelabel = new JLabel("Price:");
                pricelabel.setFont(new Font("System Bold", Font.BOLD, 19));
                pricelabel.setForeground(Color.BLUE);
                JLabel pricvalue = new JLabel("null");
                String priceva = String.valueOf(price);
                pricvalue.setText(priceva);

                proupdate.add(titlee);
                proupdate.add(titlvale);
                proupdate.add(imageLabel);
                proupdate.add(dis);
                proupdate.add(disval);
                proupdate.add(cond);
                proupdate.add(condvalue);
                proupdate.add(loc);
                proupdate.add(locvalue);
                proupdate.add(bath);
                proupdate.add(bathvalu);
                proupdate.add(bed);
                proupdate.add(bedvalu);
                proupdate.add(squarem);
                proupdate.add(squvalue);
                proupdate.add(Address);
                proupdate.add(addresvalu);
                proupdate.add(pricelabel);
                proupdate.add(pricvalue);
                updateButton = new JButton("Contact The Seller");
                updateButton.setFont(new Font("System Bold", Font.BOLD, 19));
                updateButton.setBounds(455, 83, 108, 26);
                proupdate.add(updateButton);
                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(proupdate, "IT'S WORKING ");
                    }
                });

            }
            resultSet2.close();
            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve for  update properties.");
        }
    }

    private void deleterow(String pass) {
        proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));
        initializeDatabase();
        try {
            String sql2 = "DELETE FROM realpropforseller WHERE title ='" + pass + "'";
            Statement statement2 = conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sql2);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Failed to Delete.");
            }

            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to Delete");
        }
    }

    public void myacc(String usr) {
        try {
            String sql2 = "SELECT * FROM realseller  where user_id='" + usr + "'";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            myaccount.removeAll();

            while (resultSet2.next()) {

                String firstname = resultSet2.getString("first_name");
                String lastname = resultSet2.getString("last_name");
                String email = resultSet2.getString("email");
                String address = resultSet2.getString("address");
                String city = resultSet2.getString("city");
                String password = resultSet2.getString("password");
                String gender = resultSet2.getString("gender");
                int age = resultSet2.getInt("age");

                myaccount.setPreferredSize(new Dimension(40, 399));

                JLabel profileLabel = new JLabel("Profile");
                profileLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Adjusted font size and set to bold
                profileLabel.setForeground(new Color(255, 0, 0)); // Set the color to red
                myaccount.add(profileLabel);

                JLabel firstNameLabel = new JLabel("First Name");
                firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                firstNameLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(firstNameLabel);

                JLabel firstNameValueLabel = new JLabel("null");
                firstNameValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                firstNameValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                firstNameValueLabel.setText(firstname);
                myaccount.add(firstNameValueLabel);

                JLabel lastNameLabel = new JLabel("Last Name");
                lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                lastNameLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(lastNameLabel);

                JLabel lastNameValueLabel = new JLabel("null");
                lastNameValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                lastNameValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                lastNameValueLabel.setText(lastname);
                myaccount.add(lastNameValueLabel);

                JLabel emailLabel = new JLabel("Email");
                emailLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                emailLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(emailLabel);

                JLabel emailValueLabel = new JLabel("null");
                emailValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                emailValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                emailValueLabel.setText(email);
                myaccount.add(emailValueLabel);

                JLabel passwordLabel = new JLabel("Password");
                passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                passwordLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(passwordLabel);

                JLabel passwordValueLabel = new JLabel("null");
                passwordValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                passwordValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                passwordValueLabel.setText(password);
                myaccount.add(passwordValueLabel);

                JLabel addressLabel = new JLabel("Address");
                addressLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                addressLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(addressLabel);

                JLabel addressValueLabel = new JLabel("null");
                addressValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                addressValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                addressValueLabel.setText(address);
                myaccount.add(addressValueLabel);

                JLabel cityLabel = new JLabel("City");
                cityLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                cityLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(cityLabel);

                JLabel cityValueLabel = new JLabel("null");
                cityValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                cityValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                cityValueLabel.setText(city);
                myaccount.add(cityValueLabel);

                JLabel genderLabel = new JLabel("Gender");
                genderLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                genderLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(genderLabel);

                JLabel genderValueLabel = new JLabel("null");
                genderValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                genderValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                genderValueLabel.setText(gender);
                myaccount.add(genderValueLabel);

                JLabel ageLabel = new JLabel("Age");
                ageLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                ageLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(ageLabel);

                JLabel ageValueLabel = new JLabel("null");
                ageValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                ageValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                ageValueLabel.setText(Integer.toString(age));
                myaccount.add(ageValueLabel);

                JButton updateButton = new JButton("Update");
                myaccount.add(updateButton);

                // Add Delete button

                updateButton.setFont(new Font("System Bold", Font.BOLD, 12));
                updateButton.addActionListener(e -> {
                    try {
                        // Retrieve updated values from user input
                        String updatedFirstName = JOptionPane.showInputDialog("Enter updated first name:", firstname);
                        String updatedLastName = JOptionPane.showInputDialog("Enter updated last name:", lastname);
                        String updatedEmail = JOptionPane.showInputDialog("Enter updated email:", email);
                        String updatedAddress = JOptionPane.showInputDialog("Enter updated address:", address);
                        String updatedCity = JOptionPane.showInputDialog("Enter updated city:", city);
                        String updatedPassword = JOptionPane.showInputDialog("Enter updated password:", password);
                        String updatedGender = JOptionPane.showInputDialog("Enter updated gender:", gender);
                        String updatedAgeString = JOptionPane.showInputDialog("Enter updated age:", age);

                        // Input validation (you may want to add more sophisticated validation)
                        if (updatedFirstName.isEmpty() || updatedLastName.isEmpty() || updatedEmail.isEmpty() ||
                                updatedAddress.isEmpty() || updatedCity.isEmpty() || updatedPassword.isEmpty() ||
                                updatedGender.isEmpty() || updatedAgeString.isEmpty()) {
                            JOptionPane.showMessageDialog(proupdate,
                                    "Error: Please provide valid information for all fields.");
                            return;
                        }

                        // Parse the age string to an integer
                        int updatedAge = Integer.parseInt(updatedAgeString);

                        // Update the database with the new values
                        String updateSql = "UPDATE realseller SET first_name=?, last_name=?, email=?, address=?, city=?, password=?, gender=?, age=? WHERE user_id=?";
                        try (PreparedStatement updateStatement = conn.prepareStatement(updateSql)) {
                            updateStatement.setString(1, updatedFirstName);
                            updateStatement.setString(2, updatedLastName);
                            updateStatement.setString(3, updatedEmail);
                            updateStatement.setString(4, updatedAddress);
                            updateStatement.setString(5, updatedCity);
                            updateStatement.setString(6, updatedPassword);
                            updateStatement.setString(7, updatedGender);
                            updateStatement.setInt(8, updatedAge);
                            updateStatement.setString(9, usr); // Assuming user_id is the 9th column, adjust as needed

                            int rowsAffected = updateStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                // Update successful
                                JOptionPane.showMessageDialog(proupdate, "Account information updated successfully.");
                                // You may want to refresh the displayed information after the update
                                myacc(usr);
                            } else {
                                JOptionPane.showMessageDialog(proupdate,
                                        "Error: Failed to update account information.");
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(proupdate, "Error: Failed to update account information.");
                    }
                });

            }

            resultSet2.close();
            statement2.close();

        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve user information.");
        }
    }

    public void myaccbuyer(String usr) {
        try {
            String sql2 = "SELECT * FROM realbuyer  where user_id='" + usr + "'";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            myaccount.removeAll();

            while (resultSet2.next()) {

                String firstname = resultSet2.getString("first_name");
                String lastname = resultSet2.getString("last_name");
                String email = resultSet2.getString("email");
                String address = resultSet2.getString("address");
                String city = resultSet2.getString("city");
                String password = resultSet2.getString("password");
                String gender = resultSet2.getString("gender");
                int age = resultSet2.getInt("age");

                myaccount.setPreferredSize(new Dimension(40, 399));

                JLabel profileLabel = new JLabel("Profile");
                profileLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Adjusted font size and set to bold
                profileLabel.setForeground(new Color(255, 0, 0)); // Set the color to red
                myaccount.add(profileLabel);

                JLabel firstNameLabel = new JLabel("First Name");
                firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                firstNameLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(firstNameLabel);

                JLabel firstNameValueLabel = new JLabel("null");
                firstNameValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                firstNameValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                firstNameValueLabel.setText(firstname);
                myaccount.add(firstNameValueLabel);

                JLabel lastNameLabel = new JLabel("Last Name");
                lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                lastNameLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(lastNameLabel);

                JLabel lastNameValueLabel = new JLabel("null");
                lastNameValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                lastNameValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                lastNameValueLabel.setText(lastname);
                myaccount.add(lastNameValueLabel);

                JLabel emailLabel = new JLabel("Email");
                emailLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                emailLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(emailLabel);

                JLabel emailValueLabel = new JLabel("null");
                emailValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                emailValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                emailValueLabel.setText(email);
                myaccount.add(emailValueLabel);

                JLabel passwordLabel = new JLabel("Password");
                passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                passwordLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(passwordLabel);

                JLabel passwordValueLabel = new JLabel("null");
                passwordValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                passwordValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                passwordValueLabel.setText(password);
                myaccount.add(passwordValueLabel);

                JLabel addressLabel = new JLabel("Address");
                addressLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                addressLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(addressLabel);

                JLabel addressValueLabel = new JLabel("null");
                addressValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                addressValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                addressValueLabel.setText(address);
                myaccount.add(addressValueLabel);

                JLabel cityLabel = new JLabel("City");
                cityLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                cityLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(cityLabel);

                JLabel cityValueLabel = new JLabel("null");
                cityValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                cityValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                cityValueLabel.setText(city);
                myaccount.add(cityValueLabel);

                JLabel genderLabel = new JLabel("Gender");
                genderLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                genderLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(genderLabel);

                JLabel genderValueLabel = new JLabel("null");
                genderValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                genderValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                genderValueLabel.setText(gender);
                myaccount.add(genderValueLabel);

                JLabel ageLabel = new JLabel("Age");
                ageLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                ageLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(ageLabel);

                JLabel ageValueLabel = new JLabel("null");
                ageValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                ageValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                ageValueLabel.setText(Integer.toString(age));
                myaccount.add(ageValueLabel);

                JButton updateButton = new JButton("Update");
                myaccount.add(updateButton);

                // Add Delete button

                updateButton.setFont(new Font("System Bold", Font.BOLD, 12));
                updateButton.addActionListener(e -> {
                    try {
                        // Retrieve updated values from user input
                        String updatedFirstName = JOptionPane.showInputDialog("Enter updated first name:", firstname);
                        String updatedLastName = JOptionPane.showInputDialog("Enter updated last name:", lastname);
                        String updatedEmail = JOptionPane.showInputDialog("Enter updated email:", email);
                        String updatedAddress = JOptionPane.showInputDialog("Enter updated address:", address);
                        String updatedCity = JOptionPane.showInputDialog("Enter updated city:", city);
                        String updatedPassword = JOptionPane.showInputDialog("Enter updated password:", password);
                        String updatedGender = JOptionPane.showInputDialog("Enter updated gender:", gender);
                        String updatedAgeString = JOptionPane.showInputDialog("Enter updated age:", age);

                        // Input validation (you may want to add more sophisticated validation)
                        if (updatedFirstName.isEmpty() || updatedLastName.isEmpty() || updatedEmail.isEmpty() ||
                                updatedAddress.isEmpty() || updatedCity.isEmpty() || updatedPassword.isEmpty() ||
                                updatedGender.isEmpty() || updatedAgeString.isEmpty()) {
                            JOptionPane.showMessageDialog(proupdate,
                                    "Error: Please provide valid information for all fields.");
                            return;
                        }

                        // Parse the age string to an integer
                        int updatedAge = Integer.parseInt(updatedAgeString);

                        // Update the database with the new values
                        String updateSql = "UPDATE realbuyer SET first_name=?, last_name=?, email=?, address=?, city=?, password=?, gender=?, age=? WHERE user_id=?";
                        try (PreparedStatement updateStatement = conn.prepareStatement(updateSql)) {
                            updateStatement.setString(1, updatedFirstName);
                            updateStatement.setString(2, updatedLastName);
                            updateStatement.setString(3, updatedEmail);
                            updateStatement.setString(4, updatedAddress);
                            updateStatement.setString(5, updatedCity);
                            updateStatement.setString(6, updatedPassword);
                            updateStatement.setString(7, updatedGender);
                            updateStatement.setInt(8, updatedAge);
                            updateStatement.setString(9, usr); // Assuming user_id is the 9th column, adjust as needed

                            int rowsAffected = updateStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                // Update successful
                                JOptionPane.showMessageDialog(proupdate, "Account information updated successfully.");
                                // You may want to refresh the displayed information after the update
                                myacc(usr);
                            } else {
                                JOptionPane.showMessageDialog(proupdate,
                                        "Error: Failed to update account information.inside");
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(proupdate, "Error: Failed to update account information.");
                    }
                });

            }

            resultSet2.close();
            statement2.close();

        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve user information.");
        }
    }

    public void myaccadmin(String usr) {
        try {
            String sql2 = "SELECT * FROM Admins  where Username='" + usr + "'";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            myaccount.removeAll();

            while (resultSet2.next()) {

                String lastname = resultSet2.getString("FirstName");
                String email = resultSet2.getString("LastName");
                String username = resultSet2.getString("Username");
                String emaill = resultSet2.getString("EmailAddress");
                String password = resultSet2.getString("Password");

                myaccount.setPreferredSize(new Dimension(40, 399));

                JLabel profileLabel = new JLabel("Profile");
                profileLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Adjusted font size and set to bold
                profileLabel.setForeground(new Color(255, 0, 0)); // Set the color to red
                myaccount.add(profileLabel);

                JLabel firstNameLabel = new JLabel("First Name");
                firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                firstNameLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(firstNameLabel);

                JLabel firstNameValueLabel = new JLabel("null");
                firstNameValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                firstNameValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                firstNameValueLabel.setText(lastname);
                myaccount.add(firstNameValueLabel);

                JLabel lastNameLabel = new JLabel("Last Name");
                lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                lastNameLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(lastNameLabel);

                JLabel lastNameValueLabel = new JLabel("null");
                lastNameValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                lastNameValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                lastNameValueLabel.setText(email);
                myaccount.add(lastNameValueLabel);

                JLabel emailLabel = new JLabel("Username");
                emailLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                emailLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(emailLabel);

                JLabel emailValueLabel = new JLabel("null");
                emailValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                emailValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                emailValueLabel.setText(username);
                myaccount.add(emailValueLabel);

                JLabel passwordLabel = new JLabel("Password");
                passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                passwordLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(passwordLabel);

                JLabel passwordValueLabel = new JLabel("null");
                passwordValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                passwordValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                passwordValueLabel.setText(password);
                myaccount.add(passwordValueLabel);

                JLabel addressLabel = new JLabel("Email");
                addressLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjusted font size
                addressLabel.setForeground(new Color(0, 0, 255)); // Set the color to blue
                myaccount.add(addressLabel);

                JLabel addressValueLabel = new JLabel("null");
                addressValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjusted font size
                addressValueLabel.setForeground(new Color(0, 128, 0)); // Set the color to green
                addressValueLabel.setText(emaill);
                myaccount.add(addressValueLabel);

                JButton updateButton = new JButton("Update");
                myaccount.add(updateButton);

                // Add Delete button

                updateButton.setFont(new Font("System Bold", Font.BOLD, 12));
                updateButton.addActionListener(e -> {
                    try {
                        // Retrieve updated values from user input
                        String updatedFirstName = JOptionPane.showInputDialog("Enter updated first name:", lastname);
                        String updatedLastName = JOptionPane.showInputDialog("Enter updated last name:", email);
                        String updatedEmail = JOptionPane.showInputDialog("Enter updated email:", emaill);
                        String updatedAddress = JOptionPane.showInputDialog("Enter updated Username:", username);
                        String updatedPassword = JOptionPane.showInputDialog("Enter updated password:", password);

                        // Input validation (you may want to add more sophisticated validation)
                        if (updatedFirstName.isEmpty() || updatedLastName.isEmpty() || updatedEmail.isEmpty() ||
                                updatedAddress.isEmpty() || updatedPassword.isEmpty()) {
                            JOptionPane.showMessageDialog(proupdate,
                                    "Error: Please provide valid information for all fields.");
                            return;
                        }

                        // Update the database with the new values
                        String updateSql = "UPDATE Admins SET FirstName=?, LastName=?, Username=?, EmailAddress=?, Password=? WHERE Username=?";
                        try (PreparedStatement updateStatement = conn.prepareStatement(updateSql)) {
                            updateStatement.setString(1, updatedFirstName);
                            updateStatement.setString(2, updatedLastName);
                            updateStatement.setString(3, updatedAddress);
                            updateStatement.setString(4, updatedEmail);
                            updateStatement.setString(5, updatedPassword);
                            updateStatement.setString(6, usr); // Assuming user_id is the 9th column, adjust as needed

                            int rowsAffected = updateStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                // Update successful
                                JOptionPane.showMessageDialog(proupdate, "Account information updated successfully.");
                                // You may want to refresh the displayed information after the update
                                myacc(usr);
                            } else {
                                JOptionPane.showMessageDialog(proupdate,
                                        "Error: Failed to update account information.inside");
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(proupdate, "Error: Failed to update account information.");
                    }
                });

            }

            resultSet2.close();
            statement2.close();

        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve user information.");
        }
    }

    private void deleterowuser(String pass) {
        proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));
        initializeDatabase();
        try {
            String sql2 = "DELETE FROM realseller WHERE user_id ='" + pass + "'";
            Statement statement2 = conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sql2);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Failed to Delete.");
            }

            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to Delete");
        }
    }

    private void deleterowbuyer(String pass) {
        proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));
        initializeDatabase();
        try {
            String sql2 = "DELETE FROM realbuyer WHERE user_id ='" + pass + "'";
            Statement statement2 = conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sql2);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Failed to Delete.");
            }

            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to Delete");
        }
    }

    private void deleterowadmin(String pass) {
        proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));
        initializeDatabase();
        try {
            String sql2 = "DELETE FROM Admins WHERE Username ='" + pass + "'";
            Statement statement2 = conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sql2);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Failed to Delete.");
            }

            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to Delete");
        }
    }

    private void insertProperty(String usr_id) {

        String title = titleTextField.getText();
        File imageFile = selectedFile;
        String locationpro = (String) locationComboBox.getSelectedItem();
        String addre = (String) addressComboBox.getSelectedItem();
        String squarem = squareMeterTextField.getText();
        String condition = (String) conditionComboBox.getSelectedItem();
        String description = descriptionTextArea.getText();
        int bathroom = (int) bathroomsSpinner.getValue();
        int bedroom = (int) bedroomsSpinner.getValue();
        String price = priceTextField.getText();

        try {
            // Check for empty or invalid inputs
            if (title.isEmpty() || locationpro.isEmpty() || condition.isEmpty() || addre.isEmpty()
                    || imageFile == null || bathroom <= 0 || squarem.isEmpty() || description.length() < 7) {
                JOptionPane.showMessageDialog(this, "Please fill the form correctly.");
            } else {
                // Prepare the SQL statement
                String sql = "INSERT INTO realpropforseller (user_id,title, image, location, address, square_meter, conditionn, description, bathrooms, bedrooms, price) "
                        +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, usr_id);
                preparedStatement.setString(2, title);
                FileInputStream fis = new FileInputStream(imageFile);
                preparedStatement.setBinaryStream(3, fis, (int) imageFile.length());
                preparedStatement.setString(4, locationpro);
                preparedStatement.setString(5, addre);
                preparedStatement.setString(6, squarem);
                preparedStatement.setString(7, condition);
                preparedStatement.setString(8, description);
                preparedStatement.setInt(9, bathroom);
                preparedStatement.setInt(10, bedroom);
                preparedStatement.setString(11, price);

                int rowsInserted = preparedStatement.executeUpdate();
                fis.close(); // Close the FileInputStream

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Property added successfully.");
                    // Clear input fields after successful insertion
                    titleTextField.setText("");
                    // Set other fields as needed
                    locationComboBox.setSelectedIndex(0);
                    // Clear other fields
                } else {
                    JOptionPane.showMessageDialog(this, "Property insertion failed.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Property insertion failed.");
        }
    }

    private void initializeDatabase() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate", "root", "");

            // Check if the connection is not null before creating a statement
            if (conn != null) {
                conn.createStatement();
            } else {
                System.err.println("Failed to establish a database connection.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public JPanel getTextPanel() {
        String welcome = "Chat Safely we want you to be successful\n";
        textArea = new JTextArea(welcome, 14, 34);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        textArea.setFont(meiryoFont);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textPanel = new JPanel();
        textPanel.add(scrollPane);

        textPanel.setFont(new Font("Meiryo", Font.PLAIN, 14));
        return textPanel;
    }

    public JPanel getInputPanel() {
        inputPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        inputPanel.setBorder(blankBorder);
        textField = new JTextField();
        textField.setFont(meiryoFont);
        inputPanel.add(textField);
        return inputPanel;
    }

    public JPanel getUsersPanel() {

        userPanel = new JPanel(new BorderLayout());
        String userStr = " Current Users      ";

        JLabel userLabel = new JLabel(userStr, JLabel.CENTER);
        userPanel.add(userLabel, BorderLayout.NORTH);
        userLabel.setFont(new Font("Meiryo", Font.PLAIN, 16));

        String[] noClientsYet = { "No other users" };
        setClientPanel(noClientsYet);

        clientPanel.setFont(meiryoFont);
        userPanel.add(makeButtonPanel(), BorderLayout.SOUTH);
        userPanel.setBorder(blankBorder);

        return userPanel;
    }

    public void setClientPanel(String[] currClients) {
        clientPanel = new JPanel(new BorderLayout());
        listModel = new DefaultListModel<String>();

        for (String s : currClients) {
            listModel.addElement(s);
        }
        if (currClients.length > 1) {
            privateMsgButton.setEnabled(true);
        }

        list = new JList<String>(listModel);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(8);
        list.setFont(meiryoFont);
        JScrollPane listScrollPane = new JScrollPane(list);

        clientPanel.add(listScrollPane, BorderLayout.CENTER);
        userPanel.add(clientPanel, BorderLayout.CENTER);
    }

    public JPanel makeButtonPanel() {
        privateMsgButton = new JButton("Send PM");
        privateMsgButton.addActionListener(this);
        privateMsgButton.setEnabled(true);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.add(privateMsgButton);
        return buttonPanel;
    }

    public void initchat(String nm) throws RemoteException {
        name = nm;
        if (name.length() != 0) {
            getConnected(name);
        }

    }

    private void sendPrivate(int[] privateList) throws RemoteException {
        String privateMessage = "[PM from " + name + "] :" + message + "\n";
        chatClient.serverIF.sendPM(privateList, privateMessage);
    }

    private void getConnected(String userName) throws RemoteException {
        String cleanedUserName = userName.replaceAll("\\s+", "_");
        cleanedUserName = userName.replaceAll("\\W+", "_");
        try {

            chatClient = new ChatClient3(this, cleanedUserName);
            chatClient.startClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            realproject form = new realproject();
            form.setVisible(true);

        });
    }

    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == privateMsgButton) {
                int[] privateList = list.getSelectedIndices();

                for (int i = 0; i < privateList.length; i++) {
                    System.out.println("selected index :" + privateList[i]);
                }
                message = textField.getText();
                textField.setText("");
                sendPrivate(privateList);
            }

        } catch (RemoteException remoteExc) {
            remoteExc.printStackTrace();
        }

    }
}
