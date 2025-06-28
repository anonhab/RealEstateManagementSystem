package client;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import server.ChatServerIF;


public class ChatClient3 extends UnicastRemoteObject implements ChatClient3IF {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7468891722773409712L;
	realproject chatGUI;
	private String hostName = "localhost";
	private String serviceName = "GroupChatService";
	private String clientServiceName;
	private String name;
	protected ChatServerIF serverIF;
	protected boolean connectionProblem = false;

	public ChatClient3(realproject realproject, String userName) throws RemoteException {
		super();
		this.chatGUI = realproject;
		this.name = userName;
		this.clientServiceName = "ClientListenService_" + userName;
	}


    public void startClient() throws RemoteException {
        String[] details = { name, hostName, clientServiceName };

        try {
            // Set RMI properties
           

            // Bind the client to the RMI registry
            Naming.rebind("rmi://" + hostName + "/" + clientServiceName, this);

            // Look up the remote ChatServerIF
            serverIF = (ChatServerIF) Naming.lookup("rmi://" + hostName + "/" + serviceName);

        } catch (ConnectException e) {
            // Handle connection problems
            handleConnectionError("The server seems to be unavailable\nPlease try later", e);

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            // Handle general exceptions
            handleConnectionError("Error connecting to the server", e);

        }

        if (!connectionProblem) {
            // If no connection problem, register the client with the server
            registerWithServer(details);
            System.out.println("Client Listen RMI Server is running...\n");
        }
    }
	private void handleConnectionError(String message, Exception e) {
        JOptionPane.showMessageDialog(chatGUI.frame, message, "Connection problem", JOptionPane.ERROR_MESSAGE);
        connectionProblem = true;
        e.printStackTrace();
    }

	public void registerWithServer(String[] details) {
		try {
			serverIF.passIDentity(this.ref);// now redundant ??
			serverIF.registerListener(details);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void messageFromServer(String message) throws RemoteException {
		System.out.println(message);
		chatGUI.textArea.append(message);
		// make the gui display the last appended text, ie scroll to bottom
		chatGUI.textArea.setCaretPosition(chatGUI.textArea.getDocument().getLength());
	}

	@Override
	public void updateUserList(String[] currentUsers) throws RemoteException {

		if (currentUsers.length < 2) {
			chatGUI.privateMsgButton.setEnabled(false);
		}
		chatGUI.userPanel.remove(chatGUI.clientPanel);
		chatGUI.setClientPanel(currentUsers);
		chatGUI.clientPanel.repaint();
		chatGUI.clientPanel.revalidate();
	}

}// end class
