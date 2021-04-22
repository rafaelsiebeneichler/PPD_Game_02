
public class Shot {
    public int []shotArray = new int[7];
    public int sizeShot = 0;
    int x, y;
    int [ ] [ ] shot = {   
                         { 3 }
                  };

		 
    public int[][] getMatrix(){
        return shot;  
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
