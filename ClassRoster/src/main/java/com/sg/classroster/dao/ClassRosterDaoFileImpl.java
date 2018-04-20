/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    private Map<String, Student> students = new HashMap<>();

    @Override
    public Student addStudent(String studentId, Student student)
            throws ClassRosterDaoException {
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents()
            throws ClassRosterDaoException {
        //Get all of the student objects out of the students map
        //Does this with the values() method
        loadRoster();
        return new ArrayList<Student>(students.values());

    }

    @Override
    public Student getStudent(String studentId)
            throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId)
     throws ClassRosterDaoException{
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;

        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);

            Student currentStudent = new Student(currentTokens[0]);
            // Set the remaining vlaues on currentStudent manually
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);

            // Put currentStudent into the map using studentID as the key
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        // close scanner
        scanner.close();
    }

    private void writeRoster() throws ClassRosterDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException("Could not save student data.", e);
        }

        List<Student> studentList = this.getAllStudents();

        for (Student currentStudent : studentList) {
            out.println(currentStudent.getStudentId() + DELIMITER
                    + currentStudent.getFirstName() + DELIMITER
                    + currentStudent.getLastName() + DELIMITER
                    + currentStudent.getCohort());
            out.flush();
        }
        out.close();
    }

}
