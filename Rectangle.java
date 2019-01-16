public class Rectangle implements Shape{
  private int _id;
  private int _length; //length before width in files
  private int _width;
  private String _color;
  private double _area;
  private double _perimeter;

  Rectangle(int id, int length, int width, String color) {  //Used with Shape list to create a Rectangle object
    _id = id;
    _length = length;
    _width = width;
    _color = color;
  }

  public String getArea() {
    _area = _length * _width;  //Rectangle area is side1 * side2
    return String.format("%.2f", _area);
  }

  public String getPerimeter() {
    _perimeter = (_length * 2) + (_width * 2); //Find the rectangle perimeter by adding together all the sides
    return String.format("%.2f", _perimeter);
  }

  public int getLength() { return _length; }
  public int getWidth() { return _width; }

  public String getColor() { return _color; }

  public String toString() {
    return "Rectangle " + "(ID# " + _id + ")" ;
  }

  public String getKind() { return "Rectangle"; }
  public String getDetailString() {
    return  " Length: " + getLength() + "   Width: " + getWidth() + "   Color: " + getColor() + "   Area " + getArea() + "   Perimeter " + getPerimeter();
  } //See Circle note
  public int getID() { return _id; }
}
