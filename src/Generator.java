import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Generator extends JFrame implements ActionListener{
    
    private Blocks[] blockList;
    private JButton generate;
    private JSlider lengthMap;
    private JLabel curLengthMap;

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

        container.add(param);
        container.add(generate);

        this.getContentPane().add(container);

        //Show fen
        this.setVisible(true);


        //Load blocks


        //Load presets



    }

    public void actionPerformed(ActionEvent e){

    }
}