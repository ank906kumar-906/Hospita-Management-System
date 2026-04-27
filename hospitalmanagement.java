import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DBConnection {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
        String user = "root";
        String password = "ankitlaptop";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful ");
            return connection;
        } catch (SQLException e) {
            System.out.println("Not connected ");
            System.out.println(e);
            return null;
        }
    }
}

class hospitalsys{
    public hospitalsys(){
        Frame frame=new Frame("HOSPITAL MANAGEMET");
        frame.setLayout(new BorderLayout());
        Panel innerPanel=new Panel(new FlowLayout());
        Panel maiPanel=new Panel(new GridLayout(5,1,100,30));
        
        Label label=new Label("HOSPITAL MANAGEMENT SYSTEM");
        Button b1=new Button("HR Login");
        Button b2=new Button("Patient Login");
        Button b3=new Button("Doctor Login");
         Button b4 =new Button("Registration");
        //card
        CardLayout card=new CardLayout();
        Panel cardPanel=new Panel();
        cardPanel.setLayout(card);

        innerPanel.add(maiPanel);   
        maiPanel.add(label);
        maiPanel.add(b1);
        maiPanel.add(b2);
        maiPanel.add(b3); 
        maiPanel.add(b4);

        // hr panel :)
        Panel hrPanel=new Panel(new BorderLayout());
        Panel hrouterpanel=new Panel(new FlowLayout());
        Panel mainhrpanel=new Panel(new GridLayout(7,1,10,10));
        Label label2=new Label("Hr Login");
        Label label3=new Label("Entre User ID");
        TextField textField=new TextField();
        Label label4=new Label("Entre Password");
        TextField textField2=new TextField();


        Button hrlogin=new Button("Login");
        Button hrbutton=new Button("Back");

        hrPanel.add(hrouterpanel,BorderLayout.CENTER);
        hrouterpanel.add(mainhrpanel);
        mainhrpanel.add(label2);
        mainhrpanel.add(label3);
        mainhrpanel.add(textField);
        mainhrpanel.add(label4);
        mainhrpanel.add(textField2);
        mainhrpanel.add(hrlogin);
        mainhrpanel.add(hrbutton);

        //patient panel :)
        Panel patientPanel=new Panel(new BorderLayout());
        Panel patientouterPanel=new Panel(new FlowLayout());
        Panel patientinnPanel=new Panel(new GridLayout(7,1,10,10));

        Label plabel2=new Label("Patient Login");
        Label plabel3=new Label("Entre Patient Name");
        TextField ptextField=new TextField();
        Label plabel4=new Label("Entre Age");
        TextField ptextField2=new TextField();

        Button plogin=new Button("Login");
        Button pbutton=new Button("Back");

        patientPanel.add(patientouterPanel,BorderLayout.CENTER);
        patientouterPanel.add(patientinnPanel);
        patientinnPanel.add(plabel2);
        patientinnPanel.add(plabel3);
        patientinnPanel.add(ptextField);
        patientinnPanel.add(plabel4);
        patientinnPanel.add(ptextField2);
        patientinnPanel.add(plogin);
        patientinnPanel.add(pbutton);


        //doctor panel :)
         Panel doctorPanel=new Panel(new BorderLayout());
        Panel doctorouterpanel=new Panel(new FlowLayout());
        Panel maindoctorpanel=new Panel(new GridLayout(7,1,10,10));
        Label dlabel2=new Label("Doctor Login");
        Label dlabel3=new Label("Doctor ID");
        TextField dtextField=new TextField();
        Label dlabel4=new Label("Doctor Name");
        TextField dtextField2=new TextField();


        Button dlogin=new Button("Login");
        Button dbutton=new Button("Back");

        doctorPanel.add(doctorouterpanel,BorderLayout.CENTER);
        doctorouterpanel.add(maindoctorpanel);
        maindoctorpanel.add(dlabel2);
        maindoctorpanel.add(dlabel3);
        maindoctorpanel.add(dtextField);
        maindoctorpanel.add(dlabel4);
        maindoctorpanel.add(dtextField2);
        maindoctorpanel.add(dlogin);
        maindoctorpanel.add(dbutton);

        //registration panel :)
        Label regislLabel=new Label("Registration Page");
        Panel registrPanel=new Panel(new BorderLayout());
        Panel outregistrationPanel=new Panel(new FlowLayout());
        Panel innerregistrationpPanel=new Panel(new GridLayout(4,1,100,30));

        Button Rb1=new Button("HR Regis...");
        Button Rb2=new Button("Patient Regis...");
        Button Rb4=new Button("Back");

        registrPanel.add(outregistrationPanel,BorderLayout.CENTER);
        outregistrationPanel.add(innerregistrationpPanel);
        innerregistrationpPanel.add(regislLabel);
        innerregistrationpPanel.add(Rb1);
        innerregistrationpPanel.add(Rb2);
        innerregistrationpPanel.add(Rb4);

        //add to card
        cardPanel.add(innerPanel,"menu");
        cardPanel.add(hrPanel,"HR");
        cardPanel.add(patientPanel,"Patient");
        cardPanel.add(doctorPanel,"doctor");
        cardPanel.add(registrPanel,"register");

        //action listener for registration
        Rb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new hrregistration();
                frame.dispose();
            }
        });

        Rb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new paregistration();
                frame.dispose();
            }
        });

        //action listoner
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"HR");
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"Patient");
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"doctor");
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"register");
            }
        });

        Rb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"menu");
            }
        });

        hrbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel, "menu");
            }
        });

        pbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel, "menu");
            }
        });

        dbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel, "menu");
            }
        });

        frame.add(cardPanel, BorderLayout.CENTER);
        frame.setSize(400, 300);
        

        hrlogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){

        String user = textField.getText();
        String pass = textField2.getText();

        try {
            Connection con = DBConnection.getConnection();
            if(con == null){
            System.out.println("Database not connected ❌");
            return;
            }

            String query = "SELECT * FROM hr WHERE name=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, user);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Login Success ✅");
                new HR();
                frame.dispose();
            } else {
                System.out.println("Invalid ID or Password ❌");
            }
            rs.close();
            pst.close();
            con.close();

        } catch(Exception ex){
            System.out.println(ex);
        }
    }
});

        //paitient login
        plogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String user= ptextField.getText();
                String pass= ptextField2.getText();

                try {
                    Connection con=DBConnection.getConnection();
                    if(con==null){
                        System.out.println("databass not connected");
                        return;
                    }
                    String query="SELECT * FROM patient WHERE name=? AND password=?";
                    PreparedStatement pst= con.prepareStatement(query);
                    pst.setString(1, user);
                    pst.setString(2, pass);

                   ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                        System.out.println("login");
                        new patientdasbord(user, pass);
                        frame.dispose();
                    }else{
                        System.out.println("invalid id");
                    }

                     rs.close();
                     pst.close();
                     con.close();
                } catch (Exception ep) {
                    System.out.println(ep);
                }

            }
        });
        
    dlogin.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        String idText = dtextField.getText();
        String name = dtextField2.getText();

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                System.out.println("Database not connected");
                return;
            }

            int id = Integer.parseInt(idText);

            String query = "SELECT * FROM doctorinfo WHERE id=? AND name=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, name);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                // VALID LOGIN → open doctor panel
                System.out.println("Login Success ");
                new doctor(id, name);
                frame.dispose();
            } else {
                System.out.println("Invalid Doctor ID or Name ");
            }

            rs.close();
            pst.close();
            con.close();

        } catch(NumberFormatException ex){
            System.out.println("Doctor ID must be number ");
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
});
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        }
}


