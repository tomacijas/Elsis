import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class GUI 
{
	public static void Main_Window_initialize()
	{
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 


		// create the status bar panel and shove it down the bottom of the frame
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		frame.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(frame.getWidth(),20 ));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		JLabel statusLabel = new JLabel("Status:");
		JLabel statusLabel1 = new JLabel("IP:");
		JLabel statusLabel2 = new JLabel("ID:");
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		statusPanel.add(new JSeparator(SwingConstants.VERTICAL));
		statusPanel.add(statusLabel1);
		statusPanel.add(new JSeparator(SwingConstants.VERTICAL));
		statusPanel.add(statusLabel2);
		


		frame.setVisible(true);
	}

}
