public class Main {
    public static void main(String[] args) {
        TurtleGraphic demo = new TurtleGraphic("Demo",800,600);
        demo.setPosition(0,0);
        demo.setDirection(30);
        demo.penDown();
        demo.forward(50);
        demo.penUp();
        demo.forward(30);
        demo.penDown();
        demo.forward(70);
        demo.repaint();
    }
}
