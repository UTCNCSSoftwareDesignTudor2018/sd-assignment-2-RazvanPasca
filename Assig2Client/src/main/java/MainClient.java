import controller.StartingViewController;
import view.StartingView;

public class MainClient {
    public static void main(String[] args) {
        StartingView startingView = new StartingView();
        startingView.setVisible(true);
        StartingViewController startingViewController = new StartingViewController(startingView);
    }
}
