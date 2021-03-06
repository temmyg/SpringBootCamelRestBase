package com.springboot.camel.rest.springboot_camel_rest_base;


import com.springboot.camel.rest.springboot_camel_rest_base.model.ClubMember;
import com.springboot.camel.rest.springboot_camel_rest_base.model.ClubMemberRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@Component("clubBean")
public class HealthClubController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String addClubMember(ClubMember member, String msg){
        String insertSttmnt = "insert into HealthMember (FirstName, LastName, Occupation, Age) values (?, ?, ?, ?)";
        int rowNum = jdbcTemplate.update(insertSttmnt, member.getFirstName(), member.getLastName(),
                                            member.getOccupation(), member.getAge());
        return Integer.toString(rowNum) + " Row(s) Added";
    }

    public List<ClubMember> getAllMembers() throws DataAccessException{
        ArrayList<ClubMember> result = new ArrayList<>();

        String selectSttmnt = "select * from HealthMember";
        result = new ArrayList<>(jdbcTemplate.query(selectSttmnt, new ClubMemberRowMapper()));
        return result; //result.get(0);
        //result.add(new ClubMember(){ { setAge(12); } });
        // return result;
    }
}
