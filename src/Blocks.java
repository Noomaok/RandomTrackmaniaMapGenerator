public class Blocks{

    private Vector3D relEndPoint;
    private int blockID;
    private int startOrient;
    private int endOrient;

    public Blocks(Vector3D rePoint, int idBlock, int sOrient, int eOrient){
        this.relEndPoint = rePoint;
        this.blockID = idBlock;
        this.startOrient = sOrient;
        this.endOrient = eOrient;
    }

    public Blocks(double xEnd, double yEnd, double zEnd, int idBlock, int sOrient, int eOrient){
        this(new Vector3D(xEnd, yEnd, zEnd), idBlock, sOrient, eOrient);
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