/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao {

    Student onlyStudent;
    List<Student> studentList = new ArrayList<>();

    public ClassRosterDaoStubImpl() {
        onlyStudent = new Student("001");
        onlyStudent.setFirstName("Hermione");
        onlyStudent.setLastName("Granger");
        onlyStudent.setCohort("Gryffindor");

        studentList.add(onlyStudent);
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        if (studentId.equals("001")) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return studentList;
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals("001")) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public boolean removeStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals("001")) {
            return true;
        } else {
            return false;
        }
    }

}
