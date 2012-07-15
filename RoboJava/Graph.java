import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph{
	private ArrayList<char[]> map;
	private ArrayList<Integer> lambdas;
	private ArrayList<Integer> cll; //close lambda lift 
	private ArrayList<Integer> oll; //open lambda lift
	private HashMap<Integer,Integer> stars; //stars in the map
	HashMap<Integer, HashMap<Integer,HashMap<Integer, Integer > > > graph;
	private int posy, posx;
	
	public Graph(ArrayList<char[]> map, long posy, long posx){
		this.map = map;
		lambdas = new ArrayList<Integer>();
		cll = new ArrayList<Integer>();
		oll = new ArrayList<Integer>();
		stars = new HashMap<Integer, Integer>();
		graph = new HashMap<Integer, HashMap<Integer,Integer> >();
		this.posx=posx;
		this.posy=posy;
	}
	
	private boolean muveUp(long y){
		return y>=0;
	}
	private boolean moveDow(long y){
		return y<map.size();
	}
	private boolean moveLeft(long x){
		return x>=0;
	}
	private boolean moveRigth(long x){
		return x<map.get(0).length;
	}
	
	/**
	 * Function to implement the algorithm Disjkstra and save information about map
	 */
	public HashMap<Integer, HashMap<Integer,Integer> > dijkstra(){
		Queue<Integer>visitor = new Queue<Integer>();
		ArrayList<char[]> mapClone = map.clone();//clne is new for me
		long index=0;
		visitor.add(index);
		while(!visitor.isEmpty()){
			mapClone.get(y)[x]='v';
			if(moveUp(y-1)){
				char up=mapClone.get(y-1)[x];
				switch (up) {
					case '.' : mapClone.get(y-1)[x]='v';
					   		   visitor.add(index++);
					   		   break;
					case ' ' : mapClone.get(y-1)[x]='v';
							   visitor.add(index++);
							   break;
					case '\\': mapClone.get(y-1)[x]='v';
					   		   visitor.add(index++);
					   		   lambdas.add(index);
					   		   break;
					case 'O' : mapClone.get(y-1)[x]='v';//TODO warning
			   		   		   visitor.add(index++);
			   		           oll.add(index);
			   		           break;
					case 'L' : mapClone.get(y-1)[x]='v';
	   		   		   		   visitor.add(index++);
	   		   		   		   cll.add(index);
	   		   		   		   break;
					case '*' : mapClone.get(y-1)[x]='v';
	   		   		   		   stars.add(y-1,x);
	   		   		   		   break;
					case '#' : break;
					default:
							break;
				}
			}
		}
	}
}