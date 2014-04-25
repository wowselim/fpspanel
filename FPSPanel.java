import java.awt.Graphics;
import javax.swing.*;

class FPSPanel extends JPanel implements Runnable {
  private volatile int currentFPS;
  private JLabel lblFPS;
  
  public FPSPanel() {
    currentFPS = 0;
    setOpaque(false);  
    lblFPS = new JLabel();
    add(lblFPS);
    new Thread(this).start();
  }
  
  public void run() {
    while(true) {
      try {
        Thread.sleep(1000L);
        lblFPS.setText(String.valueOf(currentFPS) + " FPS");
        currentFPS = 0;
      } catch (InterruptedException e) { break; }
    }
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    currentFPS++;
  }
}
