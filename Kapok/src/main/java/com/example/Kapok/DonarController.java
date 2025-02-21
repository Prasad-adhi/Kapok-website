package com.example.Kapok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DonarController {
//	@QueryMapping
//    public List<Donar> donars() {
//        return Donar.donars;
//    }
	
	@Autowired
	private DonarRepository donarRepository;
	
    @QueryMapping
    public Donar donarbyID(@Argument String donarID) {
        return donarRepository.getDonarByID(donarID);
    }
    
    @MutationMapping
    public Donar addDonar(@Argument Donar donar) {
    	return donarRepository.save(donar);
    }
    
    @MutationMapping
    public String deleteDonar(@Argument String donarID)
    {
    	return donarRepository.delete(donarID);
    }
    
    @MutationMapping
    public String updateDonar(String donarID, Donar donar)
    {
    	return donarRepository.update(donarID, donar);
    }
}
