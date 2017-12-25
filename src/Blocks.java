public class Blocks{
    
    private Vector3D relStartPoint;
    private Vector3D relEndPoint;
    private int blockID;
    private int startOrient;
    private int endOrient;

    public Blocks(Vector3D rsPoint, Vector3D rePoint, int idBlock, int sOrient, int eOrient){
        this.relStartPoint = rsPoint;
        this.relEndPoint = rePoint;
        this.blockID = idBlock;
        this.startOrient = sOrient;
        this.endOrient = eOrient;
    }

    public Vector3D getStartPoint(){
        return relStartPoint;
    }

    public Vector3D getEndPoint(){
        return relEndPoint;
    }

    public int getBlockId(){
        return blockID;
    }

    public int getStartOrient(){
        return startOrient;
    }

    public int getEndOrient(){
        return endOrient;
    }
}