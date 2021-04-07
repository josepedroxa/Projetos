package com.digitalinnovationone.heroesapi.Config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import java.util.Arrays;
import static com.digitalinnovationone.heroesapi.Constans.HeroesConstant.ENOPOINT_DYNAMO;
import static com.digitalinnovationone.heroesapi.Constans.HeroesConstant.REGION_DUNAMO;

public class HeroesData {
    public static void main (String[] args ) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(REGION_DUNAMO, ENOPOINT_DYNAMO ))
        .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");
        Item hero = new Item()
          .withPrimaryKey("id", 1)
          .withString("name", "Flash")
                .withString("universe", "dc comics")
                .withNumber("films", 3);

        PutItemOutcome outcome = table.putItem(hero);
        PutItemOutcome outcome1 = table.putItem(hero);




        }

    }
