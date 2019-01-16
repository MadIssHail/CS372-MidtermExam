import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

  public class MainwGUI extends JFrame implements ListSelectionListener {
    private JFrame ShapeView;              //Elements to create GUI Interface, LN 14 - 22
    private JPanel ChangeShape;
    private JPanel DisplayShape;
    private JLabel ShapeInfo;
    private JLabel DetailedShapeInfo;
    private JLabel ShapeIcon;
    DefaultListModel<String> model;
    private JList<String> ShapeList;
    private JScrollPane listScroll;

    private static List<String> lines = new ArrayList<String>();  //Arraylists: lines outputs each shapees with all its properties in one
    private static List<String> parts2 = new ArrayList<>();  // parts2 has each individual characteristic of the shapes in its own location
    private static List<Shape> Shapes = new ArrayList<>();   //Shapes holds circles, triangles, squares, and rectangles and uses parts2 to create
                                                             //new shapes based on the relevant constructor
    private static URL CircleURL;     //Necessary member variables to display icons, LN 28 - 42
    private static ImageIcon CIcon;
    private static Image Circleimg;

    private static URL SquareURL;
    private static ImageIcon SIcon;
    private static Image Squareimg;

    private static URL RectangleURL;
    private static ImageIcon RIcon;
    private static Image Rectangleimg;

    private static URL TriangleURL;
    private static ImageIcon TIcon;
    private static Image Triangleimg;


    public MainwGUI() {
      DisplayShape = new JPanel();
      ChangeShape = new JPanel();
      ShapeInfo = new JLabel("");   //Set the JLabels to exist before being initialized, but not to anything important
      DetailedShapeInfo = new JLabel("");

      ShapeView = null;
      ShapeView = new JFrame("Shape Slideshow");
      ShapeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ShapeView.setSize(750,750);
      ShapeView.setVisible(true);
      ShapeView.setLayout(new BorderLayout());
      ShapeView.add(DisplayShape, BorderLayout.NORTH);  //GridBox wasn't cooperating with the JScrollPane, so I switched to BorderLayout
      ShapeView.add(ChangeShape, BorderLayout.CENTER);

      model = new DefaultListModel<>();
      ShapeList = new JList<>(model);
      ShapeList.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);  //Found on StackOverflow so the JList wasn't just one big line
      listScroll = new JScrollPane(ShapeList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      listScroll.setPreferredSize(new Dimension(250,200));

      for (int i = 0; i < Shapes.size(); i++) {
        model.addElement(Shapes.get(i).toString());  //Adding all the shape elements to the JList
      }

      ChangeShape.add(listScroll);
      ShapeList.setDragEnabled(true);

      ShapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      ShapeList.addListSelectionListener(this);
      DisplayShape.add(ShapeInfo);
      DisplayShape.add(DetailedShapeInfo);
      ShapeIcon = new JLabel("");
      DisplayShape.add(ShapeIcon);

      try {
        Toolkit tk = Toolkit.getDefaultToolkit();
        CircleURL = new URL("https://i.stack.imgur.com/Q4nm0.png");
        Circleimg = tk.getImage(CircleURL);
        Circleimg = Circleimg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        CIcon = new ImageIcon(Circleimg);

      } catch (MalformedURLException f) {
        System.out.println(f.getMessage());
      }   //Process to display images and catch URL Exceptions LN, 80 - 122

      try {
        Toolkit tk = Toolkit.getDefaultToolkit();
        SquareURL = new URL("http://chittagongit.com//images/square-icon/square-icon-1.jpg");
        Squareimg = tk.getImage(SquareURL);
        Squareimg = Squareimg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        SIcon = new ImageIcon(Squareimg);

      } catch (MalformedURLException f) {
        System.out.println(f.getMessage());
      }

      try {
        Toolkit tk = Toolkit.getDefaultToolkit();
        RectangleURL = new URL("https://upload.wikimedia.org/wikipedia/commons/c/cc/Rectangle_.png");
        Rectangleimg = tk.getImage(RectangleURL);
        Rectangleimg = Rectangleimg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        RIcon = new ImageIcon(Rectangleimg);

      } catch (MalformedURLException f) {
        System.out.println(f.getMessage());
      }

      try {
        Toolkit tk = Toolkit.getDefaultToolkit();
        TriangleURL = new URL("https://vignette.wikia.nocookie.net/uncyclopedia/images/8/88/Triangle%28shape%29.jpg/revision/latest?cb=20121214140518");
        Triangleimg = tk.getImage(TriangleURL);
        Triangleimg = Triangleimg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        TIcon = new ImageIcon(Triangleimg);

      } catch (MalformedURLException f) {
        System.out.println(f.getMessage());
      }

    }
    public void valueChanged(ListSelectionEvent l) {
      String value = ShapeInfo.getText();
      if (!l.getValueIsAdjusting()) {
        value = ShapeList.getSelectedValue();
        ShapeInfo.setText(value);
      }
        if (value.charAt(0) == 'C') {  //If the first letter of the Shape is a C (for Circle)
          if (value.equals(Shapes.get(ShapeList.getSelectedIndex()).toString())) {
            DetailedShapeInfo.setText(Shapes.get(ShapeList.getSelectedIndex()).getDetailString()); //Set the text of the shape info label to be
            ShapeIcon.setIcon(CIcon);                                                              //the detailed info from the current JScrollPane item
          }                                                                                        //And display the corresponding icon
        }
        else if (value.charAt(0) == 'S') { //Same as above, but for Square
           if (value.equals(Shapes.get(ShapeList.getSelectedIndex()).toString())) {
             DetailedShapeInfo.setText(Shapes.get(ShapeList.getSelectedIndex()).getDetailString());
             ShapeIcon.setIcon(SIcon);
           }
        }
        else if (value.charAt(0) == 'R') { //Same as above, but for Rectangle
           if (value.equals(Shapes.get(ShapeList.getSelectedIndex()).toString())) {
             DetailedShapeInfo.setText(Shapes.get(ShapeList.getSelectedIndex()).getDetailString());
             ShapeIcon.setIcon(RIcon);
           }
        }
        else if (value.charAt(0) == 'T') { //Same as above, but for Triangle
           if (value.equals(Shapes.get(ShapeList.getSelectedIndex()).toString())) {
             DetailedShapeInfo.setText(Shapes.get(ShapeList.getSelectedIndex()).getDetailString());
             ShapeIcon.setIcon(TIcon);
           }
        }
    }

    public static void main(String[] args) {
      try (FileInputStream is = new FileInputStream("shapes.csv")) {
        InputStreamReader ir = new InputStreamReader(is);  //Necessary file read functions
        BufferedReader rdr = new BufferedReader(ir);
        String line = rdr.readLine();
        while (line != null) {
          String[] parts = line.split(","); //Split up the Strings wherever the computer finds a comma
          lines.add(line);
          for (String p: parts) {
            if (p.length() > 0 && p.charAt(0) == '"') {
              parts2.add(p.substring(1, p.length() - 1).trim()); //Trim off the quotes on either side and just grab the String value
            }
            else
              parts2.add(p.trim()); //Find values with no quotes around them, like the ID
          }
          line = rdr.readLine();
        }
      }
      catch (Exception ex) { System.out.printf("Failed for %s\n", "shapes.csv"); }
      for (int j = 0; j < parts2.size() - 3; j++) {
        if (parts2.get(j).matches("circle")) {  //Uses the broken up array to piece together a constructor based on when the computer grabs a string that says "circle"
          Shapes.add(new Circle(Integer.parseInt(parts2.get(j + 1)) , Integer.parseInt(parts2.get(j + 2)), parts2.get(j + 3)));

           }
        else if (parts2.get(j).matches("square")) { //Same as above
          Shapes.add(new Square(Integer.parseInt(parts2.get(j + 1)) , Integer.parseInt(parts2.get(j + 2)), parts2.get(j + 3)));
        }
        else if (parts2.get(j).matches("rectangle")) {
          Shapes.add(new Rectangle(Integer.parseInt(parts2.get(j + 1)) , Integer.parseInt(parts2.get(j + 2)),Integer.parseInt(parts2.get(j + 3)), parts2.get(j + 4)));

        }
        else if (parts2.get(j).matches("triangle")) {
          Shapes.add(new Triangle(Integer.parseInt(parts2.get(j + 1)) , Integer.parseInt(parts2.get(j + 2)),Integer.parseInt(parts2.get(j + 3)), Integer.parseInt(parts2.get(j + 4)), parts2.get(j + 5)));

        }
      }
      MainwGUI p = new MainwGUI(); //create the JFrame
    }
  }

