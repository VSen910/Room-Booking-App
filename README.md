
# Room Booking App

This android app covers the basic premise of booking classrooms in advance, by any of the students or faculty of my college. With this app, the users submit a booking request for a particular classroom on a particular date and time slot, then the admin accepts or declines these requests which will be reflected back in the account of the concerned user.


## Login/Sign Up

The introductory screen consists of the login and sign-up options along with an option of logging in as an admin.
For creating a new user account, the following details of the user are required:

- Name
- Email
- Mobile number
- Password

To avoid anyone from creating fake accounts, the user can only provide an email with the domain iiitdwd.ac.in so that only IIIT Dharwad students and faculty and use this app to book rooms. Moreover, an OTP will be sent to this email to verify the existence of the provided email address.

Users also have a forgot password option, in which case if an email with an existing account is provided, an OTP will be sent to it and after entering the correct OTP, the user will be allowed to change their password.

In the case of admin login, no new account can be created to protect the existing data from being tampered with.  The login credentials are pre-made and can be changed only by us developers on request by the admin for security purposes. 


## User Home Screen

On this screen, users may choose to book a room or view their previous bookings. 

On pressing the Bookings button, the user will be redirected to a screen showing all the booking requests made by the user and whether they have been accepted, declined, or still awaiting a response from the admin.
## Time Slots

For a selected classroom and a selected date, the available time slots will be shown to the user from 9 AM to 5 PM. In case any booking request for a particular time slot has been accepted, the user can no longer submit a booking request for that time slot and the button for that time slot will become unclickable.

The thing to be noted is that there can be multiple requests made by different or the same users for the same time slots until and unless the admin accepts any of those requests. After this, no more requests can be made.
## Admin

The main screen for the admin shows all the pending requests that are awaiting a response. Pressing a request card shows up a dialog box with the purpose of the booking request and options to accept and decline the request. There is also a button at the bottom right corner which shows all the previous requests which have either been accepted or declined.

If a particular combination of classroom, date, and time slot has already been accepted by the admin, he/she can no longer accept more requests of the same combination. The powers to decide which request to give the priority to have been given to the admin and the decision has to be taken in accordance with all the supporting information.
