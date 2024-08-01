package Controller;

import Model.AgencyRegisterModel;
import View.AgencyRegisterView;
import Model.Agency;

import javax.swing.*;


public class AgencyRegisterController {
    private AgencyRegisterView view;
    private AgencyRegisterModel model;

    public AgencyRegisterController(AgencyRegisterView view, AgencyRegisterModel model) {
        this.view = view;
        this.model = model;
    }

    // ActionListener for the Register button

    public void registerUser() {
        // Retrieve input from the view
            String name = view.getName();
            String email = view.getEmail();
            int agencyNo = Integer.parseInt(view.getAgencyNo());
            int numAdoptedKids = Integer.parseInt(view.getAdoptedKids());
            int numInhouseKids = Integer.parseInt(view.getInhouseKids());
            String phno = view.getPhno();
            String location = view.getLoc();
            String address = view.getAddress();

            // Create Agency object
            Agency agency = new Agency();
            agency.setAgencyNo(agencyNo);
            agency.setAgencyName(name);
            agency.setEmailId(email);
            agency.setNumAdoptedKids(numAdoptedKids);
            agency.setNumInhouseKids(numInhouseKids);
            agency.setPh(phno);
            agency.setLocation(location);
            agency.setAddress(address);

            // Register the agency through the model
            boolean success = model.registerAgency(agency);

            // Display success or failure message
            if (success) {
                JOptionPane.showMessageDialog(view,
                        "Agency registered successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(view,
                        "Failed to register agency",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
}

