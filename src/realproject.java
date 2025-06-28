import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class realproject extends JFrame implements ActionListener{
    public static int ch = 0;
    private JFileChooser fileChooser = new JFileChooser();
    public JButton chooseButton, updateButton;
    private JPanel proupdate = new JPanel();
    private JScrollPane proupscrol = new JScrollPane(proupdate);
    public static File selectedFile;
    private static String user_id_for_post;
    private JPanel proform = new JPanel(null);
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

    public realproject() {

        setTitle("Real Estate Management System");
        setSize(1340, 701);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cl = new CardLayout();
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
        ImageIcon logoIcon = new ImageIcon("/home/anon/Desktop/real/src/lolol.png");
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
        JButton profile1 = new JButton("Message");
        profile1.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton profile2 = new JButton("My Properties");
        profile2.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton profile3 = new JButton("My Appointemnt");
        JButton progile4 = new JButton("My Account");
        JButton profile5 = new JButton("Logout");
        JButton profile7 = new JButton("About Us");

        profile3.setFont(new Font("System Bold", Font.BOLD, 14));

        progile4.setFont(new Font("System Bold", Font.BOLD, 14));
        profile3.setFont(new Font("System Bold", Font.BOLD, 14));
        profile5.setFont(new Font("System Bold", Font.BOLD, 14));
        profile7.setFont(new Font("System Bold", Font.BOLD, 14));
        centerPanel.add(profile);
        centerPanel.add(profile1);
        centerPanel.add(profile2);
        centerPanel.add(profile3);
        centerPanel.add(progile4);
        centerPanel.add(profile5);
        centerPanel.add(profile7);

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
        JButton buyrprofile1 = new JButton("Messages");
        buyrprofile1.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton buyrprofile3 = new JButton("Appointemnt");
        JButton buyrprofile4 = new JButton("Profile");
        JButton buyrprofile5 = new JButton("Logout");

        JButton buyrprofile7 = new JButton("About Us");

        buyrprofile3.setFont(new Font("System Bold", Font.BOLD, 14));

        progile4.setFont(new Font("System Bold", Font.BOLD, 14));
        buyrprofile3.setFont(new Font("System Bold", Font.BOLD, 14));
        buyrprofile5.setFont(new Font("System Bold", Font.BOLD, 14));
        buyrprofile7.setFont(new Font("System Bold", Font.BOLD, 14));
        leftbuyer.add(buyrprofile);
        leftbuyer.add(buysearch);
        leftbuyer.add(buyrprofile1);
        leftbuyer.add(buyrprofile3);
        leftbuyer.add(buyrprofile4);
        leftbuyer.add(buyrprofile7);
        leftbuyer.add(buyrprofile5);

        leftbuyer.setBackground(Color.black);
        leftcon.add(leftbuyer, "ffff");
        JPanel leftadmin = new JPanel();
        leftadmin.setLayout(new GridLayout(12, 5, 1, 10));
        leftadmin.setPreferredSize(new Dimension(1, 511));
        JButton adminprofile = new JButton("Manage Admins");
        adminprofile.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton adminsearch = new JButton("Manage Users");
        adminsearch.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton adminprofile1 = new JButton("Manage Properties");
        adminprofile1.setFont(new Font("System Bold", Font.BOLD, 14));
        JButton adminprofile3 = new JButton("Edit Profile");
        JButton adminprofile4 = new JButton("Report");
        JButton adminprofile5 = new JButton("Logout");
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
        JPanel rightcont = new JPanel();
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
        trading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        trading.setForeground(Color.ORANGE);
        trading.setBackground(Color.BLACK);
        // contentPanel.setPreferredSize(new Dimension(471, 481));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(trading);
        JScrollPane scrollPane = new JScrollPane(contentPanel);

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
        JPanel search = new JPanel(new GridLayout(22, 3, 3, 3));
        JLabel searchby = new JLabel("Search By Location Or by Price Under");
        searchby.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        searcfiled = new JTextField();
        JButton searchh = new JButton("Search");
        JPanel myaccount = new JPanel(new GridLayout(12, 1, 4, 2));
        myaccount.setPreferredSize(new Dimension(40, 399));
        JLabel profileLabel = new JLabel("Profile");
        profileLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        profileLabel.setBounds(216, 81, 267, 112);
        profileLabel.setForeground(new Color(34, 32, 32));
        myaccount.add(profileLabel);
        JButton editProfileButton = new JButton("Edit Profile");
        editProfileButton.setBounds(514, 163, 100, 24);
        myaccount.add(editProfileButton);
        JLabel firstNameLabell = new JLabel("First Name");
        firstNameLabel.setBounds(238, 215, 79, 16);
        myaccount.add(firstNameLabell);
        JLabel firstNameValueLabel = new JLabel("null");
        firstNameValueLabel.setBounds(359, 215, 79, 16);
        myaccount.add(firstNameValueLabel);
        JLabel lastNameLabell = new JLabel("Last Name");
        lastNameLabel.setBounds(238, 250, 79, 16);
        myaccount.add(lastNameLabell);
        JLabel lastNameValueLabel = new JLabel("null");
        lastNameValueLabel.setBounds(359, 250, 79, 16);
        myaccount.add(lastNameValueLabel);
        JLabel emailLabell = new JLabel("Email");
        emailLabel.setBounds(236, 280, 79, 16);
        myaccount.add(emailLabell);
        JLabel emailValueLabel = new JLabel("null");
        emailValueLabel.setBounds(360, 280, 79, 16);
        myaccount.add(emailValueLabel);
        JLabel passwordLabell = new JLabel("Password");
        passwordLabel.setBounds(235, 317, 79, 16);
        myaccount.add(passwordLabell);
        JLabel passwordValueLabel = new JLabel("null");
        passwordValueLabel.setBounds(359, 317, 79, 16);
        myaccount.add(passwordValueLabel);
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(238, 354, 79, 16);
        myaccount.add(addressLabel);
        JLabel addressValueLabel = new JLabel("null");
        addressValueLabel.setBounds(359, 354, 79, 16);
        myaccount.add(addressValueLabel);
        JLabel cityLabell = new JLabel("City");
        cityLabel.setBounds(254, 387, 79, 16);
        myaccount.add(cityLabell);
        JLabel cityValueLabel = new JLabel("null");
        cityValueLabel.setBounds(359, 387, 79, 16);
        myaccount.add(cityValueLabel);
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(282, 437, 178, 24);
        myaccount.add(updateButton);
        JPanel manageadmin = new JPanel();
        JButton addadmin = new JButton("Add Admin");
        addadmin.setBounds(10, 10, 100, 24);
        manageadmin.add(addadmin);
        JButton removeadmin = new JButton("Remove Admin");
        removeadmin.setBounds(120, 10, 100, 24);
        manageadmin.add(removeadmin);
        JScrollPane scrollPane_manageadmins = new JScrollPane();
        scrollPane_manageadmins.setViewportBorder(new BevelBorder(BevelBorder.LOWERED));
        scrollPane_manageadmins.setBounds(230, 10, 200, 200);

        JPanel myaccount2 = new JPanel(new GridLayout(12, 1, 4, 2));
        myaccount2.setPreferredSize(new Dimension(40, 399));
        JLabel profileLabel2 = new JLabel("Profile");
        profileLabel2.setFont(new Font("Arial", Font.PLAIN, 20));
        profileLabel2.setBounds(216, 81, 267, 112);
        profileLabel2.setForeground(new Color(34, 32, 32));
        myaccount2.add(profileLabel2);
        JButton editProfileButton2 = new JButton("Edit Profile");
        editProfileButton2.setBounds(514, 163, 100, 24);
        myaccount2.add(editProfileButton2);
        JLabel firstNameLabell2 = new JLabel("First Name");
        firstNameLabell2.setBounds(238, 215, 79, 16);
        myaccount2.add(firstNameLabell2);
        JLabel firstNameValueLabel2 = new JLabel("null");
        firstNameValueLabel2.setBounds(359, 215, 79, 16);
        myaccount2.add(firstNameValueLabel2);
        JLabel lastNameLabell2 = new JLabel("Last Name");
        lastNameLabell2.setBounds(238, 250, 79, 16);
        myaccount2.add(lastNameLabell2);
        JLabel lastNameValueLabel2 = new JLabel("null");
        lastNameValueLabel2.setBounds(359, 250, 79, 16);
        myaccount2.add(lastNameValueLabel2);
        JLabel emailLabell2 = new JLabel("Email");
        emailLabell2.setBounds(236, 280, 79, 16);
        myaccount2.add(emailLabell2);
        JLabel emailValueLabell2 = new JLabel("null");
        emailValueLabell2.setBounds(360, 280, 79, 16);
        myaccount2.add(emailValueLabell2);
        JLabel passwordLabell2 = new JLabel("Password");
        passwordLabell2.setBounds(235, 317, 79, 16);
        myaccount2.add(passwordLabell);
        JLabel passwordValueLabel2 = new JLabel("null");
        passwordValueLabel2.setBounds(359, 317, 79, 16);
        myaccount2.add(passwordValueLabel2);
        JLabel addressLabel2 = new JLabel("Address");
        addressLabel2.setBounds(238, 354, 79, 16);
        myaccount2.add(addressLabel2);
        JLabel addressValueLabe2 = new JLabel("null");
        addressValueLabe2.setBounds(359, 354, 79, 16);
        myaccount2.add(addressValueLabe2);
        JLabel cityLabell2 = new JLabel("City");
        cityLabel.setBounds(254, 387, 79, 16);
        myaccount2.add(cityLabell2);
        JLabel cityValueLabel2 = new JLabel("null");
        cityValueLabel2.setBounds(359, 387, 79, 16);
        myaccount2.add(cityValueLabel2);
        JButton updateButton2 = new JButton("Update");
        updateButton2.setBounds(282, 437, 178, 24);
        myaccount2.add(updateButton2);
        searchh.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        search.add(searchby);
        search.add(searcfiled);
        search.add(searchh);
       
        rightcont.add(scrollPane, "prolist");
        rightcont.add(rightregistertype, "rtype");
        rightcont.add(rightPanel, "1");
        rightcont.add(rightPanel2, "2");
        rightcont.add(rightPanel_seller, "seller");
        rightcont.add(rightPanel_agent, "agent");
        rightcont.add(proupscrol, "prosclor");
        rightcont.add(search, "search");
        rightcont.add(myaccount, "myaccount");
        rightcont.add(myaccount2, "myaccount2");
        rightcont.add(manageadmin, "manageadmin");
        
        JPanel rigJPanel3 = new JPanel();
        rigJPanel3.setPreferredSize(new Dimension(81, 481));

        rightcont.add(rigJPanel3, "3");
        // add action listener for register button
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
                cl.show(rightcont, "3");
                cl.show(rightcont, "proform");
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
                        // Login successful
                        JOptionPane.showMessageDialog(null, "Successful Login", "", JOptionPane.INFORMATION_MESSAGE);
                        leftPanel.setPreferredSize(new Dimension(151, 511));
                        rightPanel.setPreferredSize(new Dimension(1175, 481));
                        retriver(user_id_for_post);
                        // insertProperty(username);
                        cl.show(northcon, "welforbuyer");
                        cl.show(leftcon, "ffff");
                        cl.show(rightcont, "3");
                        // Perform actions after successful login
                    } else if (verifyLogins(user_id_for_post, password)) {
                        // Login successful
                        JOptionPane.showMessageDialog(null, "Successful Login", "", JOptionPane.INFORMATION_MESSAGE);
                        leftPanel.setPreferredSize(new Dimension(151, 511));
                        rightPanel.setPreferredSize(new Dimension(1175, 481));
                        // retriver(password);

                        cl.show(northcon, "weleback");
                        cl.show(leftcon, "centerpanel");

                        cl.show(rightcont, "3");
                        // Perform actions after successful login
                    } else if (verifyLogina(user_id_for_post, password)) {
                        // Login successful
                        JOptionPane.showMessageDialog(null, "Successful Login", "", JOptionPane.INFORMATION_MESSAGE);
                        leftPanel.setPreferredSize(new Dimension(151, 511));
                        rightPanel.setPreferredSize(new Dimension(1175, 481));
                        // insertProperty(user_id_for_post);
                        cl.show(northcon, "weleback");
                        cl.show(leftcon, "centerpanel");
                        cl.show(rightcont, "3");
                        // Perform actions after successful login   
                    } else if (verifyLoginadmin(user_id_for_post, password)) {
                        // Login successful
                        JOptionPane.showMessageDialog(null, "Successful Login", "", JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.showMessageDialog(leftPanel, "By we will miss you  Dear");
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
                JOptionPane.showMessageDialog(leftPanel, "By we will miss you  Dear");
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
                JOptionPane.showMessageDialog(leftPanel, "clicked");
                cl.show(rightcont, "manageadmin");
            }
        });
        buyrprofile4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(rightcont, "myaccount2");

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

    private void retriver(String pass) {
        proupdate.setLayout(new BoxLayout(proupdate, BoxLayout.Y_AXIS));
        initializeDatabase();
        try {
            String sql2 = "SELECT * FROM realpropforseller WHERE user_id='" + pass + "'";
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

            }
            resultSet2.close();
            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve for  update properties.");
        }
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

            }
            resultSet2.close();
            statement2.close();
        } catch (Exception es) {
            es.printStackTrace();
            JOptionPane.showMessageDialog(proupdate, "Error: Failed to retrieve for  update properties.");
        }
    }

    // DELETE FROM realpropforseller WHERE title = 'test forth';
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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            realproject form = new realproject();
            form.setVisible(true);
        });
    }
    

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}
