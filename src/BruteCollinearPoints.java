
public class BruteCollinearPoints {
  
  private int count;
  private LineSegment[] segments;
  
  public BruteCollinearPoints(Point[] points) {
    
    if (points == null)
      throw new NullPointerException();
    
    int size = points.length;
    int count = 0;
    segments = new LineSegment[size/3];
    
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
              Point highest = points[a];
             
              if (lowest.compareTo(points[b]) == 1)
                lowest = points[b];
              if (lowest.compareTo(points[c]) == 1)
                lowest = points[c];
              if (lowest.compareTo(points[d]) == 1)
                lowest = points[d];
              
              if (highest.compareTo(points[b]) == -1)
                highest = points[b];
              if (highest.compareTo(points[c]) == -1)
                highest = points[c];
              if (highest.compareTo(points[d]) == -1)
                highest = points[d];
              
              LineSegment L = new LineSegment(lowest, highest);
              
              if (count == 0) {
                segments[count] = L;
                count++;
              }
              else {
                boolean contains = false;
                for (LineSegment S : segments)
                  if (S != null && S.toString().equals(L.toString())) contains = true;
                if (!contains) {
                  segments[count] = L;
                  count++;
                }
              }
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
    Point[] points = new Point[7];
    b = new Point(1, 1);
    points[0] = b;
    c = new Point(2, 2);
    points[1] = c;
    d = new Point(3, 3);
    points[2] = d;
    e = new Point(4, 4);
    points[3] = e;
    f = new Point(7, 1);
    points[4] = f;
    g = new Point(6, 2);
    points[5] = g;
    h = new Point(5, 3);
    points[6] = h;


   BruteCollinearPoints fast = new BruteCollinearPoints(points);
   
   LineSegment[] segs = fast.segments();
   for (LineSegment s : segs)
     System.out.println(s);
  }
  
}