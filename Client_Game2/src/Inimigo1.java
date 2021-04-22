
public class Inimigo1 {
     int x, y;
    int [ ] [ ] enemytype1 = {   				   
				    { 0,0,0,0,4,4,4,0,0,0,0 },
				    { 0,0,0,0,0,4,0,0,0,0,0 },
				    { 0,0,0,4,4,4,4,4,0,0,0 },
                                    { 0,0,4,1,4,4,4,1,4,0,0 },
				    { 0,0,4,4,4,4,4,4,4,0,0 },				    
				    { 0,0,4,4,1,1,1,4,4,0,0 },
				    { 0,0,4,0,0,0,0,0,4,0,0 },
				    { 0,0,0,4,4,0,4,4,0,0,0 }

		  };

		 
    public int[][] getMatrix(){
        return enemytype1;  
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
