
public class Inimigo2 {
  int x, y;
    int [ ] [ ] enemytype2 = {   				   
				    { 0,0,6,0,0,0,0,0,6,0,0,0 },
				    { 6,0,0,6,0,0,0,6,0,0,6,0 },
				    { 6,0,6,6,6,6,6,6,6,0,6,0 },
                                    { 6,6,6,4,6,6,6,4,6,6,6,0 },
				    { 0,6,6,6,6,6,6,6,6,6,0,0 },				    
				    { 0,6,6,6,4,4,4,6,6,6,0,0 },
				    { 0,0,6,0,0,0,0,0,6,0,0,0 },
				    { 0,6,0,0,0,0,0,0,0,6,0,0 }

		  };

		 
    public int[][] getMatrix(){
        return enemytype2;  
    }
    public int getX(){
        return x;  
    }
    public int getY(){
        return y;  
    }
    public void setX(int paramX){
        x = paramX;
    }
    public void setY(int paramY){
        y = paramY;
    }
    
  
}
