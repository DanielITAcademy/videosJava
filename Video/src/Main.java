import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// Simulated fakeDB
		List<User> userList = new ArrayList<User>();
		
		
		//loopRules
		boolean mainLoop = true; //declaro variable boolean e inicializo
		boolean loggedUserLoop;
		//Aux Data
		String name;
		String surname;
		String password;
		String keyWord;
		List<Video> videoCandidates;
	
		// Global Data
		User loggedUser = null; // aqui añadiremos el usuario con el que hagamos login
		
		//PreloadedUsers
		try {
			userList.add(new User("daniel","fernandez","1234"));
			userList.add(new User("admin","admin","admin"));
		} catch (Exception e1) {
			System.out.println(e1.getMessage()+"Something is wrong with preloadrd of user date");// otro error diferente
		} 
		
		
		
		//User newUser;
		
				System.out.println("Welcome to World of videos");
				System.out.println("############################");
				
				
				
				//Creamos bucle login y register
				
				do {
					System.out.println("What would you like to do??");
					System.out.println("Login");
					System.out.println("Register");
					System.out.println("Exit");
					String mainChoice = sc.next();
					
					switch (mainChoice.toLowerCase()) {
					case "login":
						System.out.println("You are inside the login");
					
						System.out.println("Insert your credentials");
						// me pide los datos para registrar un usuario
						System.out.println("What is your name? " );
						name = sc.next();
						System.out.println("What is your surname? " );
						surname = sc.next();
						System.out.println("What is your password? " );
						password = sc.next();
						// un try catch nos permite que no detenga la ejecucion (handlear)el programa
						try {
							User userFound = Login(name,surname,password, userList);
							System.out.println("Welcome: "+ userFound.getName()); 
							loggedUser = userFound;
						} catch (Exception e) {
							
							System.out.println(e.getMessage());
						}
						
					// Menu for user logged
						do {
							
							System.out.println("What would you like to do?"); //preguntamos al usuario que quiere hacer
							System.out.println("1_ Create a video");
							System.out.println("2_ Show a list of videos");
							System.out.println("3_ Find a video");
							System.out.println("4_ Logout");
							int loggedUserChoice = sc.nextInt();
							
						switch (loggedUserChoice) {
						case 1:
							// video creation pedimos datos
							System.out.println("Create your video");
							System.out.println("############################");
							String title = JOptionPane.showInputDialog("Title of your video");
							String url = JOptionPane.showInputDialog("URL of your video");
							System.out.println("Ahora añadiras tags,escribe'STOP' cuando acabes");
							List<String>newtagList = new ArrayList<String>();
							
							// creamos tags hacemos do while porque quiero pedir bastantes cosas al usuario
							String newTag = "";
							do {
								System.out.println("Write one tag");
								newTag = sc.next();
								if(!newTag.equals("STOP"));
									newtagList.add(newTag);
									
							}while(!newTag.equals("STOP"));
							
							//creamos el video
							Video newVideo = new Video(title,url,newtagList);
							loggedUser.addVideo(newVideo);//añadimos video al usuario logeado, por ende metemos al usuario en la lista
							System.out.println(newVideo);
							loggedUserLoop = true;
							break;
						case 2:
							System.out.println("Show all videos: ");
							
							for (Video video : loggedUser.getVideoList()) { //nos sirve para cualquier usuario logueado
								System.out.println(video.toString());
							}
							loggedUserLoop = true;
							break;
						case 3:
							
							videoCandidates = new ArrayList<Video>(); // lo inicializo aqui xq si hago otra busqueda hacer un new de la misma variable borra el antiguo objeto, por lo que se vacia la lista 
							
							System.out.println("Find a video for keyword");
							// buscaremos video por palabra tanto en el titulo como en los tags(sort manual)(parte extra no lo pide el ejercicio)
							System.out.println("Write one word: ");
							keyWord = sc.next();
							
							for (Video video : loggedUser.getVideoList()) {
								
								if(video.getTitle().contains(keyWord)) {//hacemos busqueda por titulo
									videoCandidates.add(video); //si existe lo almaceno
								}
								else {
										for (String tagList : video.getTagList()) {
											if(tagList.equals(keyWord)) {
												videoCandidates.add(video);
												break;
										}
									}
								}
								
							}
							System.out.println("############################");
							System.out.println("Videos found");
							for (Video item : videoCandidates) {
								System.out.println(item.toString());
							}
							loggedUserLoop = true;
							break;
						case 4:
							System.out.println("See you soon " +loggedUser.getName());
							loggedUser = null;
							loggedUserLoop = false;
							break;
						default:
							System.out.println("Please insert one number from 1 to 4");
							loggedUserLoop = true;
							break;
						}
						
						} while (loggedUserLoop);
						
					// End menu for user logged	
						
						mainLoop = true;
						break; 
						
						
					case "register":
						System.out.println("You are inside the register");
						
						System.out.println("Register your user");
						// me pide los datos del usuario
						System.out.println("What is your name? ");
						name = sc.next();
						System.out.println("What is your surname? ");
						surname = sc.next();
						System.out.println("What is your password? ");
						password= sc.next();
					
						// Creamos el usuario
						User newUser = null ; //declaracion del objeto
						try {
							 newUser = new User(name,surname,password);
							//Muestro usuario por pantalla
								System.out.println("You are created your user: "+newUser.toString());
								//Añado usuario a la lista
								userList.add(newUser);
								userList.add(newUser);
						} catch (Exception e) {
							System.out.println("Try again register ");
						} 
						
							
						mainLoop = true;
						break;
					
					case "exit":
						System.out.println("Exit the switch");
						mainLoop = false;
						break;
					default:
						System.out.println("Please, just we have 3 options,write well!");
						mainLoop = true;
						break;
					}
					
					
				} while (mainLoop);
				
				
				//newUser.getVideoList().add(newVideo); //añado video a la lista (forma ugly)
	
	}
	// Hacemos un método que devuelve un usuario creado
	public static User Login(String name, String surname, String password, List<User>userList) throws Exception { // Dani del futuro es un método static porque estamos en el main, no te despistes
		
		User output = null;
		// comprobacion del userList con bucle
		for (User user : userList) {
			if(user.getName().equals(name)&&user.getSurname().equals(surname)&&user.checkPassword(password)){ // si el usuario y el checkpassword es true hara algo
				output = user;
				
				break;
			}
			
			if(output==null)
				throw new Exception("User does not exist in the List");
		}
		return output;
	}
}
				

		
		
		


