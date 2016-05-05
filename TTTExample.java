import java.util.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.JOptionPane;

public class TTTExample extends JFrame {
    private JMenuBar menuBar;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private TicTacToe TTT;

    //Constructor 
    public TTTExample(){
        TTT = new TicTacToe(2);

        this.setTitle("TTTExample");
        this.setSize(310,310);
        //menu generate method

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(310,310));
        contentPane.setBackground(new Color(192,192,192));

        button1 = new JButton();
        button1.setBounds(20,20,90,90);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("");
        button1.setVisible(true);
        //Set action for button click
        //Call defined method
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b1(evt);
                }
            });

        button2 = new JButton();
        button2.setBounds(110,20,90,90);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("");
        button2.setVisible(true);
        //Set action for button click
        //Call defined method
        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b2(evt);
                }
            });

        button3 = new JButton();
        button3.setBounds(200,20,90,90);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("");
        button3.setVisible(true);
        //Set action for button click
        //Call defined method
        button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b3(evt);
                }
            });

        button4 = new JButton();
        button4.setBounds(20,110,90,90);
        button4.setBackground(new Color(214,217,223));
        button4.setForeground(new Color(0,0,0));
        button4.setEnabled(true);
        button4.setFont(new Font("sansserif",0,12));
        button4.setText("");
        button4.setVisible(true);
        //Set action for button click
        //Call defined method
        button4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b4(evt);
                }
            });

        button5 = new JButton();
        button5.setBounds(110,110,90,90);
        button5.setBackground(new Color(214,217,223));
        button5.setForeground(new Color(0,0,0));
        button5.setEnabled(true);
        button5.setFont(new Font("sansserif",0,12));
        button5.setText("");
        button5.setVisible(true);
        //Set action for button click
        //Call defined method
        button5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b5(evt);
                }
            });

        button6 = new JButton();
        button6.setBounds(200,110,90,90);
        button6.setBackground(new Color(214,217,223));
        button6.setForeground(new Color(0,0,0));
        button6.setEnabled(true);
        button6.setFont(new Font("sansserif",0,12));
        button6.setText("");
        button6.setVisible(true);
        //Set action for button click
        //Call defined method
        button6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b6(evt);
                }
            });

        button7 = new JButton();
        button7.setBounds(20,200,90,90);
        button7.setBackground(new Color(214,217,223));
        button7.setForeground(new Color(0,0,0));
        button7.setEnabled(true);
        button7.setFont(new Font("sansserif",0,12));
        button7.setText("");
        button7.setVisible(true);
        //Set action for button click
        //Call defined method
        button7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b7(evt);
                }
            });

        button8 = new JButton();
        button8.setBounds(110,200,90,90);
        button8.setBackground(new Color(214,217,223));
        button8.setForeground(new Color(0,0,0));
        button8.setEnabled(true);
        button8.setFont(new Font("sansserif",0,12));
        button8.setText("");
        button8.setVisible(true);
        //Set action for button click
        //Call defined method
        button8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b8(evt);
                }
            });

        button9 = new JButton();
        button9.setBounds(200,200,90,90);
        button9.setBackground(new Color(214,217,223));
        button9.setForeground(new Color(0,0,0));
        button9.setEnabled(true);
        button9.setFont(new Font("sansserif",0,12));
        button9.setText("");
        button9.setVisible(true);
        //Set action for button click
        //Call defined method
        button9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    b9(evt);
                }
            });

        //adding components to contentPane panel
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(button4);
        contentPane.add(button5);
        contentPane.add(button6);
        contentPane.add(button7);
        contentPane.add(button8);
        contentPane.add(button9);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for button1
    private void b1 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(0);
        Array.add(0);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button1.setText("X");
        }
        else if(var == 1){
            button1.setText("O");
        }
        else if(var == 2){
            button1.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button1.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method actionPerformed for button2
    private void b2 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(0);
        Array.add(1);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button2.setText("X");
        }
        else if(var == 1){
            button2.setText("O");
        }
        else if(var == 2){
            button2.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button2.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method actionPerformed for button3
    private void b3 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(0);
        Array.add(2);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button3.setText("X");
        }
        else if(var == 1){
            button3.setText("O");
        }
        else if(var == 2){
            button3.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button3.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method actionPerformed for button4
    private void b4 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(1);
        Array.add(0);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button4.setText("X");
        }
        else if(var == 1){
            button4.setText("O");
        }
        else if(var == 2){
            button4.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button4.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method actionPerformed for button5
    private void b5 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(1);
        Array.add(1);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button5.setText("X");
        }
        else if(var == 1){
            button5.setText("O");
        }
        else if(var == 2){
            button5.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button5.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method actionPerformed for button6
    private void b6 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(1);
        Array.add(2);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button6.setText("X");
        }
        else if(var == 1){
            button6.setText("O");
        }
        else if(var == 2){
            button6.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button6.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method actionPerformed for button7
    private void b7 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(2);
        Array.add(0);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button7.setText("X");
        }
        else if(var == 1){
            button7.setText("O");
        }
        else if(var == 2){
            button7.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button7.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method actionPerformed for button8
    private void b8 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(2);
        Array.add(1);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button8.setText("X");
        }
        else if(var == 1){
            button8.setText("O");
        }
        else if(var == 2){
            button8.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button8.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method actionPerformed for button9
    private void b9 (ActionEvent evt) {
        ArrayList<Integer> Array = new ArrayList<Integer>();
        Array.add(2);
        Array.add(2);
        int var = TTT.click(new Field(Array));
        if(var == 0){
            button9.setText("X");
        }
        else if(var == 1){
            button9.setText("O");
        }
        else if(var == 2){
            button9.setText("X");
            JOptionPane.showMessageDialog(null, "X Won!", "X Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(var == 3){
            button9.setText("O");
            JOptionPane.showMessageDialog(null, "O Won!", "O Won!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"You Cannot Click here.","You Cannot Click here.",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new TTTExample();
                }
            });
    }

}