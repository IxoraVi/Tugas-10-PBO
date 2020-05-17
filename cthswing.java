import javax.swing.*;
public class cthswing {
    public static void main (String[] args) {
        JFrame myFrame = new JFrame("Contoh program Swing");
        JLabel myLabel = new JLabel("Ini adalah bagian swing");
        myFrame.add(myLabel);
        myFrame.setSize(200,150);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
