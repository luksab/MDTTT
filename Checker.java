import java.util.*;
import java.lang.Math;
import java.io.*;
public class Checker implements
java.io.Serializable
{
    private int dim;
    public Checker(int dim)
    {
        this.dim = dim;
    }

    public boolean checkWin(ArrayList<Field> Fields){
        boolean won = false;
        //System.out.println(Fields.size());
        Field lastField = Fields.get(Fields.size()-1);
        int[] P = new int[dim];
        int[] D = new int[dim];
        int sp = lastField.player;
        for(int j=0; j<(int)(Math.pow(3,dim-1)/2)+Math.pow(3,dim-1) ; j++){
            for (int i=0;i<dim;i++){
                if( (j/(int)(Math.pow(3,i))) % 3 == 0){P[i] = 0;D[i] = 1;}
                else if((j/(int)(Math.pow(3,i)))%3==1){P[i] = lastField.getCoord(i);D[i] = 0;}
                else{P[i] = dim;D[i] = -1;}
            }
            for(int i=0; i<Fields.size() -1;i++){
                int counter = 0;
                for(int h=0;h<dim;h++){
                    if(lastField.getCoord(h) + D[h] == Fields.get(i).getCoord(h)){
                        counter++;
                    }
                }
                int counter2 = 0;
                for(int h=0;h<dim;h++){
                    if(lastField.getCoord(h) - D[h] == Fields.get(i).getCoord(h)){
                        counter2++;
                    }
                }
                if(counter == dim || counter2 == dim){
                    for (int m=0;m<dim;m++){
                        if( (j/(int)(Math.pow(3,m))) % 3 == 0){P[m] = 0;}
                        else if((j/(int)(Math.pow(3,m)))%3==1){P[m] = lastField.getCoord(m);}
                        else{P[m] = dim;}
                    }
                    int counter3 = 0;
                    for(int k=0;k<dim+1;k++){
                        ArrayList<Integer> CheckArray = new ArrayList<Integer>();
                        for(int m=0;m<dim;m++){
                            CheckArray.add(P[m]);
                        }
                        Field CheckField = new Field(CheckArray);
                        if(realPlayerOf(CheckField,Fields) == sp){
                            counter3 ++;
                        }
                        for(int m=0;m<=dim-1;m++){
                            P[m] += D[m];
                        }
                    }
                    if(counter3 == dim+1)
                    {
                        won = true;
                    }
                }
                if(won)break; // prevent unnecessary loops
            }
        }
        return won;
    }

    public ArrayList<Field> GetWin(ArrayList<Field> Fields){
        boolean won = false;
        int dim = Fields.get(0).dim;
        Field lastField = Fields.get(Fields.size()-1);
        int[] P = new int[dim];
        int[] D = new int[dim];
        int sp = lastField.player;
        ArrayList<Field> wonWith = new ArrayList<Field>();
        for(int j=0; j<(int)(Math.pow(3,dim-1)/2)+Math.pow(3,dim-1) ; j++){
            for (int i=0;i<dim;i++){
                if( (j/(int)(Math.pow(3,i))) % 3 == 0){P[i] = 0;D[i] = 1;}
                else if((j/(int)(Math.pow(3,i)))%3==1){P[i] = lastField.getCoord(i);D[i] = 0;}
                else{P[i] = dim;D[i] = -1;}
            }
            for(int i=0; i<Fields.size() -1;i++){
                int counter = 0;
                for(int h=0;h<dim;h++){
                    if(lastField.getCoord(h) + D[h] == Fields.get(i).getCoord(h)){
                        counter++;
                    }
                }
                int counter2 = 0;
                for(int h=0;h<dim;h++){
                    if(lastField.getCoord(h) - D[h] == Fields.get(i).getCoord(h)){
                        counter2++;
                    }
                }
                if(counter == dim || counter2 == dim){
                    for (int m=0;m<dim;m++){
                        if( (j/(int)(Math.pow(3,m))) % 3 == 0){P[m] = 0;}
                        else if((j/(int)(Math.pow(3,m)))%3==1){P[m] = lastField.getCoord(m);}
                        else{P[m] = dim;}
                    }
                    int counter3 = 0;
                    for(int k=0;k<dim+1;k++){
                        ArrayList<Integer> PArray = new ArrayList<Integer>();
                        for(int m=0;m<dim;m++){
                            PArray.add(P[m]);
                        }
                        Field PField = new Field(PArray);
                        if(realPlayerOf(PField,Fields) == sp){
                            wonWith.add(PField);
                            counter3 ++;
                        }
                        for(int m=0;m<=dim-1;m++){
                            P[m] += D[m];
                        }
                    }
                    if(counter3 == dim+1)
                    {
                        won = true;
                    }
                    else{
                        wonWith.clear();
                    }
                }
                if(won)break;
            }
        }
        return wonWith;
    }

    public int realPlayerOf(Field Field,ArrayList<Field> Fields){
        int dim = Field.dim;
        for(int i=0;i<Fields.size();i++){
            int counter = 0;
            for(int j=0;j<dim;j++){
                if(Fields.get(i).getCoord(j) == Field.getCoord(j))
                    counter++;
            }
            if(counter == dim){
                return Fields.get(i).player;
            }
        }
        return -1;
    }
}