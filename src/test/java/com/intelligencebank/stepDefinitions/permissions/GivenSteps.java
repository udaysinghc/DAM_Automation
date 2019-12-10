package com.intelligencebank.stepDefinitions.permissions;

import com.intelligencebank.stepDefinitions.CommonSteps;
import com.intelligencebank.stepDefinitions.admin.data.Admin;
import com.intelligencebank.stepDefinitions.navigation.data.Navigation;
import com.intelligencebank.stepDefinitions.resources.data.Resources;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;

import java.util.List;
import java.util.Map;

public class GivenSteps extends StepDefinitionsBase {

    Resources resources;
    Navigation navigation;
    Admin admin;

    public GivenSteps(CucumberTestContext context, Resources resources, Navigation navigation, Admin admin) throws Throwable {
        super(context);
        this.resources = resources;
        this.navigation = navigation;
        this.admin = admin;
    }

    @Given("^the permissions on the '(?:.*)' folder are:$")
    public void the_permissions_on_the_folder_are(List<Map<String,String>> permissions) {
        resources.permissions = permissions;
    }

    @Given("^'(.*)' is in the group '(.*)' only$")
    public void is_only(String uname, String groupname) throws Throwable {
        CommonSteps givenSteps = new CommonSteps(cucumberTestContext);
        givenSteps.i_open_the_param_page("Home");
        Pages().loginPage().loginAdmin(cucumberTestContext);
        Pages().adminUsersPage().navigateToUser(uname);
        if (groupname.toLowerCase().equals("user as group")) {
            Pages().adminEditUserPage().setUserAsGroupCheckboxChecked();
            Pages().adminEditUserPage().clickSave();
        } else {
            Pages().adminEditUserPage().unsetUserAsGroupCheckbox();
            Pages().adminEditUserPage().setGroup(groupname);
            Pages().adminEditUserPage().clickSave();
        }
    }

    @Given("^'(.*)' has '(.*)' (?:|only )General Permissions$")
    public void has_only_General_Permissions(String uname, String permissionLevel) throws InterruptedException {
        Pages().groupsPage().clickGroupsTab();
        Pages().usersAsGroupPage().waitAndClickUsersAsGroupTab();
        Pages().usersAsGroupPage().useSearch(uname);
        Pages().usersAsGroupPage().selectEditUserSingleRecord();
        Pages().usersAsGroupPage().selectPermissionsTab();
        Pages().usersAsGroupPage().setAccessSwitchOn();
        Pages().usersAsGroupPage().deleteAllResourcesPermissions();
        switch (permissionLevel) {
            case "No":
                break;
            default:
                Pages().usersAsGroupPage().clickAddDefaultPermissionsRuleButton();
                Pages().usersAsGroupPage().selectDefaultPermissionAndSave(permissionLevel);
                break;
        }
        Pages().usersAsGroupPage().switchOutOfIframe();
    }

    @Given("^'(.*)' has '(.*)' group General Permissions$")
    public void has_group_General_Permissions(String userGroup, String permissionLevel) throws InterruptedException {
        Pages().groupsPage().clickGroupsTab();
        Pages().groupsPage().editGroup(userGroup);
        Pages().editGroupsPage().selectPermissionsTab();
        Pages().editGroupsPage().switchToGroupsIframe();
        Pages().editGroupsPage().setAccessSwitchOn();
        Pages().editGroupsPage().deleteAllResourcesPermissions();
        switch (permissionLevel) {
            case "No":
                break;
            default:
                Pages().editGroupsPage().clickAddDefaultPermissionsRuleButton();
                Pages().editGroupsPage().selectDefaultPermissionAndSave(permissionLevel);
                break;
        }
        Pages().editGroupsPage().switchOutOfIframe();
    }

    @Given("^I am logged in as an '(.*)'$")
    public void i_am_logged_in_as(String uname) throws Throwable {
        CommonSteps givenSteps = new CommonSteps(cucumberTestContext);
        givenSteps.i_open_the_param_page("Home");
        Pages().loginPage().login(cucumberTestContext, uname, admin);
    }

    @Given("^the user '(?:.*)' has navigated to the '(.*)' folder$")
    public void the_user_has_navigated_to(String foldername) {
        Pages().resourceFoldersPage().waitForFolders();
        Pages().resourceFoldersPage().clickFolder(foldername);
    }
}
