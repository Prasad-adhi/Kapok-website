package com.example.Kapok;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DonarController {
	@QueryMapping
    public List<Donar> donars() {
        return Donar.donars;
    }
	
    @QueryMapping
    public Optional<Donar> donarbyID(@Argument Integer id) {
        return Donar.getdonarById(id);
    }
    
    @MutationMapping
    public boolean addDonar(@Argument Integer id, @Argument String fName, @Argument String lName, @Argument String Email, @Argument String Pwd) {
    	return Donar.addDonar(id, fName, lName, Email, Pwd);
    }
}
