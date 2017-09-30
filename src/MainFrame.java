import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MainFrame extends Frame {
    private Button btnLeft = new Button("<--");
    private Button btnRight = new Button("-->");
    private Button btnFir = new Button("Fire");
    private Label lblLine = new Label();
    private Label lbTitle = new Label("count:");
    private Label lbCount = new Label("0");
    private int count = 0;
    private Timer t1;
    private int lbGunX = 250;//lbShoot的 x 座標
    private int lbGoalX = 250;
    private int lbGoalY=40;
    private int lbBulletY = 240;
    private Label lbGun = new Label(Integer.toString(lbGunX)+",200");
    private Label lbBullet = new Label();//子彈
    private Label lbGoal = new Label(Integer.toString(lbGoalX)+",40");//目標
    private boolean cheak = true;

    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,500,400);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLayout(null);

        this.add(btnLeft);
        this.add(btnRight);
        this.add(btnFir);
        this.add(lbTitle);
        this.add(lbCount);
        this.add(lblLine);
        this.add(lbGun);
        this.add(lbBullet);
        this.add(lbGoal);
        //setLocation & size & color
        btnLeft.setBounds(150,310,50,30);
        btnRight.setBounds(250,310,50,30);
        btnFir.setBounds(200,310,50,30);
        lbTitle.setBounds(10,350,50,50);
        lbTitle.setBackground(Color.LIGHT_GRAY);
        lbCount.setBounds(60,350,50,50);
        lbCount.setBackground(Color.lightGray);
        lblLine.setBounds(0,300,500,10);
        lblLine.setBackground(Color.cyan);
        lbGun.setBounds(lbGunX,270,50,30);//Gun
        lbGun.setBackground(new Color(0,132,255));
        lbBullet.setBounds(lbGunX,lbBulletY,20,30);//Bullet
        lbBullet.setBackground(new Color(255,0,0));
        lbGoal.setBounds(lbGoalX,lbGoalY,50,50);//Goal
        lbGoal.setBackground(new Color(198, 175, 39));

        //control
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbGunX++;
                lbGun.setLocation(lbGunX,270);
                lbBullet.setLocation(lbGunX,lbBulletY);
                lbGun.setText(Integer.toString(lbGunX)+",200");
            }
        });

        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbGunX--;
                lbGun.setLocation(lbGunX,270);
                lbBullet.setLocation(lbGunX,240);
                lbGun.setText(Integer.toString(lbGunX)+",200");
            }
        });
        btnFir.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                cheak = true;
                t1.start();
            }
        });

        //Timer control
        t1 = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lbBulletY>0 && cheak){
                    lbBulletY--;
                    lbBullet.setLocation(lbGunX,lbBulletY);
                    if(lbBulletY==lbGoalY && lbGunX==lbGoalX){
                        cheak=false;
                        count++;
                        lbCount.setText(Integer.toString(count));
                        lbBulletY = 240;
                        lbBullet.setLocation(lbGunX,lbBulletY);
                        lbGoalX = new Random().nextInt(450)+1;
                        lbGoal.setLocation(lbGoalX,lbGoalY);
                        lbGoal.setText(Integer.toString(lbGoalX)+","+Integer.toString(lbGoalY));

                    }
                }else{
                    cheak = false;
                    lbBulletY = 240;
                    lbBullet.setLocation(lbGunX,lbBulletY);
                }
                }



        });

    }
}
