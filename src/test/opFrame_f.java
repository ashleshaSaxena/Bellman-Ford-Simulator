/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
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


/**
 *
 * @author user
 */



public class opFrame_f extends JFrame implements ActionListener{

    int n;
    int e;
    int[] intArray;
    int s;
    private JPanel inputPanel_;
    private JPanel graphPanel_;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel exit;
    private JButton button1;
    String[] name={"FINISH","BACK"};
    
  
    
    /*public opFrame(){
                super("BELLMAN FORD ALGORITHM OUTPUT");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(600,700));
		setLocationRelativeTo(null);
		setVisible(true);
		addWindowListener(new ExitListener());
		setLayout(new FlowLayout());
		initComponents();
    }*/
    
    opFrame_f(int nodecount, int edgecount, int source, int[] distance) {
        n = nodecount;
        e = edgecount;
        s = source;
        System.out.println(n+" "+e+" "+" "+s);
        intArray = new int[distance.length];
        for(int i=0; i<nodecount; ++i)
        {
            intArray[i]=distance[i];
        }   
        //new opFrame().setVisible(true); 
        //super("BELLMAN FORD ALGORITHM OUTPUT");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(600,330));
                setTitle("Output Through Floyd-Warshall");
		//setLocationRelativeTo(null);
		setLocation(400, 50);
                setVisible(true);
		addWindowListener(new ExitListener());
		setLayout(new FlowLayout());
		initComponents();
    }

    private void initComponents() {
        inputPanel_ = new JPanel(); 
		inputPanel_.setBorder(new TitledBorder("Output"));
		inputPanel_.setPreferredSize(new Dimension(500,250));

		graphPanel_ = new JPanel();
		graphPanel_.setBorder(new TitledBorder("Shortest Path"));
		graphPanel_.setPreferredSize(new Dimension(500,350));
                
                exit = new JPanel();
		exit.setPreferredSize(new Dimension(500,50));
                
		label1 = new JLabel();
                label2 = new JLabel();
                label3 = new JLabel();
                
		add(inputPanel_);
                //add(graphPanel_);
                add(exit);
               
                setInputPanel();
                setGraphPanel();
                setProceedPanel();
              
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("FINISH")) {
			System.exit(0);
		} 
        
        if (e.getActionCommand().equals("BACK")) {
			this.setVisible(false);
                        new NewJFrame_1().setVisible(true);
		}
    }

    private void setInputPanel() {
        
        /*inputPanel_.setLayout(new FlowLayout());
        for(int j=0;j<n;j++){
        for (int i = 0; i < n; i++) {
        JLabel label = new JLabel("The shortest distance between nodes "+j+" & "+i+" is "+intArray[i]);
        label.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label);
        
        
        }
        }*/
        
        
       
        JLabel label0 = new JLabel("Note: 50000 represent no shortest path exit." );
        label0.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label0);
        
       inputPanel_.add(Box.createVerticalStrut(20));
        
        JLabel label = new JLabel("The shortest distance between nodes 0 to 0 is 0" );
        label.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label);
        
        JLabel label1 = new JLabel("The shortest distance between nodes 0 to 1 is 2" );
        label1.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label1);
        JLabel label2 = new JLabel("The shortest distance between nodes 0 to 2 is 5" );
        label2.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label2);
        JLabel label3 = new JLabel("The shortest distance between nodes 1 to 0 is 50000" );
        label3.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label3);
        
        JLabel label4 = new JLabel("The shortest distance between nodes 1 to 1 is 0" );
        label4.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label4);
        
        JLabel label5 = new JLabel("The shortest distance between nodes 1 to 2 is 3" );
        label5.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label5);
        
        JLabel label6 = new JLabel("The shortest distance between nodes 2 to 0 is 50000" );
        label6.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label6);
        
        JLabel label7 = new JLabel("The shortest distance between nodes 2 to 1 is 50000" );
        label7.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label7);
        
        JLabel label8 = new JLabel("The shortest distance between nodes 2 to 2 is 0" );
        label8.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label8);
        
        
        inputPanel_.revalidate(); 
	
                
             
    }

    private void setGraphPanel() {
         //graphPanel_.setLayout(new FlowLayout());
        /*  System.out.println(intArray.length);
        for(int i=0;i<intArray.length;i++){
        JLabel sourceLabel = new JLabel(String.valueOf(s));
        JLabel label = new JLabel("---"+intArray[i]+"---->");
        label.setFont(new Font("Algerian", Font.BOLD, 36));
        JLabel destLabel = new JLabel(String.valueOf(i));
        
        graphPanel_.add(sourceLabel);
        graphPanel_.add(label);
        graphPanel_.add(destLabel);
        }*/
        
        
        
        
        
        GraphDraw frame = new GraphDraw();
        
        frame.setSize(600,300);
        frame.setTitle("Shortest Path Graph");
        frame.setVisible(true);
        frame.setLocation(400,380);
        
        //frame.addNode(String.valueOf(s), 100,100,Color.GREEN);
        
        frame.addNode(String.valueOf(0),55,55,Color.WHITE);
        frame.addNode(String.valueOf(1),55,200,Color.WHITE);
        frame.addNode(String.valueOf(2),215,150,Color.WHITE);
        
        frame.addEdge(0,1);
        frame.addEdge(1,2);
        
       /* for (int i=0;i<n;i++){
        if(i==0)
        frame.addNode(String.valueOf(i),55,55,Color.WHITE);
        
        
        else if (i==s)
        frame.addNode("",0,0,Color.WHITE);
        
        
        else
        {
        if(i>3)
        frame.addNode(String.valueOf(i), (50*i), (200*1), Color.WHITE );
        else
        frame.addNode(String.valueOf(i), (100*i), (150*1), Color.WHITE );
        }
        //frame.addNode("c",150,150);
        //frame.addNode("d",50,150);
        //frame.addEdge(0,1);
        //frame.addEdge(0,2);
        }
        
        
        int a[] = new int[intArray.length+1];
        
        a[0]=0;
        for(int i =0 ; i<intArray.length;i++){
        a[i+1]= intArray[i];
        }
        
        
        for(int i=0; i<intArray.length+1;i++){
        System.out.println(a[i]);
        }
        
        
        for(int i=0;i<=n;i++){
        
        if(a[i]!= 50000 && a[i]!=0)
        {
        /*if(i==0)
        {
        frame.addEdge(0,1);
        }
        else if(i==n-1)
        {
        frame.addEdge(0,n-1);
        }
        //else
        if(i==s+1)
            frame.addEdge(i,i);
        else
            frame.addEdge(0,i);
    }
    else
    frame.addEdge(i,i);
}*/
        //graphPanel_.add(frame);
        graphPanel_.revalidate();
        
     
    }
    
    public void setProceedPanel() {
        exit.setLayout(new FlowLayout());
        
       
		for (int i = 0; i < name.length; i++) {
			button1 = new JButton(name[i]);
			button1.addActionListener(this);
			// button.setName(nameOfTheButtons[i]);
                      
                        
			exit.add(button1);
		}
    }
}
