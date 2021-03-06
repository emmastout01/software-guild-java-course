/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dao.JDBCDaoImpl;
import com.sg.classroster.dao.JDBCTemplateDaoImpl;
import com.sg.classroster.dao.MySQLDatabase;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.service.ClassRosterServiceLayerImpl;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import java.sql.SQLException;

/**
 *
 * @author emmastout
 */
public class App {

    public static void main(String[] args) throws ClassRosterPersistenceException, SQLException {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterDao jdbcDao = new JDBCDaoImpl();
        MySQLDatabase dbFactory = new MySQLDatabase();
        ClassRosterDao jdbcTemplateDao = new JDBCTemplateDaoImpl(dbFactory.getJdbcTemplate());
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
            ClassRosterServiceLayer myService = 
                    new ClassRosterServiceLayerImpl(jdbcTemplateDao, myAuditDao);
        ClassRosterController controller
                = new ClassRosterController(myService, myView);
        controller.run();
    }
}
