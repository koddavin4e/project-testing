package ui;

import model.User;
import repository.LessonRepository;
import repository.ScenarioRepository;
import service.AuthService;
import service.QuizService;
import service.TypingService;

import javax.swing.JFrame;

public class AppFrame extends JFrame {

    private final AuthService authService = new AuthService();
    private final TypingService typingService = new TypingService();
    private final QuizService quizService = new QuizService();
    private final ScenarioRepository scenarioRepository = new ScenarioRepository();
    private final LessonRepository lessonRepository = new LessonRepository();

    private User currentUser;

    public AppFrame() {
        setTitle("Programmer Mind Trainer");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showLogin();
    }

    public AuthService getAuthService() {
        return authService;
    }

    public TypingService getTypingService() {
        return typingService;
    }

    public QuizService getQuizService() {
        return quizService;
    }

    public ScenarioRepository getScenarioRepository() {
        return scenarioRepository;
    }

    public LessonRepository getLessonRepository() {
        return lessonRepository;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void showLogin() {
        setContentPane(new LoginPanel(this));
        refreshUI();
    }

    public void showRegister() {
        setContentPane(new RegisterPanel(this));
        refreshUI();
    }

    public void showDashboard() {
        setContentPane(new DashboardPanel(this));
        refreshUI();
    }

    public void showTyping() {
        setContentPane(new TypingPanel(this));
        refreshUI();
    }

    public void showScenarios() {
        setContentPane(new ScenarioPanel(this));
        refreshUI();
    }

    public void showLessons() {
        setContentPane(new LessonPanel(this));
        refreshUI();
    }

    public void showProfile() {
        setContentPane(new ProfilePanel(this));
        refreshUI();
    }

    private void refreshUI() {
        revalidate();
        repaint();
    }
}
