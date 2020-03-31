import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

	//variables
	// Atributos(lo normal es que sean private, ya se mostrar con get y modificara con set)
	
		private String name; 
		private String surname;
		private String password;
		private Date dateRegister;
		private List<Video> videoList;
		
		public User() {
			
		}
		// constructor publico
		public User(String name,String surname, String password) throws Exception { 
			
			if(name.equals(""))//comprobar si el campo es vacio
				throw new Exception("Empty name. Please fill in the name");

			if(surname.equals(""))//comprobar si el campo es vacio
				throw new Exception("Empty surname. Please fill in the surname");

			if(password.equals(""))//comprobar si el campo es vacio
				throw new Exception("Empty password. Please fill in the password");
			
			this.setName(name);
			this.setSurname(surname);
			this.setPassword(password);
			this.setDateRegister(new Date());
			this.videoList = new ArrayList<Video>();
		}
		
		// Metodos
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getPassword() { //quiero un get de la password pero que no la enseñe  
			
			String hiddenPassword=" ";
			for (int i = 0; i < this.password.length(); i++) {
				hiddenPassword += "**";
			}
			return hiddenPassword;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getDateRegister() {
			return dateRegister;
		}

		public void setDateRegister(Date dateRegister) {
			this.dateRegister = dateRegister;
		}

		public List<Video> getVideoList() {
			return videoList;
		}

		public void setVideoList(List<Video> videoList) {
			this.videoList = videoList; // sustituimos una lista por otra
		}
		
		public void addVideo(Video newVideo) {//metodo 
			this.getVideoList().add(newVideo); //cogemos lista y añadimos
			
		}
		
		
		public void addVideos(List<Video> newVideo) {
			
			for (Video video : newVideo) {
				this.getVideoList().add(video);
			}
		}
		// hacer un metodo que nos devuelva un booleano	
		public boolean checkPassword(String pass) {
			return this.password.equals(pass);
			
		}
		
		@Override
		public String toString() {
			return "User [name=" + this.getName() + ", surname=" + this.getSurname() + ", password=" + this.getPassword() + ", dateRegister="
					+ this.getDateRegister() + ", videoList=" + this.getVideoList() + "]";// las cambio en getters y setters al hacer operacion se hace aqui tambien
		}
		
	
	}


