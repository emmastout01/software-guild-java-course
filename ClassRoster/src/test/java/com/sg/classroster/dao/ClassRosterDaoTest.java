/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

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
public class ClassRosterDaoTest {

    private ClassRosterDao dao = new ClassRosterDaoFileImpl();

    public ClassRosterDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    //Runs before each of the test methods
    //Need to add a 'throws exception' because getAllStudents throws exception
    //One consequence: If getAllStudents or removeStudents doesn't work, this 
    //won't work. But at the same time, we're doing testing, so if they don't work
    //that's good information for us too.
    @Before
    public void setUp()
            throws Exception {
        //Set DAO in known good state--aka, empty
        List<Student> studentList = dao.getAllStudents();
        //Now we want to go through the students one by one, and remove them
        //So we end with an empty dao
        for (Student student : studentList) {
            dao.removeStudent(student.getStudentId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addStudent method, of class ClassRosterDao.
     */
    @Test
    public void testAddGetStudent() throws Exception {
        //First, create a student to add to the dao:
        Student student = new Student("001");
        student.setFirstName("Joe");
        student.setLastName("Schmitty");
        student.setCohort("Deneb");

        dao.addStudent(student.getStudentId(), student);

        //Then, get that student from the dao: 
        Student fromDao = dao.getStudent(student.getStudentId());

        //Then, check if the student we added is equal to the student 
        //we got back from the dao.
        assertEquals(student, fromDao);
    }

    /**
     * Test of getAllStudents method, of class ClassRosterDao.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        //Add 2 students to the dao.
        Student student1 = new Student("001");
        student1.setFirstName("Joe");
        student1.setLastName("Schmitty");
        student1.setCohort("Deneb");
        
        dao.addStudent(student1.getStudentId(), student1);

        Student student2 = new Student("002");
        student2.setFirstName("Amelia");
        student2.setLastName("Bones");
        student2.setCohort("Ministry of Magic");
        
        dao.addStudent(student2.getStudentId(), student2);

        
        //Make sure that all students came back.
        //We want 2, and only 2, students
        //So, compare our list from getAllStudents with the number 2
        assertEquals(2, dao.getAllStudents().size());
        
    }

    /**
     * Test of removeStudent method, of class ClassRosterDao.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        //Add 2 students to dao
        Student student1 = new Student("001");
        student1.setFirstName("Joe");
        student1.setLastName("Schmitty");
        student1.setCohort("Deneb");
        
        dao.addStudent(student1.getStudentId(), student1);

        Student student2 = new Student("002");
        student2.setFirstName("Amelia");
        student2.setLastName("Bones");
        student2.setCohort("Ministry of Magic");
        
        dao.addStudent(student2.getStudentId(), student2);
        
        //Remove one student and make sure it's gone
        dao.removeStudent(student1.getStudentId());
        
        //Check that the student is gone
        assertEquals(1, dao.getAllStudents().size());
        assertNull(dao.getStudent(student1.getStudentId()));
        
        //Remove the other student and make sure it's gone
        dao.removeStudent(student2.getStudentId());
        
        assertEquals(0, dao.getAllStudents().size());
        assertNull(dao.getStudent(student2.getStudentId()));
        
    }

}
