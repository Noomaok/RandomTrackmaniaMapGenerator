public class Vector3D{

    private double x;
    private double y;
    private double z;

    public Vector3D(double xValue, double yValue, double zValue){
        this.x = xValue;
        this.y = yValue;
        this.z = zValue;
    }

    public Vector3D(double[] values){
        this(values[0],values[1],values[2]);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }
}