class hrregistration{
    public hrregistration(){
        Frame frame=new Frame();
        frame.setLayout(new BorderLayout());
        Panel outerpanel=new Panel(new FlowLayout());
        Panel innerpanel=new Panel(new GridLayout(7,1,10,10));

        Label label=new Label("HR Registration");
        Label labelname=new Label("Entre HR Name");
        TextField registField=new TextField();
        Label labelpass=new Label("set password");
        TextField registField1=new TextField();
        Button regisButton=new Button("CREATE");
        Button regisButton1=new Button("login page");

        frame.add(outerpanel,BorderLayout.CENTER);
        outerpanel.add(innerpanel);
        innerpanel.add(label);
        innerpanel.add(labelname);
        innerpanel.add(registField);
        innerpanel.add(labelpass);
        innerpanel.add(registField1);
        innerpanel.add(regisButton);
        innerpanel.add(regisButton1);
        

        regisButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name = registField.getText();
        String pass = registField1.getText();

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                System.out.println("Database not connected ");
                return;
            }

            String query = "INSERT INTO hr (name, password) VALUES (?, ?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, pass);
            int rows = pst.executeUpdate();

            if(rows > 0){
                System.out.println("HR Registered Successfully");
                regisButton.setEnabled(false);

            } else {
                System.out.println("Registration Failed ");
            }

