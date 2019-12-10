package com.intelligencebank.stepDefinitions.permissions;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.navigation.data.Navigation;
import com.intelligencebank.stepDefinitions.resources.data.Resources;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
import java.util.Map;

public class ThenSteps extends StepDefinitionsBase {

    Resources resources;
    Navigation navigation;

    public ThenSteps(CucumberTestContext context, Resources resources, Navigation navigation) throws Throwable {
        super(context);
        this.resources = resources;
        this.navigation = navigation;
    }

    @Then("^'(?:.*)' (?:can|cannot) perform the following folder actions:$")
    public void can_perform_the_following_folder_actions(List<Map<String, String>> dataTable) throws Throwable {
        Pages().resourceFoldersPage().iterateOverFoldersAssertingPermissions(dataTable);
    }

    @Then("^the cloned subfolder '(.*)' has permissions set the same as its parent folder$")
    public void same_permissions(String subfolderName) throws InterruptedException {
        navigateToPermissionDetails(subfolderName);
        Pages().groupPermissionsDetailPage().assertPermissionsEqual(resources.permissions);
    }

    @Then("^the cloned subfolder '(.*)' has no permissions set$")
    public void not_same_permissions(String subfolderName) throws InterruptedException {
        navigateToPermissionDetails(subfolderName);
        Pages().groupPermissionsDetailPage().assertPermissionsNotEqual(resources.permissions);
    }

    @Then("^the options are available for the '(.*)' file:$")
    public void the_options_are_available(String fileName, List<Map<String, String>> availableOptions) throws InterruptedException {
        Pages().resourceFilePage().switchToFileView();
        Pages().resourceFilePage().assertFilePermissions(fileName, availableOptions);
    }

    private void navigateToPermissionDetails(String subfolderName) throws InterruptedException {
        Pages().homePage().clickMenuOption(navigation.menuOption.getName());
        Pages().resourceFoldersPage().clickFolder(resources.toFolder.getName());
        Pages().resourceFoldersPage().clickFolder(resources.folder.getName());
        Pages().resourceFoldersPage().selectFolderSettings(subfolderName);
        Pages().folderSettingsPage().clickPermissionsDetailsButton();
    }
}
