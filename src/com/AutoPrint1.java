package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AutoPrint1 extends JFrame implements Runnable {

    JButton btn_start = new JButton("戳一次即可启动，请勿多次点击");
    JLabel label1 = new JLabel("版本：V1.0", JLabel.CENTER);
    JLabel label2 = new JLabel("功能：1.0版本目前仅支持间隔1分钟扣一次1并发送", JLabel.CENTER);
    JLabel label3 = new JLabel("更多功能敬请期待后续版本", JLabel.CENTER);

    Thread t ;

    public AutoPrint1() {

        this.setFrameAttr();
        buildCom();

        t = new Thread(this);

    }

    private void buildCom() {

        this.setLayout(new FlowLayout());
        this.add(btn_start);
        this.add(label1);
        this.add(label2);
        this.add(label3);


        btn_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.start();
            }
        });

    }

    private void setFrameAttr() {

        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setTitle("自动扣1！");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);


    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        AutoPrint1 autoPrint1 = new AutoPrint1();
        autoPrint1.setVisible(true);
    }

}
