public class Block{

    private Point3D extremPoint;
    private Point3D vectEntry;
    private Point3D vectExit;
    private boolean[][][] spaceOccupied;
    private int blockId;

    public Block(Point3D exPoint, Point3D vEntry, Point3D vExit, String spaceString, int idBlock){
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

    public Point3D getEntry(){return vectEntry;}
    public Point3D getExit(){return vectExit;}
    public Point3D getExtrem(){return extremPoint;}
    public int getId(){return blockId;}
}