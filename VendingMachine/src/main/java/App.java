
import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.service.VendingMachineServiceImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class App {
    public static void main(String[] args) 
            throws VendingMachinePersistenceException{
        
        VendingMachineView view = new VendingMachineView();
        VendingMachineDao dao = new VendingMachineDaoFileImpl();
        VendingMachineService service = new VendingMachineServiceImpl(dao);
        VendingMachineController controller = 
                new VendingMachineController(view, dao, service);
        
        controller.run();
    }
}
