package in.sampath.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class ConfigRedis {
	@Value("${spring.data.redis.url}")
	private String url;

	@Value("${spring.data.redis.port}")
	private Integer port;

	@Value("${spring.data.redis.username}")
	private String username;

	@Value("${spring.data.redis.password}")
	private String pwd;

	@Bean
	public JedisConnectionFactory jedisconnfactory() {
		RedisStandaloneConfiguration RSC = new RedisStandaloneConfiguration(url, port);
		RSC.setUsername(username);
		RSC.setPassword(pwd);

		JedisClientConfiguration clientConfig = JedisClientConfiguration.builder().build();

		return new JedisConnectionFactory(RSC, clientConfig);

	}
	
	@Bean
	@Primary
	public RedisTemplate<String, String> redisTemplate() {
		RedisTemplate<String, String> rt = new RedisTemplate<>();
		rt.setConnectionFactory(jedisconnfactory());
		return rt;
	}
}