            pst.close();
            con.close();

        } catch(Exception ex){
            System.out.println(ex);
        }
                
            }
        });

       regisButton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            new hospitalsys();
            frame.dispose();
        }
       });

        frame.setVisible(true);
         frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });



    }
}

class paregistration{
    public paregistration(){

        Frame frame=new Frame();
        frame.setLayout(new BorderLayout());
        Panel outerpanel=new Panel(new FlowLayout());
        Panel innerpanel=new Panel(new GridLayout(7,1,10,10));

        Label label=new Label("Patient Registration");
        Label labelname=new Label("Entre Patient Name");
        TextField registField=new TextField();
        Label labelpass=new Label("age");
        TextField registField1=new TextField();
        Button regisButton=new Button("CREATE");
        Button regisButton1=new Button("login page");

        frame.add(outerpanel,BorderLayout.CENTER);
        outerpanel.add(innerpanel);
        innerpanel.add(label);
        innerpanel.add(labelname);
        innerpanel.add(registField);
        innerpanel.add(labelpass);
        innerpanel.add(registField1);
        innerpanel.add(regisButton);
        innerpanel.add(regisButton1);
        

        regisButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name = registField.getText();
        String pass = registField1.getText();

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                System.out.println("Database not connected ");
                return;
            }

            String query = "INSERT INTO patient (name, password) VALUES (?, ?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, pass);
            int rows = pst.executeUpdate();

            if(rows > 0){
                System.out.println("patient Registered Successfully");
                regisButton.setEnabled(false);

            } else {
                System.out.println("Registration Failed");
            }

            pst.close();
            con.close();

        } catch(Exception ex){
            System.out.println(ex);
        }
                
            }
        });
        regisButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new hospitalsys();
                frame.dispose();
            }
        });

        frame.setVisible(true);
         frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

    }
}

