# User 7 & User 8 JavaFX MVC Bundle

This bundle contains JavaFX Model, Controller, and FXML files for 16 goals (8 for Finance Officer, 8 for System Administrator).

- Packages: `model`, `controller`
- Each goal has a trio of files:
  - `models/<ClassName>Model.java`
  - `controllers/<ClassName>Controller.java`
  - `fxml/<ShortName>.fxml`

Note: Controllers include simple `Validate`, `Process`, and `Verify` actions that you can wire to your services/database.