package com.intelligencebank.stepDefinitions.resources;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.navigation.data.Navigation;
import com.intelligencebank.stepDefinitions.resources.data.Resources;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class ThenSteps extends StepDefinitionsBase {
    private Resources resources;
    private Navigation navigation;

    public ThenSteps(CucumberTestContext context, Resources resources, Navigation navigation) throws Throwable {
        super(context);
        this.resources = resources;
        this.navigation = navigation;
    }

    @Then("^it should take less than (.*) seconds$")
    public void it_should_take_less_than_seconds(Integer expectedTime) {
        long startTime = resources.startTime.getTime();
        long endTime = resources.endTime.getTime();
        long timeElapsed = endTime - startTime;
        long expectedTimeConverted = Long.valueOf(expectedTime * 1000);
        boolean isTimely = false;
        if(timeElapsed < expectedTimeConverted) {
            isTimely = true;
        }
        Assert.assertTrue(isTimely, String.format("The action took longer that %n seconds", expectedTime));
    }

    @Then("^the new folder is visible in the folders view$")
    public void new_folder_visible() {
        Pages().resourceFoldersPage().assertFolderPresent(resources.folder.getName());
    }

    @Then("^the Breadcrumb line is updated$")
    public void breadcrumb_line_is_updated() {
        Pages().resourceFoldersPage().assertBreadcrumbItem(resources.subfolder.getName());
        Pages().resourceFoldersPage().assertBreadcrumbItem(resources.folder.getName());
    }

    @Then("^the home button works$")
    public void home_button_works() {
        Pages().resourceFoldersPage().clickHomeBreadcrumb();
        Pages().resourceFoldersPage().assertOnPage("Files");
    }

    @Then("^the files are sorted '(.*)'$")
    public void the_files_are_sorted(String sortingType) throws InterruptedException {
        switch(sortingType.toLowerCase()) {
            case "alphabetically":
                Pages().resourceFilePage().assertFilePosition(resources.filesSortOrderAlphabetically);
                break;
            case "chronologically":
                Pages().resourceFilePage().assertFilePosition(resources.filesSortOrderChronologically);
                break;
            default:
                throw new PendingException(
                        String.format("Haven't implemented any concrete actions for the sorting type '%s' yet",
                                sortingType.toLowerCase()));
        }
    }

    @Then("^the '(.*)' view is displayed by default$")
    public void the_view_is_displayed_by_default(String viewType) {
        Pages().resourceFilePage().assertView(viewType);
    }

    @Then("^the Force Watermark setting is set to '(true|false)' on the subfolder$")
    public void the_force_watermark_is_set_to(String isSet) throws InterruptedException {
        if (isSet.equals("false")) {
            Pages().homePage().clickMenuOption(navigation.menuOption.getName());
            Pages().resourceFoldersPage().clickFolder(resources.folder.getName());
            Pages().resourceFilePage().switchToFolderView();
            Pages().resourceFoldersPage().selectFolderSettings(resources.subfolder.getName());
            Pages().folderSettingsPage().assertForceWatermarkFalse();
        } else {
            throw new PendingException("Setting Force Watermark to off is not set yet");
        }
    }
}
