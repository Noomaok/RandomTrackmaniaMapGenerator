public class Block{

    private Point3D vectEntry;
    private Point3D vectExit;
    private boolean[][][] spaceOccupied;
    private String blockId;

    public Block(Point3D vEntry, Point3D vExit, boolean[][][] spOc, String idBlock){
        this.vectEntry = vEntry;
        this.vectExit = vExit;
        this.blockId = idBlock;
        this.spaceOccupied = spOc;
    }

    public Point3D getEntry(){return vectEntry;}
    public Point3D getExit(){return vectExit;}
    public Point3D getExtrem(){return extremPoint;}
    public String getId(){return blockId;}
    public boolean[][][] getSpace(){return spaceOccupied;}
}