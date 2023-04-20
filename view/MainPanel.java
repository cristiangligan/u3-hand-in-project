package view;

import javax.swing.*;

/**
 *
 * @author Cristian Gligan
 */
public class MainPanel extends JPanel {
    private final LPanel lPanel;
    private final RPanel rPanel;


    /**
     *
     * @param width
     * @param height
     * @param mainFrame
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
     *
     * @return
     * @author Cristian Gligan
     */
    protected LPanel getLeftPanel() {
        return lPanel;
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    protected RPanel getRightPanel() {
        return rPanel;
    }

}
