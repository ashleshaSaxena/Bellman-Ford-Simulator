
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



public class opFrame_n extends JFrame implements ActionListener{

    int n;
    int e;
    int[] intArray;
    int s;
    private JPanel inputPanel_;
    private JPanel graphPanel_;
    private JPanel exit;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    Edge2[] ed;
    int count=0;
    String[] name={"FINISH"};
    
  
    
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
    
    opFrame_n(int nodecount, int edgecount, int source, int[] distance,Edge2[] edges) {
        n = nodecount;
        e = edgecount;
        s = source;
        System.out.println(n+" "+e+" "+" "+s);
        intArray = new int[distance.length];
        for(int i=0; i<nodecount; ++i)
        {
            intArray[i]=distance[i];
        }   
        
        ed = new Edge2[edges.length];
        for(int i=0; i<nodecount; ++i)
        {
        ed[i]=edges[i];
        }   
        
        //new opFrame().setVisible(true); 
        //super("BELLMAN FORD ALGORITHM OUTPUT");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(600,700));
		setLocationRelativeTo(null);
		setVisible(true);
		addWindowListener(new ExitListener());
		setLayout(new FlowLayout());
		initComponents();
    }

    private void initComponents() {
        inputPanel_ = new JPanel();
		inputPanel_.setBorder(new TitledBorder("Output"));
		inputPanel_.setPreferredSize(new Dimension(500,200));
                                                                  
		graphPanel_ = new JPanel();
		graphPanel_.setBorder(new TitledBorder("Shortest Path"));
		graphPanel_.setPreferredSize(new Dimension(500,400));
                
                exit = new JPanel();
		exit.setPreferredSize(new Dimension(500,50));
                
		label1 = new JLabel();
                label2 = new JLabel();
                label3 = new JLabel();
                
		add(inputPanel_);
                add(graphPanel_);
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
    }

    private void setInputPanel() {
        
                //inputPanel_.setLayout(new FlowLayout());
                
                JLabel label0 = new JLabel("Note: 50000 represent no shortest path exit." );
        label0.setFont(new Font("Vardana", Font.BOLD, 12));
        inputPanel_.add(label0);
        
       inputPanel_.add(Box.createVerticalStrut(20));
       
       for(int i=0; i<e; ++i)
       {
       if(intArray[ed[i].dest]>intArray[ed[i].source]+ed[i].weight)
       System.out.println("Negative edge weight cycles detected!!!");
       count++;
       
       }
       
       if(count==e){
           JLabel label11 = new JLabel("Negative edge weight cycles detected!!!");
			label11.setFont(new Font("Vardana", Font.BOLD, 12));
			inputPanel_.add(label11);
       }
                
                for (int i = 0; i < n; i++) {
			JLabel label = new JLabel("The shortest distance between nodes "+s+" & "+i+" is "+intArray[i]);
			label.setFont(new Font("Vardana", Font.BOLD, 12));
			inputPanel_.add(label);
                        
                        
		}

		
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

        frame.setSize(400,300);
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

	frame.addNode(String.valueOf(s), 100,100,Color.GREEN);
        
 
	for (int i=0;i<n;i++){
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
                }*/
                //else
                if(i==s+1)
                    frame.addEdge(i,i);
                else
                    frame.addEdge(0,i);
            }
            else
                frame.addEdge(i,i);
        }
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
