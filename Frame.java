package COVID_SIM;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
public class Frame extends JPanel implements ActionListener
{
    static boolean tot;
    ArrayList<Person> people = new ArrayList<Person>();
    ArrayList<Point> points = new ArrayList<Point>();
    int time = 0;
    static int numInf=0;
    public Frame()
    {
        JFrame frame = new JFrame("COVID SIM");
        frame.setSize(1200,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for(int i = 0; i<100; i++)
            people.add(new Person());
        
        Timer t = new Timer(16, this);
        t.restart();
        
        frame.add(this);
        
        frame.setVisible(true);

    }
    
    public static void main()
    {
        Frame c = new Frame();
    }
    public void paint(Graphics g)
    {
        time+=16;
        
        
        if (tot)
        {
            points.add(new Point(time/16, numInf/150));
        }
        else
        {
            points.add(new Point(time/16, Person.inf*2));
        }
        
        int nInf=0;
        int nRec=0;
        int nVac=0;
        int nDead=0;
        for(Person p: people)
            switch (p.sick)
            {
                case 1: nInf++; numInf++; break;
                case 2: nRec++; break;
                case 5: nVac++; break;
                case 100: nDead++; break;
            }
        
        g.setFont(new Font("Arial", Font.BOLD, 20)); 
        g.setColor(Color.red); 
        g.drawString("Infected " + nInf, 850, 30); 
        g.setColor(new Color(0,212,252));
        g.drawString("Recovered " + nRec, 850, 60); 
        g.setColor(new Color(134, 222, 134));
        g.drawString("Vaccinated " + nVac, 850, 90); 
        g.setColor(Color.black);
        g.drawString("Dead " + nDead, 850, 120); 
            
        for(Person p: people)
            p.paint(g);
        
        for(int i=0; i<people.size(); i++)
        {
             for(int j=0; j<people.size(); j++)
             {
                    people.get(i).collision(people.get(j));
             }
                    if(people.get(i).dead)
                    {
                        people.get(i).vx=0;
                        people.get(i).vy=0;
                        g.setColor(Color.black);
                        g.fillOval(people.get(i).x, people.get(i).y, 10, 10);
                    }
        }
               
        g.setColor(Color.blue);
        for(Point p:points)
        {
            g.setColor(Color.black);
            g.fillOval(p.time, 800-p.value, 3, 3);  
        }
        
        if(Person.inf ==1)
        {
            g.setFont(new Font("Arial", Font.BOLD, 50)); 
                g.drawString("ERADICATED", 850, 425); }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); 
    }
    
}