
public class BruteCollinearPoints {
  
  private int count;
  private LineSegment[] segments;
  
  public BruteCollinearPoints(Point[] points) {
    
    if (points == null)
      throw new NullPointerException();
    
    int size = points.length;
    int count = 0;
    segments = new LineSegment[size/4];
    
    for (int a = 0; a < size - 3; a++)
      for (int b = a + 1; b < size - 2; b++)
        for (int c = b + 1; c < size - 1; c++)
          for (int d = c + 1; d < size; d++) {
            
            if (points[a] == null || points[b] == null || points[c] == null || points[d] == null)
              throw new NullPointerException();
            if (points[a].compareTo(points[b]) == 0 || points[a].compareTo(points[c]) == 0 || points[a].compareTo(points[d]) == 0 || points[b].compareTo(points[c]) == 0 || points[b].compareTo(points[d]) == 0 || points[c].compareTo(points[d]) == 0)
              throw new IllegalArgumentException();
            
            if (points[a].slopeTo(points[b]) == points[a].slopeTo(points[c]) && points[a].slopeTo(points[b]) == points[a].slopeTo(points[d])) {
              
              Point lowest = points[a];
              Point highest = points[d];
             
              if (lowest.compareTo(points[b]) == 1)
                lowest = points[b];
              if (lowest.compareTo(points[c]) == 1)
                lowest = points[c];
              if (lowest.compareTo(points[d]) == 1)
                lowest = points[d];
              
              if (highest.compareTo(points[a]) == -1)
                highest = points[a];
              if (highest.compareTo(points[b]) == -1)
                highest = points[b];
              if (highest.compareTo(points[c]) == -1)
                highest = points[c];
              
              segments[count] = new LineSegment(lowest, highest);
              count++;
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
    Point a,b,c,d,e,f,g,h,i,j;
    Point[] points = new Point[9];
    a = new Point(0, 0);
    points[0] = a;
    b = new Point(1, 1);
    points[1] = b;
    c = new Point(2, 2);
    points[2] = c;
    d = new Point(3, 3);
    points[3] = d;
    e = new Point(4, 4);
    points[4] = e;
    f = new Point(7, 1);
    points[5] = f;
    g = new Point(6, 2);
    points[6] = g;
    h = new Point(5, 3);
    points[7] = h;
    i = new Point(3,5);
    points[8] = i;

   BruteCollinearPoints fast = new BruteCollinearPoints(points);
   
   LineSegment[] segs = fast.segments();
   for (LineSegment s : segs)
     System.out.println(s);
  }
  
}