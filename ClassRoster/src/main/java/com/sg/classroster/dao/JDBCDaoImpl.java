/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class JDBCDaoImpl implements ClassRosterDao {

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {

        try (Connection conn = MySQLDatabase.getDataSource().getConnection()) {

            String sql = "INSERT INTO Student "
                    + "(StudentId, FirstName, LastName, Cohort) "
                    + "VALUES (?, ?, ?, ?);";

            PreparedStatement insertStatement = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, student.getStudentId());
            insertStatement.setString(2, student.getFirstName());
            insertStatement.setString(3, student.getLastName());
            insertStatement.setString(4, student.getCohort());
            insertStatement.executeUpdate();

            return student;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ClassRosterPersistenceException("DB Failure", ex);
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {

        List<Student> studentList = new ArrayList<>();

        try (Connection conn = MySQLDatabase.getDataSource().getConnection()) {

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Student;");

            while (rs.next()) {
                studentList.add(readStudent(rs));
            }
        } catch (SQLException ex) {
            throw new ClassRosterPersistenceException("DB failure.", ex);
        }

        return studentList;
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {

        try (Connection conn = MySQLDatabase.getDataSource().getConnection()) {

            String sql = "SELECT * FROM Student WHERE StudentId = ?;";
            PreparedStatement findStatement = conn.prepareStatement(sql);
            findStatement.setString(1, studentId);

            ResultSet rs = findStatement.executeQuery();
            if (rs.next()) {
                return readStudent(rs);
            }
        } catch (SQLException ex) {
            throw new ClassRosterPersistenceException("DB Failure.", ex);
        }
        return null;

    }

    @Override
    public boolean removeStudent(String studentId) throws ClassRosterPersistenceException {

        try (Connection conn = MySQLDatabase.getDataSource().getConnection()) {

            String sql = "DELETE FROM Student WHERE StudentId = ?;";
            PreparedStatement deleteStatement = conn.prepareStatement(sql);
            deleteStatement.setString(1, studentId);

            return (deleteStatement.executeUpdate() > 0); 

        } catch (SQLException ex) {
            throw new ClassRosterPersistenceException("DB Failure.", ex);
        }
    }

    private Student readStudent(ResultSet rs) throws SQLException {
        Student student = new Student(rs.getString("StudentId"));
        student.setFirstName(rs.getString("FirstName"));
        student.setLastName(rs.getString("LastName"));
        student.setCohort(rs.getString("Cohort"));
        return student;
    }

}
