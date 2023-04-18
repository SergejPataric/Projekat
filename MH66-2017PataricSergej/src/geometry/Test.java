package geometry;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Point p1 = new Point();
		/*System.out.println(p1);
		System.out.println(p1.getX());
		System.out.println(p1.getY());*/
		
		Point p2 = new Point();
		p2.setX(50);
		p1.setX(30);
		//System.out.println(p1.getX());
		//System.out.println(p2.getX());
		//p2 = p1;
		//System.out.println(p2.getX());
		
		p1.setX(10);
		p1.setY(5);
		p2.setX(8);
		p2.setY(3);
		
		//System.out.println(p1.distance(p2.getX(), p2.getY()));
		
		Line l1 = new Line(p1,p2);
		/*System.out.println(l1.getStartPoint().getX());
		System.out.println(l1.getEndPoint().getX());
		System.out.println(p1.distance(p2));
		
		System.out.println(p1.toString());*/
		
		//VEZBE 6
		/*Rectangle r1 = new Rectangle(p1,50,50);
		p1.setX(2);
		p1.setY(5);
		p2.setX(8);
		p2.setY(8);
		//System.out.println(p1.equals(r1));
		Point klik = new Point(2,6);
		System.out.println(l1.lenght());
		System.out.println(p1.distance(klik));
		System.out.println(p2.distance(klik));
		System.out.println(l1.contains(klik.getX(), klik.getY()));
		
		System.out.println(r1.contains(klik.getX(), klik.getY()));
		
		Donut d1 = new Donut();
		System.out.println(d1.getRadius());
		System.out.println(d1 instanceof Circle);
		System.out.println(d1.getInnerRadius());
		
		Circle c1 = new Circle();*/
		
							//VEZBA 7
		//Shape s1 = new Circle();
		
						
							//VEZBA 9
		
		/*int broj2 = 5/0;
		try {
			int broj = 5/0;
		}catch(Exception e) {
			System.out.println("Deljenje sa nulom nije dozvoljeno!");
		}
		
		System.out.println("Ispis");*/
		
		Circle c1 = new Circle();
		try {
			c1.setRadius(-5);
		} catch (Exception e) {
			System.out.println("Poluprecnik mora biti veci od 0");
		}
		
		
	}

}
