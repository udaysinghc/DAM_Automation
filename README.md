
# Automated Testing of the IntelligenceBank platform


## Running the Tests

mvn test -DsuiteXmlFile=config-default.xml -Dcucumber.options='--tags "(@smoke or @sanity or @overnight) and not @ignore and not @manual"'


## Automated Test Suites

@smoke
  Duration: +/- 5 minutes
  Environment: Run on developer machines before checking in any changes and after deployments to each environment (incl production).
  Purpose: Validate that the changes are not stopping other dev work
  Scope: Touching all major integration points
  
@sanity
  Duration: < 30 minutes
  Environment: Run on the gitlab agent upon committing to the gitlab GIT repo.
  Purpose: Validate that the changes are not breaking customers major use cases
  Scope: smoke + All postive scenarios, regularely encountered negative scenarios

@overnight
  Duration: < 4 Hours
  Environment: Run on the gitlab agent, scheduled to run overnight
  Purpose: Validate that the changes are not breaking customers most common use cases
  Scope: sanity + all known edge cases except for long running tests and very unlikely scenarios

@regression 
  Duration: No limit, expected to run between 4 and 24 hours.
  Environment: Run on the gitlab agent, scheduled to run over the weekend
  Purpose: Validate that the changes are not breaking customers most common use cases
  Scope: quick-regression + all known edge cases

@manual
  Duration: N/A
  Environment: Dev/Test machine
  Purpose: test that can only be run manually
  Scope: Failover tests, Misconfigured Databases, etc

@ignore
  Duration: N/A
  Environment: N/A
  Purpose: USE ONLY IF NEEDED !    Temporarely disable a test. There is significant risk in forgetting to re-enable to test, so only use in very rare scenarios.
  Scope: 


## Credentials

Credentials used while testing will be stored as environment variable setting in Gitlab.
They will have to be configured on the machine where the Cucumber tests are running and the values on the target environment. 

For example, for running the tests against the pre-production environment, the following env vars are needed:
ib-autotest-preprod-user-admin-username
ib-autotest-preprod-user-admin-password

For pre-staging however:
ib-autotest-prestaging-user-admin-username
ib-autotest-prestaging-user-admin-password

The full list of required credential environment variables:
ib-autotest-{{ENV}}-users-default-username
ib-autotest-{{ENV}}-users-default-password
ib-autotest-{{ENV}}-users-admin-username
ib-autotest-{{ENV}}-users-admin-password
ib-autotest-{{ENV}}-users-incorrect-username
ib-autotest-{{ENV}}-users-incorrect-password
ib-autotest-{{ENV}}-users-blank-username
ib-autotest-{{ENV}}-users-blank-password

Where {{ENV}} is one of the following environments:
prestaging
prestaging2
prestaging3
staging
preprod
production-au
production-us
production-eu

Note: Customer specific environments are not supported (for now), examples are DPC, Deloite, etc


