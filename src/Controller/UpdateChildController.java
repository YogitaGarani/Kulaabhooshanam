package Controller;
import java.sql.SQLException;
import java.sql.Timestamp;

import Model.UpdateChildModel;
import View.UpdateChildView;

public class UpdateChildController {
    private UpdateChildView view;
    private UpdateChildModel model;

    public UpdateChildController(UpdateChildView view, UpdateChildModel model) {
        this.view = view;
        this.model = model;

    }

        public void submitChildInfo() {
            try {
                int id = view.getId();
                String name = view.getName();
                String dob = view.getDOB();
                String sex = view.getSex();
                String geneticDisorder = view.getGeneticDisorder();
                String adoptionStatus = view.getAdoptionStatus();
                Timestamp dateAdmitted = new Timestamp(System.currentTimeMillis());
                int agencyId = view.getAgencyID();
                int age = view.getAge();

                if (!model.childExists(id)) {
                    view.displayMessage("Child does not exist.");
                    return;
                }

                model.updateChild(id, name, dob, sex, dateAdmitted, adoptionStatus, geneticDisorder, agencyId, age);
                view.displayMessage("Child information updated successfully!");
                view.clearFields();
            } catch (SQLException ex) {
                ex.printStackTrace();
                view.displayMessage("Error occurred while updating child information.");
            }
        }
}
