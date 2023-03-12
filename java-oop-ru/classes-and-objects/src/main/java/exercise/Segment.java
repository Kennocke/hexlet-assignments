package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;
    private Point midPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;

        int midPointX = (beginPoint.getX() + endPoint.getX()) / 2;
        int midPointY = (beginPoint.getY() + endPoint.getY()) / 2;
        this.midPoint = new Point(midPointX, midPointY);
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        return midPoint;
    }
}
// END
