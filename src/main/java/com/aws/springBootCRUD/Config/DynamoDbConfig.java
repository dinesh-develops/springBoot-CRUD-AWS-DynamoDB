package com.aws.springBootCRUD.Config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {
    //Replace AWS credentials
    public static final String SERVICE_ENDPOINT = "";
    public static final String REGION = "";
    public static final String ACCESS_KEY = "";
    public static final String SECRET_KEY = "";

    @Bean
    public DynamoDBMapper mapper()
    {
        return new DynamoDBMapper(amazonDynamoDbConfig());
    }

    private AmazonDynamoDB amazonDynamoDbConfig() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
    }
}
