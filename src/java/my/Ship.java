package my;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.ejb.Stateful;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Fiszu
 */
@Stateful
public class Ship implements IMapShip {

    IMap iMap;
    // IRadar iRadar;
    private int x;
    private int y;
    double[] onMap = new double[2];

    /**
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public double[] position() {
        /*	
        try{
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        jndiProps.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        jndiProps.setProperty("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        jndiProps.put(Context.PROVIDER_URL,"192.168.43.231:3700");
      
        Context ctx = new InitialContext(jndiProps);
        
            iRadar = (IRadar) ctx.lookup("java:global/lab-project/IRadar!IRadar");
        } catch (NamingException ex) {
            Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
 /*
        double[] onMap = new double[2];
        int wind;

        double freeWay = 100;
        Random rand = new Random();*/
 /*
        while (true) {
            try {
                wind = rand.nextInt(16);
                //double[] obstacle = iRadar.getEdge(x, y); //dodanie przeszkody z radaru
               
                if (wind <= 4) {
                    //onMap[0][1] = onMap[x + 1][y];
                    onMap[0] = x + y;
                } else if (wind > 4 && wind <= 8) {
                    //onMap[x][y] = onMap[x][y + 1];
                    onMap[1] = x + y + 1;
                } else if (wind > 8 && wind <= 12) {
                    //onMap[x][y] = onMap[x - 1][y];
                    onMap[0] = x + y;
                } else if (wind > 12 && wind <= 16) {
                    //onMap[x][y] = onMap[x][y - 1];
                    onMap[1] = x + y + 1;
                } else {
                    //onMap[x][y] = onMap[x + 1][y];
                    onMap[0] = x + y;
                }
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException ex) {
                Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        return onMap;

    }

    public void loop() {

        int wind;

        double freeWay = 100;
        Random rand = new Random();
        try {
            wind = rand.nextInt(16);
            //double[] obstacle = iRadar.getEdge(x, y); //dodanie przeszkody z radaru
            /*
			jeżeli napotkasz przeszkode to zrób przesunięcie po x lub y o 1 jak poniżej
             */

            if (wind <= 4) {
                //onMap[0][1] = onMap[x + 1][y];
                onMap[0] = this.x + this.y;
            } else if (wind > 4 && wind <= 8) {
                //onMap[x][y] = onMap[x][y + 1];
                onMap[1] = this.x + this.y + 1;
            } else if (wind > 8 && wind <= 12) {
                //onMap[x][y] = onMap[x - 1][y];
                onMap[0] = this.x + this.y;
            } else if (wind > 12 && wind <= 16) {
                //onMap[x][y] = onMap[x][y - 1];
                onMap[1] = this.x + this.y + 1;
            } else {
                //onMap[x][y] = onMap[x + 1][y];
                onMap[0] = this.x + this.y;
            }
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException ex) {
            Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() {
        Random rand = new Random();
        // int x, y;
        this.x = rand.nextInt() % 512 + 512;
        this.y = rand.nextInt() % 512 + 512;

        onMap[0] = this.x;
        onMap[1] = this.y;
        // MyRun runn = new MyRun();
        //runn.run();
    }

    class MyRun implements Runnable {

        private int id;

        public MyRun(int id) {
            this.id = id;
        }

        private MyRun() {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void run() {
            while (true) {
                loop();
                try {
                    //usypiamy wątek na 100 milisekund
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
