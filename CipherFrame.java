import javax.swing.*;
import java.awt.*;
public class CipherFrame extends JFrame {
    /**
     * Creates a new CipherFrame object with the given title and panel.
     * @param title the title of the frame
     * @param panel the panel to add to the frame
     */
    public CipherFrame(String title, CipherPanel panel) {
        super(title);
        this.setSize(new Dimension(300, 300));
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }
}
