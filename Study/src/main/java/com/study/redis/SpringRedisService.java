package com.study.redis;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class SpringRedisService {
	public void exam() {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
		try {
			@SuppressWarnings("unchecked")
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>)ctx.getBean("redisTemplate");
			// value operation
			ValueOperations<String, Object> values = redisTemplate.opsForValue();
			
			// set
			values.set("jechoi", new Employee("01", "jechoi", 29));
			
			// get
			System.out.println("Employee added : " + values.get("jechoi"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ctx.close();
		}
		
	}
}
