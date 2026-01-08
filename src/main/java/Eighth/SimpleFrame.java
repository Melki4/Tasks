package Eighth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleFrame extends JFrame {

    public SimpleFrame() {
        setTitle("Форма с кнопкой");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Основная панель с BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        JButton button = new JButton("OK");
        button.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        // Увеличиваем шрифт кнопки
        button.setFont(new Font("Arial", Font.ITALIC, 16));

        // Добавляем кнопку в центр с отступами
        mainPanel.setBorder(BorderFactory.createEmptyBorder(70, 100, 70, 100));
        mainPanel.add(button, BorderLayout.CENTER);

        add(mainPanel);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Запуск в потоке обработки событий (правильный способ для Swing)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame frame = new SimpleFrame();
                frame.setVisible(true);
            }
        });
    }


    /*public static void main(String[] args) {
        // Создаем фрейм
        JFrame frame = new JFrame("Моя первая форма");

        // Создаем кнопку
        JButton button = new JButton("OK");

        // Добавляем обработчик события нажатия на кнопку
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Закрываем форму и завершаем программу
                frame.dispose();
                System.exit(0);
            }
        });

        // Настраиваем фрейм
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Центрируем окно
        frame.setLayout(new FlowLayout()); // Простой менеджер компоновки

        // Добавляем кнопку на фрейм
        frame.add(button);

        // Делаем фрейм видимым
        frame.setVisible(true);
    }*/
}