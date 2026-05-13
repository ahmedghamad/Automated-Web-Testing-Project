# Automated Web Testing Project

## Table of Contents
- [Goal](#goal-of-the-project)
- [Team](#team)
- [System Under Test](#system-under-test)
- [Setup](#how-to-set-up-the-framework)
- [Project Structure](#project-structure)
- [What Was Tested](#what-was-tested)
- [Test Metrics](#test-metrics)
- [Sprint DoR & DoD](#sprint-definition-of-ready)
- [Defect Reports](#defect-reports)
- [Exploratory Testing](#exploratory-test-charters)


---

## Goal of the Project
The goal was to design and implement an automated test framework for
[Automation Exercise](https://automationexercise.com/) following Agile Scrum
methodology across a single sprint, using Java, Selenium, Serenity BDD and
Cucumber with the Page Object Model pattern.

Key objectives:
- Derive user stories from the site's functionality
- Write Gherkin feature files representing real user journeys
- Automate test cases and document any defects found
- Demonstrate collaborative working practices using GitHub
  
---

## Team

| Name | Role | 
|------|------|
| Ahmed | Product Owner | 
| Badria | Scrum Master | 
| Roshanbi | Test Lead | 
| Tam | Tester | 
| Sharaf | Tester | 

## System Under Test

| | |
|-|-|
| **URL** | https://automationexercise.com/ |
| **Type** | E-commerce demo site |
| **Browser** | Chrome |
| **Environment** | Desktop web |

---

## How to Set Up the Framework

**Prerequisites:** Java JDK 21, Maven, Chrome, IntelliJ IDEA

# Clone the repo
git clone https://github.com/ahmedghamad/Automated-Web-Testing-Project.git

# Install dependencies
mvn clean install

# Run all tests
mvn verify

# View Serenity report
open target/site/serenity/index.html

## Project Structure

```
src/
└── test/
    ├── java/com/sparta/
    │   ├── pages/          # Page Object Model classes
    │   ├── steps/          # Cucumber step definitions
    │   └── runners/        # Test runner
    └── resources/
        └── features/       # Gherkin feature files
```

## What Was Tested

| # | User Story | Type | Status |
|---|-----------|------|--------|
| 1 | User Login | Automated | ✅ |
| 2 | User Registration | Automated | ✅ |
| 3 | User Logout | Automated | ✅ |
| 4 | Browse Products | Automated | ✅ |
| 5 | Search for Product | Automated | ✅ |
| 6 | Filter by Category | Automated | ✅ |
| 7 | Filter by Brand | Automated | ✅ |
| 8 | View Product Details | Automated | ✅ |
| 9 | Add Product to Cart | Automated | ✅ |
| 10 | Add Multiple Quantities | Automated | ✅ |
| 11 | Write a Product Review | Automated | ✅ |
| 12 | View Cart | Automated | ✅ |
| 13 | Remove from Cart | Automated | ✅ |
| 14 | Checkout Process | Automated | ✅ |
| 15 | Contact Form | Automated | ✅ |
| 16 | Download Invoice | Manual | ✅ |


## Sprint Definition of Ready
A user story is ready when ALL of the following are true:
- [ ] Sprint goal defined and agreed by the team
- [ ] All stories in a ready state with acceptance criteria
- [ ] Backlog prioritised and stories assigned
- [ ] GitHub project board set up with all tickets
- [ ] Framework setup complete before stories begin
- [ ] No unresolved blockers outstanding

## Sprint Definition of Done
The sprint is done when ALL of the following are true:
- [ ] All stories meet their individual DoD
- [ ] All tests passing in CI on main branch
- [ ] All branches merged — nothing left in progress
- [ ] Project board fully up to date
- [ ] All defects logged as GitHub Issues
- [ ] README complete and up to date
- [ ] GitHub Actions workflow running successfully
- [ ] Test metrics recorded
- [ ] Sprint retrospective completed


## Exploratory Test Charters
Exploratory testing was conducted alongside automation to discover
edge cases not covered by scripted tests. 

---

