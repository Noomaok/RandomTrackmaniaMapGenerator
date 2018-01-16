public class Block{

    private Vector3D extremPoint;
    private Vector3D vectEntry;
    private Vector3D vectExit;
    private boolean[][][] spaceOccupied;
    private int blockId;

    public Block(Vector3D exPoint, Vector3D vEntry, Vector3D vExit, String spaceString, int idBlock){
        this.extremPoint = exPoint;
        this.vectEntry = vEntry;
        this.vectExit = vExit;
        this.blockId = idBlock;
        
        spaceOccupied = new boolean[(int)(extremPoint.getX())][(int)(extremPoint.getY())][(int)(extremPoint.getZ())];
        
        int index = 0;
        for(int i = 0; i<spaceOccupied.length; i++){
            for(int j = 0; j<spaceOccupied[0].length; j++){
                for(int k = 0; k<spaceOccupied[0][0].length; k++){
                    spaceOccupied[i][j][k] = (spaceString.charAt(index) == '1');
                    index++;
                }
            }
        }
    }

    public Vector3D getEntry(){return vectEntry;}
    public Vector3D getExit(){return vectExit;}
    public Vector3D getExtrem(){return extremPoint;}
    public int getId(){return blockId;}
}