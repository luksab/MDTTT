import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TicTacToe
{
    private ArrayList<Field> Fields = new ArrayList<Field>();
    private int dim;
    private boolean won;
    private boolean tie;
    private Checker checker = new Checker();
    private SimpleAI ai;

    public TicTacToe(int Dim){
        this.dim = dim;
        ai = new SimpleAI(dim);
    }

    public int aiTurn(){
        if(!tie && !won){
            Fields.add(ai.setze(Fields));
            if(checkWin())
                return 1;
            return 0;
        }
        return -1;
    }

    public ArrayList<Field> getFields(){
        return Fields;
    }

    public int realPlayerOf(Field Field){
        for(int i=0;i<Fields.size();i++){
            int zähler = 0;
            for(int j=0;j<dim;j++){
                if(Fields.get(i).getCoord(j) == Field.getCoord(j))
                    zähler++;
            }
            if(zähler == dim){
                return Fields.get(i).player;
            }
        }
        return -1;
    }

    private boolean check(Field Field){
        if(Field.dim == dim && !checkTie()){
            try{
                for(int i=0;i<dim;i++){
                    if(!(Field.getCoord(i)>=0&&Field.getCoord(i)<=dim)){
                        return false;
                    }
                }
                if(realPlayerOf(Field) == -1){
                    return true;
                }
                else{
                    return false;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        else
            return false;
    }

    public int click(Field field){
        if(check(field) && !tie && !won && (field.player == 0 || field.player == 1)){
            if(checkWin()){
                Fields.add(field);
                return 1;
            }
            else{
                Fields.add(field);
                return 0;
            }
        }
        else{
            return -1;
        }
    }

    public boolean checkWin(){
        if(checker.checkWin(Fields)){
            won = true;
            return true;
        }
        else {return false;}
    }
    
    public boolean checkTie(){
        if(Fields.size() >= Math.pow(dim+1,dim)){
            tie = true;
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Field> getWin(){
        return checker.GetWin(Fields);
    }
}
