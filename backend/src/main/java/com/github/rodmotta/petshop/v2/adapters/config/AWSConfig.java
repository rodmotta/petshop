package com.github.rodmotta.petshop.v2.adapters.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Value("${aws.region}")
    private String awsRegion;
    @Value("${aws.access_key}")
    private String accessKey;
    @Value("${aws.secret_access_key}")
    private String secretAccessKey;

    @Bean
    public AmazonS3 createS3Client() {
        return AmazonS3ClientBuilder.standard()
                //.withCredentials(new DefaultAWSCredentialsProviderChain())/*fixme - definir essa linha apos configurar maquina*/
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretAccessKey)))
                .withRegion(awsRegion)
                .build();
    }
}
