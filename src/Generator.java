import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Generator extends JFrame implements ActionListener{
    
    private final int MAP_SIZE = 32;

    private Block[] blockList;
    private JButton generate;
    private JSlider lengthMap;
    private JLabel curLengthMap;
    private JTextArea mapTextArea;
    private boolean[][][] map = new boolean[32][39][32];

    public Generator(){
        //Fill boolean map with false => no block placed
        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                for(int k = 0; k<map[0][0].length; k++){
                    map[i][j][k] = false;
                }
            }
        }

        //Create fenetre
        this.setTitle("Map Generator");
        this.setSize(400,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        JPanel param = new JPanel();
        param.setLayout(new BoxLayout(param, BoxLayout.LINE_AXIS));
        param.add(new JLabel("Length of the map : "));

        curLengthMap = new JLabel("30");
        
        lengthMap = new JSlider();
        lengthMap.setMaximum(100);
        lengthMap.setMinimum(20);
        lengthMap.setValue(30);
        lengthMap.setPaintLabels(true);
        lengthMap.setPaintTicks(true);
        lengthMap.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent arg0) {
                JSlider slider = (JSlider)arg0.getSource();
                curLengthMap.setText(String.valueOf(slider.getValue()));
            }
        });

        param.add(lengthMap);
        param.add(curLengthMap);

        TitledBorder titleParam = new TitledBorder("Parameter");
        param.setBorder(titleParam);

        //Connecte butt
        generate = new JButton("Generate Map");
        generate.addActionListener(this);

        //Text where the map while be generate
        mapTextArea = new JTextArea();
        mapTextArea.setLineWrap(true);

        container.add(param);
        container.add(generate);
        container.add(mapTextArea);

        this.getContentPane().add(container);

        //Show fen
        this.setVisible(true);

        //Load blocks
        ArrayList<String> blockStringLoad = new ArrayList<String>();
        File blockFile = new File("block.txt");
        try {
            Scanner sc = new Scanner(blockFile);
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                blockStringLoad.add(s);
            }
            sc.close();    
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        blockList = new Block[blockStringLoad.size()];

        for (int i = 0; i < blockStringLoad.size(); i++) {
            String[] bInfo = blockStringLoad.get(i).split("/");
            Vector3D extremPoint = new Vector3D(bInfo[0]);
            Vector3D vectorEntry = new Vector3D(bInfo[1]);
            Vector3D vectorExit = new Vector3D(bInfo[2]);
            blockList[i] = new Block(extremPoint,vectorEntry,vectorExit,bInfo[3],Integer.parseInt(bInfo[4]));
        }
        
        //Load presets
        //Not needed actualy
    }

    public void actionPerformed(ActionEvent e){
        generateMap();
    }

    public void generateMap(){
        String mapStringExpression = "";
        int currentX;
        int currentY;
        int currentZ;
        int currentDir;

        //Generate random start
        currentX = (int)(Math.random()*(MAP_SIZE-1))+1;
        currentY = (int)(Math.random()*(30))+9;
        currentZ = (int)(Math.random()*(MAP_SIZE-1))+1;
        currentDir = (int)(Math.random()*(4));

        map[currentX][currentY][currentZ] = true;

        mapStringExpression +=currentX+"/"+currentY+"/"+currentZ+"/"+9+"/"+currentDir;

        /*
        currentX = (int)(Math.random()*(MAP_SIZE-1))+1;
        currentY = (int)(Math.random()*(30))+9;
        currentZ = (int)(Math.random()*(MAP_SIZE-1))+1;
        currentDir = (int)(Math.random()*(4));

        mapStringExpression +="/"+currentX+"/"+currentY+"/"+currentZ+"/"+blockList[0].getId()+"/"+currentDir;
        */
        
        //while map length not done add blocks
        int i = 0;
        while(i<1){
            i++;
            int r = (int)(Math.random()*blockList.length);
            Block blockToPlace = blockList[r];

            Vector3D vectPos = updatePosition(currentX, currentY, currentZ, currentDir);
            currentX = (int)(vectPos.getX());
            currentY = (int)(vectPos.getY());
            currentZ = (int)(vectPos.getZ());
            
            //Verif place

        }

        mapTextArea.setText(mapStringExpression);
    }

    public Vector3D updatePosition(int currentX, int currentY, int currentZ, int currentDir){
        switch(currentDir){
            case 0:
                currentZ++;
                break;
            case 1:
                currentX--;
                break;
            case 2:
                currentZ--;
                break;
            case 3:
                currentX++;
                break;
            default:
                break;
        }

        Vector3D newVector = new Vector3D(currentX, currentY, currentZ);
        return newVector;
    }
    
}