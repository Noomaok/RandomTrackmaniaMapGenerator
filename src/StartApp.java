import javax.swing.UIManager;

public class StartApp{

    public static void main(String[] args) {
        try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			System.out.println(e);
        }

        new Generator();
    }
}