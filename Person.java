package COVID_SIM;
import java.awt.*;
public class Person
{
    int x, y;
    int vx, vy;
    
    int sick = 0;
    
    int rTime;
    int vTime;
     boolean dead;

    static int inf = 1;
    
    static boolean sd;
    
    static double rInf;
    static double Sd;
    double Start=0.08;
    static double rVac;
    public Person()
    {
        x = (int)(Math.random()*790);
        y = (int)(Math.random()*590);
        
        if(Math.random()<Start)
        {
            sick = 1;
            if(Math.random()<0.1)
                dead = true;
            inf++;
        }
           
        
        rTime = (int)((Math.random()*8000-5000+1)+5000);
        vTime = (int)((Math.random()*8000-5000+1)+5000);
        
        if (sd)
        {
            if(Math.random()<Sd)
            {
                vx = (int)(Math.random()*(10+1)-5);
                vy = (int)(Math.random()*(10+1)-5);
                vx = notZero(vx);
                vy = notZero(vy);
            }
        }
        else
        {
            vx = (int)(Math.random()*(10+1)-5);
                vy = (int)(Math.random()*(10+1)-5);
                vx = notZero(vx);
                vy = notZero(vy);
        }
        
    }
    
    public void collision(Person p2)
    {
        Rectangle P1 = new Rectangle(this.x, this.y, 10, 10);
        Rectangle P2 = new Rectangle(p2.x, p2.y,10,10);
        if(!dead)
        {
            if(P1.intersects(P2))
            {
                if(this.sick==1 && p2.sick==0)
                {
                    if(Math.random()<rInf)
                    {
                        p2.sick=1;
                        inf++;
                    }
                }
                else if(this.sick==0 && p2.sick==1)
                {
                    if(Math.random()<rInf)
                    {
                        this.sick=1;
                        inf++;
                    }
                }
            }
        }
    }
    public void paint(Graphics g)
    {
        if(sick==1)
            g.setColor(Color.red); 
        else if(sick==0)
            g.setColor(Color.LIGHT_GRAY);
        else if (sick == 2)
            g.setColor(new Color(0,212,252));
        else if (sick == 5)
            g.setColor(new Color(134, 222, 134));
        x+=vx;
        y+=vy;
        if (sick==1)
        {
            rTime-=16;
            if (rTime<=0)
            {
                if (dead)
                {
                    vx = 0;
                    vy = 0;
                    g.setColor(Color.black);
                    g.fillOval(x, y, 10, 10);
                    sick = 100;
                }
                else
                    sick = 2;
                inf--;
            }
        }
        if (sick==0)
        {
            if(Math.random()<rVac)
            {
                vTime-=16;
                if (vTime<=0)
                {
                    sick = 5;
                }
            }
        }
        if(x<0 || x>=790)
            vx*=-1;
        
        if(y<0 || y>=590)
            vy*=-1;
            
        g.fillOval(x,y, 10, 10);
        
    }
    int notZero(int a)
    {
        int i=1;
        while (i>0)
        {
            a = (int)(Math.random()*(10+1)-5);
            if (a!=0)
                break;
        }
        return a;
    }
}
