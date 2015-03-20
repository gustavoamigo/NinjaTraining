package other;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

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
        for(Entry<ArrayList<Float>, HashSet<Point>> entry : lines.entrySet()) {
        	HashSet<Point> pointSet = entry.getValue();
        	ArrayList<Float> triplet = entry.getKey();
        	if(pointSet.size() == maxPoints) {
        		System.out.printf("Triplet %f | %f | %f\n", triplet.get(0), triplet.get(1), triplet.get(2));
        		for(Point p : pointSet) {
        			
        			System.out.printf("%d | %d\n", p.x, p.y);
        		}
        	}
        }
    	return maxPoints;
    }
    
    public static void main(String[] args) {
    	MaxPointsOnALine solution = new MaxPointsOnALine();
    	int[] ps = {560,248,0,16,30,250,950,187,630,277,950,187,-212,-268,-287,-222,53,37,-280,-100,-1,-14,-5,4,-35,-387,-95,11,-70,-13,-700,-274,-95,11,-2,-33,3,62,-4,-47,106,98,-7,-65,-8,-71,-8,-147,5,5,-5,-90,-420,-158,-420,-158,-350,-129,-475,-53,-4,-47,-380,-37,0,-24,35,299,-8,-71,-2,-6,8,25,6,13,-106,-146,53,37,-7,-128,-5,-1,-318,-390,-15,-191,-665,-85,318,342,7,138,-570,-69,-9,-4,0,-9,1,-7,-51,23,4,1,-7,5,-280,-100,700,306,0,-23,-7,-4,-246,-184,350,161,-424,-512,35,299,0,-24,-140,-42,-760,-101,-9,-9,140,74,-285,-21,-350,-129,-6,9,-630,-245,700,306,1,-17,0,16,-70,-13,1,24,-328,-260,-34,26,7,-5,-371,-451,-570,-69,0,27,-7,-65,-9,-166,-475,-53,-68,20,210,103,700,306,7,-6,-3,-52,-106,-146,560,248,10,6,6,119,0,2,-41,6,7,19,30,250};
    	int k =0;
    	Point[] points = new Point[98];
    	for(int i=0;i<98;i++) {
    		points[i] = new Point(ps[k++], ps[k++]);
    	}
    	
		System.out.println(solution.maxPoints(points));
	}
	
}
