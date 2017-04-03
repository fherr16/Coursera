import java.util.Arrays;

public class FastCollinearPoints {
  
  public int count;
  public LineSegment[] segments;
  
  public FastCollinearPoints(Point[] points) {
    segments = new LineSegment[points.length/4];
    Point[] ordered = points.clone();
    for (int i = 0; i < points.length; i++) {
      Arrays.sort(ordered, points[i].slopeOrder());
      
      System.out.println(points[i]);
      
      for (Point p : ordered)
        System.out.print(p + ": " + points[i].slopeTo(p) +"; ");
      
      System.out.println("\n************");
      int start = 1;
      
      while (start < ordered.length) {
        int x = 1;
        while ( start + x < ordered.length && points[i].slopeTo(ordered[start]) == points[i].slopeTo(ordered[start+x])) x++;
        if (x >= 3) {
          Point lowest = points[i];
          Point highest = ordered[start+x-1];
          for(int j = start; j < start + x - 1; j++) {
            if (lowest.compareTo(ordered[j]) == 1) lowest = ordered[j];
            else if (highest.compareTo(ordered[j]) == -1) highest = ordered[j];
          }
          segments[count] = new LineSegment(lowest, highest);
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
    return segments;
  }
  
  public static void main(String[] args) {
    Point a,b,c,d,e,f,g;
    Point[] points = new Point[7];
    a = new Point(0, 0);
    points[0] = a;
    b = new Point(0,1);
    points[1] = b;
    c = new Point(1,1);
    points[2] = c;
    d = new Point(2,2);
    points[3] = d;
    e = new Point(3,3);
    points[4] = e;
    f = new Point(4,4);
    points[5] = f;
    g = new Point(2,4);
    points[6] = g;
   FastCollinearPoints fast = new FastCollinearPoints(points);
   
   LineSegment[] segs = fast.segments();
   for (LineSegment s : segs)
     System.out.println(s);
  }
}
