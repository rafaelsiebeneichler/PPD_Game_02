

public class Inimigo3 {
      int x, y;
    int [ ] [ ] enemytype3 = {   				   
				    { 0,0,0,3,3,0,0,0 },
				    { 0,0,3,3,3,3,0,0 },
				    { 0,3,3,3,3,3,3,0 },
                                    { 3,3,1,3,3,1,3,3 },
				    { 3,3,3,3,3,3,3,3 },				    
				    { 0,0,3,1,1,3,0,0 },
				    { 0,3,0,3,3,0,3,0 },
				    { 3,0,3,0,0,3,0,3 }

		  };

		 
    public int[][] getMatrix(){
        return enemytype3;  
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
