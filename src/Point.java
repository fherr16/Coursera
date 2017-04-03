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
      else slopeWithThatOne = ((thatOne.yCoordinate - yCoordinate)/(thatOne.xCoordinate - xCoordinate));
      
      if ((xCoordinate == thisOne.xCoordinate) && (yCoordinate == thisOne.yCoordinate)) slopeWithThisOne = Double.NEGATIVE_INFINITY;
      else if (yCoordinate == thisOne.yCoordinate) slopeWithThisOne = 0.0;
      else if (xCoordinate == thisOne.xCoordinate) slopeWithThisOne = Double.POSITIVE_INFINITY;
      else slopeWithThisOne = ((thisOne.yCoordinate - yCoordinate)/(thisOne.xCoordinate - xCoordinate));
      
      if (slopeWithThatOne > slopeWithThisOne) { return +1; }
      else if (slopeWithThatOne < slopeWithThisOne) { return -1; }
      else { return 0; }
    }
  }
  
  public Point(int x, int y) {
    this.xCoordinate = x;
    this.yCoordinate = y;
  }
  
  public void draw() {
    StdDraw.point(this.xCoordinate, this.yCoordinate);
  }
  
  public void drawTo(Point that) {
    StdDraw.line(this.xCoordinate, this.yCoordinate, that.xCoordinate, that.yCoordinate);
  }
  
  public String toString() {
    return "(" + this.xCoordinate + ", " + this.yCoordinate + ")";
  }
  
  public int compareTo(Point that) {
    if (this.yCoordinate > that.yCoordinate) { return +1; }
    else if (this.yCoordinate < that.yCoordinate) { return -1; }
    else {
      if (this.xCoordinate > that.xCoordinate) { return +1; }
      else if (this.xCoordinate < that.xCoordinate) { return -1; }
      else { return 0; }
    }
  }
  
  public double slopeTo(Point that) {
    if ((this.xCoordinate == that.xCoordinate) && (this.yCoordinate == that.yCoordinate)) return Double.NEGATIVE_INFINITY;
    else if (this.yCoordinate == that.yCoordinate) return 0.0;
    else if (this.xCoordinate == that.xCoordinate) return Double.POSITIVE_INFINITY;
    else return ((that.yCoordinate - this.yCoordinate)/(that.xCoordinate - this.xCoordinate));
  }
  
  public Comparator<Point> slopeOrder() {
    return new SlopeOrderComparator();
  }
}