class HR{
    public HR(){
        Frame frame=new Frame("Hr");
        frame.setLayout(new BorderLayout());

        // card
        CardLayout card=new CardLayout();
        Panel cardPanel=new Panel();
        cardPanel.setLayout(card);

         //default panel
        Panel defaultpPanel=new Panel();
        defaultpPanel.add(new Label("Hr Dashboard"));

        //1.card)panel for search doctor list 
        Panel sdouterpPanel=new Panel();
        sdouterpPanel.setLayout(new FlowLayout());
        sdouterpPanel.setBackground(Color.yellow);
        Panel sdinnerpanel=new Panel(new GridLayout(5, 1, 10, 10));
        sdinnerpanel.setBackground(Color.yellow);
        TextArea listtextarea=new TextArea();


        //add to search doctor 
        sdouterpPanel.add(sdinnerpanel);
        sdinnerpanel.add(listtextarea);
        


        //.card) panel for update doctor 
        Panel udouterPanel=new Panel();
        udouterPanel.setLayout(new FlowLayout());
        udouterPanel.setBackground(Color.yellow);
        Panel udinnerpanel=new Panel(new GridLayout(9,1,10,10));

        Label udLabel=new Label("Entre name");
        TextField udteTextField=new TextField();
        Label udLabel1=new Label("id");
        TextField udteTextField2=new TextField();
        Label udLabel2=new Label("Salary");
        TextField udTextField3=new TextField();
        Label udLabel3=new Label("Education");
        TextField udTextField4=new TextField();

        Button udButton=new Button("Update");

        udouterPanel.add(udinnerpanel);
        udinnerpanel.add(udLabel);
        udinnerpanel.add(udteTextField);
        udinnerpanel.add(udLabel1);
        udinnerpanel.add(udteTextField2);
        udinnerpanel.add(udLabel3);
        udinnerpanel.add(udTextField4);
        udinnerpanel.add(udLabel2);
        udinnerpanel.add(udTextField3);
        udinnerpanel.add(udButton);


        //panel for west
        Panel panelwest=new Panel();
        panelwest.setLayout(new GridLayout(7, 1, 10, 10));
        

        Button b1=new Button("Show Doctor List");
        Button b2=new Button("Remove Doctor");
        Button b3=new Button("Update Doctor");
        Button b4=new Button("Manage Medicines");
        Button b5=new Button("Staff Records");
        Button b6=new Button("Logout");
        

        panelwest.setBackground(Color.cyan);
        Label label=new Label("Management Panel");

         //add
        frame.add(cardPanel,BorderLayout.CENTER);
        frame.add(panelwest,BorderLayout.WEST);
        panelwest.add(label);
        panelwest.add(b1);
        panelwest.add(b2);
        panelwest.add(b3);
        panelwest.add(b4);
        panelwest.add(b5);
        panelwest.add(b6);

        //2.card)panel for  remove doctor
        Panel outerPanel=new Panel();
        outerPanel.setLayout(new FlowLayout());
        outerPanel.setBackground(Color.green);
        Panel innerPanel=new Panel(new GridLayout(6, 1, 10, 10));
        innerPanel.setBackground(Color.green);
        Label mLabel=new Label("Entre Doctor Name");
        TextField mTextField=new TextField();
        Label mLabel2=new Label("Entre Doctor ID");
        TextField mTextField2=new TextField();
        Button mb1=new Button("remove doctor");


        outerPanel.add(innerPanel);
        innerPanel.add(mLabel);
        innerPanel.add(mTextField);
        innerPanel.add(mLabel2);
        innerPanel.add(mTextField2);
        innerPanel.add(mb1);


        // 4.card) medicine list

        Panel ddouterPanel=new Panel();
        ddouterPanel.setBackground(Color.green);
        ddouterPanel.setLayout(new FlowLayout());
        Panel ddinerPanel=new Panel(new GridLayout(2,1,10,30));
        Label ddLabel=new Label("medicine list");
        TextArea ddtextarea=new TextArea();

    
        //card 4 add
        ddouterPanel.add(ddinerPanel,BorderLayout.CENTER);
        ddinerPanel.add(ddLabel);
        ddinerPanel.add(ddtextarea);

         // 5.card) staff list

        Panel slouterPanel=new Panel();
        slouterPanel.setBackground(Color.yellow);
        ddouterPanel.setLayout(new FlowLayout());
        Panel slinerPanel=new Panel(new GridLayout(2,1,10,10));
        Label slLabel=new Label("medicine list");
        TextArea sltextarea=new TextArea();

    
        //card 4 add
        slouterPanel.add(slinerPanel,BorderLayout.CENTER);
        slinerPanel.add(slLabel);
        slinerPanel.add(sltextarea);


        


        //add to card
        cardPanel.add(defaultpPanel,"menu");
        cardPanel.add(sdouterpPanel,"doctor list");
        cardPanel.add(outerPanel,"remove doctor");
        cardPanel.add(udouterPanel,"Update Doctor");
        cardPanel.add(ddouterPanel,"medicine list");
        cardPanel.add(slouterPanel,"staff list");


    
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.toFront();
        frame.requestFocus();

        //action performed
       b1.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e){

        card.show(cardPanel, "doctor list");
        listtextarea.setText("");

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                listtextarea.setText("Database not connected");
                return;
            }

            String query = "SELECT * FROM doctorinfo";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            listtextarea.append("ID\tName\tEducation\tWorkExp\tSalary\n");
            listtextarea.append("-------------------------------------------------------\n");

            while (rs.next()) {
                int id = rs.getInt("id"); // NEW
                String name = rs.getString("name");
                String edu = rs.getString("education");
                int year = rs.getInt("workyear");
                int salary = rs.getInt("salary");

                listtextarea.append(id + "\t" + name + "\t" + edu + "\t\t" + year + "\t\t" + salary + "\n");
            }

