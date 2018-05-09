/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterAuditDaoStubImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoStubImpl;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emmastout
 */

//In this class, we're testing our business methods
public class ClassRosterServiceLayerTest {

    private ClassRosterServiceLayer service;

    public ClassRosterServiceLayerTest() {
        //Here, we're going to instantiate the stub implementations
        //Using dependency injection
        ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();

        service = new ClassRosterServiceLayerImpl(dao, auditDao);
    }


    /**
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {
        //This test is a little different. Instead of testing the persistence,
        //we're testing the business logic.
        //We just want to return this one, and the test should pass.

        Student student = new Student("002");
        student.setFirstName("Romilda");
        student.setLastName("Vane");
        student.setCohort("Gryffindor");

        service.createStudent(student);
    }

    @Test
    public void testCreateStudentDuplicateId() throws Exception {
        //This test is a little different. Instead of testing the persistence,
        //we're testing the business logic.
        //We just want to return this one, and the test should pass.

        Student student = new Student("001");
        student.setFirstName("Romilda");
        student.setLastName("Vane");
        student.setCohort("Gryffindor");

        //Confirm that the test will throw a duplicate id error.
        try {
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateIdException was not thrown.");
        } catch (ClassRosterDuplicateIdException e) {
            return;
        }
    }

    @Test
    public void testCreateStudentInvalidData() throws Exception {
        //This test is a little different. Instead of testing the persistence,
        //we're testing the business logic.
        //We just want to return this one, and the test should pass.

        Student student = new Student("002");
        student.setFirstName("");
        student.setLastName("Vane");
        student.setCohort("Gryffindor");

        //Confirm that the test will throw a duplicate id error.
        try {
            service.createStudent(student);
            fail("Expected ClassRosterDataValidationException was not thrown.");
        } catch (ClassRosterDataValidationException e) {
            return;
        }
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        //Stub implementation has one student. Here, we need to confirm
        //that we get back a list of length one.
        assertEquals(1, service.getAllStudents().size());
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
        //Get a student that exists and confirm you get something back
        Student student = service.getStudent("001");
        assertNotNull(student);

        //Get a student that doesn't exists and confirm 
        //you don't get something back
        student = service.getStudent("999");
        assertNull(student);
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
         //Remove a student that exists and confirm you get something back
        Student student = service.removeStudent("001");
        assertNotNull(student);

        //Remove a student that doesn't exists and confirm 
        //you don't get something back
        student = service.removeStudent("999");
        assertNull(student);
    }

}
