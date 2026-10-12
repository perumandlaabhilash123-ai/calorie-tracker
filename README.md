# Calorie Tracker — Spring Boot Application

A full-stack web application built using Java and Spring Boot to help users track daily calorie intake, monitor nutrition, log meals, and manage weight progress.

## Features

- **Food Search:** Search for foods and view nutritional information using USDA FoodData Central.
- **Daily Food Diary:** Record meals under Breakfast, Lunch, Snack, and Dinner.
- **Calorie Tracking:** Monitor daily calories and nutritional totals.
- **Meal Management:** Add, edit, and delete food entries.
- **Copy Previous Meals:** Copy yesterday's meals into the current day.
- **Weight Tracking:** Record body weight and review weight history.
- **Weight Goals:** Track progress toward a target weight.
- **Responsive Interface:** Navigate between Home, My Diary, Add Food, and Weight pages.

## Technologies Used

| Layer | Technologies |
|---|---|
| Backend | Java, Spring Boot |
| Frontend | HTML, CSS, JavaScript |
| Database | MySQL |
| API | USDA FoodData Central |
| Build Tool | Maven |
| Version Control | Git and GitHub |
| Development Environment | Visual Studio Code |

## Application Pages

### Home Page
The main landing page introduces the application and provides a food search feature.

### My Diary
Users can review their daily calorie intake, nutrition information, and meals organized by date.

### Add Food
Users can search for foods, choose serving quantities, and save food entries to their diary.

### Weight Tracker
Users can record weight measurements and monitor their progress over time.

## Running the Application Locally

### Prerequisites

- Java and a compatible JDK
- MySQL
- Git

### Setup

1. Clone the repository:

   `git clone https://github.com/perumandlaabhilash123-ai/calorie-tracker.git`

2. Open the project in Visual Studio Code.

3. Configure the database connection and required API credentials in `src/main/resources/application.properties`.

4. Start the Spring Boot application on Windows:

   `.\mvnw.cmd spring-boot:run`

5. Open the application in your browser:

   `http://localhost:8081`

**Security:** Do not commit database passwords, API keys, or other sensitive configuration values to GitHub.

## Future Improvements

- User registration and login
- Personalized nutrition recommendations
- Improved analytics and reporting
- Cloud deployment

## Author

**Abhilash Perumandla**

GitHub: https://github.com/perumandlaabhilash123-ai

## Repository

https://github.com/perumandlaabhilash123-ai/calorie-tracker