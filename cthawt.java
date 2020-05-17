import java.awt.*;
public class cthawt {
    public static void main (String[] args) {
        Frame myFrame = new Frame("Contoh program AWT");
        Label myLabel = new Label("Hai...Ini adalah bagian dari AWT");
        myFrame.add(myLabel);
        myFrame.setSize(200,150);
        myFrame.show();
    }
}