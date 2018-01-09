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

    private Blocks[] blockList;
    private JButton generate;
    private JSlider lengthMap;
    private JLabel curLengthMap;
    private JTextArea mapTextArea;

    public Generator(){
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
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < blockStringLoad.size(); i++) {
            String[] bInfo = blockStringLoad.get(i).split("/");
            blockList[i] = new Blocks(Double.parseDouble(bInfo[0]), Double.parseDouble(bInfo[1]), Double.parseDouble(bInfo[2]), Integer.parseInt(bInfo[3]), Integer.parseInt(bInfo[4]), Integer.parseInt(bInfo[5]));
        }
        
        //Load presets
        //Not needed actualy
    }

    public void actionPerformed(ActionEvent e){
        generateMap();
    }

    public void generateMap(){
        String mapStringExpression = "";

        //Generate random start
        int x = (int)(Math.random()*(MAP_SIZE-1))+1;
        int y = (int)(Math.random()*(7))+9;
        int z = (int)(Math.random()*(MAP_SIZE-1))+1;
        int orient = (int)(Math.random()*(4));

        mapStringExpression += x+"/"+y+"/"+z+"/"+9+"/"+orient;

        mapTextArea.setText(mapStringExpression);
    }
}