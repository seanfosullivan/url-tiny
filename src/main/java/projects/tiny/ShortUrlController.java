package projects.tiny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ShortUrlController {

	@Autowired
	private ShortUrlService shortUrlService;

	@RequestMapping("/urls")
	public List<UrlShortener> getAllUrls(){
		return shortUrlService.getAllUrls();
	}

	@RequestMapping(method=RequestMethod.POST,value="/send")
	public void addUrl(@RequestBody UrlShortener urlshortener) {
		shortUrlService.addUrl(urlshortener);
	}

	@RequestMapping("/p/{shorturl}")
	public String parseUrls(@PathVariable String shorturl){
		return shortUrlService.getLongUrl(shorturl);
	}
	
	@RequestMapping("/s/{shorturl}")
	public ResponseEntity<?> redirectUrl(@PathVariable String shorturl) throws URISyntaxException{
		String tmp = shortUrlService.getLongUrl(shorturl);
		URI uri = new URI(tmp);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uri);
		return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/run")
	public String runUrl(@RequestBody String longurl) {
		String shorturl = shortUrlService.runUrl(longurl);
		return shorturl;
	}
}

