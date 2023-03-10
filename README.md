# PlayMySongs

The system should have two modules:

The first is the music upload module. Through a form, the user will be able to submit a music file to the server together with information about it. 
The information should be: style (use a combobox), song name and singer (do not allow the use of special characters for this data, with the exception of 
underscore and white space, use javascript for validation). The concatenation of the information sent (artist_style_title) will give rise to the name of 
the music file received on the server. For example: when sending a song, the user informed the name: 'Love My Life', the style: 'international pop' and 
the singer: 'Robbie Williams', the file 'LoveMyLife_popinternacional_'RobbieWilliams.mp3' must be generated on the server.

The second module offers a search interface, where the user must enter a keyword (based on part of the name of the music file) and after submission, 
the system must show all occurrences found. The user can still 'play' one of the chosen songs. Use the <audio> tag from html5,
Create a home page with links to both modules.

The system should be built on the MVC model, with the frontend using HTML+JS+CSS and eventually a bootstrap-like framework and the backend based on services.
Each service will be developed in a servlet,

In this project there is no need to handle access and session!
