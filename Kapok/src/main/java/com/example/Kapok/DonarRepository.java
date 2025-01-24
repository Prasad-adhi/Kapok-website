package com.example.Kapok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

@Repository
public class DonarRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public Donar save(Donar donar)
	{
		dynamoDBMapper.save(donar);
		return donar;
	}
	
	public Donar getDonarByID(String donarId)
	{
		return dynamoDBMapper.load(Donar.class, donarId);
	}
	
	public String delete(String donarId)
	{
		Donar don = dynamoDBMapper.load(Donar.class, donarId);
		dynamoDBMapper.delete(don);
		return "Donar deleted";
	}
	public String update(String donarId, Donar don)
	{
		dynamoDBMapper.save(don, 
				new DynamoDBSaveExpression()
				.withExpectedEntry("donarId", 
						new ExpectedAttributeValue(
						new AttributeValue().withS(donarId)
						)));
		return donarId;
	}
}