            con.close();

        } catch (Exception ex) {
            listtextarea.setText("Error: " + ex);
        }
    }
});

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                 card.show(cardPanel,"remove doctor");
            }
        });

       mb1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        String name = mTextField.getText();
        String idText = mTextField2.getText();

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                System.out.println("Database not connected ");
                return;
            }

            int id = Integer.parseInt(idText); // convert to int

            String query = "DELETE FROM doctorinfo WHERE id=? AND name=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, name);

            int rows = pst.executeUpdate();

            if(rows > 0){
                System.out.println("Doctor removed successfully ");

                // clear fields
                mTextField.setText("");
                mTextField2.setText("");

            } else {
                System.out.println("Doctor not found ");
            }

            pst.close();
            con.close();

        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
});

         b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"Update Doctor");
            }
        });

       udButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        String name = udteTextField.getText();
        String idText = udteTextField2.getText();
        String salaryText = udTextField3.getText();
        String education = udTextField4.getText();

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                System.out.println("Database not connected ");
                return;
            }

            int id = Integer.parseInt(idText);
            double salary = Double.parseDouble(salaryText);

            String query = "INSERT INTO doctorinfo (id, name, salary, education) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setDouble(3, salary);
            pst.setString(4, education);

            int rows = pst.executeUpdate();

            if(rows > 0){
                System.out.println("Doctor added successfully ");

                // clear fields
                udteTextField.setText("");
                udteTextField2.setText("");
                udTextField3.setText("");
                udTextField4.setText("");
            } else {
                System.out.println("Insert failed ");
            }

            pst.close();
            con.close();

        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
});
      
        b4.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        card.show(cardPanel,"medicine list");

        ddtextarea.setText("");

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                ddtextarea.setText("Database not connected");
                return;
            }

            String query = "SELECT * FROM medicine";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ddtextarea.append("Name\tPower\tQuantity\n");
            ddtextarea.append("-----------------------------------\n");

            while(rs.next()){
                String name = rs.getString("name");
                String power = rs.getString("power");
                String quantity = rs.getString("quantity");

                ddtextarea.append(name + "\t" + power + "\t" + quantity + "\n");
            }

            con.close();

        } catch(Exception ex){
            ddtextarea.setText("Error: " + ex);
        }
    }
});

b6.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        new hospitalsys();
        frame.dispose();
    }
});

b5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        card.show(cardPanel, "staff list");

        sltextarea.setText("");

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                sltextarea.setText("Database not connected");
                return;
            }

            String query = "SELECT * FROM staffrecord";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            sltextarea.append("Name\tAge\tSalary\n");
            sltextarea.append("----------------------------------\n");

            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                float salary = rs.getFloat("salary");

                sltextarea.append(name + "\t" + age + "\t" + salary + "\n");
            }

            con.close();

        } catch(Exception ex){
            sltextarea.setText("Error: " + ex);
        }
    }
});

       
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

    }
}

