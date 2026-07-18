# Rest-Assured-Project

A Java API test automation practice framework built with **REST Assured**, **TestNG**, **Maven**, and **Allure Reporting**, exercising the public [reqres.in](https://reqres.in) mock API (Create, Get, Update, Delete user endpoints).

> This README doubles as a repo analysis — written by reviewing the actual commit history and current file tree at [TushanSakib/Rest-Assured-Project](https://github.com/TushanSakib/Rest-Assured-Project), not just the code in isolation.

---

## Tech Stack

| Layer | Tool |
|---|---|
| HTTP client / assertions | REST Assured 5.5.1 |
| Test runner | TestNG 7.10.2 |
| JSON mapping | Jackson Databind 2.18.2 |
| Reporting | Allure 2.25.0 (`allure-testng` + `allure-maven`) |
| Build | Maven |

---

## Project Structure

```
Rest-Assured-Project/
├── src/main/java/
│   ├── base/BaseTest.java                    # Sets RestAssured.baseURI before each test class
│   ├── clients/                              # Raw HTTP layer (RestAssured calls)
│   │   ├── BaseClient.java
│   │   └── UserClient.java
│   ├── services/UserService.java             # Business layer: logs + maps Response -> POJO
│   ├── models/
│   │   ├── request/  (CreateUserRequest, UpdateUserRequest)
│   │   └── response/ (CreateUserResponse, UpdateUserResponse)
│   ├── endpoints/Routes.java                 # Centralized endpoint path constants
│   └── utils/
│       ├── ConfigReader.java                 # Loads config.qa.properties
│       ├── RequestSpecificationManager.java  # Shared RequestSpecBuilder (content-type + api key header)
│       ├── ResponseSpecificationManager.java
│       ├── AssertionUtils.java
│       ├── TestDataFactory.java
│       └── LoggerUtils.java
├── src/test/java/tests/
│   ├── CreateUserTest.java
│   ├── UpdateUserTest.java
│   ├── DeleteUserTest.java
│   └── UserAPITest.java                      # GET /users
├── testng.xml                                 # Suite definition, wires the Allure listener
├── run-tests-with-report.ps1                  # Windows-only: runs tests + opens Allure report
└── pom.xml
```

**Layering is the right idea**: `clients` (raw HTTP) → `services` (business logic/mapping) → `tests` (assertions), with request/response POJOs kept separate. This is the same shape used by production-grade API frameworks.

---

## Setup

1. Clone the repo.
2. **Create the config file the repo doesn't ship** (it's intentionally gitignored — see [Findings](#findings-from-the-repo-analysis) below):
   ```
   src/main/resources/config.qa.properties
   ```
   with:
   ```properties
   base.url=https://reqres.in
   x.api.key=<your reqres.in API key>
   ```
3. Run the suite:
   ```bash
   mvn clean test
   ```
4. Generate/view the Allure report:
   ```bash
   mvn allure:report
   mvn allure:serve
   ```
   (Windows users can run `run-tests-with-report.ps1` to do steps 3–4 in one go.)

---

## What's actually covered

| Endpoint | Method | Test |
|---|---|---|
| `/api/users?page=2` | GET | `UserAPITest.verifyGetUsers` |
| `/api/users` | POST | `CreateUserTest.verifyUserCreation` |
| `/api/users/{id}` | PUT | `UpdateUserTest.verifyUserUpdate` |
| `/api/users/{id}` | DELETE | `DeleteUserTest.verifyDeleteUser` |

`GET /api/users/{id}` (`getSingleUser`) exists in `UserClient` but has no corresponding test yet.

---

## Findings from the repo analysis

Based on the 28-commit history and the current `main` branch tree:

- **No `config.qa.properties` is committed** (correctly excluded via `.gitignore`, per commit `Remove config.qa.properties from tracking`) — good instinct on secrets hygiene, but the repo has no setup docs telling a new clone what keys the file needs. This README now covers that gap.
- **`target/` is tracked in Git** despite `.gitignore` correctly listing `target/`. It was committed in earlier history before the ignore rule existed, so Git kept tracking it (`git rm -r --cached target/` never ran). This is visible externally too: GitHub's **Languages** breakdown for this repo currently reports CSS/HTML/JS percentages higher than Java — that's the committed Surefire HTML report assets (`target/surefire-reports/*.html/.css/.js`) being counted as source, not the actual Java codebase.
- **`.idea/` is also tracked** for the same reason — IDE metadata shouldn't ship in the repo.
- **A dead config path**: `src/main/resources/config/qa.properties` exists in the repo but is empty and unused — looks like an abandoned attempt at multi-environment config (`config/qa.properties`, `config/prod.properties`, etc.) that `ConfigReader` was never wired up to read from.
- **`ConfigReader` loads via a hardcoded relative file path** (`new FileInputStream("src/main/resources/config.qa.properties")`) rather than the classpath. This only works when Maven is run from the project root — it breaks if the tests are ever packaged into a JAR or run from a different working directory in CI.
- **`pom.xml` sets Java compiler version twice, inconsistently** — `<maven.compiler.source>1.8</maven.compiler.source>` / `1.8` target in `<properties>`, but the `maven-compiler-plugin` block separately pins `source`/`target` to `15`. The plugin config wins, so the `<properties>` values are dead/misleading.
- **No CI workflow.** Tests only run locally today (`run-tests-with-report.ps1` is Windows-only, and there's no cross-platform script or GitHub Actions pipeline), so there's no automated signal on pull requests.
- **Good recent progress**, worth calling out: the last few commits (`added some fixs`, `Added delecte and request response utils`) already fixed the `application/json` content-type typo, switched `DeleteUserTest` to the correct `org.testng.annotations.Test` import, and corrected the `verifyStatusCode` method name — the codebase is actively improving commit over commit.

---

## Suggested next steps

1. `git rm -r --cached target/ .idea/` and commit — this alone will fix the GitHub language stats and stop shipping build artifacts.
2. Remove the dead `src/main/resources/config/qa.properties` or wire `ConfigReader` to actually support multiple environments via it.
3. Load config via the classloader instead of a relative file path.
4. Add a `.github/workflows/tests.yml` GitHub Actions pipeline so `mvn test` runs on every push/PR.
5. Add a test for `getSingleUser`, since the client method exists but is currently untested.

*(For the full prioritized checklist — including config, logging, and code-quality upgrades — see the companion `restassured-industry-standard-guide.md`.)*
