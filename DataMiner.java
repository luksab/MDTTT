import java.io.*;
import com.google.gson.Gson;
import java.util.*;
public class DataMiner
{
    TicTacToe TTT;
    int dim;
    String dir;
    Gson gson;
    BufferedWriter out;
    public DataMiner(int dim, String dir)
    {
        this.dim = dim;
        this.dir = dir;
        gson = new Gson();
    }

    public void generate(int y)
    {
        File directory = new File(System.getProperty("user.home")+"/"+dir+"/");
        directory.mkdir();
        String fileName;
        for(int i=0;i<y;i++){
            TicTacToe TTT = new TicTacToe(dim);
            fileName = "";
            boolean gameHasEnded = false;
            boolean activePlayer = false;
            while(!gameHasEnded){
                int ai = TTT.aiTurn();
                if(TTT.checkTie()){
                    fileName = System.getProperty("user.home")+"/"+dir+"/"+0+""+i+".json";
                    gameHasEnded=true;
                }
                else if(TTT.checkEnd()){
                    if(!activePlayer){
                        fileName = System.getProperty("user.home")+"/"+dir+"/"+1+""+i+".json";
                        gameHasEnded=true;
                    }
                    else{
                        fileName = System.getProperty("user.home")+"/"+dir+"/"+2+""+i+".json";
                        gameHasEnded=true;
                    }
                }
                activePlayer = !activePlayer;
            }
            try{
                out = new BufferedWriter(new FileWriter(fileName));
                out.write(gson.toJson(TTT.getFields()));
                //System.out.println(gson.toJson(TTT.getFields()));
            }
            catch(Exception e){
                System.out.println(e);
            }
            finally
            {
                try
                {
                    if ( out != null)
                        out.close( );
                }
                catch ( IOException e)
                {
                }
            }
        }
    }
}
