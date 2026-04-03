package ui;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel(AppFrame frame) {
        setLayout(new BorderLayout());

        JLabel hello = new JLabel("Привет, " + frame.getCurrentUser().getUsername() + "!", SwingConstants.CENTER);
        hello.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel buttons = new JPanel(new GridLayout(5, 1, 10, 10));
        buttons.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 200));

        JButton typingButton = new JButton("Тренажёр печати");
        JButton scenariosButton = new JButton("Ситуационные задачи");
        JButton lessonsButton = new JButton("Уроки и тесты");
        JButton profileButton = new JButton("Профиль");
        JButton logoutButton = new JButton("Выйти");

        typingButton.addActionListener(e -> frame.showTyping());
        scenariosButton.addActionListener(e -> frame.showScenarios());
        lessonsButton.addActionListener(e -> frame.showLessons());
        profileButton.addActionListener(e -> frame.showProfile());
        logoutButton.addActionListener(e -> {
            frame.setCurrentUser(null);
            frame.showLogin();
        });

        buttons.add(typingButton);
        buttons.add(scenariosButton);
        buttons.add(lessonsButton);
        buttons.add(profileButton);
        buttons.add(logoutButton);

        add(hello, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);
    }
}