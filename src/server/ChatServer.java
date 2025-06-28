package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;

import client.ChatClient3IF;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF {
	String line = "---------------------------------------------\n";
	private Vector<Chatter> chatters;
	private static final long serialVersionUID = 1L;

	// Constructor
	public ChatServer() throws RemoteException {
		super();
		chatters = new Vector<Chatter>(10, 1);
	}

	
	public static void main(String[] args) {
		startRMIRegistry();

		String hostName = "localhost";
		String serviceName = "GroupChatService";

		if (args.length == 2) {
			hostName = args[0];
			serviceName = args[1];
		}

		try {
			ChatServerIF chatServer = new ChatServer();
			String registryURL = "rmi://" + hostName + "/" + serviceName;
			Naming.rebind(registryURL, chatServer);

			System.out.println("Group Chat RMI Server is running on " + registryURL);
		} catch (Exception e) {
			System.err.println("Server had problems starting: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Start the RMI Registry
	 */
	public static void startRMIRegistry() {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI Server ready");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

 
	
 
	public void updateChat(String name, String nextPost) throws RemoteException {
		String message = name + " : " + nextPost + "\n";
		sendToAll(message);
	}
 
	@Override
	public void passIDentity(RemoteRef ref) throws RemoteException {
 		try {
			System.out.println(line + ref.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	 
	@Override
	public void registerListener(String[] details) throws RemoteException {
		System.out.println(new Date(System.currentTimeMillis()));
		System.out.println(details[0] + " has joined the chat session");
		System.out.println(details[0] + "'s hostname : " + details[1]);
		System.out.println(details[0] + "'sRMI service : " + details[2]);
		registerChatter(details);
	}

	 
	private void registerChatter(String[] details) {
		try {
			ChatClient3IF nextClient = (ChatClient3IF) Naming.lookup("rmi://" + details[1] + "/" + details[2]);

			chatters.addElement(new Chatter(details[0], nextClient));
			updateUserList();
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}
 
	private void updateUserList() {
		String[] currentUsers = getUserList();
		for (Chatter c : chatters) {
			try {
				c.getClient().updateUserList(currentUsers);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	 
	private String[] getUserList() {
		 
		String[] allUsers = new String[chatters.size()];
		for (int i = 0; i < allUsers.length; i++) {
			allUsers[i] = chatters.elementAt(i).getName();
		}
		return allUsers;
	}

	 
	public void sendToAll(String newMessage) {
		for (Chatter c : chatters) {
			try {
				c.getClient().messageFromServer(newMessage);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	 
	@Override
	public void leaveChat(String userName) throws RemoteException {

		for (Chatter c : chatters) {
			if (c.getName().equals(userName)) {
				System.out.println(line + userName + " left the chat session");
				System.out.println(new Date(System.currentTimeMillis()));
				chatters.remove(c);
				break;
			}
		}
		if (!chatters.isEmpty()) {
			updateUserList();
		}
	}
 
	@Override
	public void sendPM(int[] privateGroup, String privateMessage) throws RemoteException {
		Chatter pc;
		for (int i : privateGroup) {
			pc = chatters.elementAt(i);
			pc.getClient().messageFromServer(privateMessage);
		}
	}

} 
