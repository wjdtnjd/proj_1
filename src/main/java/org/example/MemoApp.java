package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MemoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Memo");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextArea textArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane);

            // 메모 목록을 저장할 리스트 생성
            List<String> memoList = new ArrayList<>();

            // 메모 추가 버튼
            JButton addButton = new JButton("Add Memo");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String memo = textArea.getText();
                    memoList.add(memo);
                    JOptionPane.showMessageDialog(frame, "Memo added successfully!");
                }
            });
            frame.add(addButton, BorderLayout.SOUTH);

            // 메모 조회 버튼
            JButton viewButton = new JButton("View Memos");
            viewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StringBuilder memoText = new StringBuilder();
                    for (String memo : memoList) {
                        memoText.append(memo).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(frame, memoText.toString());
                }
            });
            frame.add(viewButton, BorderLayout.NORTH);

            frame.setVisible(true);
        });
    }
}