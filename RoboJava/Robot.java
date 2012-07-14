import java.util.Scanner;
import java.util.ArrayList;
public class Robot{
	public static void imprimir(ArrayList<char[]>map){
		for (char [] row : map) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i]);
			}
			System.out.println();
		}
	}
	/*
	 * Function recursive to explore all map
	 */
	public static String mover (ArrayList<char []> map,int posy, int posx, int maxy,int maxx){
		if(posy < 0 || posx < 0 || posy > maxy || posx > maxx){
			return "";
		}
		if(map.get(posy)[posx]=='#'){
			return "";
		}
		if(map.get(posy)[posx]=='L'){
			return "";
		}
		else{
			if(map.get(posy)[posx]=='*'){
				/*TODO we need to verificate if we can move the rock*/
				return "";
			}
			map.get(posy)[posx]='p';
			String L = "L"+mover(map,posy,posx-1,maxy,maxx);
			String R = "R"+mover(map,posy,posx+1,maxy,maxx);
			String D = "D"+mover(map,posy+1,posx,maxy,maxx);
			String U = "U"+mover(map,posy-1,posx,maxy,maxx);
			return L+R+D+U+"|";
		}
	}
	/*
	 *	Function to move star to left or right dipend of the case 
	 */
	public static ArrayList<char[]> moveStar(ArrayList<char[]> map,int posx, int posy, char typeMove){
		switch (typeMove) {
			case 'L':  
				break;
			case 'R':
				break;
			default:
				break;
		}
		return map;
	}
	
    public static void main(String arg[]){
    	Scanner sc = new Scanner(System.in);
    	String line= "";
    	ArrayList<char[]> map = new ArrayList<char[]>();
    	int posx=0, posy=0, y=0, maxx=0, maxy=0;
    	while(sc.hasNext()){
    		line=sc.nextLine();
    		char [] row = new char[line.length()];
    		for(int i=0;i<line.length();i++){
    			row[i]=line.charAt(i);
    			if(line.charAt(i)=='R'){
    				posx=i;
    				posy=y;
    			}
    		}
    		y++;
    		map.add(row);
    	}
    	maxy=map.size();
    	maxx=map.get(0).length;
    	System.out.println("y= "+posy+" x= "+posx);
    	System.out.println("my= "+maxy+" mx= "+maxx);
    	imprimir(map);
    	System.out.println(mover(map, posy, posx, maxy-1, maxx-1));
    }
}
