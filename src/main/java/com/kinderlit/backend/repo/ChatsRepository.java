package com.kinderlit.backend.repo;

import com.kinderlit.backend.config.DynamoDBConfig;
import com.kinderlit.backend.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ChatsRepository {

        @Autowired
        public DynamoDbEnhancedClient dynamoDbEnhancedClient;

        public Chat saveChat(Chat chat) {
            try {
                DynamoDbTable<Chat> chatTable = dynamoDbEnhancedClient.table("devchats", TableSchema.fromBean(Chat.class));
                chatTable.putItem(chat);
            } catch (DynamoDbException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
            return chat;
        }

//        public Customer getCustomerById(String customerId) {
//            return dynamoDBMapper.load(Customer.class, customerId);
//        }
//
//        public String deleteCustomerById(String customerId) {
//            dynamoDBMapper.delete(dynamoDBMapper.load(Customer.class, customerId));
//            return "Customer Id : "+ customerId +" Deleted!";
//        }
//
//        public String updateCustomer(String customerId, Customer customer) {
//            dynamoDBMapper.save(customer,
//                    new DynamoDBSaveExpression()
//                            .withExpectedEntry("customerId",
//                                    new ExpectedAttributeValue(
//                                            new AttributeValue().withS(customerId)
//                                    )));
//            return customerId;
//        }

}
