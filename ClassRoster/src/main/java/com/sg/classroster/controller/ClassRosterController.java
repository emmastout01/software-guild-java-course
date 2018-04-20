/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class ClassRosterController {

    ClassRosterView view;
    ClassRosterDao dao;
    
    public ClassRosterController
        (ClassRosterDao dao, ClassRosterView view) {
            this.view = view;
            this.dao = dao;
    } 

    public void run() throws ClassRosterDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{

        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    getStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
        } catch (ClassRosterDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() 
            throws ClassRosterDaoException{
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() 
            throws ClassRosterDaoException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void getStudent() 
            throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        String idChoice = view.getStudentIdChoice();
        Student student = dao.getStudent(idChoice);
        view.displayStudent(student);
    }

    private void removeStudent()
            throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String idChoice = view.getStudentIdChoice();
        dao.removeStudent(idChoice);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
