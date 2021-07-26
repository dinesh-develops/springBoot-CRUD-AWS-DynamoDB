package com.aws.springBootCRUD.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.aws.springBootCRUD.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class customerRepository {
    @Autowired
    private DynamoDBMapper mapper;
    public Customer addCustomer(Customer customer){
        mapper.save(customer);
        return customer;
    }
    public Customer findCustomerById(String customerId){
        return mapper.load(Customer.class,customerId);
    }
    public String deleteCustomer(Customer customer){
        mapper.delete(customer);
        return "Customer Data deleted";
    }
    public String updateCustomer(Customer customer){
        mapper.save(customer,buildExpression(customer));
        return "Customer Data updated";
    }
    private DynamoDBSaveExpression buildExpression(Customer customer){
        DynamoDBSaveExpression dynamoDBSaveExpression=new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap=new HashMap<>();
        expectedMap.put("customerId",new ExpectedAttributeValue(new AttributeValue().withS(customer.getCustomerId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }
}
