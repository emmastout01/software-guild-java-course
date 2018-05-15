/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author emmastout
 */
public class JDBCTemplateDaoImpl implements ClassRosterDao {

    private JdbcTemplate jt;
    
    public JDBCTemplateDaoImpl(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        jt.update(
                "INSERT INTO Student (StudentId, FirstName, LastName, Cohort "
                + "VALUES (?, ?, ?, ?)",
                studentId,
                student.getFirstName(),
                student.getLastName(),
                student.getCohort()
        );

        return student;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return jt.query("SELECT * FROM Student;", new StudentMapper());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        String sql = "SELECT * FROM Student"
                + " WHERE StudentId LIKE ?;";
//     Ask Corbin: What is the '%' for in the example?
        try {
          return jt.queryForObject(sql, new StudentMapper(), studentId);  
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
        
    }

    @Override
    public boolean removeStudent(String studentId) throws ClassRosterPersistenceException {
        return jt.update("DELETE FROM Student WHERE StudentId = ?;", studentId) > 0;

    }

    private static final class StudentMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            Student student = new Student(rs.getString("StudentId"));
            student.setFirstName(rs.getString("FirstName"));
            student.setLastName(rs.getString("LastName"));
            student.setCohort(rs.getString("Cohort"));
            return student;
        }

    }

}
