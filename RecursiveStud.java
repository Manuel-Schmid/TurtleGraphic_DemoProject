public class RecursiveStud {
    public static void demo() {
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

    public static void drawCheckmark() {
        TurtleGraphic demo = new TurtleGraphic("Demo",400,400);
        demo.penDown();
        demo.turn(-60);
        demo.forward(20);
        demo.turn(120);
        demo.forward(60);
        demo.repaint();
    }

    public static void ex3() {
        TurtleGraphic demo = new TurtleGraphic("ex3",400,400);
        demo.setPosition(-85,-122);
        demo.turn(30);
        demo.penDown();
        demo.forward(50);
        demo.penUp();
        demo.forward(30);
        demo.penDown();
        demo.forward(70);
        demo.repaint();
    }

    public static void ex4() {
        TurtleGraphic demo = new TurtleGraphic("ex3",400,400);
        demo.penDown();
        for (int i = 0; i <= 5; i++) {
            demo.forward(50);
            demo.turn(72);
        }
    }

    public static void dragonCurve() {
        TurtleGraphic demo = new TurtleGraphic("dragon", 800, 600);
//        demo.setPosition(0,-100);
        demo.penDown();
        dragon(demo, 5, +1, 500);
        demo.repaint();
    }

    private static void dragon(TurtleGraphic demo, int t, int pre, int line) {
        if (t == 0) {
            demo.forward(line);
        } else if (t>0) {
            dragon(demo, t-1, +1, line/2);
            demo.turn(pre * 90);
            dragon(demo, t-1, -1, line/2);
        }
    }

    public static void kochCurve() {
        TurtleGraphic demo = new TurtleGraphic("KOCH", 800, 600);
        demo.setPosition(-250, 0);
        demo.penDown();
        koch(demo, 4, 500);
        demo.repaint();
    }

    private static void koch(TurtleGraphic demo, int t, double line) {
        if (t == 0) demo.forward(line);
        else {
            koch(demo, t-1, (line/3));
            demo.turn(60);
            koch(demo, t-1, (line/3));
            demo.turn(-120);
            koch(demo, t-1, (line/3));
            demo.turn(60);
            koch(demo, t-1, (line/3));
        }
        // aufgabe: "Wissenssicherung 8"
    }
}