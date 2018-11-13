package com.example.demo.configuration;

import java.io.Serializable;

import org.hibernate.type.SerializationException;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {
	/**
	 * 设置redis的存储格式和内容
	 * @param connectionFactory
	 * @return
	 */
	 @Bean
	    public RedisTemplate<Serializable, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
	        RedisTemplate<Serializable, Object> template = new RedisTemplate<Serializable, Object>();
	        template.setConnectionFactory(connectionFactory);
	        template.afterPropertiesSet();
	        // redis存取对象的关键配置
	        template.setKeySerializer(new StringRedisSerializer());
	        // ObjectRedisSerializer类为java对象的序列化和反序列化工具类
	        template.setValueSerializer(new ObjectRedisSerializer());
	        return template;
	    }
	 /**
	  * 实现redis的存储序列化（对象存储和取值转换）
	  * @author Administrator
	  *
	  */
	 class ObjectRedisSerializer implements RedisSerializer<Serializable>{
		    @Override
		    public byte[] serialize(Serializable serializable) throws SerializationException {
		        if(serializable==null){
		            return null;
		        }
		        return org.springframework.util.SerializationUtils.serialize(serializable);
		    }

		    @Override
		    public Serializable deserialize(byte[] bytes) throws SerializationException {
		        if(bytes==null){
		            return null;
		        }
		        return (Serializable) org.springframework.util.SerializationUtils.deserialize(bytes);
		    }
		}
	

}
