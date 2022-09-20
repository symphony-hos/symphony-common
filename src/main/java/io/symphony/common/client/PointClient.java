package io.symphony.common.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import io.symphony.common.point.model.PointModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PointClient {
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Config {
		@Builder.Default
		private String scheme = "http";
		@Builder.Default
		private String host = "points";
		@Builder.Default
		private Integer port = 80;
		@Builder.Default
		private String path = "path";
	}
	
	private RestTemplate restTemplate;
	
	private String baseURL;
	
	public PointClient(Config config, RestTemplateBuilder builder) {
		restTemplate = builder.build();

		Assert.notNull(config, "Config must not be null");
		Assert.notNull(config.getScheme(), "Scheme must not be null");
		Assert.notNull(config.getHost(), "Host must not be null");
		Assert.notNull(config.getPort(), "Port must not be null");
		
		StringBuffer buf = new StringBuffer();
		buf.append(config.getScheme());
		buf.append("://");
		buf.append(config.getHost());
		buf.append(":");
		buf.append(config.getPort());
		
		if (config.getPath() != null){
			buf.append("/");
			buf.append(config.getPath());
		}
		
		baseURL = buf.toString();
	}
	
		
	public CollectionModel<PointModel> getAllPoints() {
		String url = baseURL;
		HttpEntity<?> httpEntity = HttpEntity.EMPTY;
		
		ResponseEntity<CollectionModel<PointModel>> response = restTemplate.exchange(
			url,
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<CollectionModel<PointModel>>() {}
		);
		
		return response.getBody();
	}
	
	public PointModel getPoint(String extension, String pointId) {
		String url = baseURL + "/" + pointId;
		HttpEntity<?> httpEntity = HttpEntity.EMPTY;
		
		ResponseEntity<PointModel> response = restTemplate.exchange(
			url,
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<PointModel>() {}
		);
		
		return response.getBody();	
	}
	
	public PointModel createPoint(String extension, PointModel point) {				
		String url = baseURL;
		HttpEntity<PointModel> httpEntity = new HttpEntity<>(point);
		
		ResponseEntity<PointModel> response = restTemplate.exchange(
			url,
            HttpMethod.POST,
            httpEntity,
            new ParameterizedTypeReference<PointModel>() {}
		);
		
		return response.getBody();	
	}
	
	public PointModel replacePoint(String extension, String id, PointModel point) {
		String url = baseURL +  "/" + id;
		HttpEntity<PointModel> httpEntity = new HttpEntity<>(point);
		
		ResponseEntity<PointModel> response = restTemplate.exchange(
			url,
            HttpMethod.PUT,
            httpEntity,
            new ParameterizedTypeReference<PointModel>() {}
		);
		
		return response.getBody();	
	}
	
	public PointModel updatePoint(String extension, String id, PointModel point) {				
		String url = baseURL +  "/" + id;
		HttpEntity<PointModel> httpEntity = new HttpEntity<>(point);
		
		ResponseEntity<PointModel> response = restTemplate.exchange(
			url,
            HttpMethod.PATCH,
            httpEntity,
            new ParameterizedTypeReference<PointModel>() {}
		);
		
		return response.getBody();	
	}
	
	
	
}