class patientdasbord{
    String currentName;
    String currentAge;
    public patientdasbord(String name, String age){
        this.currentName = name;
        this.currentAge = age;
        Frame patientframe=new Frame();
        patientframe.setLayout(new BorderLayout());
        Panel wPanel=new Panel(new GridLayout(5,1,10,10));

    
        //west part
        Label wLabel=new Label("Patient Dashboard");
        Button b1=new Button("View Appointment");
        Button b2=new Button("Cancel Appointment");
        Button b3=new Button("TAKE Appointment");
        Button b4=new Button("Logout");


          patientframe.add(wPanel,BorderLayout.WEST);
          patientframe.setBackground(Color.cyan);
          wPanel.add(wLabel);
          wPanel.add(b1);
          wPanel.add(b2);
          wPanel.add(b3);
          wPanel.add(b4);

          // cardlayout

          CardLayout card=new CardLayout();
          Panel cardPanel=new Panel();
          cardPanel.setLayout(card);

          Panel defaultpanel=new Panel();
          defaultpanel.add(new Label("Patient information"));
          defaultpanel.setBackground(Color.green);

          //1.card)View Appointment
          Panel pdouterPanel=new Panel(new FlowLayout());
          pdouterPanel.setBackground(Color.YELLOW);
          Panel pdinnerPanel=new Panel(new GridLayout(2,1,10,10));

          Label pdLabel=new Label("Details of Patient");
          TextArea pdTextArea=new TextArea();

          pdouterPanel.add(pdinnerPanel);
          pdinnerPanel.add(pdLabel);
          pdinnerPanel.add(pdTextArea);

          // 2.card)Cancel Appointment
          Panel vaouterPanel=new Panel(new FlowLayout());
          vaouterPanel.setBackground(Color.gray);
          Panel vainnerPanel=new Panel(new GridLayout(6,1,10,10));
          vainnerPanel.setBackground(Color.gray);

          Label label1=new Label("Cancel Appointment");
          Label vaLabel=new Label("Patient Name");
          TextField vatextfield=new TextField();
          Label vaLabel2=new Label("Patient Age");
          TextField vaextfield1=new TextField();
          Button vaButton=new Button("Click");

          vaouterPanel.add(vainnerPanel);
          vainnerPanel.add(label1);
          vainnerPanel.add(vaLabel);
          vainnerPanel.add(vatextfield);
          vainnerPanel.add(vaLabel2);
          vainnerPanel.add(vaextfield1);
          vainnerPanel.add(vaButton);


          //3.card)add appointment
           Panel caouterPanel=new Panel(new FlowLayout());
           caouterPanel.setBackground(Color.green);
          Panel cainnerPanel=new Panel(new GridLayout(8,1,10,10));
           
          Label label=new Label("Take appointment");
          Label caLabel=new Label("Patient Name");
          TextField catextfield=new TextField();
          Label caLabel2=new Label("Patient Age");
          TextField caextfield1=new TextField();
          Label calaLabel3=new Label("Disease");
          TextField caextfield2=new TextField();
          Button caButton=new Button("Click");

          caouterPanel.add(cainnerPanel);
          cainnerPanel.add(label);
          cainnerPanel.add(caLabel);
          cainnerPanel.add(catextfield);
          cainnerPanel.add(caLabel2);
          cainnerPanel.add(caextfield1);
          cainnerPanel.add(calaLabel3);
          cainnerPanel.add(caextfield2);
          cainnerPanel.add(caButton);


          //4.card)Logout
          Panel laouterPanel=new Panel(new FlowLayout());
          Panel lainnerPanel=new Panel(new GridLayout(2,1,10,10));
          Label label2=new Label("THANKS FOR USING THIS website");
          Button laButton=new Button("Lougout!");

          laouterPanel.add(lainnerPanel);
          lainnerPanel.add(label2);
          lainnerPanel.add(laButton);

          //card add
          patientframe.add(cardPanel,BorderLayout.CENTER);

          cardPanel.add(defaultpanel,"main");
          cardPanel.add(pdouterPanel,"View Appointment");
          cardPanel.add(vaouterPanel,"Cancel Appointment");
          cardPanel.add(caouterPanel,"add apointment");
          cardPanel.add(laouterPanel,"Logout");

          //action part
         b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        card.show(cardPanel,"View Appointment");
        pdTextArea.setText("");

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                pdTextArea.setText("Database not connected");
                return;
            }

            String query = "SELECT * FROM patientappointment WHERE name=? AND age=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, currentName);
            pst.setInt(2, Integer.parseInt(currentAge));

            ResultSet rs = pst.executeQuery();

            pdTextArea.append("Name\tAge\tDisease\t\tDate\n");
            pdTextArea.append("-------------------------------------------------\n");

            boolean found = false;

            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String disease = rs.getString("Diseases");
                String date = rs.getString("date");

                pdTextArea.append(
                    name + "\t" + age + "\t" + disease + "\t\t" + date + "\n"
                );
                found = true;
            }

            if(!found){
                pdTextArea.setText("No appointment found ");
            }

            rs.close();
            pst.close();
            con.close();

        } catch(Exception ex){
            pdTextArea.setText("Error: " + ex);
        }
    }
});

          b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"Cancel Appointment");
            }
          });
          
           b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"add apointment");
            }
          });

           b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardPanel,"Logout");
            }
          });

          laButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new hospitalsys();
                patientframe.dispose();
            }
          });
      

       

          
caButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        String name = catextfield.getText();
        String ageText = caextfield1.getText();
        String disease = caextfield2.getText();

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                System.out.println("Database not connected ");
                return;
            }

            int age = Integer.parseInt(ageText);

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String currentDate = sdf.format(new java.util.Date());

            String query = "INSERT INTO patientappointment (name, age, date, Diseases) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, currentDate);
            pst.setString(4, disease);

            int rows = pst.executeUpdate();

            if(rows > 0){
                System.out.println("Appointment added successfully ");

                catextfield.setText("");
                caextfield1.setText("");
                caextfield2.setText("");
                caButton.setEnabled(false);

            } else {
                System.out.println("Insert failed ");
            }

            pst.close();
            con.close();

        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
});

vaButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        String name = vatextfield.getText();
        String ageText = vaextfield1.getText();

        if(name.equals("") || ageText.equals("")){
            System.out.println("Please enter all details ");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                System.out.println("Database not connected ");
                return;
            }

            int age = Integer.parseInt(ageText);

            String query = "DELETE FROM patientappointment WHERE name=? AND age=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, age);

            int rows = pst.executeUpdate();

            if(rows > 0){
                System.out.println("Appointment cancelled successfully ");

                // clear fields
                vatextfield.setText("");
                vaextfield1.setText("");
                vaButton.setEnabled(false);

            } else {
                System.out.println("No matching appointment found ");
            }

            pst.close();
            con.close();

        } catch(NumberFormatException ex){
            System.out.println("Age must be a number ");
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
});
        patientframe.setSize(600, 400);
        patientframe.setLocationRelativeTo(null);
        patientframe.setVisible(true);
        patientframe.toFront();
        patientframe.requestFocus();
        patientframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}



class doctor{
    int currentDoctorId;
    String currentDoctorName;
    
    public doctor(int id,String name){
        this.currentDoctorId=id;
        this.currentDoctorName=name;
        Frame doctorframe=new Frame("Doctor panale");
        doctorframe.setLayout(new BorderLayout());
        Panel doctorinerPanel=new Panel(new GridLayout(5,1,10,10));


        //add to west pannel
        Label doctorLabel=new Label("DOCTOR Dashboard");
        Button b1=new Button("Today Appointments");
        Button b3=new Button("Prescription");
        Button b4=new Button("Patient Records");
        Button b5=new Button("Profile");

        doctorframe.add(doctorinerPanel, BorderLayout.WEST);
        doctorframe.setBackground(Color.cyan);
        doctorinerPanel.add(doctorLabel);
        doctorinerPanel.add(b1);
        doctorinerPanel.add(b3);
        doctorinerPanel.add(b4);
        doctorinerPanel.add(b5);

        //card form
        CardLayout card=new CardLayout();
        Panel cardpanel=new Panel();
        cardpanel.setLayout(card);
    
        //dummy panel
        Panel dummypanel=new Panel();
        dummypanel.add(new Label("welcome"));

        //1.card)Appointments
        Panel outerpanel=new Panel(new FlowLayout());
        outerpanel.setBackground(Color.green);
        Panel inerPanel=new Panel(new GridLayout(3,1,10,10));

        Label appointLabel=new Label("Appointment list");
        TextArea appoinTextArea=new TextArea();
        Button appointButton=new Button("refresh");

       outerpanel.add(inerPanel);
       inerPanel.add(appointLabel);
       inerPanel.add(appoinTextArea);
       inerPanel.add(appointButton);

        //3.card)Prescription
        Panel presOuter = new Panel(new FlowLayout());
        presOuter.setBackground(Color.yellow);
        Panel presInner = new Panel(new GridLayout(3,1,10,10));

        Label presLabel = new Label("Prescription");
        TextArea presArea = new TextArea();
        Button presBtn = new Button("Load");

        presOuter.add(presInner);
        presInner.add(presLabel);
        presInner.add(presArea);
        presInner.add(presBtn);

        //4.card)Records
        Panel recOuter = new Panel(new FlowLayout());
        recOuter.setBackground(Color.green);
        Panel recInner = new Panel(new GridLayout(3,1,10,10));

        Label recLabel = new Label("Patient Records");
        TextArea recArea = new TextArea();
        Button recBtn = new Button("Load");

        recOuter.add(recInner);
        recInner.add(recLabel);
        recInner.add(recBtn);
        recInner.add(recArea);

        //5.card)profit
        Panel prouterPanel=new Panel(new FlowLayout());
        prouterPanel.setBackground(Color.yellow);
        Panel prinnerPanel=new Panel(new GridLayout(3,1,10,10));

        Label prlLabel=new Label("MY profile");
        TextArea pTextArea=new TextArea();
        Button logoutButton=new Button("logout");
        prouterPanel.add(prinnerPanel);
        prinnerPanel.add(prlLabel);
        prinnerPanel.add(pTextArea);
        prinnerPanel.add(logoutButton);

        //add to card
        cardpanel.add(dummypanel,"dummy");
        cardpanel.add(outerpanel,"Appointment");
        cardpanel.add(presOuter,"Prescription");
        cardpanel.add(recOuter,"Records");
        cardpanel.add(prouterPanel,"profile");

        //actionevent
       doctorframe.add(cardpanel,BorderLayout.CENTER);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardpanel,"Appointment");
            }
        });

         b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardpanel,"Prescription");
            }
        });

         b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(cardpanel,"Records");
            }
        });

       b5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        card.show(cardpanel, "profile");

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT name, education, workyear FROM doctorinfo WHERE id=? AND name=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, currentDoctorId);
            pst.setString(2, currentDoctorName);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                String name = rs.getString("name");
                String education = rs.getString("education");
                int experience = rs.getInt("workyear");

                pTextArea.setText(
                    "----- Doctor Profile -----\n\n" +
                    "Name: " + name + "\n" +
                    "Education: " + education + "\n" +
                    "Experience: " + experience + " years"
                );

            } else {
                pTextArea.setText("No profile found for this login");
            }

            rs.close();
            pst.close();
            con.close();

        } catch(Exception ex){
            pTextArea.setText("Error: " + ex);
        }
    }
});
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new hospitalsys();
                doctorframe.dispose();
            }
        });

        appointButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){

        appoinTextArea.setText("");

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                appoinTextArea.setText("Database not connected ");
                return;
            }

            String query = "SELECT * FROM patientappointment WHERE date = CURDATE()";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            appoinTextArea.append("Name\tAge\tDisease\t\tDate\n");
            appoinTextArea.append("-------------------------------------------------\n");

            boolean found = false;

            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String disease = rs.getString("Diseases");
                String date = rs.getString("date");

                appoinTextArea.append(
                    name + "\t" + age + "\t" + disease + "\t\t" + date + "\n"
                );
                found = true;
            }

            if(!found){
                appoinTextArea.setText("No appointments for today ");
            }

            rs.close();
            st.close();
            con.close();

        } catch(Exception ex){
            appoinTextArea.setText("Error: " + ex);
        }
    }
});



recBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        recArea.setText("");

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                recArea.setText("Database not connected ");
                return;
            }

            String query = "SELECT * FROM patientappointment";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            recArea.append("Name\tAge\tDisease\t\tMedicine\tDate\n");
            recArea.append("-------------------------------------------------------------\n");

            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String disease = rs.getString("Diseases");
                String medicine = rs.getString("medicine");
                String date = rs.getString("date");

                recArea.append(
                    name + "\t" + age + "\t" + disease + "\t\t" + medicine + "\t" + date + "\n"
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch(Exception ex){
            recArea.setText("Error: " + ex);
        }
    }
});

presBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

        presArea.setText("");

        try {
            Connection con = DBConnection.getConnection();

            if(con == null){
                presArea.setText("Database not connected ");
                return;
            }

            String query = "SELECT name, Diseases, medicine FROM patientappointment";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            presArea.append("Name\tDisease\t\tMedicine\n");
            presArea.append("-----------------------------------------\n");

            while(rs.next()){
                String name = rs.getString("name");
                String disease = rs.getString("Diseases");
                String medicine = rs.getString("medicine");

                presArea.append(name + "\t" + disease + "\t\t" + medicine + "\n");
            }

            rs.close();
            st.close();
            con.close();

        } catch(Exception ex){
            presArea.setText("Error: " + ex);
        }
    }
});

        doctorframe.setSize(600, 400);
        doctorframe.setLocationRelativeTo(null);
        doctorframe.setVisible(true);
        doctorframe.toFront();
        doctorframe.requestFocus();
        doctorframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}

public class hospitalmanagement {
public static void main(String[] args) {
    hospitalsys obj=new hospitalsys();
    }
}