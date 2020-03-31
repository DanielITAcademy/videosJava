
import java.util.ArrayList;
import java.util.List;
public class Video {

		// Atributos
		 private String url;
		 private String title;
		 private List<String> tagList;
		 
		  
		  public Video(String title,String url,List<String> tagList) {
			  this.setUrl(url);
			  this.setTitle(title);
			  this.setTagList(tagList);
		  }

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<String> getTagList() {
			return tagList;
		}

		public void setTagList(List<String> tagList) {
			this.tagList = tagList;
		}

		@Override
		public String toString() {
			return "Video [url=" + this.getUrl() + ", title=" + this.getTitle() + ", tagList=" + this.getTagList() + "]";
		}
		  
	}
	

