import java.util.ArrayList;

public class BlockGene{
    ArrayList<Block> elemBlocks = new ArrayList<Block>();

    //Game block declaration
    boolean[][][] st = {{{true}}};
    Block start = new Block(null, 
                            new Point3D(0, 0, 0), 
                            st,  
                            "StadiumRoadMainStartLine");
}