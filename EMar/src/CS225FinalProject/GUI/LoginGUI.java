package CS225FinalProject.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import CS225FinalProject.DataStructure.User;

import javax.swing.JOptionPane;

import CS225FinalProject.SimulationManager;
import CS225FinalProject.DataStructure.SimulationController;

/**
 * @author Eric Santana
 */
public class LoginGUI extends javax.swing.JDialog {

	private SimulationController controller = SimulationController
			.getInstance();

	/**
	 * Creates new form LoginGUI
	 */
	public LoginGUI(java.awt.Frame parent, boolean modal,
			SimulationManager manager) {
		super(parent, modal);
		initComponents();
		pack();

		setLocation((getToolkit().getScreenSize().width - getWidth()) / 2,
				(getToolkit().getScreenSize().height - getHeight()) / 2);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        //!!JK
        jLabel1 = new javax.swing.JLabel();
        //JK

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MassBay eMAR");
        setMinimumSize(new java.awt.Dimension(340, 240));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLabel.setText("User Name:");
        getContentPane().add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 103, 70, 27));

        usernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameTextFieldKeyPressed(evt);
            }
        });
        getContentPane().add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 140, -1));

        passwordLabel.setText("Password:");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 139, -1, -1));

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 140, -1));

        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 90, -1));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/massbayLogo.png"))); // NOI18N
        //!!JK
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 80));
        //JK

        //!!JK
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 55, 70));
        jLabel1.setText("eMAR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 110, 50));
        //JK

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void usernameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			passwordField.grabFocus();
		}
	}

    //!!JK
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean isInstructor = false;
        boolean isStudent = false;

        String userName = usernameTextField.getText().toLowerCase();
        char[] password = passwordField.getPassword();

        isStudent = controller.validateStudentLogin(
                userName,
                new String(password));

        isInstructor = controller.validateInstructorLogin(
                userName,
                new String(password));

        if (isStudent && !isInstructor) {
            SimulationManager.CURRENT_USER = controller.getUser(userName, new String(password));
            SimulationManager.state = SimulationManager.SCENARIO_STATE;
            setVisible(false);
            usernameTextField.setText("");
            passwordField.setText("");
        } else if (isInstructor && !isStudent) {
            SimulationManager.state = SimulationManager.MAINTENANCE_STATE;
            setVisible(false);
            usernameTextField.setText("");
            passwordField.setText("");
        } else {
            User enteredUser = controller.getUser(userName, null);
            if (enteredUser != null) {
                String newPassword = JOptionPane.showInputDialog(this, "Enter your new password:");
                if (newPassword != null) {
                    if (newPassword.equals("")) {
                        JOptionPane.showMessageDialog(this, "Error. You did not enter a password");
                    } else {
                        String verifyPassword = JOptionPane.showInputDialog(this, "Verify your new password:");
                        if (verifyPassword != null) {
                            if (verifyPassword.equals("")) {
                                JOptionPane.showMessageDialog(this, "Error. You did not enter a password");
                            } else {
                                if (newPassword.equals(verifyPassword)) {
                                    enteredUser.setPassword(newPassword);
                                    JOptionPane.showMessageDialog(this, "Your password has been successfully set.");
                                } else {
                                    JOptionPane.showMessageDialog(this, "Error. The passwords you typed did not match.");
                                }
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "The user name or password you typed is incorrect.");
            }
        }
    }
    //JK
        
	private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {

		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			loginButton.getActionListeners()[0]
					.actionPerformed(new ActionEvent(loginButton, 0, null));
		}
	}

	// set the nimbus look and feel!
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;

				}
                        }
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/*
		 * Create and display the dialog
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				LoginGUI dialog = new LoginGUI(new javax.swing.JFrame(), true,
						null);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {

					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
