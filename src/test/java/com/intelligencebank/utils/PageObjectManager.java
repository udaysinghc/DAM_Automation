package com.intelligencebank.utils;

import com.intelligencebank.pageObjects.*;
import com.intelligencebank.pageObjects.admin.*;
import com.intelligencebank.pageObjects.admin.groups.EditGroupsPage;
import com.intelligencebank.pageObjects.admin.groups.GroupsPage;
import com.intelligencebank.pageObjects.admin.groups.UsersAsGroupPage;
import com.intelligencebank.pageObjects.agenda.AgendaPage;
import com.intelligencebank.pageObjects.authenticator.AuthenticatorPage;
import com.intelligencebank.pageObjects.calendar.CalendarPage;
import com.intelligencebank.pageObjects.custompage.CustomPagePage;
import com.intelligencebank.pageObjects.database.DatabaseForm;
import com.intelligencebank.pageObjects.database.DatabaseRecordPage;
import com.intelligencebank.pageObjects.database.DatabaseSettingsPage;
import com.intelligencebank.pageObjects.databases.DatabaseBasePage;
import com.intelligencebank.pageObjects.databases.DatabasePage;
import com.intelligencebank.pageObjects.feeds.FeedsPage;
import com.intelligencebank.pageObjects.myaccount.MyAccountPage;
import com.intelligencebank.pageObjects.mycollections.MyCollectionsPage;
import com.intelligencebank.pageObjects.news.NewsPage;
import com.intelligencebank.pageObjects.people.PeoplePage;
import com.intelligencebank.pageObjects.report.ReportPage;
import com.intelligencebank.pageObjects.resources.*;
import com.intelligencebank.pageObjects.stats.StatsPage;
import com.intelligencebank.pageObjects.survey.SurveyPage;
import com.intelligencebank.pageObjects.workflow.WorkflowPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private BasePage basePage;
    //Agenda
    private AgendaPage agendaPage;
    // Admin
    private GroupsPage groupsPage;
    private EditGroupsPage editGroupsPage;
    private UsersAsGroupPage usersAsGroupPage;
    private AdminUsersPage adminUsersPage;
    private AdminEditUserPage adminEditUserPage;
    private AdminWorkflowsPage adminWorkflowsPage;
    private AddNewWorkflowPage addNewWorkflowPage;
    private AdminBasePage adminBasePage;
    // Authenticator
	private AuthenticatorPage authenticatorPage;
	// Calendar
	private CalendarPage calendarPage;
	// Custom
	private CustomPagePage customPagePage;
	// Database
	private DatabaseBasePage databaseBasePage;
	private DatabasePage databasePage;
	private DatabaseSettingsPage databaseSettingsPage;
	private DatabaseForm databaseForm;
	private DatabaseRecordPage databaseRecordPage;
	// Feeds
	private FeedsPage feedsPage;
    // Home
    private HomePage homePage;
    // Login and Registration
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    // My Account
	private MyAccountPage myAccountPage;
    // My Collections
	private MyCollectionsPage myCollectionsPage;
	// News
    private NewsPage newsPage;
	// People
	private PeoplePage peoplePage;
	// Report
	private ReportPage reportPage;
    // Resources
    private ResourcesBasePage resourcesBasePage;
	private AddFolderPage addFolderPage;
	private ResourceFoldersPage resourceFoldersPage;
	private ResourceFilePage resourceFilePage;
	private CloneStructurePage cloneStructurePage;
	private MoveFolderPage moveFolderPage;
	private MoveFilePage moveFilePage;
	private DeleteFolderDialog deleteFolderDialog;
	private FolderSettingsPage folderSettingsPage;
	private GroupPermissionsDetailPage groupPermissionsDetailPage;
	// Stats
	private StatsPage statsPage;
	// Survey
	private SurveyPage surveyPage;
	// Workflow
	private WorkflowPage workflowPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage basePage() {
        return (basePage == null) ? basePage = new BasePage(driver) : basePage;
    }

    // Agenda
    public AgendaPage agendaPage() {
        return (agendaPage == null) ? agendaPage = new AgendaPage(driver) : agendaPage;
    }

    // Admin
    public AdminBasePage adminBasePage() {
        return (adminBasePage == null) ? adminBasePage = new AdminBasePage(driver) : adminBasePage;
    }

    public AdminWorkflowsPage adminWorkflowsPage() {
        return (adminWorkflowsPage == null) ? adminWorkflowsPage = new AdminWorkflowsPage(driver) : adminWorkflowsPage;
    }

    public AddNewWorkflowPage addNewWorkflowPage() {
        return (addNewWorkflowPage == null) ? addNewWorkflowPage = new AddNewWorkflowPage(driver) : addNewWorkflowPage;
    }

    public GroupsPage groupsPage() {
        return (groupsPage == null) ? groupsPage = new GroupsPage(driver) : groupsPage;
    }

    public EditGroupsPage editGroupsPage() {
        return (editGroupsPage == null) ? editGroupsPage = new EditGroupsPage(driver) : editGroupsPage;
    }

    public UsersAsGroupPage usersAsGroupPage() {
        return (usersAsGroupPage == null) ? usersAsGroupPage = new UsersAsGroupPage(driver) : usersAsGroupPage;
    }

    public AdminUsersPage adminUsersPage() {
        return (adminUsersPage == null) ? adminUsersPage = new AdminUsersPage(driver) : adminUsersPage;
    }

    public AdminEditUserPage adminEditUserPage() {
        return (adminEditUserPage == null) ? adminEditUserPage = new AdminEditUserPage(driver) : adminEditUserPage;
    }

    // Authenticator
	public AuthenticatorPage authenticatorPage() {
    	return (authenticatorPage == null) ? authenticatorPage = new AuthenticatorPage(driver) : authenticatorPage;
	}

	// Calendar
	public CalendarPage calendarPage() {
    	return (calendarPage == null) ? calendarPage = new CalendarPage(driver) : calendarPage;
	}

	// Custom Page
	public CustomPagePage customPagePage() {
    	return (customPagePage == null) ? customPagePage = new CustomPagePage(driver) : customPagePage;
	}

	// Database
    public DatabaseBasePage databaseBasePage() {
        return (databaseBasePage == null) ? databaseBasePage = new DatabaseBasePage(driver) : databaseBasePage;
    }

    public DatabasePage databasePage() {
        return (databasePage == null) ? databasePage = new DatabasePage(driver) : databasePage;
    }

    public DatabaseSettingsPage databaseSettingsPage() {
        return (databaseSettingsPage == null) ? databaseSettingsPage = new DatabaseSettingsPage(driver) : databaseSettingsPage;
    }

    public DatabaseForm databaseForm() {
        return (databaseForm == null) ? databaseForm = new DatabaseForm(driver) : databaseForm;
    }

    public DatabaseRecordPage databaseRecordPage() {
        return (databaseRecordPage == null) ? databaseRecordPage = new DatabaseRecordPage(driver) : databaseRecordPage;
    }

    // Feeds
	public FeedsPage feedsPage() {
    	return (feedsPage == null) ? feedsPage = new FeedsPage(driver) : feedsPage;
	}

	// Home
    public HomePage homePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    // Login and Registration
    public LoginPage loginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public RegistrationPage registrationPage() {
        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
    }

    // My Account
	public MyAccountPage myAccountPage() {
    	return (myAccountPage == null) ? myAccountPage = new MyAccountPage(driver) : myAccountPage;
	}

    // My Collections
	public MyCollectionsPage myCollectionsPage() {
    	return (myCollectionsPage == null) ? myCollectionsPage = new MyCollectionsPage(driver) : myCollectionsPage;
	}

	// News
    public NewsPage newsPage() {
        return (newsPage == null) ? newsPage = new NewsPage(driver) : newsPage;
    }

	// People
	public PeoplePage peoplePage() {
    	return (peoplePage == null) ? peoplePage = new PeoplePage(driver) : peoplePage;
	}

	// Report
	public ReportPage reportPage() {
    	return (reportPage == null) ? reportPage = new ReportPage(driver) : reportPage;
	}

    // Resources
    public ResourcesBasePage resourcesPage() {
        return (resourcesBasePage == null) ? resourcesBasePage = new ResourcesBasePage(driver) : resourcesBasePage;
    }

    public AddFolderPage addFolderPage() {
        return (addFolderPage == null) ? addFolderPage = new AddFolderPage(driver) : addFolderPage;
    }

    public ResourceFoldersPage resourceFoldersPage() {
        return (resourceFoldersPage == null) ? resourceFoldersPage = new ResourceFoldersPage(driver) : resourceFoldersPage;
    }

    public ResourceFilePage resourceFilePage() {
        return (resourceFilePage == null) ? resourceFilePage = new ResourceFilePage(driver) : resourceFilePage;
    }

    public CloneStructurePage cloneStructurePage() {
        return (cloneStructurePage == null) ? cloneStructurePage = new CloneStructurePage(driver) : cloneStructurePage;
    }

    public MoveFolderPage moveFolderPage() {
        return (moveFolderPage == null) ? moveFolderPage = new MoveFolderPage(driver) : moveFolderPage;
    }

    public MoveFilePage moveFilePage() {
        return (moveFilePage == null) ? moveFilePage = new MoveFilePage(driver) : moveFilePage;
    }

    public DeleteFolderDialog deleteFolderDialog() {
        return (deleteFolderDialog == null) ? deleteFolderDialog = new DeleteFolderDialog(driver) : deleteFolderDialog;
    }

    public FolderSettingsPage folderSettingsPage() {
        return (folderSettingsPage == null) ? folderSettingsPage = new FolderSettingsPage(driver) : folderSettingsPage;
    }

    public GroupPermissionsDetailPage groupPermissionsDetailPage() {
        return (groupPermissionsDetailPage == null) ? groupPermissionsDetailPage = new GroupPermissionsDetailPage(driver) :groupPermissionsDetailPage;
    }

    // Stats
	public StatsPage statsPage() {
    	return (statsPage == null) ? statsPage = new StatsPage(driver) : statsPage;
	}

	// Survey
	public SurveyPage surveyPage() {
    	return (surveyPage == null) ? surveyPage = new SurveyPage(driver) : surveyPage;
	}

	// Workflow
	public WorkflowPage workflowPage() {
    	return (workflowPage == null) ? workflowPage = new WorkflowPage(driver) : workflowPage;
	}
}