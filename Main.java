package COVID_SIM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.*;


public class Main extends JFrame {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JButton jcomp3;
    private JButton jcomp4;
    private JSlider jcomp5;
    private JLabel jcomp6;
    private JSlider jcomp7;
    private JSlider jcomp8;
    private JLabel jcomp9;
    public Main() {
        JFrame f = new JFrame();
        //construct components
        jcomp1 = new JLabel ("Enter Rate of Vaccination");
        
        jcomp2 = new JLabel ("Enter Rate of Social Distancing");
        
        jcomp3 = new JButton ("SOCIAL DISTANCING ON");
        jcomp3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Person.sd  = true;
                new Frame();
            }
        });
        
        jcomp4 = new JButton ("SOCIAL DISTANCING OFF");
        jcomp4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Person.sd  = false;
                new Frame();
            }
        });
       
        jcomp5 = new JSlider (0, 100);
        jcomp5.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                Person.rVac = ((double)((((JSlider)e.getSource()).getValue()))*0.01);
               // System.out.println(Person.rVac);
            }
        });
        
        jcomp6 = new JLabel ("Enter Rate of Infection");
       
        
        jcomp7 = new JSlider (0, 100);
        jcomp7.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                Person.rInf = ((double)((((JSlider)e.getSource()).getValue()))*0.01);
               // System.out.println(Person.rInf);
            }
        });
        
        jcomp8 = new JSlider (0, 100);
        jcomp8.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                Person.Sd = 1-((double)((((JSlider)e.getSource()).getValue()))*0.01);
                //System.out.println(Person.Sd);
            }
        });
        
        jcomp9 = new JLabel ("");
        
        String[] GItems = {"Graph Active Cases", "Graph Total Cases"};

        //construct components
        JComboBox G = new JComboBox (GItems);
        JLabel graph = new JLabel ("");
        G.setBounds (210, 265, 200, 200);
        graph.setBounds (170, 355, 100, 25);
        G.addItemListener(new ItemListener()
        {
             public void itemStateChanged(ItemEvent e)
             {
        
                if (e.getSource() == GItems[1]) {
                    Frame.tot=false;
 
                }
                else
                    Frame.tot=true;
            }
        });
        
        //set components properties
        jcomp5.setOrientation (JSlider.HORIZONTAL);
        jcomp5.setMinorTickSpacing (10);
        jcomp5.setMajorTickSpacing (50);
        jcomp5.setPaintTicks (true);
        jcomp5.setPaintLabels (false);
        jcomp7.setOrientation (JSlider.HORIZONTAL);
        jcomp7.setMinorTickSpacing (10);
        jcomp7.setMajorTickSpacing (50);
        jcomp7.setPaintTicks (true);
        jcomp7.setPaintLabels (false);
        jcomp8.setOrientation (JSlider.HORIZONTAL);
        jcomp8.setMinorTickSpacing (10);
        jcomp8.setMajorTickSpacing (50);
        jcomp8.setPaintTicks (true);
        jcomp8.setPaintLabels (false);
        
        jcomp1.setBounds (120, 55, 255, 25);
        jcomp2.setBounds (120, 155, 255, 30);
        jcomp3.setBounds (115, 200, 185, 105);
        jcomp4.setBounds (330, 200, 185, 105);
        jcomp5.setBounds (335, 40, 175, 55);
        jcomp6.setBounds (120, 105, 235, 25);
        jcomp7.setBounds (335, 90, 175, 55);
        jcomp8.setBounds (335, 140, 175, 55);
        jcomp9.setBounds (65, 355, 100, 25);

        //adjust size and set layout
        setPreferredSize (new Dimension (663, 450));
        setLayout (null);

        //add components
        f.add (jcomp1);
        f.add (jcomp2);
        f.add (jcomp3);
        f.add (jcomp4);
        f.add (jcomp5);
        f.add (jcomp6);
        f.add (jcomp7);
        f.add (jcomp8);
        f.add (jcomp9);
        f.add(G);
        f.add(graph);

        f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        f.setSize(663,450);
        f.setVisible(true);
        
    }
    public static void main (String[] args) {
        Main ob=new Main();
    }
    
}