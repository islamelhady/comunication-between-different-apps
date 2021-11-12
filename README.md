# task-comunication-between-three-apps

3 apps which are named (Emitter, MiddleMan, Receiver) respectively which will do the following:

### The Emitter app will be requesting online data from the following API: https://jsonplaceholder.typicode.com/users <br>
- the returned data should be displayed in a recycler view, with the refreshing ability. <br>
- upon clicking on any item a confirmation dialog should pop-up for sending the data (to the MiddleMan App). <br>
- if the user confirms the sending then the data should be sent to the MiddleMan App using a broadcast receiver. <br>
- when the response is received from the MiddleMan app the received result should be displayed on a dialog on the same screen. <br>
- once it receives the response it should automatically pop-up from the back to the front screen. <br>

### The MiddleMan app will be listening for messages from Emitter app received from the broadcast receiver<br>
- once the data is received in the MiddleMan app, it should send it to the 3rd App using local server-client methodolgy.<br>
- the MiddleMan app should NOT do anything with the received data, other than transmitting it to the Receiver App directly.<br>
- once the MiddleMan app receives a response from the Receiver App it should forward it back to the Emitter App directly using broadcast receiver.<br>

### The Receiver App will be receiving the incoming data from MiddleMan App.<br>
- once the data is received the data should be saved in a database (any preferred DB of your choice).<br>
- a response is returned back with either (OK or NOK) to the MiddleMan App indicating the saving of data status using the same server-client methodology.<br>
- there should be a button in the receiver app that displays the current content of the stored data in the database.<br>
- when the Receiver App receives the message the app should automatically pop-up from the back to the front screen.<br>
