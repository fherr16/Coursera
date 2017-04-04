import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {
  
  private final int xCoordinate;
  private final int yCoordinate;
  
  private class SlopeOrderComparator implements Comparator<Point> {
    public int compare(Point thatOne, Point thisOne){
      double slopeWithThatOne, slopeWithThisOne;
      
      if ((xCoordinate == thatOne.xCoordinate) && (yCoordinate == thatOne.yCoordinate)) slopeWithThatOne = Double.NEGATIVE_INFINITY;
      else if (yCoordinate == thatOne.yCoordinate) slopeWithThatOne = 0.0;
      else if (xCoordinate == thatOne.xCoordinate) slopeWithThatOne = Double.POSITIVE_INFINITY;
      else slopeWithThatOne = ((double)(thatOne.yCoordinate - yCoordinate)/(double)(thatOne.xCoordinate - xCoordinate));
      
      if ((xCoordinate == thisOne.xCoordinate) && (yCoordinate == thisOne.yCoordinate)) slopeWithThisOne = Double.NEGATIVE_INFINITY;
      else if (yCoordinate == thisOne.yCoordinate) slopeWithThisOne = 0.0;
      else if (xCoordinate == thisOne.xCoordinate) slopeWithThisOne = Double.POSITIVE_INFINITY;
      else slopeWithThisOne = ((double)(thisOne.yCoordinate - yCoordinate)/(double)(thisOne.xCoordinate - xCoordinate));
      
      if (slopeWithThatOne > slopeWithThisOne) { return +1; }
      else if (slopeWithThatOne < slopeWithThisOne) { return -1; }
      else return 0;
    }
  }
  
  public Point(int x, int y) {
    this.xCoordinate = x;
    this.yCoordinate = y;
  }
  
  public void draw() {
    StdDraw.point(xCoordinate, yCoordinate);
  }
  
  public void drawTo(Point that) {
    StdDraw.line(xCoordinate, yCoordinate, that.xCoordinate, that.yCoordinate);
  }
  
  public String toString() {
    return "(" + xCoordinate + ", " + yCoordinate + ")";
  }
  
  public int compareTo(Point that) {
    if (yCoordinate > that.yCoordinate) { return +1; }
    else if (yCoordinate < that.yCoordinate) { return -1; }
    else {
      if (xCoordinate > that.xCoordinate) { return +1; }
      else if (xCoordinate < that.xCoordinate) { return -1; }
      else { return 0; }
    }
  }
  
  public double slopeTo(Point that) {
    if ((xCoordinate == that.xCoordinate) && (yCoordinate == that.yCoordinate)) return Double.NEGATIVE_INFINITY;
    else if (yCoordinate == that.yCoordinate) return 0.0;
    else if (xCoordinate == that.xCoordinate) return Double.POSITIVE_INFINITY;
    else return ((double)(that.yCoordinate - yCoordinate)/(double)(that.xCoordinate - xCoordinate));
  }
  
  public Comparator<Point> slopeOrder() {
    return new SlopeOrderComparator();
  }
}
