/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author user
 */
public class camp_3 extends JFrame implements ActionListener {
    
    private JPanel panel;
     private JPanel panel1;
     private JPanel panel2;
     String[] nameOfTheButtons = { "NEXT"};
     private JButton button;
     
    public camp_3() {
		super("Camparision And Analysis: ");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(768,520 ));
		setLocationRelativeTo(null);
		setVisible(true);
                setBackground(Color.WHITE);
		addWindowListener(new ExitListener());
		setLayout(new FlowLayout());
		initComponents();
	}

    private void initComponents() {
                panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(368,421));
                panel.setBorder(new TitledBorder("Bellman-Ford (STEP: 2)"));
                panel.setBackground(Color.WHITE);
                
                panel1 = new JPanel(new BorderLayout());
		panel1.setPreferredSize(new Dimension(368,421));
                panel1.setBorder(new TitledBorder("Floyd-Warshall (STEP: 2)"));
                panel1.setBackground(Color.WHITE);
                
                panel2 = new JPanel(new BorderLayout());
		panel2.setPreferredSize(new Dimension(768,40));
                
                add(panel);
                add(panel1);
                add(panel2);
		setPanel();
                setPanel_1();
    }

    private void setPanel() {
        ImageIcon image = new ImageIcon("C:\\Users\\user\\Desktop\\PBL\\bell_2.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        
        panel.add( label );
        
        ImageIcon image1 = new ImageIcon("C:\\Users\\user\\Desktop\\PBL\\ford_2.png");
        JLabel label1 = new JLabel("", image1, JLabel.CENTER);
        
        panel1.add( label1 );
        
       
    }

    private void setPanel_1() {
        
        for (int i = 0; i < nameOfTheButtons.length; i++) {
			button = new JButton(nameOfTheButtons[i]);
			button.addActionListener(this);
                        button.setBackground(Color.BLACK);
                        button.setForeground(Color.WHITE);
			// button.setName(nameOfTheButtons[i]);
			panel2.add(button);
		}
        /*   JButton next = new JButton("NEXT");
        panel2.add(next,JButton.RIGHT);*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            this.setVisible(false);
            new camp_4().setVisible(true);
    }
    
}
