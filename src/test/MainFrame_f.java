package test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import static test.Floyd.FloydWarshall;

@SuppressWarnings("serial")
public class MainFrame_f extends JFrame implements ActionListener {
	private JPanel inputPanel_;
        private JPanel proceedPanel_;
        private JPanel submitPanel_;
	private JTextField textNode;
        private JTextField textEdge;
        private JTextField textSource;
        private JLabel lsource;
        private JLabel lNode;
        private JLabel lEdge;
	private JPanel buttonPanel_;
	String[] nameOfTheButtons = { "SUBMIT","BACK"};
        String[] name={"PROCEED"};
	int startingPoint = 53;

        
        
	
	private JButton button;
        private JButton button1;

	private JLabel head;
	int[] diskPosstion;
        int[] dp;
        int[] sp;
        
	int selected;
        public int source_node;
        public int nodes;

	
        private JTextField[] inputField_2;
        private JTextField[] inputField_;
        private JTextField[] inputField_1;
	private JScrollPane jScrollPane;
 
	public int numOfCyn;

	public MainFrame_f() {
		super("FLOYD WARSHALL ALGORITHM");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(600,700));
		setLocationRelativeTo(null);
		setVisible(true);
		addWindowListener(new ExitListener());
		setLayout(new FlowLayout());
		initComponents();
	}

	public void initComponents() {
		
                buttonPanel_ = new JPanel();
		buttonPanel_.setPreferredSize(new Dimension(600,50));
                
                submitPanel_ = new JPanel();
		submitPanel_.setPreferredSize(new Dimension(600,40));
                
                proceedPanel_ = new JPanel();
		proceedPanel_.setPreferredSize(new Dimension(600,50));

		inputPanel_ = new JPanel();
		inputPanel_.setBorder(new TitledBorder("Input"));
		inputPanel_.setPreferredSize(new Dimension(500, 400));

		textNode = new JTextField();
                textSource = new JTextField();
                textEdge = new JTextField();
                
                
                lNode = new JLabel();
                lsource = new JLabel();
                lEdge  = new JLabel();
                add(Box.createVerticalStrut(100));
		add(buttonPanel_);
                add(submitPanel_);
		add(inputPanel_);
                add(proceedPanel_);
                
		setButtonPanel();
                setSubmitPanel();
              
	}

	public void setInputPanel() {
		inputPanel_.removeAll();

		JPanel valuePanel = new JPanel();

		String n = textEdge.getText();
                numOfCyn = Integer.parseInt(n);
                
                
                String no = textNode.getText();
                nodes = Integer.parseInt(no); 
              
		valuePanel.setLayout(new GridLayout((numOfCyn*3), 2, 10, 10));

		inputField_ = new JTextField[numOfCyn];
                inputField_1= new JTextField[numOfCyn];
                inputField_2= new JTextField[numOfCyn];
                
                

		for (int i = 0; i < inputField_.length; i++) {
			JLabel label = new JLabel("Enter source (from) ["+i+"] : ");
			label.setFont(new Font("Vardana", Font.BOLD, 12));

			inputField_[i] = new JTextField(2);
			inputField_[i].setHorizontalAlignment(JTextField.CENTER);
                        //s[i] = inputField_[i].getText();
                        //edges[i].source = Integer.parseInt(s[i]);                        
                        
                        JLabel label1 = new JLabel("Enter destination (to) ["+i+"] : ");
			label.setFont(new Font("Vardana", Font.BOLD, 12));
                        
                        inputField_1[i] = new JTextField(2);
			inputField_1[i].setHorizontalAlignment(JTextField.CENTER);
                        //d[i] = inputField_[i].getText();
                        //edges[i].dest = Integer.parseInt(d[i]); 
                        
                        JLabel label2 = new JLabel("Enter the weight of corresponing edge ["+i+"] : ");
			label.setFont(new Font("Vardana", Font.BOLD, 12));

			inputField_2[i] = new JTextField(2);
			inputField_2[i].setHorizontalAlignment(JTextField.CENTER);
                        //w[i] = inputField_[i].getText();
                        //edges[i].weight = Integer.parseInt(w[i]); 
                        
			valuePanel.add(label);
			valuePanel.add(inputField_[i]);
                        valuePanel.add(label1);
                        valuePanel.add(inputField_1[i]); 
                        valuePanel.add(label2);
                        valuePanel.add(inputField_2[i]);
                        
                        
		}

		jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new java.awt.Dimension(450, 350));

		jScrollPane.setViewportView(valuePanel);
		jScrollPane.validate();
		inputPanel_.add(jScrollPane);
		inputPanel_.revalidate();
                setProceedPanel();
	}

	public void setButtonPanel() {
		
                buttonPanel_.setLayout(new FlowLayout());
                lNode.setText("No. of Nodes");
                buttonPanel_.add(Box.createVerticalStrut(40));
                buttonPanel_.add(lNode);
                                
                buttonPanel_.add(Box.createHorizontalStrut(10));
                
                textNode.setText("0");
                buttonPanel_.add(Box.createVerticalStrut(40));
                textNode.setPreferredSize(new Dimension(40,20));
                buttonPanel_.add(textNode);
                
                                            
                buttonPanel_.add(Box.createHorizontalStrut(40));
                
                
                lEdge.setText("No. of Edges");
                buttonPanel_.add(Box.createVerticalStrut(40));
                buttonPanel_.add(lEdge);
                
                
                buttonPanel_.add(Box.createHorizontalStrut(10));
                textEdge.setText("0");
                textEdge.setPreferredSize(new Dimension(40,20));
                buttonPanel_.add(Box.createVerticalStrut(40));
                buttonPanel_.add(textEdge);
         	buttonPanel_.revalidate();
               
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("SUBMIT")) {
			setInputPanel();
		}  
                else if(e.getActionCommand().equals("BACK")) {
			this.setVisible(false);
                        new NewJFrame_1().setVisible(true);
		}  
                
                else if(e.getActionCommand().equals("PROCEED")) {
			
                    /*String so = textSource.getText();
                    source_node = Integer.parseInt(so);*/
                
                
                Edge1 edges[] = new Edge1[numOfCyn];
                
                for( int i=0; i<numOfCyn; i++ )
                {  edges[i] = new Edge1();
                                }
                
                    for (int i = 0; i < numOfCyn; i++) {
				edges[i].source = Integer
						.parseInt(inputField_[i].getText());
                                
                                edges[i].dest = Integer
						.parseInt(inputField_1[i].getText());
                                
                                edges[i].weight = Integer
						.parseInt(inputField_2[i].getText());
                                
                               System.out.println(edges[i].source+" "+edges[i].dest+" "+edges[i].weight);
			}
                   for(int i=0;i<nodes;i++){ 
                   FloydWarshall(edges, numOfCyn,nodes,i);
                   }
                   this.setVisible(false);
		}  
                
                
        }

    private void setSubmitPanel() {
        submitPanel_.setLayout(new FlowLayout());

		for (int i = 0; i < nameOfTheButtons.length; i++) {
			button = new JButton(nameOfTheButtons[i]);
			button.addActionListener(this);
			// button.setName(nameOfTheButtons[i]);
			submitPanel_.add(button);
		}
    }

    public void setProceedPanel() {
        proceedPanel_.setLayout(new FlowLayout());
        
        /*lsource.setText("Enter the Source Node: ");
        proceedPanel_.add(lsource);
        
        buttonPanel_.add(Box.createHorizontalStrut(20));
        
        textSource.setText("0");
        textSource.setPreferredSize(new Dimension(40,20));
        proceedPanel_.add(textSource);
        
        proceedPanel_.add(Box.createHorizontalStrut(50));
        
        proceedPanel_.add(Box.createVerticalStrut(40));*/
		for (int i = 0; i < name.length; i++) {
			button1 = new JButton(name[i]);
			button1.addActionListener(this);
			// button.setName(nameOfTheButtons[i]);
                      
                        
			proceedPanel_.add(button1);
		}
    }
 
}
