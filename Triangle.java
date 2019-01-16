import java.lang.*;
public class Triangle implements Shape {
  private int _id;
  private int _side1; //s1,2,3 order in files
  private int _side2;
  private int _side3;
  private String _color;
  private double _area;
  private double _priarea; //Primative  area; value found before sqrt() is taken.
  private double _perimeter;
  private double _halfper; //Half of perimeter

  Triangle(int id, int side1, int side2, int side3, String color) { //Used with Shape list to create a Triangle object
    _id = id;
    _side1 = side1;
    _side2 = side2;
    _side3 = side3;
    _color = color;
  }

  public String getArea() {
    _halfper = (_side1 + _side2 + _side3) / 2.0;   //Heron's Formula for finding the area of a triangle from the 3 sides. If the problem returns "NaN"
    _priarea = (_halfper * (_halfper - _side1) * (_halfper - _side2) * (_halfper - _side3)); //or 0, the triangle is not possible
    _area = Math.sqrt(_priarea);
    if (_area == 0)
      return "not a valid triangle";
    else
      return String.format("%.2f", _area);
  }

  public String getPerimeter() {
    _perimeter = (_side1 + _side2 + _side3); //Perimeter of a triangle is found by adding the sides together
    return String.format("%.2f", _perimeter);
  }

  public int getSide1() { return _side1; }
  public int getSide2() { return _side2; }
  public int getSide3() { return _side3; }
  public String getColor() { return _color; }

  public String toString() {
    return "Triangle (ID# " + _id + ")" ;
  }

  public String getKind() { return "Triangle"; }
  public String getDetailString() {
    return "Side 1: " + getSide1() + "   Side 2: " + getSide2() + "   Side 3: " + getSide3() + "   Color: " + getColor() + "   Area: " + getArea() + "   Perimeter: " + getPerimeter();
  } //See Circle note
  public int getID() { return _id; }
}
