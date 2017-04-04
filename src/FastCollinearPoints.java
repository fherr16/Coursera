import java.util.Arrays;
import java.util.Vector;

public class FastCollinearPoints {
  
  private int count;
  private Vector<LineSegment> segments;
  
  public FastCollinearPoints(Point[] points) {
    
    if (points == null)
      throw new NullPointerException();
    
    if (points.length == 3)
      if (points[0].compareTo(points[1]) == 0 || points[0].compareTo(points[2]) == 0 ||
          points[1].compareTo(points[2]) == 0)
        throw new IllegalArgumentException();
    
    if (points.length == 2)
      if (points[0].compareTo(points[1]) == 0)
        throw new IllegalArgumentException();
    
    segments = new Vector<LineSegment>();
    
    for (int i = 0; i < points.length; i++) {
      Point[] ordered = points.clone();
      Arrays.sort(ordered, points[i].slopeOrder());

      int start = 1;
      
      while (start < ordered.length) {
        int x = 1;
        if (points[i].slopeTo(ordered[start]) == Double.NEGATIVE_INFINITY)
          throw new IllegalArgumentException();
        while (start + x < ordered.length && points[i].slopeTo(ordered[start]) == points[i].slopeTo(ordered[start+x])) x++;
        x--;
        if (x >= 2) {
          Point lowest = points[i];
          Point highest = points[i];
          for (int j = start; j < start + x + 1; j++) {
            if (lowest.compareTo(ordered[j]) > 0) lowest = ordered[j];
            else if (highest.compareTo(ordered[j]) < 0) highest = ordered[j];
          }
          LineSegment l = new LineSegment(lowest, highest);
          
          if (count == 0) {
            segments.add(l);
            count++;
          }
          else {
            boolean contains = false;
            
            for (LineSegment s : segments)
              if (s != null && s.toString().equals(l.toString())) contains = true;
            if (!contains) {
              segments.add(l);
              count++;
            }
          }
          start = start + x + 1;
        }
        else start = start + x + 1;
      }
    }
  }
  
  public int numberOfSegments() {
    return count;
  }
  
  public LineSegment[] segments() {
    LineSegment[] finalized = new LineSegment[count];
    for (int i = 0; i < count; i++)
      finalized[i] = segments.get(i);
    return finalized;
  }
  
//  public static void main(String[] args) {
//    Point a,b,c,d,e,f,g,h,i,j;
//    Point[] points = new Point[7];
//    b = new Point(1, 1);
//    points[0] = b;
//    c = new Point(2, 2);
//    points[1] = c;
//    d = new Point(3, 3);
//    points[2] = d;
//    e = new Point(4, 4);
//    points[3] = e;
//    f = new Point(7, 1);
//    points[4] = f;
//    g = new Point(6, 2);
//    points[5] = g;
//    h = new Point(5, 3);
//    points[6] = h;
//    BruteCollinearPoints fast = new BruteCollinearPoints(points); 
//    LineSegment[] segs = fast.segments();
//    for (LineSegment s : segs)
//      System.out.println(s);
//  }
}
