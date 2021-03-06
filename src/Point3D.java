public class Point3D{

    private double x;
    private double y;
    private double z;

    public Point3D(double xValue, double yValue, double zValue){
        this.x = xValue;
        this.y = yValue;
        this.z = zValue;
    }

    public Point3D(String s){
        String[] values = s.split("_");
        this.x = Double.parseDouble(values[0]);
        this.y = Double.parseDouble(values[1]);
        this.z = Double.parseDouble(values[2]);
    }

    public Point3D(double[] values){
        this(values[0],values[1],values[2]);
    }

    public Point3D(int xValue, int yValue, int zValue){
        this.x = (double)(xValue);
        this.y = (double)(yValue);
        this.z = (double)(zValue);
    }

    public double getX(){return x;}

    public double getY(){return y;}

    public double getZ(){return z;}
}