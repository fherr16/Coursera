import java.util.Arrays;

public class FastCollinearPoints {
  
  public int count;
  public LineSegment[] segments;
  
  public FastCollinearPoints(Point[] points) {
    
    if (points == null)
      throw new NullPointerException();
    
    segments = new LineSegment[points.length/4];
    
    for (int i = 0; i < points.length; i++) {
      Point[] ordered = points.clone();
      Arrays.sort(ordered, points[i].slopeOrder());

      int start = 1;
      
      while (start < ordered.length) {
        int x = 1;
        while ( start + x < ordered.length && points[i].slopeTo(ordered[start]) == points[i].slopeTo(ordered[start+x])) x++;
        x--;
        if (x >= 2) {
          Point lowest = points[i];
          Point highest = points[i];
          for(int j = start; j < start + x + 1; j++) {
            if (lowest.compareTo(ordered[j]) == +1) lowest = ordered[j];
            else if (highest.compareTo(ordered[j]) == -1) highest = ordered[j];
          }
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
}
