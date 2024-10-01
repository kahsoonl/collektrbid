The app itself consists of a Overview Page (bid listing page) and a detail page (Bidding page) with a bottom sheet page (Collectable Detail) to show more info and image regarding the collectable as well as recent bid history.

The app is built with MVI architecture and MVI aligns with CLEAN architecture well as MVI also enforces a clear separation of concern as well as responsibilities into layers as follows:
View: Responsible for holding the presentation logic as well as user interactions with each view elements.
User Intents: Intents represents the potential interaction user can make with the app itself
ViewModel: Manages the state and minor business logic as well as processes the user intents and updating the view states accordingly.
Use Case: Use case holds the majority of the business as well as other logics that is required by each different feature and also serves as the intermediate with repository and data related operations before returning the resulted data to ViewModel for presentation on the view layer.
Repository: Serves as the single source of truth for data to their respective module in the application.

