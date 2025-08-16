# Gym Simulation System

A comprehensive JavaFX application that simulates the operations of a gym and fitness center, implementing the workflows specified in the CSE213 CRA Report for Basic Members and Premium Members.

## Project Overview

This system implements a complete gym management simulation with two user types:
- **Basic Member**: Access to core gym features
- **Premium Member**: All basic features plus premium services

## Features Implemented

### Basic Member Features (User 1)
1. **Sign up/Login** - User authentication and registration
2. **Book Gym Session** - Schedule workout sessions
3. **View Workout Plan** - Access personalized fitness plans
4. **Track Progress** - Monitor workout history and progress
5. **Join Group Classes** - Enroll in fitness classes
6. **View Class Schedule** - Browse available classes
7. **Update Profile** - Manage personal information
8. **Submit Feedback** - Provide session feedback

### Premium Member Features (User 2)
1. **Personal Training** - Book 1-on-1 sessions with trainers
2. **Diet Plans** - Access personalized nutrition plans
3. **Premium Classes** - Join exclusive fitness classes
4. **Wellness Lounge** - Book spa and wellness services
5. **Progress Analytics** - Advanced fitness tracking
6. **Fitness Assessments** - Monthly progress evaluations
7. **Supplement Tracking** - Log supplement usage
8. **Goal Setting** - Set and track fitness goals with AI/Trainer

## Technical Architecture

### Model Classes
- `User` - Abstract base class for all users
- `BasicMember` - Basic membership implementation
- `PremiumMember` - Premium membership implementation
- `WorkoutSession` - Individual workout sessions
- `GroupClass` - Group fitness classes
- `WorkoutPlan` - Personalized workout plans
- `Exercise` - Individual exercises
- `WorkoutDay` - Daily workout schedules

### Service Layer
- `GymService` - Core business logic and data management

### Controllers
- `LoginController` - Handles authentication and registration
- `DashboardController` - Manages main dashboard functionality

### UI Components
- `login-view.fxml` - Login and registration interface
- `dashboard-view.fxml` - Main dashboard with tabbed interface
- `styles.css` - Modern, professional styling

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6 or higher
- JavaFX 21

### Installation
1. Clone the repository
2. Navigate to the project directory
3. Run the application:
   ```bash
   mvn clean javafx:run
   ```

### Test Accounts
The system comes with pre-configured test accounts:

**Basic Member:**
- Email: john@example.com
- Password: password123

**Premium Member:**
- Email: jane@example.com
- Password: password123

## System Workflows

### Basic Member Workflows
1. **Login/Registration**: Secure authentication system
2. **Session Booking**: Time slot selection and availability checking
3. **Class Management**: Browse, join, and leave group classes
4. **Progress Tracking**: View workout history and statistics
5. **Profile Management**: Update personal information and fitness data

### Premium Member Workflows
1. **Personal Training**: Book sessions with certified trainers
2. **Wellness Services**: Access to spa and relaxation facilities
3. **Advanced Analytics**: Comprehensive progress reporting
4. **Goal Management**: AI-assisted fitness goal setting
5. **Supplement Tracking**: Monitor supplement intake and timing

## User Interface

The application features a modern, intuitive interface with:
- **Tabbed Navigation**: Organized feature access
- **Responsive Design**: Adapts to different screen sizes
- **Professional Styling**: Modern color scheme and typography
- **Interactive Elements**: Hover effects and visual feedback

## Data Management

- **In-Memory Storage**: Data persistence during session
- **Sample Data**: Pre-loaded classes and user accounts
- **Real-time Updates**: Dynamic UI updates based on user actions

## Future Enhancements

- Database integration for persistent storage
- Real-time notifications and reminders
- Mobile application support
- Advanced analytics and reporting
- Integration with fitness tracking devices
- Payment processing system

## Contributing

This project implements the specific requirements outlined in the CSE213 CRA Report. For modifications or extensions, please ensure compliance with the original specifications.

## License

This project is created for educational purposes as part of the CSE213 course requirements.

## Contact

For questions or support regarding this implementation, please refer to the course documentation and requirements.
