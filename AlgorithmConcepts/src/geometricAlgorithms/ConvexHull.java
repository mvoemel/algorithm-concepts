package geometricAlgorithms;

import java.util.ArrayList;
import java.util.List;

/*
 	Given a set of points in the plane. The convex hull of the 
 	set is the smallest convex polygon that contains all the
 	points of the set. We use the Jarvis Wrap algorithm to
 	calculate the convex hull. The time complexity of the 
 	algorithm is O(m * n) and the worst case time complexity
 	is O(n^2). Auxiliary space is O(n).
 	
 	@author Michael Voemel
	@date 	21.09.2022
 */

public class ConvexHull {
	
	//returns list of points of convex hull of a set of n points
	public static List<Point> convexHull(Point points[], int n) {
		if (n<3) return null;
		
		ArrayList<Point> hull = new ArrayList<>();
		
		//find left most point
		int l = 0;
		for (int i=1; i<n; i++)
			if (points[i].x < points[l].x)
				l = i;
		
		int p = l, q;
		do {
			hull.add(points[p]);
			q = (p+1) % n;
			
			for (int i=0; i<n; i++)
				if (orientation(points[p], points[i], points[q]) == 2)
					q = i;
			
			p = q;
		} while (p != 1);
		
		return hull;
	}//end convexHull
	
	//returns an int 0, 1 or 2 which indicates how the ordered triplet is oriented
	private static int orientation(Point p, Point q, Point r) {
		int val = (q.y - p.y) * (r.x - q.x) -
                  (q.x - p.x) * (r.y - q.y);
		return (val == 0)? 0 /*collinear*/:
				(val > 0)? 1 /*clockwise*/: 2 /*counterclockwise*/;
	}
	
}//ConvexHull

class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}//Point
