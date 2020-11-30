package projects.tiny;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {
	public static String ALPHANUMERIC_CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Autowired
	private ShortUrlRepo shortUrlRepo;
	
	public List<UrlShortener> getAllUrls(){
		List<UrlShortener> urlshortener =new ArrayList<>();
		shortUrlRepo.findAll().forEach(urlshortener::add);
		return urlshortener;
	}
	
	public void addUrl(UrlShortener urlshortener) {
		shortUrlRepo.save(urlshortener);
	}

	public String getLongUrl(String shorturl) {
		List<UrlShortener> urlshortener =new ArrayList<>();
		shortUrlRepo.findAll().forEach(urlshortener::add);
		UrlShortener url=urlshortener.stream().filter(t -> t.getShorturl().equals(shorturl)).findFirst().get();
		String tmp = url.getLongurl();
		return tmp;
	}

	public static String Shorten(){
		String randurl="";
		Random rand = new Random(); 
		for (int i=0; i<8; i++) {
			int randint = rand.nextInt(62);
			randurl =randurl + ALPHANUMERIC_CHARACTERS.charAt(randint);
		}
		String shorturl = randurl;
		return shorturl;
	}
	
	public String runUrl(String id) {
		String shorturl = Shorten();
		String longurl =id;
		UrlShortener urlShortener = new UrlShortener(longurl,shorturl);
		shortUrlRepo.save(urlShortener);
		return "localhost:3000/s/" + shorturl; 
	}
}
