import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Line {
	int x1,x2,y1,y2;
	Line(double x1, double y1, double x2, double y2) {
		this.x1 = (int) x1;
		this.y1 = (int) y1;
		this.x2 = (int) x2;
		this.y2 = (int) y2;
	}
	Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	void draw(Graphics g, int centerX, int centerY) {
		g.drawLine(centerX+x1,centerY-y1,centerX+x2,centerY-y2);
	}
}
class MyCanvas extends Canvas {
	ArrayList<Line> lines = new ArrayList<Line>();
	public void addLineToPaint(Line line) {
		lines.add(line);
		repaint();
	}
	public void paint(Graphics g) {
		int centerX = this.getWidth()/2;
		int centerY = this.getHeight()/2;
		for (Line line : lines) {
			line.draw(g,centerX,centerY);
		}
	}
}

public class TurtleGraphic extends JFrame {
	JFrame frame;
	MyCanvas canvas;
	boolean penDown=false;
	double turtlePositionX;
	double turtlePositionY;
	double turtleDirection;
	int centerX;
	int centerY;
	public TurtleGraphic(String title, int width, int height) {
		super(title);
		Container cp = this.getContentPane();
		canvas = new MyCanvas();
		cp.add(canvas,BorderLayout.CENTER);
		turtlePositionX = 0;
		turtlePositionY = 0;
		turtleDirection = 0;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
	}
	
	public void setPosition(double x, double y) {
		turtlePositionX = x;
		turtlePositionY = y;
	}
	public void setDirection(double angle) {  // 0 <= angle <360
		turtleDirection = angle%360;
		if (turtleDirection<0) turtleDirection += 360;
	}
	public void turn(double angle) {
		turtleDirection = (turtleDirection + angle) % 360;
		if (turtleDirection<0) turtleDirection += 360;
	}
	public void penDown() { penDown = true; }
	public void penUp() { penDown = false; }
	public void forward(double distance) {
		double x = turtlePositionX;
		double y = turtlePositionY;
		double turtleRadiant = turtleDirection/180*Math.PI;
		double newX = Math.cos(turtleRadiant)*distance+x;
		double newY = Math.sin(turtleRadiant)*distance+y;
		if (penDown) {
			canvas.addLineToPaint(new Line(x,y,newX,newY));
		}
		turtlePositionX = newX;
		turtlePositionY = newY;	
	}
	
	public static void main(String[] arg) {
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
