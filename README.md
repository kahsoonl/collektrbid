The app itself consists of a Overview Page (bid listing page) and a detail page (Bidding page) with a bottom sheet page (Collectable Detail) to show more info and image regarding the collectable as well as recent bid history.

Things to note:
1. The blank black screen on the detail page are meant as live video placeholders.
2. The timer currently starts countdown from 30 minutes everytime we exit and entering, but I think in real world usage there are different ways to fix this depending on the API implementation

Running the app:
1. Clone the repository
2. Run the project on emulator / physical device

The app is built with MVI architecture and MVI aligns with CLEAN architecture well as MVI also enforces a clear separation of concern as well as responsibilities into layers as follows:
View: Responsible for holding the presentation logic as well as user interactions with each view elements.
User Intents: Intents represents the potential interaction user can make with the app itself
ViewModel: Manages the state and minor business logic as well as processes the user intents and updating the view states accordingly.
Use Case: Use case holds the majority of the business as well as other logics that is required by each different feature and also serves as the intermediate with repository and data related operations before returning the resulted data to ViewModel for presentation on the view layer.
Repository: Serves as the single source of truth for data to their respective module in the application.

The app is divided into different modules:-
app: holds the base app as well as other initialization processes here
foundation: holds most of the foundationary codes as well as functions / components that is shared among different modules, as well as the app themes and various other base functions here
bid: holds the bidding module which consists of an overview page and a detail page

This modularity approach allows for better maintainability as well as scalability in terms of team size as these modules will be separated into a different repository if the dev team and the project itself is large and will enable for a smoother merging process across different team. But since this is a demo project it's here for demonstration purpose.
