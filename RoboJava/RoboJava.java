import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class RoboJava{
	public static void imprimir(ArrayList<char[]>map){
		for (char [] row : map) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i]);
			}
			System.out.println();
		}
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
    	//System.out.println(mover(map, posy, posx, maxy-1, maxx-1));
    }
}