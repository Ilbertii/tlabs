package ru.miet.testing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CalculatorGUI view = new CalculatorGUI();
            CalculatorPresenter presenter = new CalculatorPresenterImpl(view);
            
            // Устанавливаем слушатели для кнопок
            view.setPlusButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    presenter.onPlusClicked();
                }
            });
            
            view.setMinusButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    presenter.onMinusClicked();
                }
            });
            
            view.setMultiplyButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    presenter.onMultiplyClicked();
                }
            });
            
            view.setDivideButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    presenter.onDivideClicked();
                }
            });
            
            view.show();
        });
    }
}