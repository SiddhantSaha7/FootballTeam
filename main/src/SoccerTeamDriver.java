import controller.SoccerTeamController;

import javax.swing.SwingUtilities;

/**
 * Main application class for the U10 Soccer Team Management system.
 * Implements the MVC (Model-View-Controller) architecture with clear separation.
 * The application class only communicates with the controller.
 */
public class SoccerTeamDriver {
    
    /**
     * Main method to start the application.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Launch the application using Swing's event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Initialize the application by creating the controller
                // The controller will handle creating and setting up the view
                initializeApplication();
            }
        });
    }
    
    /**
     * Initializes the application by setting up the controller.
     * The application only interacts with the controller, not the view.
     */
    private static void initializeApplication() {
        // Create the controller, which will handle setting up the views
        SoccerTeamController controller = new SoccerTeamController();
        
        // Start the application through the controller
        controller.startController();
    }
}