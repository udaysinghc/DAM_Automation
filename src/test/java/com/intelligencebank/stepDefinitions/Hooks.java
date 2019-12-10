package com.intelligencebank.stepDefinitions;

import com.intelligencebank.stepDefinitions.admin.data.Admin;
import com.intelligencebank.stepDefinitions.admin.data.Email;
import com.intelligencebank.stepDefinitions.navigation.data.Navigation;
import com.intelligencebank.stepDefinitions.resources.data.File;
import com.intelligencebank.stepDefinitions.resources.data.Resources;
import com.intelligencebank.stepDefinitions.resources.data.StartTime;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.intelligencebank.utils.CucumberTestContext;

import java.util.ArrayList;
import java.util.Collection;

public class Hooks extends StepDefinitionsBase {

   private Resources resources;
   private Admin admin;
   private Navigation navigation;

   public Hooks(CucumberTestContext context, Resources resources, Admin admin, Navigation navigation) throws Throwable {
      super(context);
      this.resources = resources;
      this.admin = admin;
      this.navigation = navigation;
   }

   @Before
   public void setUp(Scenario scenario) throws Throwable {
      cucumberTestContext.initialize();
      cucumberTestContext.getScenarioContext().setValue("ScenarioName", scenario.getName());
      Collection<String> tagnames = scenario.getSourceTagNames();
      for(String item : tagnames) {
         if (item.equals("@DPC")) {
            admin.domain = new Email("@dpc.vic.gov.au");
         } else {
            admin.domain = new Email("@intelligencebank.com");
         }
      }
   }

   @Before(value = "@FileSortData")
   public void fileSortData(Scenario scenario) {
      Collection<String> tagnames = scenario.getSourceTagNames();
      for(String item : tagnames) {
         if (item.equals("@DPC")) {
            resources.filesSortOrderAlphabetically = new ArrayList<>();
            resources.filesSortOrderAlphabetically.add(new File("00175_AIM_Q4Calendar_VIC_Digital_PROOF_20170811 (1)"));
            resources.filesSortOrderAlphabetically.add(new File("00273_AIM_CourseDirectory_20180405"));
            resources.filesSortOrderAlphabetically.add(new File("DPC-metrics-2019-08-02"));

            resources.filesSortOrderChronologically = new ArrayList<>();
            resources.filesSortOrderChronologically.add(resources.filesSortOrderAlphabetically.get(0));
            resources.filesSortOrderChronologically.add(resources.filesSortOrderAlphabetically.get(2));
            resources.filesSortOrderChronologically.add(resources.filesSortOrderAlphabetically.get(1));
         }
      }
   }

   @After(value = "@DeleteClonedFolders or @DeleteFolders", order = 9999)
   public void deleteClonedFolders() {
      try {
         String folderName = resources.folder.getName();
         String menuOption = navigation.menuOption.getName();
         if(folderName != null) {
            Pages().homePage().clickMenuOption(menuOption);
            Pages().resourceFoldersPage().waitForFolders();
            Pages().resourceFoldersPage().selectDeleteFolder(folderName);
            Pages().deleteFolderDialog().clickDeleteFolder();
            Thread.sleep(1000);
         }
      } catch (Exception ex) {
         // don't throw an exception in teardown, will implement logging here
      }
   }

   @After(value = "@DeleteClonedPermissionsFolders", order = 9994)
   public void deleteClonedPermissionsFolders() throws InterruptedException {
      Pages().homePage().clickMenuOption(navigation.menuOption.getName());
      Pages().resourceFoldersPage().waitForFolders();
      Pages().resourceFoldersPage().clickFolder(resources.toFolder.getName());
      Pages().resourceFoldersPage().waitForFolders();
      Pages().resourceFoldersPage().selectDeleteFolder(resources.folder.getName());
      Pages().deleteFolderDialog().clickDeleteFolder();
      Pages().resourceFilePage().waitForFiles();
   }

   @After(value = "@DeleteSubfolder", order = 9995)
   public void deleteSubfolder() throws InterruptedException {
      String menuOption = navigation.menuOption.getName();
      String folderName = resources.folder.getName();
      String subfolderName = resources.subfolder.getName();
      Pages().homePage().clickMenuOption(menuOption);
      Pages().resourceFoldersPage().waitForFolders();
      Pages().resourceFoldersPage().clickFolder(folderName);
      Pages().resourceFilePage().switchToFolderView();
      Pages().resourceFoldersPage().selectDeleteFolder(subfolderName);
      Pages().deleteFolderDialog().clickDeleteFolder();
      Pages().resourceFilePage().waitForFiles();
   }

   @After(value = "@MoveFileBack", order = 9998)
   public void deleteFolders() {
      try {
         String folderName = resources.folder.getName();
         String fileName = resources.fileName.getName();
         boolean isGotoFolderButton = Pages().moveFilePage().isGotoFolderButton();
         if (isGotoFolderButton) {
            Pages().moveFilePage().clickGotoFolderButton();
            Pages().resourceFoldersPage().waitForFolders();
            Pages().resourceFilePage().switchToFileView();
            Pages().resourceFilePage().clickFileActionButton(fileName);
            Pages().resourceFilePage().selectMoveFileOption();
            Thread.sleep(1000);
            Pages().moveFolderPage().clickDestinationFolderLink(folderName);
            Pages().moveFolderPage().clickMoveButton();
            long start = System.currentTimeMillis();
            resources.startTime = new StartTime(start);
            Pages().moveFolderPage().waitForDialogToDisapear();
         }
      } catch (Exception ex) {
         // don't throw an exception in teardown, will implement logging here
      }
   }

   @After(value = "@DeleteUser", order = 9997)
   public void deleteUser() {
      try {
         String expectedUname = String.format("%s %s", admin.firstname.getValue(), admin.lastname.getValue());
         if(Pages().adminUsersPage().isUserNameInGrid(expectedUname)) {
            Pages().adminUsersPage().deleteRecord();
            Pages().adminUsersPage().waitForDeleteDialogToDisappear();
            Pages().adminUsersPage().isUserNameInGrid(expectedUname);
         }
      } catch (Exception ex) {
         // Just let it go dude, it's a teardown ;)
      }
   }

   @After(value = "@ListView", order = 9996)
   public void returnToListView() throws InterruptedException {
      String folderName = resources.folder.getName();
      String menuOption = navigation.menuOption.getName();
      Pages().homePage().clickMenuOption(menuOption);
      Pages().resourceFoldersPage().waitForFolders();
      Pages().resourceFoldersPage().selectFolderSettings(folderName);
      Pages().folderSettingsPage().setDefaultView("List");
      Pages().resourceFilePage().waitForFiles();
      Thread.sleep(1000);
   }

   @After(order = 10)
   public void tearDown() {
      if (cucumberTestContext == null)
         return;
      cucumberTestContext.tearDown();
   }

   @After("@DeleteDatabase")
   public void deleteDatabase() {
      //TODO code to delete db
   }
}
