package projects.tiny;

import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRepo extends CrudRepository<UrlShortener, String> {
}
