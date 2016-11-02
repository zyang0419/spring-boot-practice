package com.baichou.springboot.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by root on 16-10-20.
 */
@Configuration
public class RestTemplateConfig{
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){

        /**
         *org.springframework.web.client.RestClientException:
         * Could not extract response: no suitable HttpMessageConverter found for response type
         * [class com.alibaba.fastjson.JSONObject] and content type [text/html;charset=UTF-8]

         */
       // RestTemplate restTemplate = new RestTemplate(factory);
        //
        /*
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
*/
       /*  factory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());*/
/*
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;*/
         return new RestTemplate(factory);
      // return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;

       /* ClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
       // RestTemplate restTemplate = new RestTemplate(requestFactory);
        return factory;*/

    }



}