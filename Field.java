import java.util.*;
public class Field
{
    public ArrayList<Integer> coord = new ArrayList<Integer>();
    public int player;
    public int row;
    public String note = "";

    public Field(ArrayList<Integer> coord,int player)
    {
        this.coord = coord;
        this.player= player;
    }

    public Field(ArrayList<Integer> coord)
    {
        this.coord = coord;
    }

    public Field(int row,ArrayList<Integer> coord)
    {
        this.coord = coord;
        this.row = row;
    }

    public Field()
    {

    }

    public int getCoord(int dimension){
        return coord.get(dimension);
    }

    public String toString(){
        String s = ""+"Player: "+player;
        if(coord.size()>0){
            s += " coordinates: ";
            for(int i=0;i<coord.size()-1;i++){
                s += +coord.get(i)+"|";
            }
            s += +coord.get(coord.size()-1);
        }
        return s;
    }
}