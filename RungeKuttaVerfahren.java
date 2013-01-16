package runge.kutta.verfahren;

/**
 *
 * @author Bernhard Sirlinger
 */
public class RungeKuttaVerfahren {
		public static void main(String[] args) {
				RungeKuttaVerfahren test = new RungeKuttaVerfahren();
				test.berechnen();
		}
		
		public void berechnen() { 
				double y = 1, x = 2;
				double h = 0.1;
				double max_x = 5;
				double ya, yb, yc;
				double A_y, A_ya, A_yb, A_yc; //Ableitungen
				double h_2 = h/2.0;//h Halbe
				double ein6tel = 1.0/6.0;
				
				while(x <= max_x) {
						
						//Erster Schritt
						A_y = this.f(x, y);
						ya = y+(h_2*A_y);
						
						//Zweiter Schritt
						A_ya = this.f(x+h_2, ya);
						yb = y+(h_2*A_ya);
						
						//Dritter Schritt
						A_yb = this.f(x+h_2, yb);
						yc = y+(h*A_yb);
						
						//Vierter Schritt
						A_yc = this.f(x+h, yc);
						y += (h*ein6tel*(A_y+2*(A_ya+A_yb)+A_yc));
						
						System.out.println("X: "+x+" "+"Y:"+y);
						
						x += h;
				}
		}
		
		public double f(double x, double y) {
				double g = Math.pow(x, 3)+(Math.sin(y)/(x));
				return g;
		}
		
}
