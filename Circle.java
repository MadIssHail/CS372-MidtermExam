public class Circle implements Shape {  //Used with Shape list to create a Circle object

  private int _id;
  private int _radius;
  private String _color;
  private double _area;
  private double _perimeter;
  final double PI = 3.14;

  Circle(int id, int radius, String color) {
    _id = id;
    _radius = radius;
    _color = color;
  }

  public String getArea() {
    _area = _radius * _radius * PI;  //Area of circle is (PI)(radius * radius)
    return String.format("%.2f", _area);
  }

  public String getPerimeter() {
    _perimeter = _radius * 2 * PI;  // Circumference of a circle is (PI)(2 * radius)
    return String.format("%.2f", _perimeter);
  }

  public int getRadius() { return _radius; }

  public String getColor() { return _color; }

  public String toString() {
    return "Circle " + "(ID# " + _id + ")" ;
  }

  public String getKind() { return "Circle"; }
  public String getDetailString() {
    return "Color: " + getColor() + "   Radius: " + getRadius()+ "   Area: " + getArea() + "   Perimeter: " + getPerimeter();
  }  //I didn't add the Type and ID to the detailed string since they are already in toString; instead I combined the two on the interface
  public int getID() { return _id; }
}
