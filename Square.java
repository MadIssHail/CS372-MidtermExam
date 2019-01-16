public class Square implements Shape {

  private int _id;
  private int _side;
  private String _color;
  private double _area;
  private double _perimeter;

  Square(int id, int side, String color) {  //Used with Shape list to create a Square object
    _id = id;
    _side = side;
    _color = color;
  }

  public String getArea() {
    _area = _side * _side;  //Square area is side * side
    return String.format("%.2f", _area);
  }

  public String getPerimeter() {
    _perimeter = _side * 4;  //Square perimeter is found by adding the sides together
    return String.format("%.2f", _perimeter);
  }

  public int getSide() { return _side; }

  public String getColor() { return _color; }

  public String toString() {
    return "Square " + "(ID# " + _id + ")" ;
  }  //Returns in the format "Square (ID# 0)"

  public String getKind() { return "Square"; }
  public String getDetailString() {
    return " Side: " + getSide() + "   Color: " + getColor() + "   Area: " + getArea() + "   Perimeter: " + getPerimeter();
  }  //See Circle note

  public int getID() { return _id; }
}
