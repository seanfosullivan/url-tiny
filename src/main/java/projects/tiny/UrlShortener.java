package projects.tiny;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlShortener {
	@Id
	private String longurl;
	private String shorturl;
	
	public UrlShortener() {
	}
	
	public UrlShortener(String longurl, String shorturl) {
		super();
		this.longurl = longurl;
		this.shorturl = shorturl;
	}
	
	public String getLongurl() {
		return longurl;
	}

	public void setLongurl(String longurl) {
		this.longurl = longurl;
	}

	public String getShorturl() {
		return shorturl;
	}

	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}



}