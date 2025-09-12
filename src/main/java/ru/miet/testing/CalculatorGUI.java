package ru.miet.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI implements CalculatorView {
    private JFrame frame;
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JLabel errorLabel;

    public CalculatorGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Input fields
        frame.add(new JLabel("First number:"));
        firstNumberField = new JTextField();
        frame.add(firstNumberField);

        frame.add(new JLabel("Second number:"));
        secondNumberField = new JTextField();
        frame.add(secondNumberField);

        // Buttons
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        // Добавляем кнопки в отдельную панель для лучшего расположения
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        buttonPanel.add(plusButton);
        buttonPanel.add(minusButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        
        frame.add(new JLabel("Operations:"));
        frame.add(buttonPanel);

        // Result field
        frame.add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        frame.add(resultField);

        // Error label
        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        frame.add(errorLabel);
        frame.add(new JLabel()); // Пустая ячейка для выравнивания

        // Добавляем слушателей для кнопок
        plusButton.addActionListener(e -> {
            // Presenter будет установлен извне
        });
        
        minusButton.addActionListener(e -> {
            // Presenter будет установлен извне
        });
        
        multiplyButton.addActionListener(e -> {
            // Presenter будет установлен извне
        });
        
        divideButton.addActionListener(e -> {
            // Presenter будет установлен извне
        });
    }

    @Override
    public void printResult(double result) {
        resultField.setText(String.valueOf(result));
        errorLabel.setText("");
    }

    @Override
    public void displayError(String message) {
        errorLabel.setText(message);
        resultField.setText("");
    }

    @Override
    public String getFirstArgumentAsString() {
        return firstNumberField.getText().trim();
    }

    @Override
    public String getSecondArgumentAsString() {
        return secondNumberField.getText().trim();
    }

    public void setPlusButtonListener(ActionListener listener) {
        // Находим кнопку "+" и устанавливаем слушатель
        Component[] components = frame.getContentPane().getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                Component[] panelComps = ((JPanel) comp).getComponents();
                for (Component panelComp : panelComps) {
                    if (panelComp instanceof JButton && ((JButton) panelComp).getText().equals("+")) {
                        ((JButton) panelComp).addActionListener(listener);
                    }
                }
            }
        }
    }

    public void setMinusButtonListener(ActionListener listener) {
        // Аналогично для других кнопок
        Component[] components = frame.getContentPane().getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                Component[] panelComps = ((JPanel) comp).getComponents();
                for (Component panelComp : panelComps) {
                    if (panelComp instanceof JButton && ((JButton) panelComp).getText().equals("-")) {
                        ((JButton) panelComp).addActionListener(listener);
                    }
                }
            }
        }
    }

    public void setMultiplyButtonListener(ActionListener listener) {
        Component[] components = frame.getContentPane().getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                Component[] panelComps = ((JPanel) comp).getComponents();
                for (Component panelComp : panelComps) {
                    if (panelComp instanceof JButton && ((JButton) panelComp).getText().equals("*")) {
                        ((JButton) panelComp).addActionListener(listener);
                    }
                }
            }
        }
    }

    public void setDivideButtonListener(ActionListener listener) {
        Component[] components = frame.getContentPane().getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                Component[] panelComps = ((JPanel) comp).getComponents();
                for (Component panelComp : panelComps) {
                    if (panelComp instanceof JButton && ((JButton) panelComp).getText().equals("/")) {
                        ((JButton) panelComp).addActionListener(listener);
                    }
                }
            }
        }
    }

    public void show() {
        frame.setVisible(true);
    }
}