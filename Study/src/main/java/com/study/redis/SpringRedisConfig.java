package com.study.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class SpringRedisConfig {
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setHostName("localhost");
		connectionFactory.setPort(6379);
		return connectionFactory;
		
	}

	
//	@Bean - 2.1.10
//	  public LettuceConnectionFactory redisConnectionFactory() {
//	    return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379)); //2.1.10
//	  }
	
//	@Bean
//	public LettuceConnectionFactory redisConnectionFactory() {
//		LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
//		connectionFactory.setHostName("localhost");
//		connectionFactory.setPort(6379);
//		return connectionFactory;
//		
//	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}
