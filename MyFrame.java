import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame implements MouseMotionListener { 
    private Container container = new Container();
    private JTextField textField = new JTextField ("", 8);
    private JLabel labelDragged = new JLabel ("");
    private JLabel labelMoved = new JLabel ("");
    private JButton buttonOK = new JButton ("OK");
    
    MyFrame() {
        super ("Test Event Handling");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (250,150);
        setLocation (100,100);
        
        
        labelDragged.addMouseMotionListener (this);
        labelMoved.addMouseMotionListener (this);
        textField.addMouseMotionListener (this);
        
        container = getContentPane();
        container.setLayout (new GridLayout (2,2));
        container.add (new JLabel ("mouseDragged :"));
        container.add (labelDragged);
        container.add (new JLabel ("mouseMoved :"));
        container.add (labelMoved);
        container.add (new JPanel());
        container.add (textField);
        container.add (buttonOK);
        show();   
    }
    
    public void mouseDragged (MouseEvent e) {
        labelDragged.setText ("AKTIF");
        labelMoved.setText ("");
    }
    
    public void mouseMoved (MouseEvent e) {
        labelDragged.setText ("");
        labelMoved.setText ("AKTIF");
    }
    
    public void keyTyped (KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
            textField.setText("ENTER ->> ditekan + dilepas");
    }
    
    public void keyPressed (KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
           textField.setText ("Tombol ENTER ->> ditekan"); 
    }
    
    public void keyReleased (KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
            textField.setText ("Tombol ENTER ->> dilepas");
    }
}