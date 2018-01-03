package com.springboot.camel.rest.springboot_camel_rest_base.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClubMemberRowMapper implements RowMapper<ClubMember> {
    @Override
    public ClubMember mapRow(ResultSet rs, int rowNum) throws SQLException{
        ClubMember cm = new ClubMember();

        cm.setAge(rs.getInt("Age"));
        cm.setFirstName(rs.getString("FirstName"));
        cm.setOccupation(rs.getString("Occupation"));

        return cm;
    }
}
