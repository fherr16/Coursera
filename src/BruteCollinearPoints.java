
public class BruteCollinearPoints {
  
  private int count;
  private LineSegment[] segments;
  
  public BruteCollinearPoints(Point[] points) {
    
    if (points == null)
      throw new NullPointerException();
    
    int size = points.length;
    int count = 0;
    segments = new LineSegment[size/2];
    
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
  
}