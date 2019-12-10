package com.intelligencebank.stepDefinitions.resources;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.navigation.data.Navigation;
import com.intelligencebank.stepDefinitions.resources.data.*;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WhenSteps extends StepDefinitionsBase {

    public Resources resources;
    public Navigation navigation;

    public WhenSteps(CucumberTestContext context, Resources resources, Navigation navigation) throws Throwable {
        super(context);
        this.resources = resources;
        this.navigation = navigation;
    }

    @When("^I add a (?:f|F)older$")
    public void i_add_a_folder() throws InterruptedException {
        Pages().resourceFoldersPage().addFolder();
    }

    @When("^complete the Add New Folder Form$")
    public void complete_add_new_folder_form() {
        String randomString = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        String folderName = String.format("test_%s", randomString);
        resources.folder = new Folder(folderName);
        Pages().addFolderPage().setFolderName(folderName);
        Pages().addFolderPage().clickSaveButton();
    }

    @When("^I add a Subfolder(?:| within that)$")
    public void i_add_a_subfolder() throws InterruptedException {
        Pages().homePage().clickMenuOption(navigation.menuOption.getName());
        Pages().resourceFoldersPage().waitForFolders();
        Pages().resourceFoldersPage().clickFolder(resources.folder.getName());
        Pages().resourceFoldersPage().addFolder();
        String randomString = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        String folderName = String.format("test_%s_subfolder", randomString);
        resources.subfolder = new Folder(folderName);
        Pages().addFolderPage().setFolderName(folderName);
        Pages().addFolderPage().clickSaveButton();
        Pages().resourceFoldersPage().clickFolder(resources.subfolder.getName());
    }

    @When("^I clone the folder '(.*)'$")
    public void i_clone_the_folder(String folderName) throws Throwable {
        i_clone_a_folder_to(folderName, "Resources");
    }

    @When("^I clone a folder '(.*)' to '(.*)'$")
    public void i_clone_a_folder_to(String folderFromName, String folderToName) throws Throwable {
        cloneFolder(folderFromName, folderToName);
        long start = System.currentTimeMillis();
        resources.startTime = new StartTime(start);
        Pages().cloneStructurePage().waitForDialogToDisapear();
        long end = System.currentTimeMillis();
        resources.endTime = new EndTime(end);
        Pages().resourceFoldersPage().goBack();
    }

    @When("^I move the file '(.*)' in '(.*)' to '(.*)'$")
    public void i_move_the_folder(String fileName, String folder, String destinationFolderName) throws Throwable {
        resources.fileName = new File(fileName);
        resources.folder = new Folder(folder);
        Pages().homePage().clickMenuOption(navigation.menuOption.getName());
        Pages().resourceFoldersPage().clickFolder(folder);
        Pages().resourceFoldersPage().waitForFolders();
        Pages().resourceFilePage().switchToFileView();
        Pages().resourceFilePage().assertFilePresent(fileName);
        Pages().resourceFilePage().clickFileActionButton(fileName);
        Pages().resourceFilePage().selectMoveFileOption();
        Thread.sleep(1000);
        Pages().moveFolderPage().clickDestinationFolderLink(destinationFolderName);
        Pages().moveFolderPage().clickMoveButton();
        long start = System.currentTimeMillis();
        resources.startTime = new StartTime(start);
        Pages().moveFolderPage().waitForDialogToDisapear();
        long end = System.currentTimeMillis();
        resources.endTime = new EndTime(end);
    }

    @When("^I change the '(.*)' setting to '(.*)'$")
    public void i_change_the_folder_setting(String settingType, String settingValue) throws InterruptedException {
        switch(settingType.toLowerCase()) {
            case "default order":
                Pages().folderSettingsPage().setDefaultOrder(settingValue);
                break;
            case "default layout":
                Pages().folderSettingsPage().setDefaultView(settingValue);
                break;
            default:
                throw new PendingException(String.format("The setting type '%s' has not been implemented yet", settingType));
        }
    }

    @When("^the Force Watermark setting is set to '(true|false)'$")
    public void force_watermark_setting(String isSet) throws InterruptedException {
        if (isSet.equals("true")) {
            Pages().folderSettingsPage().setForceWatermarkTrue();
        } else {
            throw new PendingException("Setting Force Watermark to off is not set yet");
        }
    }

    private void cloneFolder(String folderFromName, String folderToName) throws InterruptedException {
        Pages().resourceFoldersPage().waitForFolders();
        Pages().resourceFoldersPage().switchToFolderView();
        Pages().resourceFoldersPage().selectCloneStructure(folderFromName);
        Pages().cloneStructurePage().selectFolder(folderToName);
        String randomString = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        String clonedFolderName = String.format("%s%s", folderFromName, randomString);
        resources.folder = new Folder(clonedFolderName);
        resources.toFolder = new Folder(folderToName);
        Pages().cloneStructurePage().enterFolderName(clonedFolderName);
        Pages().cloneStructurePage().clickCloneButton();
    }
}
