package other;
import java.util.*;

/*
 * https://oj.leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnALine {
	static class Point {
		     int x;
		     int y;
		     Point() { x = 0; y = 0; }
		     Point(int a, int b) { x = a; y = b; }
	}
	
    public int maxPoints(Point[] points) {
    	if(points.length <=2) return points.length;
    	int maxPoints = 0;
        HashMap<ArrayList<Float>, HashSet<Point>> lines = 
        		new HashMap<ArrayList<Float>, HashSet<Point>>(); 
        for(int i = 0; i<points.length-1;i++) {
        	for(int j = i+1;j<points.length;j++) {
        		Point p1 = points[i];
        		Point p2 = points[j];
        		float a,b,c = 0;
        		if(p2.x - p1.x != 0) {
        			a = ((float) p2.y - p1.y)/((float)p2.x - p1.x);
        			b = 1;
        			c = p1.y - a*p1.x;
        		} else {
        			a = 1;
        			b = 0;
        			c = -p1.x;
        		}
        		ArrayList<Float> triplet = new ArrayList<Float>();
        		triplet.add(a);
        		triplet.add(b);
        		triplet.add(c);
        		if(lines.containsKey(triplet)) {
           			HashSet<Point> pointSet = lines.get(triplet);
        			pointSet.add(p1);
        			pointSet.add(p2);
        			if(pointSet.size() > maxPoints) maxPoints = pointSet.size();
        		} else {
        			HashSet<Point> pointSet = new HashSet<Point>();
        			pointSet.add(p1);
        			pointSet.add(p2);
        			lines.put(triplet, pointSet);
        			if(pointSet.size() > maxPoints) maxPoints = pointSet.size();
        		}
        	}
        }
    	return maxPoints;
    }
    
    public static void main(String[] args) {
    	MaxPointsOnALine solution = new MaxPointsOnALine();
		Point[] points = { 
				new Point(1, -7)
				, new Point(2, -9)
				, new Point(1,2), new Point(4, -13),
				new Point(2, 4), new Point(3,1), new Point(4, -2), new Point(5,-5), new Point(6, -8),
				new Point(1,2), new Point(1,3), new Point(1,4), new Point(1,5), new Point(1,6), new Point(1,7),
				new Point(2,1), new Point(3,1), new Point(4,1), new Point(5,1), new Point(6,1), new Point(7,1), new Point(8,1), new Point(9,1) 
				};
		System.out.println(solution.maxPoints(points));
	}
	
}
