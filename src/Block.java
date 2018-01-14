public class Block{

    private Vector3D spaceOccupied;
    private Vector3D placementPoint;
    private Vector3D vectEntry;
    private Vector3D vectExit;

    public Block(Vector3D spOccupied, Vector3D pPoint, Vector3D vEntry, Vector3D vExit){
        this.spaceOccupied = spOccupied;
        this.placementPoint = pPoint;
        this.vectEntry = vEntry;
        this.vectExit = vExit;
    }

    public Vector3D getEntry(){return vectEntry;}
    public Vector3D getExit(){return vectExit;}
    public Vector3D getSpace(){return spaceOccupied;}
    public Vector3D getPlacement(){return placementPoint;}
    
}