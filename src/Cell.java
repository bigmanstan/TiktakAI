/**
 * Created by bigmanstan on 17/9/17.
 */

public class Cell{

    private int x;
    private int y;
    private int minmaxvalue;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return this.x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return this.y;
    }

    public void SetminmaxValue( int minmaxvalue){
        this.minmaxvalue = minmaxvalue;
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
}

