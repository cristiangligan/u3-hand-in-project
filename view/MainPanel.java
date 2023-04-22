package view;

import javax.swing.*;

/**
 * MainPanel is the main container, containing instances of {@link LPanel} and {@link RPanel}.
 *
 * @author Cristian Gligan
 */
public class MainPanel extends JPanel {
    private final LPanel lPanel;
    private final RPanel rPanel;


    /**
     * MainPanel constructor
     *
     * @param width the width of the panel in pixels
     * @param height the height of the panel in pixels
     * @param mainFrame reference to the {@link MainFrame} instance
     * @author Cristian Gligan
     */
    public MainPanel(int width, int height, MainFrame mainFrame) {
        super(null);
        this.setSize(width, height);

        lPanel = new LPanel(width / 2 + 60, height, mainFrame);
        add(lPanel);

        rPanel = new RPanel(width / 2 + 70, height, mainFrame);
        add(rPanel);
    }

    /**
     * Returns a reference to the {@link LPanel} instance
     *
     * @return reference to the {@link LPanel} instance
     * @author Cristian Gligan
     */
    protected LPanel getLeftPanel() {
        return lPanel;
    }

    /**
     * Returns a reference to the {@link RPanel} instance
     *
     * @return reference to the {@link RPanel} instance
     * @author Cristian Gligan
     */
    protected RPanel getRightPanel() {
        return rPanel;
    }

}
