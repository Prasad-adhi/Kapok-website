package com.example.Kapok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfig {
	
	
	private String[] readCredentialsFromCSV(String filePath){
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) 
        {
            reader.readNext();
            return reader.readNext();
        } 
        catch (IOException | CsvException e) 
        {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
            return new String[]{"", ""};
        }
    }
	
	@Bean
	public DynamoDBMapper dynamoDBMapper()
	{
		return new DynamoDBMapper(buildAmazonDynamoDB());
	}

	private AmazonDynamoDB buildAmazonDynamoDB() {
		String[] credentials = readCredentialsFromCSV("dynamodbaccess_accessKeys.csv");
        String accessKey = credentials[0];
        String secretKey = credentials[1];
		// TODO Auto-generated method stub
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
								"dynamodb.us-east-2.amazonaws.com",
								"us-east-2"
						)
				).withCredentials(
				new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey,secretKey))
			).build();
	}
}
