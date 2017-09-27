import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends Frame {
    private Button btnLeft = new Button("<--");
    private Button btnRight = new Button("-->");
    private Button btnFir = new Button("Fire");
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
        btnLeft.setBounds(100,350,50,30);
        btnRight.setBounds(200,350,50,30);
        btnFir.setBounds(150,350,50,30);
    }
}
